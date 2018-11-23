package dsi235.controllers.implementaciones;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

import dsi235.controllers.NotificationController;
import dsi235.entities.Usuario;

@Controller
public class NotificacionControllerImpl implements NotificationController {

	// TODO
	@Override
	public boolean enviarCorreo(Usuario usuario, String contenido) {
		final String username = "ticketsystemdsi235@gmail.com"; 
		final String password = "ticketsystem";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, null);

		try {

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getCorreo()));

			message.setSubject("Notificacion");
			message.setText(contenido);
			// Envia el mensaje
			Transport t = session.getTransport("smtp");
			t.connect(username, password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return true;

	}
}
