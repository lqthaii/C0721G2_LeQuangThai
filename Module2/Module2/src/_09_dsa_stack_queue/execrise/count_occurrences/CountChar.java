package _09_dsa_stack_queue.execrise.count_occurrences;

import java.util.TreeMap;

public class CountChar {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        String str = "thaith";
        str.toUpperCase();
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.substring(i,i+1))){
                map.put(str.substring(i,i+1),1);
            }else{
                map.put(str.substring(i,i+1),map.get(str.substring(i,i+1))+1);
            }
        }
        System.out.println(map);
    }
}
