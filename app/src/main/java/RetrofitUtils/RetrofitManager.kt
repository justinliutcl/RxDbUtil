package RetrofitUtils

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * created by jeffrey on 2018/2/25.
 */
class RetrofitManager {

    companion object {
        private val SOUND_CLOUD_KEY_DEFAULT = "WKcQQdEZw7Oi01KqtHWxeVSxNyRzgT8M"
        private const val SOUND_CLOUD_BASE_URL = "https://api.soundcloud.com/"
        @JvmStatic
        fun getSoundCloudRetrofit(): Retrofit {
            val builder = OkHttpClient.Builder()
            builder.addInterceptor {
                val origin = it.request()
                val url = origin.url().newBuilder().addQueryParameter("client_id", SOUND_CLOUD_KEY_DEFAULT).build()
                it.proceed(origin.newBuilder().url(url).build())
            }
            return Retrofit.Builder()
                    .baseUrl(SOUND_CLOUD_BASE_URL)
                    .addConverterFactory(DecodeConverterFactory.create())
                    .client(builder.build())
                    .build()
        }

    }


}