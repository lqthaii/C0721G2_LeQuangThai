package repository.Impl.service;

import model.Part;
import model.TypeService;
import repository.ITypeServiceRepository;
import repository.Impl.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeServiceRepository implements ITypeServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<TypeService> getAllTypeService() {
        List<TypeService> typeServices = new ArrayList<>();
        try {
            Statement statement =  baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("select * from loai_dich_vu");
            TypeService typeService =null;
            while(resultSet.next()){
                typeService = new TypeService();
                typeService.setId(String.valueOf(resultSet.getInt("id")));
                typeService.setName(resultSet.getString("ten"));
                typeServices.add(typeService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return typeServices;
    }

    @Override
    public TypeService getTypeService(String id) {
        TypeService typeService = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from loai_dich_vu where id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                typeService = new TypeService();
                typeService.setId(String.valueOf(resultSet.getInt("id")));
                typeService.setName(resultSet.getString("ten"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return typeService;
    }
}

