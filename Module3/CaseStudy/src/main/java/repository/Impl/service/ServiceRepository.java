package repository.Impl.service;

import model.*;
import repository.IServiceRepository;
import repository.Impl.BaseRepository;
import service.Impl.service.TypeRentService;
import service.Impl.service.TypeServiceService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    TypeRentService typeRentService = new TypeRentService();
    TypeServiceService typeServiceService = new TypeServiceService();
    @Override
    public void addService(Service service) {
        PreparedStatement preparedStatement=null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into dich_vu (id,dien_tich,so_tang,so_nguoi_toi_da, " +
                    " chi_phi_thue,id_kieu_thue,id_loai_dich_vu,trang_thai) " +
                    " value (?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(service.getId()));
            preparedStatement.setFloat(2, Float.valueOf(service.getArea()));
            preparedStatement.setInt(3,Integer.parseInt(service.getNumberFloors()));
            preparedStatement.setInt(4,Integer.parseInt(service.getMaximumPeople()));
            preparedStatement.setInt(5,Integer.parseInt(service.getPriceRent()));
            preparedStatement.setInt(6,Integer.parseInt(service.getTypeRent().getId()));
            preparedStatement.setInt(7,Integer.parseInt(service.getTypeService().getId()));
            preparedStatement.setString(8,service.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Service getService(String id) {
        Service service =null;
        TypeService typeService =null;
        TypeRent typeRent =null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from dich_vu where id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                typeService = this.typeServiceService.getTypeService(String.valueOf(resultSet.getInt("id_loai_dich_vu")));
                typeRent = this.typeRentService.getTypeRent(String.valueOf(resultSet.getInt("id_kieu_thue")));
                String status = resultSet.getString("trang_thai");
                String area = String.valueOf(resultSet.getFloat("dien_tich"));
                String numberFloors = String.valueOf(resultSet.getInt("so_tang"));
                String maximumPeople = String.valueOf(resultSet.getInt("so_nguoi_toi_da"));
                String priceRent = String.valueOf(resultSet.getInt("chi_phi_thue"));
                service = new Service(id,area,numberFloors,maximumPeople,priceRent,typeRent,typeService,status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public List<Service> getAllService() {
        List<Service> services = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("select * from dich_vu");
            Service service =null;
            TypeService typeService =null;
            TypeRent typeRent =null;
            while(resultSet.next()){
                typeService = this.typeServiceService.getTypeService(String.valueOf(resultSet.getInt("id_loai_dich_vu")));
                typeRent = this.typeRentService.getTypeRent(String.valueOf(resultSet.getInt("id_kieu_thue")));
                String status = resultSet.getString("trang_thai");
                String id = String.valueOf(resultSet.getInt("id"));
                String area = String.valueOf(resultSet.getFloat("dien_tich"));
                String numberFloors = String.valueOf(resultSet.getInt("so_tang"));
                String maximumPeople = String.valueOf(resultSet.getInt("so_nguoi_toi_da"));
                String priceRent = String.valueOf(resultSet.getInt("chi_phi_thue"));
                service = new Service(id,area,numberFloors,maximumPeople,priceRent,typeRent,typeService,status);
                services.add(service);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
}
