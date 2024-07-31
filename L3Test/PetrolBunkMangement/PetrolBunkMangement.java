import java.util.*;


class PetrolBunk
{
    int id;
    String name;
    int petrolPrice;
    int dieselPrice;
    int petrolCapacity;
    int dieselCapacity;
    int petrolHolding;
    int dieselHolding;
    int totalAmount;
    List<Vehicle>details=new ArrayList<>();

     public PetrolBunk(int id,String name,int petrolPrice,int dieselPrice,int petrolCapacity,int dieselCapacity)
       {
 	  this.id=id;
	  this.name=name;
	  this.petrolPrice=petrolPrice;
    	  this.dieselPrice=dieselPrice;
    	  this.petrolCapacity=petrolCapacity;
    	  this.dieselCapacity=dieselCapacity;
	  this.petrolHolding = petrolCapacity;
          this.dieselHolding = dieselCapacity;
    	  this.totalAmount=totalAmount=0;
       } 
   public int getId()
	{
	   return id;
	}
   public String getName()
	{
	   return name;
	}
   public int getPetrolPrice()
	{
	   return petrolPrice;
	}
   public int getDieselPrice()
	{
	   return dieselPrice;
	}

  public int getPetrolCapacity()
	{
	   return petrolCapacity;
	}
   public int getDieselCapacity()
	{
	   return dieselCapacity;
	}

   public int getTotalAmount()
	{
	   return totalAmount;
	}

   public void addVehicleDetails( Vehicle vehicle)
     {
	boolean vehicleExsist=false;
  	for(Vehicle v : details)
	{
	  if(v.vehicleNumber.equalsIgnoreCase(vehicle.vehicleNumber))
	    {
		v.numberOfLiter+=vehicle.numberOfLiter;
		v.amount+=vehicle.amount;
	  	v.dateTime=vehicle.dateTime;
		vehicleExsist=true;
		break;
	    }
	}
       if(!vehicleExsist)
	{
	  details.add(vehicle);
	}
	
     }

   public List<Vehicle> getVehicleDetails()
     {
	return details;
     }

  public int getPetrolHolding() {
        return petrolHolding;
    }

    public int getDieselHolding() {
        return dieselHolding;
    }


    public void setPetrolPrice(int price)
	{
	    petrolPrice=price;
	}

   public void setDieselPrice(int price)
	{
	    dieselPrice=price;
	}
  public void setPetrolCapacity(int capacity)
	{
	    petrolHolding+=capacity;
	}

   public void setDieselCapacity(int capacity)
	{
	    dieselHolding+=capacity;
	}

   public void addTotalAmount(int amount)
	{
	   totalAmount+=amount;
	}

   public void refill() 
    {
        this.petrolHolding=this.petrolCapacity;
        this.dieselHolding=this.dieselCapacity;
    }

  
}

class Vehicle
{
    String fuelType;
    String vehicleType;
    String vehicleNumber;
    int numberOfLiter;
    int amount;
    String dateTime;
    
    public Vehicle(String fuelType,String vehicleType,String vehicleNumber,int numberOfLiter,int amount, String dateTime)
 	{
	   this.fuelType=fuelType;
	   this.vehicleType=vehicleType;
	   this.vehicleNumber=vehicleNumber;
	   this.numberOfLiter=numberOfLiter;
           this.amount=amount;
	   this.dateTime=dateTime;
	}

	public String toString() 
     {
        return "Vehicle Type: "+vehicleType+ ", Vehicle Number: " + vehicleNumber + ", Fuel Type: " + fuelType + ", Number of Liters: " + numberOfLiter + ", Amount: " + amount + ", Date and Time: " + dateTime;
     }
	
}



public class PetrolBunkMangement
{
  static Scanner sc=new Scanner(System.in);
  PetrolBunk petrolBunk; 
  public void createPertrolBunk()
   {
	System.out.print("Enter the PetrolPrice: ");
	int petrol=sc.nextInt();
	System.out.print("Enter the DiselePrice: ");
	int diesel=sc.nextInt();
	System.out.print("Enter the PetrolCapacity in Liters: ");
	int petrolcap=sc.nextInt();
	System.out.print("Enter the DieselCapacity in Liters: ");
	int dieselcap=sc.nextInt();
	petrolBunk=new PetrolBunk(101,"INDIAN OIL",petrol,diesel,petrolcap,dieselcap);
	System.out.println("PETROL BUNK CREATED");
	System.out.println();
        System.out.println("Created Bunk with PB-"+petrolBunk.getId()+" with "+petrolcap+" litre of petrol and "+dieselcap+" litre of diesel capacity");
	System.out.println();
	System.out.println();
   }
 
