import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.*;

class MenuItem 
{
    private String name;
    private String category;
    private LocalDateTime time;

    public MenuItem(String name,String category)
    {
        this.name=name;
        this.category=category;
        this.time=LocalDateTime.now();
    }

    public String getName() 
    {
        return name;
    }

    public String getCategory()
    {
        return category;
    }

    public LocalDateTime getTime() 
    {
        return time;
    }
}


abstract class Meal
 {
    Queue<MenuItem>menuItems;
    static final int limit=2;

    public Meal()
    {
       this.menuItems=new LinkedList<>();
    }

    public void addMenuItem(MenuItem item)
      {
        if(menuItems.size()>=limit) 
         {
            System.out.println("Maximum size reached so,Removing the Last Item");
            menuItems.poll(); 
         }
        menuItems.add(item);
    }

    public void removeOldItems() 
      {
        LocalDateTime six=LocalDateTime.now().minusHours(6);
        while(!menuItems.isEmpty() && menuItems.peek().getTime().isBefore(six)) 
         {
             System.out.println("Removing item older than 6 hours: "+menuItems.poll().getName());
         }
      }


  public void displayMenu() 
     {
        if(menuItems.isEmpty())
          {
             System.out.println("Menu is Empty ");
          }
	else 
	  {
            System.out.println("Current Menu:");
            for(MenuItem item : menuItems) 
	     {
                System.out.println("- "+item.getCategory()+": "+item.getName());
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
        Dinner dinner=new Dinner();
        Snacks snacks=new Snacks();

        Scanner scanner=new Scanner(System.in);

        while(true) 
	  {
            try {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add Menu Item");
                System.out.println("2. Display Menu");
                System.out.println("3. Exit");
                int choice=Integer.parseInt(scanner.nextLine());

                switch(choice) 
		  {
                    case 1:
                        System.out.println("Enter meal time(Breakfast/Lunch/Dinner/Snacks): ");
                        String mealTime=scanner.nextLine().toLowerCase();

                        System.out.println("Enter category(Starters/Main Courses/Desserts/Beverages): ");
                        String category=scanner.nextLine().toLowerCase();

                        System.out.println("Enter item name: ");
                        String itemName=scanner.nextLine();

                        MenuItem menuItem=new MenuItem(itemName,category);

                        switch(mealTime) 
			{
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
                                System.out.println("Invalid meal time");
                        }
                        break;

                    case 2:
                        System.out.println("Enter meal time to display (Breakfast/Lunch/Dinner/Snacks): ");
                        String displayMealTime=scanner.nextLine().trim().toLowerCase();

                        switch (displayMealTime) 
			 {
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
                           System.out.println("Exiting the Application");
                           return;


                    default:
                        System.out.println("Invalid choice");
                }
            } 

	catch(Exception e)
	    {
                System.out.println("An error occurred: ");
            }

        }
    }
}
