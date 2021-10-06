package services;

import models.Booking;
import models.Contract;
import models.Customer;
import utils.ReadWriteContract;

import java.util.*;

public class ContractServiceImpl implements ContactService {
    static Scanner sc = new Scanner(System.in);
    Queue<Booking> bookingQueue = ReadWriteContract.readFileBooking();
    List<Contract> contractList = ReadWriteContract.readFileContract();

    @Override
    public void add() {
        Contract contract = inputContract();
        contractList.add(contract);
        ReadWriteContract.writeFileContract(ReadWriteContract.PATH_CONTRACT, contractList);
    }

    @Override
    public void edit() {
        display();
        boolean flag = false;
        System.out.println("Please input ID Contract you want to edit:");
        String id = sc.nextLine();
        if (checkIsExist(id) != -1) {
            Contract contract = inputContract();
            contractList.set(checkIsExist(id), contract);
        } else {
            System.err.println("Contract ID does not exist");
        }
        ReadWriteContract.writeFileContract(ReadWriteContract.PATH_CONTRACT, contractList);
    }

    @Override
    public void display() {
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    public int checkIsExist(String id) {
        int i = 0;
        for (Contract contract : contractList) {
            i++;
            if (id.equals(contract.getIdContract())) {
                return i;
            }
        }
        return -1;
    }

    public Contract inputContract() {
        String idContract;
        do {
            System.out.println("Please input ID Contract");
            idContract = sc.nextLine();
            if (checkIsExist(idContract) != -1) {
                System.err.println("ID Contract already not exist!!");
            }
        } while (checkIsExist(idContract) != -1);
        Booking booking = bookingQueue.poll();
        ReadWriteContract.updateFileBooking(ReadWriteContract.PATH_BOOKING, bookingQueue);
        Customer customer = booking.getCustomer();
        System.out.println("Please input Advance Deposit  Amount");
        double adcAmout = Double.parseDouble(sc.nextLine());
        System.out.println("Please input Total Amount");
        double totalAmount = Double.parseDouble(sc.nextLine());
        return new Contract(idContract, booking, customer, adcAmout, totalAmount);
    }

}
