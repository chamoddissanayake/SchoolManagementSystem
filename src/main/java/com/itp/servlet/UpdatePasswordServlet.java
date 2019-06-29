package com.itp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.itp.exception.DatabaseErrorException;
import com.itp.model.AcademicStaff;
import com.itp.model.Admin;
import com.itp.model.AdministrativeStaff;
import com.itp.model.CustomError;
import com.itp.model.OBMember;
import com.itp.model.Parent;
import com.itp.model.Student;
import com.itp.service.UpdatePasswordService;
import com.itp.util.PasswordUtils;


@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(UpdatePasswordServlet.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userType= request.getParameter("updateUserType");
		String userID =request.getParameter("updateUserId");
		String newPassword = request.getParameter("updateUserPassword");
		
        // Generate Salt. The generated value can be stored in DB. 
        String salt = PasswordUtils.getSalt(30);
        
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils.generateSecurePassword(newPassword, salt);
        
        UpdatePasswordService ups = new UpdatePasswordService();
        
		if(userType.equals("student")) {
		
				Student std = new Student();
				std.setSecured_password(mySecurePassword);
				std.setSalt(salt);
				std.setsId(userID);
						
				
				try {
					ups.updateStudentPassword(std);
					
					request.setAttribute("StdEdited", std);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				
				} catch (DatabaseErrorException e) {
					log.error("error on updating student");
					
					CustomError error = new CustomError();
					error.setName("Unknown error");
					error.setDescription1("Error occured ");
					request.setAttribute("error", error);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
			
		
		}else if(userType.equals("administrative_staff")) {
			
				AdministrativeStaff adstf = new AdministrativeStaff();
				adstf.setSecured_password(mySecurePassword);
				adstf.setSalt(salt);
				adstf.setStfID(userID);
						
				try {
					ups.updateAdministrativeStaffPassword(adstf);
					
					request.setAttribute("adstfEdited", adstf);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				
				} catch (DatabaseErrorException e) {
					log.error("error on updating Administrative Staff");
					
					CustomError error = new CustomError();
					error.setName("Unknown error");
					error.setDescription1("Error occured ");
					request.setAttribute("error", error);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
			
		}else if(userType.equals("academic_staff")) {
				AcademicStaff acds = new AcademicStaff();
				acds.setSecured_password(mySecurePassword);
				acds.setSalt(salt);
				acds.setStfID(userID);
				
				try {
					ups.updateAcademicStaffPassword(acds);
					
					request.setAttribute("acdsEdited", acds);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				
				} catch (DatabaseErrorException e) {
					log.error("error on updating Academic Staff");
					
					CustomError error = new CustomError();
					error.setName("Unknown error");
					error.setDescription1("Error occured ");
					request.setAttribute("error", error);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				
				
		}else if(userType.equals("admin")) {
				Admin admin = new Admin();
				admin.setSecured_password(mySecurePassword);
				admin.setSalt(salt);
				admin.setaID(userID);
				
				try {
					ups.updateAdminPassword(admin);
					
					request.setAttribute("adminEdited", admin);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				
				} catch (DatabaseErrorException e) {
					log.error("error on updating Admin");
					
					CustomError error = new CustomError();
					error.setName("Unknown error");
					error.setDescription1("Error occured ");
					request.setAttribute("error", error);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				
		}else if(userType.equals("parent")) {
				Parent prn = new Parent();
				prn.setSecured_password(mySecurePassword);
				prn.setSalt(salt);
				prn.setPid(userID);
					
				try {
					ups.updateParentPassword(prn);
					
					request.setAttribute("prnEdited", prn);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				
				} catch (DatabaseErrorException e) {
					log.error("error on updating Parent");
					
					CustomError error = new CustomError();
					error.setName("Unknown error");
					error.setDescription1("Error occured ");
					request.setAttribute("error", error);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
			
			
		}else if(userType.equals("ob_member")) {
				OBMember obm = new OBMember();
				obm.setSecured_password(mySecurePassword);
				obm.setSalt(salt);
				obm.setObID(userID);
				
				try {
					ups.updateOBMemberPassword(obm);
					
					request.setAttribute("obmEdited", obm);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				
				} catch (DatabaseErrorException e) {
					log.error("error on updating OBMember");
					
					CustomError error = new CustomError();
					error.setName("Unknown error");
					error.setDescription1("Error occured ");
					request.setAttribute("error", error);
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				
		}else {
			CustomError error = new CustomError();
			error.setName("User type not found");
			error.setDescription1("Error occured ");
			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		
	}
}
