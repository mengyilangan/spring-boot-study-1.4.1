package com.mylg.learn.spring.expression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mylg
 * @date 2021-12-30
 */
class StringDemoTest {
    /**
     * 调用 JavaBean 属性的示例调用了该String属性Bytes：
     */
    @Test
    void stringByte() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        System.out.println(bytes.length);
        System.out.println(new String(bytes));
    }

    @Test
    void stringConcat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    @Test
    void string() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    /**
     * SpEL 还通过使用标准点符号（例如prop1.prop2.prop3）以及相应的属性值设置来支持嵌套属性 。也可以访问公共字段
     */
    @Test
    void nestProperties() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
        System.out.println(length);
    }

    /**
     * 可以调用 String 的构造函数而不是使用字符串文字，如以下示例所示：
     */
    @Test
    void construct() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);
    }

    @Test
    void parseStr() {
        ExpressionParser parser = new SpelExpressionParser();
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
        Assertions.assertEquals("Hello World", helloWorld);
        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
        System.out.println(avogadrosNumber);
        Assertions.assertEquals(6.0221415E23, avogadrosNumber);
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        Assertions.assertEquals(2147483647, maxValue);
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        Assertions.assertTrue(trueValue);
        Object nullValue = parser.parseExpression("null").getValue();
        Assertions.assertNull(nullValue);
    }
}
