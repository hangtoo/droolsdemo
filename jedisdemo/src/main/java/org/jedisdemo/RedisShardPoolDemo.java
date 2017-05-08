package org.jedisdemo;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

public class RedisShardPoolDemo {
    
    final static ShardedJedisPool pool;
    static{
        JedisPoolConfig config =new JedisPoolConfig();//Jedis池配置
        config.setMaxTotal(500);//最大活动的对象个数
        config.setMaxIdle(1000 * 60);//对象最大空闲时间
        config.setMaxWaitMillis(1000 * 10);//获取对象时最大等待时间
        config.setTestOnBorrow(true);
        String hostA = "123.0.0.1";
        int portA = 6379;
        String hostB = "123.0.0.2";
        int portB = 6379;
        List jdsInfoList =new ArrayList(2);
        JedisShardInfo infoA = new JedisShardInfo(hostA, portA);
        infoA.setPassword("pswd");
        JedisShardInfo infoB = new JedisShardInfo(hostB, portB);
        infoB.setPassword("pswd");
        jdsInfoList.add(infoA);
        jdsInfoList.add(infoB);
        pool =new ShardedJedisPool(config, jdsInfoList, Hashing.MURMUR_HASH,
        		Sharded.DEFAULT_KEY_TAG_PATTERN);
     }
       
    /**
    
     * @param args
    
     */
    
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            String key = generateKey();
            ShardedJedis jds = null;
            try {
                jds = pool.getResource();
                System.out.println(key+":"+jds.getShard(key).getClient().getHost());
                System.out.println(jds.set(key,Math.random()+""));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pool.returnResource(jds);
            }
        }
    }
    
    private static int index = 1;
    public static String generateKey(){
        return String.valueOf(Thread.currentThread().getId())+"_"+(index++);
    }
}