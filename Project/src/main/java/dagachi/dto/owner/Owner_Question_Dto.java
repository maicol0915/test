package dagachi.dto.owner;

import lombok.*;

@Setter
@Getter
public class Owner_Question_Dto {
	private int owner_WriteNo;
	private String owner_WriteTitle;
	private String owner_Name;
	private String date_Created;
	private String owner_Content;
	private int owner_Num;
}