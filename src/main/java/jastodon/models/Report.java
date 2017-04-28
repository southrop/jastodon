package jastodon.models;

import com.google.gson.annotations.SerializedName;

/**
 * @author Southrop
 */

public class Report {

    public int id;

    @SerializedName("action_taken")
    public String actionTaken;

}
