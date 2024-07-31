/*3.Write a program to illustrate the size or range of various data types.*/

import java.util.*;
public class Size

{
public static void main(String args[])
   { 
      System.out.println("Size of Integer is: "+32/8+" Bytes");              //Integer.SIZE(32 bit)
      System.out.println("Size of Float is: " +32/8+" Bytes");                //Float.SIZE(32 bit)
      System.out.println("Size of Double is: "+64/8+" Bytes");               //Double.SIZE(64 bit)
      System.out.println("Size of Character is: "+16/8+" Bytes");            //Charcter.SIZE (16 bit)
      System.out.println("Size of Long is: "+64/8+" Bytes");                 //Long.SIZE(64 bit)
      System.out.println("Size of Boolean is: "+8/8+" Bytes");               //Boolean.SIZE(8 bit)
      System.out.println("Size of Short is: "+16/8+" Bytes");                //Short.SIZE(16 bit)
   }
}