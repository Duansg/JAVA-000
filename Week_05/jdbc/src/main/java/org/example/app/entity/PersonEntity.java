package org.example.app.entity;

import lombok.Builder;
import lombok.Data;

/**
 * PersonEntity
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午11:29
 */
@Data
@Builder
public class PersonEntity {

    private Long id;

    private String uuid;

    private String name;

}
