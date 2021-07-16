package com.deepsingh44.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.deepsingh44.model.Quotes;
import com.deepsingh44.model.User;

public class UserDao {
	private static UserDao userDao = new UserDao();

	private UserDao() {
	}

	public static UserDao getUserDao() {
		return userDao;
	}

	public int insert(User user) {
		int i = 0;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());
			i = ps.executeUpdate();
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
		}
		return i;
	}

	public User login(String email, String pass) {
		User user = null;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("select * from users where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString(1));
				user.setEmail(rs.getString("email"));
				user.setPass(rs.getString(3));
			}
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
		}
		return user;
	}

}
