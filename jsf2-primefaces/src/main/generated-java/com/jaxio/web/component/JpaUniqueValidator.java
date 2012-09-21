/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/component/JpaUniqueValidator.p.vm.java
 */
package com.jaxio.web.component;

import static org.apache.commons.lang.StringUtils.isBlank;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jaxio.util.ResourcesUtil;

@FacesValidator(value = "jpaUniqueValidator")
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class JpaUniqueValidator implements Validator {

    @Inject
    private JpaUniqueSupport jpaUniqueSupport;
    @Inject
    private ResourcesUtil resourcesUtil;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (entity == null && isBlank(property)) {
            return;
        }
        if (entity == null) {
            throw new IllegalStateException("Missing 'entity' attribute");
        }
        if (property == null) {
            throw new IllegalStateException("Missing 'property' attribute");
        }
        if (!jpaUniqueSupport.isUnique(entity, property, value)) {
            throw new ValidatorException(new FacesMessage(resourcesUtil.getProperty(entity.getClass().getSimpleName().toLowerCase() + "_" + property
                    + "_already_exists")));
        }
    }

    private Object entity;
    private String property;

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public Object getEntity() {
        return entity;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}