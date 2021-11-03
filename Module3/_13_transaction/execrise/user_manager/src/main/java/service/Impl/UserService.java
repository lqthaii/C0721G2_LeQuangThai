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
    public void updateUser(User user) {
        this.userRepository.updateUser(user);
    }

    @Override
    public List<User> searchUserCountry(String country) {
        return this.userRepository.searchUserCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return this.userRepository.sortByName();
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.getAllUser();
    }
    public void deleteUser(String id){
        this.userRepository.deleteUser(id);
    }
}
