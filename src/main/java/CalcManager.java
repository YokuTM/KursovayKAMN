import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcManager")
public class CalcManager extends HttpServlet { //Класс для проверки введеных логина и пароля 
	private static final long serialVersionUID = 1L;
	public static int monthMan;
	public static String[] monthName = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	         
		  	Login.selectedId = Login.sessionId;
		  	
	        request.setAttribute("userList", FileReaderClass.usersObj);
	        request.setAttribute("name", FileReaderClass.usersObj.get(Login.selectedId).getName());
	        getServletContext().getRequestDispatcher("/WEB-INF/views/calcManager.jsp").forward(request, response);
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter wr = response.getWriter();
        //Получение значений логина и пароля с формы HTML-страницы
        monthMan = Integer.valueOf(request.getParameter("selectMonth")); 
        Login.selectedId = Integer.valueOf(request.getParameter("selectUser")); 
        Calculator.main(Login.selectedId, monthMan);
        response.sendRedirect("result");
	}
}