package com.gateway;

import com.gateway.inbound.HttpInboundServer;

/**
 * GateWayApplication
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/4 10:57 下午
 */
public class GateWayApplication {

    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "1.0.0";

    public static void main(String[] args) throws Exception{
        String proxyServer = System.getProperty("proxyServer","http://localhost:8088");
        String proxyPort = System.getProperty("proxyPort","8888");
        //  http://localhost:8888/api/hello  ==> gateway API
        //  http://localhost:8088/api/hello  ==> backend service
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" starting...");
        HttpInboundServer server = new HttpInboundServer(port, proxyServer);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + proxyServer);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
