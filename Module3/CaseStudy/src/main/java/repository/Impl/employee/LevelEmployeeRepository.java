package repository.Impl.employee;

import model.Level;
import model.Part;
import model.TypeCustomer;
import repository.ILevelEmployeeRepository;
import repository.Impl.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LevelEmployeeRepository implements ILevelEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Level> getAllLevel() {
        List<Level> levels = new ArrayList<>();
        try {
            Statement statement =  baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("select * from trinh_do");
            Level level =null;
            while(resultSet.next()){
                level = new Level();
                level.setId(String.valueOf(resultSet.getInt("id")));
                level.setLevel(resultSet.getString("trinh_do"));
                levels.add(level);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return levels;
    }

    @Override
    public Level getLevelEmployee(int id) {
        Level level = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from trinh_do where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                level = new Level();
                level.setId(String.valueOf(resultSet.getInt("id")));
                level.setLevel(resultSet.getString("trinh_do"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return level;
    }
}
