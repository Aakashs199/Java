/* 2.Store a list of students from Chennai in a linked list and sort them based on the length of their names*/

import java.util.*;
class Student
 {
    String name;
    public Student(String name)
    {
        this.name = name;
    } 
    public String getName() 
    {
        return name;
    }
}

public class ChennaiStudentList 
{
    public static void main(String[] args)
  {
        LinkedList<Student> chennaiStudents = new LinkedList<>();
        
        chennaiStudents.add(new Student("John Doe"));
        chennaiStudents.add(new Student("Jane Smith"));
        chennaiStudents.add(new Student("Alice"));
        chennaiStudents.add(new Student("Bob"));
        
        Collections.sort(chennaiStudents, (s1, s2) -> Integer.compare(s1.getName().length(), s2.getName().length()));
        
        System.out.println("Sorted list by name length:");
        for(Student student : chennaiStudents) 
       {
            System.out.println(student.getName());
        }
    }
}
