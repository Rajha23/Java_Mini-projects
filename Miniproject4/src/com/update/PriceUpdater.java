package com.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PriceUpdater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product ID:");
		int id = sc.nextInt();
		System.out.println("Enter New Price: ");
		double price = sc.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pricedb","root","root");
			String sql = "UPDATE products SET price = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, price);
			ps.setInt(2, id);
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
                System.out.println("Product price updated successfully!");
            } else {
                System.out.println("Product ID not found.");
            }
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		sc.close();
	}
}

