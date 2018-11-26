package example.infrastructure.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("example")

                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(LocalTime.class, String.class)

                .apiInfo(apiInfo())
                .select()
                .paths(patterns())
                .build();
    }

    private Predicate<String> patterns() {
        return or(
                regex("/reservations.*"),
                regex("/uuids.*")
        );
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api example")
                .description("version 1.0")
                .build();
    }

}
