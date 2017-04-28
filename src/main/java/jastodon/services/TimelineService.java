package jastodon.services;

import java.util.List;

import jastodon.models.Status;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Southrop
 */

public interface TimelineService {

    @GET("api/v1/timelines/home")
    Call<List<Status>> getHomeTimeline(
            @Query("local") Boolean local,
            @Query("max_id") Integer maxId,
            @Query("since_id") Integer sinceId,
            @Query("limit") Integer limit
    );

    @GET("api/v1/timelines/public")
    Call<List<Status>> getPublicTimeline(
            @Query("local") Boolean local,
            @Query("max_id") Integer maxId,
            @Query("since_id") Integer sinceId,
            @Query("limit") Integer limit
    );

    @GET("api/v1/timelines/tag/{hashtag}")
    Call<List<Status>> getTagTimeline(
            @Path("hashtag") String hashtag,
            @Query("local") Boolean local,
            @Query("max_id") Integer maxId,
            @Query("since_id") Integer sinceId,
            @Query("limit") Integer limit
    );

}
