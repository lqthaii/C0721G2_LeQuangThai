package service.Impl.contract;

import model.Contract;
import repository.IContractRepository;
import repository.Impl.contract.ContractRepository;
import service.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    IContractRepository contractRepository = new ContractRepository();

    @Override
    public List<Contract> getAllContract() {
        return this.contractRepository.getAllContract();
    }

    @Override
    public Contract getContract(String id) {
        return this.contractRepository.getContract(id);
    }

    @Override
    public void addContract(Contract contract) {
        this.contractRepository.addContract(contract);
    }

    @Override
    public void deleteContract(int id) {
        this.contractRepository.deleteContract(id);
    }

    @Override
    public void updateContract(Contract contract) {
        this.contractRepository.updateContract(contract);
    }
}
