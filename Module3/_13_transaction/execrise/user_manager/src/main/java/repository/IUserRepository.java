package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;

    public User selectUser(String id);

    public List<User> selectAllUsers();

    public void updateUser(User user);

    public List<User> searchUserCountry(String country);

    public List<User> sortByName();

    public List<User> getAllUser();
    public void deleteUser(String id);
}
