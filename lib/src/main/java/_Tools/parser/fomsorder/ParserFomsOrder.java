package _Tools.parser.fomsorder;

import java.io.BufferedReader;
import java.io.FileReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParserFomsOrder {
	private static String logDataPath = "C:\\Users\\0012252\\Desktop\\Tools\\project\\外期GW\\2. 相關Log\\20231225ttjpx\\check.log";

	public static void main(String[] args) throws Exception {

		try (BufferedReader br = new BufferedReader(new FileReader(logDataPath))) {

			String data;

			while ((data = br.readLine()) != null) {
				if (data.indexOf("RECV FomsOrder:[") != -1) {

					int start = data.indexOf("RECV FomsOrder:[") + "RECV FomsOrder:[".length();
					int end = data.lastIndexOf("]");

					String fomsOrder = data.substring(start, end);
					FomsOrderTTFIX order = new FomsOrderTTFIX(fomsOrder);
					System.out.println(order);

				}
			}

		}

	}

}
