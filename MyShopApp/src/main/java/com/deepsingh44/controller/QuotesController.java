package com.deepsingh44.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepsingh44.dao.QuotesDao;

@WebServlet("/quotes")
public class QuotesController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String opt = req.getParameter("opt");
		if (opt != null) {
			int choice = Integer.parseInt(opt);
			switch (choice) {
			case 1:
				insertQuotes(req, resp);
				break;
			case 2:
				deleteQuotes(req, resp);
				break;
			case 3:
				updateQuotes(req, resp);
				break;
			case 4:
				findQuotes(req, resp);
				break;
			case 5:
				getAllQuotes(req, resp);
				break;

			}
		}
	}

	private void getAllQuotes(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void findQuotes(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void updateQuotes(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void deleteQuotes(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void insertQuotes(HttpServletRequest req, HttpServletResponse resp) {
		int i = QuotesDao.getQuotesDao().insert(quotes);
		if (i > 0) {
			resp.getWriter().print("Successfully Quotes Added");
		} else {
			resp.getWriter().print("Quotes Added Failed");
		}
		req.getRequestDispatcher("add.jsp").include(req, resp);
	}

}
