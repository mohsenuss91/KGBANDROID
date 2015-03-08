// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.d.d;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.manager.ar;
import com.appyet.manager.bp;
import com.appyet.metadata.MetadataModuleFeed;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.appyet.c:
//            af, r

public final class ae extends ArrayAdapter
{

    final r a;
    private ApplicationContext b;
    private int c;
    private LayoutInflater d;
    private boolean e;
    private int f;

    public ae(r r1, Context context, List list, int i)
    {
        a = r1;
        super(context, 0x7f03003d, list);
        f = 0;
        b = (ApplicationContext)context.getApplicationContext();
        c = i;
        d = (LayoutInflater)b.getSystemService("layout_inflater");
        e = false;
        f = (int)TypedValue.applyDimension(1, 6F, context.getResources().getDisplayMetrics());
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        View view3 = d.inflate(c, null, false);
        View view2 = view3;
        af af2 = new af(a);
        if (c != 0x7f030042 && c != 0x7f030043) goto _L4; else goto _L3
_L3:
        af2.a = (TextView)view2.findViewById(0x7f0a008e);
        af2.b = (TextView)view2.findViewById(0x7f0a008b);
        af2.c = (TextView)view2.findViewById(0x7f0a008d);
        af2.d = (TextView)view2.findViewById(0x7f0a0095);
        af2.e = (TextView)view2.findViewById(0x7f0a0091);
        af2.f = (ImageView)view2.findViewById(0x7f0a0093);
        af2.g = (ImageView)view2.findViewById(0x7f0a0090);
        af2.l = (ImageView)view2.findViewById(0x7f0a0094);
        af2.h = (ProgressBar)view2.findViewById(0x7f0a0092);
        af2.i = (ImageView)view2.findViewById(0x7f0a008a);
        af2.j = (LinearLayout)view2.findViewById(0x7f0a008c);
        af2.k = (LinearLayout)view2.findViewById(0x7f0a008f);
        af2.m = (TextView)view2.findViewById(0x7f0a0097);
        af2.n = (ImageView)view2.findViewById(0x7f0a0096);
_L10:
        view2.setTag(af2);
_L11:
        FeedItem feeditem;
        Feed feed;
        MetadataModuleFeed metadatamodulefeed;
        feeditem = (FeedItem)getItem(i);
        feed = (Feed)b.n.c.get(feeditem.getFeed().getFeedId());
        metadatamodulefeed = (MetadataModuleFeed)b.n.d.get(feeditem.getFeed().getFeedId());
        if (c == 0x7f030042) goto _L6; else goto _L5
_L5:
        int l = c;
        if (l != 0x7f030043) goto _L7; else goto _L6
_L6:
        if (feeditem.getThumbnailMD5() != null) goto _L9; else goto _L8
_L8:
        af2.j.setPadding(0, 0, 0, 0);
        af2.i.setVisibility(8);
_L12:
        r.a(b, c, af2, feeditem, e, feed, metadatamodulefeed);
        return view2;
_L4:
        af2.o = (ImageView)view2.findViewById(0x7f0a008a);
        af2.p = (TextView)view2.findViewById(0x7f0a008b);
          goto _L10
        Exception exception2;
        exception2;
        Exception exception1;
        View view1;
        exception1 = exception2;
        view1 = view2;
_L14:
        com.appyet.d.d.a(exception1);
        return view1;
_L2:
        af af1 = (af)view.getTag();
        af2 = af1;
        view2 = view;
          goto _L11
_L9:
        int k;
        int j = b.d.D();
        Resources resources = b.getResources();
        k = (int)TypedValue.applyDimension(1, j, resources.getDisplayMetrics());
        if (!ar.b(b).getLanguage().equalsIgnoreCase("ar"))
        {
            break MISSING_BLOCK_LABEL_669;
        }
        af2.j.setPadding(k + f, 0, 0, 0);
_L13:
        af2.i.setVisibility(0);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)af2.i.getLayoutParams();
        layoutparams.width = k;
        layoutparams.height = k;
        af2.i.setLayoutParams(layoutparams);
        if (feeditem.getThumbnailMD5() != null)
        {
            r.l(a).a(feeditem.getThumbnail(), af2.i, r.k(a));
        }
          goto _L12
        Exception exception3;
        exception3;
        af2.i.setVisibility(8);
        af2.j.setPadding(0, 0, 0, 0);
        com.appyet.d.d.a(exception3);
          goto _L12
        af2.j.setPadding(0, 0, k + f, 0);
          goto _L13
_L7:
        r.l(a).a(feeditem.getThumbnail(), af2.o, r.m(a));
          goto _L12
        Exception exception;
        exception;
        exception1 = exception;
        view1 = view;
          goto _L14
    }
}
