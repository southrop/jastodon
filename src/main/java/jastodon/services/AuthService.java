package jastodon.services;

import jastodon.models.oauth.AccessToken;
import jastodon.models.oauth.ClientTokens;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author Southrop
 */

public interface AuthService {

    @FormUrlEncoded
    @POST("api/v1/apps")
    Call<ClientTokens> registerClient(
            @Field("client_name") String clientName,
            @Field("redirect_uris") String redirectUris,
            @Field("scopes") String scopes,
            @Field("website") String website
    );

    @FormUrlEncoded
    @POST("oauth/token")
    Call<AccessToken> getAccessToken(
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("redirect_uri") String redirectUri,
            @Field("code") String code,
            @Field("grant_type") String grantType
    );

}
