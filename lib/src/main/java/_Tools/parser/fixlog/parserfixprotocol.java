package _Tools.parser.fixlog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.ConfigError;
import quickfix.DataDictionary;
import quickfix.DefaultMessageFactory;
import quickfix.FieldNotFound;
import quickfix.Group;
import quickfix.InvalidMessage;
import quickfix.MessageUtils;
import quickfix.field.LegCFICode;
import quickfix.field.LegMaturityMonthYear;
import quickfix.field.LegRatioQty;
import quickfix.field.LegSecurityExchange;
import quickfix.field.LegSide;
import quickfix.field.LegSymbol;
import quickfix.field.MsgType;
import quickfix.field.NoLegs;
import quickfix.fix42.Message;

public class parserfixprotocol {

	public static void main(String[] args) throws FieldNotFound {
		String newOrderMultileg = "8=FIX.4.29=53835=849=BNPHKFIX42_ASX_UAT56=KGIHKFIX42_ASX_UAT34=126"
				+ "352=20230728-09:01:54.416128=KGIF37=00000487996UOHK111=202307286165654417=0901021982"
				+ "150=039=020=01=KLin55=XT48=XT22=8167=MLEG200=202309207=ASX54=138=140=244=25.0"
				+ "115=AUD59=0126=20230731-06:51:00.00032=031=0151=114=06=060=20230728-09:01:54.40621="
				+ "177=O555=2600=XT602=XT603=8608=FXXXXX609=FUT610=202309611=20230915616=ASX623=1624="
				+ "1654=0600=XT602=XT603=8608=FXXXXX609=FUT610=202312611=20231215616=ASX623=1624=2654=0541=20230901528=A10=213";
		String request = newOrderMultileg;
		try {
			if (MsgType.ORDER_SINGLE.equals(MessageUtils.getMessageType(request))) {
				System.out.println(request.toString());
			}
			DefaultMessageFactory messageFactory = new DefaultMessageFactory();
			// InputStream file =
			// MessageHandler.class.getResourceAsStream("/ini/FIX44.xml");
//			InputStream file = new FileInputStream(new File("D:\\Workspace\\java\\fixgw\\src\\test\\java\\kgifutures\\fixsystem\\multileg\\FIX44.xml"));
			InputStream file = new FileInputStream(new File("D:\\Workspace\\java\\fixgw\\ini\\FIX42.xml"));
//			InputStream file = new FileInputStream(new File("D:\\Workspace\\java\\fixgw\\ini\\FIX4220230728BAK.xml"));

			DataDictionary dataDictionary = new DataDictionary(file);
			Message message = (Message) MessageUtils.parse(messageFactory, dataDictionary, request);

			System.out.println(message.toString());
			// System.out.println("getSubAccount=", getSubAccount(message));

			System.out.println("NoLegs:" + message.getString(NoLegs.FIELD));
			List<Group> groups = message.getGroups(NoLegs.FIELD);
			System.out.println("getGroupCount:" + message.getGroupCount(NoLegs.FIELD));
			for (Group group : groups) {
				System.out.println("group : " + group.getClass().getSimpleName());
				System.out.println("LegSymbol:" + group.getString(LegSymbol.FIELD));
				System.out.println("LegCFICode:" + group.getString(LegCFICode.FIELD));
				System.out.println("LegMaturityMonthYear:" + group.getString(LegMaturityMonthYear.FIELD));
				System.out.println("LegSecurityExchange:" + group.getString(LegSecurityExchange.FIELD));
				System.out.println("LegRatioQty:" + group.getString(LegRatioQty.FIELD));
				System.out.println("LegSide:" + group.getString(LegSide.FIELD));
			}

		} catch (ConfigError e) {
			e.printStackTrace();
		} catch (InvalidMessage e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
