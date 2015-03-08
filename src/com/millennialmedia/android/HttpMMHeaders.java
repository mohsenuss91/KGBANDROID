// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;
import org.apache.http.Header;

class HttpMMHeaders
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private static final String HEADER_MM_CUSTOM_CLOSE = "X-MM-USE-CUSTOM-CLOSE";
    private static final String HEADER_MM_ENABLE_HARDWARE_ACCEL = "X-MM-ENABLE-HARDWARE-ACCELERATION";
    private static final String HEADER_MM_TRANSITION = "X-MM-TRANSITION";
    private static final String HEADER_MM_TRANSITION_DURATION = "X-MM-TRANSITION-DURATION";
    private static final String HEADER_MM_TRANSPARENT = "X-MM-TRANSPARENT";
    static final long serialVersionUID = 0xb41d817d0ea16L;
    boolean enableHardwareAccel;
    boolean isTransparent;
    String transition;
    long transitionTimeInMillis;
    boolean useCustomClose;

    public HttpMMHeaders(Parcel parcel)
    {
        try
        {
            boolean aflag[] = new boolean[3];
            parcel.readBooleanArray(aflag);
            isTransparent = aflag[0];
            useCustomClose = aflag[1];
            enableHardwareAccel = aflag[2];
            transition = parcel.readString();
            transitionTimeInMillis = parcel.readLong();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public HttpMMHeaders(Header aheader[])
    {
        int i = aheader.length;
        for (int j = 0; j < i; j++)
        {
            Header header = aheader[j];
            checkTransparent(header);
            checkTransition(header);
            checkTransitionDuration(header);
            checkUseCustomClose(header);
            checkEnableHardwareAccel(header);
        }

    }

    private void checkEnableHardwareAccel(Header header)
    {
        if ("X-MM-ENABLE-HARDWARE-ACCELERATION".equalsIgnoreCase(header.getName()))
        {
            enableHardwareAccel = Boolean.parseBoolean(header.getValue());
        }
    }

    private void checkTransition(Header header)
    {
        if ("X-MM-TRANSITION".equalsIgnoreCase(header.getName()))
        {
            transition = header.getValue();
        }
    }

    private void checkTransitionDuration(Header header)
    {
        if ("X-MM-TRANSITION-DURATION".equalsIgnoreCase(header.getName()))
        {
            String s = header.getValue();
            if (s != null)
            {
                transitionTimeInMillis = (long)(1000F * Float.parseFloat(s));
            }
        }
    }

    private void checkTransparent(Header header)
    {
        if ("X-MM-TRANSPARENT".equalsIgnoreCase(header.getName()))
        {
            String s = header.getValue();
            if (s != null)
            {
                isTransparent = Boolean.parseBoolean(s);
            }
        }
    }

    private void checkUseCustomClose(Header header)
    {
        if ("X-MM-USE-CUSTOM-CLOSE".equalsIgnoreCase(header.getName()))
        {
            useCustomClose = Boolean.parseBoolean(header.getValue());
        }
    }

    public int describeContents()
    {
        return 0;
    }

    void updateArgumentsWithSettings(Map map)
    {
        map.put("transparent", String.valueOf(isTransparent));
        map.put("transition", String.valueOf(transition));
        map.put("transitionDuration", String.valueOf(transitionTimeInMillis));
        map.put("useCustomClose", String.valueOf(useCustomClose));
        map.put("enableHardwareAccel", String.valueOf(enableHardwareAccel));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean aflag[] = new boolean[3];
        aflag[0] = isTransparent;
        aflag[1] = useCustomClose;
        aflag[2] = enableHardwareAccel;
        parcel.writeBooleanArray(aflag);
        parcel.writeString(transition);
        parcel.writeLong(transitionTimeInMillis);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final HttpMMHeaders createFromParcel(Parcel parcel)
        {
            return new HttpMMHeaders(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final HttpMMHeaders[] newArray(int i)
        {
            return new HttpMMHeaders[i];
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
