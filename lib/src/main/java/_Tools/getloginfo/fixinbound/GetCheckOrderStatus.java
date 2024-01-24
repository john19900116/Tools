package _Tools.getloginfo.fixinbound;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GetCheckOrderStatus {
	private static final String path = "C:\\Users\\0012252\\Desktop\\Tools\\project\\FIXProtocol\\2. 相關Log\\uat\\2024.01.22fubon\\";
	private static final String dataPath = path + "FIXInbound.log";
	private static final String clordId = "20240122-00009-00001";
	private static final String outDataPath = path + clordId + ".log";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(dataPath)); BufferedWriter bw = new BufferedWriter(new FileWriter(outDataPath));) {
			String data;

			while ((data = br.readLine()) != null) {

				if ((data.indexOf("fromApp:NewOrderSingle") != -1 || data.indexOf("fromApp:OrderCancelRequest") != -1 || data.indexOf("fromApp:OrderCancelReplaceRequest") != -1) && data.indexOf(clordId) != -1) {
					bw.newLine();
					bw.newLine();
					bw.newLine();
					bw.newLine();
					bw.write(data);
					bw.newLine();

				}

				if (data.indexOf("DataToRedis:putIntoRedis") != -1) {
					bw.write(data);
					bw.newLine();

				}

				if (data.indexOf("fromApp:DontKnowTrade") != -1) {
					bw.write(data);
					bw.newLine();

				}

				if (data.indexOf("Process Start") != -1 && data.indexOf(clordId) != -1) {
					bw.write(data);
					bw.newLine();

				}

				if (data.indexOf("Process Done") != -1 && data.indexOf(clordId) != -1) {
					bw.write(data);
					bw.newLine();

				}

				if (data.indexOf("OnRcvDataReceive DataType") != -1 && data.indexOf(clordId) != -1) {
//					System.out.println(data.substring(data.indexOf("Message : [") + "Message : [".length(), data.indexOf("] Start Process")));

					System.out.println(data);

					bw.write(data);
					bw.newLine();

				}

				if (data.indexOf("PushOrderClient.lambda$OnRcvData$59():232") != -1 && data.indexOf(clordId) != -1) {
					bw.write(data);
					bw.newLine();

				}

//				if (data.indexOf("OnRcvDataReceive DataType : 3722") != -1 && data.indexOf(clordId) != -1) {
//					bw.write(data);
//					bw.newLine();
//
//				}

				if (data.indexOf("SendOrder Send To") != -1 && data.indexOf(clordId) != -1) {
					bw.write(data);
					bw.newLine();

				}

				if ((data.indexOf("CheckOrderStatus") != -1 || data.indexOf("OnRcvData Receive DataType") != -1) && data.indexOf(clordId) != -1) {
					bw.write(data);
					bw.newLine();
				}

				if (data.indexOf("toApp:ExecutionReport") != -1 && data.indexOf(clordId) != -1) {
					bw.write(data);
					bw.newLine();
				}

			}
		}

	}

}
