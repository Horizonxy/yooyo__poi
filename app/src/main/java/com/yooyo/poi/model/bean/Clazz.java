package com.yooyo.poi.model.bean;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/7.
 */

@DatabaseTable
public class Clazz implements Serializable {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String name;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Student> students;

    public ForeignCollection<Student> getStudents() {
        return students;
    }

    public void setStudents(ForeignCollection<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
