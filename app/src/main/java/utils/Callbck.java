package utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by DELL on 2017/10/24.
 */

public interface Callbck {

    void onSuccess(Call call, Response response);
    void onFailure(Call call, IOException e);



}
