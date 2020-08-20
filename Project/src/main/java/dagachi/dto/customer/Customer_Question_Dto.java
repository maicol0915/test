package dagachi.dto.customer;

import lombok.*;

@Setter 
@Getter
public class Customer_Question_Dto {

	private int customer_WriteNo;
	private String customer_WriteTitle;
	private String customer_Name;
	private String date_Created;
	private String customer_Content;
	private int customer_Num;
}