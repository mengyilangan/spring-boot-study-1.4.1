///**
// * @author mylg
// * @date 2021-07-09
// */
//package com.mylg.study.bean.names.repeat;
//
//import com.mylg.study.bean.names.Application;
//import com.mylg.study.bean.names.importbean.Parent;
//import org.junit.Test;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
//import org.springframework.context.annotation.ConfigurationClassPostProcessor;
//import org.springframework.core.env.StandardEnvironment;
//
//public class ConfigurationClassPostProcessorTest {
//
//    @Test
//    public void testParse() {
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
//        reader.register(Application.class);
//        ConfigurationClassPostProcessor processor = new ConfigurationClassPostProcessor();
//        processor.setEnvironment(new StandardEnvironment());
//        processor.processConfigBeanDefinitions(beanFactory);
//        Parent parent = beanFactory.getBean(Parent.class);
//        System.out.println(parent);
//    }
//}
