package org.product.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * DeductStockResultDto
 * @author duansg
 * @version 1.0
 * @date 2021/1/27 下午5:06
 */
@Data
public class DeductStockResultDto implements Serializable {

    private static final long serialVersionUID = -5817453437345836819L;

    private Integer errno;

    private String batchno;

    private String msg;

    private Integer stock;

    private Integer version;

    private Integer num;
}