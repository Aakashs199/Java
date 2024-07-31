import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Taxi
 {
    int id;
    char currentLocation;
    int totalEarnings;
    List<Booking>bookings;
    public Taxi(int id)
   {
     this.id = id;
     this.currentLocation = 'A';
     this.totalEarnings=0;
     this.bookings = new ArrayList<>();
   }

 public boolean isAvailable(int pickupTime) 
    {
      if(bookings.isEmpty())
       {
         return true;
       }
      Booking lastBooking=bookings.get(bookings.size() - 1);
         return lastBooking.dropTime<=pickupTime;
    }

 public void addBooking(Booking booking)
   {
      this.bookings.add(booking);
      this.totalEarnings+=booking.amount;
      this.currentLocation=booking.dropPoint;
    }

 public void display()
  {
    System.out.println("Taxi-"+id+" Total Earnings:Rs. "+totalEarnings);
    for(Booking booking:bookings)
      {
         booking.display();
      }
    }
}

class Booking 
 {
  int bookingID;
  int customerID;
  char pickupPoint;
  char dropPoint;
  int pickupTime;
  int dropTime;
  int amount;
  public Booking(int bookingID,int customerID,char pickupPoint,char dropPoint,int pickupTime,int dropTime,int amount)
    {
      this.bookingID = bookingID;
      this.customerID = customerID;
      this.pickupPoint = pickupPoint;
      this.dropPoint = dropPoint;
      this.pickupTime = pickupTime;
      this.dropTime = dropTime;
      this.amount = amount;
    }

   public void display()
    {
      System.out.println("BookingID: "+bookingID+" CustomerID: "+customerID+" From: "+pickupPoint+" To: "+dropPoint+ "PickupTime: "+pickupTime+" DropTime: " +dropTime+" Amount:Rs. "+amount);
    }
}

public class TaxiBookingSystemtask
 {
   List<Taxi> taxis;
   int bookingID;
   public TaxiBookingSystemtask(int numberOfTaxis)
    {
      taxis = new ArrayList<>();
      for(int i=1;i<=numberOfTaxis;i++) 
        {
            taxis.add(new Taxi(i));
        }
        bookingID = 1;
    }

 public void bookTaxi(int customerID,char pickupPoint,char dropPoint,int pickupTime)
   {
     Taxi selectedTaxi = null;
     int minDistance = Integer.MAX_VALUE;
     int minEarnings = Integer.MAX_VALUE;
     for(Taxi taxi:taxis)
     {
       if(taxi.isAvailable(pickupTime))
          {
            int distance=Math.abs(taxi.currentLocation-pickupPoint);
            if(distance<minDistance||(distance==minDistance && taxi.totalEarnings<minEarnings))
              {
                    minDistance = distance;
                     minEarnings = taxi.totalEarnings;
                    selectedTaxi = taxi;
              }
            }
        }
     if(selectedTaxi!=null)
       {
         int distance = Math.abs(pickupPoint - dropPoint);
         int secondhalf=(distance*15-5)*10;
         int amount=secondhalf+100;
          int dropTime = pickupTime + distance;
         Booking booking = new Booking(bookingID++, customerID, pickupPoint, dropPoint, pickupTime, dropTime, amount);
         selectedTaxi.addBooking(booking);
         System.out.println("Taxi can be allotted.");
         System.out.println("Taxi-" + selectedTaxi.id + " is allotted");
        } 
     else 
        {
            System.out.println("No taxi available at this time.");
        }
    }

 public void displayTaxiDetails()
  {
   for(Taxi taxi:taxis)
    {
      taxi.display();
    }
  }

public static void main(String[] args)
  {
    TaxiBookingSystemtask ob = new TaxiBookingSystemtask(4);
    Scanner scanner = new Scanner(System.in);
    int choice;
   do
    {
     System.out.println("1. Book Taxi");
     System.out.println("2. Display Taxi Details");
     System.out.println("3. Exit");
     choice = scanner.nextInt();
     switch (choice)
       {
         case 1:
               System.out.print("Enter Customer ID: ");
               int customerID = scanner.nextInt();
               System.out.print("Enter Pickup Point(A-F): ");
               char pickupPoint = scanner.next().toUpperCase().charAt(0);
               System.out.print("Enter Drop Point(A-F): ");
               char dropPoint = scanner.next().toUpperCase().charAt(0);
               System.out.print("Enter Pickup Time(in hours): ");
               int pickupTime = scanner.nextInt();
               ob.bookTaxi(customerID,pickupPoint,dropPoint,pickupTime);
               break;
          case 2:
               ob.displayTaxiDetails();
               break;
          case 3:
               System.out.println("Exiting");
               break;
         default:
               System.out.println("Invalid choice");
            }
        }
     while (choice != 3);
    }
}
