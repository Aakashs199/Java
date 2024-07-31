import java.util.*;
import java.io.*;
class Car implements Serializable
{
  String brand;
  String color;
  int price;
  int milage;
  String fueltype;
  public Car(String brand,String color,int price,int milage,String fueltype)
   {
     this.brand=brand;
     this.color=color;
     this.price=price;
     this.milage=milage;
     this.fueltype=fueltype;
   }
  public String getBrand()
   {
     return brand;
   }
  public String getColor()
   {
     return color;
   }
  public int getPrice()
   {
     return price;
   }
  public int getMilage()
   {
     return milage;
   }
  public String getFueltype()
   {
     return fueltype;
   }
}


public class CarSerialization
 {
 @SuppressWarnings("unchecked")public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    ArrayList<Car> carlist=new ArrayList<>();
    carlist.add(new Car("Audi","White",2000000,20,"Disel"));
    carlist.add(new Car("BMW","Red",4000000,18,"Petrol"));
    carlist.add(new Car("Shift","Blue",6000000,22,"Disel"));
    carlist.add(new Car("Maruthi","Black",8000000,25,"Petrol"));
    carlist.add(new Car("Benz","White",90000000,17,"Disel"));
    System.out.println("----Serialization----");
    try
     {
       FileOutputStream fout=new FileOutputStream("car.ser");
       ObjectOutputStream out=new ObjectOutputStream(fout);
       out.writeObject(carlist);
       out.close();
       fout.close();
       System.out.println("Serialization is Completed");
     }
    catch(IOException e)
     {
         System.out.println(e);
     }
   System.out.println("----DeSerialization----");
   try
    {
      ArrayList<Car> output=new ArrayList<>();
      FileInputStream fin=new FileInputStream("car.ser");
      ObjectInputStream in=new ObjectInputStream(fin);
      output=(ArrayList<Car>)in.readObject();
      in.close();
      fin.close();
      for(Car car: output)
     {
        System.out.print("Brand: "+car.getBrand()+" Color: "+car.getColor()+" Price: "+car.getPrice()+" Milage: "+car.getMilage()+" FuelType: "+car.getFueltype());
        System.out.println();
     }
      System.out.println("----DeSerialization is Completed----");
    }
    catch(IOException | ClassNotFoundException e)
     {
       System.out.println(e);
     }

  }
 }

