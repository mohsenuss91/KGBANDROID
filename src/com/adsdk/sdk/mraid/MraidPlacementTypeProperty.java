// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidProperty

class MraidPlacementTypeProperty extends MraidProperty
{

    private final MraidView.PlacementType mPlacementType;

    MraidPlacementTypeProperty(MraidView.PlacementType placementtype)
    {
        mPlacementType = placementtype;
    }

    public static MraidPlacementTypeProperty createWithType(MraidView.PlacementType placementtype)
    {
        return new MraidPlacementTypeProperty(placementtype);
    }

    public String toJsonPair()
    {
        return (new StringBuilder("placementType: '")).append(mPlacementType.toString().toLowerCase()).append("'").toString();
    }
}
