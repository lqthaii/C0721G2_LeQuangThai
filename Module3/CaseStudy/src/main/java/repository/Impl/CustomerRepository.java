package repository.Impl;

import model.Customer;
import repository.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    final String GET_ALL_CUSTOMER = "select * from khach_hang";
    final String INSERT_CUSTOMER = "insert into khach_hang(id,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi) " +
            " values(?,?,?,?,?,?,?,?)";
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet= statement.executeQuery(GET_ALL_CUSTOMER);
            Customer customer =null;
            while(resultSet.next()){
                customer = new Customer();
                String id = resultSet.getString("id");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String identity = resultSet.getString("so_cmnd");
                String numberPhone = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                customer.setId(id);
                customer.setName(name);
                customer.setBirthday(birthday);
                customer.setIdentity(identity);
                customer.setNumberPhone(numberPhone);
                customer.setEmail(email);
                customer.setAddress(address);
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer getCustomer(String id) {
        return null;
    }

    @Override
    public void addCusomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement(INSERT_CUSTOMER);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
