package com.nnk.springboot.config;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

/**
 *
 * @author tamorieeeen
 *
 */
public class CustomDialect extends AbstractDialect implements IExpressionObjectDialect {

	    private final IExpressionObjectFactory NUMBER_EXPRESSION_OBJECTS_FACTORY = new NumberExpressionFactory();

	    public CustomDialect() {
	
	        super("authUsername");
	
	    }
	
	
	    @Override
	
	    public IExpressionObjectFactory getExpressionObjectFactory() {
	
	        return NUMBER_EXPRESSION_OBJECTS_FACTORY;
	
	    }
	
	}