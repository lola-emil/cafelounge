package com.lolaemil.cafelounge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// TODO: add table status (available, served, reserved)

@Entity
public class DiningTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer guestCount;

    @ManyToOne
    @JoinColumn(name = "table_category_id")
    private TableCategory tableCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    public TableCategory getTableCategory() {
        return tableCategory;
    }

    public void setTableCategory(TableCategory tableCategory) {
        this.tableCategory = tableCategory;
    }
}
