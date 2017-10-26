package utils;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by DELL on 2017/10/24.
 */

public class NetRequest {
    public static  void call(String url, Map<String,String> params, final Callbck callbck)
    {

       /* OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder body= new FormBody.Builder();
        for (Map.Entry<String, String> stringStringEntry : params.entrySet()) {

            body.add(stringStringEntry.getKey(),stringStringEntry.getValue());
        }

        RequestBody build = body.build();

        Request request=new Request.Builder().url(url).post(build).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callbck.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callbck.onSuccess(call,response);
            }
        });*/

       OkHttpClient okHttpClient=new OkHttpClient();
        /*FormBody.Builder body=new FormBody.Builder();
        for (Map.Entry<String, String> stringStringEntry : params.entrySet()) {
            params.put(stringStringEntry.getKey(),stringStringEntry.getValue());
        }
        RequestBody build = body.build();*/
        Request request=new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callbck.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callbck.onSuccess(call,response);
            }
        });


    }
}
