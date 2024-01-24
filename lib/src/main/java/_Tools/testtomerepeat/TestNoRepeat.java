package _Tools.testtomerepeat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestNoRepeat {
	protected final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static List<String> counts = new ArrayList<>();

	public static void main(String[] args) {
		int i = 0;
		while (i != 50) {

			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("ExecID = " + getExecID());

				}
			}).start();

			i++;
		}

	}

	public  static String getExecID() {
		String execID = TIME_FORMAT.format(new Date());
		while (counts.indexOf(execID) != -1) {
			execID = TIME_FORMAT.format(new Date());
		}
		counts.add(execID);
		return execID;
	}

}
