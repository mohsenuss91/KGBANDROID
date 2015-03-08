// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

class VideoLogEvent
    implements Parcelable, Externalizable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    static final long serialVersionUID = 0xb0a600850e2f008L;
    String activities[];
    long position;

    public VideoLogEvent()
    {
    }

    VideoLogEvent(Parcel parcel)
    {
        try
        {
            position = parcel.readLong();
            activities = new String[parcel.readInt()];
            parcel.readStringArray(activities);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    VideoLogEvent(JSONObject jsonobject)
    {
        deserializeFromObj(jsonobject);
    }

    private void deserializeFromObj(JSONObject jsonobject)
    {
        int i = 0;
        if (jsonobject != null)
        {
            position = 1000 * jsonobject.optInt("time");
            JSONArray jsonarray = jsonobject.optJSONArray("urls");
            if (jsonarray != null)
            {
                activities = new String[jsonarray.length()];
                while (i < jsonarray.length()) 
                {
                    activities[i] = jsonarray.optString(i);
                    i++;
                }
            } else
            {
                activities = new String[0];
                return;
            }
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void readExternal(ObjectInput objectinput)
    {
        position = objectinput.readLong();
        int i = objectinput.readInt();
        activities = new String[i];
        for (int j = 0; j < i; j++)
        {
            activities[j] = (String)objectinput.readObject();
        }

    }

    public void writeExternal(ObjectOutput objectoutput)
    {
        objectoutput.writeLong(position);
        objectoutput.writeInt(activities.length);
        String as[] = activities;
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            objectoutput.writeObject(as[j]);
        }

    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(position);
        parcel.writeInt(activities.length);
        parcel.writeStringArray(activities);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final VideoLogEvent createFromParcel(Parcel parcel)
        {
            return new VideoLogEvent(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final VideoLogEvent[] newArray(int i)
        {
            return new VideoLogEvent[i];
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
