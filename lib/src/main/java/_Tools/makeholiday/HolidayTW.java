package _Tools.makeholiday;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HolidayTW {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private static String outDataPath = "C:\\Users\\0012252\\Desktop\\Tools\\project\\FIXProtocol\\10. 版本\\HolidayTW\\2024\\HolidayTW.ini";
	private static List<String> passDates = Arrays.asList(new String[] { "20240101", "20240208", "20240209", 
			"20240212", "20240213", "20240214", "20240228", "20240404","20240405","20240610","20240917","20241010" });

	public static void main(String[] args) throws IOException {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outDataPath))) {

			int totalDay = 400;
			for (int i = 0; i <= totalDay; i++) {
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_MONTH, i);
				Date daysLater = calendar.getTime();
				int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

				if ((dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) || passDates.indexOf(sdf.format(daysLater)) != -1) {
					bw.write(sdf.format(daysLater));
					bw.newLine();
					System.out.println(sdf.format(daysLater) + "=" + dayOfWeek);

				}

			}
		}

	}

}
