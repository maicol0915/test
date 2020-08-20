package dagachi.dto.customer;

import lombok.*;

@Getter
@Setter 
public class Customer_SignUp_Dto {
	private int customer_Num;
	private String customer_Email;
	private String customer_Name;
	private String customer_Password;
	private String customer_Gender;
	private String customer_PhoneNumber;
	private String customer_Birth;
	private String customer_Join_Date;
}