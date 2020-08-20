package dagachi.service.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dagachi.dao.owner.Owner_Question_Dao;
import dagachi.dto.owner.Owner_Question_Dto;

@Component
public class Owner_Question_ServiceImpl implements Owner_Question_Service {

	@Autowired
	private Owner_Question_Dao dao;

	// 게시물 목록
	public List<Owner_Question_Dto> list() throws Exception {
		return dao.list();
	}

	// 게시물 작성
	@Override
	public void write(Owner_Question_Dto vo) throws Exception {

		dao.write(vo);
	}

	// 게시물 조회
	@Override
	public Owner_Question_Dto view(int owner_WriteNo) throws Exception {

		return dao.view(owner_WriteNo);
	}

	// 게시물 수정
	@Override
	public void modify(Owner_Question_Dto dto) throws Exception {

		dao.modify(dto);
	}

	// 게시물 삭제
	public void delete(int owner_WriteNo) throws Exception {
		dao.delete(owner_WriteNo);
	}

	// 게시물 총 갯수
	@Override
	public int count() throws Exception {
		return dao.count();
	}

	// 게시물 목록 + 페이징
	@Override
	public List<Owner_Question_Dto> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}

}