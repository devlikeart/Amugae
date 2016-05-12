package com.mimos.amugae;

/**
 * Created by jkm50 on 2016-05-12.
 */
public class CardviewItem {
    int idx;
    int image;
    String content;
    int time;
    int lateTime;
    int like;
    int comment;

    int getImage(){
        return this.image;
    }
    String getContent(){
        return this.content;
    }
    int getTime(){
        return  this.time;
    }
    int getComment(){
        return  this.comment;
    }
    int getLike(){
        return  this.like;
    }
    CardviewItem(int idx, int image, String content,int time, int like, int comment){
        this.image = image;
        this.comment = comment;
        this.time = time;
        this.idx = idx;
        this.content = content;
        this.like = like;
    }

}
