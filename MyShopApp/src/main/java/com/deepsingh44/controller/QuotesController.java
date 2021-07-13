package com.deepsingh44.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.deepsingh44.dao.QuotesDao;
import com.deepsingh44.model.Quotes;

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

	private void getAllQuotes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Quotes> quotes = QuotesDao.getQuotesDao().getAllQuotes();
		req.getServletContext().setAttribute("quotes", quotes);
		resp.sendRedirect("quoteslist.jsp");

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

		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setRepository(new File("E://"));
		Quotes quotes = new Quotes();
		boolean status = ServletFileUpload.isMultipartContent(req);
		if (status) {
			ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
			try {
				List<FileItem> items = upload.parseRequest(req);
				Iterator<FileItem> it = items.iterator();
				while (it.hasNext()) {
					FileItem item = it.next();

					if (item.isFormField()) {
						if (item.getFieldName().equalsIgnoreCase("title")) {
							quotes.setTitle(item.getString());
						}
						if (item.getFieldName().equalsIgnoreCase("desc")) {
							quotes.setDescription(item.getString());
						}
					} else {

						String root = req.getServletContext().getRealPath("/");
						File folder = new File(root, "images");
						if (!folder.exists())
							folder.mkdir();

						File fileDetail = File.createTempFile("quotes", ".jpg", folder);
						FileOutputStream fo = new FileOutputStream(fileDetail.getAbsolutePath());
						fo.write(item.get());
						fo.close();
						quotes.setImage(fileDetail.getName());
						System.out.println(fileDetail.getAbsolutePath());

					}
				}

				int i = QuotesDao.getQuotesDao().insert(quotes);
				if (i > 0) {
					resp.getWriter().print("Successfully Quotes Added");
				} else {
					resp.getWriter().print("Quotes Added Failed");
				}
				req.getRequestDispatcher("add.jsp").include(req, resp);

			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.WARNING, e.toString());
			}

		}
	}

}
