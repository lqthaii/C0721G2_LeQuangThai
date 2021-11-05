package repository.Impl.contract;

import model.*;
import repository.IContractRepository;
import repository.Impl.BaseRepository;
import service.ICustomerService;
import service.IEmployeeService;
import service.IServiceService;
import service.Impl.customer.CustomerService;
import service.Impl.employee.EmployeeService;
import service.Impl.service.ServiceService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    ICustomerService customerService = new CustomerService();
    IEmployeeService employeeService = new EmployeeService();
    IServiceService serviceService = new ServiceService();
    @Override
    public List<Contract> getAllContract() {
        List<Contract> contracts = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet= statement.executeQuery("select * from hop_dong");
            Customer customer = null;
            Employee employee =null;
            Service service =null;
            Contract contract =null;
            while(resultSet.next()){
                customer = customerService.getCustomer(String.valueOf(resultSet.getInt("id_khach_hang")));
                employee = employeeService.getEmployee(String.valueOf(resultSet.getInt("id_nhan_vien")));
                service = serviceService.getService(String.valueOf(resultSet.getInt("id_dich_vu")));
                String id = String.valueOf(resultSet.getInt("id"));
                String dateCreateContract = String.valueOf(resultSet.getDate("ngay_lam_hop_dong"));
                String dateEnd = String.valueOf(resultSet.getDate("ngay_ket_thuc"));
                int deposits =resultSet.getInt("tien_dat_coc");
                int totalMoney = resultSet.getInt("tong_tien");
                contract = new Contract(id,employee,customer,service,dateCreateContract,dateEnd,deposits,totalMoney);
                contracts.add(contract);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }

    @Override
    public Contract getContract(String id) {
        return null;
    }

    @Override
    public void addContract(Contract contract) {

    }

    @Override
    public void deleteContract(int id) {
        PreparedStatement preparedStatement =null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from hop_dong where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateContract(Contract contract) {

    }
}
