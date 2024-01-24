package _Tools.testconvert;

import java.math.BigDecimal;

public class TestConvertUsSymbolPrice {
	private static final BigDecimal d32 = new BigDecimal("0.32");

	public static void main(String[] args) {
		System.out.println(convert36Ptice("102.99609375"));
		System.out.println(convert36Ptice("103.00390625"));
		System.out.println(convert36Ptice("-0.8671875"));
		System.out.println(convert36Ptice("-0.8828125"));

	}

	private static String convert36Ptice(String price10) {
		String[] priceArray = price10.split("[.]");
		String fpricen = priceArray[0];
		String fpriced = priceArray[1];
		BigDecimal fPriceN = new BigDecimal(fpricen);
		BigDecimal fPriceD = new BigDecimal("0." + fpriced);
		BigDecimal newPriceD = fPriceD.multiply(d32);
		return fPriceN.add(newPriceD).toString().replaceAll("0+?$", "");

	}

}
