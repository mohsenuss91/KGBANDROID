// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;

import java.io.Serializable;

public class FileCache
    implements Serializable
{

    public static final String COLUMN_CACHE_GUID = "CacheGuid";
    public static final String COLUMN_DOWNLOAD_ATTEMPT = "DownloadAttempt";
    public static final String COLUMN_DOWNLOAD_STATUS = "DownloadStatus";
    public static final String COLUMN_FILE_CACHE_ID = "FileCacheId";
    public static final String COLUMN_FILE_CACHE_NAME = "FileCacheName";
    public static final String COLUMN_FILE_LINK = "FileLink";
    public static final String COLUMN_FILE_TYPE = "FileType";
    private static final long serialVersionUID = 0x92b31902c86f53f3L;
    private String mCacheGuid;
    private Integer mDownloadAttempt;
    private DownloadStatusEnum mDownloadStatus;
    private Long mFileCacheId;
    private String mFileCacheName;
    private String mFileLink;
    private FileTypeEnum mFileType;

    public FileCache()
    {
    }

    public String getCacheGuid()
    {
        return mCacheGuid;
    }

    public Integer getDownloadAttempt()
    {
        return mDownloadAttempt;
    }

    public DownloadStatusEnum getDownloadStatus()
    {
        return mDownloadStatus;
    }

    public Long getFileCacheId()
    {
        return mFileCacheId;
    }

    public String getFileCacheName()
    {
        return mFileCacheName;
    }

    public String getFileLink()
    {
        return mFileLink;
    }

    public FileTypeEnum getFileType()
    {
        return mFileType;
    }

    public void setCacheGuid(String s)
    {
        mCacheGuid = s;
    }

    public void setDownloadAttempt(Integer integer)
    {
        mDownloadAttempt = integer;
    }

    public void setDownloadStatus(DownloadStatusEnum downloadstatusenum)
    {
        mDownloadStatus = downloadstatusenum;
    }

    public void setDownloadStatus(String s)
    {
        if (s.equals("Pending"))
        {
            mDownloadStatus = DownloadStatusEnum.Pending;
            return;
        }
        if (s.equals("Failed"))
        {
            mDownloadStatus = DownloadStatusEnum.Failed;
            return;
        }
        if (s.equals("Success"))
        {
            mDownloadStatus = DownloadStatusEnum.Success;
            return;
        } else
        {
            s.equals("Ignore");
            mDownloadStatus = DownloadStatusEnum.Ignore;
            return;
        }
    }

    public void setFileCacheId(Long long1)
    {
        mFileCacheId = long1;
    }

    public void setFileCacheName(String s)
    {
        mFileCacheName = s;
    }

    public void setFileLink(String s)
    {
        mFileLink = s;
    }

    public void setFileType(FileTypeEnum filetypeenum)
    {
        mFileType = filetypeenum;
    }

    public void setFileType(String s)
    {
        if (s.equals("Image"))
        {
            mFileType = FileTypeEnum.Image;
        } else
        {
            if (s.equals("Podcast"))
            {
                mFileType = FileTypeEnum.Podcast;
                return;
            }
            if (s.equals("FavIcon"))
            {
                mFileType = FileTypeEnum.FavIcon;
                return;
            }
            if (s.equals("Thumbnail"))
            {
                mFileType = FileTypeEnum.Thumbnail;
                return;
            }
        }
    }

    private class DownloadStatusEnum extends Enum
    {

        private static final DownloadStatusEnum $VALUES[];
        public static final DownloadStatusEnum Failed;
        public static final DownloadStatusEnum Ignore;
        public static final DownloadStatusEnum Pending;
        public static final DownloadStatusEnum Success;

        public static DownloadStatusEnum valueOf(String s)
        {
            return (DownloadStatusEnum)Enum.valueOf(com/appyet/data/FileCache$DownloadStatusEnum, s);
        }

        public static DownloadStatusEnum[] values()
        {
            return (DownloadStatusEnum[])$VALUES.clone();
        }

        static 
        {
            Pending = new DownloadStatusEnum("Pending", 0);
            Failed = new DownloadStatusEnum("Failed", 1);
            Success = new DownloadStatusEnum("Success", 2);
            Ignore = new DownloadStatusEnum("Ignore", 3);
            DownloadStatusEnum adownloadstatusenum[] = new DownloadStatusEnum[4];
            adownloadstatusenum[0] = Pending;
            adownloadstatusenum[1] = Failed;
            adownloadstatusenum[2] = Success;
            adownloadstatusenum[3] = Ignore;
            $VALUES = adownloadstatusenum;
        }

        private DownloadStatusEnum(String s, int i)
        {
            super(s, i);
        }
    }


    private class FileTypeEnum extends Enum
    {

        private static final FileTypeEnum $VALUES[];
        public static final FileTypeEnum FavIcon;
        public static final FileTypeEnum Image;
        public static final FileTypeEnum Podcast;
        public static final FileTypeEnum Thumbnail;

        public static FileTypeEnum valueOf(String s)
        {
            return (FileTypeEnum)Enum.valueOf(com/appyet/data/FileCache$FileTypeEnum, s);
        }

        public static FileTypeEnum[] values()
        {
            return (FileTypeEnum[])$VALUES.clone();
        }

        static 
        {
            Image = new FileTypeEnum("Image", 0);
            Podcast = new FileTypeEnum("Podcast", 1);
            FavIcon = new FileTypeEnum("FavIcon", 2);
            Thumbnail = new FileTypeEnum("Thumbnail", 3);
            FileTypeEnum afiletypeenum[] = new FileTypeEnum[4];
            afiletypeenum[0] = Image;
            afiletypeenum[1] = Podcast;
            afiletypeenum[2] = FavIcon;
            afiletypeenum[3] = Thumbnail;
            $VALUES = afiletypeenum;
        }

        private FileTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

}
