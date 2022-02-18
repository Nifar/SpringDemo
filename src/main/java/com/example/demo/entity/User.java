package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "u_id"))
public class User extends AbstractEntity {

    @Column(name = "u_name", length = 255, nullable = false, unique = true)
    private String username;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Cat> cats;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "u_id")}, inverseJoinColumns = {@JoinColumn(name = "r_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"u_id", "r_id"})})
    @Column(nullable = false)
    List<Role> roles;

}
