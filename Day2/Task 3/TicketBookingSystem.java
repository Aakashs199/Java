import java.util.*;

class Ticket
 {
    String passengerName;
    public Ticket(String passengerName) 
    {
        this.passengerName=passengerName;
    }

  public void bookTicket() 
    {
        System.out.println("Booking ticket for: "+passengerName);
    }

  public void cancelTicket()
    {
        System.out.println("Cancelling ticket for: "+passengerName);
    }

  public void displayDetails() 
    {
        System.out.println("Passenger Name: "+passengerName);
    }
}

class BusTicket extends Ticket
 {
    String busNumber;
    int seatNumber;
    private static int seatCounter=1;

    public BusTicket(String passengerName,String busNumber)
    {
        super(passengerName);
        this.busNumber=busNumber;
        this.seatNumber=seatCounter++;
    }

    public void bookTicket()
    {
        System.out.println("Booking bus ticket for: "+passengerName+" on bus: "+busNumber+" at seat: S"+seatNumber);
    }

    public void displayDetails()
    {
        System.out.println("------Bus Ticket Details-------");
        super.displayDetails();
        System.out.println("Bus Number: "+busNumber);
        System.out.println("Seat Number: S"+seatNumber);
    }
}

class TrainTicket extends Ticket
 {
    String trainNumber;
    int berthNumber;

    private static int berthCounter=1; 

    public TrainTicket(String passengerName, String trainNumber)
    {
        super(passengerName);
        this.trainNumber=trainNumber;
        this.berthNumber=berthCounter++;
    }

    public void bookTicket()
    {
        System.out.println("Booking train ticket for: "+passengerName+" on train: "+trainNumber+" at berth: B"+berthNumber);
    }

    public void displayDetails() 
    {
        System.out.println("-----Train Ticket Details-------");
        super.displayDetails();
        System.out.println("Train Number: "+trainNumber);
        System.out.println("Berth Number: B"+berthNumber);
    }
}



public class TicketBookingSystem
 {
    public static double calculatePrice(double basePrice) 
    {
        return basePrice;
    }

    public static double calculatePrice(double basePrice, double serviceCharge) 
    {
        return basePrice+serviceCharge;
    }

    public static double calculatePrice(double basePrice, double serviceCharge, double tax)
    {
        return basePrice+serviceCharge+tax;
    }

public static void main(String[] args)
  {
        Scanner sc = new Scanner(System.in);
        while(true)
	 {
            System.out.println("----Ticket Booking System-----");
             System.out.println("1. Book Bus Ticket");
            System.out.println("2. Book Train Ticket");
            System.out.println("3. Exit");
          System.out.print("Enter choice: ");
          int choice = sc.nextInt();
          sc.nextLine();
          Ticket ticket = null;
         switch(choice) 
	    {
                case 1:
                    System.out.print("Enter Passenger Name: ");
                    String busPassengerName = sc.nextLine();
                    System.out.print("Enter Bus Number: ");
                    String busNumber = sc.nextLine();

                    Ticket busticket=new BusTicket(busPassengerName,busNumber); 
                    busticket.bookTicket();
                    busticket.displayDetails();

                    double busPrice=calculatePrice(500);
                    double busPriceWithTax=calculatePrice(500,50);
                    System.out.println("Bus Ticket Price: "+busPrice);
                    System.out.println("Bus Ticket Price with Service Tax: "+busPriceWithTax);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter Passenger Name: ");
                    String trainPassengerName = sc.nextLine();
                    System.out.print("Enter Train Number: ");
                    String trainNumber = sc.nextLine();

                    Ticket trainticket = new TrainTicket(trainPassengerName,trainNumber);
                    trainticket.bookTicket();
                    trainticket.displayDetails();

                    double trainPrice = calculatePrice(800);
                    double trainPriceWithCharges = calculatePrice(800,100,50);
                    System.out.println("Train Ticket Price: " + trainPrice);
                    System.out.println("Train Ticket Price with Service Charge and Tax: "+trainPriceWithCharges);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("----Exiting Application----");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
