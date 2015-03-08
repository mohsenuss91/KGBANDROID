// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.controller.JSUtilityController;
import com.inmobi.re.controller.util.StartActivityForResultCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.androidsdk:
//            a

public class IMBrowserActivity extends Activity
{

    public static final String ANIMATED = "isAnimationEnabledOnDimiss";
    public static final int BROWSER_ACTIVITY = 100;
    public static final String EXPANDDATA = "data";
    public static final int EXPAND_ACTIVITY = 102;
    public static final String EXTRA_BROWSER_ACTIVITY_TYPE = "extra_browser_type";
    public static final String EXTRA_URL = "extra_url";
    public static final int GET_IMAGE = 101;
    public static final int INTERSTITIAL_ACTIVITY = 101;
    private static IMWebView b;
    private static com.inmobi.re.container.IMWebView.IMWebViewListener c;
    private static IMWebView d;
    private static FrameLayout e;
    private static Message f;
    private static Map l = new HashMap();
    private static int m = 0;
    private static Activity o;
    private IMWebView a;
    private RelativeLayout g;
    private float h;
    private Boolean i;
    private CustomView j;
    private long k;
    private int n;
    private WebViewClient p;

    public IMBrowserActivity()
    {
        k = 0L;
        p = new a(this);
    }

    static IMWebView a()
    {
        return b;
    }

    static IMWebView a(IMBrowserActivity imbrowseractivity)
    {
        return imbrowseractivity.a;
    }

    private String a(String s)
    {
        int i1;
        String s1;
        i1 = 0;
        s1 = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        flag = "".equals(s);
        s1 = null;
        if (flag) goto _L2; else goto _L3
_L3:
        SimpleDateFormat asimpledateformat[];
        int j1;
        int k1;
        asimpledateformat = JSUtilityController.formats;
        j1 = asimpledateformat.length;
        k1 = 0;
_L5:
        SimpleDateFormat simpledateformat1;
        if (k1 >= j1)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        simpledateformat1 = asimpledateformat[k1];
        Date date1 = simpledateformat1.parse(s);
        Date date = date1;
_L7:
        SimpleDateFormat asimpledateformat1[];
        int l1;
        asimpledateformat1 = JSUtilityController.calendarUntiFormats;
        l1 = asimpledateformat1.length;
_L6:
        s1 = null;
        if (i1 >= l1) goto _L2; else goto _L4
_L4:
        SimpleDateFormat simpledateformat = asimpledateformat1[i1];
        String s2 = simpledateformat.format(Long.valueOf(date.getTime()));
        s1 = s2;
_L2:
        return s1;
        Exception exception1;
        exception1;
        k1++;
          goto _L5
        Exception exception;
        exception;
        i1++;
          goto _L6
        date = null;
          goto _L7
    }

