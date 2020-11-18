package org.example.app;

import lombok.Data;

/**
 * StudentService
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午11:40
 */
@Data
public class StudentService {

    private int id;

    private String name;

    @Override
    public String toString() {
        return "StudentService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
