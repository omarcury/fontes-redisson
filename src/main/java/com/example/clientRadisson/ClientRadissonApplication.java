package com.example.clientRadisson;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

@SpringBootApplication
public class ClientRadissonApplication {

//	@Autowired
//	public static JedisConnectionFactory jedisConnectionFactory;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientRadissonApplication.class, args);

//		Config config = new Config();
//		config.useClusterServers()
//		       // use "rediss://" for SSL connection
//	          .addNodeAddress("redis://18.231.69.180:8002");
////		      .addNodeAddress("redis://18.231.69.180:8002");
//
//		RedissonClient redisson = Redisson.create(config);		
		
//		JedisConnectionFactory jedisConnFactory = new JedisConnectionFactory();
//	    jedisConnFactory.setHostName("18.231.69.180");
//	    jedisConnFactory.setPort(8002);
//	    jedisConnFactory.afterPropertiesSet();
//	    
//	    RedisTemplate<String, String> genericTemplate = new StringRedisTemplate(jedisConnFactory);
//	    RedisTemplate<String, String> xstreamGenericTemplate = new RedisTemplate<String, String>();
//	    xstreamGenericTemplate.setConnectionFactory(jedisConnFactory);	   
	    
	    
//		System.out.println(jedisConnFactory.getHostName());
		

//		System.out.println(jedisConnectionFactory.getHostName());
		
//		Jedis jedis = new Jedis("18.231.69.180", 8002, 600);
//		jedis.set("omar", "cury");
//		String value = jedis.get("omar");	
//		System.out.println(value);
		
//		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//		//Jedis Cluster will attempt to discover cluster nodes automatically
//		jedisClusterNodes.add(new HostAndPort("18.231.69.180", 7002));
//		JedisCluster jc = new JedisCluster(jedisClusterNodes);
//		jc.set("foo", "bar");
//		String value = jc.get("foo");		
		
		try (JedisCluster jedisCluster = new JedisCluster(new HostAndPort("127.0.0.1", 7000))) {
			for (int i = 0; i < 1000; i++) {
			
				jedisCluster.set("key:"+ String.valueOf(i), "value"+String.valueOf(i));				
			}

			for (int j = 0; j < 100; j++) {
				System.out.println(jedisCluster.get("key:"+ String.valueOf(j)));
			}
		    // use the jedisCluster resource as if it was a normal Jedis resource
		} catch (IOException e) {}
//		
		
		
	}
	
	
}
