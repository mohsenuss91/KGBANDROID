// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;

import com.appyet.d.e;
import com.appyet.f.l;
import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.appyet.data:
//            Feed

public class FeedItem
    implements Serializable
{

    public static final String COLUMN_ARTICLE = "Article";
    public static final String COLUMN_ARTICLE_STATUS = "ArticleStatus";
    public static final String COLUMN_AUTHOR = "Author";
    public static final String COLUMN_CACHE_GUID = "CacheGuid";
    public static final String COLUMN_COMMENTS_COUNT = "CommentsCount";
    public static final String COLUMN_COMMENTS_LINK = "CommentsLink";
    public static final String COLUMN_COMMENTS_WEBLINK = "CommentsWebLink";
    public static final String COLUMN_CREATED_DATE = "CreatedDate";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_ENCLOSURE_CURRENT_POSITION = "EnclosureCurrentPosition";
    public static final String COLUMN_ENCLOSURE_DURATION = "EnclosureDuration";
    public static final String COLUMN_ENCLOSURE_LENGTH = "EnclosureLength";
    public static final String COLUMN_ENCLOSURE_LINK = "EnclosureLink";
    public static final String COLUMN_ENCLOSURE_STATUS = "EnclosureStatus";
    public static final String COLUMN_ENCLOSURE_TYPE = "EnclosureType";
    public static final String COLUMN_FEEDITEM_ID = "FeedItemId";
    public static final String COLUMN_FEED_ID = "FeedId";
    public static final String COLUMN_IS_DELETED = "IsDeleted";
    public static final String COLUMN_IS_QUEUED = "IsQueued";
    public static final String COLUMN_IS_READ = "IsRead";
    public static final String COLUMN_IS_STAR = "IsStar";
    public static final String COLUMN_LINK = "Link";
    public static final String COLUMN_PUB_DATE = "PubDate";
    public static final String COLUMN_QUEUE_ORDER = "QueueOrder";
    public static final String COLUMN_SNIPPET = "Snippet";
    public static final String COLUMN_THUMBNAIL = "Thumbnail";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_UNIQUE_KEY = "UniqueKey";
    private static final long serialVersionUID = 0xe5fed7290ece93f3L;
    private String mArticle;
    private ArticleStatusEnum mArticleStatus;
    private String mAuthor;
    private String mCacheGuid;
    private String mCommentsCount;
    private String mCommentsLink;
    private String mCommentsWebLink;
    private Date mCreatedDate;
    private String mDescription;
    private DisplayModeEnum mDisplayMode;
    private Integer mEnclosureCurrentPosition;
    private Integer mEnclosureDuration;
    private Integer mEnclosureLength;
    private String mEnclosureLink;
    private String mEnclosureLinkMD5;
    private EnclosureStatusEnum mEnclosureStatus;
    private String mEnclosureType;
    private Feed mFeed;
    private Long mFeedItemId;
    private FlagEnum mFlag;
    private boolean mIsDeleted;
    private boolean mIsQueued;
    private boolean mIsRead;
    private boolean mIsStar;
    private String mLink;
    private Date mPubDate;
    private String mPubDateString;
    private long mQueueOrder;
    private String mSnippet;
    private String mThumbnail;
    private String mThumbnailMD5;
    private String mTitle;
    private String mUniqueKey;

    public FeedItem()
    {
        mDisplayMode = DisplayModeEnum.None;
        mArticleStatus = ArticleStatusEnum.None;
        mEnclosureStatus = EnclosureStatusEnum.None;
    }

    public FeedItem(long l1)
    {
        mDisplayMode = DisplayModeEnum.None;
        mFeedItemId = Long.valueOf(l1);
    }

    public String buildUniqueKey()
    {
        if (mUniqueKey != null)
        {
            return mUniqueKey;
        }
        if (mTitle != null && mLink != null)
        {
            return (new StringBuilder()).append(mTitle).append(mLink).toString();
        }
        if (mTitle == null && mLink != null)
        {
            return mLink;
        }
        if (mTitle != null && mLink == null)
        {
            return mTitle;
        } else
        {
            return "";
        }
    }

    public String buildUniqueKeyLegacy()
    {
        if (mTitle != null && mLink != null)
        {
            return (new StringBuilder()).append(mTitle).append(mLink).toString();
        }
        if (mTitle == null && mLink != null)
        {
            return mLink;
        }
        if (mTitle != null && mLink == null)
        {
            return mTitle;
        } else
        {
            return "";
        }
    }

    public void clear()
    {
        mTitle = null;
        mLink = null;
        mDescription = null;
        mPubDate = null;
        mIsRead = false;
        mIsDeleted = false;
        mCommentsLink = null;
        mCommentsWebLink = null;
        mCommentsCount = null;
        mEnclosureType = null;
        mEnclosureLength = Integer.valueOf(-1);
        mEnclosureLink = null;
        mThumbnail = null;
        mSnippet = null;
        mEnclosureDuration = null;
        mEnclosureCurrentPosition = Integer.valueOf(0);
        mAuthor = null;
        mPubDateString = null;
        mIsQueued = false;
        mQueueOrder = 0L;
        mArticleStatus = ArticleStatusEnum.None;
        mEnclosureStatus = EnclosureStatusEnum.None;
        mArticle = null;
        mCacheGuid = null;
        mCreatedDate = null;
        mUniqueKey = null;
    }

    public FeedItem copy()
    {
        FeedItem feeditem = new FeedItem();
        feeditem.mAuthor = mAuthor;
        feeditem.mTitle = mTitle;
        feeditem.mLink = mLink;
        feeditem.mDescription = mDescription;
        feeditem.mPubDate = mPubDate;
        feeditem.mIsRead = mIsRead;
        feeditem.mIsDeleted = mIsDeleted;
        feeditem.mCommentsLink = mCommentsLink;
        feeditem.mCommentsWebLink = mCommentsWebLink;
        feeditem.mCommentsCount = mCommentsCount;
        feeditem.mEnclosureType = mEnclosureType;
        feeditem.mEnclosureLength = mEnclosureLength;
        feeditem.mEnclosureLink = mEnclosureLink;
        feeditem.mThumbnail = mThumbnail;
        feeditem.mSnippet = mSnippet;
        feeditem.mEnclosureDuration = mEnclosureDuration;
        feeditem.mEnclosureCurrentPosition = mEnclosureCurrentPosition;
        feeditem.mPubDateString = mPubDateString;
        feeditem.mIsQueued = mIsQueued;
        feeditem.mQueueOrder = mQueueOrder;
        feeditem.mArticleStatus = mArticleStatus;
        feeditem.mEnclosureStatus = mEnclosureStatus;
        feeditem.mArticle = mArticle;
        feeditem.mCacheGuid = mCacheGuid;
        feeditem.mCreatedDate = mCreatedDate;
        feeditem.mUniqueKey = mUniqueKey;
        return feeditem;
    }

    public String getArticle()
    {
        return mArticle;
    }

    public ArticleStatusEnum getArticleStatus()
    {
        if (mArticleStatus == null)
        {
            return ArticleStatusEnum.None;
        } else
        {
            return mArticleStatus;
        }
    }

    public String getAuthor()
    {
        return mAuthor;
    }

    public String getCacheGuid()
    {
        return mCacheGuid;
    }

    public String getCommentsCount()
    {
        return mCommentsCount;
    }

    public String getCommentsLink()
    {
        return mCommentsLink;
    }

    public String getCommentsWebLink()
    {
        return mCommentsWebLink;
    }

    public Date getCreatedDate()
    {
        return mCreatedDate;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public DisplayModeEnum getDisplayMode()
    {
        if (mDisplayMode == null)
        {
            return DisplayModeEnum.None;
        } else
        {
            return mDisplayMode;
        }
    }

    public Integer getEnclosureCurrentPosition()
    {
        if (mEnclosureCurrentPosition == null || mEnclosureCurrentPosition.intValue() < 0)
        {
            return Integer.valueOf(0);
        } else
        {
            return mEnclosureCurrentPosition;
        }
    }

    public Integer getEnclosureDuration()
    {
        if (mEnclosureDuration == null)
        {
            return Integer.valueOf(0);
        } else
        {
            return mEnclosureDuration;
        }
    }

    public Integer getEnclosureLength()
    {
        if (mEnclosureLength == null || mEnclosureLength.intValue() < 0)
        {
            return Integer.valueOf(0);
        } else
        {
            return mEnclosureLength;
        }
    }

    public String getEnclosureLink()
    {
        return mEnclosureLink;
    }

    public String getEnclosureLinkMD5()
    {
label0:
        {
            if (mEnclosureLinkMD5 == null)
            {
                String s = getEnclosureLink();
                if (s == null)
                {
                    break label0;
                }
                mEnclosureLinkMD5 = e.a(s);
            }
            return mEnclosureLinkMD5;
        }
        return null;
    }

    public EnclosureStatusEnum getEnclosureStatus()
    {
        if (mEnclosureStatus == null)
        {
            return EnclosureStatusEnum.None;
        } else
        {
            return mEnclosureStatus;
        }
    }

    public String getEnclosureType()
    {
        return mEnclosureType;
    }

    public Feed getFeed()
    {
        return mFeed;
    }

    public Long getFeedItemId()
    {
        return mFeedItemId;
    }

    public FlagEnum getFlag()
    {
        return mFlag;
    }

    public boolean getIsDeleted()
    {
        return mIsDeleted;
    }

    public boolean getIsQueued()
    {
        return mIsQueued;
    }

    public boolean getIsRead()
    {
        return mIsRead;
    }

    public boolean getIsStar()
    {
        return mIsStar;
    }

    public String getLink()
    {
        return mLink;
    }

    public Date getPubDate()
    {
        return mPubDate;
    }

    public String getPubDateString()
    {
        return mPubDateString;
    }

    public long getQueueOrder()
    {
        return mQueueOrder;
    }

    public String getSnippet()
    {
        return mSnippet;
    }

    public String getThumbnail()
    {
        return mThumbnail;
    }

    public String getThumbnailMD5()
    {
label0:
        {
            if (mThumbnailMD5 == null)
            {
                String s = getThumbnail();
                if (s == null)
                {
                    break label0;
                }
                mThumbnailMD5 = e.a(s);
            }
            return mThumbnailMD5;
        }
        return null;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public String getUniqueKey()
    {
        return mUniqueKey;
    }

    public void setArticle(String s)
    {
        mArticle = s;
    }

    public void setArticleStatus(ArticleStatusEnum articlestatusenum)
    {
        mArticleStatus = articlestatusenum;
    }

    public void setAuthor(String s)
    {
        mAuthor = s;
    }

    public void setCacheGuid(String s)
    {
        mCacheGuid = s;
    }

    public void setCommentsCount(String s)
    {
        mCommentsCount = s;
    }

    public void setCommentsLink(String s)
    {
        mCommentsLink = s;
    }

    public void setCommentsWebLink(String s)
    {
        mCommentsWebLink = s;
    }

    public void setCreatedDate(Date date)
    {
        mCreatedDate = date;
    }

    public void setDescription(String s)
    {
        mDescription = s;
    }

    public void setDisplayMode(DisplayModeEnum displaymodeenum)
    {
        mDisplayMode = displaymodeenum;
    }

    public void setEnclosureCurrentPosition(Integer integer)
    {
        mEnclosureCurrentPosition = integer;
    }

    public void setEnclosureDuration(Integer integer)
    {
        mEnclosureDuration = integer;
    }

    public void setEnclosureLength(Integer integer)
    {
        mEnclosureLength = integer;
    }

    public void setEnclosureLink(String s)
    {
        mEnclosureLink = s;
    }

    public void setEnclosureStatus(EnclosureStatusEnum enclosurestatusenum)
    {
        mEnclosureStatus = enclosurestatusenum;
    }

    public void setEnclosureType(String s)
    {
        mEnclosureType = s;
    }

    public void setFeed(Feed feed)
    {
        mFeed = feed;
    }

    public void setFeedItemId(Long long1)
    {
        mFeedItemId = long1;
    }

    public void setFlag(FlagEnum flagenum)
    {
        mFlag = flagenum;
    }

    public void setIsDeleted(boolean flag)
    {
        mIsDeleted = flag;
    }

    public void setIsQueued(boolean flag)
    {
        mIsQueued = flag;
    }

    public void setIsRead(boolean flag)
    {
        mIsRead = flag;
    }

    public void setIsStar(boolean flag)
    {
        mIsStar = flag;
    }

    public void setLink(String s)
    {
        mLink = s;
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
            mPubDate = new Date();
        }
    }

    public void setQueueOrder(long l1)
    {
        mQueueOrder = l1;
    }

    public void setSnippet(String s)
    {
        mSnippet = s;
    }

    public void setThumbnail(String s)
    {
        mThumbnail = s;
    }

    public void setTitle(String s)
    {
        mTitle = s;
    }

    public void setUniqueKey(String s)
    {
        mUniqueKey = s;
    }

    private class DisplayModeEnum extends Enum
    {

        private static final DisplayModeEnum $VALUES[];
        public static final DisplayModeEnum Article;
        public static final DisplayModeEnum Feed;
        public static final DisplayModeEnum None;

        public static DisplayModeEnum valueOf(String s)
        {
            return (DisplayModeEnum)Enum.valueOf(com/appyet/data/FeedItem$DisplayModeEnum, s);
        }

        public static DisplayModeEnum[] values()
        {
            return (DisplayModeEnum[])$VALUES.clone();
        }

        static 
        {
            None = new DisplayModeEnum("None", 0);
            Feed = new DisplayModeEnum("Feed", 1);
            Article = new DisplayModeEnum("Article", 2);
            DisplayModeEnum adisplaymodeenum[] = new DisplayModeEnum[3];
            adisplaymodeenum[0] = None;
            adisplaymodeenum[1] = Feed;
            adisplaymodeenum[2] = Article;
            $VALUES = adisplaymodeenum;
        }

        private DisplayModeEnum(String s, int i)
        {
            super(s, i);
        }
    }


    private class ArticleStatusEnum extends Enum
    {

        private static final ArticleStatusEnum $VALUES[];
        public static final ArticleStatusEnum DownloadCompleted;
        public static final ArticleStatusEnum DownloadPending;
        public static final ArticleStatusEnum None;

        public static ArticleStatusEnum valueOf(String s)
        {
            return (ArticleStatusEnum)Enum.valueOf(com/appyet/data/FeedItem$ArticleStatusEnum, s);
        }

        public static ArticleStatusEnum[] values()
        {
            return (ArticleStatusEnum[])$VALUES.clone();
        }

        static 
        {
            None = new ArticleStatusEnum("None", 0);
            DownloadPending = new ArticleStatusEnum("DownloadPending", 1);
            DownloadCompleted = new ArticleStatusEnum("DownloadCompleted", 2);
            ArticleStatusEnum aarticlestatusenum[] = new ArticleStatusEnum[3];
            aarticlestatusenum[0] = None;
            aarticlestatusenum[1] = DownloadPending;
            aarticlestatusenum[2] = DownloadCompleted;
            $VALUES = aarticlestatusenum;
        }

        private ArticleStatusEnum(String s, int i)
        {
            super(s, i);
        }
    }


    private class EnclosureStatusEnum extends Enum
    {

        private static final EnclosureStatusEnum $VALUES[];
        public static final EnclosureStatusEnum DownloadCompleted;
        public static final EnclosureStatusEnum DownloadPending;
        public static final EnclosureStatusEnum None;

        public static EnclosureStatusEnum valueOf(String s)
        {
            return (EnclosureStatusEnum)Enum.valueOf(com/appyet/data/FeedItem$EnclosureStatusEnum, s);
        }

        public static EnclosureStatusEnum[] values()
        {
            return (EnclosureStatusEnum[])$VALUES.clone();
        }

        static 
        {
            None = new EnclosureStatusEnum("None", 0);
            DownloadPending = new EnclosureStatusEnum("DownloadPending", 1);
            DownloadCompleted = new EnclosureStatusEnum("DownloadCompleted", 2);
            EnclosureStatusEnum aenclosurestatusenum[] = new EnclosureStatusEnum[3];
            aenclosurestatusenum[0] = None;
            aenclosurestatusenum[1] = DownloadPending;
            aenclosurestatusenum[2] = DownloadCompleted;
            $VALUES = aenclosurestatusenum;
        }

        private EnclosureStatusEnum(String s, int i)
        {
            super(s, i);
        }
    }

}
