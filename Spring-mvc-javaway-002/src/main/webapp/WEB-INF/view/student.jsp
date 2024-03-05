<%@ page import="com.app.Model.Student" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: swapnil farande
  Date: 23-02-2024
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentRegisration Form</title>
</head>
<body>
<
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
    PrintWriter printWriter = response.getWriter();
    printWriter.println("<html><head><style>");
    printWriter.println("table {border-collapse: collapse; width: 100%;}");
    printWriter.println("th, td {border: 1px solid black; padding: 8px; text-align: left;}");
    printWriter.println("</style></head><body>");
    printWriter.println("<table><tr><th>StudentId</th> <th>StudentName</th> <th>StudentCity</th> <th>StudentPhone</th></tr>");


    for (Student student:students){

        printWriter.println("<tr>");
        printWriter.println("<td>"+student.getStudentId()+"</td>");
        printWriter.println("<td>"+student.getStudentName()+"</td>");
        printWriter.println("<td>"+student.getStudentCity()+"</td>");
        printWriter.println("<td>"+student.getStudentPhone()+"</td>");
        printWriter.println("</tr>");

        //printWriter.println(student);
    }
    printWriter.println("</table></body></html");
%>


</body>
</html>
