package database.steps;

import java.sql.SQLException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

@SuppressWarnings("serial")
public class DbValidations {
	
//	@Steps
//	SwiftDBSteps swiftDBSteps;

	String fseid;
	static String OPID;
	
	@Step
	public static String fetchOPId(String status) throws ClassNotFoundException, SQLException {
		System.out.println("Execution of Query");
		if (status.contentEquals("Ordered"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'Ordered' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");
		} 
		else if (status.contentEquals("Closed"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'Closed' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");
		}
		else if (status.contentEquals("InProgress"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'InProgress' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");
		}
		else if (status.contentEquals("DueDateComplete"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'DueDateComplete' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");
		}
		else if (status.contentEquals("PendingClosed"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'PendingClosed' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");
		}
		else if (status.contentEquals("Cancelled"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'Cancelled' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");
		}
		else if (status.contentEquals("CancelInProgress"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'CancelInProgress' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");	
		}
		else if (status.contentEquals("New"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'New' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");
		}
		else if (status.contentEquals("Approved"))
		{
			OPID = SwiftDBSteps.getDBlatestRow("SELECT TRANSACTION_ID FROM ( SELECT * FROM product_service_package where STATUS = 'Approved' ORDER BY TRANSACTION_ID DESC ) WHERE ROWNUM = 1");
		}
		System.out.println("\n Query got Executed");
		System.out.println("Order Package ID:  " + OPID);
		Assert.assertNotNull(OPID);
		return OPID;
	}

}