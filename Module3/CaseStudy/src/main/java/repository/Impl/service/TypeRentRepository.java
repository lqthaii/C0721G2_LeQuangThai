package repository.Impl.service;

import model.TypeRent;
import model.TypeService;
import repository.ITypeRentRepository;
import repository.Impl.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeRentRepository implements ITypeRentRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<TypeRent> getAllTypeRent() {
        List<TypeRent> typeRents = new ArrayList<>();
        try {
            Statement statement =  baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("select * from kieu_thue");
            TypeRent typeRent =null;
            while(resultSet.next()){
                typeRent = new TypeRent();
                typeRent.setId(String.valueOf(resultSet.getInt("id")));
                typeRent.setName(resultSet.getString("ten"));
                typeRent.setPrice(String.valueOf(resultSet.getInt("gia")));
                typeRents.add(typeRent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return typeRents;
    }

    @Override
    public TypeRent getTypeRent(String id) {
        TypeRent typeRent =null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from kieu_thue where id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                typeRent = new TypeRent();
                typeRent.setId(String.valueOf(resultSet.getInt("id")));
                typeRent.setName(resultSet.getString("ten"));
                typeRent.setPrice(String.valueOf(resultSet.getInt("gia")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return typeRent;
    }
}
