package repository.Impl;

import model.User;
import repository.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public void insertUser(User user) throws SQLException {
        PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("insert into `user`(id,`name`,email,country) " +
                "values(?,?,?,?)");
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getCountry());
        preparedStatement.executeUpdate();
    }

    @Override
    public User selectUser(String id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select *" +
                    "from `user`" +
                    "where id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        Statement statement = null;
        List<User> users = new ArrayList<>();
        try {
            statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery("select id, `name`, email, country\n" +
                    "from `user`");
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }

    @Override
    public List<User> searchUserCountry(String country) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from user where country=?");
            preparedStatement.setString(1,country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> sortByName() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from `user`" +
                    "order by `name`");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
