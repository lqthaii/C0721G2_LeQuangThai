package models;

public class House extends Facility {
    private String roomStandard;
    private int numberFloor;

    public House() {
    }

    public House(String roomStandard, int numberFloor) {
        this.roomStandard = roomStandard;
        this.numberFloor = numberFloor;
    }

    public House(String name, double areaUsed, double cost, int numberMaxPeople, String rentalType, String roomStandard, int numberFloor) {
        super(name, areaUsed, cost, numberMaxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloor = numberFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
    public String writeFile(){
        return this.name+","+this.areaUsed+","+this.cost+","+this.numberMaxPeople+","+this.rentalType+","+this.roomStandard+","+this.numberFloor;
    }
    public String toString(){
        return "Name: "+this.name+", Area Used:"+this.areaUsed+", Cost:"+this.cost+", Max People:"+this.numberMaxPeople+", Rental Type:"+this.rentalType+", Room Standard:"+this.roomStandard+", Number Floor:"+this.numberFloor;
    }
}
