package com.kea.dat16c;

import java.net.URL;

/**
 * Created by thyge on 05-10-2017.
 */
public class FunLink
{
    private String link;
    private String desc;

    public FunLink()
    {

    }

    public FunLink(String link, String desc)
    {
        this.link = link;
        this.desc = desc;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String toString()
    {
        return link + desc;
    }
}
