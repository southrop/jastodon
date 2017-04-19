package jastodon.models;

import com.google.gson.annotations.SerializedName;

/**
 * @author Southrop
 */

public class Relationship {

    public int id;

    public boolean following;

    @SerializedName("followed_by")
    public boolean followedBy;

    public boolean blocking;

    public boolean muting;
}
