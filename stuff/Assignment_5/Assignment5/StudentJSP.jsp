<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/Style.css" />
<title>Student Data</title>
</head>
<body>

<h1> Student Data</h1>

<table align="center" border="1" style="border-style: solid;
    border-color: blue">
<tr><td><strong>Student Id:</strong><s:property value="stud_bean1.getStudentID()" /></td>
<td><strong>First Name:</strong> <s:property value="stud_bean1.getFName()" /></td>
<td><strong>Last Name:</strong> <s:property value="stud_bean1.getLName()" /></td></tr>
<tr><td><strong>E-mail:</strong> <s:property value="stud_bean1.getEmail()" /></td>
<td><strong>Telephone: </strong> <s:property value="stud_bean1.getPhone()" /></td>
<td><strong>Graduation Year:</strong> <s:property value="stud_bean1.getYear()" /></td></tr></tr>
<tr><td><strong>Street Address:</strong> <s:property value="stud_bean1.getStreet()" /></td>
<td><strong>Zip Code:</strong> <s:property value="stud_bean1.getZip()" /></td>
<td><strong>Standard Deviation:</strong> <s:property value="stud_bean1.getStandardDev()" /></td></tr>
<tr><td><strong>City:</strong> <s:property value="stud_bean1.getCity()" /></td>
<td><strong>State:</strong> <s:property value="stud_bean1.getState()" /></td>
<td><strong>What you like most about campus:</strong> <s:property value="stud_bean1.getThingsliked()" /></td></tr>
<tr><td><strong>Date Of Survey:</strong> <s:property value="stud_bean1.getDate()" /></td>
<td><strong>Graduation Month:</strong> <s:property value="stud_bean1.getGradMonth()" /></td>

<tr><td><strong>Data:</strong> <s:property value="stud_bean1.getData()" /></td>
<td><strong>Mean:</strong> <s:property value="stud_bean1.getMean()" /></td>
</tr>
<tr><td><strong>How you got to our site:</strong> <s:property value="stud_bean1.getHowinterested()" /></td>
<td><strong>How likely you are to recommend GMU:</strong> <s:property value="stud_bean1.getLikelihood()" /></td>
</tr>
<tr><td><strong>URL:</strong> <s:property value="stud_bean1.getUrl()" /></td>
<td><strong>Comments:</strong> <s:property value="stud_bean1.getComments()" /></td></tr>
</table>

</body>
</html>