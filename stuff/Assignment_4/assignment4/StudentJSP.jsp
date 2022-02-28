<%@page import="form.studentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Data</title>
</head>
<body bgcolor="yellow">
<h2> Saved Form Data</h2>
	<%
		studentBean sbObj2 = (studentBean) session.getAttribute("sb2");
	%>
	
	<form>
		<table align="center">
			<tr>
				<td><label>StudentID</label><br /> <input type="text"
					id="StudentID" name="StudentID" value="<%=sbObj2.getStudentID()%>"
					readonly="readonly" /></td>
			
				<td><label>First Name</label><br /> <input type="text"
					id="FirstName" name="FirstName" value="<%=sbObj2.getFirstName()%>"
					readonly="readonly" /></td>

				

				<td><label>Last Name</label><br /> <input type="text"
					id="LastName" name="LastName" value="<%=sbObj2.getLastName()%>" readonly="readonly" /></td>


			</tr>
			<tr>
				<td><label>Street Address </label><br /> <input type="text"
					name="Street" id="street" value="<%=sbObj2.getStreet()%>"
					readonly="readonly" /></td>

				<td><label>Zipcode</label><br /> <input type="text" name="zip"
					id="zip" value="<%=sbObj2.getZip()%>" readonly="readonly" /></td>

				<td><label>City</label><br /> <input type="text" name="City"
					id="City" value="<%=sbObj2.getCity()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td><label>State</label><br /> <input type="text" name="State"
					id="State" value="<%=sbObj2.getState()%>" readonly="readonly"/></td>
				<td><label>Telephone Number</label><br /> <input
					name="TelephoneNumber" id="TelephoneNumber" type="text"
					value="<%=sbObj2.getPhone()%>" readonly="readonly" /></td>
				<td><label>Email</label><br /> <input type="text"
					name="Email" id="email" value="<%=sbObj2.getEmail()%>"
					readonly="readonly" /></td>

			</tr>
			<tr>
				<td><label>URL</label><br /> <input name="url" type="text"
					value="<%=sbObj2.getURL()%>" readonly="readonly" /></td>
				<td><label>Date of Survey:</label><br /> <input type="text"
					name="date" id="DateOfSurvey" value="<%=sbObj2.getDate()%>"
					readonly="readonly" /></td>
				<td><label>Data entered </label><br /> <input type="text"
					name="data" value="<%=sbObj2.getData()%>" readonly="readonly" /></td>
			<tr>
				<td><label>LikeMost</label><br /> <input name="LikeMost"
					type="text" value="<%=sbObj2.getThingsLiked()%>" readonly="readonly" /></td>
				<td><label>HowToSite</label><br /> <input name="HowToSite"
					type="text" value="<%=sbObj2.getHowInterested()%>" readonly="readonly" />
				</td>
				<td><label>Likelihood</label><br /> <input name="Likelihood"
					type="text" value="<%=sbObj2.getLikelihood()%>" readonly="readonly" /></td>

			</tr>
			
			<tr>
				<td><label>GradMonth</label><br /> <input type="text"
					name="GradMonth" value="<%=sbObj2.getGradMonth()%>" readonly="readonly" /></td>
				<td><label>Year</label><br /> <input type="text" name="Year"
					value="<%=sbObj2.getYear()%>" readonly="readonly" /></td>
					
					<td><label>Comments</label><br /> <input type="text" name="comments"
					value="<%=sbObj2.getComments()%>" readonly="readonly" /></td>
			</tr>
		</table>
	</form>
</body>
</html>