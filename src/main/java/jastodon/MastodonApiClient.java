package jastodon;

import java.util.concurrent.ConcurrentHashMap;

import jastodon.internal.MastodonApi;
import jastodon.services.AccountService;
import jastodon.services.AuthService;
import jastodon.services.FavouriteService;
import jastodon.services.NotificationService;
import jastodon.services.ProfileService;
import jastodon.services.RelationshipService;
import jastodon.services.ReportService;
import jastodon.services.SearchService;
import jastodon.services.StatusesService;
import jastodon.services.TimelineService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Southrop
 */

public class MastodonApiClient {
    public static final String  OAUTH_AUTHORIZE_PATH = "/oauth/authorize";

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

    public AuthService getAuthService() {
        return getService(AuthService.class);
    }

    public FavouriteService getFavouriteService() {
        return getService(FavouriteService.class);
    }

    public NotificationService getNotificationService() {
        return getService(NotificationService.class);
    }

    public ProfileService getProfileService() {
        return getService(ProfileService.class);
    }

    public RelationshipService getRelationshipService() {
        return getService(RelationshipService.class);
    }

    public ReportService getReportService() {
        return getService(ReportService.class);
    }

    public SearchService getSearchService() {
        return getService(SearchService.class);
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
