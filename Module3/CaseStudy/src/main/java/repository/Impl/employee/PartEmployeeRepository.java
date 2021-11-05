package repository.Impl.employee;

import model.Level;
import model.Part;
import model.Position;
import repository.IPartEmployeeRepository;
import repository.Impl.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PartEmployeeRepository implements IPartEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Part> getAllPart() {
        List<Part> parts = new ArrayList<>();
        try {
            Statement statement =  baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("select * from bo_phan");
            Part part =null;
            while(resultSet.next()){
                part = new Part();
                part.setId(String.valueOf(resultSet.getInt("id")));
                part.setPart_name(resultSet.getString("ten_bo_phan"));
                parts.add(part);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return parts;
    }

    @Override
    public Part getPartEmployee(int id) {
        Part part = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from bo_phan where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                part = new Part();
                part.setId(String.valueOf(resultSet.getInt("id")));
                part.setPart_name(resultSet.getString("ten_bo_phan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return part;
    }
}
