package jastodon;

import jastodon.entities.Account;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Southrop
 */

public interface MastodonService {

    @GET("/api/v1/accounts/{id}")
    Call<Account> account(@Path("id") String id);

    

}