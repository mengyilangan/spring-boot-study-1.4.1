package com.mylg.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author jiangqiaonan
 * @date 2020-12-30
 */
@Configuration
@ConfigurationProperties(prefix = "info")
public class Information {
    private Integer student;

    private Integer school;

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    @PostConstruct
    public void post() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Information{" +
            "student=" + student +
            ", school=" + school +
            '}';
    }
}
