package jastodon.services;

import jastodon.entities.Account;

import jastodon.entities.Relationship;
import jastodon.entities.Status;
import retrofit2.Call;
import retrofit2.http.Field;
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
    @GET("accounts/{id}")
    Call<Account> getAccount(@Path("id") int accountId);

    /**
     * Retrieves the details of the current account.
     * @return an {@link Account} object for the current account.
     */
    @GET("accounts/verify_credentials")
    Call<Account> getCurrentAccount();

    /**
     * Updates the profile for the current account.
     * @param displayName    name to display in the user's profile.
     * @param note           biography for the user.
     * @param avatar         base64 encoded image to display as the user's avatar.
     * @param header         base64 encoded image to display as the user's header image
     * @return an {@link Account} object for the updated account.
     */
    @PATCH("accounts/update_credentials")
    Call<Account> updateAccount(
            @Field("display_name") int displayName,
            @Field("note") String note,
            @Field("avatar") String avatar,
            @Field("header") String header
    );

    /**
     * Retrieves a list of accounts that follow the specified account.
     * @param accountId       ID of the account whose followers list is to be retrieved.
     * @return an array containing all the {@link Account}s that follow the specified user.
     */
    @GET("accounts/{id}/followers")
    Call<Account[]> getAccountFollowers(@Path("id") int accountId);

    /**
     * Retrieves a list of accounts followed by the specified account.
     * @param accountId       ID of the account whose following list is to be retrieved.
     * @return an array containing all the {@link Account}s that the specified user is following.
     */
    @GET("accounts/{id}/following")
    Call<Account[]> getAccountFollowing(@Path("id") int accountId);

    /**
     * Retrieves a list of statuses made by the specified account.
     * @param accountId       ID of the account whose statuses are to be retrieved.
     * @param onlyMedia       whether to only return statuses that have media attachments
     * @param excludeReplies  whether to skip statuses that reply to other statuses
     * @return an array containing all the {@link Status}es that the specified user has made.
     */
    @GET("accounts/{id}/statuses")
    Call<Status[]> getStatuses(
            @Path("id") int accountId,
            @Query("only_media") Boolean onlyMedia,
            @Query("exclude_replies") Boolean excludeReplies
    );

    /**
     * Follows the specified account for the current account.
     * @param accountId        ID of the account to be followed by the current account.
     * @return a {@link Relationship} object representing the updated relationship between the two accounts.
     */
    @POST("accounts/:id/follow")
    Call<Relationship> follow(@Path("id") int accountId);

    /**
     * Unfollows the specified account for the current account.
     * @param accountId        ID of the account to be unfollowed by the current account.
     * @return a {@link Relationship} object representing the updated relationship between the two accounts.
     */
    @POST("accounts/{id}/unfollow")
    Call<Relationship> unfollow(@Path("id") int accountId);

}