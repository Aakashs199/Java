import java.util.*;
import java.sql.*;
import java.io.*;
class Imageinsert
 {
    public static void main(String args[]) 
    {
      try
	{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root19");
           System.out.println("Connected");

           PreparedStatement state=con.prepareStatement("insert into  img values(?,?)");
	   state.setString(1,"Logo");

	   FileInputStream fin=new FileInputStream("C:\\Users\\inc5540-12\\Documents\\JDBC\\jtp-logo3.png");

           state.setBinaryStream(2,fin,fin.available());
	   int i=state.executeUpdate();
	   System.out.println(i+"Record affected");

      }


      catch(ClassNotFoundException e)
	 {
            System.out.println("JDBC Driver not found");
         }

      catch(SQLException e) 
	{
            System.out.println(e);
        }
       catch(IOException e) 
	{
            System.out.println(e);
        }

    }
}
