package dagachi.dao.admin;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dagachi.dto.admin.Admin_Login_Dto;
import dagachi.dto.admin.Admin_SignUp_Dto;

@Repository
public class Admin_SignUp_DaoImpl implements Admin_SignUp_Dao {

	// 데이터베이스
	@Inject
	private SqlSession sql;

	// 매퍼
	private static String namespace = "AmemberMapper";

	// 회원가입
	public void register(Admin_SignUp_Dto dto) throws Exception {
		sql.insert(namespace + ".Aregister", dto);
	}
	
	public void insert(Admin_SignUp_Dto dto) throws Exception {
		sql.insert(namespace + ".Aregister", dto);
	}
	
	public Admin_Login_Dto login(Admin_Login_Dto dto) throws Exception {
		return sql.selectOne(namespace + ".Alogin", dto);
	}
}