// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.highschool.entity;

import com.highschool.entity.HighSchool;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect HighSchool_Roo_Jpa_Entity {
    
    declare @type: HighSchool: @Entity;
    
    declare @type: HighSchool: @Table(name = "HighSchool");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer HighSchool.id;
    
    public Integer HighSchool.getId() {
        return this.id;
    }
    
    public void HighSchool.setId(Integer id) {
        this.id = id;
    }
    
}