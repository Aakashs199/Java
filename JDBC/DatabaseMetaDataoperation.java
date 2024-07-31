import java.sql.*;

class DatabaseMetadataoperation 
{
  public static void main(String args[]) 
   {
        try 
	{
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "root19"))
	       {
                System.out.println("Connected");

                java.sql.DatabaseMetaData dbms = con.getMetaData();
                System.out.println("Driver Name: "+dbms.getDriverName());
                System.out.println("Driver Version: "+dbms.getDriverVersion());
                System.out.println("UserName: "+dbms.getUserName());
                System.out.println("Database Product Name: "+dbms.getDatabaseProductName());
                System.out.println("Database Product Version: "+dbms.getDatabaseProductVersion());
             }
        }
   catch(ClassNotFoundException e) 
	{
            System.out.println("JDBC Driver not found: "+e.getMessage());
        } 
   catch(SQLException e)
	 {
            System.out.println("SQL Error: "+e.getMessage());
         }
    }
}
