package models;

public abstract class Facility {
    String name;
    double areaUsed;
    double cost;
    int numberMaxPeople;
    String rentalType;
    String id;
    public Facility() {
    }

    public Facility(String id,String name, double areaUsed, double cost, int numberMaxPeople, String rentalType) {
        this.name = name;
        this.id = id;
        this.areaUsed = areaUsed;
        this.cost = cost;
        this.numberMaxPeople = numberMaxPeople;
        this.rentalType = rentalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumberMaxPeople() {
        return numberMaxPeople;
    }

    public void setNumberMaxPeople(int numberMaxPeople) {
        this.numberMaxPeople = numberMaxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }
}

