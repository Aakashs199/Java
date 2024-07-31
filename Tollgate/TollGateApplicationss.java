import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TollGate 
{
    private int tollId;
    private String location;
    private double carFare;
    private double twoWheelerFare;
    private List<Vehicle> passedVehicles;
    private double totalCollected;

    public TollGate(int tollId, String location, double carFare, double twoWheelerFare)
 {
        this.tollId = tollId;
        this.location = location;
        this.carFare = carFare;
        this.twoWheelerFare = twoWheelerFare;
        this.passedVehicles = new ArrayList<>();
        this.totalCollected = 0;
    }

    public int getTollId() {
        return tollId;
    }

    public String getLocation() {
        return location;
    }

    public double getCarFare() {
        return carFare;
    }

    public double getTwoWheelerFare() {
        return twoWheelerFare;
    }

    public void addVehicle(Vehicle vehicle, double fare) {
        passedVehicles.add(vehicle);
        totalCollected += fare;
    }

    public List<Vehicle> getPassedVehicles() {
        return passedVehicles;
    }

    public double getTotalCollected() {
        return totalCollected;
    }
}

class Vehicle 
{
    private String vehicleNumber;
    private String type;
    private String currentLocation;
    private double amountPaid;
    private boolean isVIP;
    private List<String> journeyDetails;

