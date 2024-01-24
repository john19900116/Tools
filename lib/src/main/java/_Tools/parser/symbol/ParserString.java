package _Tools.parser.symbol;

public class ParserString {

	public static void main(String[] args) {
		String pb3303Str = "8=FIX.4.2|9=428|35=8|34=944|49=KFIXFUTU|52=20230817-07:25:25.545|56=BLPFUTU|1=42450837|6=0|11=20230817-00002-00004|14=0|17=20230817152525544|18=4|20=0|21=1|22=1|37=0|38=2|39=8|40=2|41=20230817-00002-00001|54=1|55=XUQ3|58=3723:ClordID=20230817-00002-00001|ModifyID=8156299110170403014|DateTime=20230817152520703|Function=M|OrgTotalQty=2|NewTotalQty=1|ModifyStatus=C|Channel=F|Keyin=F900000|63=0|64=20230817|76=KGI|150=8|151=0|167=FUT|200=202308|10=045||"
			;

		String[] pb3303split = pb3303Str.split("[|]");

		for (String p3303 : pb3303split) {
			String[] str = p3303.split("=");
			if (str.length == 2) {
				System.out.println(str[0] + " = " + str[1]);

			} else {
				System.out.println(str[0]);

			}

		}

	}

}
