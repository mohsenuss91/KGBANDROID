// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcel;
import java.io.Externalizable;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK, VideoAd, AdCache, MMAdImpl

abstract class CachedAd
    implements Externalizable
{

    static final int INTERSTITIAL = 2;
    static final int NATIVE = 3;
    static final int VIDEO = 1;
    static final long serialVersionUID = 0x465b8f9134839c6L;
    String acid;
    String contentUrl;
    long deferredViewStart;
    boolean downloadAllOrNothing;
    int downloadPriority;
    Date expiration;
    private String id;

    CachedAd()
    {
        downloadAllOrNothing = false;
        deferredViewStart = System.currentTimeMillis();
    }

    protected CachedAd(Parcel parcel)
    {
        downloadAllOrNothing = false;
        try
        {
            id = parcel.readString();
            acid = parcel.readString();
            expiration = (Date)parcel.readSerializable();
            deferredViewStart = parcel.readLong();
            boolean aflag[] = new boolean[1];
            parcel.readBooleanArray(aflag);
            downloadAllOrNothing = aflag[0];
            contentUrl = parcel.readString();
            downloadPriority = parcel.readInt();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    static CachedAd parseJSON(String s)
    {
        if (MMSDK.logLevel < 5) goto _L2; else goto _L1
_L1:
        int i;
        MMSDK.Log.v("Received cached ad.");
        i = s.length();
        if (i <= 1000) goto _L4; else goto _L3
_L3:
        int j;
        int k;
        j = 999;
        k = 0;
_L7:
        int j1;
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        MMSDK.Log.v(s.substring(k, j));
        j1 = j + 1000;
        if (j1 <= i) goto _L6; else goto _L5
_L5:
        int i1 = i - 1;
_L8:
        MMSDK.Log.v(s.substring(j, i1));
_L2:
        if (s.length() > 0)
        {
            return new VideoAd(s);
        } else
        {
            return null;
        }
_L4:
        MMSDK.Log.v(s);
          goto _L2
_L6:
        int k1 = j;
        j = j1;
        k = k1;
          goto _L7
        int l = k;
        i1 = j;
        j = l;
          goto _L8
    }

    abstract boolean canShow(Context context, MMAdImpl mmadimpl, boolean flag);

    void delete(Context context)
    {
        int i;
        File file;
        i = 0;
        file = AdCache.getCacheDirectory(context);
        if (file == null || !file.isDirectory())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        File afile[];
        afile = file.listFiles(new _cls1());
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(afile.length);
        aobj[1] = id;
        MMSDK.Log.v("Deleting %d files for %s.", aobj);
_L1:
        if (i >= afile.length)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        afile[i].delete();
        i++;
          goto _L1
        Exception exception;
        exception;
        MMSDK.Log.v(exception);
    }

    protected void deserializeFromObj(JSONObject jsonobject)
    {
        String s;
        SimpleDateFormat simpledateformat;
        id = jsonobject.optString("id", null);
        acid = jsonobject.optString("vid", null);
        contentUrl = jsonobject.optString("content-url", null);
        s = jsonobject.optString("expiration", null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZZ");
        expiration = simpledateformat.parse(s);
        return;
        ParseException parseexception;
        parseexception;
        MMSDK.Log.e(parseexception);
        return;
    }

    abstract boolean download(Context context);

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof CachedAd))
        {
            return false;
        } else
        {
            CachedAd cachedad = (CachedAd)obj;
            return id.equals(cachedad.id);
        }
    }

    String getId()
    {
        return id;
    }

    abstract int getType();

    abstract String getTypeString();

    boolean isExpired()
    {
        return expiration != null && expiration.getTime() <= System.currentTimeMillis();
    }

    abstract boolean isOnDisk(Context context);

    boolean isValid()
    {
        return id != null && id.length() > 0 && contentUrl != null && contentUrl.length() > 0;
    }

    public void readExternal(ObjectInput objectinput)
    {
        id = (String)objectinput.readObject();
        acid = (String)objectinput.readObject();
        expiration = (Date)objectinput.readObject();
        deferredViewStart = objectinput.readLong();
        contentUrl = (String)objectinput.readObject();
    }

    abstract boolean saveAssets(Context context);

    void setId(String s)
    {
        id = s;
    }

    abstract void show(Context context, long l);

    public void writeExternal(ObjectOutput objectoutput)
    {
        objectoutput.writeObject(id);
        objectoutput.writeObject(acid);
        objectoutput.writeObject(expiration);
        objectoutput.writeLong(deferredViewStart);
        objectoutput.writeObject(contentUrl);
    }

    protected void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(acid);
        parcel.writeSerializable(expiration);
        parcel.writeLong(deferredViewStart);
        boolean aflag[] = new boolean[1];
        aflag[0] = downloadAllOrNothing;
        parcel.writeBooleanArray(aflag);
        parcel.writeString(contentUrl);
        parcel.writeInt(downloadPriority);
    }


    private class _cls1
        implements FileFilter
    {

        final CachedAd this$0;

        public boolean accept(File file)
        {
            return file.isFile() && file.getName().startsWith(id);
        }

        _cls1()
        {
            this$0 = CachedAd.this;
            super();
        }
    }

}
