package fpoly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.mailG; // Import đúng class mailG từ package utils

@WebServlet("/mail/send")
public class MailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/send-mail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");

        try {
            // Đổi từ Mailer.send sang mailG.send cho đúng tên class bạn định nghĩa bên dưới
            mailG.send(to, subject, body);
            req.setAttribute("message", "Gửi email thành công đến " + to + "!");
        } catch (Exception e) {
            req.setAttribute("message", "Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
        req.getRequestDispatcher("/views/send-mail.jsp").forward(req, resp);
    }
}