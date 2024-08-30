import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    private static final String DB_URL = "jdbc:mysql://localhost:3306/RailwayDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root19"; 

    private static Connection getConnection() 
	{
        Connection connection = null;
        try 
		{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
		
		catch (SQLException e)
		{
            e.printStackTrace();
        }
        return connection;
    }

    private void savePassengerToDatabase(Train train) 
	{
        String query = "INSERT INTO passengers (pnr, berth_no, status, berth_type, name, age) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query))
		{

            preparedStatement.setInt(1, train.pnr);
            preparedStatement.setInt(2, train.berthNo);
            preparedStatement.setString(3, train.currentStatus);
            preparedStatement.setString(4, train.berthType);
            preparedStatement.setString(5, train.name);
            preparedStatement.setInt(6, train.age);

            preparedStatement.executeUpdate();
            System.out.println("Passenger details saved to the database.");
        }
		catch(SQLException e)
		{
            e.printStackTrace();
        }
    }


    private void deletePassengerFromDatabase(int pnr)
	{
        String query = "DELETE FROM passengers WHERE pnr = ?";
        try(Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) 
		{

            preparedStatement.setInt(1, pnr);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Passenger details deleted from the database.");
            } else {
                System.out.println("No record found with the given PNR.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initializeCoach() {
        Train train;
        int berthNo = 0;
        int racCount = 0;
        String str;

        for (int i = 1; i <= 18; i++) {
            if (i != 8 && i != 17) {
                berthNo++;
            }

            if (berthNo == 7 || berthNo == 15) {
                racCount++;
                str = "RAC" + racCount;
            } else {
                str = "AVL";
            }

            train = new Train(0, berthNo, str, seats[(berthNo - 1) % 8], " ", 0);
            coach.add(train);
        }
        train = new Train(0, 0, "WL1", "-", " ", 0);
        coach.add(train);
        train = new Train(0, 0, "WL2", "-", " ", 0);
        coach.add(train);
        displayCoach();
    }

    public void bookTicket() {
        sc.nextLine();
        System.out.print("Enter your Name: ");
        String passengerName = sc.nextLine();
        System.out.print("Enter your Age: ");
        int passengerAge = sc.nextInt();

        if (passengerAge <= 6) {
            System.out.println("Booking Ticket is Not possible Because Age is less than 6");
            return;
        }

        System.out.print("Need Berth Preference(yes/no): ");
        sc.nextLine();
        String preference = sc.nextLine();

        if (preference.equalsIgnoreCase("yes")) {
            System.out.print("Enter your Preference:{LB, MB, UB, LB, MB, UB, SL, SU}: ");
            String berth = sc.nextLine();
            Train availableBerth = null;
            for (Train train : coach) {
                if (train.berthType.equalsIgnoreCase(berth) && train.currentStatus.equals("AVL")) {
                    train.name = passengerName;
                    train.age = passengerAge;
                    train.currentStatus = "CNF";
                    Random random = new Random();
                    int pnrPassenger = 1000000 + random.nextInt(900000);
                    train.pnr = pnrPassenger;
                    availableBerth = train;
                    savePassengerToDatabase(train); // Save to database
                    break;
                }
            }

            if (availableBerth != null) {
                System.out.println("Ticket Booked Successfully");
                displayCoach();
                return;
            } else {
                System.out.println("---------Your Preference Berth Seat is Not Available----- ");
                System.out.println("Press 1 to Book any BerthSeats");
                System.out.println("Press 0 to Exit");
                int value = sc.nextInt();
                if (value == 1) {
                    bookTicketWithoutPreference(passengerName, passengerAge);
                } else {
                    System.out.println("LEAVING THE CONSOLE");
                    return;
                }
            }

        } else {
            bookTicketWithoutPreference(passengerName, passengerAge);
        }
    }

    public void bookGroupTicket() {
        sc.nextLine();
        System.out.print("Enter the number of passengers: ");
        int numPassengers = sc.nextInt();
        sc.nextLine();
        List<String> names = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();
        List<String> preferences = new ArrayList<>();

        for (int i = 0; i < numPassengers; i++) {
            System.out.print("Enter Name of Passenger " + (i + 1) + ": ");
            names.add(sc.nextLine());
            System.out.print("Enter Age of Passenger " + (i + 1) + ": ");
            ages.add(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Berth Preference of Passenger " + (i + 1) + "{LB, MB, UB, SL, SU}: ");
            preferences.add(sc.nextLine());
        }

        List<Train> allocatedBerths = new ArrayList<>();
        Random random = new Random();
        int pnrPassenger = 1000000 + random.nextInt(900000);

        for (int i = 0; i < numPassengers; i++) {
            for (Train train : coach) {
                if (train.currentStatus.equals("AVL") && train.berthType.equalsIgnoreCase(preferences.get(i))) {
                    train.name = names.get(i);
                    train.age = ages.get(i);
                    train.currentStatus = "CNF";
                    train.pnr = pnrPassenger;
                    allocatedBerths.add(train);
                    savePassengerToDatabase(train); // Save to database
                    break;
                }
            }
        }

        if (allocatedBerths.size() < numPassengers) {
            for (int i = allocatedBerths.size(); i < numPassengers; i++) {
                boolean allocated = false;
                for (Train train : coach) {
                    if (train.currentStatus.equals("AVL") && !allocatedBerths.contains(train)) {
                        train.name = names.get(i);
                        train.age = ages.get(i);
                        train.currentStatus = "CNF";
                        train.pnr = pnrPassenger;
                        allocatedBerths.add(train);
                        savePassengerToDatabase(train); // Save to database
                        allocated = true;
                        break;
                    }
                }

                if (!allocated) {
                    System.out.println("Not enough available berths to accommodate the group.");
                    allocateRACOrWL(pnrPassenger, names, ages, allocatedBerths, i);
                    return;
                }
            }
        }
        System.out.println("Group Tickets Booked Successfully");
        displayCoach();
    }

    public void allocateRACOrWL(int pnrPassenger, List<String> names, List<Integer> ages, List<Train> allocatedBerths, int startIndex) {
        for (int i = startIndex; i < names.size(); i++) {
            boolean allocated = false;
            for (Train train : coach) {
                if (train.currentStatus.startsWith("RAC") && !allocatedBerths.contains(train)) {
                    train.name = names.get(i);
                    train.age = ages.get(i);
                    train.currentStatus = "RAC";
                    train.pnr = pnrPassenger;
                    allocatedBerths.add(train);
                    savePassengerToDatabase(train); // Save to database
                    allocated = true;
                    break;
                }
            }

            if (!allocated) {
                for (Train train : coach) {
                    if (train.currentStatus.startsWith("WL") && !allocatedBerths.contains(train)) {
                        train.name = names.get(i);
                        train.age = ages.get(i);
                        train.currentStatus = "WL";
                        train.pnr = pnrPassenger;
                        allocatedBerths.add(train);
                        savePassengerToDatabase(train); // Save to database
                        break;
                    }
                }
            }
        }
    }

    public void bookTicketWithoutPreference(String passengerName, int passengerAge) {
        Train availableBerth = null;

        for (Train train : coach) {
            if (train.currentStatus.equals("AVL")) {
                train.name = passengerName;
                train.age = passengerAge;
                train.currentStatus = "CNF";
                Random random = new Random();
                int pnrPassenger = 1000000 + random.nextInt(900000);
                train.pnr = pnrPassenger;
                availableBerth = train;
                savePassengerToDatabase(train); // Save to database
                break;
            }
        }

        if (availableBerth != null) {
            System.out.println("Ticket Booked Successfully");
            displayCoach();
            return;
        } else {
            bookRACOrWL(passengerName, passengerAge);
        }
    }

    public void bookRACOrWL(String passengerName, int passengerAge) {
        Train racOrWlBerth = null;

        for (Train train : coach) {
            if (train.currentStatus.startsWith("RAC") || train.currentStatus.startsWith("WL")) {
                train.name = passengerName;
                train.age = passengerAge;
                Random random = new Random();
                int pnrPassenger = 1000000 + random.nextInt(900000);
                train.pnr = pnrPassenger;
                racOrWlBerth = train;
                savePassengerToDatabase(train); // Save to database
                break;
            }
        }

        if (racOrWlBerth != null) {
            System.out.println("RAC/WL Ticket Booked Successfully");
            displayCoach();
            return;
        } else {
            System.out.println("No Available Tickets");
        }
    }

    public void cancelTicket() {
        System.out.print("Enter PNR Number to Cancel: ");
        int pnrValue = sc.nextInt();
        boolean flag = false;
        Train cancelledTrain = null;

        for (Train train : coach) {
            if (train.pnr == pnrValue) {
                flag = true;
                cancelledTrain = train;
                break;
            }
        }

        if (flag && cancelledTrain != null) {
            cancelledTrain.pnr = 0;
            cancelledTrain.currentStatus = "AVL";
            cancelledTrain.name = " ";
            cancelledTrain.age = 0;
            shiftRACAndWL();
            deletePassengerFromDatabase(pnrValue); // Remove from database
            System.out.println("Ticket is Canceled With the PNR Number you Provided");
            displayCoach();
        } else {
            System.out.println("PNR Number Not Found");
        }
    }

    public void shiftRACAndWL() {
        for (int i = 0; i < coach.size(); i++) {
            Train currentTrain = coach.get(i);

            if (currentTrain.currentStatus.equals("AVL")) {
                for (int j = i + 1; j < coach.size(); j++) {
                    Train racOrWlTrain = coach.get(j);

                    if (racOrWlTrain.currentStatus.startsWith("RAC") || racOrWlTrain.currentStatus.startsWith("WL")) {
                        currentTrain.pnr = racOrWlTrain.pnr;
                        currentTrain.currentStatus = "CNF";
                        currentTrain.name = racOrWlTrain.name;
                        currentTrain.age = racOrWlTrain.age;

                        racOrWlTrain.pnr = 0;
                        if (racOrWlTrain.currentStatus.startsWith("RAC")) {
                            racOrWlTrain.currentStatus = "WL" + (Integer.parseInt(racOrWlTrain.currentStatus.substring(3)) - 1);
                        } else {
                            racOrWlTrain.currentStatus = "AVL";
                            racOrWlTrain.name = " ";
                            racOrWlTrain.age = 0;
                        }
                        break;
                    }
                }
            }
        }
    }

    public void displayCoach() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Berth No | PNR Number | Current Status | Berth Type | Name	      | Age");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (Train train : coach) {
            System.out.printf("%8d | %10d | %14s | %10s | %15s | %3d\n",
                    train.berthNo, train.pnr, train.currentStatus, train.berthType, train.name, train.age);
        }
        System.out.println("--------------------------------------------------------------------------------");
		
    }

    public static void main(String[] args) {
        RailwayTicketBooking bookingSystem = new RailwayTicketBooking();
        bookingSystem.initializeCoach();
        boolean exit = false;

        while (!exit) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Railway Ticket Booking System");
            System.out.println("1. Book Ticket");
            System.out.println("2. Book Group Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.println("----------------------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) 
			{
                case 1:
                    bookingSystem.bookTicket();
                    break;
                case 2:
                    bookingSystem.bookGroupTicket();
                    break;
                case 3:
                    bookingSystem.cancelTicket();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
