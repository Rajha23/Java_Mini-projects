package com.salary.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
System.out.print("Enter Employee ID: ");
int empId = sc.nextInt();
String url = "jdbc:mysql://localhost:3306/company", 
user = "root", 
password = "Thejuswini@2006";
String query = "SELECT name, salary FROM employees WHERE emp_id = ?";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,user,password);
	PreparedStatement ps = con.prepareStatement(query);
	ps.setInt(1, empId);	
	ResultSet rs = ps.executeQuery();
	 if (rs.next()) {
         System.out.println("\nEmployee Name: " + rs.getString("name"));
         System.out.println("Salary: ₹" + rs.getDouble("salary"));
     } else {
         System.out.println("\nRecord not found!");
     }

     rs.close();
     ps.close();
     con.close();
} catch (Exception e) {
	e.printStackTrace();
}
sc.close();	}

}
