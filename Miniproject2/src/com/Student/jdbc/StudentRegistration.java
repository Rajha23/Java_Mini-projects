package com.Student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in);

		        try {
		            // 1. Load JDBC Driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // 2. Create Connection
		            Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/student",
		                "root",
		                "root"
		            );

		            // 3. Read student details
		            System.out.print("Enter Student Name: ");
		            String name = sc.nextLine();

		            System.out.print("Enter Roll Number: ");
		            int roll = sc.nextInt();
		            sc.nextLine(); // buffer clear

		            System.out.print("Enter Department: ");
		            String dept = sc.nextLine();

		            // 4. SQL Insert Query
		            String query = "INSERT INTO students(name, roll, dept) VALUES (?, ?, ?)";

		            // 5. PreparedStatement
		            PreparedStatement ps = con.prepareStatement(query);
		            ps.setString(1, name);
		            ps.setInt(2, roll);
		            ps.setString(3, dept);

		            // 6. Execute Query
		            int rows = ps.executeUpdate();

		            if (rows > 0) {
		                System.out.println("Student Registered Successfully!");
		            }

		            // 7. Close connection
		            ps.close();
		            con.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        sc.close();
		    }
		

	}



