package form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Ajay Adithya Rajagopal
 * This is the front controller which accesses studentDao class and data processor class
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FormServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
		String SID = request.getParameter("SID");
		studentDAO st2 = new studentDAO();
		studentBean Sb2 = st2.getDataByStudentID(SID);
		HttpSession session = request.getSession();
		session.setAttribute("sb2", Sb2);
		RequestDispatcher dispatcher;
		if(Sb2!=null)
		{
			System.out.println("Calling StudentJSP");
			dispatcher = request.getRequestDispatcher("StudentJSP.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			System.out.println("Calling StudentNullJSP");
			dispatcher = request.getRequestDispatcher("NoSuchStudentJSP.jsp");
			dispatcher.forward(request, response);
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught ");
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try
		{
			response.setHeader("Access-Control-Allow-Origin","http://mason.gmu.edu");
			String Data = request.getParameter("Data").toString();
			dataProcessor dcObj = new dataProcessor();
			dataBean dbObj = dcObj.calculate(Data);
			String Mean = Double.toString(dbObj.getMean());
			String SD = Double.toString(dbObj.getSd());
			
			
			String Studid = request.getParameter("StudentID");
			String Fname = request.getParameter("FName");
			String Lname = request.getParameter("LName");
			String Street = request.getParameter("street");
			String ZipCode = request.getParameter("zip");
			String City = request.getParameter("city");
			String State = request.getParameter("state");
			String Email = (String) request.getParameter("email");
			String phone = request.getParameter("phone");
			String URL = request.getParameter("url");
			String DOS = request.getParameter("date");
			String howinterested = request.getParameter("howinterested");
			String GradMonth = request.getParameter("GradMonth");
			String Year = request.getParameter("Year");
			String comments = request.getParameter("comments");
			String Likelihood = request.getParameter("Likelihood");
			String[] thingsliked = request.getParameterValues("thingsliked");
			
			String Like = "";
			for (int i = 0; i < thingsliked.length; i++) {
				Like += thingsliked[i] + " ";
			}
			
			studentDAO SdObj = new studentDAO();
			SdObj.storeData(Studid, Fname, Lname, Street, ZipCode, City,
					State, Email, phone, URL, DOS, Data, howinterested, GradMonth,
					Year, Likelihood, Mean, SD, Like,comments);
			
			
			HttpSession session = request.getSession();
			session.setAttribute("db1", dbObj);
			String UnOrderedList = SdObj.getStudentId();
			session.setAttribute("unOrderedList", UnOrderedList);
			RequestDispatcher dispatcher;
			if (dbObj.getMean() >= 90) {
				dispatcher = request.getRequestDispatcher("/winnerAcknowledgement.jsp");
				dispatcher.forward(request, response);
				} 
			else {
				
				dispatcher = request.getRequestDispatcher("/simpleAcknowledgement.jsp");
				dispatcher.forward(request, response);
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception caught ");
			e.printStackTrace();
		}
	}

}
