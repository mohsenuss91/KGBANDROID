// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            fv

class ult extends ult
{

    protected void a(fv fv1)
    {
        class _cls1 extends fx
        {

            final fz._cls1 ys;

            public void a(Status status, ParcelFileDescriptor parcelfiledescriptor)
            {
                yr.a(new fz.b(status, parcelfiledescriptor));
            }

            _cls1(com.google.android.gms.common.api.a.d d)
            {
                ys = fz._cls1.this;
                super(d);
            }
        }

        fv1.a(new _cls1(this));
    }

    public tus b(Status status)
    {
        return new <init>(status, null);
    }

    public Result c(Status status)
    {
        return b(status);
    }
}
