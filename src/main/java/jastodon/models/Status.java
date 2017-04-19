package jastodon.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author Southrop
 */

public class Status {

    public int id;

    public String uri;

    public String url;

    public Account account;

    @SerializedName("in_reply_to_id")
    public int inReplyToId;

    @SerializedName("in_reply_to_account_id")
    public int inReplyToAccountId;

    public Status reblog;

    public String content;

    @SerializedName("created_at")
    public Date createdAt;

    @SerializedName("reblogs_count")
    public int reblogsCount;

    @SerializedName("favourites_count")
    public int favouritesCount;

    public boolean reblogged;

    public boolean favourited;

    public boolean sensitive;

    @SerializedName("spoiler_text")
    public String spoilerText;

    public enum Visibility {
        @SerializedName("public")   PUBLIC,
        @SerializedName("unlisted") UNLISTED,
        @SerializedName("private")  PRIVATE,
        @SerializedName("direct")   DIRECT;
    }

    //@SerializedName("media_attachments")
    //public Attachment[] mediaAttachments;

    //public Mention[] mentions;

    //public Tag[] tags;

    public Application application;
}
