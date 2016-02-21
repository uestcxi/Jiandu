package com.jason.jiandu.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by Jason on 2016/2/21.
 */
public class ArticleObj extends BmobObject
{
    private String artTitle;
    private String artAuthor;
    private String artContent;
    private String artTime;

    public String getArtTitle()
    {
        return artTitle;
    }

    public void setArtTitle(String artTitle)
    {
        this.artTitle = artTitle;
    }

    public String getArtAuthor()
    {
        return artAuthor;
    }

    public void setArtAuthor(String artAuthor)
    {
        this.artAuthor = artAuthor;
    }

    public String getArtContent()
    {
        return artContent;
    }

    public void setArtContent(String artContent)
    {
        this.artContent = artContent;
    }

    public String getArtTime()
    {
        return artTime;
    }

    public void setArtTime(String artTime)
    {
        this.artTime = artTime;
    }
}
