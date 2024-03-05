<%--
  Created by IntelliJ IDEA.
  User: swapnil farande
  Date: 28-02-2024
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create StudentForm</title>
    <link rel="stylesheet" href="demo1.css">
</head>
<body>
<form action="http://localhost:8086/Spring_mvc_javaway_002_war/student/create" method="post">
    <table style="border: 10px">
        <tr>
            <td>Id</td>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>City</td>
            <td><input type="text" name="city"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="number" name="phone"></td>
        </tr>
        <tr>

            <td><input type="submit" value="Add Student"></td>
            <td><input type="reset" value="reset"></td>
        </tr>


    </table>




</form>

</body>
</html>
