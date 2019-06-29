package com.itp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.itp.exception.DatabaseErrorException;
import com.itp.model.AcademicStaff;
import com.itp.model.Admin;
import com.itp.model.AdministrativeStaff;
import com.itp.model.CustomError;
import com.itp.model.OBMember;
import com.itp.model.Parent;
import com.itp.model.Student;
import com.itp.service.IStudentService;
import com.itp.service.LoginTrackService;
import com.itp.service.StudentServiceImpl;
import com.itp.util.PasswordUtils;


@WebServlet("/LoginHandlerServlet")
public class LoginHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(LoginHandlerServlet.class.getName());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userType= request.getParameter("user_type");
		String username;
		String password = request.getParameter("upassword");
		
		if(userType.equals("student")) {
					username =request.getParameter("uname_student");
					
					Student stdObj = new Student();
					stdObj.setsId(username);
					stdObj.setPassword(password);
										
					IStudentService istudentservice = new StudentServiceImpl();
					Student obj=null;
					try {
						obj = istudentservice.searchStudentDetailsToVerify(stdObj);
					} catch (DatabaseErrorException e) {
						log.error("Error on login",e);
					}

					
					if(obj == null) {
						request.setAttribute("stdUser", stdObj);
						RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}else {
						
						String providedPassword= stdObj.getPassword().trim();
						String securePassword = obj.getSecured_password().trim();
						String salt =  obj.getSalt().trim();
							
						boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
						System.out.println(passwordMatch);
						if(passwordMatch) 
				        {
							trackLogin(stdObj);
							HttpSession session = request.getSession();
							session.setAttribute("sessionUsr", stdObj);
							response.sendRedirect("/SchoolManagementSystem/studentDashboard.jsp");
							return;
				        }else {
				        	request.setAttribute("stdUser", stdObj);
							RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
							rd.forward(request, response);
				        }
					}
					
			
		}else if(userType.equals("administrative_staff")) {
					username =request.getParameter("uname_administrative_staff");
					
					AdministrativeStaff adstf = new AdministrativeStaff();
					adstf.setStfID(username);
					adstf.setPassword(password);
					
					IStudentService istudentservice = new StudentServiceImpl();
					AdministrativeStaff obj=null;
					
					
					
					try {
						obj = istudentservice.searchAdministrativeStaffDetailsToVerify(adstf);
					} catch (DatabaseErrorException e) {
						log.error("Error on login",e);
					}
					
					if(obj == null) {
						request.setAttribute("adstfUser", adstf);
						RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}else {
						
						String providedPassword= adstf.getPassword().trim();
						String securePassword = obj.getSecured_password().trim();
						String salt =  obj.getSalt().trim();
							
						boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
						System.out.println(passwordMatch);
						if(passwordMatch) 
				        {
							trackLogin(adstf);
							HttpSession session = request.getSession();
							session.setAttribute("sessionUsr", adstf);
							response.sendRedirect("/SchoolManagementSystem/administrativeStaffDashboard.jsp");
							return;
				        }else {
				        	request.setAttribute("adstfUser", adstf);
							RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
							rd.forward(request, response);
				        }
					}
					
			
		}else if(userType.equals("academic_staff")){
					username =request.getParameter("uname_academic_staff");
					
					AcademicStaff acdstf = new AcademicStaff();
					acdstf.setStfID(username);
					acdstf.setPassword(password);
					
					IStudentService istudentservice = new StudentServiceImpl();
					AcademicStaff obj=null;
					
					try {
						obj = istudentservice.searchAcademicStaffDetailsToVerify(acdstf);
					} catch (DatabaseErrorException e) {
						log.error("Error on login",e);
					}

					
					if(obj == null) {
						request.setAttribute("acdstfUser", acdstf);
						RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}else {
						
						String providedPassword= acdstf.getPassword().trim();
						String securePassword = obj.getSecured_password().trim();
						String salt =  obj.getSalt().trim();
							
						boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
						System.out.println(passwordMatch);
						if(passwordMatch) 
				        {
							trackLogin(acdstf);
							HttpSession session = request.getSession();
							session.setAttribute("sessionUsr", acdstf);
							response.sendRedirect("/SchoolManagementSystem/academicStaffDashboard.jsp");
							return;
				        }else {
				        	request.setAttribute("acdstfUser", acdstf);
							RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
							rd.forward(request, response);
				        }
					}
			
		}else if(userType.equals("admin")) {
					username = request.getParameter("uname_admin");
					
					Admin admin = new Admin();
					admin.setaID(username);
					admin.setPassword(password);
			
					IStudentService istudentservice = new StudentServiceImpl();
					Admin obj=null;
					
					try {
						obj = istudentservice.searchAdminDetailsToVerify(admin);
					} catch (DatabaseErrorException e) {
						log.error("Error on login",e);
					}
					if(obj == null) {
						request.setAttribute("adminUser", admin);
						RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}else {
						
						String providedPassword= admin.getPassword().trim();
						String securePassword = obj.getSecured_password().trim();
						String salt =  obj.getSalt().trim();
							
						boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
						System.out.println(passwordMatch);
						if(passwordMatch) 
				        {
							trackLogin(admin);
							HttpSession session = request.getSession();
							session.setAttribute("sessionUsr", admin);
							response.sendRedirect("/SchoolManagementSystem/adminDashboard.jsp");
							return;
				        }else {
				        	request.setAttribute("adminUser", admin);
							RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
							rd.forward(request, response);
				        }
					}
					
			
		}else if(userType.equals("parent")) {
					username = request.getParameter("uname_parent");
					
					Parent prn = new Parent();
					prn.setPid(username);
					prn.setPassword(password);
			
					IStudentService istudentservice = new StudentServiceImpl();
					Parent obj=null;
					
					try {
						obj = istudentservice.searchParentDetailsToVerify(prn);
					} catch (DatabaseErrorException e) {
						log.error("Error on login",e);
					}
					if(obj == null) {
						request.setAttribute("prnUser", prn);
						RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}else {
						
						String providedPassword= prn.getPassword().trim();
						String securePassword = obj.getSecured_password().trim();
						String salt =  obj.getSalt().trim();
							
						boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
						System.out.println(passwordMatch);
						if(passwordMatch) 
				        {
							trackLogin(prn);
							HttpSession session = request.getSession();
							session.setAttribute("sessionUsr", prn);
							response.sendRedirect("/SchoolManagementSystem/parentDashboard.jsp");
							return;
				        }else {
				        	request.setAttribute("prnUser", prn);
							RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
							rd.forward(request, response);
				        }
					}
					
		}else if(userType.equals("ob_member")) {
					username= request.getParameter("uname_ob_member");
					
					OBMember obm = new OBMember();
					obm.setObID(username);
					obm.setPassword(password);
					
					IStudentService istudentservice = new StudentServiceImpl();
					OBMember obj=null;
					
					try {
						obj = istudentservice.searchOBMemberDetailsToVerify(obm);
					} catch (DatabaseErrorException e) {
						log.error("Error on login",e);
					}
					if(obj == null) {
						request.setAttribute("obUser", obm);
						RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}else {
						
						String providedPassword= obm.getPassword().trim();
						String securePassword = obj.getSecured_password().trim();
						String salt =  obj.getSalt().trim();
							
						boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
						System.out.println(passwordMatch);
						if(passwordMatch) 
				        {
							trackLogin(obm);
							HttpSession session = request.getSession();
							session.setAttribute("sessionUsr", obm);
							response.sendRedirect("/SchoolManagementSystem/obDashboard.jsp");
							return;
				        }else {
				        	request.setAttribute("obUser", obm);
							RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
							rd.forward(request, response);
				        }
					}
					
			}
						
			CustomError er = new CustomError();
			er.setName("Unknown User Type");
			er.setDescription1("System Error Occured.");
			
			request.setAttribute("error", er);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
	 }

	private void trackLogin(Object obj) {
		LoginTrackService loginTrack = new LoginTrackService();
		
		if(obj instanceof Student) {
			try {
				loginTrack.trackStudentLoginDetails((Student)obj);
			} catch (DatabaseErrorException e) {
				log.error("Error while tracking student",e);
			}
		}else if(obj instanceof AdministrativeStaff) {
			try {
				loginTrack.trackAdministrativeStaffLoginDetails((AdministrativeStaff)obj);
			} catch (DatabaseErrorException e) {
				log.error("Error while tracking AdministrativeStaff",e);
			}
		}else if(obj instanceof AcademicStaff) {
			try {
				loginTrack.trackAcademicStaffLoginDetails((AcademicStaff)obj);
			} catch (DatabaseErrorException e) {
				log.error("Error while tracking AcademicStaff",e);
			}
		}else if(obj instanceof Admin) {
			try {
				loginTrack.trackAdminLoginDetails((Admin)obj);
			} catch (DatabaseErrorException e) {
				log.error("Error while tracking Admin",e);
			}
		}else if(obj instanceof Parent) {
			try {
				loginTrack.trackParentLoginDetails((Parent)obj);
			} catch (DatabaseErrorException e) {
				log.error("Error while tracking Parent",e);
			}
		}else if(obj instanceof OBMember) {
			try {
				loginTrack.trackOBMemberLoginDetails((OBMember)obj);
			} catch (DatabaseErrorException e) {
				log.error("Error while tracking OB Member",e);
			}
		}else {
			log.error("Unsupported object type");
		}
		
	}
}
