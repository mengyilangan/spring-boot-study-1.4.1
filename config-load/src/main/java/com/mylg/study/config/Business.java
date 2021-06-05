package com.mylg.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author jiangqiaonan
 * @date 2020-12-30
 */
@Configuration
@ConfigurationProperties(locations = "classpath:business.yml", prefix = "business")
public class Business {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void post() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Business{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
