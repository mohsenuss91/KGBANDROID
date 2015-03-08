// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.b.b;
import android.support.v4.b.d;

// Referenced classes of package android.support.v4.view:
//            be

public class c extends android.view.SavedState
{

    public static final android.os.r.SavedState.CREATOR CREATOR;
    int a;
    Parcelable b;
    ClassLoader c;

    public String toString()
    {
        return (new StringBuilder("FragmentPager.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(a).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.riteToParcel(parcel, i);
        parcel.writeInt(a);
        parcel.writeParcelable(b, i);
    }

    static 
    {
        be be1 = new be();
        if (android.os. >= 13)
        {
            new d(be1);
        }
        CREATOR = new b(be1);
    }

    (Parcel parcel, ClassLoader classloader)
    {
        super(parcel);
        if (classloader == null)
        {
            classloader = getClass().getClassLoader();
        }
        a = parcel.readInt();
        b = parcel.readParcelable(classloader);
        c = classloader;
    }

    public c(Parcelable parcelable)
    {
        super(parcelable);
    }
}
