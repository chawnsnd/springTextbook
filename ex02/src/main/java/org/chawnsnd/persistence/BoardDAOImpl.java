package org.chawnsnd.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.chawnsnd.domain.BoardVO;
import org.chawnsnd.domain.Criteria;
import org.chawnsnd.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.chawnsnd.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception{
		session.insert(namespace+".create", vo);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception{
		return session.selectOne(namespace+".read",bno);
	}
	
	@Override
	public void update(BoardVO vo) throws Exception{
		session.update(namespace+".update", vo);
	}
	
	@Override
	public void delete(Integer bno) throws Exception{
		session.delete(namespace+".delete", bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception{
		return session.selectList(namespace+".listAll");
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception{
		
		return session.selectList(namespace+".listPage", cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception{
		return session.selectOne(namespace+".countPaging", cri);
	}
	
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri)throws Exception{
		return session.selectList(namespace+".listSearch", cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception{
		return session.selectOne(namespace+".listSearchCount", cri);
	}

}
