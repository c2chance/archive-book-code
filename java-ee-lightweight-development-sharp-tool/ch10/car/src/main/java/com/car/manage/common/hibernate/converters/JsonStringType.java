package com.car.manage.common.hibernate.converters;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.hibernate.usertype.DynamicParameterizedType;

import java.io.Serializable;
import java.util.Properties;

/**
 * json type.
 */
public class JsonStringType extends
        AbstractSingleColumnStandardBasicType<Serializable> implements DynamicParameterizedType {
    /**
     * sql type to java type.
     *
     * @param sqlTypeDescriptor  sql type desc
     * @param javaTypeDescriptor java type
     */
    public JsonStringType(SqlTypeDescriptor sqlTypeDescriptor, JavaTypeDescriptor<Serializable> javaTypeDescriptor) {
        super(JsonStringSqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor());
    }

    /**
     * init.
     */
    public JsonStringType() {
        super(JsonStringSqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor());
    }

    public String getName() {
        return "json";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((JsonTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}
