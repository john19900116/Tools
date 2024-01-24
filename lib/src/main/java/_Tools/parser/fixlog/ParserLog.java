package _Tools.parser.fixlog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParserLog {
	private static String dataPath = "C:\\Users\\0012252\\Desktop\\Tools\\project\\FIXProtocol\\2. 相關Log\\uat\\2023.10.24\\";
	private static String logrdata = "FIXInbound.log";
//	private static String filterdata = "20230814-00005-00001"; //確認改單
	private static String filterdata = "20231024-00001-00001"; //取消改單
	
	private static String outdataPath = "C:\\Users\\0012252\\Desktop\\Tools\\project\\FIXProtocol\\2. 相關Log\\uat\\2023.10.24\\";

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(dataPath + logrdata)); BufferedWriter bw = new BufferedWriter(new FileWriter(outdataPath + filterdata + ".log"));) {
			String data;
			while ((data = br.readLine()) != null) {
				if (data.indexOf(filterdata) != -1 ) {
					bw.write(data);
					bw.newLine();
				}

			}
		}

	}

}
