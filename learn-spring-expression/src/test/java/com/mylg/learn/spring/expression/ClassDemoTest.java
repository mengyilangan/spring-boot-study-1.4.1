package com.mylg.learn.spring.expression;

import com.mylg.learn.spring.expression.bean.Inventor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mylg
 * @date 2021-12-30
 */
class ClassDemoTest {
    @Test
    void testProperties() {
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name"); // Parse name as an expression
        String name = (String) exp.getValue(tesla);
        System.out.println(name);
        exp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(tesla, Boolean.class);
        System.out.println(result);
    }


    @Test
    void testTranslate() {
        Assertions.assertThrows(SpelEvaluationException.class, () -> {
            ExpressionParser parser = new SpelExpressionParser();
            Expression exp = parser.parseExpression(" '姓名:'  + name + ';'");
            StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
            evaluationContext.setVariable("name", "张三");
            String message = exp.getValue(evaluationContext, String.class);
            System.out.println(message);
        });

    }

    @Test
    void testTranslateSimple() {
        Assertions.assertThrows(SpelEvaluationException.class, () -> {
            ExpressionParser parser = new SpelExpressionParser();
            Expression exp = parser.parseExpression(" '姓名:'  + name + ';'");
            SimpleEvaluationContext evaluationContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();
            evaluationContext.setVariable("name", "张三");
            String message = exp.getValue(evaluationContext, String.class);
            System.out.println(message);
        });
    }

    @Test
    void testPropertiesNext() {
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        Inventor context = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        ExpressionParser parser = new SpelExpressionParser();
        int year = (Integer) parser.parseExpression("birthdate.year + 1900").getValue(context);
        String city = (String) parser.parseExpression("placeOfBirth.city").getValue(context);
        System.out.println(year);
        System.out.println(year);
    }

    @Test
    void assignmentMap() {
        String str = "'Hello '+ #name";
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("name", "Mike Tesla");
        SpelExpressionParser parser = new SpelExpressionParser();
        String result = parser.parseExpression(str).getValue(context, String.class);
        System.out.println(result);
    }

}
