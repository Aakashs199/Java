import java.util.*;
import java.util.LinkedHashMap; 
import java.util.Map; 
import java.util.Set; 
import java.util.HashMap;
import java.util.Map.Entry;
class Passenger 
{
	private static int idProvider = 0;
	private int id;
	private String name;
	private int age;
	private char preference;
	private String ticketType;
	private int seatNumber;

	public Passenger(String name, int age, char preference) {
		this.id = ++idProvider;
		this.name = name;
		this.age = age;
		this.preference = preference;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Passenger.idProvider = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getPreference() {
		return preference;
	}

	public void setPreference(char preference) {
		this.preference = preference;
	}
	
	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Passenger Ticket id : "+id+"\nPassenger name : " + name 
				+ "\nPassenger age : " + age +"\nPassenger Seat no : "+seatNumber+
				"\nPassenger preference : " + preference;
	}
}



class TicketBooking 
{	
	private static int berthLimit = 6/3;
	private static int racLimit = 1;
	private static int waitingListLimit = 1;
	
	private static int upperSeatNumber = 1;
	private static int middleSeatNumber = 2;
	private static int lowerSeatNumber = 3;
	
	static ArrayList<Passenger> confirmedList = new ArrayList<Passenger>();
	
	static ArrayList<Passenger> upperList = new ArrayList<Passenger>();
	static ArrayList<Passenger> middleList = new ArrayList<Passenger>();
	static ArrayList<Passenger> lowerList = new ArrayList<Passenger>();
	
	
	static Queue<Passenger> racQueue = new LinkedList<Passenger>();
	static Queue<Passenger> waitingQueue = new LinkedList<Passenger>();
	
	public static void bookTicket(Passenger p)
	{
		if(upperList.size() == berthLimit && lowerList.size() == berthLimit && middleList.size() == berthLimit)
		{
			if(updateRacQueue(p))
			{
				System.out.println("Added to RAC\nYour ticket id is "+p.getId());
			}
			else if(updateWaitingQueue(p))
			{
				System.out.println("Added to Waiting List\nYour ticket id is "+p.getId());			
			}
			else
			{
				p.setId(p.getId()-1); 
				System.out.println("Tickets not available");
			}
		}
		else if(checkAvailability(p))
		{
			System.out.println("Booking confirmed\nYour ticket id is "+p.getId());
			p.setTicketType("berth");
			confirmedList.add(p);
		}
		else
		{
			System.out.println(p.getPreference()+" is not available");
			p.setId(p.getId()-1);
			availableList();
		}
	}

	private static boolean updateWaitingQueue(Passenger p) {
		
		if(waitingQueue.size()<waitingListLimit) {
			p.setTicketType("waitingList");
			waitingQueue.add(p);
			return true;
		}
		
		return false;
	}

	private static boolean updateRacQueue(Passenger p) {
		
		if(racQueue.size()<racLimit) {
			p.setTicketType("rac");
			racQueue.add(p);
			return true;
		}
		
		return false;
	}

	private static void availableList() {
		System.out.println("Check out the no of seats available");
		System.out.println("Upper Berth "+(berthLimit - upperList.size()));
		System.out.println("Middle Berth "+(berthLimit - middleList.size()));
		System.out.println("Lower Berth "+(berthLimit - lowerList.size()));
	}

	private static boolean checkAvailability(Passenger p) 
	{
		Map<Integer,Character> map = TicketCanceling.getSeatNumberWithBerth();
		
		if(p.getPreference()=='U') {
			if(upperList.size()<berthLimit)
			{
				if(!map.isEmpty())
				{
					getSeatDetails(map, p);
				}
				else
				{
					p.setSeatNumber(upperSeatNumber);
					upperSeatNumber+=3; 
				}
			
				upperList.add(p);
				return true;
			}
		}
		else if (p.getPreference()=='M') {
			if(middleList.size()<berthLimit)
			{
				if(!map.isEmpty())
				{
					getSeatDetails(map, p);
				}
				else
				{
					p.setSeatNumber(middleSeatNumber);
					middleSeatNumber+=3;
				}
			
				middleList.add(p);
				return true;
			}
		}
		else {
			if(lowerList.size()<berthLimit)
			{
				if(!map.isEmpty())
				{
					getSeatDetails(map, p);
				}
				else
				{
					p.setSeatNumber(lowerSeatNumber);
					lowerSeatNumber+=3;
				}
		
				lowerList.add(p);
				return true;
			}
		}
		
		return false;
	}

	public static void getSeatDetails(Map<Integer,Character> map,Passenger p)
	{
		int seatNumber = checkForPreferenceAvailability(map,p.getPreference());
		p.setSeatNumber(seatNumber);
		map.remove(seatNumber);
	}
	
