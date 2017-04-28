package jastodon.services;

import jastodon.models.Status;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Southrop
 */

public interface FavouriteService {

    /**
     * Retrieves a list of statuses that have been favourited by the authenticated user.
     * @param maxId           (optional) whether to only return statuses with ID less than
     *                        or equal to this.
     * @param sinceId         (optional) whether to only return statuses with ID greater than this.
     * @param limit           (optional) number of statuses to be returned (default: 40, max: 80).
     * @return                an array of {@link Status}es favourited by the authenticated user.
     */
    @GET("api/v1/favourites")
    Call<Status[]> getFavourites(
            @Query("max_id") int maxId,
            @Query("since_id") int sinceId,
            @Query("limit") int limit
    );

    @POST("api/v1/statuses/{id}/favourite")
    Call<Status> favourite(@Path("id") int statusId);

    @POST("api/v1/statuses/{id}/unfavourite")
    Call<Status> unfavourite(@Path("id") int statusId);

}
