package repository.Impl.customer;

import model.Customer;
import model.TypeCustomer;
import repository.ICustomerRepository;
import repository.Impl.BaseRepository;
import service.Impl.customer.CustomerTypeService;
import service.ICustomerTypeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    final String GET_ALL_CUSTOMER = "select kh.id,ho_ten,lk.ten,kh.id_loai_khach,ngay_sinh,so_cmnd,sdt,email,dia_chi from khach_hang kh" +
            " join loai_khach lk on lk.id = kh.id_loai_khach";
    final String INSERT_CUSTOMER = "insert into khach_hang(id,id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi) " +
            " values(?,?,?,?,?,?,?,?)";
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery(GET_ALL_CUSTOMER);
            Customer customer =null;
            TypeCustomer typeCustomer =null;
            while(resultSet.next()){
                customer = new Customer();
                typeCustomer = new TypeCustomer();
                typeCustomer.setId(resultSet.getString("kh.id_loai_khach"));
                typeCustomer.setName(resultSet.getString("lk.ten"));
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
                customer.setTypeCustomer(typeCustomer);
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer getCustomer(String id) {
        ICustomerTypeService customerTypeService = new CustomerTypeService();
        Customer customer = new Customer();
        TypeCustomer typeCustomer= null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from khach_hang where id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                typeCustomer = customerTypeService.getTypeCustomer(String.valueOf(resultSet.getInt("id_loai_khach")));
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
                customer.setTypeCustomer(typeCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return customer;
    }

    @Override
    public void addCusomer(Customer customer) {
        PreparedStatement preparedStatement=null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setInt(1,Integer.parseInt(customer.getId()));
            preparedStatement.setInt(2, Integer.parseInt(customer.getTypeCustomer().getId()));
            preparedStatement.setString(3,customer.getName());
            preparedStatement.setString(4,customer.getBirthday());
            preparedStatement.setString(5,customer.getIdentity());
            preparedStatement.setString(6,customer.getNumberPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        PreparedStatement preparedStatement =null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from khach_hang where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        PreparedStatement preparedStatement =null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update khach_hang set id_loai_khach =?, ho_ten =?,ngay_sinh =?, " +
                    " so_cmnd=?, sdt =?, email =?,dia_chi=?" +
                    " where id=?");
            preparedStatement.setInt(1,Integer.parseInt(customer.getTypeCustomer().getId()));
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthday());
            preparedStatement.setString(4,customer.getIdentity());
            preparedStatement.setString(5,customer.getNumberPhone());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getAddress());
            preparedStatement.setInt(8,Integer.parseInt(customer.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
