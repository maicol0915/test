package dagachi.dto.admin;

import lombok.*;

@Setter
@Getter
public class Admin_Login_Dto {
	private String admin_Id;
	private String admin_Password;
	private String admin_Name;
}