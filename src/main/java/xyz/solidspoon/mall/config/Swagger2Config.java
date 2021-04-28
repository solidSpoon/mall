package xyz.solidspoon.mall.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API 文档的配置
 * @author solidSpoon
 * @date 2021/4/27 17:30
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包下 Controller 生成 API 文档
                .apis(RequestHandlerSelectors.basePackage("xyz.solidspoon.mall.controller"))
                // 为有 @Api 注解的 Controller 生成 API 文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 为有 @ApiOperation 注解的方法生成 API 文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI 演示")
                .description("mall")
                .contact("macro")
                .version("1.0")
                .build();
    }
}
