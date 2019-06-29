package com.itp.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import com.itp.service.ForgottenPasswordService;
import com.itp.util.CommonConstants;

@WebServlet("/ForgottenPasswordServlet")
public class ForgottenPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(LoginHandlerServlet.class.getName());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userType= request.getParameter("user_type");
		String userID;
		String email = request.getParameter("uemail");
		
		System.out.println(userType+email);
		
		if(userType.equals("student")) {
				boolean foundStudentIDEmail =false;
				
				Student stdObj = new Student();
				stdObj.setsId(request.getParameter("uname_student"));
				stdObj.setEmail(email);
				//DB check
					//found student sid address
					//set boolean
					ForgottenPasswordService fps = new ForgottenPasswordService();
					try {
						foundStudentIDEmail =fps.ValidateStudentIdAndEmail(stdObj);
					} catch (DatabaseErrorException e) {
						log.error("error on checking student");
					}
				
					System.out.println("---> Found status: "+foundStudentIDEmail);
					
				if(foundStudentIDEmail == true) {
					
					try {
						//send email
						sendEmailLinkToUpdatePassword(stdObj);	
					
					} catch (Exception e) {
						CustomError err = new CustomError();
						err.setName("Email error!");
						err.setDescription1("Error occured while sending email.");
						request.setAttribute("EmailErr", err);
						RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
						rd.forward(request, response);
					}
						
					
					request.setAttribute("stdUserSent", stdObj);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
					return;
					//redirect to forgot password page with email successfully sent message
				}else {
					//redirect to forgot password page with error userID or email not found
					request.setAttribute("stdUser", stdObj);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
				}
				
		}else if (userType.equals("administrative_staff")) {
				
				boolean foundAdministrativeStaffIDEmail =false;
				
					AdministrativeStaff adstf = new AdministrativeStaff();
					adstf.setStfID(request.getParameter("uname_administrative_staff"));
					adstf.setEmail(email);
					//DB check
					//found Administrative Staff id and Email
					//set boolean
					ForgottenPasswordService fps = new ForgottenPasswordService();
					try {
						foundAdministrativeStaffIDEmail =fps.ValidateAdministrativeStaffIdAndEmail(adstf);
					} catch (DatabaseErrorException e) {
						log.error("error on checking Administrative Staff");
					}
				
					System.out.println("---> Administrative staff found status: "+foundAdministrativeStaffIDEmail);
				
				if(foundAdministrativeStaffIDEmail == true) {
					//send email					
					try {
							//send email
							sendEmailLinkToUpdatePassword(adstf);	
						
						} catch (Exception e) {
							CustomError err = new CustomError();
							err.setName("Email error!");
							err.setDescription1("Error occured while sending email.");
							request.setAttribute("EmailErr", err);
							RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
							rd.forward(request, response);
						}
						request.setAttribute("adstfSent", adstf);
						RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
						rd.forward(request, response);
						return;
					//redirect to forgot password page with email successfully sent message
				
					
					//redirect to forgot password page with email successfully sent message
				}else {
					//redirect to forgot password page with error userID or email not found
					request.setAttribute("adstfUser", adstf);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
				}
			
		}else if (userType.equals("academic_staff")) {
			
				boolean foundAcademicStaffIDEmail =false;
					
					AcademicStaff acdstf = new AcademicStaff();
					acdstf.setStfID(request.getParameter("uname_academic_staff"));
					acdstf.setEmail(email);
					//DB check
					//found Academic Staff id and Email
					//set boolean
					ForgottenPasswordService fps = new ForgottenPasswordService();
					try {
						foundAcademicStaffIDEmail =fps.ValidateAcademicStaffIdAndEmail(acdstf);
					} catch (DatabaseErrorException e) {
						log.error("error on checking Academic staff");
					}
				
					System.out.println("---> Academic staff found status: "+foundAcademicStaffIDEmail);
					
				
				if(foundAcademicStaffIDEmail == true) {

					//send email					
					try {
							//send email
							sendEmailLinkToUpdatePassword(acdstf);	
						
						} catch (Exception e) {
							CustomError err = new CustomError();
							err.setName("Email error!");
							err.setDescription1("Error occured while sending email.");
							request.setAttribute("EmailErr", err);
							RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
							rd.forward(request, response);
						}
						request.setAttribute("acdstfSent", acdstf);
						RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
						rd.forward(request, response);
						return;
				
					//redirect to forgot password page with email successfully sent message
				}else {
					//redirect to forgot password page with error userID or email not found
					request.setAttribute("acdstfUser", acdstf);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
				}
			
		}else if (userType.equals("admin")) {
			
				boolean foundAdminIDEmail =false;
					
					Admin admin = new Admin();
					admin.setaID(request.getParameter("uname_admin"));
					admin.setEmail(email);
					
					//DB check
					//found Admin id and Email
					//set boolean
				
					ForgottenPasswordService fps = new ForgottenPasswordService();
					try {
						foundAdminIDEmail =fps.AdminIdAndEmail(admin);
					} catch (DatabaseErrorException e) {
						log.error("error on checking Admin");
					}
				
					System.out.println("---> Admin found status: "+foundAdminIDEmail);
					
				if(foundAdminIDEmail == true) {
					//send email
					try {
					//send email
						sendEmailLinkToUpdatePassword(admin);	
					
					} catch (Exception e) {
						CustomError err = new CustomError();
						err.setName("Email error!");
						err.setDescription1("Error occured while sending email.");
						request.setAttribute("EmailErr", err);
						RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
						rd.forward(request, response);
					}
					request.setAttribute("adminSent", admin);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
					return;
					
					//redirect to forgot password page with email successfully sent message
				}else {
					//redirect to forgot password page with error userID or email not found
					request.setAttribute("adminUser", admin);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
				}
			
		}else if (userType.equals("parent")) {
				boolean foundParentIDEmail =false;
					
					Parent prn = new Parent();
					prn.setPid(request.getParameter("uname_parent"));
					prn.setEmail(email);
					
					//DB check
					//found Parent id and Email
					//set boolean
				
					ForgottenPasswordService fps = new ForgottenPasswordService();
					try {
						foundParentIDEmail =fps.ParentIdAndEmail(prn);
					} catch (DatabaseErrorException e) {
						log.error("error on checking Parent");
					}
				
					System.out.println("---> Parent found status: "+foundParentIDEmail);
					
					
				if(foundParentIDEmail == true) {

					try {
					//send email
						sendEmailLinkToUpdatePassword(prn);	
					
					} catch (Exception e) {
						CustomError err = new CustomError();
						err.setName("Email error!");
						err.setDescription1("Error occured while sending email.");
						request.setAttribute("EmailErr", err);
						RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
						rd.forward(request, response);
					}
					request.setAttribute("prnSent", prn);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
					return;
					
					//redirect to forgot password page with email successfully sent message
				}else {
					//redirect to forgot password page with error userID or email not found
					request.setAttribute("prnUser", prn);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
				}
		}else if(userType.equals("ob_member")) {
				boolean foundOBMemberIDEmail =false;
					
					OBMember obm = new OBMember();
					obm.setObID(request.getParameter("uname_ob_member"));
					obm.setEmail(email);
					
					//DB check
					//found Parent id and Email
					//set boolean
					ForgottenPasswordService fps = new ForgottenPasswordService();
					try {
						foundOBMemberIDEmail =fps.OBMemberIdAndEmail(obm);
					} catch (DatabaseErrorException e) {
						log.error("error on checking OB Member ");
					}
				
					System.out.println("---> OBMember found status: "+foundOBMemberIDEmail);
				
				if(foundOBMemberIDEmail == true) {
					//send email
					try {
						//send email
							sendEmailLinkToUpdatePassword(obm);	
						
						} catch (Exception e) {
							CustomError err = new CustomError();
							err.setName("Email error!");
							err.setDescription1("Error occured while sending email.");
							request.setAttribute("EmailErr", err);
							RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
							rd.forward(request, response);
						}
						request.setAttribute("obmSent", obm);
						RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
						rd.forward(request, response);
						return;
					//redirect to forgot password page with email successfully sent message
				}else {
					//redirect to forgot password page with error userID or email not found
					request.setAttribute("obUser", obm);
					RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
					rd.forward(request, response);
				}
		}
		
		
		CustomError er = new CustomError();
		er.setName("Unknown User Type");
		er.setDescription1("System Error Occured.");
		
		request.setAttribute("error", er);
		
		RequestDispatcher rd = request.getRequestDispatcher("/forgottenPassword.jsp");
		rd.forward(request, response);
	}



	private void sendEmailLinkToUpdatePassword(Student obj) {
				
			System.out.println("Ready to send message...");
			
			String to =  obj.getEmail();
			final String from =CommonConstants.SCHOOL_EMAIL_ADDRESS;
			Properties properties = new Properties();
			
			properties.put("mail.smtp.auth","true");
			properties.put("mail.smtp.starttls","true");
			properties.put("mail.smtp.host","smtp.gmail.com");
			properties.put("mail.smtp.port",587);
		
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, CommonConstants.SCHOOL_EMAIL_PASSWORD);
				}
			});
			
			try {
				
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Update Password");
				message.setText("Dear Student,  Please click the following link to update your password.\n\n\n\n"
						+ " http://localhost:8081/schoolmanagement/updatePassword.jsp?type=student&id="+obj.getsId()
						+ "\n\n\n\n\n\n\n\nThis is a system generated message. Do not reply.");
				
				properties.put("mail.smtp.starttls.enable", "true");
				Transport.send(message);
				System.out.println("Message sent successfully");
			}catch(MessagingException mex) {
				mex.printStackTrace();
			}		
	}
	
	
	private void sendEmailLinkToUpdatePassword(AdministrativeStaff obj) {
		System.out.println("Ready to send message...");
		
		String to =  obj.getEmail();
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
	
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("asokacollegecolombo10@gmail.com", "itpgroup");
			}
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("asokacollegecolombo10@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Update Password");
			message.setText("Dear Administrative Staff,  Please click the following link to update your password.\n\n\n\n"
					+ " http://localhost:8081/schoolmanagement/updatePassword.jsp?type=administrative_staff&id="+obj.getStfID()
					+ "\n\n\n\n\n\n\n\nThis is a system generated message. Do not reply.");
			
			properties.put("mail.smtp.starttls.enable", "true");
			Transport.send(message);
			System.out.println("Message sent successfully");
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}		
	}
	
	
	
	private void sendEmailLinkToUpdatePassword(AcademicStaff obj) {
			

		System.out.println("Ready to send message...");
		
		String to =  obj.getEmail();
		final String from =CommonConstants.SCHOOL_EMAIL_ADDRESS;
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
	
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, CommonConstants.SCHOOL_EMAIL_PASSWORD);
			}
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Update Password");
			message.setText("Dear Academic Staff,  Please click the following link to update your password.\n\n\n\n"
					+ " http://localhost:8081/schoolmanagement/updatePassword.jsp?type=academic_staff&id="+obj.getStfID()
					+ "\n\n\n\n\n\n\n\nThis is a system generated message. Do not reply.");
			
			properties.put("mail.smtp.starttls.enable", "true");
			Transport.send(message);
			System.out.println("Message sent successfully");
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}			
	}

	
	private void sendEmailLinkToUpdatePassword(Admin obj) {
	
		System.out.println("Ready to send message...");
		
		String to =  obj.getEmail();
		final String from =CommonConstants.SCHOOL_EMAIL_ADDRESS;
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
	
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, CommonConstants.SCHOOL_EMAIL_PASSWORD);
			}
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Update Password");
			message.setText("Dear Admin,  Please click the following link to update your password.\n\n\n\n"
					+ " http://localhost:8081/schoolmanagement/updatePassword.jsp?type=admin&id="+obj.getaID()
					+ "\n\n\n\n\n\n\n\nThis is a system generated message. Do not reply.");
			
			properties.put("mail.smtp.starttls.enable", "true");
			Transport.send(message);
			System.out.println("Message sent successfully");
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}			
	}
	
	
	private void sendEmailLinkToUpdatePassword(Parent obj) {

		System.out.println("Ready to send message...");
		
		String to =  obj.getEmail();
		final String from =CommonConstants.SCHOOL_EMAIL_ADDRESS;
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
	
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, CommonConstants.SCHOOL_EMAIL_PASSWORD);
			}
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Update Password");
			message.setText("Dear Parent,  Please click the following link to update your password.\n\n\n\n"
					+ " http://localhost:8081/schoolmanagement/updatePassword.jsp?type=parent&id="+obj.getPid()
					+ "\n\n\n\n\n\n\n\nThis is a system generated message. Do not reply.");
			
			properties.put("mail.smtp.starttls.enable", "true");
			Transport.send(message);
			System.out.println("Message sent successfully");
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}			
	}
	
	private void sendEmailLinkToUpdatePassword(OBMember obj) {
		
		System.out.println("Ready to send message...");
		
		String to =  obj.getEmail();
		final String from =CommonConstants.SCHOOL_EMAIL_ADDRESS;
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
	
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, CommonConstants.SCHOOL_EMAIL_PASSWORD);
			}
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Update Password");
			message.setText("Dear OB Member,  Please click the following link to update your password.\n\n\n\n"
					+ " http://localhost:8081/schoolmanagement/updatePassword.jsp?type=ob_member&id="+obj.getObID()
					+ "\n\n\n\n\n\n\n\nThis is a system generated message. Do not reply.");
			
			properties.put("mail.smtp.starttls.enable", "true");
			Transport.send(message);
			System.out.println("Message sent successfully");
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}			
	
		
	}
}
