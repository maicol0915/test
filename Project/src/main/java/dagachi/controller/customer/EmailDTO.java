package dagachi.controller.customer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailDTO {
	private String subject;
	private String content;
	private String date;
	private String receiver;
	private int certiNum;
}
