import java.io.*;
import java.util.*;

class Vehicle {
    String type;
    int cost;
    int entryTime = 0;
    int exitTime;
    int lotPosition = 1;
    int[] space = {0, 0, 0, 0, 0};
    int number;

    public Vehicle(String type, int entryTime, int number) {
        this.type = type;
        this.entryTime = entryTime;
        this.number = number;
        this.space = space;
    }
}

public class ParkingManagement {
    int carCost = 50;
    int bikeCost = 10;
    int totalCapacity = 125;
    List<Vehicle> vehicles;

    public ParkingManagement(int n) {
        vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vehicles.add(new Vehicle("", 0, 0));
        }
    }

    public boolean isFree(Vehicle vehicle) {
        int[] arr = vehicle.space;
        if (vehicle.type.equals("twowheeler")) {
            for (int i = 0; i < 3; i++) {
                if (arr[i] == 0) {
                    vehicle.space[i] = 1;
                    return true;
                }
            }
        } else {
            for (int i = 3; i < 5; i++) {
                if (arr[i] == 0) {
                    vehicle.space[i] = 1;
                    return true;
                }
            }
        }
        return false;
    }

    public int findPosition(String vehicleType) {
        for (Vehicle vehicle : vehicles) {
            if (isFree(vehicle)) {
                return vehicle.lotPosition;
            }
        }
        return -1;
    }

    public boolean allocateVehicle(String vehicleType, int number, int entryTime) {
        if (totalCapacity > 0) {
            int position = findPosition(vehicleType);
            if (position != -1) {
                Vehicle vehicle = new Vehicle(vehicleType, entryTime, number);
                vehicle.lotPosition = position;
                totalCapacity--;
                vehicles.add(vehicle);
                return true;
            }
        }
        return false;
    }

    public void exitVehicle(int number, int exitTime) {
        try {
            FileWriter writer = new FileWriter("vehicle_details.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            for (Iterator<Vehicle> iterator = vehicles.iterator(); iterator.hasNext(); ) {
                Vehicle vehicle = iterator.next();
                if (vehicle.number == number) {
                    vehicle.exitTime = exitTime;
                    long duration = vehicle.exitTime - vehicle.entryTime;
                    int cost = (vehicle.type.equals("car")) ? carCost * (int) duration : bikeCost * (int) duration;
                    String details = "Vehicle " + number + " exited from lot " + vehicle.lotPosition + ". Amount due: " + cost;
                    System.out.println(details);
                    bufferWriter.write(details);
                    bufferWriter.newLine();
                    iterator.remove();
                    totalCapacity++;
                    bufferWriter.close();
                    return;
                }
            }
            System.out.println("Vehicle " + number + " not found.");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ParkingManagement park = new ParkingManagement(25);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the Choice");
            System.out.println("1. Parking a Vehicle");
            System.out.println("2. Exit a Vehicle");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Vehicle Type: ");
                    String vehicleType = sc.next().toLowerCase();
                    System.out.println("Enter the Vehicle Number: ");
                    int number = sc.nextInt();
                    System.out.println("Enter the Entry Time: ");
                    int entryTime = sc.nextInt();
                    if (park.allocateVehicle(vehicleType, number, entryTime)) {
                        System.out.println("Vehicle has been parked");
                    } else {
                        System.out.println("No space for parking");
                    }
                    break;
                case 2:
                    System.out.println("Enter the Vehicle Number: ");
                    int exitNumber = sc.nextInt();
                    System.out.println("Enter the Exit Time: ");
                    int exitTime = sc.nextInt();
                    park.exitVehicle(exitNumber, exitTime);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
