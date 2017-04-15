package jastodon.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author Southrop
 */

public class Status {

    public String id;

    public String uri;

    public String url;

    public Account account;

    @SerializedName("in_reply_to_id")
    public String inReplyToId;

    @SerializedName("in_reply_to_account_id")
    public String inReplyToAccountId;

    public String reblog;

    public String content;

    @SerializedName("created_at")
    public Date createdAt;

    @SerializedName("reblogs_count")
    public String reblogsCount;

    @SerializedName("favourites_count")
    public String favouritesCount;

    public boolean reblogged;

    public boolean favourited;

    public boolean sensitive;

    public String spoiler_text;

    public enum Visibility {
        @SerializedName("public")   PUBLIC,
        @SerializedName("unlisted") UNLISTED,
        @SerializedName("private")  PRIVATE,
        @SerializedName("direct")   DIRECT;
    }

    //@SerializedName("media_attachments")
    //public Attachments[] mediaAttachments;

    //public Mentions[] mentions;

    //public Tags[] tags;

    //public Application application;
}
