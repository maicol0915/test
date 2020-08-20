package dagachi.service.customer;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import dagachi.dao.customer.Customer_Question_Dao;
import dagachi.dto.customer.Customer_Question_Dto;

@Component
public class Customer_Question_ServiceImpl implements Customer_Question_Service {

	@Inject
	private Customer_Question_Dao dao;

	// 게시물 목록
	public List<Customer_Question_Dto> list() throws Exception {
		return dao.list();
	}

	// 게시물 작성
	@Override
	public void write(Customer_Question_Dto vo) throws Exception {

		dao.write(vo);
	}

	// 게시물 조회
	@Override
	public Customer_Question_Dto view(int customer_WriteNo) throws Exception {

		return dao.view(customer_WriteNo);
	}

	// 게시물 수정
	@Override
	public void modify(Customer_Question_Dto dto) throws Exception {

		dao.modify(dto);
	}

	// 게시물 삭제
	public void delete(int customer_WriteNo) throws Exception {
		dao.delete(customer_WriteNo);
	}

	// 게시물 총 갯수
	@Override
	public int count() throws Exception {
		return dao.count();
	}

	// 게시물 목록 + 페이징
	@Override
	public List<Customer_Question_Dto> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}

}