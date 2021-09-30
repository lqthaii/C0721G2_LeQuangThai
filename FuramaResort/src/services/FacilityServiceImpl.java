package services;

import models.*;

import java.util.*;

public class FacilityServiceImpl extends Facility implements FacilityService   {
    static  protected  Map<Facility,Integer> facilityMap = new LinkedHashMap<>();
    static {
        Facility facility = new Villa("Villa",2000,2000000,4,"Day","Vip",20,2);
        Facility facility1 = new House("House", 20.00, 10000000.00, 2,"Nomarl","Normal",20);
        Facility facility2 = new Room("Room", 20.00, 10000000.00, 2, "Day", "Pool");
        facilityMap.put(facility,1);
        facilityMap.put(facility1,1);
        facilityMap.put(facility2,1);
    }
    static Scanner sc = new Scanner(System.in);

    public static Villa inputVilla() {
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Area Used:");
        double areaUsed = Double.parseDouble(sc.nextLine());
        System.out.println("Cost:");
        double cost = Double.parseDouble(sc.nextLine());
        System.out.println("Number Max People:");
        int maxPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Rental Type:");
        String rentalType = sc.nextLine();
        System.out.println("Room Standard:");
        String roomStandard = sc.nextLine();
        System.out.println("Area Pool:");
        double areaPool = Double.parseDouble(sc.nextLine());
        System.out.println("Number Floor:");
        int numberFloor = Integer.parseInt(sc.nextLine());
        return new Villa(name, areaUsed, cost, maxPeople, rentalType, roomStandard, areaPool, numberFloor);
    }

    public static House inputHourse() {
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Area Used:");
        double areaUsed = Double.parseDouble(sc.nextLine());
        System.out.println("Cost:");
        double cost = Double.parseDouble(sc.nextLine());
        System.out.println("Number Max People:");
        int maxPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Rental Type:");
        String rentalType = sc.nextLine();
        System.out.println("Room Standard:");
        String roomStandard = sc.nextLine();
        System.out.println("Number Floor:");
        int numberFloor = Integer.parseInt(sc.nextLine());
        return new House(name, areaUsed, cost, maxPeople, rentalType, roomStandard, numberFloor);
    }

    public static Room inputRoom() {
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Area Used:");
        double areaUsed = Double.parseDouble(sc.nextLine());
        System.out.println("Cost:");
        double cost = Double.parseDouble(sc.nextLine());
        System.out.println("Number Max People:");
        int maxPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Rental Type:");
        String rentalType = sc.nextLine();
        System.out.println("Service Free:");
        String serviceFree = sc.nextLine();
        return new Room(name, areaUsed, cost, maxPeople, rentalType, serviceFree);
    }
    public static void increaseUsed(Facility facility){
        for (Facility key : facilityMap.keySet()) {
            if(key instanceof Villa){
                facilityMap.put(key,((Integer)(facilityMap.get(key))+1));
            } else if(key instanceof House){
                facilityMap.put(key,((Integer)(facilityMap.get(key))+1));
            }else if(key instanceof Room){
                facilityMap.put(key,((Integer)(facilityMap.get(key))+1));
            }
        }
    }
    @Override
    public void add() {
        int choose;
        do {
            System.out.println("Please input type Facility:");
            System.out.println("1. Villa");
            System.out.println("2. House");
            System.out.println("3. Room");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    facilityMap.put(inputVilla(),1);
                    break;
                case 2:
                    facilityMap.put(inputHourse(),1);
                    break;
                case 3:
                    facilityMap.put(inputRoom(),1);
                    break;
                default:
                    System.out.println("Bạn đã nhập sai vui lòng nhập lại");
            }
        } while (choose < 1 || choose > 3);
    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        int i=1;
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            System.out.println(i+" "+key + " " + facilityMap.get(key));
            i++;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public Facility returnFacility(int index){
        Facility facility1 = null;
        int i=1;
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            if(index == (i-1)){
                facility1 = key;
            }
            i++;
        }
        return facility1;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
