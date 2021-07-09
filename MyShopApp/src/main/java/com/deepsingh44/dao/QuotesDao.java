package com.deepsingh44.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.deepsingh44.model.Quotes;

public class QuotesDao {

	private static QuotesDao quotesDao = new QuotesDao();

	private QuotesDao() {
	}

	public static QuotesDao getQuotesDao() {
		return quotesDao;
	}

	public int insert(Quotes quotes) {
		int i = 0;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("insert into quotes values(default,?,?,?)");
			ps.setString(1, quotes.getTitle());
			ps.setString(2, quotes.getDescription());
			ps.setString(3, quotes.getImage());
			i = ps.executeUpdate();
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
		}
		return i;
	}

	public int delete(int id) {
		int i = 0;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("delete from quotes where id=?");
			ps.setInt(1, id);
			i = ps.executeUpdate();
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
		}
		return i;
	}

	public Quotes find(String title) {
		Quotes quotes = null;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("SELECT * from quotes WHERE title LIKE ?");
			ps.setString(1, title + "%");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				quotes = new Quotes();
				quotes.setId(rs.getInt(1));
				quotes.setTitle(rs.getString(2));
				quotes.setDescription(rs.getString(3));
				quotes.setImage(rs.getString(4));
			}
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
		}
		return quotes;
	}

	public int update(Quotes quotes) {
		int i = 0;
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("update quotes set title=?, description=?, image=? where id=?");
			ps.setString(1, quotes.getTitle());
			ps.setString(2, quotes.getDescription());
			ps.setString(3, quotes.getImage());
			ps.setInt(4, quotes.getId());
			i = ps.executeUpdate();
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
		}
		return i;
	}

	public List<Quotes> getAllQuotes() {
		List<Quotes> quotesList = new ArrayList<Quotes>();
		try (Connection con = Dao.getConnection();) {
			PreparedStatement ps = con.prepareStatement("select * from quotes");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Quotes quotes = new Quotes();
				quotes.setId(rs.getInt(1));
				quotes.setTitle(rs.getString(2));
				quotes.setDescription(rs.getString(3));
				quotes.setImage(rs.getString(4));
				quotesList.add(quotes);
			}
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
		}
		return quotesList;
	}

}
