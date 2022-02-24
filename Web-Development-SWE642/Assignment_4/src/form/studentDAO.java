package form;
import java.sql.*;

public class studentDAO {
	
	public Connection conn =null;
	
	public studentDAO(){
        try{
        	System.out.println("connecting");
        	Class.forName ("oracle.jdbc.driver.OracleDriver");
        	conn = DriverManager.getConnection ("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g","sdesai20", "roathy");
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
		          //String street2 = rs.getString("street2");
		          String city = rs.getString("city");
		          String state = rs.getString("state");
		          String zip = rs.getString("zip");
		          String email = rs.getString("email");
		          String likes = rs.getString("ThingsLiked");
		          String site = rs.getString("HowInterested");
		          String data = rs.getString("data");
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
		          sb1.setFirstName(firstname);
		          sb1.setLastName(lastname);
		          sb1.setStreet(street);
		          sb1.setPhone(phone);
		          sb1.setEmail(email);
		          sb1.setZip(zip);
		          sb1.setState(state);
		          sb1.setCity(city);
		          sb1.setThingsLiked(likes);
		          sb1.setHowInterested(site);
		          sb1.setData(data);
		          sb1.setMean(mean);
		          sb1.setStandardDev(sd);
		          sb1.setURL(URL);
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
	
	
	public void storeData(String SID,String firstname,String lastname,String street, String zip, String city,String state,String email,String phone,String URL,String DOS,String numbers,String HowInterested,String GradMonth,String Year,String Likelihood,String mean,String SD,String ThingsLiked,String comments) throws SQLException
	{
		try
		{
				Statement stmt= conn.createStatement();
				String sql="insert into student642 values ('"+SID+"','"+firstname+"','"+lastname+"','"+street+"','"+zip+"','"+city+"','"+state+"','"+email+"','"+phone+"','"+URL+"','"+DOS+"','"+numbers+"','"+HowInterested+"','"+GradMonth+"','"+Year+"','"+Likelihood+"','"+mean+"','"+SD+"','"+ThingsLiked+"','"+comments+	"')";
				stmt.executeUpdate(sql);     
		}
		catch(Exception e)
		{
			System.out.println("Cannot store data in database");
			e.printStackTrace();
		}
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
			stringBuilder.append("<li><a href='FormServlet?SID="+ rs.getString("SID") +"'>"+rs.getString("SID")+"</a></li>");
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
		
	
	
	public static void main(String []args)
	{
		//studentData obj = new studentData();
	}
	
	
}
