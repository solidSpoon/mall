package xyz.solidspoon.mall.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于生产 MBG 的代码
 * @author solidSpoon
 * @date 2021/4/26 18:53
 */
public class Generator {
    public static void main(String[] args) throws XMLParserException, IOException, InvalidConfigurationException, SQLException, InterruptedException {
        // MBG 执行过程中的警告信息
        List<String> warnings = new ArrayList<>();
        // 当生成代码重复时，覆盖原代码
        boolean overwrite = true;
        // 读取我们的 MBG 配置文件
        InputStream inputStream = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(inputStream);
        inputStream.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        // 创建 MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // 执行生成代码
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
