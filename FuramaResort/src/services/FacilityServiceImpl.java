package services;

import models.*;
import utils.BookingComparator;
import utils.ReadWriteFacility;
import utils.RegexFacility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class FacilityServiceImpl extends Facility implements FacilityService {
    static Map<Facility, Integer> facilityMap = ReadWriteFacility.readFile();
    static protected ArrayList<Facility> facilitieMaintenance = ReadWriteFacility.readFileMaintenance();
    static Scanner sc = new Scanner(System.in);

    static private RegexFacility regexFacility = new RegexFacility();

    public static void resetFacility() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int day = localDate.getDayOfMonth();
        if (day == 1) {
            for (Facility facility : facilitieMaintenance) {
                facilityMap.put(facility, 0);
            }
        }
        ReadWriteFacility.writeFile(facilityMap);
        ReadWriteFacility.writeFileMaintenance(facilitieMaintenance);
    }

    public static void checkMaintenance() {
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            if (facilityMap.get(key) > 5) {
                Facility facility = key;
                facilitieMaintenance.add(facility);
                //facilityMap.remove(key);
            }
        }
        for (Facility facility : facilitieMaintenance) {
            facilityMap.remove(facility);
        }
        ReadWriteFacility.writeFile(facilityMap);
        ReadWriteFacility.writeFileMaintenance(facilitieMaintenance);
    }

    public static String input(String msg, String regex) {
        String value;
        do {
            System.out.println(msg);
            value = sc.nextLine();
            if (!regexFacility.validate(value, regex)) System.err.println("ERROR " + msg);
        } while (!regexFacility.validate(value, regex));
        return value;
    }

    public static String[] inputData(String regex) {
        String id, name, rentalType, roomStandard, cost, areaUsed, areaPool, maxPeople, numberFloor;
        id = input("ID ", RegexFacility.ID_VILLA_REGEX);
        name = input("Name", RegexFacility.NAME_REGEX);
        areaUsed = input("Area Used", RegexFacility.AREA_REGEX);
        cost = input("Cost", RegexFacility.COST_REGEX);
        maxPeople = input("Number Max People", RegexFacility.NUMBER_REGEX);
        System.out.println("Rental Type:");
        rentalType = sc.nextLine();
        String[] arr = {id, name, areaUsed, cost, maxPeople, rentalType};
        return arr;
    }

    public static Villa inputVilla() {
        String id, name, rentalType, roomStandard;
        double cost, areaUsed, areaPool;
        int maxPeople, numberFloor;
        String[] arr = inputData(RegexFacility.ID_VILLA_REGEX);
        id = arr[0];
        name = arr[1];
        areaUsed = Double.parseDouble(arr[2]);
        cost = Double.parseDouble(arr[3]);
        maxPeople = Integer.parseInt(arr[4]);
        numberFloor = Integer.parseInt(input("Number Floor People", RegexFacility.NUMBER_REGEX));
        rentalType = arr[5];
        System.out.println("Room Standard:");
        roomStandard = sc.nextLine();
        areaPool = Double.parseDouble(input("Area Pool", RegexFacility.AREA_REGEX));

        return new Villa(id, name, areaUsed, cost, maxPeople, rentalType, roomStandard, areaPool, numberFloor);
    }

    public static House inputHourse() {
        String id, name, rentalType, roomStandard;
        double cost, areaUsed;
        int maxPeople, numberFloor;
        String[] arr = inputData(RegexFacility.ID_HOUSE_REGEX);
        id = arr[0];
        name = arr[1];
        areaUsed = Double.parseDouble(arr[2]);
        cost = Double.parseDouble(arr[3]);
        maxPeople = Integer.parseInt(arr[4]);
        numberFloor = Integer.parseInt(input("Number Floor People", RegexFacility.NUMBER_REGEX));
        rentalType = arr[5];
        System.out.println("Room Standard:");
        roomStandard = sc.nextLine();
        return new House(id, name, areaUsed, cost, maxPeople, rentalType, roomStandard, numberFloor);
    }

    public static Room inputRoom() {
        String id, name, rentalType, serviceFree;
        double cost, areaUsed;
        int maxPeople;
        String[] arr = inputData(RegexFacility.ID_ROOM_REGEX);
        id = arr[0];
        name = arr[1];
        areaUsed = Double.parseDouble(arr[2]);
        cost = Double.parseDouble(arr[3]);
        maxPeople = Integer.parseInt(arr[4]);
        rentalType = arr[6];
        System.out.println("Service Free:");
        serviceFree = sc.nextLine();
        return new Room(id, name, areaUsed, cost, maxPeople, rentalType, serviceFree);
    }

    public static void increaseUsed(String id) {
        for (Facility key : facilityMap.keySet()) {
            if (key instanceof Villa && key.getId().equals(id)) {
                facilityMap.put(key, ((Integer) (facilityMap.get(key)) + 1));
                break;
            } else if (key instanceof House && key.getId().equals(id)) {
                facilityMap.put(key, ((Integer) (facilityMap.get(key)) + 1));
                break;
            } else if (key instanceof Room && key.getId().equals(id)) {
                facilityMap.put(key, ((Integer) (facilityMap.get(key)) + 1));
                break;
            }
        }
        ReadWriteFacility.writeFile(facilityMap);
        ReadWriteFacility.writeFileMaintenance(facilitieMaintenance);
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
                    facilityMap.put(inputVilla(), 0);
                    break;
                case 2:
                    facilityMap.put(inputHourse(), 0);
                    break;
                case 3:
                    facilityMap.put(inputRoom(), 0);
                    break;
                default:
                    System.out.println("Bạn đã nhập sai vui lòng nhập lại");
            }
        } while (choose < 1 || choose > 3);
        ReadWriteFacility.writeFile(facilityMap);
    }


    @Override
    public void edit() {

    }

    @Override
    public void display() {
        checkMaintenance();
        int i = 1;
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            System.out.println(i + " " + key);
            i++;
        }
    }

    public void displayMaintenance() {
        for (Facility facility : facilitieMaintenance) {
            System.out.println(facility);
        }
    }

    public Facility returnFacility(int index) {
        Facility facility1 = null;
        int i = 0;
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            if (index == (i + 1)) {
                facility1 = key;
            }
            i++;
        }
        return facility1;
    }

    public Facility returnFacility(String name) {
        Facility facility1 = null;
        int i = 1;
        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            if (name.equals(key.getName())) {
                facility1 = key;
            }
            i++;
        }
        return facility1;
    }

}
