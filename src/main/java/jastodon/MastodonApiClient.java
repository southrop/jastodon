package jastodon;

import java.util.concurrent.ConcurrentHashMap;

import jastodon.internal.MastodonApi;
import jastodon.services.AccountService;
import jastodon.services.AppService;
import jastodon.services.StatusesService;
import jastodon.services.TimelineService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author admin
 */

public class MastodonApiClient {
    private final ConcurrentHashMap<Class, Object> services;
    private final Retrofit retrofit;

    public MastodonApiClient(OkHttpClient client, String host) {
        this(client, new MastodonApi(host));
    }

    private MastodonApiClient(OkHttpClient client, MastodonApi api) {
        this.services = new ConcurrentHashMap<>();
        this.retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(api.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public AccountService getAccountService() {
        return getService(AccountService.class);
    }

    public AppService getAppService() {
        return getService(AppService.class);
    }

    public StatusesService getStatusesService() {
        return getService(StatusesService.class);
    }

    public TimelineService getTimelineService() {
        return getService(TimelineService.class);
    }

    @SuppressWarnings("unchecked")
    private <T> T getService(Class<T> cls) {
        if (!services.contains(cls)) {
            services.putIfAbsent(cls, retrofit.create(cls));
        }
        return (T) services.get(cls);
    }
}