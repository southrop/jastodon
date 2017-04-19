package jastodon.services;

import jastodon.entities.Status;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Southrop
 */

public interface TimelineService {

    @GET("timelines/home")
    Call<Status[]> getHomeTimeline();

    @GET("timelines/public")
    Call<Status[]> getPublicTimeline(
            @Query("local") Boolean onlyLocal
    );

    @GET("timelines/tag/{hashtag}")
    Call<Status[]> getTagTimeline(
            @Path("hashtag") String hashtag,
            @Query("local") Boolean onlyLocal
    );

}
