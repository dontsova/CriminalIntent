package com.grayhound.CriminalIntent;

import java.util.UUID;

/**
 * Created by slava on 11.03.15.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime(){
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
