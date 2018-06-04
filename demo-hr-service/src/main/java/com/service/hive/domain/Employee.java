package com.service.hive.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Employee {

    @ApiModelProperty(value="ID，主键", hidden=false, notes="主键，隐藏", required=true, dataType="Long")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(value="员工名称")
    @Column
    private String name;

    @ApiModelProperty(value="员工年龄")
    @Column
    private Integer age;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
