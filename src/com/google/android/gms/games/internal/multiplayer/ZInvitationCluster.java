// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.internal.multiplayer:
//            InvitationClusterCreator

public final class ZInvitationCluster
    implements SafeParcelable, Invitation
{

    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
    private final ArrayList RE;
    private final int xJ;

    ZInvitationCluster(int i, ArrayList arraylist)
    {
        xJ = i;
        RE = arraylist;
        id();
    }

    private void id()
    {
        boolean flag;
        Invitation invitation;
        int i;
        if (!RE.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        gy.A(flag);
        invitation = (Invitation)RE.get(0);
        i = RE.size();
        for (int j = 1; j < i; j++)
        {
            Invitation invitation1 = (Invitation)RE.get(j);
            gy.a(invitation.getInviter().equals(invitation1.getInviter()), "All the invitations must be from the same inviter");
        }

    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof ZInvitationCluster))
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        ZInvitationCluster zinvitationcluster = (ZInvitationCluster)obj;
        if (zinvitationcluster.RE.size() != RE.size())
        {
            return false;
        }
        int i = RE.size();
        for (int j = 0; j < i; j++)
        {
            if (!((Invitation)RE.get(j)).equals((Invitation)zinvitationcluster.RE.get(j)))
            {
                return false;
            }
        }

        return true;
    }

    public final Invitation freeze()
    {
        return this;
    }

    public final volatile Object freeze()
    {
        return freeze();
    }

    public final int getAvailableAutoMatchSlots()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final long getCreationTimestamp()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final Game getGame()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final String getInvitationId()
    {
        return ((InvitationEntity)RE.get(0)).getInvitationId();
    }

    public final int getInvitationType()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final Participant getInviter()
    {
        return ((InvitationEntity)RE.get(0)).getInviter();
    }

    public final ArrayList getParticipants()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final int getVariant()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final int hashCode()
    {
        return hl.hashCode(RE.toArray());
    }

    public final ArrayList ie()
    {
        return new ArrayList(RE);
    }

    public final boolean isDataValid()
    {
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        InvitationClusterCreator.a(this, parcel, i);
    }

}
