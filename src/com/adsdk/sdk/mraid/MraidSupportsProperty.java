// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidProperty

class MraidSupportsProperty extends MraidProperty
{

    private boolean calendar;
    private boolean inlineVideo;
    private boolean sms;
    private boolean storePicture;
    private boolean tel;

    MraidSupportsProperty()
    {
    }

    public String toJsonPair()
    {
        return (new StringBuilder("supports: {sms: ")).append(String.valueOf(sms)).append(", tel: ").append(String.valueOf(tel)).append(", calendar: ").append(String.valueOf(calendar)).append(", storePicture: ").append(String.valueOf(storePicture)).append(", inlineVideo: ").append(String.valueOf(inlineVideo)).append("}").toString();
    }

    public MraidSupportsProperty withCalendar(boolean flag)
    {
        calendar = flag;
        return this;
    }

    public MraidSupportsProperty withInlineVideo(boolean flag)
    {
        inlineVideo = flag;
        return this;
    }

    public MraidSupportsProperty withSms(boolean flag)
    {
        sms = flag;
        return this;
    }

    public MraidSupportsProperty withStorePicture(boolean flag)
    {
        storePicture = flag;
        return this;
    }

    public MraidSupportsProperty withTel(boolean flag)
    {
        tel = flag;
        return this;
    }
}
