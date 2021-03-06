package com.hdudowicz.gamenewsapp;



import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseFeedParser implements FeedParser {
    static final String PUB_DATE = "pubDate";
    static final String TITLE = "title";
    static final String LINK = "link";
    static final String DESCRIPTION = "description";
    static final String ITEM = "item";
    static final String IMAGE_TAG = "thumbnail";


    final URL feedUrl;

    protected BaseFeedParser(String feedUrl){
        try{
            this.feedUrl = new URL(feedUrl);
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }

    protected InputStream getInputStream(){
        try {
            return feedUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
