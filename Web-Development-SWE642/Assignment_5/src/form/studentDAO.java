/* Ajay Adithya Rajagopal
 * Model class to access and retrieve records from database
 */
package form;

import java.sql.*;
import form.studentBean;

public class studentDAO {

	public Connection conn =null;
	
	public studentDAO(){
        try{
        	System.out.println("connecting");
        	Class.forName ("oracle.jdbc.driver.OracleDriver");
        	conn = DriverManager.getConnection ("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g","arajago2", "eerdac");
        }
        catch(Exception e){
        	System.out.println("Cannot connect to server");
        	e.printStackTrace();
        }
    }
	
	
	public studentBean getDataByStudentID(String SID)
	{
		Statement statement = null;
		studentBean sb1=null;
		try
		{
			System.out.println("Creating statement...");
			statement = conn.createStatement();
			String sql;
			System.out.print(SID);
		      sql = "select * from student642 where SID = '"+ SID +"'";
		     ResultSet rs = statement.executeQuery(sql);
		      while(rs.next())
		      {
		    	  String studentid = rs.getString("SID");
		          String firstname = rs.getString("firstname");
		          String lastname = rs.getString("lastname");
		          String phone = rs.getString("phone");
		          String street = rs.getString("street");
		          String city = rs.getString("city");
		          String state = rs.getString("state");
		          String zip = rs.getString("zip");
		          String email = rs.getString("email");
		          String likes = rs.getString("ThingsLiked");
		          String site = rs.getString("HowInterested");
		          String data = rs.getString("numbers");
		          String mean = rs.getString("mean");
		          String sd = rs.getString("sd");
		          String URL=rs.getString("url");
		          String Likelihood=rs.getString("Likelihood");
		          String dos=rs.getString("dos");
		          String GradMonth=rs.getString("gradMonth");
		          String Year=rs.getString("year");
		          String comments=rs.getString("comments");
		          
		          sb1=new studentBean();
		          sb1.setStudentID(studentid);
		          sb1.setFName(firstname);
		          sb1.setLName(lastname);
		          sb1.setStreet(street);
		          sb1.setPhone(phone);
		          sb1.setEmail(email);
		          sb1.setZip(zip);
		          sb1.setState(state);
		          sb1.setCity(city);
		          sb1.setThingsliked(likes);
		          sb1.setHowinterested(site);
		          sb1.setData(data);
		          sb1.setMean(mean);
		          sb1.setStandardDev(sd);
		          sb1.setUrl(URL);
		          sb1.setLikelihood(Likelihood);
		          sb1.setGradMonth(GradMonth);
		          sb1.setYear(Year);
		          sb1.setComments(comments);
		          sb1.setDate(dos);
		          
		      }
		}
		catch(Exception e)
		{
			System.out.println("Unable to retreive data");
          	e.printStackTrace();
		}
		return sb1;
	}
	
	
	public String  getStudentId()
	{
		ResultSet rs =null;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<ul>");
		try
		{
			Statement stmt= conn.createStatement();
			String sql1="select SID from student642";
			rs=stmt.executeQuery(sql1);
			while(rs.next()){
				stringBuilder.append("<li><a href='Myservlet?SID="+ rs.getString("SID") +"'>"+rs.getString("SID")+"</a></li>");
			}
			stringBuilder.append("</ul>");
			conn.close();
		}
		catch (Exception e) 
		{
			System.out.println("Cannot get student ID's: "+e.getMessage());
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	
	
	public void storeData (studentBean stud_bean) {
		String STUDENT_ID = stud_bean.getStudentID();
        String firstname = stud_bean.getFName();
        String lastname = stud_bean.getLName();
        String street = stud_bean.getStreet();
        String zip = stud_bean.getZip();
        String city = stud_bean.getCity();
        String state = stud_bean.getState();
        String email = stud_bean.getEmail();
        String phone = stud_bean.getPhone();
        String URL = stud_bean.getUrl();
        String DOS = stud_bean.getDate();
        String numbers=stud_bean.getData();
        String howInterested = stud_bean.getHowinterested();
        String GradMonth = stud_bean.getGradMonth();
        String Year = stud_bean.getYear();
        String Likelihood = stud_bean.getLikelihood();
        String mean = stud_bean.getMean();
        String SD = stud_bean.getStandardDev();
        String likemost = stud_bean.getThingsliked();
        String comments = stud_bean.getComments();
        
        
        try
        {
        	Statement stmt= conn.createStatement();
        	String sql="insert into student642 values ('"+STUDENT_ID+"','"+firstname+"','"+lastname+"','"+street+"','"+zip+"','"+city+"','"+state+"','"+email+"','"+phone+"','"+URL+"','"+DOS+"','"+numbers+"','"+howInterested+"','"+GradMonth+"','"+Year+"','"+Likelihood+"','"+mean+"','"+SD+"','"+likemost+"','"+comments+"')";
        	stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
        	System.out.println("Cannot store data in database");
        	e.printStackTrace();
        }
	}
	
	
}
