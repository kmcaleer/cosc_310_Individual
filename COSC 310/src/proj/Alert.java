
package proj;

import java.io.*;
import java.util.*;
import org.apache.commons.mail.*;
import java.util.ArrayList;

public class Alert{

	public User user;
	public ArrayList<Product> productList;
	private String warning;
	private String product;
	private Email email;

	public Alert(){
		email = new SimpleEmail();


// Set the Authenticator to the default when authentication is requested from the mail server.
//**Not sure if needed so commented out
	//email.setAuthenticator(new DefaultAuthenticator("team22", "310pw"));
	
// Set whether SSL/TLS encryption should be enabled for the SMTP transport upon connection (SMTPS/POPS).
//**Not sure if needed so commented out
	//email.setSSLOnConnect(true);

// Set the hostname of the outgoing mail server 
	email.setHostName("smtp.googlemail.com");

// Set the non-SSL port number of the outgoing mail server
	email.setSmtpPort(3307);

// Set FROM field of email
	email.setFrom(user.getEmail());
	
// Set email subject
	email.setSubject("Low Inventory Warning");

// Set the content of the email
	email.setMsg(getWarning());

// Set TO field/recipient of the email
	email.addTo(user.getEmail());
	
// Set condition to send alert

		if(email.getMessage() != null){
			email.send();
		}

}
	
		public String getWarning() {
			return warning;
		}

		public void setWarning(ArrayList<Product> productList) {
		this.productList = productList;
		
		for(int i=0; i < productList.size(); i++){
			if(productList.get(i).isLow()){
				this.product = productList.get(i).getName();
				warning += product + "stock is running low. More should be ordered.\n";
				}
		}
		}

}
