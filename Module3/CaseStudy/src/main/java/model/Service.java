package model;

public class Service {
    String id;
    String area;
    String numberFloors;
    String maximumPeople;
    String priceRent;
    TypeRent typeRent;
    TypeService typeService;
    String status;

    public Service() {
    }

    public Service(String id, String dienTich, String soTang, String soNguoiToiDa, String priceRent, TypeRent typeRent, TypeService typeService, String status) {
        this.id = id;
        this.area = dienTich;
        this.numberFloors = soTang;
        this.maximumPeople = soNguoiToiDa;
        this.priceRent = priceRent;
        this.typeRent = typeRent;
        this.typeService = typeService;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(String maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(String priceRent) {
        this.priceRent = priceRent;
    }

    public TypeRent getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(TypeRent typeRent) {
        this.typeRent = typeRent;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
