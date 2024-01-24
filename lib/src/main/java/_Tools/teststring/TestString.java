package _Tools.teststring;

public class TestString {

	public static void main(String[] args) {
		String data = "20160909-04:46:02.005: 8=FIX.4.29=8535=449=ICE34=34143=Y52=20160909-04:46:01.57956=1392457=kgi_fix_os36=342123=Y10=092" ;
		String fixVersion = "FIX.4.2"; 
		
		
		
		
		String messageHeader = "8="+fixVersion;
//		String message = messageHeader + dataSet[1];
		String message = data.substring(data.indexOf(messageHeader)) ;
		System.out.println(message);
	}

}
