package aboutme;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Today")
public class TodayServlet extends HttpServlet { //TodayServlet(자식)은 HttpServlet(부모)를 상속한다.
	private static final long serialVersionUID = 1L;
	public TodayServlet() {
		
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime year = LocalDateTime.of(now.getYear(),now.getMonth(),now.getDayOfMonth(),now.getHour(),now.getMinute());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("현재시간:yyyy/MM/dd/HH:mm");
		String formatDateTime = year.format(formatter);
		out.println("<html>");
		out.println("<head><title>현재시간</title></head>");
		out.println("<body>");
		out.println("<h1><a href=index.html>메인화면</a></h1>");
		out.println("<div style=text-align:center;"
				+ "margin:20%;>"
				+ "<h1>"
				+ "<span style=font-size:70px;>");
		out.println(formatDateTime);
		out.println("</span></h1></div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
