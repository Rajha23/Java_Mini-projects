<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Feedback Form</title>
</head>
<body>

<h2>Feedback Form</h2>

<form action="" method="post">
    Name: <input type="text" name="name"><br><br>
    Feedback:<br>
    <textarea name="feedback" rows="5" cols="30"></textarea><br><br>
    <input type="submit" value="Submit">
</form>

<%
    String name = request.getParameter("name");
    String fb = request.getParameter("feedback");

    if(name != null && fb != null && !name.equals("") && !fb.equals(""))
    {
%>
        <h3>Thank you, <%= name %> for your feedback!</h3>
<%
    }
%>

</body>
</html>