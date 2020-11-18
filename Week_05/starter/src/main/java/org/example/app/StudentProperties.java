package org.example.app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * StudentProperties
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午11:39
 */
@Data
@ConfigurationProperties(prefix = "me.bob")
public class StudentProperties {

    private int id;

    private String name;
}
