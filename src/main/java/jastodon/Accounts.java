package jastodon;

import jastodon.entities.Account;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

/**
 * @author Southrop
 */

public interface Accounts {

    /**
     * Retrieves the details of a specified account.
     * @param accountId    ID of the account to be retrieved.
     * @return an {@link Account} object for the user with the specified ID.
     */
    @GET("/api/v1/accounts/{id}")
    Call<Account> getAccount(@Path("id") String accountId);

    /**
     * Retrieves the details of the current account.
     * @return an {@link Account} object for the current account.
     */
    @GET("/api/v1/accounts/verify_credentials")
    Call<Account> getCurrentAccount();

    /**
     * Updates the profile for the current account.
     * @param displayName  name to display in the user's profile.
     * @param note         biography for the user.
     * @param avatar       base64 encoded image to display as the user's avatar.
     * @param header       base64 encoded image to display as the user's header image
     * @return an {@link Account} object for the updated account.
     */
    @PATCH("/api/v1/accounts/update_credentials")
    Call<Account> updateAccount(
            @Field("display_name") String displayName,
            @Field("note") String note,
            @Field("avatar") String avatar,
            @Field("header") String header
    );

    /**
     * Retrieves the followers for the specified account.
     * @param accountId     ID of the account whose followers list is to be retrieved.
     * @return an array containing all the {@link Account}s that follow the specified user.
     */
    @GET("/api/v1/accounts/{id}/followers")
    Call<Account[]> getAccountFollowers(@Path("id") String accountId);

    /**
     * Retrieves the accounts followed by the specified account.
     * @param accountId     ID of the account whose following list is to be retrieved.
     * @return an array containing all the {@link Account}s that the specified user is following.
     */
    @GET("/api/v1/accounts/{id}/following")
    Call<Account[]> getAccountFollowing(@Path("id") String accountId);

}