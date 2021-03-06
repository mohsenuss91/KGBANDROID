// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            ActivityRecognitionResultCreator, DetectedActivity

public class ActivityRecognitionResult
    implements SafeParcelable
{

    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
    List US;
    long UT;
    long UU;
    private final int xJ;

    public ActivityRecognitionResult(int i, List list, long l, long l1)
    {
        xJ = 1;
        US = list;
        UT = l;
        UU = l1;
    }

    public ActivityRecognitionResult(DetectedActivity detectedactivity, long l, long l1)
    {
        this(Collections.singletonList(detectedactivity), l, l1);
    }

    public ActivityRecognitionResult(List list, long l, long l1)
    {
        boolean flag;
        int i;
        boolean flag1;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hn.b(flag, "Must have at least 1 detected activity");
        i = l != 0L;
        flag1 = false;
        if (i > 0)
        {
            int j = l1 != 0L;
            flag1 = false;
            if (j > 0)
            {
                flag1 = true;
            }
        }
        hn.b(flag1, "Must set times");
        xJ = 1;
        US = list;
        UT = l;
        UU = l1;
    }

    public static ActivityRecognitionResult extractResult(Intent intent)
    {
        if (!hasResult(intent))
        {
            return null;
        } else
        {
            return (ActivityRecognitionResult)intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        }
    }

    public static boolean hasResult(Intent intent)
    {
        if (intent == null)
        {
            return false;
        } else
        {
            return intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public int getActivityConfidence(int i)
    {
        for (Iterator iterator = US.iterator(); iterator.hasNext();)
        {
            DetectedActivity detectedactivity = (DetectedActivity)iterator.next();
            if (detectedactivity.getType() == i)
            {
                return detectedactivity.getConfidence();
            }
        }

        return 0;
    }

    public long getElapsedRealtimeMillis()
    {
        return UU;
    }

    public DetectedActivity getMostProbableActivity()
    {
        return (DetectedActivity)US.get(0);
    }

    public List getProbableActivities()
    {
        return US;
    }

    public long getTime()
    {
        return UT;
    }

    public int getVersionCode()
    {
        return xJ;
    }

    public String toString()
    {
        return (new StringBuilder("ActivityRecognitionResult [probableActivities=")).append(US).append(", timeMillis=").append(UT).append(", elapsedRealtimeMillis=").append(UU).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ActivityRecognitionResultCreator.a(this, parcel, i);
    }

}
