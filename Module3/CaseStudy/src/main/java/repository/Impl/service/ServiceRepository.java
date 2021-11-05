package repository.Impl.service;

import model.Service;
import repository.IServiceRepository;
import repository.Impl.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceRepository implements IServiceRepository {
    @Override
    public void addService(Service service) {
        BaseRepository baseRepository = new BaseRepository();
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
}
