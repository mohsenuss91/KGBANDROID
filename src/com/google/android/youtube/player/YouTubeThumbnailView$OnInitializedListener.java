// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


// Referenced classes of package com.google.android.youtube.player:
//            YouTubeThumbnailView, YouTubeInitializationResult, YouTubeThumbnailLoader

public interface 
{

    public abstract void onInitializationFailure(YouTubeThumbnailView youtubethumbnailview, YouTubeInitializationResult youtubeinitializationresult);

    public abstract void onInitializationSuccess(YouTubeThumbnailView youtubethumbnailview, YouTubeThumbnailLoader youtubethumbnailloader);
}
