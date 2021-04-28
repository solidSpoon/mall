package xyz.solidspoon.mall.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * 自定义注释生成器
 * @author solidSpoon
 * @date 2021/4/26 18:35
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";

    /**
     * 设置用户配置的参数
     * @param properties
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);

        // isTrue() 判断字符是不是 true
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     * 给字段添加注释
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        // 根据参数和备注信息判断是否添加备注信息
        // stringHasValue() 判断字符是否有内容
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
//           addFieldJavaDoc(field, remarks);
            // 数据库中特殊字符需要转义
            if (remarks.contains("\"")) {
                remarks = remarks.replace("\"", "'");
            }
            // 给 model 的字段添加 swagger 注解
            field.addJavaDocLine("@ApiModelProperty(value = \"" + remarks + "\")");
        }
    }

    /**
     * 给 model 的字段添加注释
     * @param field
     * @param remarks
     */
    private void addFieldJavaDoc(Field field, String remarks) {
        // 文档注释开始
        field.addJavaDocLine("/**");
        // 获取数据库字段的备注信息
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for (String remarkLine : remarkLines) {
            field.addJavaDocLine(" * " + remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        // 只在 model 中添加 swagger 注解类的导入
        if (!compilationUnit.isJavaInterface() && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
        }
    }
}
