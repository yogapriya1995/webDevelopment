package net.javaguides.login.database;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import net.javaguides.login.bean.LoginBean;

public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;
		String user= loginBean.getUsername();
		String password=loginBean.getPassword();
		if(loginBean.getUsername().equalsIgnoreCase("admin")&& loginBean.getPassword().equalsIgnoreCase("admin"))
		{
			status=true;
		}

		return status;
	}


}
