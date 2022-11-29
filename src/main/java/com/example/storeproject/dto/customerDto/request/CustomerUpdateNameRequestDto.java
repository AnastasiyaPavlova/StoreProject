package com.example.storeproject.dto.customerDto.request;


import java.util.Objects;

public class CustomerUpdateNameRequestDto {
    private Long id;
    private String name;

    public CustomerUpdateNameRequestDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public CustomerUpdateNameRequestDto(){}
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerUpdateNameRequestDto that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
