<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>JSP Page Scope Example</title>       
</head>
<body>
    <c:set var="name" value="Dinesh" scope="page" />
    Local Variable: <c:out value="${name}" />
    <a href="second.jsp">Test Page</a>
</body>
</html>
