package repository.Impl.contract;

import model.*;
import repository.IContractRepository;
import repository.IEmployeeRepository;
import repository.Impl.BaseRepository;
import service.*;
import service.Impl.contract.ContractService;
import service.Impl.customer.CustomerService;
import service.Impl.customer.CustomerTypeService;
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
        IEmployeeService employeeService = new EmployeeService();
        ICustomerService customerService = new CustomerService();
        IServiceService serviceService = new ServiceService();
        Contract contract = null;
        Employee employee = null;
        Customer customer = null;
        Service service = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from hop_dong where id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                employee = this.employeeService.getEmployee(String.valueOf(resultSet.getInt("id_nhan_vien")));
                customer = this.customerService.getCustomer(String.valueOf(resultSet.getInt("id_khach_hang")));
                service = this.serviceService.getService(String.valueOf(resultSet.getInt("id_dich_vu")));
                String dateCreateContract = String.valueOf(resultSet.getDate("ngay_lam_hop_dong"));
                String dateEnd = String.valueOf(resultSet.getDate("ngay_ket_thuc"));
                int deposit = resultSet.getInt("tien_dat_coc");
                int totalMoney = resultSet.getInt("tong_tien");
                contract = new Contract(id,employee,customer,service,dateCreateContract,dateEnd,deposit,totalMoney);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseRepository.close();
        }
        return contract;
    }

    @Override
    public void addContract(Contract contract) {
        PreparedStatement preparedStatement=null;
        Connection connection = baseRepository.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into hop_dong " +
                    " values (?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(contract.getId()));
            preparedStatement.setInt(2,Integer.parseInt(contract.getEmployee().getId()));
            preparedStatement.setInt(3,Integer.parseInt(contract.getCustomer().getId()));
            preparedStatement.setInt(4,Integer.parseInt(contract.getService().getId()));
            preparedStatement.setDate(5,Date.valueOf(contract.getDateCreateContract()));
            preparedStatement.setDate(6,Date.valueOf(contract.getDateEnd()));
            preparedStatement.setInt(7,contract.getDeposits());
            preparedStatement.setInt(8,contract.getTotalMoney());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
