package io.spring.bean;

import java.sql.Date;

public class MyReview {
    private String name;
    private String content;
    private String title;
    private Date time_completion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime_completion() {
        return time_completion;
    }

    public void setTime_completion(Date time_completion) {
        this.time_completion = time_completion;
    }
}
