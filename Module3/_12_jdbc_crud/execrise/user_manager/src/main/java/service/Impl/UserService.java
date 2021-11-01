package service.Impl;

import model.User;
import repository.IUserRepository;
import repository.Impl.UserRepository;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    IUserRepository userRepository = new UserRepository();
    @Override
    public void insertUser(User user) throws SQLException {
        this.userRepository.insertUser(user);
    }

    @Override
    public User selectUser(String id) {
       return this.userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(String id) throws SQLException {
        return this.userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.userRepository.updateUser(user);
    }

    @Override
    public List<User> searchUserCountry(String country) {
        return this.userRepository.searchUserCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return this.userRepository.sortByName();
    }
}
