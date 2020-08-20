package dagachi.service.admin;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import dagachi.dao.admin.Admin_SignUp_Dao;
import dagachi.dto.admin.Admin_Login_Dto;
import dagachi.dto.admin.Admin_SignUp_Dto;
import lombok.Setter;

@Service
public class Admin_SignUp_ServiceImpl implements Admin_SignUp_Service {

	@Inject
	private Admin_SignUp_Dao dao;

	// 회원가입
	@Override
	public void register(Admin_SignUp_Dto dto) throws Exception {
		System.out.println(dto);
		dao.insert(dto);
	}

	public void insert(Admin_SignUp_Dto dto) throws Exception {
		dao.insert(dto);
	}

	@Override
	public Admin_Login_Dto login(Admin_Login_Dto dto) throws Exception {
		return dao.login(dto);
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

}