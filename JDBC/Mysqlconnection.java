import java.sql.*;
class Mysqlconnection
 {
    public static void main(String args[]) 
    {
      try
	{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root19");
           System.out.println("Connected");

           Statement state=con.createStatement();
	   String query="select * from emp";

           ResultSet rs=state.executeQuery(query);           
            while(rs.next())
	      {
                System.out.println("id="+rs.getInt(1)+" Name:"+rs.getString(2)+" Age:"+rs.getInt(3));
              }
             System.out.println("--------------");



 	  ResultSet rs1=state.executeQuery("select name from emp where id=10");
          if(rs1.next())
           {
	     System.out.println("Name Matches id 10: "+rs1.getString(1));
	   }
	  System.out.println("--------------");


 	  ResultSet rs2=state.executeQuery("select * from emp order by age desc");
            {
	       while(rs2.next())
	        {
                  System.out.println("id="+rs2.getInt(1)+" Name:"+rs2.getString(2)+" Age:"+rs2.getInt(3));
                }
	    }
	System.out.println("--------------");


/*	int rowaffected=state.executeUpdate("update emp set name='Abhishek' where id='11'");	
	  if(rowaffected>0)
	    {
	       ResultSet rs3=state.executeQuery("select * from emp");
	       while(rs3.next())
	          {
                    System.out.println("id="+rs3.getInt(1)+" Name:"+rs3.getString(2)+" Age:"+rs3.getInt(3));
                  }
	    }
	   else
	      {
	         System.out.println("No row Affected");
	      }  */
           rs.close();
           state.close();
           con.close();
        }

      catch(ClassNotFoundException e)
	 {
            System.out.println("JDBC Driver not found");
         }

      catch(SQLException e) 
	{
            System.out.println("SQL Error");
        }

    }
}
