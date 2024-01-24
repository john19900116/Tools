package _Tools.parser.symbol;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class parserPriceFormat {
	public final static NumberFormat PRICE_FORMAT = new DecimalFormat("0000000000000");
	public final static NumberFormat NEG_PRICE_FORMAT = new DecimalFormat("000000000000");

	public static void main(String[] args) {

		System.out.println(formatPrice("17500"));
		System.out.println(formatPrice("0.175"));  //  0000000175000
	}

	private static String formatPrice(String oldprice) {
		Double orderPrice = (double) 0;
		orderPrice = Double.valueOf(oldprice);

		String price = "0000000000000";
		orderPrice = orderPrice * 1000000;

		if (orderPrice > 0) {
			price = PRICE_FORMAT.format(orderPrice);
		} else {
			price = NEG_PRICE_FORMAT.format(orderPrice);
		}

		return price;
	}

}
