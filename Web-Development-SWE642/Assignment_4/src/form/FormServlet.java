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
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
		String SID = request.getParameter("SID");
		System.out.println("banana-0");
		studentDAO st2 = new studentDAO();
		System.out.println("banana-1");
		studentBean Sb2 = st2.getDataByStudentID(SID);
		System.out.println("banana-2");
		HttpSession session = request.getSession();
		System.out.println("banana-3");
		session.setAttribute("sb2", Sb2);
		System.out.println("banana-4");
		RequestDispatcher dispatcher;
		System.out.println("apple-0");
		if(Sb2!=null)
		{
			System.out.println("Calling StudentJSP");
			dispatcher = request.getRequestDispatcher("StudentJSP.jsp");
			System.out.println("apple-1");
			dispatcher.forward(request, response);
			System.out.println("apple-2");
		}
		else
		{
			System.out.println("Calling StudentNullJSP");
			dispatcher = request.getRequestDispatcher("NoSuchStudentJSP,.jsp");
			System.out.println("apple-3");
			dispatcher.forward(request, response);
			System.out.println("apple-4");
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught ");
			e.printStackTrace();
		}
		System.out.println("apple-5");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
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
			
			System.out.println("Orange-1");
			HttpSession session = request.getSession();
			System.out.println("Orange-2");
			session.setAttribute("db1", dbObj);
			System.out.println("Orange-3");
			String UnOrderedList = SdObj.getStudentId();
			System.out.println("Orange-4");
			session.setAttribute("unOrderedList", UnOrderedList);
			System.out.println("Orange-5");
			
			RequestDispatcher dispatcher;
			System.out.println("Orange-6");
			if (dbObj.getMean() >= 90) {
				System.out.println("Orange-7");
				dispatcher = request.getRequestDispatcher("/winnerAcknowledgement.jsp");
				dispatcher.forward(request, response);
				System.out.println("Orange-8");
			} else {
				System.out.println("Orange-9");
				dispatcher = request.getRequestDispatcher("/simpleAcknowledgement.jsp");
				dispatcher.forward(request, response);
				System.out.println("Orange-10");
			}
			System.out.println("Orange-11");
		}
		catch(Exception e)
		{
			System.out.println("Exception caught ");
			e.printStackTrace();
		}
	}

}
