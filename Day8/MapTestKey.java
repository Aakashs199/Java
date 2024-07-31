/* 11.Write a Java program to test if a map contains a mapping for the specified key. */

import java.util.*;
public class MapTestKey
 {
  public static void main(String[] args)  
   {
     Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 15);
        System.out.println(map);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key to check: ");
        String key = scanner.nextLine();

        if(map.containsKey(key))
	 {
            System.out.println("Value for key: " +key+": "+ map.get(key));
        } 
	else 
	{
            System.out.println("The map does not contain a mapping for the key: " +key);
        }
    }
}
