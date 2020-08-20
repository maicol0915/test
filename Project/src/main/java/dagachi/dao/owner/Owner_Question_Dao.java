package dagachi.dao.owner;

import java.util.*;

import dagachi.dto.owner.Owner_Question_Dto;

public interface Owner_Question_Dao {

	// 게시물 목록
	public List<Owner_Question_Dto> list() throws Exception;

	// 게시물 작성
	public void write(Owner_Question_Dto vo) throws Exception;

	// 게시물 조회
	public Owner_Question_Dto view(int owner_WriteNo) throws Exception;

	// 게시물 수정
	public void modify(Owner_Question_Dto dto) throws Exception;

	// 게시물 삭제
	public void delete(int owner_WriteNo) throws Exception;

	// 게시물 총 갯수
	public int count() throws Exception;

	// 게시물 목록 + 페이징
	public List<Owner_Question_Dto> listPage(int displayPost, int postNum) throws Exception;
}