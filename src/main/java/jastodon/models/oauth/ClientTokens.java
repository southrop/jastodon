package jastodon.models.oauth;

import com.google.gson.annotations.SerializedName;

/**
 * @author Southrop
 */

public class ClientTokens {

    public String id;

    @SerializedName("client_id")
    public String clientId;

    @SerializedName("client_secret")
    public String clientSecret;

}
