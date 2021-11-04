package repository.Impl.employee;

import model.*;
import repository.Impl.BaseRepository;
import repository.employee.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String GET_ALL_EMPLOYEE = "select nv.id, nv.ho_ten, vt.id, vt.ten_vi_tri,td.id, td.trinh_do,bp.id, " +
            " bp.ten_bo_phan,ngay_sinh, so_cmnd, luong,sdt,email,dia_chi " +
            " from nhan_vien nv " +
            " join vi_tri vt on nv.id_vi_tri = vt.id " +
            " join trinh_do td on td.id = nv.id_trinh_do " +
            " join bo_phan bp on bp.id = nv.id_bo_phan";
    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery(GET_ALL_EMPLOYEE);
            Employee employee =null;
            Level level =null;
            Part part =null;
            Position position =null;
            while(resultSet.next()){
                level = new Level(resultSet.getString("td.id"),resultSet.getString("trinh_do"));
                part = new Part(resultSet.getString("bp.id"),resultSet.getString("ten_bo_phan"));
                position = new Position(resultSet.getString("vt.id"),resultSet.getString("ten_vi_tri"));
                String id = resultSet.getString("nv.id");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String identity = resultSet.getString("so_cmnd");
                String numberPhone = resultSet.getString("sdt");
                double salary = Double.valueOf(resultSet.getString("luong"));
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                employee = new Employee(id,name,position,level,part,birthday,identity,salary,numberPhone,email,address);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public Employee getEmployee(String id) {
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {
        PreparedStatement preparedStatement =null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from nhan_vien where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
