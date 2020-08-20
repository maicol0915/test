package dagachi.dao.admin;

import dagachi.dto.admin.Admin_Login_Dto;
import dagachi.dto.admin.Admin_SignUp_Dto;

public interface Admin_SignUp_Dao {
	public void register(Admin_SignUp_Dto dto) throws Exception;
	
	public void insert(Admin_SignUp_Dto dto) throws Exception;
	
	public Admin_Login_Dto login(Admin_Login_Dto dto) throws Exception;//수정

}