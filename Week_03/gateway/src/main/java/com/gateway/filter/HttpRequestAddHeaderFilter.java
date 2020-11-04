package com.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * HttpRequestAddHeaderFilter
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/4 11:56 下午
 */
public class HttpRequestAddHeaderFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("hello", "world");
    }
}
