package _Tools.parser.symbol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ParserSymbol {
	private static final String patternStr = "[1-9]";

	private static final Map<String, String> symbolmap = new HashMap<>();

	private static final String symbolDataPath = "C:\\Users\\0012252\\Desktop\\Tools\\workSpace\\Tools\\Tools\\config\\SymbolMap.ini";

	private static final String firstYear = "202";

	private static final String[] MONTH_CODE = { "F", "G", "H", "J", "K", "M", "N", "Q", "U", "V", "X", "Z" };

	private static final String[] CALL_CODE = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L" };

	private static final String[] PUT_CODE = { "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X" };

	public static void main(String[] args) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(symbolDataPath))) {

			String data;

			while ((data = br.readLine()) != null) {
				symbolmap.put(data.split("=")[0], data.split("=")[1]);
			}

		}

		System.out.println(getSymbolComYM("RTYH3", "N"));
		System.out.println(getSymbolComYM("FTH3", "N"));
		System.out.println(getSymbolComYM("FTH3FTJ3", "Y"));
		System.out.println(getSymbolComYM("MESH3", "N"));
		System.out.println(getSymbolComYM("MESH3MESJ3", "Y"));
		System.out.println(getSymbolComYM("06205=G2", "N"));
		

		System.out.println(getSymbolComYM("XUZ1XUF2", "Y"));
		
	}

	/**
	 * 將期貨商品轉換商品代碼
	 * 
	 * @param bbgSymbol
	 * @return
	 */
	public static String getSymbolComYM(String bbgSymbol, String isMelg) {
		int length = bbgSymbol.length();

		if (length < 3) {
			return bbgSymbol;
		}
		StringJoiner sj = new StringJoiner("|", "|", "|");

		if (bbgSymbol.indexOf("=") == -1) {
			parserFut(bbgSymbol, isMelg, sj);
		} else {
			parserStkFut(bbgSymbol, isMelg, sj);
		}

		return sj.add("*").toString();
	}

	private static void parserStkFut(String bbgSymbol, String isMelg, StringJoiner sj) {

		if ("N".equals(isMelg)) { // 單式
			String[] bbgSymbolarray = bbgSymbol.split("=");
			String symbol = bbgSymbolarray[0];
			String year = firstYear + String.valueOf(bbgSymbolarray[1].charAt(1));
			String month = String.valueOf(bbgSymbolarray[1].charAt(0));

			month = String.valueOf(Arrays.asList(MONTH_CODE).indexOf(month) + 1);
			month = Integer.valueOf(month) <= 9 ? "0" + month : month;
			sj.add(symbol);
			sj.add(year + month);

		} else {

		}

	}

	private static void parserFut(String bbgSymbol, String isMelg, StringJoiner sj) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(bbgSymbol);
		int yesr1Indexof = 0;

		if (matcher.find()) {
			yesr1Indexof = matcher.start();
		}

		String bbgSymbol1 = bbgSymbol.substring(0, yesr1Indexof + 1);
		int len1 = bbgSymbol1.length();
		String bbgSymbol2 = bbgSymbol.substring(yesr1Indexof + 1);
		int len2 = bbgSymbol2.length();

		String year1 = firstYear + StringUtils.substring(bbgSymbol1, len1 - 1);
		String month1 = StringUtils.substring(bbgSymbol1, len1 - 2, len1 - 1);
		String symbol1 = StringUtils.substring(bbgSymbol1, 0, len1 - 2);

		symbol1 = symbolmap.get(symbol1);
		month1 = String.valueOf(Arrays.asList(MONTH_CODE).indexOf(month1) + 1);
		month1 = Integer.valueOf(month1) <= 9 ? "0" + month1 : month1;
		sj.add(symbol1);
		sj.add(year1 + month1);
		String year2 = "";
		String month2 = "";
		String symbol2 = "";

		if (bbgSymbol2.trim().length() != 0 && "Y".equals(isMelg)) {
			year2 = firstYear + StringUtils.substring(bbgSymbol2, len2 - 1);
			month2 = StringUtils.substring(bbgSymbol2, len2 - 2, len2 - 1);
			symbol2 = StringUtils.substring(bbgSymbol2, 0, len2 - 2);
			symbol2 = symbolmap.get(symbol2);
			month2 = String.valueOf(Arrays.asList(MONTH_CODE).indexOf(month2) + 1);
			month2 = Integer.valueOf(month2) <= 9 ? "0" + month2 : month2;
			sj.add(symbol2);
			sj.add(year2 + month2);
		}
	}

}
