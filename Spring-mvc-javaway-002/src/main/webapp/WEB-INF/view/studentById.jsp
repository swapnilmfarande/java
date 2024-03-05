<%@ page import="com.app.Model.Student" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: swapnil farande
  Date: 26-02-2024
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Student By Id</title>
</head>
<body>
<%
    Student student = (Student) request.getAttribute("studentById");
    PrintWriter writer = response.getWriter();
    writer.println(student);
%>

</body>
</html>
