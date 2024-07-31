/*1.(L1).Write a program for demonstrating Multiple Inheritance in java */

interface InternetConnectable
 {
    void connectToInternet();
 }

interface MediaPlayable
 {
    void connectToInternet();
    void playMedia(String media);
 }

interface CallSupportable
 {
    void makeCall(String phoneNumber);
 }

 interface Turn
 {
    void turnOn(); 
    void turnOff();
 }



class Smartphone extends ElectronicDevice implements InternetConnectable,MediaPlayable,CallSupportable,Turn
  {
     public void connectToInternet() 
	{
          System.out.println("Smartphone is connected to the internet");
        }
    public void playMedia(String media)
	{
          System.out.println("Playing "+media+" on Smartphone");
        }
    public void makeCall(String phoneNumber)
        {
          System.out.println("Calling " +phoneNumber+ " from Smartphone");
        }
    public void turnOn() 
	{
          System.out.println("Smartphone is turning on");
        }
    public void turnOff()
        {
           System.out.println("Smartphone is turning off");
        }
   
}

class Laptop extends ElectronicDevice implements InternetConnectable, MediaPlayable,Turn 
{
    public void connectToInternet() 
    {
        System.out.println("Laptop is connected to the internet");
    }
    public void playMedia(String media) 
     {
        System.out.println("Playing "+media+" on Laptop");
     }
   public void turnOn() 
	{
          System.out.println("Laptop is turning on");
        }
    public void turnOff()
        {
           System.out.println("Laptop is turning off");
        }
   
}

public class MultipleInheritance
 {
    public static void main(String[] args)
    {
        Smartphone smartphone = new Smartphone();
        smartphone.turnOn();
        smartphone.connectToInternet();
        smartphone.playMedia("Music");
        smartphone.makeCall("8925209097");
        smartphone.turnOff();

        System.out.println("--------------------------------");

        Laptop laptop = new Laptop();
        laptop.turnOn();
        laptop.connectToInternet();
        laptop.playMedia("Movie");
        laptop.turnOff();
    }
}
