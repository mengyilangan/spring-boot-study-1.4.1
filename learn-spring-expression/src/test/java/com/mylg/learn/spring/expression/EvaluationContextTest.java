package com.mylg.learn.spring.expression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#expressions-properties-arrays
 * @author mylg
 * @date 2021-12-31
 */
class EvaluationContextTest {
    @Test
    void testContext() {
        Simple simple = new Simple();
        simple.booleanList.add(true);

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");
        Boolean b = simple.booleanList.get(0);
        Assertions.assertFalse(b);
    }

    @Test
    void testParse() {
        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(config);
        Expression expression = parser.parseExpression("booleanList[3]");
        Simple demo = new Simple();
        Object o = expression.getValue(demo);
        Assertions.assertNull(o);
    }

    @Test
    void testParseString() {
        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(config);
        Expression expression = parser.parseExpression("'list=' + booleanList[0]");
        Simple demo = new Simple();
        demo.booleanList.add(true);
        Object o = expression.getValue(demo);
        Assertions.assertEquals(o.toString(), "list=true");
    }

    public void testMap(){

    }


}

class Simple {
    public List<Boolean> booleanList = new ArrayList<Boolean>();
}