	public static int checkForPreferenceAvailability(Map<Integer,Character> map,char preference)
	{
		int seatNumber = 0;
		
		for(Entry<Integer,Character> entry : map.entrySet())
		{
			if(preference == (char)entry.getValue())
			{
				seatNumber = (int)entry.getKey();
				break;
			}
		}
		return seatNumber;
	}
	
	public static void displayConfirmed()
	{
		System.out.println("-------------------------");
		for(Passenger p : confirmedList)
		{
			System.out.println(p.toString());
			System.out.println("-------------------------");
		}
	}
	
	public static void displayRAC()
	{
		System.out.println("-------------------------");
		for(Passenger p : racQueue)
		{
			System.out.println(p.toString());
			System.out.println("-------------------------");
		}
	}
	public static void displayWaiting()
	{
		System.out.println("-------------------------");
		for(Passenger p : waitingQueue)
		{
			System.out.println(p.toString());
			System.out.println("-------------------------");
		}
	}
}

class TicketCanceling extends TicketBooking
{
	//Only for RAC
	private static char preferenceTracker = '\0';
	private static int canceledSeatNumber = 0;
	
	private static Map<Integer,Character> seatNumberWithBerth = new HashMap<Integer,Character>();
	
	public static String canceling(int id)
	{
		for(Passenger p : confirmedList)
		{
			if(p.getId() == id) {
				cancel(p);
				return "Success";
			}
		}
		
		for(Passenger p : racQueue)
		{
			if(p.getId() == id) {
				cancel(p);
				return "Success";
			}
		}
		
		for(Passenger p : waitingQueue)
		{
			if(p.getId() == id) {
				cancel(p);
				return "Success";
			}
		}
		
		return "Invalid Id";
	}

	private static void cancel(Passenger p) 
	{
		if(p.getTicketType() == "berth")
		{
			//Only for RAC
			preferenceTracker = p.getPreference();
			canceledSeatNumber = p.getSeatNumber();
			//Map for reference in future
			seatNumberWithBerth.put(canceledSeatNumber,preferenceTracker);
			
			deleteFromAllLists(p);
			addRacToBerth(racQueue.poll());
			addWaitingToRac(waitingQueue.poll());
		}
		else if(p.getTicketType() == "rac")
		{
			racQueue.remove(p);
			addWaitingToRac(waitingQueue.poll());
		}
		else
		{
			waitingQueue.remove(p);
		}
	}

	private static void addWaitingToRac(Passenger p) {
		
		if(p!=null)
		{
			p.setTicketType("rac");
			racQueue.add(p);
		}
	}

	private static void addRacToBerth(Passenger p) {
		
		if(p!=null)
		{
			p.setPreference(preferenceTracker);
			p.setSeatNumber(canceledSeatNumber);
			p.setTicketType("berth");
			
			if(preferenceTracker == 'U') {
				upperList.add(p);
			}
			else if (preferenceTracker == 'M') {
				middleList.add(p);
			}
			else {
				lowerList.add(p);
			}
			
			confirmedList.add(p);
			seatNumberWithBerth.remove(canceledSeatNumber);
			preferenceTracker = '\0';
			canceledSeatNumber = 0;
		}
	}

	private static void deleteFromAllLists(Passenger p) {

		confirmedList.remove(p);
		upperList.remove(p);
		lowerList.remove(p);
		middleList.remove(p);
	}

	public static Map<Integer, Character> getSeatNumberWithBerth() {
		return seatNumberWithBerth;
	}

}





public class MainClass 
{
	public static void main(String[] args) 
	{
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("\nChoose any one \n 1.Book ticket \n 2.Cancel ticket"
					+ " \n 3.Display Confirmed list\n 4.Display RAC list"
					+ "\n 5.Display Waiting list\n 6.Exit");
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			
			switch(n)
			{
			case 1:
			{
				System.out.println("Enter name : ");
				String name = s.next();
				System.out.println("Enter age : ");
				int age = s.nextInt();
				System.out.println("Enter berth : ");
				char preference = s.next().charAt(0);
				if(preference == 'U' || preference == 'M' || preference == 'L')
					TicketBooking.bookTicket(new Passenger(name,age,preference));
				else
					System.out.println("Invalid berth");
				break;
			}
			
			case 2:
			{
				System.out.println("Enter your Ticket id : ");
				int id = s.nextInt();
				System.out.println(TicketCanceling.canceling(id));
				break;
			}
			
			case 3:
			{
				TicketBooking.displayConfirmed();
				break;
			}
			
			case 4:
			{
				TicketBooking.displayRAC();
				break;
			}
			
			case 5:
			{
				TicketBooking.displayWaiting();
				break;
			}
			
			case 6:
			{
				System.out.println("\tThank you!");
				s.close();
				loop=false;
				break;
			}
			}
		}
	}
}