package example.infrastructure.configuration.graphql;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class TimeScalarType extends GraphQLScalarType {

    private static final String DEFAULT_NAME = "Time";

    public TimeScalarType() {
        this(DEFAULT_NAME);
    }

    public TimeScalarType(final String name) {
        super(name, "Time type", new Coercing<LocalTime, String>() {
            @Override
            public String serialize(Object input) {
                if (input instanceof LocalTime) return input.toString();
                throw new RuntimeException("LocalDate object required");
            }

            @Override
            public LocalTime parseValue(Object input) {
                if( input instanceof String ) return LocalTime.parse((String)input);
                throw new RuntimeException("String HH:MM required");
            }

            @Override
            public LocalTime parseLiteral(Object input) {
                if( input instanceof LocalTime ) return LocalTime.parse((String)input);
                throw new RuntimeException("String YYYY-MM-DD required");
            }
        });
    }

}
