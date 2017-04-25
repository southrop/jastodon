package jastodon.services;

import javax.annotation.Nullable;

import jastodon.models.Account;

import jastodon.models.Relationship;
import jastodon.models.Status;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
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
     * Retrieves the details of the current account.
     * @return an {@link Account} object for the current account.
     */
    @GET("api/v1/accounts/verify_credentials")
    Call<Account> getCurrentAccount();

    /**
     * Updates the profile for the current account.
     * @param displayName    name to display in the user's profile.
     * @param note           biography for the user.
     * @param avatar         base64 encoded image to display as the user's avatar.
     * @param header         base64 encoded image to display as the user's header image
     * @return an {@link Account} object for the updated account.
     */
    @FormUrlEncoded
    @PATCH("api/v1/accounts/update_credentials")
    Call<Account> updateAccount(
            @Field("display_name") int displayName,
            @Field("note") String note,
            @Field("avatar") String avatar,
            @Field("header") String header
    );

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

    /**
     * Follows the specified account for the current account.
     * @param accountId        ID of the account to be followed by the current account.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @POST("api/v1/accounts/{id}/follow")
    Call<Relationship> follow(@Path("id") int accountId);

    /**
     * Unfollows the specified account for the current account.
     * @param accountId        ID of the account to be unfollowed by the current account.
     * @return                 a {@link Relationship} object representing the updated relationship
     *                         between the two accounts.
     */
    @POST("api/v1/accounts/{id}/unfollow")
    Call<Relationship> unfollow(@Path("id") int accountId);

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
     * @return                 an array of {@link Relationship} objects representing the
     *                         relationships between the specified accounts and the current account.
     */
    @GET("api/v1/accounts/relationships")
    Call<Relationship[]> getRelationships(@Query("id[]") int... accountIds);

    /**
     * Searches for accounts using a given search query.
     * Can search for accounts on a different instance if the query is specified in
     * <code>username@domain</code> format and is not already in the database.
     * @param query       search query.
     * @param limit       number of accounts to be returned (default: 40).
     * @return an array of {@link Account}s that match the given search query.
     */
    @GET("api/v1/accounts/search")
    Call<Account[]> search(
            @Query("q") String query,
            @Query("limit") int limit
    );
}