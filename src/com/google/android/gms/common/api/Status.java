// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;

// Referenced classes of package com.google.android.gms.common.api:
//            Result, StatusCreator, CommonStatusCodes

public final class Status
    implements Result, SafeParcelable
{

    public static final StatusCreator CREATOR = new StatusCreator();
    public static final Status Ek = new Status(0);
    public static final Status El = new Status(14);
    public static final Status Em = new Status(8);
    public static final Status En = new Status(15);
    public static final Status Eo = new Status(16);
    private final int CQ;
    private final String Ep;
    private final PendingIntent mPendingIntent;
    private final int xJ;

    public Status(int i)
    {
        this(1, i, null, null);
    }

    Status(int i, int j, String s, PendingIntent pendingintent)
    {
        xJ = i;
        CQ = j;
        Ep = s;
        mPendingIntent = pendingintent;
    }

    public Status(int i, String s, PendingIntent pendingintent)
    {
        this(1, i, s, pendingintent);
    }

    private String es()
    {
        if (Ep != null)
        {
            return Ep;
        } else
        {
            return CommonStatusCodes.getStatusCodeString(CQ);
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    final PendingIntent eL()
    {
        return mPendingIntent;
    }

    public final ConnectionResult eM()
    {
        return new ConnectionResult(CQ, mPendingIntent);
    }

    public final boolean equals(Object obj)
    {
        Status status;
        if (obj instanceof Status)
        {
            if (xJ == (status = (Status)obj).xJ && CQ == status.CQ && hl.equal(Ep, status.Ep) && hl.equal(mPendingIntent, status.mPendingIntent))
            {
                return true;
            }
        }
        return false;
    }

    public final PendingIntent getResolution()
    {
        return mPendingIntent;
    }

    public final Status getStatus()
    {
        return this;
    }

    public final int getStatusCode()
    {
        return CQ;
    }

    public final String getStatusMessage()
    {
        return Ep;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final boolean hasResolution()
    {
        return mPendingIntent != null;
    }

    public final int hashCode()
    {
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(xJ);
        aobj[1] = Integer.valueOf(CQ);
        aobj[2] = Ep;
        aobj[3] = mPendingIntent;
        return hl.hashCode(aobj);
    }

    public final boolean isCanceled()
    {
        return CQ == 16;
    }

    public final boolean isInterrupted()
    {
        return CQ == 14;
    }

    public final boolean isSuccess()
    {
        return CQ <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i)
    {
        if (!hasResolution())
        {
            return;
        } else
        {
            activity.startIntentSenderForResult(mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
            return;
        }
    }

    public final String toString()
    {
        return hl.e(this).a("statusCode", es()).a("resolution", mPendingIntent).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        StatusCreator.a(this, parcel, i);
    }

}
