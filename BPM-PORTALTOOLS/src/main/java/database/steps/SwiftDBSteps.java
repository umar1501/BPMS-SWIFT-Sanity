package database.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.Statement;
import com.ctl.it.qa.staf.Page;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings("serial")
public class SwiftDBSteps {

	public static Connection conn;
	
	@Step
	public static void DataBaseConnection () throws ClassNotFoundException, SQLException {
		String DbUrl = Page.envData.getFieldValue("swiftDB-url");
		String Dbusername = Page.envData.getFieldValue("swiftDB-username");
		String Dbpsw = Page.envData.getFieldValue("swiftDB-psw");
	    String DbDriver = "oracle.jdbc.driver.OracleDriver";
	    Class.forName(DbDriver);
//	    OracleDataSource ds;
//		ds = new OracleDataSource();
//		ds.setURL(DbUrl);
//		conn = ds.getConnection(Dbusername,Dbpsw); 
	    System.out.println("Swift Data base request connection.... ");
	    conn = DriverManager.getConnection(DbUrl, Dbusername, Dbpsw);
	    System.out.println("Swift Data base is connected.... ");
	}
	
	@Step
	public String getResultAfterExecuteQuery(String query,String attribute ) throws SQLException {
		  Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      String ele=null;
	      
	      while (rs.next())
	      {
	         ele = rs.getString(attribute);
	      }      
	      st.close();
	      return ele;
	    }
	
	@Step
	public static String getDBlatestRow(String query) throws SQLException {
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);	
        ResultSet res = st.executeQuery(query);
        res.next();
        //System.out.print(res.getString(1));
        return res.getString(1).toString();   
	}
}

