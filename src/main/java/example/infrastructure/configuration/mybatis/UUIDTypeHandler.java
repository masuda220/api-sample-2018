package example.infrastructure.configuration.mybatis;

import com.google.common.base.Strings;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.UUID;

/**
 * good with PostgreSQL
 * not good with H2Database
 */

@MappedTypes(UUID.class)
public class UUIDTypeHandler implements TypeHandler<UUID> {

    private static final Logger LOG = LoggerFactory.getLogger(UUIDTypeHandler.class);
    @Override
    public void setParameter(
            PreparedStatement statement,
            int index,
            UUID parameter,
            JdbcType jdbcType) throws SQLException {

        if (parameter == null) {
            statement.setObject(index, null, Types.OTHER);
        } else {
            statement.setObject(index, parameter.toString(), Types.OTHER);
        }

    }

    @Override
    public UUID getResult(ResultSet resultSet, String columnName) throws SQLException {
        return toUUID(resultSet.getString(columnName));
    }

    @Override
    public UUID getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return toUUID(resultSet.getString(columnIndex));
    }

    @Override
    public UUID getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return toUUID(callableStatement.getString(columnIndex));
    }

    private static UUID toUUID(String value) throws SQLException {
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            LOG.warn("Bad UUID found: {}", value);
        }
        return null;
    }

}
