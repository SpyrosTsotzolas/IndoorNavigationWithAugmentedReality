package com.example.indoornavigationwithaugmentedreality.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;


@Entity(tableName = "destination_table")
public class Destination {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "x1")
    private int x1;

    @ColumnInfo(name = "y1")
    private int y1;

    @ColumnInfo(name = "x2")
    private int x2;

    @ColumnInfo(name = "y2")
    private int y2;

    @ColumnInfo(name = "x3")
    private int x3;

    @ColumnInfo(name = "y3")
    private int y3;

    @ColumnInfo(name = "x4")
    private int x4;

    @ColumnInfo(name = "y4")
    private int y4;


    public Destination(@NonNull String name, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        this.name = name;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getX3() {
        return x3;
    }

    public int getY3() {
        return y3;
    }

    public int getX4() {
        return x4;
    }

    public int getY4() {
        return y4;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }
}
