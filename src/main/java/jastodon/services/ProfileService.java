package jastodon.services;

import jastodon.models.Account;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;

/**
 * @author Southrop
 */

public interface ProfileService {

    /**
     * Retrieves the details of the current account.
     * @return an {@link Account} object for the current account.
     */
    @GET("api/v1/accounts/verify_credentials")
    Call<Account> getProfile();

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
    Call<Account> updateProfile(
            @Field("display_name") int displayName,
            @Field("note") String note,
            @Field("avatar") String avatar,
            @Field("header") String header
    );

}