 public void showCapasity()
  {
   if(petrolBunk!=null)
	{
          System.out.println("Price of Petrol: "+petrolBunk.getPetrolCapacity());
          System.out.println("Price of Diesel: "+petrolBunk.getDieselCapacity());
	  System.out.println();
	}
    else
      {
	System.out.println("No PetrolBunk is Not Created");
	System.out.println();
      }
  }


 public void showRevenue()
 {
     if(petrolBunk != null)
	 {
            int petrolRevenue = 0;
            int dieselRevenue = 0;
            for(Vehicle v : petrolBunk.getVehicleDetails()) 
		{
                  if(v.fuelType.equalsIgnoreCase("Petrol"))
		 {
                    petrolRevenue += v.amount;
                 }
		 else if(v.fuelType.equalsIgnoreCase("Diesel"))
		 {
                    dieselRevenue += v.amount;
                 }
            }
            System.out.println("PB-" +petrolBunk.getId()+" revenue from PETROL sales: "+petrolRevenue+" from DIESEL sales: "+dieselRevenue);
	    System.out.println();
        } 
      else
	 {
            System.out.println("Petrol Bunk is not created yet.");
	    System.out.println();
         }
    }


 public void showCurrentHolding()
   {
        if(petrolBunk != null)
	 {
            System.out.println("PB-"+petrolBunk.getId()+" current_holding PETROL: "+petrolBunk.getPetrolHolding()+" DIESEL: "+petrolBunk.getDieselHolding());
		System.out.println();
         }
	 else
	 {
            System.out.println("Petrol Bunk is not created yet");
	    System.out.println();
         }
    }


