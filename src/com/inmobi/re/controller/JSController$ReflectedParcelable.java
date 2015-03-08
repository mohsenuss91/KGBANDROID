// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable;
import com.inmobi.re.controller.util.NavigationStringEnum;
import com.inmobi.re.controller.util.TransitionStringEnum;
import java.lang.reflect.Field;

public class ing
    implements Parcelable
{

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Field afield[];
        int j;
        afield = getClass().getDeclaredFields();
        j = 0;
_L2:
        Field field;
        Class class1;
        if (j >= afield.length)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        field = afield[j];
        class1 = field.getType();
        if (!class1.isEnum())
        {
            break MISSING_BLOCK_LABEL_112;
        }
        String s = class1.toString();
        if (s.equals("class com.mraid.NavigationStringEnum"))
        {
            parcel.writeString(((NavigationStringEnum)field.get(this)).getText());
            break MISSING_BLOCK_LABEL_145;
        }
        Object obj;
        try
        {
            if (s.equals("class com.mraid.TransitionStringEnum"))
            {
                parcel.writeString(((TransitionStringEnum)field.get(this)).getText());
            }
            break MISSING_BLOCK_LABEL_145;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
            return;
        }
        return;
        obj = field.get(this);
        if (!(obj instanceof android.os.race))
        {
            parcel.writeValue(obj);
        }
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ()
    {
    }

    protected (Parcel parcel)
    {
        Field afield[];
        int i;
        afield = getClass().getDeclaredFields();
        i = 0;
_L2:
        Field field;
        Class class1;
        if (i >= afield.length)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        field = afield[i];
        class1 = field.getType();
        if (!class1.isEnum())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        String s = class1.toString();
        if (s.equals("class com.mraid.NavigationStringEnum"))
        {
            field.set(this, NavigationStringEnum.fromString(parcel.readString()));
            break MISSING_BLOCK_LABEL_141;
        }
        try
        {
            if (s.equals("class com.mraid.TransitionStringEnum"))
            {
                field.set(this, TransitionStringEnum.fromString(parcel.readString()));
            }
            break MISSING_BLOCK_LABEL_141;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
            return;
        }
        return;
        if (!(field.get(this) instanceof android.os.race))
        {
            field.set(this, parcel.readValue(null));
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
