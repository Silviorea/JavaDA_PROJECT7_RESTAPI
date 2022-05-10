package com.nnk.springboot.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

public class NumberExpressionFactory implements IExpressionObjectFactory
{

	private static final String TEMPORAL_EVALUATION_VARIABLE_NAME = "authUsername";

	private static final Set<String> ALL_EXPRESSION_OBJECT_NAMES = Collections.unmodifiableSet(

			new HashSet<>(Arrays.asList(TEMPORAL_EVALUATION_VARIABLE_NAME)));

	@Override

	public Set<String> getAllExpressionObjectNames()
	{

		return ALL_EXPRESSION_OBJECT_NAMES;

	}

	@Override

	public Object buildObject(

			IExpressionContext context, String expressionObjectName)
	{

		if (

		TEMPORAL_EVALUATION_VARIABLE_NAME.equals(expressionObjectName))
		{

			return new AuthUsername();

		}

		return null;

	}

	@Override

	public boolean isCacheable(String expressionObjectName)
	{

		return true;

	}

}