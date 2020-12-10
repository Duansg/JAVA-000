package org.example.service;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * XAOrderService
 *
 * @author duansg
 * @version 1.0
 * @date 2020/12/10 上午11:29
 */
@Service
public class XAOrderService {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(XAOrderService.class);

    @Autowired
    public XAOrderService(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Init.
     */
    public void init() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS order_info");
        jdbcTemplate.execute("CREATE TABLE order_info ( id BIGINT AUTO_INCREMENT, order_code VARCHAR(50),user_id INT NOT NULL,  PRIMARY KEY (id))");
    }

    /**
     * Clean up.
     */
    public void cleanup() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS order_info");
    }

    /**
     * Execute XA.
     *
     * @param count insert record count
     * @return transaction type
     */
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public TransactionType insert(final int count) {
        return jdbcTemplate.execute("INSERT INTO order_info (order_code, user_id) VALUES (?, ?)", (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            doInsert(count, preparedStatement);
            return TransactionTypeHolder.get();
        });
    }

    /**
     * Execute XA with exception.
     *
     * @param count insert record count
     */
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void insertFailed(final int count) {
        jdbcTemplate.execute("INSERT INTO order_info (order_code, user_id) VALUES (?, ?)", (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            doInsert(count, preparedStatement);
            throw new SQLException("mock transaction failed");
        });
    }

    private void doInsert(final int count, final PreparedStatement preparedStatement) throws SQLException {
        for (int i = 0; i < count; i++) {
            preparedStatement.setObject(1, i+2);
            preparedStatement.setObject(2, i+3);
            preparedStatement.executeUpdate();
            logger.info("doInsert :"+i);
        }
    }

    /**
     * Select all.
     *
     * @return record count
     */
    public int selectAll() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) AS count FROM order_info", Integer.class);
    }
}
