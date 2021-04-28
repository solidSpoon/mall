package xyz.solidspoon.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author solidSpoon
 * @date 2021/4/26 19:09
 */
@Configuration
@MapperScan("xyz.solidspoon.mall.mbg.mapper")
public class MyBatisConfig {}
