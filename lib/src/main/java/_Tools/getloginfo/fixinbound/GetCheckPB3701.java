package _Tools.getloginfo.fixinbound;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GetCheckPB3701 {
	private static final String path = "C:\\Users\\0012252\\Desktop\\Tools\\project\\FIXProtocol\\2. 相關Log\\uat\\2024.01.24fubon\\";
	private static final String dataPath = path + "FIXInbound.log";
	private static final String outDataPath = path + "PB3701" + ".log";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(dataPath)); BufferedWriter bw = new BufferedWriter(new FileWriter(outDataPath));) {
			String data;

			while ((data = br.readLine()) != null) {

				if (data.indexOf("Send To [10.99.24.116:7000] Order : 3701") != -1) {

					bw.write(data);
					bw.newLine();
					bw.newLine();
					bw.newLine();
					bw.newLine();

				}

				if (data.indexOf("fromApp:NewOrderSingle") != -1) {

					bw.write(data);
					bw.newLine();

				}

			}
		}

	}

}
