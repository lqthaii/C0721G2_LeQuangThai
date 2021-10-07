package utils;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ReadWriteFacility {
    static final String PATH_VILLA = "src\\data\\villa.csv";
    static final String PATH_HOUSE = "src\\data\\house.csv";
    static final String PATH_ROOM = "src\\data\\room.csv";
    static final String PATH_MAINTENANCE = "src\\data\\facilitieMaintenance.csv";

    public static void writeFile(Map facilityMap) {
        try {
            FileWriter writer1 = new FileWriter(PATH_VILLA, false);
            FileWriter writer2 = new FileWriter(PATH_HOUSE, false);
            FileWriter writer3 = new FileWriter(PATH_ROOM, false);
            BufferedWriter bufferedWriter1 = new BufferedWriter(writer1);
            BufferedWriter bufferedWriter2 = new BufferedWriter(writer2);
            BufferedWriter bufferedWriter3 = new BufferedWriter(writer3);
            Set<Facility> keySet = facilityMap.keySet();
            for (Facility key : keySet) {
                if (key instanceof Villa) {
                    bufferedWriter1.write(facilityMap.get(key) + "," + ((Villa) key).writeFile());
                    bufferedWriter1.newLine();
                } else if (key instanceof House) {
                    bufferedWriter2.write(facilityMap.get(key) + "," + ((House) key).writeFile());
                    bufferedWriter2.newLine();
                } else if (key instanceof Room) {
                    bufferedWriter3.write(facilityMap.get(key) + "," + ((Room) key).writeFile());
                    bufferedWriter3.newLine();
                }
            }
            bufferedWriter1.close();
            bufferedWriter2.close();
            bufferedWriter3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Facility, Integer> readFile() {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        try {
            File fileVilla = new File(PATH_VILLA);
            File fileHouse = new File(PATH_HOUSE);
            File fileRoom = new File(PATH_ROOM);
            if (!fileVilla.exists() || !fileHouse.exists() || !fileRoom.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader brVilla = new BufferedReader(new FileReader(fileVilla));
            BufferedReader brHouse = new BufferedReader(new FileReader(fileHouse));
            BufferedReader brRoom = new BufferedReader(new FileReader(fileRoom));
            String line = "";
            String[] arr;
            while ((line = brVilla.readLine()) != null) {
                arr = line.split(",");
                facilityMap.put(new Villa(arr[1], arr[2], Double.parseDouble(arr[3]), Double.parseDouble(arr[4]),
                                Integer.parseInt(arr[5]), arr[6], arr[7], Double.parseDouble(arr[8]), Integer.parseInt(arr[9])),
                        Integer.parseInt(arr[0]));
            }
            while ((line = brHouse.readLine()) != null) {
                arr = line.split(",");
                facilityMap.put(new House(arr[1], arr[2], Double.parseDouble(arr[3]), Double.parseDouble(arr[4]),
                        Integer.parseInt(arr[5]), arr[6], arr[7], Integer.parseInt(arr[8])), Integer.parseInt(arr[0]));
            }
            while ((line = brRoom.readLine()) != null) {
                arr = line.split(",");
                facilityMap.put(new Room(arr[1], arr[2], Double.parseDouble(arr[3]), Double.parseDouble(arr[4]),
                        Integer.parseInt(arr[5]), arr[6], arr[7]), Integer.parseInt(arr[0]));
            }
            brVilla.close();
            brHouse.close();
            brRoom.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facilityMap;
    }

    public static void writeFileMaintenance(ArrayList<Facility> facilitieMaintenance) {
        try {
            FileWriter writer = new FileWriter(PATH_MAINTENANCE, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Facility facility : facilitieMaintenance) {
                if (facility instanceof Villa) {
                    bufferedWriter.write(((Villa) facility).writeFile());
                    bufferedWriter.newLine();
                } else if (facility instanceof House) {
                    bufferedWriter.write(((House) facility).writeFile());
                    bufferedWriter.newLine();
                } else if (facility instanceof Room) {
                    bufferedWriter.write(((Room) facility).writeFile());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Facility> readFileMaintenance() {
        ArrayList<Facility> facilitieMaintenance = new ArrayList<>();
        try {
            File file = new File(PATH_MAINTENANCE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arr;
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                if (arr[0].contains("SVVL")) {
                    facilitieMaintenance.add(new Villa(arr[0], arr[1], Double.parseDouble(arr[2]),
                            Double.parseDouble(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6],
                            Double.parseDouble(arr[7]), Integer.parseInt(arr[8])));
                } else if (arr[0].contains("SVHO")) {
                    facilitieMaintenance.add(new House(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Integer.parseInt(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7])));
                } else {
                    facilitieMaintenance.add(new Room(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Integer.parseInt(arr[4]), arr[5], arr[6]));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facilitieMaintenance;
    }
}
