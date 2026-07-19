// TCS PRA Practice: Character Frequency Count
// Description: Counts and displays the frequency of each character in a given string, ignoring spaces and maintaining insertion order.
// Category: Hashing / Map

import java.util.*;
public class HashMap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine().replaceAll("\\s+","");
        LinkedHashMap<Character,Integer>freq=new LinkedHashMap<>();
        for(char c:str.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer>entry:freq.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        sc.close();
    }
}
