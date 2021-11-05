package repository.Impl.customer;

import model.TypeCustomer;
import repository.ICustomerTypeRepository;
import repository.Impl.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<TypeCustomer> getAllCustomerType() {
        List<TypeCustomer> customerType = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("select * from loai_khach");
            TypeCustomer typeCustomer =null;
            while(resultSet.next()){
                typeCustomer = new TypeCustomer();
                typeCustomer.setId(resultSet.getString("id"));
                typeCustomer.setName(resultSet.getString("ten"));
                customerType.add(typeCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return customerType;
    }

    @Override
    public TypeCustomer getTypeCustomer(String id) {
        TypeCustomer typeCustomer = new TypeCustomer();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from loai_khach where id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                typeCustomer = new TypeCustomer();
                typeCustomer.setId(String.valueOf(resultSet.getInt("id")));
                typeCustomer.setName(resultSet.getString("ten"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return typeCustomer;
    }
}
