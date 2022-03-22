package com.example.querydslTest.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age", "phoneNumber"})
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String username;
    private int age;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public User(String username, int age, String phoneNumber, Team team) {
        this.username = username;
        this.age = age;
        this.phoneNumber = phoneNumber;
        if (team != null) changeTeam(team);
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getUsers().add(this);
    }
}
