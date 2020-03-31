package com.ids.fao.utils


import com.google.gson.annotations.SerializedName

/**
 * Created by Ibrahim on 11/15/2017.
 */

class JsonParameters {

    @SerializedName("PageUserId")
    var PageUserId: Int = 0

    @SerializedName("UserId")
    var UserId: Int=0



/*    constructor(

        Id: Int,
        PostId: Int,
        CommentId: Int,
        Comment: String,
        RepliesCount: Int,
        UserId: Int,
        UserName: String,
        Image: String,
        Date: String,
        Time: String,
        Replies: SendReplies
    ) {

        this.Id = Id
        this.PostId = PostId
        this.CommentId = CommentId.toString()
        this.Comment = Comment
        this.RepliesCount = RepliesCount
        this.UserName = UserName
        this.UserId = UserId
        this.Image = Image
        this.Date = Date
        this.Time = Time
        this.Replies = Replies
    }*/



}
