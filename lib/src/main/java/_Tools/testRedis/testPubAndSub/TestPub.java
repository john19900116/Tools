package _Tools.testRedis.testPubAndSub;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class TestPub {
	private static JedisCluster jedisCluster;
	private static String settingPath = "C:\\Users\\0012252\\Desktop\\Tools\\workSpace\\Tools\\Tools\\lib\\src\\main\\java\\_Tools\\testRedis\\testPubAndSub\\redis.properties";
	private static Properties pro = null;
	private static String channelName;

	public static void main(String[] args) throws InterruptedException {

		InputStream in = null;

		try {
			in = new FileInputStream(settingPath);
			pro = new Properties();
			try {
				pro.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("RedisClient : " + ex.getMessage());
		}

		init();

		channelName = pro.getProperty("channel.name");
		int i = 0;
		while (true) {
			pubData(channelName, String.valueOf(i));
			i++;
			Thread.sleep(1 * 1000);

		}

	}

	private static void init() {

		String _urls = pro.getProperty("redis.cluster.urls");
		String _ports = pro.getProperty("redis.cluster.ports");
		String[] hosts = _urls.split(",");
		String[] ports = _ports.split(",");

		Set<HostAndPort> hostAndPortSet = new HashSet<>();
		for (String host : hosts) {
			for (String port : ports) {
				int iport = Integer.parseInt(port);
				HostAndPort hostAndPort = new HostAndPort(host, iport);
				hostAndPortSet.add(hostAndPort);
			}
		}
		System.out.println(hostAndPortSet);
		jedisCluster = new JedisCluster(hostAndPortSet);

	}

	private static void pubData(String channel, String value) {

		jedisCluster.publish(channel, value);

		System.out.println("pub value ok");
		System.out.println("key =[" + channel + "],value =[" + value + "]");

	}
}