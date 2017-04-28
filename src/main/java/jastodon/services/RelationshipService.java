package jastodon.services;

import java.util.List;

import jastodon.models.Account;
import jastodon.models.Relationship;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Southrop
 */


public interface RelationshipService {

    /**
     * Gets the relationship between the current account and the specified account.
     * @param accountId        ID of the account whose relationship with the current account
     *                         is to be retrieved.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @GET("api/v1/accounts/relationships")
    Call<Relationship> getRelationships(@Query("id") int accountId);

    /**
     * Gets the relationship between the current account and the specified account(s).
     * @param accountIds       ID of the accounts whose relationship with the current account is to
     *                         be retrieved.
     * @return                 a list of {@link Relationship} objects representing the
     *                         relationships between the specified accounts and the current account.
     */
    @GET("api/v1/accounts/relationships")
    Call<List<Relationship>> getRelationships(@Query("id[]") int... accountIds);

    /**
     * Follows the specified account for the current account.
     * @param accountId        ID of the account to be followed by the current account.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @POST("api/v1/accounts/{id}/follow")
    Call<Relationship> follow(@Path("id") int accountId);

    /**
     * Follows the specified remote account for the current account.
     * @param fullUsername     The full username in <code>username@domain</code> format of the user
     *                         to be followed the current account.
     * @return                 the local representation of the account as an {@link Account} object.
     */
    @FormUrlEncoded
    @POST("api/v1/follows")
    Call<Relationship> followRemote(@Field("uri") String fullUsername);

    /**
     * Unfollows the specified account for the current account.
     * @param accountId        ID of the account to be unfollowed by the current account.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @POST("api/v1/accounts/{id}/unfollow")
    Call<Relationship> unfollow(@Path("id") int accountId);

    /**
     * Retrieves a list of accounts that have requested to follow the authenticated user.
     * @param maxId           (optional) whether to only return accounts with ID less than
     *                        or equal to this.
     * @param sinceId         (optional) whether to only return accounts with ID greater than this.
     * @param limit           (optional) number of accounts to be returned (default: 40, max: 80).
     * @return                a list of {@link Account}s that have requested to follow the
     *                        authenticated user.
     */
    @GET("api/v1/follow_requests")
    Call<List<Account>> getFollowRequests(
            @Query("max_id") Integer maxId,
            @Query("since_id") Integer sinceId,
            @Query("limit") Integer limit
    );

    /**
     * Approves the request from the specified user to follow the authenticated user.
     * @param accountId       ID of the account whose request is to be approved.
     * @return                an empty response.
     */
    @POST("api/v1/follow_requests/{id}/authorize")
    Call<Response> authorizeFollowRequest(@Path("id") int accountId);

    /**
     * Rejects the request from the specified user to follow the authenticated user.
     * @param accountId       ID of the account whose request is to be rejected.
     * @return                an empty response.
     */
    @POST("api/v1/follow_requests/{id}/reject")
    Call<Response> rejectFollowRequest(@Path("id") int accountId);

    /**
     * Retrieves a list of accounts that have been blocked by the authenticated user.
     * @param maxId           (optional) whether to only return accounts with ID less than
     *                        or equal to this.
     * @param sinceId         (optional) whether to only return accounts with ID greater than this.
     * @param limit           (optional) number of accounts to be returned (default: 40, max: 80).
     * @return                a list of {@link Account}s blocked by the authenticated user.
     */
    @GET("api/v1/blocks")
    Call<List<Account>> getBlocks(
            @Query("max_id") Integer maxId,
            @Query("since_id") Integer sinceId,
            @Query("limit") Integer limit
    );

    /**
     * Blocks the specified account for the current account.
     * @param accountId        ID of the account to be blocked by the current account.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @POST("api/v1/accounts/{id}/block")
    Call<Relationship> block(@Path("id") int accountId);

    /**
     * Unblocks the specified account for the current account.
     * @param accountId        ID of the account to be unblocked by the current account.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @POST("api/v1/accounts/{id}/unblock")
    Call<Relationship> unblock(@Path("id") int accountId);

    /**
     * Mutes the specified account for the current account.
     * @param accountId        ID of the account to be muted by the current account.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @POST("api/v1/accounts/{id}/mute")
    Call<Relationship> mute(@Path("id") int accountId);

    /**
     * Unmutes the specified account for the current account.
     * @param accountId        ID of the account to be unmuted by the current account.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @POST("api/v1/accounts/{id}/unmute")
    Call<Relationship> unmute(@Path("id") int accountId);

}
