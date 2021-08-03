/**
 * @author jiangqiaonan
 * @date 2021-06-08
 */
package com.mylg.study.bean.names.define;

import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Arrays;

public class GenericBeanDefinitionDemo {
    public static void main(String[] args) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(A.class);
        beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, 12);
        beanDefinition.setAttribute("m", "1");
        beanDefinition.setAttribute("n", "13");
        System.out.println(Arrays.toString(beanDefinition.attributeNames()));
        System.out.println(beanDefinition);
    }

    public static class A {
        private String a;

        public A(String a) {
            this.a = a;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}
