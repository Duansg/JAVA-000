package com.gateway.inbound;

import com.gateway.filter.CustomHttpRequestFilter;
import com.gateway.filter.CustomHttpRequestFilter2;
import com.gateway.filter.FilterChain;
import com.gateway.filter.HttpRequestFilter;
import com.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpInboundHandler
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/4 11:35 下午
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final String proxyServer;
    private HttpOutboundHandler handler;
    private HttpRequestFilter filer;

    public HttpInboundHandler(String proxyServer) {
        this.proxyServer = proxyServer;
        handler = new HttpOutboundHandler(this.proxyServer);
        filer = new CustomHttpRequestFilter();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            fullRequest.headers().add("hello","world");
            // 通过filter过滤器
            FilterChain filterChain = new FilterChain();
            filterChain.add(filer).add(new CustomHttpRequestFilter2());
            filterChain.doFilter(fullRequest, ctx);
            handler.handle(fullRequest, ctx);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
