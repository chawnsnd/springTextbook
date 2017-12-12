package org.chawnsnd.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.chawnsnd.domain.MessageVO;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace="org.zerock.mapper.MessageMapper";
	
	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public MessageVO readMessage(Integer mno) throws Exception {
		return session.selectOne(namespace+".readMessage", mno);
	}

	@Override
	public void updateState(Integer mno) throws Exception {
		session.update(namespace+".updateState", mno);
	}

}
