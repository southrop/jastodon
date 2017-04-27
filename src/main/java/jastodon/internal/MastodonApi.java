package jastodon.internal;

import javax.annotation.Nonnull;

/**
 * @author Southrop
 */

public class MastodonApi {

    private static final String BASE_SCHEME = "https://";

    private final String baseUrl;

    public MastodonApi(@Nonnull String host) {
        String hostWithScheme = host;

        if (!hostWithScheme.startsWith("http")) {
            hostWithScheme = BASE_SCHEME + host;
        }
        
        if (!hostWithScheme.endsWith("/")) {
            hostWithScheme = hostWithScheme + "/";
        }

        this.baseUrl = hostWithScheme;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

}
