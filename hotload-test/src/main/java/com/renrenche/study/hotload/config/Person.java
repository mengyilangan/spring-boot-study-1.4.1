package com.renrenche.study.hotload.config;

import com.renrenche.config.refresh.ConfigReload;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 1.疑问：当path存在，加载的内容是打包的or外部的
 *
 * @author jiangqiaonan
 * @date 2021/2/1
 */
@ConfigurationProperties(prefix = "config",
        locations = {"classpath:person.yml", "classpath:person1.yml"}
)
@ConfigReload
@Data
public class Person {
    private String first;

    private String last;
}
