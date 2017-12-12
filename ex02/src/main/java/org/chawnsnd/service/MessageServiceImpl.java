package org.chawnsnd.service;

import javax.inject.Inject;

import org.chawnsnd.domain.MessageVO;
import org.chawnsnd.persistence.MessageDAO;
import org.chawnsnd.persistence.PointDAO;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDAO messageDAO;
	
	@Inject
	private PointDAO pointDAO;
	
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		messageDAO.create(vo);
		pointDAO.updatePOINT(vo.getSender(), 10);
	}

	@Override
	public MessageVO readMessage(String uid, Integer mno) throws Exception {
		messageDAO.updateState(mno);
		pointDAO.updatePOINT(uid, 5);
		
		return messageDAO.readMessage(mno);
	}

}
