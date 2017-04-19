package jastodon.internal;

import javax.annotation.Nonnull;

/**
 * @author admin
 */

public class MastodonApi {

    private static final String BASE_SCHEME = "https://";

    private final String baseUrl;

    public MastodonApi(@Nonnull String host) {
        this.baseUrl = BASE_SCHEME + host + "/";
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

}
