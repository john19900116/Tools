package _Tools.testconvert;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestConvertPrice {
	protected final static NumberFormat PRICE_FORMAT = new DecimalFormat("0000000000000");
	protected final static NumberFormat NEG_PRICE_FORMAT = new DecimalFormat("000000000000");

	public static void main(String[] args) {
		System.out.println((Double.valueOf("0015142000000") / 1000000) / Double.valueOf("0001"));

	}

	protected static String renderPx(Double px) {
		px = px / 1000000;
		System.out.println(px);

		return String.valueOf(px);
	}

}
