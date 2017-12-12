package org.chawnsnd.test;

import java.util.List;

import javax.inject.Inject;

import org.chawnsnd.domain.BoardVO;
import org.chawnsnd.domain.Criteria;
import org.chawnsnd.domain.SearchCriteria;
import org.chawnsnd.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

/*	@Test
	public void testCreate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setTitle("���ο� ���� �ֽ��ϴ�.");
		board.setContent("���ο� ���� �ֽ��ϴ�.");
		board.setWriter("user00");
		dao.create(board);
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("������ ���Դϴ�.");
		board.setContent("���� �׽�Ʈ");
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.delete(1);
	}
	
	@Test
	public void testListPage() throws Exception{
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
	}
	*/
/*	@Test
	public void testURI() throws Exception{
		
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("bno",12)
				.queryParam("perPageNum", 20)
				.build()
				.expand("board","read")
				.encode();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}*/
	
	@Test
	public void testDynamic1() throws Exception{
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("��");
		cri.setSearchType("t");
		
		logger.info("==================================");
		
		List<BoardVO> list = dao.listSearch(cri);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
		
		logger.info("==================================");
		logger.info("COUNT: "+dao.listSearchCount(cri));
	}
}