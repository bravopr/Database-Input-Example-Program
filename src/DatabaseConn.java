
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class DatabaseConn {

	public static void dbInput ( String PTNO, int ID_Operator, int Shift , String Qty, String Defect ) 
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Calendar cal = Calendar.getInstance();
		String DATE = dateFormat.format(cal.getTime());
		
		
		// Create a variable for the connection string.
	      String connectionUrl = "jdbc:sqlserver://SERVERNAME:PORT;" +
	         "databaseName=EXAMPLE;user=User;password=PASSWORD";

	      // Declare the JDBC objects.
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
		
	      
	      try {
	    	  //Creates Timestamp Object
		Timestamp tsDate = new Timestamp(dateFormat.parse(DATE).getTime());	
      

      
         // Establish the connection.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(connectionUrl);
        
         stmt = con.createStatement();        
         
         String Wqry = "INSERT INTO SCRAP (PTNO,ID_OPERATOR,INPUT_DATE,SHIFT,QTY,DEFECT) VALUES ('"+PTNO+"','"+ID_Operator+"','"+tsDate+"','"+Shift+"','"+Qty+"','"+Defect+"') ";
		
         if(Shift != 0 && !Defect.equals(GUI.getNone()))
         {				
         stmt.execute(Wqry);         
		 }
         else {  JOptionPane.showMessageDialog(null,"Error: Verify your values. / Verifica tus valores.");}
      }

      // Handle any errors that may have occurred.
      catch (Exception e) {
    	  JOptionPane.showMessageDialog(null,"Error: Verify your values. / Verifica tus valores.");
         e.printStackTrace();
      }
      finally {
         if (rs != null) try { rs.close(); } catch(Exception e) {}
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
         if (con != null) try { con.close(); } catch(Exception e) {}
      }
   }
		
	}


