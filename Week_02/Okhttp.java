import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

/**
 * Okhttp
 * @author duansg
 * @version 1.0
 * @date 2020/10/28 10:31 下午
 */
public class Okhttp {

    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .get()
                    .url("http://localhost:8801/test")
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } finally {
            client.clone();
        }
    }
}
