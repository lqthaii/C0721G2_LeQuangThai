package models;

public class Villa extends Facility {
    private String roomStandard;
    private double arePool;
    private int numberFloor;

    public Villa() {
    }

    public Villa(String roomStandard, double arePool, int numberFloor) {
        this.roomStandard = roomStandard;
        this.arePool = arePool;
        this.numberFloor = numberFloor;
    }

    public Villa(String name, double areaUsed, double cost, int numberMaxPeople, String rentalType, String roomStandard, double arePool, int numberFloor) {
        super(name, areaUsed, cost, numberMaxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.arePool = arePool;
        this.numberFloor = numberFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getArePool() {
        return arePool;
    }

    public void setArePool(double arePool) {
        this.arePool = arePool;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
    public String writeFile(){
        return this.name+","+this.areaUsed+","+this.cost+","+this.numberMaxPeople+","+this.rentalType+","+this.roomStandard+","+this.arePool+","+this.numberFloor;
    }
    public String toString(){
        return "Name: "+this.name+", Area Used: "+this.areaUsed+", Cost: "+this.cost+", Number Max People: "+this.numberMaxPeople+", Rental Type: "+this.rentalType+", Room Standand: "+this.roomStandard+", Area Pool"+this.arePool+", Number Floor:"+this.numberFloor;
    }
}
