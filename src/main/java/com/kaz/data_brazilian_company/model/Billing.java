package com.kaz.data_brazilian_company.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.StringJoiner;

@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public boolean free;
    public boolean database;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isDatabase() {
        return database;
    }

    public void setDatabase(boolean database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Billing.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("free=" + free)
                .add("database=" + database)
                .toString();
    }
}
