package jastodon.services;

import jastodon.models.Notification;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Southrop
 */

public interface NotificationService {

    @GET("api/v1/notifications")
    Call<Notification> getNotifications(
            @Query("max_id") int maxId,
            @Query("since_id") int sinceId,
            @Query("limit") int limit
    );

    @GET("api/v1/notifications/{id}")
    Call<Notification> getNotification(
            @Path("id") int notificationId,
            @Query("max_id") int maxId,
            @Query("since_id") int sinceId,
            @Query("limit") int limit
    );

    @POST("api/v1/notifications/clear")
    Call<Response> clearNotifications();

}