    public Vehicle(String vehicleNumber, String type, String currentLocation, boolean isVIP)
    {
        this.vehicleNumber=vehicleNumber;
        this.type = type;
        this.currentLocation=currentLocation;
        this.isVIP=isVIP;
        this.amountPaid = 0;
        this.journeyDetails = new ArrayList<>();
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void addAmountPaid(double amount) {
        this.amountPaid += amount;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void addJourneyDetail(String journey) {
        journeyDetails.add(journey);
    }

    public List<String> getJourneyDetails() {
        return journeyDetails;
    }
}

class TollGateSystem
 {
    private List<TollGate> tollGates;
    public TollGateSystem() 
     {
        tollGates = new ArrayList<>();
        tollGates.add(new TollGate(1,"Chennai",50,30));
        tollGates.add(new TollGate(2,"Chengalpattu",40,25));
        tollGates.add(new TollGate(3,"Villupuram",60,35));
        tollGates.add(new TollGate(4,"Salem",70,40));
        tollGates.add(new TollGate(5,"Coimbatore",80,50));
      }

    public TollGate getTollGateByLocation(String location)
	 {
          for(TollGate tollGate : tollGates) 
	   {
             if(tollGate.getLocation().equalsIgnoreCase(location))
	    {
                return tollGate;
            }
        }
        return null;
    }

  public void calculateJourneyFare(Vehicle vehicle, String start, String destination)
     {
        boolean startFound=false;
        double totalFare=0;
        StringBuilder journey=new StringBuilder();
        boolean reverseDirection=false;    
        int startIdx=-1,destIdx =-1;
        for(int i=0;i<tollGates.size();i++)
	 {
            if(tollGates.get(i).getLocation().equalsIgnoreCase(start)) 
	     {
                startIdx = i;
             }
            if(tollGates.get(i).getLocation().equalsIgnoreCase(destination))
	    {
                destIdx = i;
            }
        }

        if(startIdx>destIdx) 
	{
            reverseDirection = true;
        }
        
        if(reverseDirection) 
	{
            for(int i=tollGates.size()-1;i>=0;i--)
	     {
                TollGate tollGate = tollGates.get(i);
                if(tollGate.getLocation().equalsIgnoreCase(start))
		 {
                    startFound=true;
                }

                if (startFound)
		 {
                    double fare = vehicle.getType().equalsIgnoreCase("car") ? tollGate.getCarFare() : tollGate.getTwoWheelerFare();
                    totalFare += fare;
                    tollGate.addVehicle(vehicle, fare);
                    journey.append(tollGate.getLocation()).append(" ");
                }

                if (tollGate.getLocation().equalsIgnoreCase(destination))
		 {
                    break;
                }
            }
        } 
	else
	 {
            for(TollGate tollGate : tollGates)
		 {
                if(tollGate.getLocation().equalsIgnoreCase(start))
	        {
                    startFound=true;
                }

                if (startFound) 
		{
                    double fare = vehicle.getType().equalsIgnoreCase("car") ? tollGate.getCarFare() : tollGate.getTwoWheelerFare();
                    totalFare += fare;
                    tollGate.addVehicle(vehicle, fare);
                    journey.append(tollGate.getLocation()).append(" ");
                }

                if (tollGate.getLocation().equalsIgnoreCase(destination)) 
		{
                    break;
                }
            }
        }

        if(vehicle.isVIP()) 
	{
            totalFare *= 0.8;
        }

        vehicle.addAmountPaid(totalFare);
        vehicle.addJourneyDetail("From " + start + " to " + destination + ": " + totalFare);
        System.out.println("------Amount Calculated------");
        System.out.println("From " + start + " to " + destination + ": " + totalFare);
    }

    public void displayTollDetails() 
	{
        for(TollGate tollGate : tollGates)
	  {
            System.out.println("Toll Location: "+tollGate.getLocation());
            System.out.println("Total Collected: "+tollGate.getTotalCollected());
            System.out.println("---Vehicles Passed---");
            for (Vehicle vehicle : tollGate.getPassedVehicles())
	     {
                System.out.println("-> "+vehicle.getVehicleNumber()+": "+vehicle.getAmountPaid());
                System.out.println("-------------------");
            }
            System.out.println();
        }
    }

    public void displayVehicleDetails(Vehicle vehicle) 
      {
        System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
        System.out.println("Total Amount Paid: " + vehicle.getAmountPaid());
        System.out.println("Journey Details: ");
        for(String journey : vehicle.getJourneyDetails())
	 {
            System.out.println("-> "+journey);
         }
        System.out.println();
    }
}

public class TollGateApplicationss 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        TollGateSystem tollGateSystem = new TollGateSystem();
        List<Vehicle> vehicles = new ArrayList<>();
        while (true)
	 {
            System.out.println("Choose an option:");
            System.out.println("1. Calculate fare for a journey");
            System.out.println("2. Display toll details");
            System.out.println("3. Display vehicle details");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice)
	     {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String vehicleNumber = sc.nextLine();
                    System.out.print("Enter vehicle type(car or twowheeler): ");
                    String type = sc.nextLine();
                    System.out.print("Enter current location: ");
                    String currentLocation=sc.nextLine();
                    System.out.print("Is the vehicle VIP (true/false): ");
                    boolean isVIP = sc.nextBoolean();
                    sc.nextLine();
                    Vehicle vehicle = null;
                    for(Vehicle v:vehicles)
			 {
                        if(v.getVehicleNumber().equalsIgnoreCase(vehicleNumber))
			  {
                            vehicle=v;
                            break;
                          }
                        }
                    if(vehicle==null) 
		    {
                        vehicle = new Vehicle(vehicleNumber,type,currentLocation,isVIP);
                        vehicles.add(vehicle);
                    } 
	          else 
		    {
                        vehicle.setCurrentLocation(currentLocation);
                    }
                    System.out.print("Enter start location: ");
                    String start = sc.nextLine();
                    System.out.print("Enter destination location: ");
                    String destination = sc.nextLine();
                    tollGateSystem.calculateJourneyFare(vehicle, start, destination);
                    break;

                case 2:
                    tollGateSystem.displayTollDetails();
                    break;

                case 3:
                    System.out.print("Enter vehicle number to display details: ");
                    String searchVehicleNumber = sc.nextLine();
                    Vehicle searchVehicle = null;

                    for(Vehicle v : vehicles)
		      {
                        if (v.getVehicleNumber().equalsIgnoreCase(searchVehicleNumber)) 
			{
                            searchVehicle = v;
                            break;
                        }
                    }

                    if(searchVehicle == null) 
			{
                        System.out.println("No vehicle data available for the given vehicle number.");
                    } 
		   else
			{
                        tollGateSystem.displayVehicleDetails(searchVehicle);
                    }
                    break;

                case 4:
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
