package org.example.app.controller;

import org.example.app.entity.PersonEntity;
import org.example.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.UUID;

/**
 * TestController
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午11:33
 */
@RestController
public class TestController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "insert")
    private void insert() throws SQLException {
        personRepository.add(PersonEntity.builder().uuid(UUID.randomUUID().toString()).name("Bob").build());
    }

    @GetMapping(value = "update")
    private void update() throws SQLException {
        personRepository.update(PersonEntity.builder().build());
    }

}
