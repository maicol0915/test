package dagachi.dao.customer;

import java.util.HashMap;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dagachi.dto.customer.Customer_Login_Dto;
import dagachi.dto.customer.Customer_SignUp_Dto;

@Repository
public class Customer_Login_DaoImpl implements Customer_Login_Dao {

	// 데이터베이스
	@Inject
	private SqlSession sql;

	// 매퍼
	private static String namespace = "CmemberMapper";

	// 회원가입
	public void register(Customer_SignUp_Dto dto) throws Exception {
		sql.insert(namespace + ".Cregister", dto);
	}

	public void insert(Customer_SignUp_Dto dto) throws Exception {
		sql.insert(namespace + ".Cregister", dto);
	}

	// 로그인
	@Override
	public Customer_Login_Dto login(Customer_Login_Dto dto) throws Exception {
		return sql.selectOne(namespace + ".CLogin", dto);
	}
	
	
	public int ID(String customer_Email) {
		return sql.selectOne(namespace + ".findPass", customer_Email);
		  
	}

	@Override
	public void update(HashMap<String, Object> map) {
		return;
	}
	

}