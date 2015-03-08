// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.google.android.gms.internal:
//            ey, ev, cg

public class fa extends WebChromeClient
{

    private final ey lL;

    public fa(ey ey1)
    {
        lL = ey1;
    }

    private static void a(android.app.AlertDialog.Builder builder, String s, JsResult jsresult)
    {
        builder.setMessage(s).setPositiveButton(0x104000a, new _cls3(jsresult)).setNegativeButton(0x1040000, new _cls2(jsresult)).setOnCancelListener(new _cls1(jsresult)).create().show();
    }

    private static void a(Context context, android.app.AlertDialog.Builder builder, String s, String s1, JsPromptResult jspromptresult)
    {
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setOrientation(1);
        TextView textview = new TextView(context);
        textview.setText(s);
        EditText edittext = new EditText(context);
        edittext.setText(s1);
        linearlayout.addView(textview);
        linearlayout.addView(edittext);
        builder.setView(linearlayout).setPositiveButton(0x104000a, new _cls6(jspromptresult, edittext)).setNegativeButton(0x1040000, new _cls5(jspromptresult)).setOnCancelListener(new _cls4(jspromptresult)).create().show();
    }

    protected final void a(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        cg cg1 = lL.bV();
        if (cg1 == null)
        {
            ev.D("Could not get ad overlay when showing custom view.");
            customviewcallback.onCustomViewHidden();
            return;
        } else
        {
            cg1.a(view, customviewcallback);
            cg1.setRequestedOrientation(i);
            return;
        }
    }

    protected boolean a(Context context, String s, String s1, String s2, JsResult jsresult, JsPromptResult jspromptresult, boolean flag)
    {
        android.app.AlertDialog.Builder builder;
        builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(s);
        if (flag)
        {
            try
            {
                a(context, builder, s1, s2, jspromptresult);
            }
            catch (android.view.WindowManager.BadTokenException badtokenexception)
            {
                ev.c("Fail to display Dialog.", badtokenexception);
            }
            break MISSING_BLOCK_LABEL_56;
        }
        a(builder, s1, jsresult);
        return true;
    }

    public final void onCloseWindow(WebView webview)
    {
        if (!(webview instanceof ey))
        {
            ev.D("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        cg cg1 = ((ey)webview).bV();
        if (cg1 == null)
        {
            ev.D("Tried to close an AdWebView not associated with an overlay.");
            return;
        } else
        {
            cg1.close();
            return;
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        String s = (new StringBuilder("JS: ")).append(consolemessage.message()).append(" (").append(consolemessage.sourceId()).append(":").append(consolemessage.lineNumber()).append(")").toString();
        _cls7.sP[consolemessage.messageLevel().ordinal()];
        JVM INSTR tableswitch 1 5: default 96
    //                   1 106
    //                   2 113
    //                   3 120
    //                   4 120
    //                   5 127;
           goto _L1 _L2 _L3 _L4 _L4 _L5
_L1:
        ev.B(s);
_L7:
        return super.onConsoleMessage(consolemessage);
_L2:
        ev.A(s);
        continue; /* Loop/switch isn't completed */
_L3:
        ev.D(s);
        continue; /* Loop/switch isn't completed */
_L4:
        ev.B(s);
        continue; /* Loop/switch isn't completed */
_L5:
        ev.z(s);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
    {
        android.webkit.WebView.WebViewTransport webviewtransport = (android.webkit.WebView.WebViewTransport)message.obj;
        WebView webview1 = new WebView(webview.getContext());
        webview1.setWebViewClient(lL.bW());
        webviewtransport.setWebView(webview1);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, android.webkit.WebStorage.QuotaUpdater quotaupdater)
    {
        long l3;
        l3 = 0x500000L - l2;
        if (l3 <= 0L)
        {
            quotaupdater.updateQuota(l);
            return;
        }
        if (l != 0L) goto _L2; else goto _L1
_L1:
        if (l1 > l3 || l1 > 0x100000L)
        {
            l1 = 0L;
        }
_L4:
        quotaupdater.updateQuota(l1);
        return;
_L2:
        if (l1 != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        l = Math.min(l + Math.min(0x20000L, l3), 0x100000L);
_L6:
        l1 = l;
        if (true) goto _L4; else goto _L3
_L3:
        if (l1 > Math.min(0x100000L - l, l3)) goto _L6; else goto _L5
_L5:
        l += l1;
          goto _L6
    }

    public final void onHideCustomView()
    {
        cg cg1 = lL.bV();
        if (cg1 == null)
        {
            ev.D("Could not get ad overlay when hiding custom view.");
            return;
        } else
        {
            cg1.aM();
            return;
        }
    }

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        if ((webview instanceof ey) && ((ey)webview).ca() != null)
        {
            return a(((ey)webview).ca(), s, s1, null, jsresult, null, false);
        } else
        {
            return a(webview.getContext(), s, s1, null, jsresult, null, false);
        }
    }

    public final boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        return a(webview.getContext(), s, s1, null, jsresult, null, false);
    }

    public final boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        return a(webview.getContext(), s, s1, null, jsresult, null, false);
    }

    public final boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        return a(webview.getContext(), s, s1, s2, null, jspromptresult, true);
    }

    public final void onReachedMaxAppCacheSize(long l, long l1, android.webkit.WebStorage.QuotaUpdater quotaupdater)
    {
        long l2 = 0x500000L - l1;
        long l3 = 0x20000L + l;
        if (l2 < l3)
        {
            quotaupdater.updateQuota(0L);
            return;
        } else
        {
            quotaupdater.updateQuota(l3);
            return;
        }
    }

    public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        a(view, -1, customviewcallback);
    }

    private class _cls3
        implements android.content.DialogInterface.OnClickListener
    {

        final JsResult sM;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            sM.confirm();
        }

        _cls3(JsResult jsresult)
        {
            sM = jsresult;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final JsResult sM;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            sM.cancel();
        }

        _cls2(JsResult jsresult)
        {
            sM = jsresult;
            super();
        }
    }


    private class _cls1
        implements android.content.DialogInterface.OnCancelListener
    {

        final JsResult sM;

        public final void onCancel(DialogInterface dialoginterface)
        {
            sM.cancel();
        }

        _cls1(JsResult jsresult)
        {
            sM = jsresult;
            super();
        }
    }


    private class _cls6
        implements android.content.DialogInterface.OnClickListener
    {

        final JsPromptResult sN;
        final EditText sO;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            sN.confirm(sO.getText().toString());
        }

        _cls6(JsPromptResult jspromptresult, EditText edittext)
        {
            sN = jspromptresult;
            sO = edittext;
            super();
        }
    }


    private class _cls5
        implements android.content.DialogInterface.OnClickListener
    {

        final JsPromptResult sN;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            sN.cancel();
        }

        _cls5(JsPromptResult jspromptresult)
        {
            sN = jspromptresult;
            super();
        }
    }


    private class _cls4
        implements android.content.DialogInterface.OnCancelListener
    {

        final JsPromptResult sN;

        public final void onCancel(DialogInterface dialoginterface)
        {
            sN.cancel();
        }

        _cls4(JsPromptResult jspromptresult)
        {
            sN = jspromptresult;
            super();
        }
    }


    private class _cls7
    {

        static final int sP[];

        static 
        {
            sP = new int[android.webkit.ConsoleMessage.MessageLevel.values().length];
            try
            {
                sP[android.webkit.ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                sP[android.webkit.ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                sP[android.webkit.ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                sP[android.webkit.ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                sP[android.webkit.ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4)
            {
                return;
            }
        }
    }

}
