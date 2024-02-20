package _Tools.convert;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class TestConvertFutMonth {
	private static final String[] MONTH_CODE = { "F", "G", "H", "J", "K", "M", "N", "Q", "U", "V", "X", "Z" };

	private static final String[] CALL_CODE = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L" };

	private static final String[] PUT_CODE = { "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X" };

	private static final Map<String, String> symbolmap = new HashMap<>();

	public static void main(String[] args) {
		symbolmap.put("FT", "TXF");
//		System.out.println(getSymbolComYM("FTH3"));
		System.out.println(getSymbolComYM("FTH3FTJ3"));
		
		
		
	}
	
	
	public static String getMlegSymbolComYM(String bbgSymbol) {
		int length = bbgSymbol.length();

		if (length < 6) {
			return bbgSymbol;
		}
		
		 ;
		System.out.println(bbgSymbol.substring(bbgSymbol.length()/2));
		

		String year = StringUtils.substring(bbgSymbol, length - 1);
		String month = StringUtils.substring(bbgSymbol, length - 2, length - 1);
		String symbol = StringUtils.substring(bbgSymbol, 0, length - 2);
		symbol = symbolmap.get(symbol);
		month = String.valueOf(Arrays.asList(MONTH_CODE).indexOf(month) + 1);

		return symbol + "|" + "202" + year + (Integer.valueOf(month) <= 9 ? "0" + month : month);

	}
	
	
	public static String getSymbolComYM(String bbgSymbol) {
		int length = bbgSymbol.length();

		if (length < 3) {
			return bbgSymbol;
		}

		String year = StringUtils.substring(bbgSymbol, length - 1);
		String month = StringUtils.substring(bbgSymbol, length - 2, length - 1);
		String symbol = StringUtils.substring(bbgSymbol, 0, length - 2);
		symbol = symbolmap.get(symbol);
		month = String.valueOf(Arrays.asList(MONTH_CODE).indexOf(month) + 1);

		return symbol + "|" + "202" + year + (Integer.valueOf(month) <= 9 ? "0" + month : month);

	}
}
