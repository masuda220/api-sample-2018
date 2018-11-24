package example.infrastructure.configuration.graphql;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDScalarType extends GraphQLScalarType {

    private static final String DEFAULT_NAME = "UUID";

    public UUIDScalarType() {
        this(DEFAULT_NAME);
    }

    public UUIDScalarType(final String name) {
        super(name, "UUID type", new Coercing<UUID, String>() {
            @Override
            public String serialize(Object input) {
                if (input instanceof UUID) return input.toString();
                throw new RuntimeException("UUID object required");
            }

            @Override
            public UUID parseValue(Object input) {
                if( input instanceof String ) return UUID.fromString((String)input);
                throw new RuntimeException("String required");
            }

            @Override
            public UUID parseLiteral(Object input) {
                if( input instanceof String ) return UUID.fromString((String)input);
                throw new RuntimeException("String required");
            }
        });
    }

}
