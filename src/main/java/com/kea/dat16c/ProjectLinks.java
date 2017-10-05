package com.kea.dat16c;
import java.util.ArrayList;

public class ProjectLinks
{


    private String link;
    private String projectName;
    private String name;
    private String summary;
    private String projectText;


    @Override
    public String toString() {
        return "Link" + link + projectName + name + summary;
    }

    public ProjectLinks()
    {

    }

    public ProjectLinks(String link, String projectText) {
        this.link = link;
        this.projectText = projectText;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProjectText() {
        return projectText;
    }

    public void setProjectText(String projectText) {
        this.projectText = projectText;
    }
}
