package _Tools.testRedis.testGetAndSet;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class TesrRedisClient {
	private static JedisCluster jedisCluster;

	public static void main(String[] args) {

		init(args[0]);
		String processType = args[1];
		System.out.println("processType = " + processType);
		switch (processType) {
		case "SET":
			setData(args[2], args[3]);
			break;
		case "GET":
			getData(args[2]);
			break;
		default:
			System.out.println("Unexpected value: " + processType);
		}

	}

	private static void init(String proDataPath) {
		InputStream in = null;
		Properties pro = null;
		try {
			in = new FileInputStream(proDataPath);
			pro = new Properties();
			try {
				pro.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("RedisClient : " + ex.getMessage());
		}

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
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void getData(String key) {

		// 获取一个键的值
		String value = jedisCluster.get(key);
		System.out.println("get value ok");
		System.out.println("key =[" + key + "],value =[" + value + "]");

		// 关闭连接
		jedisCluster.close();
	}

	private static void setData(String key, String value) {

		// 存储一个键值对
		jedisCluster.set(key, value);
		System.out.println("set value ok");
		System.out.println("key =[" + key + "],value =[" + value + "]");
		// 关闭连接
		jedisCluster.close();
	}
}