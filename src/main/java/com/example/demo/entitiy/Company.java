package com.example.demo.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company extends BaseEntity {

    private String name;

    private String address;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<User> users;


    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
