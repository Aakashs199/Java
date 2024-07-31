/* 1.Write a program to get student names and respective locations - sort students based on the lexicographical order of locations.  */

import java.util.*;
public class StudentSorter
 {
   public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> students = new HashMap<>();
        System.out.println("Enter the number of students:");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numStudents; i++) 
          {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter student location:");
            String location = scanner.nextLine();
            students.put(name, location);
          }
     List<Map.Entry<String,String>> set=new ArrayList<>(students.entrySet());
     Collections.sort(set,new Comparator<Map.Entry<String,String>>(){
            public int compare(Map.Entry<String,String>entry1, Map.Entry<String,String>entry2){
               return entry1.getValue().compareTo(entry2.getValue());
             }
        });
     System.out.println("----Sorted Based on Location----");
    for(Map.Entry<String,String>entry:set)
      {
         System.out.println(entry.getKey()+" "+entry.getValue());
      }
       
    }
}
