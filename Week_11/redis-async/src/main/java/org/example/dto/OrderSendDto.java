package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * OrderSendDto
 *
 * @author duansg
 * @version 1.0
 * @date 2021/1/6 下午11:27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSendDto implements Serializable {

    private String orderCode;
}
