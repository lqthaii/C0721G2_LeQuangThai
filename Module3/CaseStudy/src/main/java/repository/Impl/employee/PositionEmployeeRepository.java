package repository.Impl.employee;

import model.Position;
import model.TypeCustomer;
import repository.Impl.BaseRepository;
import repository.employee.IPositionEmployeeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionEmployeeRepository implements IPositionEmployeeRepository {
    @Override
    public List<Position> getAllPosition() {
        List<Position> positions = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
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
}
