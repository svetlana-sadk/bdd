package domain;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.lang.*;

public class Journaliste {
    private Integer id;
    private String name;
    private List<String> news;

    public Journaliste(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Journaliste{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
