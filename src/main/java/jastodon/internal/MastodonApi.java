package jastodon.internal;

import javax.annotation.Nonnull;

/**
 * @author admin
 */

public class MastodonApi {

    private static final String BASE_SCHEME = "https://";

    private final String baseUrl;

    public MastodonApi(@Nonnull String host) {
        if (!host.startsWith("http")) {
            host = BASE_SCHEME + host;
        }
        if (!host.endsWith("/")) {
            host = host + "/";
        }
        this.baseUrl = host;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

}
