<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My First JSP</title>
</head>
<body>
	Inorder to show how to use for in jsp .here I priint 10 welcome
	</br>
	<%
		for (int i = 0; i < 10; i++) {
	%>

	Welcome<%=i%>>
	</br>
	<%
		}
	%>
</body>
</html>