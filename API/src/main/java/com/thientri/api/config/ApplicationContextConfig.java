package com.thientri.api.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
@Configuration
 
@ComponentScan("com.thientri.api.*")
 
public class ApplicationContextConfig {
	
	public static Connection getConnection() {
		try {
			String connectionurl = "jdbc:mysql://localhost:3306/diemdanhsinhvien?useUnicode=true&characterEncoding=utf-8";
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection(connectionurl,"root","");
        	return con;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
  
}