    private String a(JSONArray jsonarray)
    {
        int i1;
        i1 = 0;
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        StringBuilder stringbuilder;
        if (jsonarray.length() == 0)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        stringbuilder = new StringBuilder();
_L1:
        if (i1 >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        Object obj = jsonarray.get(i1);
        stringbuilder.append((new StringBuilder()).append(obj).append(",").toString());
        i1++;
          goto _L1
        String s;
        int j1;
        s = stringbuilder.toString();
        j1 = s.length();
        if (j1 != 0) goto _L3; else goto _L2
_L2:
        s = null;
_L5:
        return s;
_L3:
        int k1 = j1 - 1;
        if (s.charAt(k1) != ',') goto _L5; else goto _L4
_L4:
        String s1 = s.substring(0, j1 - 1);
        return s1;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Couldn't parse json in create calendar event", exception1);
        return s;
        Exception exception;
        exception;
        exception.printStackTrace();
        Log.internal("[InMobi]-[RE]-4.4.1", "Exception parsing recurrence rule", exception);
        return null;
    }

    private String a(JSONArray jsonarray, int i1, int j1)
    {
        int k1 = 0;
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() == 0) goto _L2; else goto _L3
_L3:
        StringBuilder stringbuilder = new StringBuilder();
_L10:
        if (k1 >= jsonarray.length()) goto _L5; else goto _L4
_L4:
        int j2 = jsonarray.getInt(k1);
        if (j2 < i1 || j2 > j1)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        String s;
        int l1;
        int i2;
        Exception exception1;
        String s1;
        try
        {
            stringbuilder.append((new StringBuilder()).append(j2).append(",").toString());
            break MISSING_BLOCK_LABEL_171;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Log.internal("[InMobi]-[RE]-4.4.1", "Exception parsing recurrence rule", exception);
        }
          goto _L2
_L5:
        s = stringbuilder.toString();
        l1 = s.length();
        if (l1 != 0) goto _L7; else goto _L6
_L6:
        s = null;
_L9:
        return s;
_L7:
        i2 = l1 - 1;
        if (s.charAt(i2) != ',') goto _L9; else goto _L8
_L8:
        s1 = s.substring(0, l1 - 1);
        return s1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Couldn't parse json in create calendar event", exception1);
        return s;
_L2:
        return null;
        k1++;
          goto _L10
    }

