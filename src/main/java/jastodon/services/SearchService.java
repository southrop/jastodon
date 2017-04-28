package jastodon.services;

import jastodon.models.Account;
import jastodon.models.Results;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Southrop
 */

public interface SearchService {

    /**
     * Searches for statuses, accounts and hashtags using the given search query. If
     * <code>query</code> is a URL, Mastodon will attempt to fetch the provided account or status.
     * @param query    search query.
     * @param resolve  whether to resolve non-local accounts.
     * @return         a {@link Results} object containing the results.
     */
    @GET("api/v1/search")
    Call<Results> search(
            @Query("q") String query,
            @Query("resolve") Boolean resolve
    );


    /**
     * Searches for accounts using the given search query.
     * Can search for accounts on a different instance if the query is specified in
     * <code>username@domain</code> format and is not already in the database.
     * @param query       search query.
     * @param limit       number of accounts to be returned (default: 40).
     * @return an array of {@link Account}s that match the given search query.
     */
    @GET("api/v1/accounts/search")
    Call<Account[]> searchAccounts(
            @Query("q") String query,
            @Query("limit") int limit
    );

}
