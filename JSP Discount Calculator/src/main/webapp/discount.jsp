<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Discount Calculator</title>
</head>
<body>

<h2>JSP Discount Calculator</h2>

<form action="discount.jsp" method="post">
    Enter Price: <input type="text" name="price"><br><br>
    Enter Discount (%): <input type="text" name="discount"><br><br>
    <input type="submit" value="Calculate">
</form>

<%
    String p = request.getParameter("price");
    String d = request.getParameter("discount");

    if(p != null && d != null && !p.equals("") && !d.equals(""))
    {
        double price = Double.parseDouble(p);
        double discount = Double.parseDouble(d);

        double finalPrice = price - (price * discount / 100);

%>

<h3>
Original Price: <%= price %> <br>
Discount: <%= discount %> % <br>
Final Payable Amount: <b><%= finalPrice %></b>
</h3>

<%
    }
%>

</body>
</html>