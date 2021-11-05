package repository;

import model.Contract;
import model.Customer;

import java.util.List;

public interface IContractRepository {
    public List<Contract> getAllContract();
    public Contract getContract(String id);
    public void addContract(Contract contract);
    public void deleteContract(int id);
    public void updateContract(Contract contract);
}
