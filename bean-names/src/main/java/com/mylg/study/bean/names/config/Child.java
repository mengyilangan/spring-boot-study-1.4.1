/**
 * @author jiangqiaonan
 * @date 2021-06-17
 */
package com.mylg.study.bean.names.config;

public class Child {
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
