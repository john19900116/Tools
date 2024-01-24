package _Tools.testquickfixj;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import _Tools.testquickfixj.handler.FIXInboundReturnHandler;
import quickfix.Acceptor;
import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.FileStoreFactory;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.InvalidMessage;
import quickfix.LogFactory;
import quickfix.Message;
import quickfix.MessageStoreFactory;
import quickfix.RejectLogon;
import quickfix.ScreenLogFactory;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.UnsupportedMessageType;
import quickfix.field.Account;
import quickfix.field.ClOrdID;
import quickfix.field.Currency;
import quickfix.field.FutSettDate;
import quickfix.field.HandlInst;
import quickfix.field.IDSource;
import quickfix.field.MaturityDay;
import quickfix.field.MaturityMonthYear;
import quickfix.field.MsgType;
import quickfix.field.OrdType;
import quickfix.field.OrderID;
import quickfix.field.OrderQty;
import quickfix.field.OrigClOrdID;
import quickfix.field.Price;
import quickfix.field.SecurityExchange;
import quickfix.field.SecurityID;
import quickfix.field.SecurityType;
import quickfix.field.SettlmntTyp;
import quickfix.field.Side;
import quickfix.field.Symbol;
import quickfix.field.Text;
import quickfix.field.TimeInForce;
import quickfix.field.TransactTime;
import quickfix.fix42.NewOrderSingle;
import quickfix.fix42.OrderCancelReplaceRequest;
import quickfix.fix42.OrderCancelRequest;
import quickfix.fix44.ResendRequest;

public class FutServerApplication extends FIXInboundReturnHandler implements Application {
	private static SessionID sessionId;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
//	private final FIXInboundReturnHandler rtnHandler = new FIXInboundReturnHandler();

	@Override
	public void onCreate(SessionID sessionId) {
		System.out.println("onCreate");
	}

	@Override
	public void onLogon(SessionID sessionId) {
		System.out.println("onLogon");
		this.sessionId = sessionId;

	}

	@Override
	public void onLogout(SessionID sessionId) {
		System.out.println("onLogout");
		this.sessionId = null;

	}

	@Override
	public void toAdmin(Message message, SessionID sessionId) {

		System.out.println("toAdmin: (" + message.getClass().getSimpleName() + ")|" + message);

	}

	@Override
	public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
		System.out.println("fromAdmin: (" + message.getClass().getSimpleName() + ")|" + message);

	}

	@Override
	public void toApp(Message message, SessionID sessionId) throws DoNotSend {
		System.out.println("toApp: (" + message.getClass().getSimpleName() + ")|" + message);

	}

	@Override
	public void fromApp(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

		System.out.println("fromApp: (" + message.getClass().getSimpleName() + ")");
		try {
			crack(message, sessionId);
		} catch (UnsupportedMessageType | FieldNotFound | IncorrectTagValue e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws ConfigError, FileNotFoundException, InterruptedException, SessionNotFound {

		SessionSettings settings = new SessionSettings("C:\\Users\\0012252\\Desktop\\Tools\\workSpace\\Tools\\Tools\\config\\TTServer.ini");

		Application application = new FutServerApplication();
		MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
		LogFactory logFactory = new ScreenLogFactory(false, false, false);
		DefaultMessageFactory messageFactory = new DefaultMessageFactory();

		Acceptor initiator = new SocketAcceptor(application, messageStoreFactory, settings, logFactory, messageFactory);
		initiator.start();

//		CountDownLatch latch = new CountDownLatch(1);
//		latch.await();

		new Thread(new Runnable() {

			@Override
			public void run() {
				ResendRequest resemd = new ResendRequest();
				try {

					Thread.sleep(10 * 1000);
					System.out.println("Send");
					Session.sendToTarget(resemd, sessionId);

				} catch (SessionNotFound | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

}