    private void a(int i1, String s, String s1, String s2, int j1)
    {
        i1;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 110
    //                   2 117
    //                   3 124;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_124;
_L1:
        String s3 = null;
_L5:
        String s4;
        s4 = (new StringBuilder()).append(s).append(" ").append(s1).append(" ").append(s2).toString();
        Intent intent = new Intent();
        intent.setType("text/plain");
        intent.setPackage(s3);
        intent.putExtra("android.intent.extra.TEXT", s4);
        try
        {
            startActivityForResult(intent, j1);
            return;
        }
        catch (Exception exception) { }
        break MISSING_BLOCK_LABEL_133;
_L2:
        s3 = "";
          goto _L5
_L3:
        s3 = "com.google.android.apps.plus";
          goto _L5
        s3 = "com.twitter.android";
          goto _L5
        i1;
        JVM INSTR tableswitch 1 3: default 160
    //                   1 210
    //                   2 279
    //                   3 306;
           goto _L6 _L7 _L8 _L9
_L6:
        String s5 = null;
_L10:
        if (s5 != null)
        {
            Intent intent1 = new Intent("android.intent.action.VIEW");
            intent1.setData(Uri.parse(s5));
            try
            {
                startActivityForResult(intent1, j1);
                return;
            }
            catch (Exception exception1)
            {
                onActivityResult(j1, 0, null);
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L7:
        s5 = (new StringBuilder("https://www.facebook.com/dialog/feed?app_id=181821551957328&link=")).append(URLEncoder.encode(s1, "UTF-8")).append("&picture=").append(URLEncoder.encode(s2, "UTF-8")).append("&name=&description=").append(URLEncoder.encode(s, "UTF-8")).append("&redirect_uri=").append(URLEncoder.encode(s1, "UTF-8")).toString();
          goto _L10
_L8:
        s5 = (new StringBuilder("https://m.google.com/app/plus/x/?v=compose&content=")).append(URLEncoder.encode(s4, "UTF-8")).toString();
          goto _L10
_L9:
        String s6 = (new StringBuilder("http://twitter.com/home?status=")).append(URLEncoder.encode(s4, "UTF-8")).toString();
        s5 = s6;
          goto _L10
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.internal("[InMobi]-[RE]-4.4.1", "UTF-8 encoding not supported? What sorcery is this?", unsupportedencodingexception);
        if (true) goto _L6; else goto _L11
_L11:
        Intent intent2 = new Intent();
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.TEXT", s4);
        try
        {
            startActivityForResult(intent2, j1);
            return;
        }
        catch (Exception exception2)
        {
            onActivityResult(j1, 0, null);
        }
        return;
    }

    private void a(long l1, long l2, String s, String s1, String s2, 
            String s3, String s4, int i1)
    {
        Intent intent;
        intent = new Intent("android.intent.action.EDIT");
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", l1);
        intent.putExtra("allDay", false);
        intent.putExtra("endTime", l2);
        intent.putExtra("title", s1);
        intent.putExtra("eventLocation", s);
        intent.putExtra("description", s2);
        if (!s3.equals("transparent")) goto _L2; else goto _L1
_L1:
        intent.putExtra("availability", 1);
_L11:
        if ("".equals(s4) || android.os.Build.VERSION.SDK_INT <= 8) goto _L4; else goto _L3
_L3:
        StringBuilder stringbuilder = new StringBuilder();
        JSONObject jsonobject;
        String s5;
        jsonobject = new JSONObject(s4);
        s5 = jsonobject.optString("frequency");
        if (s5 == null) goto _L6; else goto _L5
_L5:
        if ("".equals(s5)) goto _L6; else goto _L7
_L7:
        String s6;
        if ("daily".equals(s5) || "weekly".equals(s5) || "monthly".equals(s5) || "yearly".equals(s5))
        {
            stringbuilder.append((new StringBuilder("freq=")).append(s5).append(";").toString());
        }
        s6 = jsonobject.optString("interval");
        if (s6 == null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        if (!"".equals(s6))
        {
            stringbuilder.append((new StringBuilder("interval=")).append(Integer.parseInt(s6)).append(";").toString());
        }
_L13:
        String s7 = a(jsonobject.optString("expires"));
        if (s7 == null) goto _L9; else goto _L8
_L8:
        stringbuilder.append((new StringBuilder("until=")).append(s7.replace("+", "Z+").replace("-", "Z-")).append(";").toString());
_L15:
        String s8 = a(jsonobject.optJSONArray("daysInWeek"));
        if (s8 == null)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        stringbuilder.append((new StringBuilder("byday=")).append(s8).append(";").toString());
        String s9 = a(jsonobject.optJSONArray("daysInMonth"), -30, 31);
        if (s9 == null)
        {
            break MISSING_BLOCK_LABEL_469;
        }
        stringbuilder.append((new StringBuilder("bymonthday=")).append(s9).append(";").toString());
        String s10 = a(jsonobject.optJSONArray("daysInYear"), -364, 365);
        if (s10 == null)
        {
            break MISSING_BLOCK_LABEL_524;
        }
        stringbuilder.append((new StringBuilder("byyearday=")).append(s10).append(";").toString());
        String s11 = a(jsonobject.optJSONArray("weeksInMonth"), -3, 4);
        if (s11 == null)
        {
            break MISSING_BLOCK_LABEL_576;
        }
        stringbuilder.append((new StringBuilder("byweekno=")).append(s11).append(";").toString());
        String s12 = a(jsonobject.optJSONArray("monthsInYear"), 1, 12);
        if (s12 == null)
        {
            break MISSING_BLOCK_LABEL_628;
        }
        stringbuilder.append((new StringBuilder("bymonth=")).append(s12).append(";").toString());
        Log.internal("[InMobi]-[RE]-4.4.1", (new StringBuilder("Recurrence rule : ")).append(stringbuilder.toString()).toString());
_L12:
        if (!"".equals(stringbuilder.toString()))
        {
            intent.putExtra("rrule", stringbuilder.toString());
        }
_L4:
        startActivityForResult(intent, i1);
        return;
_L2:
        if (!s3.equals("opaque")) goto _L11; else goto _L10
_L10:
        Exception exception;
        intent.putExtra("availability", 0);
          goto _L11
_L6:
        try
        {
            if (a != null)
            {
                a.raiseError("Frequency is incorrect in recurrence rule", "createCalendarEvent");
            }
            startActivityForResult(intent, i1);
            return;
        }
        catch (Exception exception1)
        {
            try
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "Exception parsing recurrence rule", exception1);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                onActivityResult(i1, 0, null);
                return;
            }
        }
          goto _L12
        Exception exception2;
        exception2;
        if (a != null)
        {
            a.raiseError("Interval is incorrect in recurrence rule", "createCalendarEvent");
        }
        Log.internal("[InMobi]-[RE]-4.4.1", "Invalid interval in recurrence rule", exception2);
          goto _L13
_L9:
        if (a == null) goto _L15; else goto _L14
_L14:
        a.raiseError("Date format is incorrect in until", "createCalendarEvent");
          goto _L15
    }

    private void a(Intent intent)
    {
        String s;
        int i1;
        Intent intent2;
        s = intent.getStringExtra("action");
        i1 = intent.getIntExtra("id", 0);
        if (!s.equals("takeCameraPicture"))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        Uri uri = (Uri)intent.getExtras().get("URI");
        intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        intent2.putExtra("output", uri);
        startActivityForResult(intent2, i1);
_L1:
        return;
        Exception exception1;
        exception1;
        onActivityResult(i1, 0, null);
        return;
        if (s.equals("getGalleryImage"))
        {
            Intent intent1 = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            try
            {
                startActivityForResult(intent1, i1);
                return;
            }
            catch (Exception exception)
            {
                onActivityResult(i1, 0, null);
            }
            return;
        }
        if (s.equals("postToSocial"))
        {
            a(intent.getIntExtra("socialType", 0), intent.getStringExtra("text"), intent.getStringExtra("link"), intent.getStringExtra("image"), i1);
            return;
        }
        if (s.equals("createCalendarEvent"))
        {
            a(intent.getLongExtra("start", 0L), intent.getLongExtra("end", 0L), intent.getStringExtra("location"), intent.getStringExtra("description"), intent.getStringExtra("summary"), intent.getStringExtra("transparency"), intent.getStringExtra("recurrence"), i1);
            return;
        }
          goto _L1
    }

    private void a(ViewGroup viewgroup)
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(0);
        linearlayout.setId(100);
        linearlayout.setWeightSum(100F);
        linearlayout.setOnTouchListener(new b());
        linearlayout.setBackgroundResource(0x108009a);
        linearlayout.setBackgroundColor(0xff888888);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), (int)(44F * h));
        layoutparams.addRule(12);
        viewgroup.addView(linearlayout, layoutparams);
        android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        layoutparams1.weight = 25F;
        CustomView customview = new CustomView(this, h, com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_ICON);
        linearlayout.addView(customview, layoutparams1);
        customview.setOnTouchListener(new g());
        CustomView customview1 = new CustomView(this, h, com.inmobi.re.container.CustomView.SwitchIconType.REFRESH);
        linearlayout.addView(customview1, layoutparams1);
        customview1.setOnTouchListener(new h());
        CustomView customview2 = new CustomView(this, h, com.inmobi.re.container.CustomView.SwitchIconType.BACK);
        linearlayout.addView(customview2, layoutparams1);
        customview2.setOnTouchListener(new e());
        j = new CustomView(this, h, com.inmobi.re.container.CustomView.SwitchIconType.FORWARD_INACTIVE);
        linearlayout.addView(j, layoutparams1);
        j.setOnTouchListener(new f());
    }

    static Activity b()
    {
        return o;
    }

    static CustomView b(IMBrowserActivity imbrowseractivity)
    {
        return imbrowseractivity.j;
    }

    static IMWebView c()
    {
        return d;
    }

    public static int generateId(StartActivityForResultCallback startactivityforresultcallback)
    {
        m = 1 + m;
        l.put(Integer.valueOf(m), startactivityforresultcallback);
        return m;
    }

    public static void requestOnAdDismiss(Message message)
    {
        f = message;
    }

    public static void setExpandedLayout(FrameLayout framelayout)
    {
        if (framelayout != null)
        {
            e = framelayout;
        }
    }

    public static void setExpandedWebview(IMWebView imwebview)
    {
        if (imwebview != null)
        {
            d = imwebview;
        }
    }

    public static void setOriginalActivity(Activity activity)
    {
        if (activity != null)
        {
            o = activity;
        }
    }

    public static void setWebViewListener(com.inmobi.re.container.IMWebView.IMWebViewListener imwebviewlistener)
    {
        c = imwebviewlistener;
    }

    public static void setWebview(IMWebView imwebview)
    {
        if (imwebview != null)
        {
            b = imwebview;
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        try
        {
            ((StartActivityForResultCallback)l.get(Integer.valueOf(i1))).onActivityResult(j1, intent);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "onActivityResult failed", exception);
        }
        l.remove(Integer.valueOf(j1));
        if (a == null)
        {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (configuration.orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
        } else
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
        }
        if (a != null)
        {
            a.onOrientationEventChange();
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Intent intent = getIntent();
        n = intent.getIntExtra("extra_browser_type", 100);
        k = intent.getLongExtra("isAnimationEnabledOnDimiss", 0L);
        if (n == 100)
        {
            requestWindowFeature(1);
            if (android.os.Build.VERSION.SDK_INT < 9 || android.os.Build.VERSION.SDK_INT >= 11)
            {
                getWindow().setFlags(1024, 1024);
            }
            WindowManager windowmanager = (WindowManager)getSystemService("window");
            DisplayMetrics displaymetrics = new DisplayMetrics();
            windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
            if (intent.getStringExtra("action") != null)
            {
                a(intent);
            }
            h = getResources().getDisplayMetrics().density;
            String s = intent.getStringExtra("extra_url");
            i = Boolean.valueOf(intent.getBooleanExtra("FIRST_INSTANCE", false));
            Log.debug("[InMobi]-[RE]-4.4.1", "IMBrowserActivity-> onCreate");
            CookieSyncManager.createInstance(this);
            CookieSyncManager.getInstance().startSync();
            g = new RelativeLayout(this);
            if (s != null)
            {
                boolean flag = intent.getBooleanExtra("QAMODE", false);
                a = new IMWebView(this, c, true, true);
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
                layoutparams.addRule(10);
                layoutparams.addRule(2, 100);
                g.setBackgroundColor(-1);
                g.addView(a, layoutparams);
                a(g);
                a.getSettings().setJavaScriptEnabled(true);
                a.setExternalWebViewClient(p);
                a.getSettings().setLoadWithOverviewMode(true);
                a.getSettings().setUseWideViewPort(true);
                if (android.os.Build.VERSION.SDK_INT >= 8)
                {
                    a.loadUrl(s, null);
                } else
                {
                    a.loadUrl(s);
                }
                if (flag)
                {
                    HashMap hashmap = new HashMap();
                    hashmap.put("mk-carrier", "117.97.87.6");
                    hashmap.put("x-real-ip", "117.97.87.6");
                }
                setContentView(g);
            }
        } else
        {
            if (n == 101)
            {
                b.setActivity(this);
                b.mInterstitialController.setActivity(this);
                b.mInterstitialController.changeContentAreaForInterstitials(k);
                View view1 = findViewById(225);
                if (view1 != null)
                {
                    view1.setOnClickListener(new i());
                }
                b.setOnKeyListener(new c());
                return;
            }
            if (n == 102)
            {
                if (e != null && e.getParent() != null)
                {
                    ((ViewGroup)e.getParent()).removeView(e);
                }
                setContentView(e);
                d.setState(com.inmobi.re.container.IMWebView.ViewState.EXPANDED);
                d.mIsViewable = true;
                d.mExpandController.setActivity(this);
                d.setBrowserActivity(this);
                d.mExpandController.handleOrientationForExpand();
                View view = findViewById(MRAIDExpandController.EXP_CLOSE_BUTTON);
                if (view != null)
                {
                    view.setOnClickListener(new d());
                }
                d.setOnKeyListener(new a());
                return;
            }
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        try
        {
            c = null;
            if (a != null)
            {
                a.mAudioVideoController.releaseAllPlayers();
            }
            if (f != null && i.booleanValue())
            {
                f.sendToTarget();
                f = null;
            }
            if (b != null)
            {
                b.mAudioVideoController.releaseAllPlayers();
                b = null;
            }
            if (e != null)
            {
                e = null;
            }
            if (d != null)
            {
                d = null;
            }
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Exception in onDestroy ", exception);
        }
    }

    protected void onPause()
    {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume()
    {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }


    private class b
        implements android.view.View.OnTouchListener
    {

        final IMBrowserActivity a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return true;
        }

        b()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }


    private class g
        implements android.view.View.OnTouchListener
    {

        final IMBrowserActivity a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 1)
            {
                view.setBackgroundColor(0xff888888);
                a.finish();
            } else
            if (motionevent.getAction() == 0)
            {
                view.setBackgroundColor(0xff00ffff);
                return true;
            }
            return true;
        }

        g()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }


    private class h
        implements android.view.View.OnTouchListener
    {

        final IMBrowserActivity a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 1)
            {
                view.setBackgroundColor(0xff888888);
                IMBrowserActivity.a(a).doHidePlayers();
                IMBrowserActivity.a(a).reload();
            } else
            if (motionevent.getAction() == 0)
            {
                view.setBackgroundColor(0xff00ffff);
                return true;
            }
            return true;
        }

        h()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }


    private class e
        implements android.view.View.OnTouchListener
    {

        final IMBrowserActivity a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
            view.setBackgroundColor(0xff888888);
            if (!IMBrowserActivity.a(a).canGoBack()) goto _L4; else goto _L3
_L3:
            IMBrowserActivity.a(a).goBack();
_L6:
            return true;
_L4:
            a.finish();
            return true;
_L2:
            if (motionevent.getAction() == 0)
            {
                view.setBackgroundColor(0xff00ffff);
                return true;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        e()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }


    private class f
        implements android.view.View.OnTouchListener
    {

        final IMBrowserActivity a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 1)
            {
                view.setBackgroundColor(0xff888888);
                if (IMBrowserActivity.a(a).canGoForward())
                {
                    IMBrowserActivity.a(a).goForward();
                }
            } else
            if (motionevent.getAction() == 0)
            {
                view.setBackgroundColor(0xff00ffff);
                return true;
            }
            return true;
        }

        f()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }


    private class i
        implements android.view.View.OnClickListener
    {

        final IMBrowserActivity a;

        public void onClick(View view)
        {
            if (IMBrowserActivity.a() != null && IMBrowserActivity.a().mInterstitialController != null)
            {
                IMBrowserActivity.a().mInterstitialController.handleInterstitialClose();
            }
            a.finish();
        }

        i()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }


    private class c
        implements android.view.View.OnKeyListener
    {

        final IMBrowserActivity a;

        public boolean onKey(View view, int i1, KeyEvent keyevent)
        {
            if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
            {
                a.finish();
                IMBrowserActivity.b().finish();
            }
            return false;
        }

        c()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }


    private class d
        implements android.view.View.OnClickListener
    {

        final IMBrowserActivity a;

        public void onClick(View view)
        {
            if (IMBrowserActivity.c() != null)
            {
                IMBrowserActivity.c().close();
            }
            a.finish();
        }

        d()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }


    private class a
        implements android.view.View.OnKeyListener
    {

        final IMBrowserActivity a;

        public boolean onKey(View view, int i1, KeyEvent keyevent)
        {
            if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
            {
                if (IMBrowserActivity.c() != null)
                {
                    IMBrowserActivity.c().close();
                }
                a.finish();
                IMBrowserActivity.b().finish();
            }
            return false;
        }

        a()
        {
            a = IMBrowserActivity.this;
            super();
        }
    }

}
