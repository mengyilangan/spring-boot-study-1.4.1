/**
 * @author jiangqiaonan
 * @date 2021-06-05
 */
package com.mylg.study.bean.names.repeat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonFactory {
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("repeat");
        return person;
    }
}
