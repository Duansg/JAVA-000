package org.example.app.repository.impl;

import org.example.app.entity.PersonEntity;
import org.example.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PersonRepository
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午11:27
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final DataSource dataSource;

    public PersonRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Boolean add(PersonEntity person) throws SQLException {
        String sql = "INSERT INTO t_person(UUID, NAME) VALUES('" + person.getUuid() + "', '" + person.getName() + "')";
        jdbcTemplate.execute(sql);
        return true;
    }

    @Override
    public Boolean update(PersonEntity person) throws SQLException {
        String sql = "UPDATE t_person SET name = ?  WHERE id = ? ";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, "Duansg");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public PersonEntity get(Long id) {
        return null;
    }
}
