package service;

import model.Contract;

import java.util.List;

public interface IContractService {
    public List<Contract> getAllContract();
    public Contract getContract(String id);
    public void addContract(Contract contract);
    public void deleteContract(int id);
    public void updateContract(Contract contract);
}
