package com.study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.entity.Hello;
import com.study.querydsl.entity.QHello;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class QuerydslApplicationTests {

    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {
        Hello hello = new Hello();
        em.persist(hello);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QHello qHello = new QHello("h");

        var result = queryFactory
                .selectFrom(qHello)
                .fetchOne();

        assertThat(result).isEqualTo(hello);
        assertThat(result.getId()).isEqualTo(hello.getId());
    }

}
