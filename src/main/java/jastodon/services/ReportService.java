package jastodon.services;

import java.util.List;

import jastodon.models.Report;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author Southrop
 */

public interface ReportService {

    /**
     * Retrieves a list of reports submitted by the authenticated user.
     * @return a list of {@link Report}s submitted by the authenticated user.
     */
    @GET("api/v1/reports")
    Call<List<Report>> getReports();

    /**
     *
     * @param accountId  ID of the account to be reported.
     * @param statusId   ID of the status to be reported.
     * @param comment    comment to associate with the report.
     * @return           the finished {@link Report} object.
     */
    @FormUrlEncoded
    @POST("api/v1/reports")
    Call<Report> reportStatus(
            @Field("account_id") int accountId,
            @Field("status_ids") int statusId,
            @Field("comment") String comment
    );

    /**
     *
     * @param accountId  ID of the account to be reported.
     * @param statusIds  array of IDs of the statuses to be reported.
     * @param comment    comment to associate with the report.
     * @return           the finished {@link Report} object.
     */
    @FormUrlEncoded
    @POST("api/v1/reports")
    Call<Report> reportStatuses(
            @Field("account_id") int accountId,
            @Field("status_ids") int[] statusIds,
            @Field("comment") String comment
    );

}
