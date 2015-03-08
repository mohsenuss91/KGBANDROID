// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Externalizable;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd, VideoImage, VideoLogEvent, AdCache, 
//            HandShake, MMAdImpl, HttpGetRequest, DTOCachedVideo

class VideoAd extends CachedAd
    implements Parcelable, Externalizable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls3();
    static final String VIDEO_FILE_ID = "video.dat";
    static final long serialVersionUID = 0x252e2adaa757e358L;
    ArrayList activities;
    ArrayList buttons;
    String cacheComplete[];
    String cacheFailed[];
    String cacheMissURL;
    DTOCachedVideo cachedVideoDto;
    long closeDelayMillis;
    long contentLength;
    long duration;
    String endActivity[];
    String endOverlayURL;
    String onCompletionUrl;
    boolean reloadNonEndOverlayOnRestart;
    boolean showControls;
    boolean showCountdown;
    String startActivity[];
    boolean stayInPlayer;
    boolean usingInternalStorage;
    String videoError[];
    private String videoFileId;
    String webOverlayURL;

    public VideoAd()
    {
        buttons = new ArrayList();
        activities = new ArrayList();
    }

    VideoAd(Parcel parcel)
    {
        super(parcel);
        buttons = new ArrayList();
        activities = new ArrayList();
        try
        {
            startActivity = new String[parcel.readInt()];
            parcel.readStringArray(startActivity);
            endActivity = new String[parcel.readInt()];
            parcel.readStringArray(endActivity);
            boolean aflag[] = new boolean[5];
            parcel.readBooleanArray(aflag);
            showControls = aflag[0];
            stayInPlayer = aflag[1];
            showCountdown = aflag[2];
            reloadNonEndOverlayOnRestart = aflag[3];
            usingInternalStorage = aflag[4];
            onCompletionUrl = parcel.readString();
            webOverlayURL = parcel.readString();
            endOverlayURL = parcel.readString();
            cacheMissURL = parcel.readString();
            videoFileId = parcel.readString();
            duration = parcel.readLong();
            contentLength = parcel.readLong();
            closeDelayMillis = parcel.readLong();
            buttons = parcel.readArrayList(com/millennialmedia/android/VideoImage.getClassLoader());
            activities = parcel.readArrayList(com/millennialmedia/android/VideoLogEvent.getClassLoader());
            cacheComplete = new String[parcel.readInt()];
            parcel.readStringArray(cacheComplete);
            cacheFailed = new String[parcel.readInt()];
            parcel.readStringArray(cacheFailed);
            videoError = new String[parcel.readInt()];
            parcel.readStringArray(videoError);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    VideoAd(String s)
    {
        buttons = new ArrayList();
        activities = new ArrayList();
        if (s != null)
        {
            JSONObject jsonobject;
            try
            {
                jsonobject = new JSONObject(s);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                jsonobject = null;
            }
            if (jsonobject != null)
            {
                JSONObject jsonobject1 = jsonobject.optJSONObject("video");
                if (jsonobject1 != null)
                {
                    deserializeFromObj(jsonobject1);
                }
            }
        }
    }

    private void deleteVideoFile(Context context)
    {
        if (AdCache.deleteFile(context, (new StringBuilder()).append(videoFileId).append("video.dat").toString()))
        {
            Object aobj[] = new Object[1];
            aobj[0] = videoFileId;
            MMSDK.Log.v("VideoAd video file %s was deleted.", aobj);
        }
    }

    static boolean downloadVideoFile(Context context, String s, String s1)
    {
        File file = AdCache.getCacheDirectory(context);
        if (file == null || !file.isDirectory())
        {
            return false;
        } else
        {
            MMSDK.Log.v((new StringBuilder("Downloading (")).append(s1).append("video.dat) content to %s").toString(), new Object[] {
                file
            });
            boolean flag = AdCache.downloadComponent(s, (new StringBuilder()).append(s1).append("video.dat").toString(), file, context);
            String s2 = (new StringBuilder("Caching completed successfully (")).append(s1).append("video.dat)? %b").toString();
            Object aobj[] = new Object[1];
            aobj[0] = Boolean.valueOf(flag);
            MMSDK.Log.v(s2, aobj);
            return flag;
        }
    }

    static Uri getVideoUri(Context context, String s)
    {
        return Uri.fromFile(AdCache.getDownloadFile(context, (new StringBuilder()).append(s).append("video.dat").toString()));
    }

    private void handleSharedVideoFile(final Context context)
    {
        AdCache.iterateCachedAds(context, 2, new _cls1());
    }

    static boolean hasVideoFile(Context context, String s)
    {
        return AdCache.hasDownloadFile(context, (new StringBuilder()).append(s).append("video.dat").toString());
    }

    static void playAd(Context context, String s, HttpRedirection.RedirectionListenerImpl redirectionlistenerimpl)
    {
label0:
        {
            if (s != null)
            {
                VideoAd videoad = (VideoAd)AdCache.load(context, s);
                if (videoad == null || !videoad.canShow(context, null, false))
                {
                    break label0;
                }
                redirectionlistenerimpl.updateLastVideoViewedTime();
                MMSDK.Log.v("mmvideo: attempting to play video %s", new Object[] {
                    s
                });
                videoad.show(context, redirectionlistenerimpl.creatorAdImplInternalId);
                redirectionlistenerimpl.startingVideo();
            }
            return;
        }
        MMSDK.Log.v("mmvideo: Ad %s cannot be shown at this time.", new Object[] {
            s
        });
    }

    boolean canShow(Context context, MMAdImpl mmadimpl, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (isExpired() || !isOnDisk(context) || !HandShake.sharedHandShake(context).canDisplayCachedAd(mmadimpl.adType, deferredViewStart)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (isExpired() || !isOnDisk(context))
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    void delete(Context context)
    {
        super.delete(context);
        handleSharedVideoFile(context);
        AdCache.cachedVideoWasRemoved(context, acid);
        Object aobj[] = new Object[1];
        aobj[0] = getId();
        MMSDK.Log.v("Ad %s was deleted.", aobj);
    }

    public int describeContents()
    {
        return 0;
    }

    protected void deserializeFromObj(JSONObject jsonobject)
    {
        super.deserializeFromObj(jsonobject);
        JSONArray jsonarray = jsonobject.optJSONArray("startActivity");
        webOverlayURL = jsonobject.optString("overlayURL", null);
        endOverlayURL = jsonobject.optString("endURL", null);
        cacheMissURL = jsonobject.optString("cacheMissURL", null);
        videoFileId = jsonobject.optString("videoFileId", null);
        if (jsonarray != null)
        {
            startActivity = new String[jsonarray.length()];
            for (int k1 = 0; k1 < jsonarray.length(); k1++)
            {
                startActivity[k1] = jsonarray.optString(k1);
            }

        } else
        {
            startActivity = new String[0];
        }
        JSONArray jsonarray1 = jsonobject.optJSONArray("endActivity");
        if (jsonarray1 != null)
        {
            endActivity = new String[jsonarray1.length()];
            for (int j1 = 0; j1 < jsonarray1.length(); j1++)
            {
                endActivity[j1] = jsonarray1.optString(j1);
            }

        } else
        {
            endActivity = new String[0];
        }
        JSONArray jsonarray2 = jsonobject.optJSONArray("cacheComplete");
        if (jsonarray2 != null)
        {
            cacheComplete = new String[jsonarray2.length()];
            for (int i1 = 0; i1 < jsonarray2.length(); i1++)
            {
                cacheComplete[i1] = jsonarray2.optString(i1);
            }

        } else
        {
            cacheComplete = new String[0];
        }
        JSONArray jsonarray3 = jsonobject.optJSONArray("cacheFailed");
        if (jsonarray3 != null)
        {
            cacheFailed = new String[jsonarray3.length()];
            for (int l = 0; l < jsonarray3.length(); l++)
            {
                cacheFailed[l] = jsonarray3.optString(l);
            }

        } else
        {
            cacheFailed = new String[0];
        }
        JSONArray jsonarray4 = jsonobject.optJSONArray("videoError");
        if (jsonarray4 != null)
        {
            videoError = new String[jsonarray4.length()];
            for (int k = 0; k < jsonarray4.length(); k++)
            {
                videoError[k] = jsonarray4.optString(k);
            }

        } else
        {
            videoError = new String[0];
        }
        showControls = jsonobject.optBoolean("showVideoPlayerControls");
        showCountdown = jsonobject.optBoolean("showCountdownHUD");
        reloadNonEndOverlayOnRestart = jsonobject.optBoolean("reloadOverlayOnRestart");
        JSONObject jsonobject1 = jsonobject.optJSONObject("onCompletion");
        if (jsonobject1 != null)
        {
            onCompletionUrl = jsonobject1.optString("url", null);
            stayInPlayer = jsonobject1.optBoolean("stayInPlayer");
        }
        duration = (long)(1000D * jsonobject.optDouble("duration", 0.0D));
        contentLength = jsonobject.optLong("contentLength");
        closeDelayMillis = jsonobject.optLong("closeAfterDelay");
        JSONArray jsonarray5 = jsonobject.optJSONArray("buttons");
        if (jsonarray5 != null)
        {
            for (int j = 0; j < jsonarray5.length(); j++)
            {
                JSONObject jsonobject3 = jsonarray5.optJSONObject(j);
                if (jsonobject3 != null)
                {
                    VideoImage videoimage = new VideoImage(jsonobject3);
                    buttons.add(videoimage);
                }
            }

        }
        JSONArray jsonarray6 = jsonobject.optJSONArray("log");
        int i = 0;
        if (jsonarray6 != null)
        {
            for (; i < jsonarray6.length(); i++)
            {
                JSONObject jsonobject2 = jsonarray6.optJSONObject(i);
                if (jsonobject2 != null)
                {
                    VideoLogEvent videologevent = new VideoLogEvent(jsonobject2);
                    activities.add(videologevent);
                }
            }

        }
    }

    boolean download(Context context)
    {
        boolean flag;
label0:
        {
            File file = AdCache.getCacheDirectory(context);
            if (file == null || !file.isDirectory())
            {
                return false;
            }
            usingInternalStorage = AdCache.isInternalDir(context, file);
            MMSDK.Log.v("Downloading content to %s", new Object[] {
                file
            });
            flag = AdCache.downloadComponent(contentUrl, (new StringBuilder()).append(videoFileId).append("video.dat").toString(), file, context);
            if (!flag)
            {
                break label0;
            }
            int i = 0;
            boolean flag1;
            do
            {
                if (i >= buttons.size())
                {
                    break label0;
                }
                VideoImage videoimage = (VideoImage)buttons.get(i);
                flag1 = AdCache.downloadComponent(videoimage.imageUrl, (new StringBuilder()).append(getId()).append(videoimage.getImageName()).toString(), file, context);
                if (!flag1)
                {
                    break;
                }
                i++;
                flag = flag1;
            } while (true);
            flag = flag1;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        if (downloadAllOrNothing)
        {
            delete(context);
        }
        HttpGetRequest.log(cacheFailed);
_L4:
        Object aobj[] = new Object[1];
        aobj[0] = Boolean.valueOf(flag);
        MMSDK.Log.v("Caching completed successfully? %b", aobj);
        return flag;
_L2:
        if (flag)
        {
            if (acid != null && acid.length() > 0)
            {
                AdCache.cachedVideoWasAdded(context, acid);
            }
            HttpGetRequest.log(cacheComplete);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    int getType()
    {
        return 1;
    }

    String getTypeString()
    {
        return "Video";
    }

    Intent getVideoExtrasIntent(Context context, long l)
    {
        Intent intent = new Intent();
        intent.putExtra("videoId", getId());
        if (l != -4L)
        {
            intent.putExtra("internalId", l);
        }
        intent.setData(Uri.parse((new StringBuilder()).append(AdCache.getCacheDirectory(context).getAbsolutePath()).append(File.separator).append(videoFileId).append("video.dat").toString()));
        return intent;
    }

    boolean hasEndCard()
    {
        for (Iterator iterator = buttons.iterator(); iterator.hasNext();)
        {
            if (((VideoImage)iterator.next()).isLeaveBehind)
            {
                return true;
            }
        }

        return false;
    }

    boolean isOnDisk(Context context)
    {
label0:
        {
label1:
            {
                File file = AdCache.getCacheDirectory(context);
                if (file == null || !file.exists())
                {
                    break label0;
                }
                String as[] = file.list(new _cls2());
                boolean flag;
                Iterator iterator;
                VideoImage videoimage;
                if (as != null && as.length >= 1 + buttons.size())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label1;
                }
                if (!(new File(file, (new StringBuilder()).append(videoFileId).append("video.dat").toString())).exists())
                {
                    return false;
                }
                iterator = buttons.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                    videoimage = (VideoImage)iterator.next();
                } while ((new File(file, (new StringBuilder()).append(getId()).append(videoimage.getImageName()).toString())).exists());
                return false;
            }
            return flag;
        }
        return false;
    }

    void logBeginEvent()
    {
        if (startActivity != null)
        {
            MMSDK.Log.d("Cached video begin event logged");
            for (int i = 0; i < startActivity.length; i++)
            {
                MMSDK.Event.logEvent(startActivity[i]);
            }

        }
    }

    void logEndEvent()
    {
        if (endActivity != null)
        {
            MMSDK.Log.d("Cached video end event logged");
            for (int i = 0; i < endActivity.length; i++)
            {
                MMSDK.Event.logEvent(endActivity[i]);
            }

        }
    }

    public void readExternal(ObjectInput objectinput)
    {
        int i = 0;
        super.readExternal(objectinput);
        showControls = objectinput.readBoolean();
        onCompletionUrl = (String)objectinput.readObject();
        webOverlayURL = (String)objectinput.readObject();
        endOverlayURL = (String)objectinput.readObject();
        cacheMissURL = (String)objectinput.readObject();
        videoFileId = (String)objectinput.readObject();
        stayInPlayer = objectinput.readBoolean();
        showCountdown = objectinput.readBoolean();
        reloadNonEndOverlayOnRestart = objectinput.readBoolean();
        int j = objectinput.readInt();
        startActivity = new String[j];
        for (int k = 0; k < j; k++)
        {
            startActivity[k] = (String)objectinput.readObject();
        }

        int l = objectinput.readInt();
        endActivity = new String[l];
        for (int i1 = 0; i1 < l; i1++)
        {
            endActivity[i1] = (String)objectinput.readObject();
        }

        duration = objectinput.readLong();
        usingInternalStorage = objectinput.readBoolean();
        contentLength = objectinput.readLong();
        closeDelayMillis = objectinput.readLong();
        int j1 = objectinput.readInt();
        cacheComplete = new String[j1];
        for (int k1 = 0; k1 < j1; k1++)
        {
            cacheComplete[k1] = (String)objectinput.readObject();
        }

        int l1 = objectinput.readInt();
        cacheFailed = new String[l1];
        for (int i2 = 0; i2 < l1; i2++)
        {
            cacheFailed[i2] = (String)objectinput.readObject();
        }

        int j2 = objectinput.readInt();
        videoError = new String[j2];
        for (int k2 = 0; k2 < j2; k2++)
        {
            videoError[k2] = (String)objectinput.readObject();
        }

        buttons.clear();
        int l2 = objectinput.readInt();
        for (int i3 = 0; i3 < l2; i3++)
        {
            VideoImage videoimage = (VideoImage)objectinput.readObject();
            buttons.add(videoimage);
        }

        activities.clear();
        for (int j3 = objectinput.readInt(); i < j3; i++)
        {
            VideoLogEvent videologevent = (VideoLogEvent)objectinput.readObject();
            activities.add(videologevent);
        }

    }

    boolean saveAssets(Context context)
    {
        return true;
    }

    void setDtoCachedVideo(DTOCachedVideo dtocachedvideo)
    {
        cachedVideoDto = dtocachedvideo;
    }

    void show(Context context, long l)
    {
        Utils.IntentUtils.startCachedVideoPlayerActivity(context, getVideoExtrasIntent(context, l));
    }

    public void writeExternal(ObjectOutput objectoutput)
    {
        int i = 0;
        super.writeExternal(objectoutput);
        objectoutput.writeBoolean(showControls);
        objectoutput.writeObject(onCompletionUrl);
        objectoutput.writeObject(webOverlayURL);
        objectoutput.writeObject(endOverlayURL);
        objectoutput.writeObject(cacheMissURL);
        objectoutput.writeObject(videoFileId);
        objectoutput.writeBoolean(stayInPlayer);
        objectoutput.writeBoolean(showCountdown);
        objectoutput.writeBoolean(reloadNonEndOverlayOnRestart);
        objectoutput.writeInt(startActivity.length);
        String as[] = startActivity;
        int j = as.length;
        for (int k = 0; k < j; k++)
        {
            objectoutput.writeObject(as[k]);
        }

        objectoutput.writeInt(endActivity.length);
        String as1[] = endActivity;
        int l = as1.length;
        for (int i1 = 0; i1 < l; i1++)
        {
            objectoutput.writeObject(as1[i1]);
        }

        objectoutput.writeLong(duration);
        objectoutput.writeBoolean(usingInternalStorage);
        objectoutput.writeLong(contentLength);
        objectoutput.writeLong(closeDelayMillis);
        objectoutput.writeInt(cacheComplete.length);
        String as2[] = cacheComplete;
        int j1 = as2.length;
        for (int k1 = 0; k1 < j1; k1++)
        {
            objectoutput.writeObject(as2[k1]);
        }

        objectoutput.writeInt(cacheFailed.length);
        String as3[] = cacheFailed;
        int l1 = as3.length;
        for (int i2 = 0; i2 < l1; i2++)
        {
            objectoutput.writeObject(as3[i2]);
        }

        objectoutput.writeInt(videoError.length);
        String as4[] = videoError;
        for (int j2 = as4.length; i < j2; i++)
        {
            objectoutput.writeObject(as4[i]);
        }

        objectoutput.writeInt(buttons.size());
        for (Iterator iterator = buttons.iterator(); iterator.hasNext(); objectoutput.writeObject((VideoImage)iterator.next())) { }
        objectoutput.writeInt(activities.size());
        for (Iterator iterator1 = activities.iterator(); iterator1.hasNext(); objectoutput.writeObject((VideoLogEvent)iterator1.next())) { }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeInt(startActivity.length);
        parcel.writeStringArray(startActivity);
        parcel.writeInt(endActivity.length);
        parcel.writeStringArray(endActivity);
        boolean aflag[] = new boolean[5];
        aflag[0] = showControls;
        aflag[1] = stayInPlayer;
        aflag[2] = showCountdown;
        aflag[3] = reloadNonEndOverlayOnRestart;
        aflag[4] = usingInternalStorage;
        parcel.writeBooleanArray(aflag);
        parcel.writeString(onCompletionUrl);
        parcel.writeString(endOverlayURL);
        parcel.writeString(webOverlayURL);
        parcel.writeString(cacheMissURL);
        parcel.writeString(videoFileId);
        parcel.writeLong(duration);
        parcel.writeLong(contentLength);
        parcel.writeLong(closeDelayMillis);
        parcel.writeList(buttons);
        parcel.writeList(activities);
        parcel.writeInt(cacheComplete.length);
        parcel.writeStringArray(cacheComplete);
        parcel.writeInt(cacheFailed.length);
        parcel.writeStringArray(cacheFailed);
        parcel.writeInt(videoError.length);
        parcel.writeStringArray(videoError);
    }




    private class _cls1 extends AdCache.Iterator
    {

        boolean hasSharedVideoFile;
        final VideoAd this$0;
        final Context val$context;

        boolean callback(CachedAd cachedad)
        {
            if (cachedad != null && (cachedad instanceof VideoAd) && ((VideoAd)cachedad).videoFileId.equals(videoFileId))
            {
                hasSharedVideoFile = true;
            }
            return super.callback(cachedad);
        }

        void done()
        {
            if (!hasSharedVideoFile)
            {
                deleteVideoFile(context);
            }
            super.done();
        }

        _cls1()
        {
            this$0 = VideoAd.this;
            context = context1;
            super();
            hasSharedVideoFile = false;
        }
    }


    private class _cls2
        implements FilenameFilter
    {

        final VideoAd this$0;

        public boolean accept(File file, String s)
        {
            if (getId() == null)
            {
                return false;
            } else
            {
                return s.startsWith(getId());
            }
        }

        _cls2()
        {
            this$0 = VideoAd.this;
            super();
        }
    }


    private class _cls3
        implements android.os.Parcelable.Creator
    {

        public final VideoAd createFromParcel(Parcel parcel)
        {
            return new VideoAd(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final VideoAd[] newArray(int i)
        {
            return new VideoAd[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls3()
        {
        }
    }

}
