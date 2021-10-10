package se.redbridge.academy.serverless;

import com.kumuluz.ee.amqp.common.annotations.AMQPConsumer;

import javax.enterprise.context.ApplicationScoped;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Logger;

@ApplicationScoped
public class Mailer {
  private static final Logger LOG = Logger.getLogger(Mailer.class.getName());

  @AMQPConsumer(host = "mqtest", key = "test")
  public void onMessage(String message) {
    LOG.info("Entered onMessage()");

    try {
      // FIXME Do this through middleware config
      final Properties properties = new Properties();
      properties.put("mail.smtp.host", "proxy.int.redbridge.se");
      properties.put("mail.smtp.port", 25);

      final var msg = new MimeMessage(Session.getInstance(properties));
      msg.setFrom("noreply@redbridge.se");
      msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("daniel@redbridge.se"));
      msg.setSubject("Mail from nowhere");
      msg.setText(message);
      Transport.send(msg);
    } catch (final MessagingException e) {
      throw new IllegalStateException("Shit's broke, yo!", e);
    }

    System.exit(0); // let's leave now
  }

}
