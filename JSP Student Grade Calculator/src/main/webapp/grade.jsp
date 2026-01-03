<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Grade Calculator</title>
</head>
<body>

<h2>Student Grade Calculator</h2>

<form>
    Enter Marks: <input type="text" name="marks">
    <input type="submit" value="Check Grade">
</form>

<%
    String m = request.getParameter("marks");

    if(m != null && !m.equals(""))
    {
        int marks = Integer.parseInt(m);
        String grade = "";

        if(marks >= 90)
            grade = "A";
        else if(marks >= 75)
            grade = "B";
        else
            grade = "C";

        out.print("<h3>Your Grade is: " + grade + "</h3>");
    }
%>

</body>
</html>