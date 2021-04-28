package xyz.solidspoon.mall.service;

/**
 * redis 操作 Service
 * 对象和数组都以 json 形式进行存储
 * @author solidSpoon
 * @date 2021/4/27 20:26
 */
public interface RedisService {

    /**
     * 存储数据
     * @param key key
     * @param value value
     */
    void set(String key, String value);

    /**
     * 获取数据
     * @param key key
     * @return value
     */
    String get(String key);

    /**
     * 设置超期时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     * @param key key
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key key
     * @param delta 自增步长
     * @return
     */
    Long increment(String key, long delta);
}
