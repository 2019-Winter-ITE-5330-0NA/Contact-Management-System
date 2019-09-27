<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>

<%String table= (String) request.getAttribute("table"); %>
<body>
<h1>My Contacts</h1>
<%= table %>
<a href="V_11_AddForm.jsp">Add New Contact</a>
</body>
</html>