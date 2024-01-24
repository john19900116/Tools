package _Tools.parser.fixlog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import quickfix.ConfigError;
import quickfix.DataDictionary;
import quickfix.DefaultMessageFactory;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;
import quickfix.Message;
import quickfix.MessageUtils;
import quickfix.field.ExecID;

@Slf4j
public class parserfixInBoundprotocol {
	private static String dataPath = "C:\\Users\\0012252\\Desktop\\Tools\\project\\FIXProtocol\\2. 相關Log\\prod\\2023.12.28\\20231227\\FIX.4.4-KGIPROD-SFPROD.messages.log";
	private static Map<String, Integer> counts = new HashMap<>();

	public static void main(String[] args) throws FieldNotFound, IOException, InvalidMessage {
		try {

			DefaultMessageFactory messageFactory = new DefaultMessageFactory();
			InputStream file = new FileInputStream(new File("C:\\Users\\0012252\\Desktop\\Tools\\workSpace\\Tools\\Tools\\config\\INBOUND-FIX44.xml"));
			DataDictionary dataDictionary = new DataDictionary(file);

			try (BufferedReader br = new BufferedReader(new FileReader(dataPath))) {
				String data;
				while ((data = br.readLine()) != null) {

					String fixMesg = data.substring(data.indexOf("8=FIX.4.4"));
//					System.out.println(fixMesg);
					Message message = (Message) MessageUtils.parse(messageFactory, dataDictionary, fixMesg);
					if (message.isSetField(ExecID.FIELD)) {
						System.out.println(message.getString(ExecID.FIELD));
						String execID = message.getString(ExecID.FIELD);
						int count = 1;
						if (counts.containsKey(execID)) {
							count = count + counts.get(execID);
						}
						counts.put(execID, count);
					}

				}

			}
			for (String execID : counts.keySet()) {
				if (counts.get(execID) == 2) {
					System.out.println("execID = " + execID + " ,Count = " + counts.get(execID));

				}

			}
		} catch (ConfigError e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
