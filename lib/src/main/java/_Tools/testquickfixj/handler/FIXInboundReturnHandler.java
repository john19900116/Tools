package _Tools.testquickfixj.handler;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.field.ExecType;
import quickfix.field.OrdStatus;
import quickfix.field.OrderQty;
import quickfix.field.Text;

public class FIXInboundReturnHandler extends MessageCracker {
	@Handler
	public void onMessage(quickfix.fix42.OrderCancelReject request, SessionID sessionID) {
		System.out.println("OrderCancelReject = " + request);
	}
	/**
	 * 0 = New
		1 = Partially filled
		2 = Filled
		3 = Done for day
		4 = Canceled
		5 = Replaced
		6 = Pending Cancel (e.g. result of Order Cancel Request <F>)
		7 = Stopped
		8 = Rejected
		9 = Suspended
		A = Pending New
		B = Calculated
		C = Expired
		D = Accepted for bidding
		E = Pending Replace (e.g. result of Order Cancel/Replace Request <G>)
	 * @param request
	 * @param sessionID
	 * @throws FieldNotFound
	 */
	@Handler
	public void onMessage(quickfix.fix42.ExecutionReport request, SessionID sessionID) throws FieldNotFound {
		System.out.println("ExecutionReport = " + request);
		System.out.println("ExecType = " + request.getChar(ExecType.FIELD));
		System.out.println("OrdStatus = " + request.getChar(OrdStatus.FIELD));
		System.out.println("QTY = " + request.getChar(OrderQty.FIELD));
		System.out.println("Text = " + request.getString(Text.FIELD));
		System.out.println("====================================================");

	}

	@Handler
	public void onMessage(quickfix.fix42.Reject request, SessionID sessionID) {
		System.out.println("Reject = " + request);

	}

	@Handler
	protected void onMessage(Message message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {

	}
}
