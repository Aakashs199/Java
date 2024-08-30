import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
    double cost;

    public Train(int pnr, int berthNo, String currentStatus, String berthType, String name, int age, double cost) 
    {
        this.pnr = pnr;
        this.berthNo = berthNo;
        this.currentStatus = currentStatus;
        this.berthType = berthType;
        this.name = name;
        this.age = age;
        this.cost = cost;
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

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void savePassengerToDatabase(Train train) 
   {
        String query = "INSERT INTO current_passenger_details (pnr, berth_no, status, berth_type, name, age, cost, booking_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) 
	{

            preparedStatement.setInt(1, train.pnr);
            preparedStatement.setInt(2, train.berthNo);
            preparedStatement.setString(3, train.currentStatus);
            preparedStatement.setString(4, train.berthType);
            preparedStatement.setString(5, train.name);
            preparedStatement.setInt(6, train.age);
            preparedStatement.setDouble(7, train.cost);
            preparedStatement.setString(8, LocalDateTime.now().toString());

            preparedStatement.executeUpdate();
            System.out.println("Passenger details saved to the database.");
        }
	 catch (SQLException e) 
	{
            e.printStackTrace();
        }
    }

    private void deletePassengerFromDatabase(int pnr) {
        String query = "DELETE FROM current_passenger_details WHERE pnr = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

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

    private void updateRecDetails(int berthNo, String status) {
        String query = "INSERT INTO rec_details (berth_no, status, update_time) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, berthNo);
            preparedStatement.setString(2, status);
            preparedStatement.setString(3, LocalDateTime.now().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateWaitingListDetails(int berthNo, String status) {
        String query = "INSERT INTO waiting_list_details (berth_no, status, update_time) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, berthNo);
            preparedStatement.setString(2, status);
            preparedStatement.setString(3, LocalDateTime.now().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCancelDetails(int pnr, int berthNo, String status) {
        String query = "INSERT INTO cancel_details (pnr, berth_no, status, cancel_time) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, pnr);
            preparedStatement.setInt(2, berthNo);
            preparedStatement.setString(3, status);
            preparedStatement.setString(4, LocalDateTime.now().toString());

            preparedStatement.executeUpdate();
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
                str = "REC" + racCount;
            } else {
                str = "AVL";
            }

            double cost = getCostForBerthType(seats[(berthNo - 1) % 8]);
            train = new Train(0, berthNo, str, seats[(berthNo - 1) % 8], " ", 0, cost);
            coach.add(train);
        }
        train = new Train(0, 0, "WL1", "-", " ", 0, 0);
        coach.add(train);
        train = new Train(0, 0, "WL2", "-", " ", 0, 0);
        coach.add(train);
        displayCoach();
    }

    private double getCostForBerthType(String berthType)
 {
        switch (berthType) {
            case "LB":
                return 500;
            case "MB":
                return 400;
            case "UB":
                return 350;
            case "SL":
                return 300;
            case "SU":
                return 200;
            default:
                return 0;
        }
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
            System.out.print("Enter your Preference {LB, MB, UB, SL, SU}: ");
            String berth = sc.nextLine();
            Train availableBerth = bookAvailableSeat(passengerName, passengerAge, berth);

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

    private Train bookAvailableSeat(String name, int age, String berthType) {
        // Try to book AVL seat
        Train bookedBerth = bookSeatWithStatus(name, age, berthType, "AVL");
        if (bookedBerth != null) {
            return bookedBerth;
        }
        // If AVL seats are full, try REC seats
        bookedBerth = bookSeatWithStatus(name, age, berthType, "REC");
        if (bookedBerth != null) {
            return bookedBerth;
        }
        // If REC seats are full, book in WL
        return bookSeatWithStatus(name, age, "-", "WL");
    }

    private Train bookSeatWithStatus(String name, int age, String berthType, String status) {
        for (Train train : coach) {
            if (train.berthType.equalsIgnoreCase(berthType) && train.currentStatus.equals(status)) {
                train.name = name;
                train.age = age;
                train.currentStatus = "CNF";
                Random random = new Random();
                int pnrPassenger = 1000000 + random.nextInt(900000);
                train.pnr = pnrPassenger;
                savePassengerToDatabase(train); // Save to database
                return train;
            }
        }
        return null;
    }

    public void bookGroupTicket() {
        sc.nextLine();
        System.out.print("Enter Number of Passengers: ");
        int passengerCount = sc.nextInt();
        sc.nextLine();

        if (passengerCount > 6) {
            System.out.println("Booking for more than 6 Passengers is not allowed");
            return;
        }

        String[] passengerNames = new String[passengerCount];
        int[] passengerAges = new int[passengerCount];

        for (int i = 0; i < passengerCount; i++) {
            System.out.print("Enter Name for Passenger " + (i + 1) + ": ");
            passengerNames[i] = sc.nextLine();
            System.out.print("Enter Age for Passenger " + (i + 1) + ": ");
            passengerAges[i] = sc.nextInt();
            sc.nextLine();

            if (passengerAges[i] <= 6) {
                System.out.println("Booking Ticket is Not possible for Passenger " + passengerNames[i] + " Because Age is less than 6");
                return;
            }
        }

        for (int i = 0; i < passengerCount; i++) {
            String berthType = determineBerthType(passengerAges[i]);
            Train bookedBerth = bookAvailableSeat(passengerNames[i], passengerAges[i], berthType);

            if (bookedBerth == null) {
                System.out.println("Could not book ticket for " + passengerNames[i]);
            } else {
                System.out.println("Ticket booked for " + passengerNames[i]);
            }
        }

        displayCoach();
    }


	private void bookTicketWithoutPreference(String name, int age) {
        // Try to book an available seat (AVL)
        Train availableBerth = bookSeatWithStatus(name, age, "", "AVL");
        if (availableBerth != null) {
            System.out.println("Ticket Booked Successfully without preference");
            displayCoach();
            return;
        }
        
        // If no AVL seat is available, try to book a RAC (REC) seat
        availableBerth = bookSeatWithStatus(name, age, "", "REC");
        if (availableBerth != null) {
            System.out.println("RAC Ticket Booked Successfully");
            displayCoach();
            return;
        }
        
        // If no REC seat is available, book a Waiting List (WL) ticket
        availableBerth = bookSeatWithStatus(name, age, "-", "WL");
        if (availableBerth != null) {
            System.out.println("Waiting List Ticket Booked Successfully");
            displayCoach();
            return;
        }

        // If no AVL, REC, or WL seats are available
        System.out.println("No seats available, booking failed.");
    }

    private String determineBerthType(int age) {
        if (age >= 60) {
            return "LB";
        } else {
            return seats[new Random().nextInt(seats.length)];
        }
    }

    public void displayCoach() {
        System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s",
                "PNR", "Berth No", "Status", "Berth Type", "Name", "Age", "Cost"));

        for (Train train : coach) {
            System.out.println(String.format("%-10s %-10d %-10s %-10s %-10s %-10d %-10.2f",
                    train.pnr == 0 ? "-" : String.valueOf(train.pnr), train.berthNo,
                    train.currentStatus, train.berthType, train.name, train.age, train.cost));
        }
    }

    public static void main(String[] args) {
        RailwayTicketBooking bookingSystem = new RailwayTicketBooking();
        bookingSystem.initializeCoach();

        while (true) {
            System.out.println("\nWelcome to the Railway Ticket Booking System");
            System.out.println("1. Book Individual Ticket");
            System.out.println("2. Book Group Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
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
                    System.out.println("Exiting the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

 public void cancelTicket()
 {
        System.out.print("Enter your PNR: ");
        int pnr = sc.nextInt();

        for (Train train : coach) {
            if (train.pnr == pnr) {
                train.currentStatus = "AVL";
                train.name = " ";
                train.age = 0;
                train.pnr = 0;

                updateCancelDetails(pnr, train.berthNo, train.currentStatus);
                deletePassengerFromDatabase(pnr);
                System.out.println("Ticket cancelled successfully.");
                displayCoach();
                return;
            }
        }

        System.out.println("PNR not found.");
    }
}