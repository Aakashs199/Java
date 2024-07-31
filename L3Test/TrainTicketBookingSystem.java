import java.util.*;
class Train 
{
    private int trainnumber;
    private String trainname;
    private String source;
    private String destination;
    private String time;
    private int maxseat = 50;
    private int availableseat;

    public Train(int trainnumber,String trainname,String source,String destination,String time,int maxseat)
      {
        this.trainnumber=trainnumber;
        this.trainname=trainname;
        this.source=source;
        this.destination=destination;
        this.time=time;
        this.maxseat=maxseat;
        this.availableseat=maxseat;
     }

    public int getTrainNumber()
     {
        return trainnumber;
     }

    public String getTrainName()
      {
        return trainname;
      }

    public String getSource() 
     {
        return source;
     }

    public String getDestination()
      {
        return destination;
      }

    public String getTime() 
      {
        return time;
      }

    public int getAvailableSeats() 
      {
        return availableseat;
      }

    public boolean bookSeat()
      {
        if(availableseat > 0) 
         {
            availableseat--;
            return true;
        }
        return false;
    }

    public void cancelSeat()
     {
        if(availableseat<maxseat)
          {
            availableseat++;
          }
    }
}


class Ticket
 {
    private static int ticketcounter = 1;
    private int ticketnumber;
    private String passengername;
    private int seatnumber;
    private int trainnumber;

    public Ticket(String passengername, int seatnumber, int trainnumber) 
    {
        this.passengername = passengername;
        this.ticketnumber = ticketcounter++;
        this.seatnumber = seatnumber;
        this.trainnumber = trainnumber;
    }

    public String getPassengerName() 
    {
        return passengername;
    }

    public int getTicketNumber() 
    {
        return ticketnumber;
    }

    public int getSeatNumber()
    {
        return seatnumber;
    }

    public int getTrainNumber()
     {
        return trainnumber;
     }
}


public class TrainTicketBookingSystem
 {
    private List<Train>trains;
    private List<Ticket>tickets;
    private Map<Integer,List<Integer>>reservedseats;

    public TrainTicketBookingSystem()
    {
        trains = new ArrayList<>();
        tickets = new ArrayList<>();
        reservedseats = new HashMap<>();
    }

  public boolean bookTicket(String passengername, int seatnumber, int trainnumber)
    {
       try{
            Train selectedTrain = null;
            for(Train train : trains) 
	    {
                if (train.getTrainNumber() == trainnumber)
	        {
                    selectedTrain = train;
                    break;
                }
            }

            if(selectedTrain == null)  
            {
              throw new IllegalArgumentException("Invalid Train");
            }

            if(seatnumber > 50)
	    {
              throw new IllegalArgumentException("Invalid Seat");
            }

            if(reservedseats.containsKey(trainnumber) && reservedseats.get(trainnumber).contains(seatnumber)) 
	    {
                throw new RuntimeException("Seat is Already Booked");
            }

            if (selectedTrain.bookSeat())
	    {
                Ticket ticket = new Ticket(passengername, seatnumber, trainnumber);
                tickets.add(ticket);
                reservedseats.computeIfAbsent(trainnumber, k -> new ArrayList<>()).add(seatnumber);
                System.out.println("Ticket Booked Successfully");
                return true;
            }
	   else
	    {
                throw new RuntimeException("No available seats for Train");
            }

        }

       catch(IllegalArgumentException e) 
	   {
            System.out.println("Error: " + e.getMessage());
            return false;
           }
	 catch(RuntimeException e)
	  {
            System.out.println("Error: " + e.getMessage());
            return false;
          }
    }


  public void displayTrain(String source, String destination)
   {

     List<Train> availableTrains = new ArrayList<>();
     for(Train train : trains)
	 {
            if(train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination))
	     {
                availableTrains.add(train);
             }
         }
        for(Train train : availableTrains) 
	{
 	  System.out.println("-----Trains Available-----");
          System.out.println("Train Name: "+train.getTrainName()); 
          System.out.println("Source: "+train.getSource());
 	  System.out.println("Destination: "+train.getDestination());
	  System.out.println("Departure Time: "+train.getTime());
	  System.out.println("Available Seats: "+train.getAvailableSeats());
	  System.out.println("Train Number: "+train.getTrainNumber());
          System.out.println("-----------------");
        }
    }

 public static void main(String[] args)
 {
    TrainTicketBookingSystem book = new TrainTicketBookingSystem();
    Scanner sc=new Scanner(System.in);
    Train train1 = new Train(1010,"Mumbai Superfast","MUMBAI","DELHI","13:05",50);
    Train train2 = new Train(2013, "Delhi SuperFast","DELHI","JAIPUR","7:00",50);
    Train train3 = new Train(3045, "Prayagraj EXP","PRAYAGRAJ","DELHI","10:00",50);

    book.trains.add(train1);
    book.trains.add(train2);
    book.trains.add(train3);

    while(true)
        {
            System.out.println("Choose an option:");
            System.out.println("1. Display Train Information");
            System.out.println("2. Book a Ticket");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter source station: ");
                    String source=sc.nextLine().toUpperCase();
                    System.out.print("Enter destination station: ");
                    String destination=sc.nextLine().toUpperCase();
                    book.displayTrain(source,destination);
                    break;
                case 2:
                    System.out.print("Enter passenger name: ");
                    String passengerName=sc.nextLine();
                    System.out.print("Enter seat number: ");
                    int seatNumber=sc.nextInt();
                    System.out.print("Enter train number: ");
                    int trainNumber=sc.nextInt();
                    book.bookTicket(passengerName, seatNumber, trainNumber);
                    break;
                case 3:
                    System.out.println("---End of the Program---");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
