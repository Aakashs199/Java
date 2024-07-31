import java.util.*;
import java.sql.*;
import java.io.*;
class Imageextract
 {
    public static void main(String args[]) 
    {
      try
	{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root19");
           System.out.println("Connected");

           PreparedStatement state=con.prepareStatement("select * from img");
	   ResultSet rs=state.executeQuery();
	   if(rs.next())
	    {
  	       Blob b=rs.getBlob(2);
	       byte arr[]=b.getBytes(1,(int)b.length());

  	       FileOutputStream fout=new FileOutputStream("C:\\Users\\inc5540-12\\Documents\\JDBC\\Extracted Image\\retrivejtp-logo3.png");
	       fout.write(arr);
	       fout.close();
	   }
	  System.out.println("Image Extracted");
	  con.close();
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
