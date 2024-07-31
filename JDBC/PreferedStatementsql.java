import java.util.*;
import java.sql.*;
import java.io.*;
class PreferedStatementsql
 {
    public static void main(String args[]) 
    {
      try
	{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","root19");
           System.out.println("Connected");

           PreparedStatement state=con.prepareStatement("insert into mark values(?,?,?)");

          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	do
	  {
	    System.out.print("enter Roll no: ");  
	    int rno=Integer.parseInt(br.readLine());  
       	    System.out.print("enter Mark1: ");  
	    int mark1=Integer.parseInt(br.readLine());
	    System.out.print("enter Mark2: ");  
	    int mark2=Integer.parseInt(br.readLine());
	   
	    state.setInt(1,rno);
	    state.setInt(2,mark1);
	    state.setInt(3,mark2);
	    int i=state.executeUpdate();
	    
	     String query="select * from mark";
          ResultSet rs=state.executeQuery(query);           
            while(rs.next())
	      {
                System.out.println("rno="+rs.getInt(1)+" Mark1:"+rs.getInt(2)+" Mark2:"+rs.getInt(3));
              }
             System.out.println("--------------"); 

	    System.out.println("Do you want to update:(y/n)");
	     String str=br.readLine();
	      if(str.startsWith("n"))
		{
		  System.out.println("Exiting the Program");
		   break;
		}
	  }
	while(true);
           
	 

  
      }


      catch(ClassNotFoundException e)
	 {
            System.out.println("JDBC Driver not found");
         }

      catch(SQLException e) 
	{
            System.out.println("SQL Error");
        }
       catch(IOException e) 
	{
            System.out.println("SQL Error");
        }

    }
}
