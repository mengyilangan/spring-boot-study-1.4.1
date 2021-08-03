/**
 * @author jiangqiaonan
 * @date 2021-06-17
 */
package com.mylg.study.bean.names.controller;

import com.mylg.study.bean.names.config.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RestController("/person")
public class PersonController {
    @Autowired
    private Person person;

    private final Field[] fields = Person.class.getDeclaredFields();

    private final Map<String, Method> methodMap = initConfigMap(Person.class);


    @GetMapping("/object")
    public Object getPerson() {
        return person;
    }

    @GetMapping("/reflection/fields")
    public Map<String, Object> getPersonReflectionFields() {
        Map<String, Object> data = new HashMap<>(fields.length);
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                data.put(field.getName(), field.get(person));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @GetMapping("/reflection/methods")
    public Map<String, Object> getPersonReflectionMethods() {
        Map<String, Object> data = new HashMap<>(methodMap.size());
        for (Map.Entry<String, Method> entry : methodMap.entrySet()) {
            try {
                data.put(entry.getKey(), entry.getValue().invoke(person));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    private Map<String, Method> initConfigMap(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        Map<String, Method> methods = new HashMap<>(fields.length);
        for (Field field : fields) {
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), cls);
                Method getMethod = pd.getReadMethod();
                methods.put(field.getName(), getMethod);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
        }
        return methods;
    }
}
