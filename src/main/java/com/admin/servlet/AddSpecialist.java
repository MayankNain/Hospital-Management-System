package com.admin.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.dao.SpecialistDao;
import com.db.DBConnect;
@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String specName = req.getParameter("specName");
		SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
		
		boolean f = dao.addSpecialist(specName);
		HttpSession session = req.getSession();
		
		if (f) {
			session.setAttribute("succMsg", "Specialist Added");
			resp.sendRedirect("admin/index.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on Server");
			resp.sendRedirect("admin_login.jsp");
		}
	}

}
