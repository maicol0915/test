package dagachi.dao.customer;

import java.util.HashMap;

import dagachi.dto.customer.Customer_Login_Dto;
import dagachi.dto.customer.Customer_SignUp_Dto;

public interface Customer_Login_Dao {
	public void register(Customer_SignUp_Dto dto) throws Exception;

	public void insert(Customer_SignUp_Dto dto) throws Exception;

	public Customer_Login_Dto login(Customer_Login_Dto dto) throws Exception;

	public int ID(String customer_Email);

	public void update(HashMap<String, Object> map);


}