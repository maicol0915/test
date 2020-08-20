package dagachi.service.customer;

import java.util.List;

import dagachi.dto.customer.Customer_Question_Dto;

public interface Customer_Question_Service {

	// 게시물 목록
	public List<Customer_Question_Dto> list() throws Exception;

	// 게시물 작성
	public void write(Customer_Question_Dto vo) throws Exception;

	// 게시물 조회
	public Customer_Question_Dto view(int customer_WriteNo) throws Exception;

	// 게시물 수정
	public void modify(Customer_Question_Dto dto) throws Exception;

	// 게시물 삭제
	public void delete(int customer_WriteNo) throws Exception;

	// 게시물 총 갯수
	public int count() throws Exception;

	// 게시물 목록 + 페이징
	public List<Customer_Question_Dto> listPage(int displayPost, int postNum) throws Exception;

}