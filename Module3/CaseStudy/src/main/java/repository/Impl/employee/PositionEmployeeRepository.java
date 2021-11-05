package repository.Impl.employee;

import model.Part;
import model.Position;
import repository.Impl.BaseRepository;
import repository.IPositionEmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionEmployeeRepository implements IPositionEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Position> getAllPosition() {
        List<Position> positions = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("select * from vi_tri");
            Position position =null;
            while(resultSet.next()){
                position = new Position();
                position.setId(resultSet.getString("id"));
                position.setNamePosition(resultSet.getString("ten_vi_tri"));
                positions.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return positions;
    }

    @Override
    public Position getPositionEmployee(int id) {
        Position position = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from vi_tri where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                position = new Position();
                position.setId(String.valueOf(resultSet.getInt("id")));
                position.setNamePosition(resultSet.getString("ten_vi_tri"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return position;
    }
}
