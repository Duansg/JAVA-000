package org.example.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.HashMap;
/**
 * CustomMqMessage
 * @author duansg
 * @version 1.0
 * @date 2021/1/20 下午10:44
 */


@AllArgsConstructor
@Data
public class CustomMqMessage<T> {

    private HashMap<String,Object> headers;

    private T body;

}