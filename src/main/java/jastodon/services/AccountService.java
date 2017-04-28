package jastodon.services;

import jastodon.models.Account;
import jastodon.models.Status;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Southrop
 */

public interface AccountService {

    /**
     * Retrieves the details of a specified account.
     * @param accountId      ID of the account to be retrieved.
     * @return an {@link Account} object for the user with the specified ID.
     */
    @GET("api/v1/accounts/{id}")
    Call<Account> getAccount(@Path("id") int accountId);

    /**
     * Retrieves a list of accounts that follow the specified account.
     * @param accountId       ID of the account whose followers list is to be retrieved.
     * @param maxId           (optional) whether to only return statuses with ID less than
     *                        or equal to this.
     * @param sinceId         (optional) whether to only return statuses with ID greater than this.
     * @param limit           (optional) number of statuses to be returned (default: 40, max: 80).
     * @return an array of {@link Account}s that follow the specified user.
     */
    @GET("api/v1/accounts/{id}/followers")
    Call<Account[]> getAccountFollowers(
            @Path("id") int accountId,
            @Query("max_id") Integer maxId,
            @Query("since_id") Integer sinceId,
            @Query("limit") Integer limit
    );

    /**
     * Retrieves a list of accounts followed by the specified account.
     * @param accountId       ID of the account whose following list is to be retrieved.
     * @param maxId           (optional) whether to only return statuses with ID less than
     *                        or equal to this.
     * @param sinceId         (optional) whether to only return statuses with ID greater than this.
     * @param limit           (optional) number of statuses to be returned (default: 40, max: 80).
     * @return an array of {@link Account}s that the specified user is following.
     */
    @GET("api/v1/accounts/{id}/following")
    Call<Account[]> getAccountFollowing(
            @Path("id") int accountId,
            @Query("max_id") Integer maxId,
            @Query("since_id") Integer sinceId,
            @Query("limit") Integer limit
    );

    /**
     * Retrieves a list of statuses made by the specified account.
     * @param accountId       ID of the account whose statuses are to be retrieved.
     * @param onlyMedia       whether to only return statuses that have media attachments.
     * @param excludeReplies  whether to skip statuses that reply to other statuses.
     * @param maxId           (optional) whether to only return statuses with ID less than
     *                        or equal to this.
     * @param sinceId         (optional) whether to only return statuses with ID greater than this.
     * @param limit           (optional) number of statuses to be returned (default: 40, max: 80).
     * @return an array of {@link Status}es that the specified user has made.
     */
    @GET("api/v1/accounts/{id}/statuses")
    Call<Status[]> getStatuses(
            @Path("id") int accountId,
            @Query("only_media") Boolean onlyMedia,
            @Query("exclude_replies") Boolean excludeReplies,
            @Query("max_id") Integer maxId,
            @Query("since_id") Integer sinceId,
            @Query("limit") Integer limit
    );

}
