<%@page import="isms.hibernate.models.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	User user1 = (User) session.getAttribute("user");
%>
<jsp:useBean id="user" class="isms.hibernate.models.User"
	scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Welcome :User Info from get attribute..</h1>
	<br>
	<h5><%=user1.getUserName()%></h5>
	<h5><%=user1.getEmail()%></h5>
	<h5><%=user1.getPhoneNumber()%></h5>
	<h5><%=user1.getUserType()%></h5>
	<br>
	<br>
	<br>
	<h1>Welcome :User Info from jsp bean</h1>
	<br>
	<h5><jsp:getProperty property="userName" name="user" /></h5>
	<h5><jsp:getProperty property="email" name="user" /></h5>
<h5><jsp:getProperty property="phoneNumber" name="user"/></h5>
	<h5><%=user1.getUserType()%></h5>
</body>
</html>