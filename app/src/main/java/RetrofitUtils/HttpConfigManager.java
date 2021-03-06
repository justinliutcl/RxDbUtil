package RetrofitUtils;

import android.content.Context;

import java.util.List;

import LogUtils.CommonLog;
import RetrofitUtils.DataBean.SoundCloudMusic;
import RetrofitUtils.DataBean.SoundConfigCallBack;
import RetrofitUtils.configRequest.SoundConfigRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Justinliu on 2018/3/21.
 */

public class HttpConfigManager {
    private static final int LIMIT  = 20;
    private              int offset = 0;

    public void refreshConfig(final Context context, String q, final SoundConfigCallBack<SoundCloudMusic> callBack) {
        SoundConfigRequest configRequest = RetrofitManager.getSoundCloudRetrofit().create(SoundConfigRequest.class);
        offset = LIMIT;
        Call<List<SoundCloudMusic>> config = configRequest.getConfig("streamable", "hotness", q, LIMIT + "", "0");
        config.enqueue(new Callback<List<SoundCloudMusic>>() {
            @Override
            public void onResponse(Call<List<SoundCloudMusic>> call, Response<List<SoundCloudMusic>> response) {
                List<SoundCloudMusic> arr = response.body();
                callBack.onDataResponse(arr);
            }

            @Override
            public void onFailure(Call<List<SoundCloudMusic>> call, Throwable t) {
                CommonLog.e("request ad config failed : " + t.getMessage());
                callBack.onDataResponse(null);
            }
        });
    }
}
