// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            m

public final class NotifyTransactionStatusRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new m();
    String aiN;
    String ajO;
    int status;
    final int xJ;

    NotifyTransactionStatusRequest()
    {
        xJ = 1;
    }

    NotifyTransactionStatusRequest(int i, String s, int j, String s1)
    {
        xJ = i;
        aiN = s;
        status = j;
        ajO = s1;
    }

    public static Builder newBuilder()
    {
        NotifyTransactionStatusRequest notifytransactionstatusrequest = new NotifyTransactionStatusRequest();
        notifytransactionstatusrequest.getClass();
        return notifytransactionstatusrequest. new Builder(null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getDetailedReason()
    {
        return ajO;
    }

    public final String getGoogleTransactionId()
    {
        return aiN;
    }

    public final int getStatus()
    {
        return status;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        m.a(this, parcel, i);
    }


    private class Builder
    {

        final NotifyTransactionStatusRequest ajP;

        public final NotifyTransactionStatusRequest build()
        {
            boolean flag = true;
            boolean flag1;
            if (!TextUtils.isEmpty(ajP.aiN))
            {
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
            hn.b(flag1, "googleTransactionId is required");
            if (ajP.status <= 0 || ajP.status > 8)
            {
                flag = false;
            }
            hn.b(flag, "status is an unrecognized value");
            return ajP;
        }

        public final Builder setDetailedReason(String s)
        {
            ajP.ajO = s;
            return this;
        }

        public final Builder setGoogleTransactionId(String s)
        {
            ajP.aiN = s;
            return this;
        }

        public final Builder setStatus(int i)
        {
            ajP.status = i;
            return this;
        }

        private Builder()
        {
            ajP = NotifyTransactionStatusRequest.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
