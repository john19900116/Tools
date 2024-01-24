package _Tools.testTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestAsiaTaipei {
	protected static SimpleDateFormat yyyyMMddHHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	protected static SimpleDateFormat sdfTaipei = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	public static void main(String[] args) throws ParseException {
		yyyyMMddHHmmssSSS.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
		Date rc = yyyyMMddHHmmssSSS.parse("20231025072724854");
		sdfTaipei.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Taipei"));
		String taipeiTime = sdfTaipei.format(rc);

		System.out.println(taipeiTime);



	}
}
