package com.michael.demoproject.enumobject;

import java.util.Arrays;

public enum SexEnum {
    MALE(1,"男"),FEMALE(2,"女");

    private Integer id;
    private String name;

    SexEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public static SexEnum getSexEnumByid(Integer id){
      return   Arrays.stream(SexEnum.values()).filter(sexEnum -> sexEnum.getId()==id).findFirst().orElse(null);
    }
}
