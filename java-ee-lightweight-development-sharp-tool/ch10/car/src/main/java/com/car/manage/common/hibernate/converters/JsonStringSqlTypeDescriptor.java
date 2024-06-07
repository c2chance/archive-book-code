package com.car.manage.common.hibernate.converters;

import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicBinder;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * json desc.
 */
public class JsonStringSqlTypeDescriptor
        extends AbstractJsonSqlTypeDescriptor {

    /**
     * 对象实例.
     */
    static final JsonStringSqlTypeDescriptor INSTANCE =
            new JsonStringSqlTypeDescriptor();

    @Override
    public <T> ValueBinder<T> getBinder(
            final JavaTypeDescriptor<T> javaTypeDescriptor) {
        return new BasicBinder<T>(javaTypeDescriptor, this) {
            @Override
            protected void doBind(PreparedStatement st, T value, int index, WrapperOptions options)
                    throws SQLException {
                st.setString(index, javaTypeDescriptor.unwrap(value, String.class, options));
            }

            @Override
            protected void doBind(CallableStatement st, T value, String name, WrapperOptions options)
                    throws SQLException {
                st.setString(name, javaTypeDescriptor.unwrap(value, String.class, options));
            }
        };
    }
}
