package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;

    public User selectUser(String id);

    public List<User> selectAllUsers();

    public boolean deleteUser(String id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public List<User> searchUserCountry(String country);

    public List<User> sortByName();
}
