// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            DTOResizeParameters, MMAdView

class fsetY
{

    DTOResizeParameters resizeParams;
    final MMAdView this$0;
    int translationX;
    int translationY;

    private BoundsResult calculateBounds(int i, int j, int k, int l)
    {
        if (j + (i + k) <= l) goto _L2; else goto _L1
_L1:
        j += l - k;
        if (j >= 0) goto _L4; else goto _L3
_L3:
        j = 0;
        k = l;
_L6:
        class BoundsResult
        {

            int size;
            final MMAdView.BannerBounds this$1;
            int translation;

            private BoundsResult()
            {
                this$1 = MMAdView.BannerBounds.this;
                super();
            }

            BoundsResult(MMAdView._cls1 _pcls1)
            {
                this();
            }
        }

        BoundsResult boundsresult = new BoundsResult(null);
        boundsresult.translation = j - i;
        boundsresult.size = k;
        return boundsresult;
_L4:
        if (j + k > l)
        {
            j = l - k;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (j <= 0)
        {
            j = i;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void calculateXBounds()
    {
        int ai[] = new int[2];
        getLocationInWindow(ai);
        BoundsResult boundsresult = calculateBounds(ai[0], resizeParams.offsetX, resizeParams.width, resizeParams.xMax);
        resizeParams.width = boundsresult.size;
        translationX = boundsresult.translation;
    }

    private void calculateYBounds()
    {
        int ai[] = new int[2];
        getLocationInWindow(ai);
        BoundsResult boundsresult = calculateBounds(ai[1], resizeParams.offsetY, resizeParams.height, resizeParams.yMax);
        resizeParams.height = boundsresult.size;
        translationY = boundsresult.translation;
    }

    void calculateOnScreenBounds()
    {
        calculateXBounds();
        calculateYBounds();
    }

    android.view. modifyLayoutParams(android.view. )
    {
        .width = resizeParams.width;
        .height = resizeParams.height;
        return ;
    }

    BoundsResult(DTOResizeParameters dtoresizeparameters)
    {
        this$0 = MMAdView.this;
        super();
        resizeParams = dtoresizeparameters;
        translationX = dtoresizeparameters.offsetX;
        translationY = dtoresizeparameters.offsetY;
    }
}
