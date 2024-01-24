package _Tools.TestMina.Server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TCPServerHandler extends IoHandlerAdapter {
	protected static final Logger logger = LoggerFactory.getLogger(TCPServerHandler.class);

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		logger.info("session Created");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("Session opened : {}", session.getLocalAddress());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		logger.info("Session Closed : {}", session.getLocalAddress());
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		if (status == IdleStatus.BOTH_IDLE) {
			System.out.println("Session idle: " + session.getRemoteAddress());
			session.closeNow();
		}
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		logger.info("Session Closed : {} Error Message : {}", session.getLocalAddress(), cause.getMessage(), cause);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		logger.info("From {} Received Message : {}", session.getLocalAddress(), message.toString());
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.inputClosed(session);
	}

	@Override
	public void event(IoSession session, FilterEvent event) throws Exception {
		// TODO Auto-generated method stub
		super.event(session, event);
	}

}
