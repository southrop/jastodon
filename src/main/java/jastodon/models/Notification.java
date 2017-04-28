package jastodon.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author Southrop
 */

public class Notification {

    public int id;

    public enum Type {
        @SerializedName("mention")   MENTION,
        @SerializedName("reblog")    REBLOG,
        @SerializedName("favourite") FAVOURITE,
        @SerializedName("follow")    FOLLOW
    }

    @SerializedName("created_at")
    public Date createdAt;

    public Account account;

    public Status status;

}
