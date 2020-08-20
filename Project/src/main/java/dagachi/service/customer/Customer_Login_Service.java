package dagachi.service.customer;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import dagachi.controller.customer.EmailDTO;
import dagachi.dto.customer.Customer_Login_Dto;
import dagachi.dto.customer.Customer_SignUp_Dto;

public interface Customer_Login_Service {
	// 회원가입
	public void register(Customer_SignUp_Dto dto) throws Exception;

	public void insert(Customer_SignUp_Dto dto) throws Exception;

	public Customer_Login_Dto login(Customer_Login_Dto dto) throws Exception;

	public int ID(String customer_Email);

	public boolean mailSend(EmailDTO email);

	public void update(HashMap<String, Object> map);

	public boolean emailCertification(HttpSession session, String customer_Email, int parseInt);








}