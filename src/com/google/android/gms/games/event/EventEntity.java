// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.il;

// Referenced classes of package com.google.android.gms.games.event:
//            Event, EventEntityCreator

public final class EventEntity
    implements SafeParcelable, Event
{

    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String Mm;
    private final Uri Mo;
    private final String Mz;
    private final String Nf;
    private final PlayerEntity Ng;
    private final long Nh;
    private final String Ni;
    private final boolean Nj;
    private final String mName;
    private final int xJ;

    EventEntity(int i, String s, String s1, String s2, Uri uri, String s3, Player player, 
            long l, String s4, boolean flag)
    {
        xJ = i;
        Nf = s;
        mName = s1;
        Mm = s2;
        Mo = uri;
        Mz = s3;
        Ng = new PlayerEntity(player);
        Nh = l;
        Ni = s4;
        Nj = flag;
    }

    public EventEntity(Event event)
    {
        xJ = 1;
        Nf = event.getEventId();
        mName = event.getName();
        Mm = event.getDescription();
        Mo = event.getIconImageUri();
        Mz = event.getIconImageUrl();
        Ng = (PlayerEntity)event.getPlayer().freeze();
        Nh = event.getValue();
        Ni = event.getFormattedValue();
        Nj = event.isVisible();
    }

    static int a(Event event)
    {
        Object aobj[] = new Object[9];
        aobj[0] = event.getEventId();
        aobj[1] = event.getName();
        aobj[2] = event.getDescription();
        aobj[3] = event.getIconImageUri();
        aobj[4] = event.getIconImageUrl();
        aobj[5] = event.getPlayer();
        aobj[6] = Long.valueOf(event.getValue());
        aobj[7] = event.getFormattedValue();
        aobj[8] = Boolean.valueOf(event.isVisible());
        return hl.hashCode(aobj);
    }

    static boolean a(Event event, Object obj)
    {
        if (obj instanceof Event)
        {
            if (event == obj)
            {
                return true;
            }
            Event event1 = (Event)obj;
            if (hl.equal(event1.getEventId(), event.getEventId()) && hl.equal(event1.getName(), event.getName()) && hl.equal(event1.getDescription(), event.getDescription()) && hl.equal(event1.getIconImageUri(), event.getIconImageUri()) && hl.equal(event1.getIconImageUrl(), event.getIconImageUrl()) && hl.equal(event1.getPlayer(), event.getPlayer()) && hl.equal(Long.valueOf(event1.getValue()), Long.valueOf(event.getValue())) && hl.equal(event1.getFormattedValue(), event.getFormattedValue()) && hl.equal(Boolean.valueOf(event1.isVisible()), Boolean.valueOf(event.isVisible())))
            {
                return true;
            }
        }
        return false;
    }

    static String b(Event event)
    {
        return hl.e(event).a("Id", event.getEventId()).a("Name", event.getName()).a("Description", event.getDescription()).a("IconImageUri", event.getIconImageUri()).a("IconImageUrl", event.getIconImageUrl()).a("Player", event.getPlayer()).a("Value", Long.valueOf(event.getValue())).a("FormattedValue", event.getFormattedValue()).a("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final Event freeze()
    {
        return this;
    }

    public final volatile Object freeze()
    {
        return freeze();
    }

    public final String getDescription()
    {
        return Mm;
    }

    public final void getDescription(CharArrayBuffer chararraybuffer)
    {
        il.b(Mm, chararraybuffer);
    }

    public final String getEventId()
    {
        return Nf;
    }

    public final String getFormattedValue()
    {
        return Ni;
    }

    public final void getFormattedValue(CharArrayBuffer chararraybuffer)
    {
        il.b(Ni, chararraybuffer);
    }

    public final Uri getIconImageUri()
    {
        return Mo;
    }

    public final String getIconImageUrl()
    {
        return Mz;
    }

    public final String getName()
    {
        return mName;
    }

    public final void getName(CharArrayBuffer chararraybuffer)
    {
        il.b(mName, chararraybuffer);
    }

    public final Player getPlayer()
    {
        return Ng;
    }

    public final long getValue()
    {
        return Nh;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final boolean isDataValid()
    {
        return true;
    }

    public final boolean isVisible()
    {
        return Nj;
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        EventEntityCreator.a(this, parcel, i);
    }

}
