package _Tools.parser.symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserStkFut {

	public static void main(String[] args) {
		String stkFut = "06250A=J3";
		String[] bbgSymbolarray = stkFut.split("=");
		String symbol = bbgSymbolarray[0];
		String year = "2023" + String.valueOf(bbgSymbolarray[1].charAt(1));
		String month = String.valueOf(bbgSymbolarray[1].charAt(0));
		System.out.println("symbol=" + symbol);
		System.out.println("year=" + year);
		System.out.println("month=" + month);
		String REGEX = "[0-9]{1,}";
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(symbol);
		StringBuilder sb = new StringBuilder();
		String type = "";
		if (m.find()) {
			String digitstr = symbol.substring(m.start(), m.end());
			type = symbol.substring(m.end());
			sb.append(digitstr);
		}

		System.out.println(sb);
		System.out.println(type);

	}

}
