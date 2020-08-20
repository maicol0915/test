package dagachi.service.customer;

import java.util.HashMap;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import dagachi.dao.customer.Customer_Login_Dao;
import dagachi.dto.customer.Customer_Login_Dto;
import dagachi.dto.customer.Customer_SignUp_Dto;
import lombok.Setter;

@Service
public class Customer_Login_ServiceImpl implements Customer_Login_Service {

	@Inject
	private Customer_Login_Dao dao;
	@Setter
	@Autowired
	protected JavaMailSender mailSender;

	// 회원가입
	@Override
	public void register(Customer_SignUp_Dto dto) throws Exception {
		System.out.println(dto);
		dao.insert(dto);
	}

	public void insert(Customer_SignUp_Dto dto) throws Exception {
		dao.insert(dto);
	}

	@Override
	public Customer_Login_Dto login(Customer_Login_Dto dto) throws Exception {
		return dao.login(dto);

	}

	public int ID(String customer_Email) {
		int num = dao.ID(customer_Email);
		return num;
	}

	public boolean emailCertification(HttpSession session, String customer_Email, int inputCode) {
		try {
			int generationCode = (int) session.getAttribute("num" + customer_Email);
			System.out.println("입력한 코드  ::" + inputCode);
			System.out.println("실제 코드 ::" + generationCode);
			if (generationCode == inputCode) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw e;
		}

	}

	public boolean mailSend(dagachi.controller.customer.EmailDTO email) {
		try {
			MimeMessage msg = mailSender.createMimeMessage();

			msg.setSubject(email.getSubject());

			// 일반 텍스트만 전송하려는 경우
			msg.setText(email.getContent());
			msg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));

			mailSender.send(msg);

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public void update(HashMap<String, Object> map) {
		dao.update(map);

	}

}

/*
 * 
 * public boolean isLogin(String id) { boolean isLogin = false;
 * Enumeration<String> e = loginUsers.keys(); String key = ""; while
 * (e.hasMoreElements()) { key = (String) e.nextElement(); if
 * (id.equals(loginUsers.get(key))) isLogin = true; } return isLogin; }
 * 
 * public boolean isUsing(String sessionId) { boolean isUsing = false;
 * Enumeration<String> e = loginUsers.keys(); String key = ""; while
 * (e.hasMoreElements()) { key = (String) e.nextElement(); if
 * (sessionId.equals(loginUsers.get(key))) isUsing = true; } return isUsing; }
 * 
 * public void setSession(HttpSession session, CSignUpDTO dto) {
 * loginUsers.put(session.getId(), dto.getId()); session.setAttribute("id",
 * dto.getId()); }
 */
