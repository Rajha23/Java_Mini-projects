<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Addition Using JSP</title>
</head>
<body>

<h2>JSP Addition Program</h2>

<form action="addition.jsp" method="post">
    Enter Number 1: <input type="text" name="n1"><br><br>
    Enter Number 2: <input type="text" name="n2"><br><br>
    <input type="submit" value="Add">
</form>

<%
String a = request.getParameter("n1");
String b = request.getParameter("n2");

if(a != null && b != null && !a.equals("") && !b.equals("")) {
    try {
        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(b);
        int sum = n1 + n2;
%>

<h3>Result:</h3>
<p>Sum = <%= sum %></p>

<%
    } catch(Exception e) {
%>
<p style="color:red">Please enter valid numbers</p>
<%
    }
}
%>

</body>
</html>