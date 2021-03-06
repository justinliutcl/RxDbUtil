package RetrofitUtils.configRequest;

import java.util.List;

import RetrofitUtils.DataBean.SoundCloudMusic;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Justinliu on 2018/1/29.
 */

public interface SoundConfigRequest {

    @GET("tracks.json")
    Call<List<SoundCloudMusic>> getConfig(@Query("filter") String filter,
                                          @Query("order") String order,
                                          @Query("q") String q,
                                          @Query("limit") String limit,
                                          @Query("offset") String offset
    );
}
