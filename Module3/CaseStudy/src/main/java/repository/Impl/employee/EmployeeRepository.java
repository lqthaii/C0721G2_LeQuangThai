package repository.Impl.employee;

import model.*;
import repository.ILevelEmployeeRepository;
import repository.IPartEmployeeRepository;
import repository.IPositionEmployeeRepository;
import repository.Impl.BaseRepository;
import repository.IEmployeeRepository;
import service.ILevelEmployeeService;
import service.IPartEmployeeService;
import service.IPositionEmployeeService;
import service.Impl.employee.LevelEmployeeService;
import service.Impl.employee.PartEmployeeService;
import service.Impl.employee.PositionEmployeeService;

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
        IPartEmployeeRepository partEmployeeRepository = new PartEmployeeRepository();
        ILevelEmployeeRepository levelEmployeeRepository = new LevelEmployeeRepository();
        IPositionEmployeeRepository positionEmployeeRepository = new PositionEmployeeRepository();
        Employee employee = new Employee();
        Part part = null;
        Level level =null;
        Position position =null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from nhan_vien where id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                part = partEmployeeRepository.getPartEmployee(resultSet.getInt("id_bo_phan"));
                level = levelEmployeeRepository.getLevelEmployee(resultSet.getInt("id_trinh_do"));
                position = positionEmployeeRepository.getPositionEmployee(resultSet.getInt("id_vi_tri"));
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                String identity = resultSet.getString("so_cmnd");
                double salary = Double.valueOf(resultSet.getFloat("luong"));
                String numberPhone = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                employee.setId(id);
                employee.setName(name);
                employee.setBirthday(birthday);
                employee.setIdentity(identity);
                employee.setNumberPhone(numberPhone);
                employee.setEmail(email);
                employee.setAddress(address);
                employee.setPart(part);
                employee.setLevel(level);
                employee.setPosition(position);
                employee.setSalary(salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        PreparedStatement preparedStatement=null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into nhan_vien (id,ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmnd,luong,sdt,email,dia_chi) " +
                    " value (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(employee.getId()));
            preparedStatement.setString(2,employee.getName());
            preparedStatement.setInt(3,Integer.parseInt(employee.getPosition().getId()));
            preparedStatement.setInt(4,Integer.parseInt(employee.getLevel().getId()));
            preparedStatement.setInt(5,Integer.parseInt(employee.getPart().getId()));
            preparedStatement.setString(6,employee.getBirthday());
            preparedStatement.setString(7,employee.getIdentity());
            preparedStatement.setInt(8,((int)employee.getSalary()));
            preparedStatement.setString(9,employee.getNumberPhone());
            preparedStatement.setString(10,employee.getEmail());
            preparedStatement.setString(11,employee.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public void updateEmployee(Employee employee) {
        PreparedStatement preparedStatement =null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update nhan_vien set ho_ten =?,id_vi_tri=?,id_trinh_do =?,ngay_sinh =?, " +
                    " so_cmnd=?, sdt =?, email =?,dia_chi=?, id_bo_phan=?,luong =?" +
                    " where id=?");
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setInt(2,Integer.parseInt(employee.getPosition().getId()));
            preparedStatement.setInt(3,Integer.parseInt(employee.getLevel().getId()));
            preparedStatement.setString(4,employee.getBirthday());
            preparedStatement.setString(5,employee.getIdentity());
            preparedStatement.setString(6,employee.getNumberPhone());
            preparedStatement.setString(7,employee.getEmail());
            preparedStatement.setString(8,employee.getAddress());
            preparedStatement.setInt(9,Integer.parseInt(employee.getPart().getId()));
            preparedStatement.setFloat(10,(float) employee.getSalary());
            preparedStatement.setInt(11,Integer.parseInt(employee.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Employee> searchEmployee(String name) {
        ILevelEmployeeService levelEmployeeService = new LevelEmployeeService();
        IPartEmployeeService partEmployeeService = new PartEmployeeService();
        IPositionEmployeeService positionEmployeeService = new PositionEmployeeService();
        List<Employee> employees = new ArrayList<>();
        PreparedStatement preparedStatement =null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("select * from nhan_vien where ho_ten like ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee =null;
            Level level =null;
            Part part =null;
            Position position =null;
                while(resultSet.next()){
                    level = levelEmployeeService.getLevelEmployee(Integer.parseInt(resultSet.getString("id_trinh_do")));
                    part = partEmployeeService.getPartEmployee(Integer.parseInt(resultSet.getString("id_bo_phan")));
                    position = positionEmployeeService.getPositionEmployee(Integer.parseInt(resultSet.getString("id_vi_tri")));
                    String id = resultSet.getString("id");
                    String name1 = resultSet.getString("ho_ten");
                    String birthday = resultSet.getString("ngay_sinh");
                    String identity = resultSet.getString("so_cmnd");
                    String numberPhone = resultSet.getString("sdt");
                    double salary = Double.valueOf(resultSet.getString("luong"));
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("dia_chi");
                    employee = new Employee(id,name1,position,level,part,birthday,identity,salary,numberPhone,email,address);
                    employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
