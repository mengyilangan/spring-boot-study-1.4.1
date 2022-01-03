package com.mylg.learn.spring.expression.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mylg
 * @date 2022-01-03
 */
public class Society {
    private String name;

    public static String Advisors = "advisors";

    public static String President = "president";

    private List<Inventor> members = new ArrayList<>();

    private Map officers = new HashMap<>();

    public List getMembers() {
        return members;
    }

    public Map getOfficers() {
        return officers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMember(String name) {
        for (Inventor inventor : members) {
            if (inventor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
