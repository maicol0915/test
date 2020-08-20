package dagachi.dto.customer;

import lombok.*;

@Setter
@Getter 
public class Customer_Login_Dto {
	private String customer_Email;
	private String customer_Name;
	private String customer_Password;
}