package com.example.querydslTest.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserTest {

    @Autowired
    EntityManager em;

    @Test
    public void testEntity() {
        Team team = new Team("멍충이팀");
        User user = new User("kihwan", 32, "01027886899", team);
        em.persist(team);
        em.persist(user);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QUser qUser = QUser.user;

        User result = query
                .selectFrom(qUser)
                .fetchOne();

        Assertions.assertThat(result).isEqualTo(user);
        Assertions.assertThat(result.getId()).isEqualTo(user.getId());
        Assertions.assertThat(result.getTeam().getTeamname()).isEqualTo(user.getTeam().getTeamname());
    }
}