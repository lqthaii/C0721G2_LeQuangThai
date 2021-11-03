package model;

public class Service {
    String id;
    String area;
    String numberFloors;
    String maximumPeople;
    String priceRent;
    String typeRent;
    String idLoaiDichVu;
    String trangThai;

    public Service() {
    }

    public Service(String id, String dienTich, String soTang, String soNguoiToiDa, String chiPhiThue, String idKieuThue, String idLoaiDichVu, String trangThai) {
        this.id = id;
        this.area = dienTich;
        this.numberFloors = soTang;
        this.maximumPeople = soNguoiToiDa;
        this.priceRent = chiPhiThue;
        this.typeRent = idKieuThue;
        this.idLoaiDichVu = idLoaiDichVu;
        this.trangThai = trangThai;
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

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public String getIdLoaiDichVu() {
        return idLoaiDichVu;
    }

    public void setIdLoaiDichVu(String idLoaiDichVu) {
        this.idLoaiDichVu = idLoaiDichVu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
