package util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class mailG {
    public static void send(String to, String subject, String body) throws Exception {
        // 1. Cấu hình các thông số server Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // 2. Điền thông tin tài khoản Gmail của bạn
        final String username = "trantung09062k8@gmail.com";
        final String password = "bfqs drof ptvv cxlh"; // Mật khẩu ứng dụng 16 ký tự của bạn

        // 3. Tạo phiên làm việc (Session) với cơ chế xác thực
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // 4. Xây dựng nội dung Mail
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setContent(body, "text/html; charset=utf-8");

        // 5. Thực hiện gửi mail
        Transport.send(message);
    }
}