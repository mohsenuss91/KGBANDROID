// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.millennialmedia.google.gson.Gson;

// Referenced classes of package com.millennialmedia.android:
//            HttpMMHeaders

class OverlaySettings
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    static final String PROPERTIES_ACCELEROMETER = "enableNativeAccelerometer";
    static final String PROPERTIES_ALLOW_ORIENTATION_CHANGE = "allowOrientationChange";
    static final String PROPERTIES_CUSTOM_CLOSE = "useCustomClose";
    static final String PROPERTIES_ENABLE_HARDWARE_ACCEL = "enableHardwareAccel";
    static final String PROPERTIES_FORCE_ORIENTATION = "forceOrientation";
    static final String PROPERTIES_HEIGHT = "height";
    static final String PROPERTIES_MODAL = "modal";
    static final String PROPERTIES_ORIENTATION = "orientation";
    static final String PROPERTIES_TRANSITION = "transition";
    static final String PROPERTIES_TRANSITION_DURATION = "transitionDuration";
    static final String PROPERTIES_TRANSPARENT = "transparent";
    static final String PROPERTIES_WIDTH = "width";
    String adUrl;
    boolean allowOrientationChange;
    boolean canAccelerate;
    String content;
    long creatorAdImplId;
    boolean hasLoadedExpandUrl;
    int height;
    boolean isFromInterstitial;
    private boolean isTransparent;
    HttpMMHeaders mmHeaders;
    boolean modal;
    String orientation;
    boolean shouldLaunchToOverlay;
    int shouldResizeOverlay;
    private String transition;
    private long transitionTimeInMillis;
    String urlToLoad;
    private boolean useCustomClose;
    int width;

    OverlaySettings()
    {
        transition = "";
        orientation = "";
        urlToLoad = "";
        allowOrientationChange = true;
        content = "";
        adUrl = "";
        hasLoadedExpandUrl = false;
    }

    OverlaySettings(Parcel parcel)
    {
        long l;
        l = 0L;
        super();
        transition = "";
        orientation = "";
        urlToLoad = "";
        allowOrientationChange = true;
        content = "";
        adUrl = "";
        hasLoadedExpandUrl = false;
        boolean aflag[] = new boolean[7];
        parcel.readBooleanArray(aflag);
        shouldLaunchToOverlay = aflag[0];
        isTransparent = aflag[1];
        canAccelerate = aflag[2];
        useCustomClose = aflag[3];
        modal = aflag[4];
        isFromInterstitial = aflag[5];
        allowOrientationChange = aflag[6];
        shouldResizeOverlay = parcel.readInt();
        transition = parcel.readString();
        transitionTimeInMillis = parcel.readLong();
        if (transitionTimeInMillis >= l)
        {
            try
            {
                l = transitionTimeInMillis;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return;
            }
        }
        transitionTimeInMillis = l;
        orientation = parcel.readString();
        creatorAdImplId = parcel.readLong();
        urlToLoad = parcel.readString();
        height = parcel.readInt();
        width = parcel.readInt();
        content = parcel.readString();
        adUrl = parcel.readString();
        mmHeaders = (HttpMMHeaders)parcel.readParcelable(com/millennialmedia/android/HttpMMHeaders.getClassLoader());
        return;
    }

    static final OverlaySettings createFromJson(String s)
    {
        return (OverlaySettings)(new Gson()).fromJson(s, com/millennialmedia/android/OverlaySettings);
    }

    public int describeContents()
    {
        return 0;
    }

    boolean enableHardwareAccel()
    {
        return mmHeaders != null && mmHeaders.enableHardwareAccel;
    }

    boolean getIsTransparent()
    {
        return isTransparent || mmHeaders != null && mmHeaders.isTransparent;
    }

    String getTransition()
    {
        if (!TextUtils.isEmpty(transition))
        {
            return transition;
        }
        if (mmHeaders != null && mmHeaders.transition != null && !TextUtils.isEmpty(mmHeaders.transition))
        {
            return mmHeaders.transition;
        } else
        {
            return "none";
        }
    }

    long getTransitionDurationInMillis()
    {
        long l = 0L;
        if (transitionTimeInMillis > l)
        {
            l = transitionTimeInMillis;
        } else
        if (mmHeaders != null)
        {
            return mmHeaders.transitionTimeInMillis;
        }
        return l;
    }

    boolean getUseCustomClose()
    {
        return useCustomClose || mmHeaders != null && mmHeaders.useCustomClose;
    }

    boolean hasExpandUrl()
    {
        return urlToLoad != null && !urlToLoad.equals("");
    }

    boolean hasLoadedExpandUrl()
    {
        boolean flag = true;
        if (!hasLoadedExpandUrl)
        {
            hasLoadedExpandUrl = flag;
            flag = false;
        }
        return flag;
    }

    boolean isExpanded()
    {
        return !isFromInterstitial && creatorAdImplId != 0L;
    }

    boolean isFromInterstitial()
    {
        return isFromInterstitial && creatorAdImplId != 0L;
    }

    void log()
    {
        MMSDK.Log.v(toString());
    }

    void setIsTransparent(boolean flag)
    {
        isTransparent = flag;
    }

    void setTransition(String s)
    {
        transition = s;
    }

    void setTransitionDurationInMillis(long l)
    {
        transitionTimeInMillis = l;
    }

    void setUseCustomClose(boolean flag)
    {
        useCustomClose = flag;
    }

    void setWebMMHeaders(HttpMMHeaders httpmmheaders)
    {
        mmHeaders = httpmmheaders;
    }

    public String toString()
    {
        Object aobj[] = new Object[12];
        aobj[0] = Integer.valueOf(height);
        aobj[1] = Integer.valueOf(width);
        aobj[2] = Boolean.valueOf(modal);
        aobj[3] = urlToLoad;
        aobj[4] = Long.valueOf(creatorAdImplId);
        aobj[5] = Integer.valueOf(shouldResizeOverlay);
        aobj[6] = Long.valueOf(transitionTimeInMillis);
        aobj[7] = transition;
        aobj[8] = Boolean.valueOf(canAccelerate);
        aobj[9] = Boolean.valueOf(isTransparent);
        aobj[10] = Boolean.valueOf(useCustomClose);
        aobj[11] = orientation;
        return String.format("height %d width %d modal %b urlToLoad %s creatorAdImplId %s shouldResizeOverlay: %d transitionTime: %d overlayTransition: %s shouldAccelerate: %b shouldMakeOverlayTransparent: %b shouldShowCustomClose: %b Orientation: %s", aobj);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean aflag[] = new boolean[7];
        aflag[0] = shouldLaunchToOverlay;
        aflag[1] = isTransparent;
        aflag[2] = canAccelerate;
        aflag[3] = useCustomClose;
        aflag[4] = modal;
        aflag[5] = isFromInterstitial;
        aflag[6] = allowOrientationChange;
        parcel.writeBooleanArray(aflag);
        parcel.writeInt(shouldResizeOverlay);
        parcel.writeString(transition);
        parcel.writeLong(transitionTimeInMillis);
        parcel.writeString(orientation);
        parcel.writeLong(creatorAdImplId);
        parcel.writeString(urlToLoad);
        parcel.writeInt(height);
        parcel.writeInt(width);
        parcel.writeString(content);
        parcel.writeString(adUrl);
        parcel.writeParcelable(mmHeaders, i);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final OverlaySettings createFromParcel(Parcel parcel)
        {
            return new OverlaySettings(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final OverlaySettings[] newArray(int i)
        {
            return new OverlaySettings[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
