//package com.mylg.study.bean.names.repeat;
//
//
//import org.junit.Test;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.type.StandardAnnotationMetadata;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//
///**
// * @author mylg
// * @date 2021-07-09
// */
//public class PersonTest {
//
//    @Test
//    public void testJunit() {
//        Exception e = new RuntimeException("huuhu");
//        e.printStackTrace();
//    }
//
//    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(PersonTest.class);
//        System.out.println(result.getFailures().stream().map(Failure::getMessage).collect(Collectors.joining(",")));
//    }
//
////    @Test
////    public void testStandardAnnotationMetadata() {
////        StandardAnnotationMetadata metadata = new StandardAnnotationMetadata(Person.class);
////        System.out.println(metadata.getAnnotationTypes());
////        System.out.println(metadata.isAbstract());
////        System.out.println(metadata.isFinal());
////        System.out.println(metadata.getClassName());
////        System.out.println(metadata.getAnnotatedMethods(Bean.class.getName()));
////        System.out.println(Arrays.toString(metadata.getMemberClassNames()));
////    }
//
////    @Test
////    public void testClass() {
////        System.out.println(Arrays.toString(E.class.getDeclaredClasses()));
////        System.out.println(E.H.I.class.getEnclosingClass());
////        System.out.println(E.H.class.getEnclosingClass());
////        E.K e = new E().new K();
////        System.out.println(e.getClass().getEnclosingClass());
////    }
//
////    @Configuration("repeatPerson")
////    @ConfigurationProperties(prefix = "person", locations = "business.yml")
////    public class Person {
////        private String name;
////
////        @Bean("name")
////        public String getName() {
////            return name;
////        }
////
////        public void setName(String name) {
////            this.name = name;
////        }
////    }
//}
