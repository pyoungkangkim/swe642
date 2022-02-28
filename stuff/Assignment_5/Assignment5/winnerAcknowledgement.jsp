<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Winner !!!!</title>
</head>
<body>

<h1>Winner Acknowledgement</h1>
	<h3>Congratulations !You have won 2 movie tickets. Apply promoCode SWE642.</h3>
	<h4>Thank you</h4>
	<h3>
		<strong>Mean : </strong><s:property value="datab.getMean()"/><br>
	</h3>
	<h3>
		<strong>Standard Deviation :</strong><s:property value="datab.getSd()"/>
	</h3>
	<h3>
	Click on the Student ID's below to retrieve the saved form data.
	</h3>
	<h3>
	<s:iterator value="id_string" >
	<a href="/Assignment5/list?id=<s:property/>"><s:property/></a><br/>
	</s:iterator>
	</h3>

</body>
</html>