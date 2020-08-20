package dagachi.dao.owner;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dagachi.dto.owner.Owner_Question_Dto;

@Repository
public class Owner_Question_DaoImpl implements Owner_Question_Dao {

	@Autowired
	private SqlSession sql;

	private static String namespace = "Oquestion";

	//게시물 목록
	@Override
	public List<Owner_Question_Dto> list() throws Exception {
		return sql.selectList(namespace + ".Oquestion");
	}
	
	//게시물 작성
	@Override
	public void write(Owner_Question_Dto vo) throws Exception {

		sql.insert(namespace + ".Owrite", vo);
	}

	// 게시물 조회
	public Owner_Question_Dto view(int owner_WriteNo) throws Exception {

		return sql.selectOne(namespace + ".Oview", owner_WriteNo);
	}

	// 게시물 수정
	@Override
	public void modify(Owner_Question_Dto dto) throws Exception {
		sql.update(namespace + ".Omodify", dto);
	}

	// 게시물 삭제
	public void delete(int owner_WriteNo) throws Exception {
		sql.delete(namespace + ".Odelete", owner_WriteNo);
	}

	// 게시물 총 갯수
	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace + ".Ocount");
	}

	// 게시물 목록 + 페이징
	@Override
	public List<Owner_Question_Dto> listPage(int displayPost, int postNum) throws Exception {

		HashMap<String, Integer> data = new HashMap<String, Integer>();

		data.put("displayPost", displayPost);
		data.put("postNum", postNum);

		return sql.selectList(namespace + ".OlistPage", data);
	}

}