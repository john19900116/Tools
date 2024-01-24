package _Tools.testRedis.testPubAndSub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPubSub;

public class TestSub {
	private static JedisCluster jedisCluster;
	private static String settingPath = "C:\\Users\\0012252\\Desktop\\Tools\\workSpace\\Tools\\Tools\\lib\\src\\main\\java\\_Tools\\testRedis\\testPubAndSub\\redis.properties";
	private static Properties pro = null;
	private static String channelName;

	public static void main(String[] args) {

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
		JedisPubSub jedisPubSub = new JedisPubSub() {

			@Override
			public void onMessage(String channel, String message) {
				System.out.println("Channel " + channel + " has sent a message : " + message);
				if (message.equals("300")) {
					/* Unsubscribe from channel C1 after first message is received. */
					unsubscribe(channel);
				}
			}

			@Override
			public void onSubscribe(String channel, int subscribedChannels) {
				System.out.println("Client is Subscribed to channel : " + channel);
				System.out.println("Client is Subscribed to " + subscribedChannels + " no. of channels");
			}

			@Override
			public void onUnsubscribe(String channel, int subscribedChannels) {
				System.out.println("Client is Unsubscribed from channel : " + channel);
				System.out.println("Client is Subscribed to " + subscribedChannels + " no. of channels");
			}

		};

		jedisCluster.subscribe(jedisPubSub, channelName);

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

}