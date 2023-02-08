package com.example.tobby;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {

  @Autowired
  JdbcTemplate jdbcTemplate;
  @Autowired
  HelloRepository helloRepository;

  @BeforeEach
  void init() {
    jdbcTemplate.execute(
        "create table if not exists hello(name varchar(50) primary key, count int)");
  }

  @Test
  void findHelloFailed() {
    assertThat(helloRepository.findHello("Toby")).isNull();
  }

  @Test
  void increaseCount() {
    helloRepository.increaseCount("Toby");
    assertThat(helloRepository.countOf("Toby")).isEqualTo(1);
  }

}
