// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageButton;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

class VideoImage
    implements Parcelable, Externalizable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    static final long serialVersionUID = 0xb37c805a5f2be9dL;
    int anchor;
    int anchor2;
    long appearanceDelay;
    ImageButton button;
    long contentLength;
    String eventLoggingUrls[];
    long fadeDuration;
    float fromAlpha;
    String imageUrl;
    long inactivityTimeout;
    boolean isLeaveBehind;
    android.widget.RelativeLayout.LayoutParams layoutParams;
    String linkUrl;
    String overlayOrientation;
    int paddingBottom;
    int paddingLeft;
    int paddingRight;
    int paddingTop;
    int position;
    int position2;
    float toAlpha;

    public VideoImage()
    {
        paddingTop = 0;
        paddingBottom = 0;
        paddingLeft = 0;
        paddingRight = 0;
        fromAlpha = 1.0F;
        toAlpha = 1.0F;
        fadeDuration = 1000L;
    }

    VideoImage(Parcel parcel)
    {
        boolean flag;
        flag = true;
        super();
        paddingTop = 0;
        paddingBottom = 0;
        paddingLeft = 0;
        paddingRight = 0;
        fromAlpha = 1.0F;
        toAlpha = 1.0F;
        fadeDuration = 1000L;
        imageUrl = parcel.readString();
        contentLength = parcel.readLong();
        eventLoggingUrls = new String[parcel.readInt()];
        parcel.readStringArray(eventLoggingUrls);
        linkUrl = parcel.readString();
        overlayOrientation = parcel.readString();
        paddingTop = parcel.readInt();
        paddingBottom = parcel.readInt();
        paddingLeft = parcel.readInt();
        paddingRight = parcel.readInt();
        position = parcel.readInt();
        anchor = parcel.readInt();
        position2 = parcel.readInt();
        anchor2 = parcel.readInt();
        appearanceDelay = parcel.readLong();
        inactivityTimeout = parcel.readLong();
        fromAlpha = parcel.readFloat();
        toAlpha = parcel.readFloat();
        fadeDuration = parcel.readLong();
        if (parcel.readInt() != flag)
        {
            flag = false;
        }
        isLeaveBehind = flag;
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        return;
    }

    VideoImage(JSONObject jsonobject)
    {
        paddingTop = 0;
        paddingBottom = 0;
        paddingLeft = 0;
        paddingRight = 0;
        fromAlpha = 1.0F;
        toAlpha = 1.0F;
        fadeDuration = 1000L;
        deserializeFromObj(jsonobject);
    }

    private void deserializeFromObj(JSONObject jsonobject)
    {
        int i = 0;
        if (jsonobject == null)
        {
            return;
        }
        imageUrl = jsonobject.optString("image", null);
        contentLength = jsonobject.optLong("contentLength");
        JSONArray jsonarray = jsonobject.optJSONArray("activity");
        if (jsonarray != null)
        {
            eventLoggingUrls = new String[jsonarray.length()];
            for (; i < jsonarray.length(); i++)
            {
                eventLoggingUrls[i] = jsonarray.optString(i);
            }

        } else
        {
            eventLoggingUrls = new String[0];
        }
        linkUrl = jsonobject.optString("url", null);
        overlayOrientation = jsonobject.optString("overlayOrientation", null);
        position = jsonobject.optInt("android-layout");
        anchor = jsonobject.optInt("android-layoutAnchor");
        position2 = jsonobject.optInt("android-layout2");
        anchor2 = jsonobject.optInt("android-layoutAnchor2");
        paddingTop = jsonobject.optInt("android-paddingTop");
        paddingLeft = jsonobject.optInt("android-paddingLeft");
        paddingRight = jsonobject.optInt("android-paddingRight");
        paddingBottom = jsonobject.optInt("android-paddingBottom");
        appearanceDelay = (long)(1000D * jsonobject.optDouble("appearanceDelay", 0.0D));
        inactivityTimeout = (long)(1000D * jsonobject.optDouble("inactivityTimeout", 0.0D));
        JSONObject jsonobject1 = jsonobject.optJSONObject("opacity");
        if (jsonobject1 != null)
        {
            fromAlpha = (float)jsonobject1.optDouble("start", 1.0D);
            toAlpha = (float)jsonobject1.optDouble("end", 1.0D);
            fadeDuration = (long)(1000D * jsonobject1.optDouble("fadeDuration", 1.0D));
        }
        isLeaveBehind = jsonobject.optBoolean("is_leavebehind");
    }

    public int describeContents()
    {
        return 0;
    }

    String getImageName()
    {
        if (imageUrl != null)
        {
            Uri uri = Uri.parse(imageUrl);
            if (uri != null && uri.getLastPathSegment() != null)
            {
                return uri.getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat");
            }
        }
        return null;
    }

    public void readExternal(ObjectInput objectinput)
    {
        imageUrl = (String)objectinput.readObject();
        contentLength = objectinput.readLong();
        int i = objectinput.readInt();
        eventLoggingUrls = new String[i];
        for (int j = 0; j < i; j++)
        {
            eventLoggingUrls[j] = (String)objectinput.readObject();
        }

        linkUrl = (String)objectinput.readObject();
        overlayOrientation = (String)objectinput.readObject();
        paddingTop = objectinput.readInt();
        paddingBottom = objectinput.readInt();
        paddingLeft = objectinput.readInt();
        paddingRight = objectinput.readInt();
        position = objectinput.readInt();
        anchor = objectinput.readInt();
        position2 = objectinput.readInt();
        anchor2 = objectinput.readInt();
        appearanceDelay = objectinput.readLong();
        inactivityTimeout = objectinput.readLong();
        fromAlpha = objectinput.readFloat();
        toAlpha = objectinput.readFloat();
        fadeDuration = objectinput.readLong();
        isLeaveBehind = objectinput.readBoolean();
    }

    public void writeExternal(ObjectOutput objectoutput)
    {
        objectoutput.writeObject(imageUrl);
        objectoutput.writeLong(contentLength);
        objectoutput.writeInt(eventLoggingUrls.length);
        String as[] = eventLoggingUrls;
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            objectoutput.writeObject(as[j]);
        }

        objectoutput.writeObject(linkUrl);
        objectoutput.writeObject(overlayOrientation);
        objectoutput.writeInt(paddingTop);
        objectoutput.writeInt(paddingBottom);
        objectoutput.writeInt(paddingLeft);
        objectoutput.writeInt(paddingRight);
        objectoutput.writeInt(position);
        objectoutput.writeInt(anchor);
        objectoutput.writeInt(position2);
        objectoutput.writeInt(anchor2);
        objectoutput.writeLong(appearanceDelay);
        objectoutput.writeLong(inactivityTimeout);
        objectoutput.writeFloat(fromAlpha);
        objectoutput.writeFloat(toAlpha);
        objectoutput.writeLong(fadeDuration);
        objectoutput.writeBoolean(isLeaveBehind);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(imageUrl);
        parcel.writeLong(contentLength);
        parcel.writeInt(eventLoggingUrls.length);
        parcel.writeStringArray(eventLoggingUrls);
        parcel.writeString(linkUrl);
        parcel.writeString(overlayOrientation);
        parcel.writeInt(paddingTop);
        parcel.writeInt(paddingBottom);
        parcel.writeInt(paddingLeft);
        parcel.writeInt(paddingRight);
        parcel.writeInt(position);
        parcel.writeInt(anchor);
        parcel.writeInt(position2);
        parcel.writeInt(anchor2);
        parcel.writeLong(appearanceDelay);
        parcel.writeLong(inactivityTimeout);
        parcel.writeFloat(fromAlpha);
        parcel.writeFloat(toAlpha);
        parcel.writeLong(fadeDuration);
        int j;
        if (isLeaveBehind)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final VideoImage createFromParcel(Parcel parcel)
        {
            return new VideoImage(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final VideoImage[] newArray(int i)
        {
            return new VideoImage[i];
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
