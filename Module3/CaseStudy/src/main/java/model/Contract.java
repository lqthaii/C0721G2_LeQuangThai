package model;

public class Contract {
    String id;
    Employee employee;
    Customer customer;
    Service service;
    String dateCreateContract;
    String dateEnd;
    int deposits;
    int totalMoney;

    public Contract() {
    }

    public Contract(String id, Employee employee, Customer customer, Service service, String dateCreateContract, String dateEnd, int deposits, int totalMoney) {
        this.id = id;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.dateCreateContract = dateCreateContract;
        this.dateEnd = dateEnd;
        this.deposits = deposits;
        this.totalMoney = totalMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getDateCreateContract() {
        return dateCreateContract;
    }

    public void setDateCreateContract(String dateCreateContract) {
        this.dateCreateContract = dateCreateContract;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getDeposits() {
        return deposits;
    }

    public void setDeposits(int deposits) {
        this.deposits = deposits;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