 public void fillFuel(String fuelType, String regNo, String vehicleType, int numberOfLiters) 
     {
         if(petrolBunk != null)
	  {
             int amount=0;
             String dateTime=new Date().toString();
             if(fuelType.equalsIgnoreCase("petrol"))
	      {
                 if(petrolBunk.getPetrolHolding() >= numberOfLiters)
		 {
                    amount=numberOfLiters*petrolBunk.getPetrolPrice();
                    petrolBunk.petrolHolding -= numberOfLiters;
                    petrolBunk.addTotalAmount((int) amount);
                    Vehicle vehicle = new Vehicle(fuelType,vehicleType,regNo,numberOfLiters,amount,dateTime);
                    petrolBunk.addVehicleDetails(vehicle);
		    System.out.println("----PETROL FILLED----");
                    System.out.println("Filled " +numberOfLiters+ " litre of PETROL for "+regNo+" : "+amount);
		    System.out.println();
                 } 
		else
		 {
                    System.out.println("Not enough PETROL to fill at the moment kindly revisit.");
		    System.out.println();
                 }
              }

 	     else if(fuelType.equalsIgnoreCase("Diesel"))
		 {
                   if(petrolBunk.getDieselHolding() >= numberOfLiters)
		    {
                      amount = numberOfLiters * petrolBunk.getDieselPrice();
                      petrolBunk.dieselHolding -= numberOfLiters;
                      petrolBunk.addTotalAmount((int) amount);
                      Vehicle vehicle = new Vehicle(fuelType, vehicleType, regNo, numberOfLiters, amount, dateTime);
                      petrolBunk.addVehicleDetails(vehicle);
		      System.out.println("-----DIESEL FILLED----");
                      System.out.println("Filled " + numberOfLiters + " litre of DIESEL for " + regNo + " : " + amount);
                    }
		   else
		    {
                      System.out.println("Not enough DIESEL to fill at the moment kindly revisit.");
			System.out.println();
                    }
            	}
	    else
		{
		    System.out.println("Invalid Fuel Type");
		}
           } 
       else
	 {
            System.out.println("Petrol Bunk is not created yet.");
		System.out.println();
         }
    }


public void filterVehicleDetails(String vehicleType, int litre)
  {
      if(petrolBunk != null)
	 {
            List<Vehicle> filteredVehicles = new ArrayList<>();
            for(Vehicle vehicle : petrolBunk.getVehicleDetails()) 
		{
                   if(vehicle.vehicleType.equalsIgnoreCase(vehicleType) && vehicle.numberOfLiter > litre)
		   {
                     filteredVehicles.add(vehicle);
                   }
                }
            if(filteredVehicles.size()>0)
	     {
                System.out.println("Data Fetch successful.");
                for(Vehicle vehicle : filteredVehicles)
		 {
                    System.out.println(vehicle);
		    System.out.println();
                 }
            } 
	   else
	     {
                System.out.println("No results for the filter.");
		System.out.println();
             }
        } 
 else
    {
       System.out.println("Petrol Bunk is not created yet.");
	System.out.println();
    }
 }



public void display()
{
  if(petrolBunk != null)
   {
     sc.nextLine();
     System.out.println("Enter your Vehicle Number");
     String tnNumber=sc.nextLine();
     boolean visited=false;
     List<Vehicle> arr=new ArrayList<>();
     for(Vehicle v : petrolBunk.getVehicleDetails())
      {
	 if(v.vehicleNumber.equalsIgnoreCase(tnNumber))
	 {
	    visited=true;
	    arr.add(v);
	    break;
	 }
      }
    if(!visited)
	{
	   System.out.println("Vehicle is Not Registered Yet");
	   System.out.println();
	}
     else
	{
	  System.out.println("Found: "+tnNumber);
	  for(Vehicle v : arr)
	   {
		System.out.println(v);
		System.out.println();
	   }
	}
   }
   else
    {
	System.out.println("Bunk is Not Created");
	System.out.println();
    }
}

public void alterPrice()
{
  if(petrolBunk != null)
   {
	System.out.print("Enter the Petrol Price to get Altered: ");
	int petrolNewPrice=sc.nextInt();
	System.out.print("Enter the Diesel Price to get Altered: ");
	int dieselNewPrice=sc.nextInt();
	petrolBunk.setPetrolPrice(petrolNewPrice);
   	petrolBunk.setDieselPrice(dieselNewPrice);
	System.out.println("New Petrol Price: "+petrolBunk.getPetrolPrice());
	System.out.println("New Diesel Price: "+petrolBunk.getDieselPrice());
	System.out.println();
	System.out.println();

   }
   else
   {
     System.out.println("-------Bunk is Not Created------");
	System.out.println();
   }
}

public void alterCapacity()
{
  if(petrolBunk != null)
   {
	System.out.print("Enter the Petrol Capacity to get Altered: ");
	int petrolNewCapacity=sc.nextInt();
	System.out.print("Enter the Diesel Capasity to get Altered: ");
	int dieselNewCapacity=sc.nextInt();
	petrolBunk.setPetrolCapacity(petrolNewCapacity);
   	petrolBunk.setDieselCapacity(dieselNewCapacity);

	System.out.println("New Petrol Price: "+petrolBunk.getPetrolHolding());
	System.out.println("New Diesel Price: "+petrolBunk.getDieselHolding());
	System.out.println();
	System.out.println();

   }
   else
   {
     System.out.println("-------Bunk is Not Created------");
	System.out.println();
   }
}

public static void main(String args[])
{
   PetrolBunkMangement petrolbunkmangement=new PetrolBunkMangement();
   boolean validate=true;
   while(validate)
    {
 	System.out.println("----------------Enter Your Choice------------------");
	System.out.println("1.Create a Petrol bunk.");
        System.out.println("2.View the capacity of the Petrol bunk.(Petrol Capacity, Diesel Capacity");
	System.out.println("3.View the current revenue earned");
	System.out.println("4.View the current holding of Petrol/Diesel in the bunk");
	System.out.println("5.Fill Petrol/Diesel to a vehicle and stores the details");
	System.out.println("6.Filter and display the Vehicle details based on the vehicle type and fuel filled");
	System.out.println("7.Find the details of a particular vehicle with the REGNO");
	System.out.println("8.Alter the Petrol/Diesel price");
	System.out.println("9.Add Petrol/Diesel to the existing holding");
	System.out.println("10.EXIT");
	int choice=sc.nextInt();
	System.out.println();
	switch(choice)
	  {
		case 1:
 			petrolbunkmangement.createPertrolBunk();
			break;

		case 2:
			petrolbunkmangement.showCapasity();
			break;

		case 3:
			petrolbunkmangement.showRevenue();
			break;

		case 4:
			petrolbunkmangement.showCurrentHolding();
			break;

		case 5:
			System.out.print("Enter fuel type: ");
                        String fuelType=sc.next();
                        System.out.print("Enter vehicle reg no: ");
                        String regNo=sc.next();
                        System.out.print("Enter vehicle type: ");
                        String vehicleType=sc.next();
                        System.out.print("Enter number of litres: ");
                        int numberOfLitre=sc.nextInt();
                        petrolbunkmangement.fillFuel(fuelType,regNo,vehicleType,numberOfLitre);
			break;

		case 6:
			sc.nextLine();
                        System.out.print("Enter the vehicle_type: ");
                        String filterInput1=sc.nextLine();
			System.out.print("Enter the fuelLimit: ");
                        int filterInput2=sc.nextInt();
			petrolbunkmangement.filterVehicleDetails(filterInput1,filterInput2);
			break;
		
		case 7:
			petrolbunkmangement.display();
			break;

		case 8:
			petrolbunkmangement.alterPrice();

			break;

		case 9:
			petrolbunkmangement.alterCapacity();
			break;

		case 10:
			System.out.println("------Exiting the Console------");
			System.out.println("--------------------------------------");
			validate=false;
			break;

		default:
			System.out.println("Invalid Choice");
			System.out.println("--------------------------------------");
			break;
	  }
    }
}
}