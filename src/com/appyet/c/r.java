// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.a.a.b.f;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.widget.SearchView;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.c;
import com.appyet.d.a;
import com.appyet.d.d;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.data.Module;
import com.appyet.f.h;
import com.appyet.f.w;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.bp;
import com.appyet.manager.bq;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataModuleFeed;
import com.appyet.metadata.MetadataTheme;
import com.appyet.receiver.b;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.simonvt.menudrawer.MenuDrawer;
import uk.co.senab.a.a.a.e;
import uk.co.senab.a.b.i;

// Referenced classes of package com.appyet.c:
//            ae, ao, ak, af, 
//            am, ag, an, t, 
//            u, aq, ap, aj, 
//            ai, ad, y, ah, 
//            w, ac, x, ab, 
//            v, aa, s, al

public final class r extends SherlockFragment
    implements com.actionbarsherlock.widget.SearchView.OnCloseListener, com.actionbarsherlock.widget.SearchView.OnQueryTextListener, b, uk.co.senab.a.b.a.b
{

    protected ApplicationContext a;
    protected List b;
    protected Long c;
    protected com.actionbarsherlock.view.MenuItem d;
    protected boolean e;
    protected boolean f;
    private ae g;
    private int h;
    private TextView i;
    private com.appyet.receiver.c j;
    private ListView k;
    private GridView l;
    private an m;
    private ak n;
    private int o;
    private SearchView p;
    private f q;
    private com.a.a.b.d r;
    private com.a.a.b.d s;
    private al t;
    private e u;

    public r()
    {
        h = 0;
        b = null;
        c = null;
        d = null;
        o = 0;
        q = com.a.a.b.f.a();
        e = false;
        f = true;
        t = null;
    }

    static ae a(r r1)
    {
        return r1.g;
    }

    static al a(r r1, al al)
    {
        r1.t = al;
        return al;
    }

    static ao a(r r1, List list)
    {
        return r1.a(list);
    }

    private ao a(List list)
    {
        int i1 = 1;
        if (g != null && (k.getAdapter() != null || l.getAdapter() != null))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (a.n.a == null || a.n.a.getLayout() == null || !a.n.a.getLayout().equals("GRID")) goto _L2; else goto _L1
_L1:
        g = new ae(this, a, list, 0x7f030040);
_L3:
        ao ao1;
        ao1 = new ao(this);
        ao1.c = 2;
        return ao1;
_L2:
        Exception exception;
label0:
        {
            if (a.d.E() != c.b)
            {
                break label0;
            }
            g = new ae(this, a, list, 0x7f030043);
        }
          goto _L3
        try
        {
            g = new ae(this, a, list, 0x7f030042);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
          goto _L3
        ao ao2;
        ao2 = new ao(this);
        ao2.a = new ArrayList();
        ao2.b = new ArrayList();
        int j1 = 0;
_L5:
        if (j1 >= g.getCount())
        {
            break; /* Loop/switch isn't completed */
        }
        ((FeedItem)g.getItem(j1)).setFlag(com.appyet.data.FeedItem.FlagEnum.None);
        j1++;
        if (true) goto _L5; else goto _L4
_L4:
        Iterator iterator = list.iterator();
_L13:
        if (!iterator.hasNext()) goto _L7; else goto _L6
_L6:
        FeedItem feeditem1;
        int j2;
        feeditem1 = (FeedItem)iterator.next();
        j2 = g.getCount();
        int k2 = 0;
_L23:
        if (k2 >= j2) goto _L9; else goto _L8
_L8:
        FeedItem feeditem2 = (FeedItem)g.getItem(k2);
        if (!feeditem2.getFeedItemId().equals(feeditem1.getFeedItemId())) goto _L11; else goto _L10
_L10:
        feeditem2.setIsDeleted(feeditem1.getIsDeleted());
        feeditem2.setIsRead(feeditem1.getIsRead());
        feeditem2.setIsStar(feeditem1.getIsStar());
        feeditem2.setCommentsCount(feeditem1.getCommentsCount());
        feeditem2.setArticleStatus(feeditem1.getArticleStatus());
        feeditem2.setEnclosureStatus(feeditem1.getEnclosureStatus());
        feeditem2.setFlag(com.appyet.data.FeedItem.FlagEnum.Update);
        int l2 = i1;
_L22:
        if (l2 != 0) goto _L13; else goto _L12
_L12:
        if (a.n.a == null || a.n.a.getLayout() == null || !a.n.a.getLayout().equals("GRID")) goto _L15; else goto _L14
_L14:
        g = new ae(this, a, list, 0x7f030040);
_L16:
        ao ao3;
        ao3 = new ao(this);
        ao3.c = 2;
        return ao3;
_L15:
label1:
        {
            if (a.d.E() != c.b)
            {
                break label1;
            }
            g = new ae(this, a, list, 0x7f030043);
        }
          goto _L16
        g = new ae(this, a, list, 0x7f030042);
          goto _L16
_L24:
        int l1;
        if (l1 >= g.getCount()) goto _L18; else goto _L17
_L17:
        FeedItem feeditem = (FeedItem)g.getItem(l1);
        if (feeditem.getFlag() != com.appyet.data.FeedItem.FlagEnum.None) goto _L20; else goto _L19
_L19:
        ao2.b.add(feeditem);
        int i2 = i1;
          goto _L21
_L25:
        ao2.c = i1;
        return ao2;
_L26:
        i1 = 0;
        if (true)
        {
            break; /* Loop/switch isn't completed */
        }
_L20:
        int k1;
        i2 = k1;
          goto _L21
_L9:
        l2 = 0;
          goto _L22
_L11:
        k2++;
          goto _L23
_L7:
        k1 = 0;
        l1 = 0;
          goto _L24
_L21:
        l1++;
        k1 = i2;
          goto _L24
_L18:
        if (k1 == 0) goto _L26; else goto _L25
    }

    private FeedItem a(int i1)
    {
        if (a.n.a != null && a.n.a.getLayout() != null && a.n.a.getLayout().equals("GRID")) goto _L2; else goto _L1
_L1:
        if (k.getAdapter().getClass() != android/widget/HeaderViewListAdapter) goto _L4; else goto _L3
_L3:
        if (i1 - 1 >= 0) goto _L6; else goto _L5
_L5:
        return null;
_L6:
        return (FeedItem)g.getItem(i1 - 1);
_L4:
        if (i1 < 0) goto _L5; else goto _L2
_L2:
        return (FeedItem)g.getItem(i1);
    }

    static void a(r r1, int i1)
    {
        r1.n.a(i1, r1.c);
    }

    public static void a(ApplicationContext applicationcontext, int i1, af af1, FeedItem feeditem, boolean flag, Feed feed, MetadataModuleFeed metadatamodulefeed)
    {
        if (i1 != 0x7f030042 && i1 != 0x7f030043) goto _L2; else goto _L1
_L1:
        String s2;
        af1.b.setText(feeditem.getTitle());
        if (feed == null || feed.getTitle() == null || feed.getTitle().trim().length() == 0 || !flag || !metadatamodulefeed.IsShowPublisher)
        {
            af1.c.setVisibility(8);
        } else
        {
            af1.c.setVisibility(0);
            af1.c.setText(feed.getTitle());
        }
        af1.a.setText(feeditem.getSnippet());
        if (feeditem.getIsStar())
        {
            af1.f.setVisibility(0);
        } else
        {
            af1.f.setVisibility(8);
        }
        if (feeditem.getEnclosureLink() != null)
        {
            af1.g.setVisibility(0);
            af1.g.setImageResource(0x7f0200ff);
            if (feeditem.getEnclosureDuration() != null)
            {
                af1.h.setMax(feeditem.getEnclosureDuration().intValue());
            }
            float f1;
            StringBuilder stringbuilder;
            Object aobj[];
            if (feeditem.getEnclosureCurrentPosition() != null && feeditem.getEnclosureCurrentPosition().intValue() > 1000)
            {
                af1.h.setProgress(feeditem.getEnclosureCurrentPosition().intValue());
                af1.h.setVisibility(0);
            } else
            {
                af1.h.setVisibility(8);
            }
        } else
        {
            af1.g.setVisibility(8);
            af1.h.setVisibility(8);
        }
        af1.d.setText((new StringBuilder()).append(com.appyet.d.a.a(applicationcontext, feeditem.getPubDate())).append(" (").append(com.appyet.d.a.a(applicationcontext, feeditem.getPubDate())).append(")").toString());
        if (feeditem.getCommentsCount() != null)
        {
            af1.m.setVisibility(0);
            af1.n.setVisibility(0);
            if (!feeditem.getCommentsCount().equals("0"))
            {
                af1.m.setText(feeditem.getCommentsCount());
            } else
            {
                af1.m.setText("0");
            }
        } else
        {
            af1.m.setVisibility(8);
            af1.n.setVisibility(8);
        }
        if (feeditem.getEnclosureLink() == null) goto _L4; else goto _L3
_L3:
        af1.k.setVisibility(0);
        DecimalFormat decimalformat = new DecimalFormat("#.#");
        String s1;
        if (feeditem.getEnclosureLength() == null)
        {
            stringbuilder = new StringBuilder();
            aobj = new Object[1];
            aobj[0] = decimalformat.format(0L);
            s1 = stringbuilder.append(String.format("%s", aobj)).append(" ").append(applicationcontext.getString(0x7f08008b)).toString();
        } else
        {
            StringBuilder stringbuilder1 = new StringBuilder();
            Object aobj1[] = new Object[1];
            aobj1[0] = decimalformat.format((double)feeditem.getEnclosureLength().intValue() / 1048576D);
            s1 = stringbuilder1.append(String.format("%s", aobj1)).append(" ").append(applicationcontext.getString(0x7f08008b)).toString();
        }
        if (feeditem.getEnclosureType() == null) goto _L6; else goto _L5
_L5:
        if (!feeditem.getEnclosureType().toLowerCase().contains("audio")) goto _L8; else goto _L7
_L7:
        s2 = applicationcontext.getString(0x7f08005c);
_L11:
        af1.e.setText((new StringBuilder()).append(com.appyet.d.a.a(feeditem.getEnclosureDuration().intValue())).append(" ").append(s1).append(" ").append(s2).toString());
_L9:
        f1 = 1.0F;
        if (applicationcontext.getResources().getBoolean(0x7f0d000d))
        {
            f1 = 1.2F;
        }
        if (applicationcontext.d.E() == c.b)
        {
            af1.a.setVisibility(8);
        } else
        {
            af1.a.setVisibility(0);
        }
        if (feeditem.getArticleStatus() != com.appyet.data.FeedItem.ArticleStatusEnum.DownloadCompleted && feeditem.getArticleStatus() == com.appyet.data.FeedItem.ArticleStatusEnum.DownloadPending)
        {
            af1.l.setImageResource(0x7f020088);
            af1.l.setVisibility(0);
        } else
        {
            af1.l.setVisibility(8);
        }
        af1.b.setTextSize(2, 16F * f1);
        af1.c.setTextSize(2, 14F * f1);
        af1.a.setTextSize(2, 14F * f1);
        af1.d.setTextSize(2, 14F * f1);
        af1.e.setTextSize(2, f1 * 14F);
        applicationcontext.m.a(feeditem.getIsRead(), af1.b, af1.d, af1.a, af1.e, af1.c, null);
        applicationcontext.m.a(feeditem.getIsRead(), null, af1.m, null, null, null, null);
        return;
_L8:
        if (feeditem.getEnclosureType().toLowerCase().contains("video"))
        {
            s2 = applicationcontext.getString(0x7f08005d);
            continue; /* Loop/switch isn't completed */
        }
_L6:
        s2 = applicationcontext.getString(0x7f08005e);
        continue; /* Loop/switch isn't completed */
_L4:
        af1.k.setVisibility(8);
          goto _L9
_L2:
        af1.p.setText(feeditem.getTitle());
        applicationcontext.m.a(feeditem.getIsRead(), null, null, null, null, null, af1.p);
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private boolean a(Intent intent)
    {
        if (intent == null) goto _L2; else goto _L1
_L1:
        if (!intent.hasExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID")) goto _L2; else goto _L3
_L3:
        long l1 = intent.getLongExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID", -1L);
        if (l1 == -1L) goto _L2; else goto _L4
_L4:
        intent.removeExtra("ACTION_WIDGET_OPEN_FEEDITEM_ID");
        int i1 = 0;
_L5:
        if (i1 >= g.getCount())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((FeedItem)g.getItem(i1)).getFeedItemId().equals(Long.valueOf(l1)))
        {
            break MISSING_BLOCK_LABEL_97;
        }
        n.a(i1, c);
        return true;
        i1++;
        if (true) goto _L5; else goto _L2
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        a.e.a(exception);
_L2:
        return false;
    }

    static boolean a(r r1, Intent intent)
    {
        return r1.a(intent);
    }

    static FeedItem b(r r1, int i1)
    {
        return r1.a(i1);
    }

    static void b(r r1)
    {
        try
        {
            r1.h = -1 + r1.h;
            if (r1.h <= 0 && r1.getActivity().findViewById(0x7f0a0073) != null)
            {
                ProgressBar progressbar = (ProgressBar)r1.getActivity().findViewById(0x7f0a0073);
                Animation animation = AnimationUtils.loadAnimation(r1.getActivity(), 0x7f040011);
                animation.setAnimationListener(new am(r1, progressbar));
                progressbar.startAnimation(animation);
                r1.h = 0;
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static View c(r r1, int i1)
    {
        if (r1.a.n.a != null && r1.a.n.a.getLayout() != null && r1.a.n.a.getLayout().equals("GRID"))
        {
            if (i1 >= r1.l.getFirstVisiblePosition() && i1 <= r1.l.getLastVisiblePosition())
            {
                return r1.l.getChildAt(i1 - r1.l.getFirstVisiblePosition());
            }
        } else
        if (i1 >= r1.k.getFirstVisiblePosition() && i1 <= r1.k.getLastVisiblePosition())
        {
            return r1.k.getChildAt(i1 - r1.k.getFirstVisiblePosition());
        }
        return null;
    }

    static void c(r r1)
    {
        try
        {
            r1.h = 1 + r1.h;
            ((ProgressBar)r1.getActivity().findViewById(0x7f0a0073)).setVisibility(0);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static int d(r r1, int i1)
    {
        r1.o = i1;
        return i1;
    }

    static TextView d(r r1)
    {
        return r1.i;
    }

    static ListView e(r r1)
    {
        return r1.k;
    }

    static GridView f(r r1)
    {
        return r1.l;
    }

    private void f()
    {
        a.t.a(c.longValue());
    }

    private void g()
    {
        if (a.n.f == null || g == null || g.isEmpty()) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L10:
        if (i1 >= g.getCount()) goto _L2; else goto _L3
_L3:
        if (!((FeedItem)g.getItem(i1)).getFeedItemId().equals(a.n.f)) goto _L5; else goto _L4
_L4:
        if (a.n.a == null || a.n.a.getLayout() == null || !a.n.a.getLayout().equals("GRID")) goto _L7; else goto _L6
_L6:
        l.setSelection(i1);
_L2:
        com.appyet.context.f f1 = a.n;
_L8:
        f1.f = null;
        return;
_L7:
        k.setSelection(i1);
          goto _L2
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        f1 = a.n;
          goto _L8
_L5:
        i1++;
        if (true) goto _L10; else goto _L9
_L9:
        Exception exception;
        exception;
        a.n.f = null;
        throw exception;
    }

    static void g(r r1)
    {
        r1.i();
    }

    private void h()
    {
        try
        {
            if (a.n.b == null || a.n.b.size() == 0)
            {
                c();
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        if (g == null) goto _L2; else goto _L1
_L1:
        if (a.n.b.size() != o)
        {
            c();
            return;
        }
        if (a.n.b.size() != g.getCount())
        {
            c();
            return;
        }
          goto _L3
_L11:
        int i1;
        if (i1 >= a.n.b.size()) goto _L5; else goto _L4
_L4:
        if ((FeedItem)g.getItem(i1) != (FeedItem)a.n.b.get(i1))
        {
            c();
            return;
        }
          goto _L6
_L5:
        if (a.n.a == null || a.n.a.getLayout() == null || !a.n.a.getLayout().equals("GRID")) goto _L8; else goto _L7
_L7:
        if (l.getAdapter() == null)
        {
            l.setAdapter(g);
        }
_L9:
        g();
        g.notifyDataSetChanged();
        i.setVisibility(8);
        d();
        return;
_L8:
        if (k.getAdapter() == null)
        {
            k.setAdapter(g);
        }
        if (true) goto _L9; else goto _L2
_L2:
        return;
_L3:
        i1 = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        i1++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    static void h(r r1)
    {
        r1.g();
    }

    private void i()
    {
        if (a.n.a != null && a.n.a.getLayout() != null && a.n.a.getLayout().equals("GRID"))
        {
            l.setOnScrollListener(new ag(this, q, e, f));
            return;
        } else
        {
            k.setOnScrollListener(new ag(this, q, e, f));
            return;
        }
    }

    static void i(r r1)
    {
        if (r1.a.n.a.getIcon() == null) goto _L2; else goto _L1
_L1:
        InputStream inputstream = null;
        InputStream inputstream2 = r1.getResources().getAssets().open((new StringBuilder("module/")).append(r1.a.n.a.getIcon()).toString());
        InputStream inputstream1 = inputstream2;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream1);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        r1.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i1 = bitmap.getWidth();
        int j1 = bitmap.getHeight();
        float f1 = displaymetrics.scaledDensity;
        float f2 = displaymetrics.scaledDensity;
        Matrix matrix = new Matrix();
        matrix.postScale(f1, f2);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, i1, j1, matrix, true);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(r1.getResources(), bitmap1);
        r1.getSherlockActivity().getSupportActionBar().setIcon(bitmapdrawable);
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        inputstream1.close();
_L4:
        return;
        IOException ioexception1;
        ioexception1;
_L7:
        com.appyet.d.d.a(ioexception1);
        r1.getSherlockActivity().getSupportActionBar().setIcon(0x7f0200dc);
        if (inputstream == null) goto _L4; else goto _L3
_L3:
        ActionBar actionbar;
        try
        {
            inputstream.close();
            return;
        }
        catch (IOException ioexception2)
        {
            com.appyet.d.d.a(ioexception2);
        }
        actionbar = r1.getSherlockActivity().getSupportActionBar();
_L5:
        actionbar.setIcon(0x7f0200dc);
        return;
        Exception exception;
        exception;
        inputstream1 = null;
_L6:
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (IOException ioexception)
            {
                com.appyet.d.d.a(ioexception);
                r1.getSherlockActivity().getSupportActionBar().setIcon(0x7f0200dc);
            }
        }
        throw exception;
_L2:
        r1.getSherlockActivity().getSupportActionBar().setIcon(0x7f0200dc);
        return;
        IOException ioexception3;
        ioexception3;
        com.appyet.d.d.a(ioexception3);
        actionbar = r1.getSherlockActivity().getSupportActionBar();
          goto _L5
        exception;
          goto _L6
        exception;
        inputstream1 = inputstream;
          goto _L6
        ioexception1;
        inputstream = inputstream1;
          goto _L7
    }

    static an j(r r1)
    {
        r1.m = null;
        return null;
    }

    static com.a.a.b.d k(r r1)
    {
        return r1.r;
    }

    static f l(r r1)
    {
        return r1.q;
    }

    static com.a.a.b.d m(r r1)
    {
        return r1.s;
    }

    static al n(r r1)
    {
        return r1.t;
    }

    public final void a()
    {
        if (g != null)
        {
            g.notifyDataSetChanged();
        }
    }

    public final void b()
    {
        try
        {
            c();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void c()
    {
        try
        {
            if (m == null || m.d() == h.c)
            {
                m = new an(this);
                m.a(new Void[0]);
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void d()
    {
        int i1;
        String s1;
        i1 = 0x7f0a0041;
        s1 = "";
        if (g != null)
        {
            if (!a.n.j)
            {
                break MISSING_BLOCK_LABEL_208;
            }
            s1 = (new StringBuilder(" (")).append(g.getCount()).append(")").toString();
        }
_L1:
        int k1;
        if (a.n.a == null)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        getSherlockActivity().getSupportActionBar().setTitle((new StringBuilder()).append(w.a(a, a.n.a.getName())).append(s1).toString());
        k1 = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int j1;
        TextView textview;
        TextView textview1;
        if (k1 != 0)
        {
            i1 = k1;
        }
        textview1 = (TextView)getSherlockActivity().getWindow().findViewById(i1);
        textview1.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        textview1.setSelected(true);
        textview1.setMarqueeRepeatLimit(-1);
        if (a.m.a.ActionBarFgColor)
        {
            textview1.setTextColor(getResources().getColor(0x7f09004d));
            return;
        }
        break MISSING_BLOCK_LABEL_241;
        s1 = (new StringBuilder(" (")).append(g.getCount()).append("+)").toString();
          goto _L1
        try
        {
            textview1.setTextColor(getResources().getColor(0x7f09004f));
            return;
        }
        catch (Exception exception)
        {
            if (exception.getMessage() != null)
            {
                com.appyet.d.d.a(exception);
                return;
            }
        }
        break MISSING_BLOCK_LABEL_438;
        if (a.n.h == null)
        {
            break MISSING_BLOCK_LABEL_438;
        }
        getSherlockActivity().getSupportActionBar().setTitle((new StringBuilder()).append(a.n.h).append(s1).toString());
        j1 = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (j1 != 0)
        {
            i1 = j1;
        }
        textview = (TextView)getSherlockActivity().getWindow().findViewById(i1);
        textview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        textview.setSelected(true);
        textview.setMarqueeRepeatLimit(-1);
        if (a.m.a.ActionBarFgColor)
        {
            textview.setTextColor(getResources().getColor(0x7f09004d));
            return;
        }
        textview.setTextColor(getResources().getColor(0x7f09004f));
        return;
    }

    public final void e()
    {
        u.a();
        if (a.n.a != null && a.n.a.getType().equals("Feed"))
        {
            f();
            return;
        }
        if (a.c() == 0)
        {
            Toast.makeText(a, 0x7f080052, 1).show();
            a.t.a(true);
            return;
        } else
        {
            Toast.makeText(a, 0x7f080052, 1).show();
            return;
        }
    }

    public final void onActivityCreated(Bundle bundle)
    {
        Bundle bundle1;
        String s1;
        super.onActivityCreated(bundle);
        MainActivity mainactivity;
        try
        {
            View view = getView();
            i = (TextView)view.findViewById(0x7f0a0081);
            k = (ListView)view.findViewById(0x7f0a0082);
            l = (GridView)view.findViewById(0x7f0a0083);
            bundle1 = getArguments();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        if (bundle1 == null) goto _L2; else goto _L1
_L1:
        if (bundle1.containsKey("DisplayType")) goto _L3; else goto _L2
_L2:
        a.n.g = com.appyet.context.d.d;
_L6:
        if (a.n.a == null || a.n.a.getLayout() == null || !a.n.a.getLayout().equals("GRID")) goto _L5; else goto _L4
_L4:
        k.setVisibility(8);
        l.setVisibility(0);
_L10:
        if (!a.m.a.PrimaryBgColor.equals("DARK"))
        {
            break MISSING_BLOCK_LABEL_512;
        }
        i.setTextColor(getResources().getColor(0x7f09003f));
_L11:
        k.setCacheColorHint(0);
        l.setCacheColorHint(0);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        if (bundle.containsKey("STATE_PAUSE_ON_SCROLL"))
        {
            e = bundle.getBoolean("STATE_PAUSE_ON_SCROLL", false);
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        if (bundle.containsKey("STATE_PAUSE_ON_FLING"))
        {
            f = bundle.getBoolean("STATE_PAUSE_ON_FLING", true);
        }
        k.setOnItemClickListener(new t(this));
        l.setOnItemClickListener(new u(this));
        registerForContextMenu(k);
        registerForContextMenu(l);
        mainactivity = (MainActivity)getActivity();
        if (mainactivity.a() != null)
        {
            mainactivity.a().setTouchMode(2);
        }
        a.e.a("FeedArticleList");
        return;
_L3:
label0:
        {
            s1 = bundle1.getString("DisplayType");
            if (!s1.equals("Module"))
            {
                break label0;
            }
            c = Long.valueOf(bundle1.getLong("ModuleId"));
            a.n.g = com.appyet.context.d.a;
        }
          goto _L6
        if (!s1.equals("Search")) goto _L8; else goto _L7
_L7:
        a.n.g = com.appyet.context.d.b;
        a.n.h = bundle1.getString("SearchTerm");
          goto _L6
_L8:
        if (!s1.equals("FeedQuery")) goto _L6; else goto _L9
_L9:
        c = Long.valueOf(bundle1.getLong("ModuleId"));
        a.n.g = com.appyet.context.d.c;
          goto _L6
_L5:
        k.setVisibility(0);
        l.setVisibility(8);
          goto _L10
        i.setTextColor(getResources().getColor(0x7f09003e));
          goto _L11
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            n = (ak)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement OnHeadlineSelectedListener").toString());
        }
    }

    public final boolean onClose()
    {
        return false;
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(getActivity());
    }

    public final boolean onContextItemSelected(MenuItem menuitem)
    {
        android.widget.AdapterView.AdapterContextMenuInfo adaptercontextmenuinfo = (android.widget.AdapterView.AdapterContextMenuInfo)menuitem.getMenuInfo();
        int l1;
        if (menuitem.getItemId() != 0x7f0a00f7)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        l1 = adaptercontextmenuinfo.position;
        (new aq(this, l1)).a(new Void[0]);
_L2:
        return true;
        Exception exception4;
        exception4;
        try
        {
            com.appyet.d.d.a(exception4);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return super.onContextItemSelected(menuitem);
        }
        if (true) goto _L2; else goto _L1
_L1:
        int k1;
        if (menuitem.getItemId() != 0x7f0a00f8)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        k1 = adaptercontextmenuinfo.position;
        (new com.appyet.c.ap(this, k1)).a(new Void[0]);
_L3:
        return true;
        Exception exception3;
        exception3;
        com.appyet.d.d.a(exception3);
          goto _L3
        int j1;
        if (menuitem.getItemId() != 0x7f0a00f9)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        j1 = adaptercontextmenuinfo.position;
        (new aj(this, j1)).a(new Void[0]);
_L4:
        return true;
        Exception exception2;
        exception2;
        com.appyet.d.d.a(exception2);
          goto _L4
        int i1;
        if (menuitem.getItemId() != 0x7f0a00fa)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        i1 = adaptercontextmenuinfo.position;
        (new ai(this, i1)).a(new Void[0]);
_L5:
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
          goto _L5
        FeedItem feeditem;
        if (menuitem.getItemId() != 0x7f0a00fb)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        feeditem = a(adaptercontextmenuinfo.position);
        if (feeditem == null)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        if (!feeditem.getIsDeleted())
        {
            feeditem.setIsDeleted(true);
            (new ad(this, feeditem)).a(new Void[0]);
        }
        break MISSING_BLOCK_LABEL_285;
        boolean flag = super.onContextItemSelected(menuitem);
        return flag;
        return true;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = (ApplicationContext)getActivity().getApplicationContext();
        a.n.i = 0;
        a.n.j = false;
        if (a.n.b != null)
        {
            a.n.b.clear();
            a.n.b = null;
        }
        a.n.f = null;
        r = (new com.a.a.b.e()).a().a(0x7f0200e6).b(0x7f0200e8).c().e().a(android.graphics.Bitmap.Config.RGB_565).f();
        s = (new com.a.a.b.e()).a().a(0x7f0200e5).c().e().a(android.graphics.Bitmap.Config.RGB_565).f();
        setHasOptionsMenu(true);
        if (a.d.c())
        {
            Toast.makeText(getActivity(), 0x7f080077, 0).show();
        }
    }

    public final void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        try
        {
            android.widget.AdapterView.AdapterContextMenuInfo adaptercontextmenuinfo = (android.widget.AdapterView.AdapterContextMenuInfo)contextmenuinfo;
            FeedItem feeditem = (FeedItem)g.getItem(adaptercontextmenuinfo.position);
            if (feeditem.getTitle() != null)
            {
                contextmenu.setHeaderTitle(feeditem.getTitle());
            }
            getSherlockActivity().getMenuInflater().inflate(0x7f0f0002, contextmenu);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void onCreateOptionsMenu(Menu menu, com.actionbarsherlock.view.MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        menuinflater.inflate(0x7f0f0004, menu);
        SearchManager searchmanager;
        d = menu.findItem(0x7f0a0102);
        p = (SearchView)d.getActionView();
        p.setIconifiedByDefault(true);
        searchmanager = (SearchManager)a.getSystemService("search");
        if (searchmanager == null) goto _L2; else goto _L1
_L1:
        SearchableInfo searchableinfo;
        Iterator iterator;
        List list = searchmanager.getSearchablesInGlobalSearch();
        searchableinfo = searchmanager.getSearchableInfo(getActivity().getComponentName());
        iterator = list.iterator();
_L5:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        SearchableInfo searchableinfo1 = (SearchableInfo)iterator.next();
        Exception exception;
        if (searchableinfo1.getSuggestAuthority() == null || !searchableinfo1.getSuggestAuthority().startsWith("applications"))
        {
            searchableinfo1 = searchableinfo;
        }
        break MISSING_BLOCK_LABEL_227;
_L4:
        p.setSearchableInfo(searchableinfo);
_L2:
        p.setOnQueryTextListener(this);
        p.setOnCloseListener(this);
        if (a.m.a.ActionBarFgColor)
        {
            d.setIcon(0x7f0200bb);
            return;
        }
        try
        {
            d.setIcon(0x7f0200cc);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
        searchableinfo = searchableinfo1;
          goto _L5
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03003d, null);
    }

    public final void onDestroy()
    {
        super.onDestroy();
        try
        {
            if (k != null)
            {
                k.setAdapter(null);
            }
            if (l != null)
            {
                l.setAdapter(null);
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void onLowMemory()
    {
        ApplicationContext _tmp = a;
        ApplicationContext.d();
        super.onLowMemory();
    }

    public final boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131362038 2131362057: default 100
    //                   2131362038 741
    //                   2131362039 100
    //                   2131362040 100
    //                   2131362041 100
    //                   2131362042 100
    //                   2131362043 100
    //                   2131362044 100
    //                   2131362045 100
    //                   2131362046 100
    //                   2131362047 100
    //                   2131362048 100
    //                   2131362049 100
    //                   2131362050 730
    //                   2131362051 358
    //                   2131362052 376
    //                   2131362053 394
    //                   2131362054 506
    //                   2131362055 618
    //                   2131362056 106
    //                   2131362057 822;
           goto _L1 _L2 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        return super.onOptionsItemSelected(menuitem);
_L9:
        if (a.n.a != null && a.n.a.getLayout() != null && a.n.a.getLayout().equals("GRID"))
        {
            a.n.a.setLayout("LIST");
            a.h.a(c.longValue(), "LIST");
        } else
        {
            a.n.a.setLayout("GRID");
            a.h.a(c.longValue(), "GRID");
        }
        if (a.n.a != null && a.n.a.getLayout() != null && a.n.a.getLayout().equals("GRID"))
        {
            k.setVisibility(8);
            l.setVisibility(0);
        } else
        {
            k.setVisibility(0);
            l.setVisibility(8);
        }
        l.setAdapter(null);
        k.setAdapter(null);
        if (g != null)
        {
            g.clear();
            g = null;
        }
        c();
        continue; /* Loop/switch isn't completed */
_L4:
        a.d.a(false);
        c();
        continue; /* Loop/switch isn't completed */
_L5:
        a.d.a(true);
        c();
        continue; /* Loop/switch isn't completed */
_L6:
        y y1 = new y(this);
        Exception exception3;
        if (a.d.I())
        {
            (new android.app.AlertDialog.Builder(getActivity())).setMessage(0x7f080060).setIcon(0x7f0200b4).setTitle(0x7f08005f).setPositiveButton(getString(0x7f080061), y1).setNegativeButton(getString(0x7f080062), y1).show();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            (new ah(this)).a(new Void[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception3)
        {
            com.appyet.d.d.a(exception3);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        com.appyet.c.w w1 = new com.appyet.c.w(this);
        Exception exception2;
        if (a.d.I())
        {
            (new android.app.AlertDialog.Builder(getActivity())).setMessage(0x7f080060).setIcon(0x7f0200b4).setTitle(0x7f08005f).setPositiveButton(getString(0x7f080061), w1).setNegativeButton(getString(0x7f080062), w1).show();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            (new ac(this)).a(new Void[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2)
        {
            com.appyet.d.d.a(exception2);
        }
        continue; /* Loop/switch isn't completed */
_L8:
        x x1 = new x(this);
        Exception exception1;
        if (a.d.I())
        {
            (new android.app.AlertDialog.Builder(getActivity())).setMessage(0x7f080060).setIcon(0x7f0200b4).setTitle(0x7f08005f).setPositiveButton(getString(0x7f080061), x1).setNegativeButton(getString(0x7f080062), x1).show();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            (new ab(this)).a(new Void[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception1)
        {
            com.appyet.d.d.a(exception1);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        getActivity().onSearchRequested();
        continue; /* Loop/switch isn't completed */
_L2:
        try
        {
            CharSequence acharsequence[] = getResources().getTextArray(0x7f0e0002);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
            builder.setTitle(getString(0x7f08008c));
            builder.setSingleChoiceItems(acharsequence, a.d.e(), new v(this));
            builder.create().show();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        f();
        if (true) goto _L1; else goto _L11
_L11:
    }

    public final void onPause()
    {
        super.onPause();
        getActivity().unregisterReceiver(j);
        com.appyet.c.aa.a.clear();
        com.a.a.b.f.a().b();
        a.a = false;
        if (a.n.a != null && a.n.a.getLayout() != null && a.n.a.getLayout().equals("GRID"))
        {
            int j1 = l.getFirstVisiblePosition();
            if (l != null && j1 > 0 && a.n.b != null && a.n.b.size() > 0 && j1 < a.n.b.size())
            {
                a.n.f = ((FeedItem)a.n.b.get(j1)).getFeedItemId();
                return;
            } else
            {
                a.n.f = null;
                return;
            }
        }
        int i1 = k.getFirstVisiblePosition();
        if (k != null && i1 > 0 && a.n.b != null && a.n.b.size() > 0 && i1 < a.n.b.size())
        {
            a.n.f = ((FeedItem)a.n.b.get(i1)).getFeedItemId();
            return;
        } else
        {
            a.n.f = null;
            return;
        }
    }

    public final void onPrepareOptionsMenu(Menu menu)
    {
        boolean flag = true;
        com.actionbarsherlock.view.MenuItem menuitem = menu.findItem(0x7f0a0103);
        com.actionbarsherlock.view.MenuItem menuitem1 = menu.findItem(0x7f0a0104);
        menuitem.setEnabled(flag);
        menuitem1.setEnabled(flag);
        com.actionbarsherlock.view.MenuItem menuitem2;
        boolean flag1;
        com.actionbarsherlock.view.MenuItem menuitem3;
        if (a.d.c())
        {
            menuitem.setVisible(flag);
            menuitem1.setVisible(false);
        } else
        {
            menuitem.setVisible(false);
            menuitem1.setVisible(flag);
        }
        menuitem2 = menu.findItem(0x7f0a0108);
        if (c != null)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        menuitem2.setVisible(flag1);
        menuitem3 = menu.findItem(0x7f0a0109);
        if (a.n.a == null || !a.n.a.getType().equals("Feed"))
        {
            flag = false;
        }
        menuitem3.setVisible(flag);
        super.onPrepareOptionsMenu(menu);
    }

    public final boolean onQueryTextChange(String s1)
    {
        return false;
    }

    public final boolean onQueryTextSubmit(String s1)
    {
        FragmentTransaction fragmenttransaction = getActivity().getSupportFragmentManager().beginTransaction();
        r r1 = new r();
        Bundle bundle = new Bundle();
        bundle.putString("DisplayType", "Search");
        bundle.putString("SearchTerm", s1);
        r1.setArguments(bundle);
        r1.setRetainInstance(true);
        fragmenttransaction.setTransition(4097);
        fragmenttransaction.replace(0x7f0a00c2, r1, "ContentFrameFragment");
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commitAllowingStateLoss();
        d.collapseActionView();
        return true;
    }

    public final void onResume()
    {
        super.onResume();
        a.a = true;
        j = new com.appyet.receiver.c(this);
        IntentFilter intentfilter = new IntentFilter(a.x);
        getActivity().registerReceiver(j, intentfilter);
        ActionBar actionbar;
        if (a.n.b == null || a.d.X() > 0)
        {
            a.d.j(0);
            c();
        } else
        {
            h();
        }
        actionbar = getSherlockActivity().getSupportActionBar();
        if (getResources().getBoolean(0x7f0d000d))
        {
            actionbar.setDisplayHomeAsUpEnabled(false);
            actionbar.setHomeButtonEnabled(false);
        } else
        {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
        }
        i();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("STATE_PAUSE_ON_SCROLL", e);
        bundle.putBoolean("STATE_PAUSE_ON_FLING", f);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ViewGroup viewgroup = (ViewGroup)view;
        u = new e(viewgroup.getContext());
        uk.co.senab.a.b.b b1 = uk.co.senab.a.b.a.a(getActivity());
        b1.a = uk.co.senab.a.b.h.a().a;
        b1.c = viewgroup;
        uk.co.senab.a.b.b b2 = b1.a(new int[] {
            0x7f0a0082, 0x7f0a0083, 0x7f0a0081
        });
        b2.b = this;
        s s1 = new s(this);
        if (b2.d == null)
        {
            b2.d = new HashMap();
        }
        b2.d.put(android/widget/TextView, s1);
        b2.a(u);
    }
}
