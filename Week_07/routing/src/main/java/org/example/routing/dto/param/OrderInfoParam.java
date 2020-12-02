package org.example.routing.dto.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * OrderInfo
 * @author duansg
 * @version 1.0
 */
public class OrderInfoParam {

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    public static class CreateParam implements Serializable {

        private static final long serialVersionUID = -4127626599600813412L;

        private Long userId;

        private Integer quantity;
    }

}
