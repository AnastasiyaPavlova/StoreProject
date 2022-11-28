package com.example.storeproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private Long parentCategoryId;
    private String name;

    public Category(String name, long parentCategoryId) {
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getId(), category.getId()) && Objects.equals(getParentCategoryId(), category.getParentCategoryId()) && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getParentCategoryId(), getName());
    }
}


