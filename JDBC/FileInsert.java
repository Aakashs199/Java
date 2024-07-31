import java.util.*;
import java.sql.*;
import java.io.*;
class FileInsert
 {
    public static void main(String args[]) 
    {
      try
	{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root19");
           System.out.println("Connected");

           PreparedStatement state=con.prepareStatement("insert into  filetable values(?,?)");
	   File f=new File("C:\\Users\\inc5540-12\\Documents\\JDBC\\Sample.txt");
	   FileReader fr=new FileReader(f);
	   state.setInt(1,100);

           state.setCharacterStream(2,fr,(int)f.length());
	   int i=state.executeUpdate();
	   System.out.println(i+"Record affected");
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
