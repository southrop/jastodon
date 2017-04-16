package jastodon.entities;

import com.google.gson.annotations.SerializedName;

/**
 * @author Southrop
 */

public class AppTokens {

    public String id;

    @SerializedName("client_id")
    public String clientId;

    @SerializedName("client_secret")
    public String clientSecret;

}
