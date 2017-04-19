package jastodon.services;

import jastodon.entities.OAuthTokens;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author Southrop
 */

public interface AppService {

    @FormUrlEncoded
    @POST("api/v1/apps")
    Call<OAuthTokens> registerApp(
            @Field("client_name") String clientName,
            @Field("redirect_uris") String redirectUris,
            @Field("scopes") String scopes,
            @Field("website") String website
    );

}
