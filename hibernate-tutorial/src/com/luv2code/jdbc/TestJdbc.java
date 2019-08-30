package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://192.168.100.109:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		try {

			System.out.println("Connection to Database: " + jdbcUrl);
			Connection myconn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successfull !!!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
