import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.*;

class MenuItem 
{
    private String name;
    private String category;
    private LocalDateTime timestamp;

    public MenuItem(String name, String category)
    {
        this.name = name;
        this.category = category;
        this.timestamp = LocalDateTime.now();
    }

    public String getName() 
    {
        return name;
    }

    public String getCategory()
    {
        return category;
    }

    public LocalDateTime getTimestamp() 
    {
        return timestamp;
    }
}





abstract class Meal
 {
    protected Queue<MenuItem> menuItems;
    private static final int MAX_SIZE = 10;

    public Meal()
    {
        this.menuItems = new LinkedList<>();
    }

    public void addMenuItem(MenuItem item)
      {
        if (menuItems.size() >= MAX_SIZE) 
        {
            System.out.println("Max size reached, removing oldest item...");
            menuItems.poll(); 
        }
        menuItems.add(item);
    }

    public void removeOldItems() 
      {
        LocalDateTime sixHoursAgo = LocalDateTime.now().minusHours(6);
        while (!menuItems.isEmpty() && menuItems.peek().getTimestamp().isBefore(sixHoursAgo)) 
         {
            System.out.println("Removing item older than 6 hours: " + menuItems.poll().getName());
        }
    }

    public void displayMenu() 
      {
        if (menuItems.isEmpty())
         {
            System.out.println("No items in the menu.");
        } 
	else {
            System.out.println("Current Menu:");
            for (MenuItem item : menuItems) {
                System.out.println("- " + item.getCategory() + ": " + item.getName());
            }
        }
    }
}

class Breakfast extends Meal 
{
    
}

class Lunch extends Meal 
{
    
}

class Dinner extends Meal 
{

}

class Snacks extends Meal 
{
    
}



public class MealMenuApp 
{
   public static void main(String[] args)
    {
        Breakfast breakfast=new Breakfast();
        Lunch lunch=new Lunch();
        Dinner dinner = new Dinner();
        Snacks snacks = new Snacks();

        Scanner scanner = new Scanner(System.in);

        while(true) 
	  {
            try {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add Menu Item");
                System.out.println("2. Display Menu");
                System.out.println("3. Exit");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) 
		  {
                    case 1:
                        System.out.println("Enter meal time(Breakfast/Lunch/Dinner/Snacks): ");
                        String mealTime = scanner.nextLine().trim().toLowerCase();
                        System.out.println("Enter category (Starters/Main Courses/Desserts/Beverages): ");
                        String category = scanner.nextLine().trim();
                        System.out.println("Enter item name: ");
                        String itemName = scanner.nextLine().trim();

                        MenuItem menuItem = new MenuItem(itemName, category);

                        switch (mealTime) {
                            case "breakfast":
                                breakfast.removeOldItems();
                                breakfast.addMenuItem(menuItem);
                                break;
                            case "lunch":
                                lunch.removeOldItems();
                                lunch.addMenuItem(menuItem);
                                break;
                            case "dinner":
                                dinner.removeOldItems();
                                dinner.addMenuItem(menuItem);
                                break;
                            case "snacks":
                                snacks.removeOldItems();
                                snacks.addMenuItem(menuItem);
                                break;
                            default:
                                System.out.println("Invalid meal time.");
                        }
                        break;

                    case 2:
                        System.out.println("Enter meal time to display (Breakfast/Lunch/Dinner/Snacks): ");
                        String displayMealTime = scanner.nextLine().trim().toLowerCase();

                        switch (displayMealTime) {
                            case "breakfast":
                                breakfast.displayMenu();
                                break;
                            case "lunch":
                                lunch.displayMenu();
                                break;
                            case "dinner":
                                dinner.displayMenu();
                                break;
                            case "snacks":
                                snacks.displayMenu();
                                break;
                            default:
                                System.out.println("Invalid meal time.");
                        }
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } 
	catch(Exception e)
	    {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
