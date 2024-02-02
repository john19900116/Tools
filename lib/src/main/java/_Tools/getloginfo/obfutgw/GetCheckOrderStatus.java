package _Tools.getloginfo.obfutgw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GetCheckOrderStatus {
	private static final String path = "C:\\Users\\0012252\\Desktop\\Tools\\project\\外期GW\\2. 相關Log\\20240130ttgw\\";
	private static final String dataPath = path + "GW.dug.20240130";
	private static final String outDataPath = path + "check.log";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(dataPath)); BufferedWriter bw = new BufferedWriter(new FileWriter(outDataPath));) {
			String data;

			while ((data = br.readLine()) != null) {

				if (data.indexOf("NewOrderMultileg Leg") != -1) {
					bw.write(data);
					bw.newLine();

				}

				if (data.indexOf("toApp:NewOrderMultileg") != -1 || data.indexOf("fromApp:ExecutionReport") != -1 || data.indexOf("toApp:MultilegOrderCancelReplaceRequest") != -1 || data.indexOf("toApp:NewOrderSingle") != -1) {
					bw.write(data);
					bw.newLine();

				}

//				if (data.indexOf("toApp:OrderCancelRequest") != 1) {
//					bw.write(data);
//					bw.newLine();
//
//				}

				if (data.indexOf("IS SEND : ") != -1) {
					bw.write(data);
					bw.newLine();

				}

				if (data.indexOf("reply : Reply ") != -1) {
					bw.write(data);
					bw.newLine();
					bw.newLine();
					bw.newLine();
					bw.newLine();

				}

			}
		}

	}

}
