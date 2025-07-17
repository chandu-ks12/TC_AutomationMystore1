package utils;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.io.File;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;


public class EmailReportSender {

    public static void sendReportByEmail(String toEmail, String reportPath) {
        final String fromEmail = "your_email@gmail.com";
        final String password = "your_app_password"; // Use App Password for Gmail

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Automation Test Report");

            // Message body
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hi,\n\nPlease find the attached Extent Report.\n\nRegards,\nAutomation Team");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(reportPath));
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
