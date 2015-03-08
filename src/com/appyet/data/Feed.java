// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;

import com.appyet.d.e;
import com.appyet.f.l;
import com.appyet.manager.bl;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Feed
    implements Serializable
{

    public static final String COLUMN_ARTICLE_NUMBER_LIMIT = "ArticleNumberLimit";
    public static final String COLUMN_CACHE_GUID = "CacheGuid";
    public static final String COLUMN_ENCODING = "Encoding";
    public static final String COLUMN_FAV_ICON = "FavIcon";
    public static final String COLUMN_FEED_ID = "FeedId";
    public static final String COLUMN_FEED_TYPE = "FeedType";
    public static final String COLUMN_GUID = "Guid";
    public static final String COLUMN_HTTPETag = "HTTPETag";
    public static final String COLUMN_HTTPLastModified = "HTTPLastModified";
    public static final String COLUMN_IMAGE_LINK = "ImageLink";
    public static final String COLUMN_IS_AUTO_MOBILIZE = "IsAutoMobilize";
    public static final String COLUMN_IS_DOWNLOAD_NEW_ENCLOSURE = "IsDownloadNewEnclosure";
    public static final String COLUMN_LINK = "Link";
    public static final String COLUMN_MOBILIZE_PROVIDER = "MobilizeProvider";
    public static final String COLUMN_MODULE_ID = "ModuleId";
    public static final String COLUMN_PUB_DATE = "PubDate";
    public static final String COLUMN_STREAM_HASH = "StreamHash";
    public static final String COLUMN_SYNC_DATE = "SyncDate";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_TOTAL_COUNT = "TotalCount";
    public static final String COLUMN_UNREAD_COUNT = "UnreadCount";
    public static final String COLUMN_WEB_LINK = "WebLink";
    private static final long serialVersionUID = 0xa4a5d25d6814ac8cL;
    private long mArticleNumberLimit;
    private String mCacheGuid;
    private String mEncoding;
    private String mFavIcon;
    private String mFavIconUrlMD5;
    private Long mFeedId;
    private List mFeedItems;
    private FeedTypeEnum mFeedType;
    private String mGuid;
    private String mHTTPETag;
    private String mHTTPLastModified;
    private String mImageLink;
    private String mImageLinkMD5;
    private boolean mIsAutoMobilize;
    private boolean mIsDownloadNewEnclosure;
    private boolean mIsSelected;
    private String mLink;
    private String mMobilizeProvider;
    private long mModuleId;
    private Date mPubDate;
    private String mPubDateString;
    private String mStreamHash;
    private Date mSyncDate;
    private String mTitle;
    private long mTotalCount;
    private long mUnreadCount;
    private String mWebLink;

    public Feed()
    {
    }

    public void applyChange(Feed feed)
    {
        setUnreadCount(feed.getUnreadCount());
        setTotalCount(feed.getTotalCount());
        setFeedId(feed.getFeedId());
        setFeedType(feed.getFeedType());
        setLink(feed.getLink());
        setPubDate(feed.getPubDate());
        setTitle(feed.getTitle());
        setEncoding(feed.getEncoding());
        setFavIcon(feed.getFavIcon());
        setWebLink(feed.getWebLink());
        setImageLink(feed.getImageLink());
        setIsAutoMobilize(feed.getIsAutoMobilize());
        setIsDownloadNewEnclosure(feed.getIsDownloadNewEnclosure());
        setGuid(feed.getGuid());
        setCacheGuid(feed.getCacheGuid());
        setHTTPETag(feed.getHTTPETag());
        setHTTPLastModified(feed.getHTTPLastModified());
        setSyncDate(feed.getSyncDate());
        setStreamHash(feed.getStreamHash());
        setModuleId(feed.getModuleId());
        setArticleNumberLimit(feed.getArticleNumberLimit());
    }

    public long getArticleNumberLimit()
    {
        return mArticleNumberLimit;
    }

    public String getCacheGuid()
    {
        return mCacheGuid;
    }

    public String getEncoding()
    {
        return mEncoding;
    }

    public String getFavIcon()
    {
        return mFavIcon;
    }

    public String getFavIconUrl()
    {
        if (getFavIcon() != null)
        {
            return getFavIcon();
        }
        if (getWebLink() != null)
        {
            return (new StringBuilder("http://")).append(bl.a(getWebLink())).append("/favicon.ico").toString();
        } else
        {
            return null;
        }
    }

    public String getFavIconUrlMD5()
    {
label0:
        {
            if (mFavIconUrlMD5 == null)
            {
                String s = getFavIconUrl();
                if (s == null)
                {
                    break label0;
                }
                mFavIconUrlMD5 = e.a(s);
            }
            return mFavIconUrlMD5;
        }
        return null;
    }

    public Long getFeedId()
    {
        return mFeedId;
    }

    public List getFeedItems()
    {
        return mFeedItems;
    }

    public FeedTypeEnum getFeedType()
    {
        return mFeedType;
    }

    public String getGuid()
    {
        return mGuid;
    }

    public String getHTTPETag()
    {
        return mHTTPETag;
    }

    public String getHTTPLastModified()
    {
        return mHTTPLastModified;
    }

    public String getImageLink()
    {
        return mImageLink;
    }

    public String getImageLinkMD5()
    {
label0:
        {
            if (mImageLinkMD5 == null)
            {
                String s = getImageLink();
                if (s == null)
                {
                    break label0;
                }
                mImageLinkMD5 = e.a(s);
            }
            return mImageLinkMD5;
        }
        return null;
    }

    public boolean getIsAutoMobilize()
    {
        return false;
    }

    public boolean getIsDownloadNewEnclosure()
    {
        return mIsDownloadNewEnclosure;
    }

    public boolean getIsSelected()
    {
        return mIsSelected;
    }

    public String getLink()
    {
        return mLink;
    }

    public String getMobilizeProvider()
    {
        return mMobilizeProvider;
    }

    public long getModuleId()
    {
        return mModuleId;
    }

    public Date getPubDate()
    {
        return mPubDate;
    }

    public String getPubDateString()
    {
        return mPubDateString;
    }

    public String getStreamHash()
    {
        return mStreamHash;
    }

    public Date getSyncDate()
    {
        return mSyncDate;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public long getTotalCount()
    {
        return mTotalCount;
    }

    public long getUnreadCount()
    {
        return mUnreadCount;
    }

    public String getWebLink()
    {
        return mWebLink;
    }

    public void setArticleNumberLimit(long l1)
    {
        mArticleNumberLimit = l1;
    }

    public void setCacheGuid(String s)
    {
        mCacheGuid = s;
    }

    public void setEncoding(String s)
    {
        mEncoding = s;
    }

    public void setFavIcon(String s)
    {
        mFavIcon = s;
    }

    public void setFeedId(Long long1)
    {
        mFeedId = long1;
    }

    public void setFeedItems(List list)
    {
        mFeedItems = list;
    }

    public void setFeedType(FeedTypeEnum feedtypeenum)
    {
        mFeedType = feedtypeenum;
    }

    public void setGuid(String s)
    {
        mGuid = s;
    }

    public void setHTTPETag(String s)
    {
        mHTTPETag = s;
    }

    public void setHTTPLastModified(String s)
    {
        mHTTPLastModified = s;
    }

    public void setImageLink(String s)
    {
        mImageLink = s;
    }

    public void setIsAutoMobilize(boolean flag)
    {
        mIsAutoMobilize = flag;
    }

    public void setIsDownloadNewEnclosure(boolean flag)
    {
        mIsDownloadNewEnclosure = flag;
    }

    public void setIsSelected(boolean flag)
    {
        mIsSelected = flag;
    }

    public void setLink(String s)
    {
        mLink = s;
    }

    public void setMobilizeProvider(String s)
    {
        mMobilizeProvider = s;
    }

    public void setModuleId(long l1)
    {
        mModuleId = l1;
    }

    public void setPubDate(Date date)
    {
        mPubDate = date;
    }

    public void setPubDateString(String s)
    {
        mPubDateString = s;
        try
        {
            if (mPubDateString != null)
            {
                mPubDate = l.a(mPubDateString);
            }
            return;
        }
        catch (Exception exception)
        {
            mPubDate = null;
        }
    }

    public void setStreamHash(String s)
    {
        mStreamHash = s;
    }

    public void setSyncDate(Date date)
    {
        mSyncDate = date;
    }

    public void setTitle(String s)
    {
        mTitle = s;
    }

    public void setTotalCount(long l1)
    {
        mTotalCount = l1;
    }

    public void setUnreadCount(long l1)
    {
        mUnreadCount = l1;
    }

    public void setWebLink(String s)
    {
        mWebLink = s;
    }
}
