package com.car.manage.common.hibernate.converters;

import com.car.util.json.JsonUtil;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.MutableMutabilityPlan;
import org.hibernate.usertype.DynamicParameterizedType;

import java.io.Serializable;
import java.util.Objects;
import java.util.Properties;

/**
 * json type desc.
 */
public class JsonTypeDescriptor
        extends AbstractTypeDescriptor<Serializable>
        implements DynamicParameterizedType {

    private Class<? extends Serializable> jsonObjectClass;

    @Override
    public void setParameterValues(Properties parameters) {
        jsonObjectClass = ((ParameterType) parameters.get(PARAMETER_TYPE)).getReturnedClass();

    }

    /**
     * init.
     */
    public JsonTypeDescriptor() {
        super(Serializable.class, new MutableMutabilityPlan<Serializable>() {
            @Override
            protected Serializable deepCopyNotNull(Serializable value) {
                return JsonUtil.clone(value);
            }
        });
    }

    @Override
    public boolean areEqual(Serializable one, Serializable another) {
        if (one == another) {
            return true;
        }

        if (one == null || another == null) {
            return false;
        }

        return Objects.equals(JsonUtil.toString(one), JsonUtil.toString(another));
    }

    @Override
    public String toString(Serializable value) {
        return JsonUtil.toString(value);
    }

    @Override
    public Serializable fromString(String string) {
        return JsonUtil.fromString(string, jsonObjectClass);
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public <X> X unwrap(Serializable value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }

        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }

        if (Object.class.isAssignableFrom(type)) {
            return JsonUtil.fromString(JsonUtil.toString(value), type);
        }

        throw unknownUnwrap(type);
    }

    @Override
    public <X> Serializable wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }

        return fromString(value.toString());
    }
}
