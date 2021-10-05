package services;

import models.*;

import java.io.*;
import java.util.*;

public class FacilityServiceImpl extends Facility implements FacilityService   {
    static  protected  Map<Facility,Integer> facilityMap = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);
    static final String PATCH_VILLA ="src\\data\\villa.csv";
    static final String PATCH_HOUSE ="src\\data\\house.csv";
    static final String PATCH_ROOM ="src\\data\\room.csv";
    static {
        try {
            File fileVilla = new File(PATCH_VILLA);
            File fileHouse = new File(PATCH_HOUSE);
            File fileRoom = new File(PATCH_ROOM);
            if (!fileVilla.exists()||!fileHouse.exists()||!fileRoom.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader brVilla = new BufferedReader(new FileReader(fileVilla));
            BufferedReader brHouse = new BufferedReader(new FileReader(fileHouse));
            BufferedReader brRoom = new BufferedReader(new FileReader(fileRoom));
            String line = "";
            String[] arr;
            while ((line = brVilla.readLine()) != null) {
                arr =line.split(",");
                facilityMap.put(new Villa(arr[1],Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),Integer.parseInt(arr[4]),arr[5],arr[6],Double.parseDouble(arr[7]),Integer.parseInt(arr[8])),Integer.parseInt(arr[0]));
            }
            while ((line = brHouse.readLine()) != null) {
                arr =line.split(",");
                facilityMap.put(new House(arr[1],Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),Integer.parseInt(arr[4]),arr[5],arr[6],Integer.parseInt(arr[7])),Integer.parseInt(arr[0]));
            }
            while ((line = brRoom.readLine()) != null) {
                arr =line.split(",");
                facilityMap.put(new Room(arr[1],Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),Integer.parseInt(arr[4]),arr[5],arr[6]),Integer.parseInt(arr[0]));
            }
            brVilla.close();
            brHouse.close();
            brRoom.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
    public void writeFile(String patch1,String patch2, String patch3){
        try {
            FileWriter writer1 = new FileWriter(patch1, false);
            FileWriter writer2 = new FileWriter(patch2, false);
            FileWriter writer3 = new FileWriter(patch3, false);
            BufferedWriter bufferedWriter1 = new BufferedWriter(writer1);
            BufferedWriter bufferedWriter2 = new BufferedWriter(writer2);
            BufferedWriter bufferedWriter3 = new BufferedWriter(writer3);
            Set<Facility> keySet = facilityMap.keySet();
            for (Facility key : keySet) {
                if(key instanceof Villa){
                    bufferedWriter1.write(facilityMap.get(key)+","+((Villa) key).writeFile());
                    bufferedWriter1.newLine();
                }else if(key instanceof House){
                    bufferedWriter2.write(facilityMap.get(key)+","+((House) key).writeFile());
                    bufferedWriter2.newLine();}
                else if(key instanceof Room){
                    bufferedWriter3.write(facilityMap.get(key)+","+((Room) key).writeFile());
                    bufferedWriter3.newLine();}
            }
            bufferedWriter1.close();
            bufferedWriter2.close();
            bufferedWriter3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
    public void edit() {

    }

    @Override
    public void display() {
        int i=1;
        writeFile(PATCH_VILLA,PATCH_HOUSE,PATCH_ROOM);
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            System.out.println(i+" "+key);
            i++;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public Facility returnFacility(int index){
        Facility facility1 = null;
        int i=0;
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            if(index == (i+1)){
                facility1 = key;
            }
            i++;
        }
        return facility1;
    }
    public Facility returnFacility(String name){
        Facility facility1 = null;
        int i=1;
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            if(name.equals(key.getName())){
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
