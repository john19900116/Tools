package _Tools.parser.symbol;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ParserCmeSymBol {
	private static final String cmeSymbolCodes = "ES,NQ,6A,6B,6C,6E,6J,6S,ND,SP,YM,ZB,ZN,GC,CL,NG,SI,LE,HE,GF,GE,NKD,6N,E7,ZR,ZD,ZL,ZM,ZF,ZT,TN,UB,XK,ZQ,HG,HO,QM,PA,PL,PN,RB,MGC,RY,RP,ZC,OZC,ZS,OZS,OZN,OZB,ZW,OZW,OYM,DJ,NE,DX,LO,OG,ON,SO,XC,M6E,ZO,EW,EW1,EW2,EW3,EW4,EUU,ADU,CAU,GBU,JPU,E1C,E2C,E3C,E4C,E5C,SBT,GCT,SIT,CLT,HGT,RF,EV,EMD,RTY,6M,M6A,M6B,MJY,CD,EC,HXE,MES,MYM,MNQ,M2K,SR1,SR3,SDA,HET,GFT,LET,SIL,TUL,TUT,TUX,TUB,TYT,TUF,TFY,TAF,TOU,TUN,TYX,TOB,TOF,FOL,FYT,FYN,FIX,FOB,NIB,NOL,TEX,NON,NBY,NCB,NOB,BOB,BUB,NUB,SDI,MQ1,MQ2,MQ3,MQ4,EX1,EX2,EX3,EX4,BIO,XAV,BZ,SPX,MCL,QG,10Y,OZF,XW,MHG,Z3N";
	private static Properties properties;

	public static void main(String[] args) {
		initProperties();
		for (String symbolsCode : cmeSymbolCodes.split(",")) {

			String calendar = properties.getProperty("fut_spread." + symbolsCode + ".calendar");
			if (calendar != null) {
				if (calendar.equals("SP") || calendar.equals("EQ")) {
					System.out.print(symbolsCode + ",");

				}

			}
		}
	}

	private static void initProperties() {
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\0012252\\Desktop\\Tools\\project\\外期GW\\3. config\\商品檔\\CmeFutureSpreadSymbolInfo.properties");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
