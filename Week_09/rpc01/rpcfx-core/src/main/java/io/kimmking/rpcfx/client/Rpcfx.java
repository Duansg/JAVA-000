package io.kimmking.rpcfx.client;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.io.IOException;
import java.lang.reflect.Method;

public final class Rpcfx {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.kimmking.rpcfx.demo.api.User");
        ParserConfig.getGlobalInstance().addAccept("io.kimmking.rpcfx.demo.api.Order");
    }

    public static <T> T create(final Class<T> serviceClass, final String url) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(serviceClass);
        enhancer.setCallback(new RpcfxInvocationHandler(serviceClass,url));
        return (T) enhancer.create();
    }

    public static class RpcfxInvocationHandler implements MethodInterceptor {

        public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

        private final Class<?> serviceClass;
        private final String url;

        public <T> RpcfxInvocationHandler(Class<T> serviceClass, String url) {
            this.serviceClass = serviceClass;
            this.url = url;
        }

        private RpcfxResponse post(RpcfxRequest req, String url) throws IOException {
            OkHttpClient client = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), JSON.toJSONString(req)))
                    .build();
            String respJson = client.newCall(request).execute().body().string();
            System.out.println("resp json: " + respJson);
            return JSON.parseObject(respJson, RpcfxResponse.class);
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            RpcfxRequest request = new RpcfxRequest();
            request.setServiceClass(this.serviceClass.getName());
            request.setMethod(method.getName());
            request.setParams(objects);
            RpcfxResponse response = post(request, url);
            return JSON.parse(response.getResult().toString());
        }
    }

}
