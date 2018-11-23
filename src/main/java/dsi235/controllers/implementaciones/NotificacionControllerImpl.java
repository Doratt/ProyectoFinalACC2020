package dsi235.controllers.implementaciones;

import java.util.Properties;

import javax.inject.Singleton;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

import dsi235.controllers.NotificationController;
import dsi235.entities.Usuario;

@Controller
@Singleton
public class NotificacionControllerImpl implements NotificationController {

	private Transport t;
	private Session session;
	final String username = "herreraChristian1897@gmail.com";
	final String password = "hahahahaha";

	public void NotificationController() {
		init();
	}

	// TODO

	private void init() {
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.auth", "true");

		session = Session.getDefaultInstance(props, null);
		try {
			t = session.getTransport("smtp");
			t.connect(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean enviarCorreo(Usuario usuario, String contenido) {

		if(t==null || !t.isConnected()) {
			init();
		}
		
		try {
					
			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getCorreo()));
			message.setSubject("Notificacion");
			message.setText(contenido);
			// Envia el mensaje
			t.sendMessage(message, message.getAllRecipients());
		} catch (Exception e) {
			System.out.println("Fallo en enviarCorreo");
			e.printStackTrace();
			init();

		}
		return true;

	}

}
