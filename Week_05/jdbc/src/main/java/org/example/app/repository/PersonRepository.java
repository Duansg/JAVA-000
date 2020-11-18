package org.example.app.repository;

import org.example.app.entity.PersonEntity;

import java.sql.SQLException;

public interface PersonRepository {

    Boolean add(PersonEntity person) throws SQLException;

    Boolean update(PersonEntity person) throws SQLException;

    boolean delete(Long id);

    PersonEntity get(Long id);

}
