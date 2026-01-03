package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BalanceCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account Number: ");
		int accNo = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb",
	                "root",
	                "Thejuswini@2006");
			String sql =  "SELECT holder_name, balance FROM accounts WHERE acc_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,accNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 System.out.println("Account Holder: " + rs.getString("holder_name"));
	                System.out.println("Account Balance: ₹" + rs.getDouble("balance"));
				
			} else {
				System.out.println("Account number not found!");
            
			}
		     rs.close();
	            ps.close();
	            con.close();
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
		}
sc.close();
	}

}
