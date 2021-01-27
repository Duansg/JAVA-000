package org.order.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * CheckStockDto
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午11:54
 */
@Data
@Builder
public class CheckStockDto implements Serializable {

    private String productCode;

    private String orderCode;
}
