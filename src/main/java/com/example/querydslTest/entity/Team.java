package com.example.querydslTest.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "teamname"})
public class Team {
    @Id @GeneratedValue
    private Long id;
    private String teamname;

    @OneToMany(mappedBy = "team")
    private List<User> users = new ArrayList<>();

    public Team (String teamname) {
        this.teamname = teamname;
    }
}
