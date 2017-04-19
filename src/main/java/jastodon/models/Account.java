package jastodon.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author Southrop
 */

public class Account {

    public int id;

    public String username;

    public String acct;

    public String note;

    public String url;

    public String avatar;

    public String header;

    public boolean locked;

    @SerializedName("created_at")
    public Date createdAt;

    @SerializedName("followers_count")
    public int followersCount;

    @SerializedName("following_count")
    public int followingCount;

    @SerializedName("statuses_count")
    public int statusesCount;

}