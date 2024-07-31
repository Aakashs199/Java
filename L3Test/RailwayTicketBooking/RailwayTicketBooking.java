import java.util.*;
class Train 
{
    int pnr;
    int berthNo;
    String currentStatus;
    String berthType;
    String name;
    int age;

    public Train(int pnr, int berthNo, String currentStatus, String berthType, String name, int age)
    {
        this.pnr = pnr;
        this.berthNo = berthNo;
        this.currentStatus = currentStatus;
        this.berthType = berthType;
        this.name = name;
        this.age = age;
    }
}

public class RailwayTicketBooking
 {
    static Scanner sc = new Scanner(System.in);
    static String seats[] = {"LB", "MB", "UB", "LB", "MB", "UB", "SL", "SU"};
    static List<Train> coach = new ArrayList<>();

    public void initializeCoach() 
     {
        Train train;
        int berthNo = 0;
        int racCount = 0;
        String str;

        for(int i=1;i<=18;i++)
	 {
            if(i!=8 && i!=17) 
	    {
                berthNo++;
            }

            if(berthNo==7 || berthNo==15)
	    {
                racCount++;
                str ="RAC"+racCount;
            } 
	    else
	    {
                str="AVL";
            }

            train=new Train(0, berthNo, str, seats[(berthNo - 1) % 8]," ",0);
            coach.add(train);
        }
        train = new Train(0, 0, "WL1", "-", " ", 0);
        coach.add(train);
        train = new Train(0, 0, "WL2", "-", " ", 0);
        coach.add(train);
        displayCoach();
    }



 public void bookTicket() 
   {
        sc.nextLine();
        System.out.print("Enter your Name: ");
        String passengerName = sc.nextLine();
        System.out.print("Enter your Age: ");
        int passengerAge = sc.nextInt();

        if(passengerAge <= 6) 
	{
            System.out.println("Booking Ticket is Not possible Because Age is less than 6");
            return;
        }

      System.out.print("Need Berth Preference(yes/no): ");
      sc.nextLine();
      String preference = sc.nextLine();

      if(preference.equalsIgnoreCase("yes"))
	 {
            System.out.print("Enter your Preference:{LB, MB, UB, LB, MB, UB, SL, SU}: ");
            String berth = sc.nextLine();
            Train availableBerth = null;
            for(Train train : coach)
	      {
                 if(train.berthType.equalsIgnoreCase(berth) && train.currentStatus.equals("AVL")) 
		  {
                     train.name = passengerName;
                     train.age = passengerAge;
                     train.currentStatus = "CNF";
                     Random random = new Random();
                     int pnrPassenger = 1000000 + random.nextInt(900000);
                     train.pnr = pnrPassenger;
                     availableBerth = train;
                     break;
                }
            }

            if(availableBerth != null)
	     {
                System.out.println("Ticket Booked Successfully");
                displayCoach();
                return;
             }
	    else
	     {
                System.out.println("---------Your Preference BerthSeat is Not Available----- ");
                System.out.println("Press 1 to Book any BerthSeats");
                System.out.println("Press 0 to Exit");
                int value = sc.nextInt();
                if(value == 1) 
		{
                    bookTicketWithoutPreference(passengerName,passengerAge);
                }
		else
		 {
                    System.out.println("LEAVING THE CONSOLE");
                    return;
                 }
            }

        }
 
     else 
        {
            bookTicketWithoutPreference(passengerName,passengerAge);
        }
    }



 public void bookGroupTicket() 
   {
        sc.nextLine();
        System.out.print("Enter the number of passengers: ");
        int numPassengers = sc.nextInt();
        sc.nextLine();
        List<String> names = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();
        List<String> preferences = new ArrayList<>();


        for (int i = 0; i < numPassengers; i++) 
	{
            System.out.print("Enter Name of Passenger "+(i+1)+": ");
            names.add(sc.nextLine());
            System.out.print("Enter Age of Passenger "+(i+1)+": ");
            ages.add(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Berth Preference of Passenger "+(i+1)+"{LB, MB, UB, SL, SU}: ");
            preferences.add(sc.nextLine());
        }


        List<Train> allocatedBerths = new ArrayList<>();
        Random random = new Random();
        int pnrPassenger = 1000000 + random.nextInt(900000);

        for(int i=0;i<numPassengers;i++)
	 {
            for(Train train : coach)
	      {
                 if(train.currentStatus.equals("AVL") && train.berthType.equalsIgnoreCase(preferences.get(i))) 
		{
                    train.name=names.get(i);
                    train.age=ages.get(i);
                    train.currentStatus="CNF";
                    train.pnr=pnrPassenger;
                    allocatedBerths.add(train);
                    break;
                }
            }
        }


    if(allocatedBerths.size()<numPassengers)
	 {
            for(int i=allocatedBerths.size();i<numPassengers;i++)
	      {
                 boolean allocated = false;
                 for(Train train : coach) 
		   {
                    if(train.currentStatus.equals("AVL") && !allocatedBerths.contains(train)) 
			{
                         train.name = names.get(i);
                         train.age = ages.get(i);
                         train.currentStatus = "CNF";
                         train.pnr = pnrPassenger;
                         allocatedBerths.add(train);
                         allocated = true;
                         break;
                      }
                   }

                if(!allocated) 
		{
                    System.out.println("Not enough available berths to accommodate the group.");
                    allocateRACOrWL(pnrPassenger,names,ages,allocatedBerths,i);
                    return;
                }
            }
        }
        System.out.println("Group Tickets Booked Successfully");
        displayCoach();
    }





 public void allocateRACOrWL(int pnrPassenger,List<String> names,List<Integer> ages,List<Train> allocatedBerths,int startIndex) 
   {
        for(int i= startIndex;i<names.size();i++)
	 {
            boolean allocated = false;
            for(Train train : coach)
	      {
                  if(train.currentStatus.startsWith("RAC") && !allocatedBerths.contains(train))
		 {
                    train.name = names.get(i);
                    train.age = ages.get(i);
                    train.currentStatus = "RAC";
                    train.pnr = pnrPassenger;
                    allocatedBerths.add(train);
                    allocated = true;
                    break;
                }
            }

            if(!allocated)
	      {
                 for(Train train : coach)
		   {
                      if(train.currentStatus.startsWith("WL") && !allocatedBerths.contains(train)) 
			{
                         train.name = names.get(i);
                         train.age = ages.get(i);
                         train.currentStatus = "WL";
                         train.pnr = pnrPassenger;
                         allocatedBerths.add(train);
                         break;
                        }
                   }
              }
          }
        System.out.println("Group Tickets Booked with RAC/WL");
        displayCoach();
    }



public void bookTicketWithoutPreference(String passengerName, int passengerAge) 
   {
      Train availableBerth = null;
      for(Train train : coach) 
	{
            if(train.currentStatus.equals("AVL"))
	     {
                train.name = passengerName;
                train.age = passengerAge;
                train.currentStatus = "CNF";
                Random random = new Random();
                int pnrPassenger = 1000000 + random.nextInt(900000);
                train.pnr = pnrPassenger;
                availableBerth = train;
                break;
            }
        }

        if(availableBerth == null)
	 {
            System.out.println("No Ticket is Available");
            bookRACOrWL(passengerName, passengerAge);
         }
	 else
	 {
            System.out.println("Ticket is Booked");
            displayCoach();
         }
    }

public void bookRACOrWL(String passengerName,int passengerAge)
  {
      Train availableRACOrWL=null;
      for(Train train : coach)
	 {
            if(train.currentStatus.startsWith("RAC"))
	      {
                train.name = passengerName;
                train.age = passengerAge;
                Random random = new Random();
                int pnrPassenger = 1000000 + random.nextInt(900000);
                train.pnr = pnrPassenger;
                availableRACOrWL = train;
                break;
             }
        }

        if(availableRACOrWL == null)
	 {
            for(Train train : coach)
	      {
                if(train.currentStatus.startsWith("WL")) 
		  {
                     train.name = passengerName;
                     train.age = passengerAge;
                     Random random = new Random();
                     int pnrPassenger = 1000000 + random.nextInt(900000);
                     train.pnr = pnrPassenger;
                     availableRACOrWL = train;
                     break;
                }
            }
        }

        if(availableRACOrWL != null)
	 {
            System.out.println("Ticket Booked in RAC/WL");
            displayCoach();
         }
	else
	 {
            System.out.println("No Ticket is Available in RAC/WL");
         }
    }



 public void cancelTicket() 
    {
        System.out.print("Enter the PNR Value: ");
        int pnrValue = sc.nextInt();
        boolean flag = false;
        Train cancelledTrain = null;

     for(Train train : coach)
        {
            if(train.pnr == pnrValue)
	     {
                System.out.println(train.pnr+"		 " +train.berthNo+"		 "+train.currentStatus+"		 "+train.berthType+"			"+train.name+"			"+train.age);
                cancelledTrain = train;
                flag = true;
                break;
            }
        }

    if(flag&&cancelledTrain!=null)
	 {
            cancelledTrain.pnr = 0;
            cancelledTrain.currentStatus ="AVL";
            cancelledTrain.name = " ";
            cancelledTrain.age = 0;
            shiftRACAndWL();
            System.out.println("Ticket is Canceled With the PNR Number you Provided");
            displayCoach();
        }

    else
	 {
            System.out.println("No Ticket is Booked With the PNR Number you Provided");
         }
    }




 public void shiftRACAndWL()
   {
       Train previous = null;
       for(Train train : coach)
	 {
            if(train.currentStatus.startsWith("RAC"))
	      {
                 if(previous != null && previous.currentStatus.equals("AVL"))
		 {
                    previous.pnr = train.pnr;
                    previous.name = train.name;
                    previous.age = train.age;
                    previous.currentStatus ="CNF";
                    train.pnr=0;
                    train.currentStatus ="AVL";
                    train.name = " ";
                    train.age=0;
                }
                 previous = train;
            }
        }

        for(Train train : coach)
        {
            if(train.currentStatus.startsWith("WL")) 
	      {
                 if(previous != null && previous.currentStatus.startsWith("RAC"))
		 {
                    previous.pnr = train.pnr;
                    previous.name = train.name;
                    previous.age = train.age;
                    previous.currentStatus = "RAC" + previous.berthNo;
                    train.pnr = 0;
                    train.currentStatus = "AVL";
                    train.name = " ";
                    train.age = 0;
                }
                previous=train;
            }
        }
    }



 public void displayCoach()
   {	
	System.out.println("PNR		"+"Berth No 	"+"Status 		"+"BerthType 		"+"Name			"+"Age");
        for(Train train:coach) 
	{
            System.out.println(train.pnr+"		 " +train.berthNo+"		 "+train.currentStatus+"		 "+train.berthType+"			"+train.name+"			"+train.age);
        }
    }


  public void displayWithPnr()
   {
	System.out.print("Enter the PNR Value: ");
	int pnrValue=sc.nextInt();
	boolean flag=false;
     for(Train train:coach) 
	{
           if(train.pnr==pnrValue)
		{
		   System.out.println(train.pnr+"		 " +train.berthNo+"		 "+train.currentStatus+"		 "+train.berthType+"			"+train.name+"			"+train.age);
		   flag=true;
		}   
        }
      if(!flag)
	{
		System.out.println("No Ticket is Booked With the PNR Number you Provided");
	}
   }






  public static void main(String args[]) 
  {
     RailwayTicketBooking book = new RailwayTicketBooking();
     boolean check = true;
        while(check) 
	{
            System.out.println("Enter the Choice: ");
	    System.out.println("1.Create Compartment & Display");
	    System.out.println("2.Book a Ticket");
	    System.out.println("3. Display Details with PNR: ");
	    System.out.println("4.Book a Ticket for Group of People: ");
	    System.out.println("5.Cancel Ticket: ");
            int choice = sc.nextInt();
            switch (choice) 
		{
                case 1:		    
                       book.initializeCoach();
                       break;

		case 2:
                        book.bookTicket();
                        break;
		
		case 3:
			book.displayWithPnr();
			break;

		case 4:
			book.bookGroupTicket();
                        break;

		case 5:
			book.cancelTicket();
                        break;

		case 6:
			book.displayCoach();
			
                        break;

                default:
                        check=false;
                        break;
            }
        }
    }
}


