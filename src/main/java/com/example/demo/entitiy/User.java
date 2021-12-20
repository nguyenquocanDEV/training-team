package com.example.demo.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    private String username;

    private String email;

    @ManyToOne
    @JoinColumn(name = "company_id", updatable = false, insertable = false)
    @JsonIgnore
    private Company company;

    @Column(name = "company_id")
    private String companyId;

    public User(String username, String email, String companyId) {
        this.username = username;
        this.email = email;
        this.companyId = companyId;
    }

}
