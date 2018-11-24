package example.infrastructure.configuration.graphql;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateScalarType extends GraphQLScalarType {

    private static final String DEFAULT_NAME = "Date";

    public DateScalarType() {
        this(DEFAULT_NAME);
    }

    public DateScalarType(final String name) {
        super(name, "Date type", new Coercing<LocalDate, String>() {
            @Override
            public String serialize(Object input) {
                if (input instanceof LocalDate) return input.toString();
                throw new RuntimeException("LocalDate object required");
            }

            @Override
            public LocalDate parseValue(Object input) {
                if( input instanceof String ) return LocalDate.parse((String)input);
                throw new RuntimeException("String YYYY-MM-DD required");
            }

            @Override
            public LocalDate parseLiteral(Object input) {
                if( input instanceof LocalDate ) return LocalDate.parse((String)input);
                throw new RuntimeException("String YYYY-MM-DD required");
            }
        });
    }

}
