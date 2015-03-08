// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.appyet.context.ApplicationContext;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.appyet.f.a;
import com.appyet.manager.al;
import com.appyet.manager.ar;
import com.appyet.manager.bp;
import com.appyet.manager.bw;
import com.appyet.manager.d;
import com.appyet.metadata.MetadataModuleFeed;
import com.appyet.metadata.MetadataTheme;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.appyet.c:
//            k

final class m extends a
{

    WebView a;
    String b;
    View c;
    final k d;

    public m(k k1, WebView webview, View view)
    {
        d = k1;
        super();
        a = webview;
        c = view;
    }

    private transient Void f()
    {
        if (k.b(d).getArticleStatus() != com.appyet.data.FeedItem.ArticleStatusEnum.DownloadCompleted) goto _L2; else goto _L1
_L1:
        String s;
        if (k.b(d).getArticle() == null)
        {
            k.c(d).h.a(k.b(d));
        }
        s = k.b(d).getArticle();
_L43:
        String s1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML Basic 1.1//EN\"\"http://www.w3.org/TR/xhtml-basic/xhtml-basic11.dtd\"><html><head><title></title>";
        String s2;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            s1 = (new StringBuilder()).append(s1).append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\" />").toString();
        }
        s2 = (new StringBuilder()).append(s1).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/fonts.css\"></link>").toString();
        if (!k.c(d).m.a.PrimaryBgColor.equals("DARK")) goto _L4; else goto _L3
_L3:
        String s3 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_dark.css\"></link>").toString();
_L30:
        k.c(d).d.K();
        JVM INSTR tableswitch 0 4: default 208
    //                   0 1755
    //                   1 1823
    //                   2 1891
    //                   3 1959
    //                   4 2027;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        if (com.appyet.c.k.d(d).IsTextRTL)
        {
            s3 = (new StringBuilder()).append(s3).append("<style>body {direction: rtl; text-align: right;unicode-bidi: bidi-override;}</style>").toString();
        }
          goto _L11
_L41:
        String s4;
        if (com.appyet.c.k.d(d).IsIncludeJQuery || s.contains("www.youtube.com/embed/") || s.contains("www.youtube.com/v/") || k.b(d).getEnclosureLink() != null && k.b(d).getThumbnailMD5() != null && k.c(d).j.g(k.b(d).getThumbnailMD5()))
        {
            s3 = (new StringBuilder()).append(s3).append("<script type=\"text/javascript\" src=\"file:///android_asset/html/jquery-1.8.3.min.js\"></script>").toString();
        }
        if (s.contains("www.youtube.com/embed/") || s.contains("www.youtube.com/v/"))
        {
            s3 = (new StringBuilder()).append(s3).append("<script type=\"text/javascript\" src=\"file:///android_asset/html/webview.js\"></script>").toString();
        }
        if (k.b(d).getEnclosureLink() != null && k.b(d).getThumbnailMD5() != null && k.c(d).j.g(k.b(d).getThumbnailMD5()))
        {
            s3 = (new StringBuilder()).append(s3).append("<script type=\"text/javascript\">$(document).ready(function() {$('img[src$=\"").append(k.b(d).getThumbnail()).append("\"]').css(\"display\", \"none\");});</script>").toString();
        }
        if (com.appyet.c.k.d(d).ExtraHTMLHeader != null && !com.appyet.c.k.d(d).ExtraHTMLHeader.trim().equals(""))
        {
            s3 = (new StringBuilder()).append(s3).append(com.appyet.c.k.d(d).ExtraHTMLHeader).toString();
        }
        s4 = (new StringBuilder()).append(s3).append("</head>").toString();
        String s5;
        String s6;
        String s7;
        DecimalFormat decimalformat;
        String s8;
        String s10;
        String s11;
        String s12;
        Matcher matcher;
        boolean flag;
        String s14;
        String s16;
        Matcher matcher1;
        boolean flag1;
        String s18;
        if (k.b(d).getIsRead())
        {
            s5 = "appyet_title appyet_title_read";
        } else
        {
            s5 = "appyet_title appyet_title_unread";
        }
        s6 = (new StringBuilder()).append(s4).append("<body><div class=\"appyet_frame\"><div class=\"").append(s5).append("\">").append(k.b(d).getTitle()).append("</div><p class=\"appyet_subtitle\">").toString();
        if (!ar.b(k.c(d)).getLanguage().equalsIgnoreCase("ar")) goto _L13; else goto _L12
_L12:
        s7 = (new StringBuilder()).append(s6).append("<span class=\"time\">").append(com.appyet.d.a.b(k.c(d), k.b(d).getPubDate())).append("</span>").toString();
        if (k.b(d).getAuthor() != null && k.b(d).getAuthor().length() > 0)
        {
            s7 = (new StringBuilder()).append(s7).append(" / <span class=\"author\">").append(k.b(d).getAuthor()).append("</span>").toString();
        }
        if (k.e(d) != null && k.e(d).getTitle() != null && k.e(d).getTitle().trim().length() > 0 && com.appyet.c.k.d(d).IsShowPublisher)
        {
            s7 = (new StringBuilder()).append(s7).append(" / <span class=\"publisher\">").append(k.e(d).getTitle()).append("</span>").toString();
        }
_L31:
        if (k.b(d).getEnclosureLink() == null) goto _L15; else goto _L14
_L14:
        decimalformat = new DecimalFormat("#.#");
        if (k.b(d).getEnclosureLength() != null) goto _L17; else goto _L16
_L16:
        StringBuilder stringbuilder = new StringBuilder();
        Object aobj[] = new Object[1];
        aobj[0] = decimalformat.format(0.0D);
        s8 = stringbuilder.append(String.format("%s", aobj)).append(" ").append(d.getString(0x7f08008b)).toString();
_L32:
        if (k.b(d).getEnclosureType() == null) goto _L19; else goto _L18
_L18:
        if (!k.b(d).getEnclosureType().toLowerCase().contains("audio")) goto _L21; else goto _L20
_L20:
        s10 = k.c(d).getString(0x7f08005c);
_L34:
        s7 = (new StringBuilder()).append(s7).append("<br>").append(s10).toString();
        if (k.b(d).getEnclosureLength().intValue() > 0)
        {
            s7 = (new StringBuilder()).append(s7).append(" ").append(s8).toString();
        }
        if (k.b(d).getEnclosureDuration().intValue() > 0)
        {
            s7 = (new StringBuilder()).append(s7).append(" ").append(com.appyet.d.a.a(k.b(d).getEnclosureDuration().intValue())).toString();
        }
_L15:
        s11 = (new StringBuilder()).append(s7).append("</p>").toString();
        if (k.b(d).getEnclosureLink() == null) goto _L23; else goto _L22
_L22:
        s12 = "file:///android_asset/html/podcast_background.png";
        if (k.b(d).getThumbnailMD5() != null && k.c(d).j.g(k.b(d).getThumbnailMD5()))
        {
            s12 = (new StringBuilder("file://")).append(k.c(d).j.b(k.b(d).getThumbnailMD5())).toString();
        }
        s11 = (new StringBuilder()).append(s11).append("<p><a href='appyet.podcast://none'><img class='appyet_podcastimg' src='file:///android_asset/html/video.png' style=\"background:url('").append(s12).append("')\"/></a></p>").toString();
_L23:
        if (!k.e(d).getLink().toLowerCase().contains("://gdata.youtube.com/feeds/base/") && !k.e(d).getLink().toLowerCase().contains("://www.youtube.com/rss/")) goto _L25; else goto _L24
_L24:
        String s13 = k.b(d).getLink();
        matcher = Pattern.compile("(?:videos\\/|v=)([\\w-]+)").matcher(s13);
        flag = matcher.find();
        if (!flag) goto _L27; else goto _L26
_L26:
        String s15 = matcher.group(1);
        s16 = (new StringBuilder()).append(s11).append("<p><a href='appyet.youtube:").append(s15).append("'><img class='appyet_youtubeimg' src='file:///android_asset/html/youtube_btn_play.png' style=\"background:url('http://i.ytimg.com/vi/").append(s15).append("/0.jpg')\"/></a></p>").toString();
        matcher1 = Pattern.compile(";\"><span>(.*?)</span>").matcher(s);
        flag1 = matcher1.find();
        if (!flag1) goto _L29; else goto _L28
_L28:
        String s17 = matcher1.group(1);
        s18 = (new StringBuilder()).append(s16).append("<p>").append(s17).append("</p>").toString();
        s14 = s18;
        break MISSING_BLOCK_LABEL_1510;
_L2:
        if (k.b(d).getDescription() == null)
        {
            k.c(d).h.a(k.b(d));
        }
        s = k.b(d).getDescription();
        continue; /* Loop/switch isn't completed */
_L4:
        s3 = (new StringBuilder()).append(s2).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_light.css\"></link>").toString();
          goto _L30
_L6:
label0:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label0;
            }
            s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_extra_small.css\"></link>").toString();
        }
          goto _L5
        s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_extra_small.css\"></link>").toString();
          goto _L5
_L7:
label1:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label1;
            }
            s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_small.css\"></link>").toString();
        }
          goto _L5
        s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_small.css\"></link>").toString();
          goto _L5
_L8:
label2:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label2;
            }
            s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_medium.css\"></link>").toString();
        }
          goto _L5
        s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_medium.css\"></link>").toString();
          goto _L5
_L9:
label3:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label3;
            }
            s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_large.css\"></link>").toString();
        }
          goto _L5
        s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_large.css\"></link>").toString();
          goto _L5
_L10:
label4:
        {
            if (!d.getResources().getBoolean(0x7f0d000d))
            {
                break label4;
            }
            s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_tablet_extra_large.css\"></link>").toString();
        }
          goto _L5
        s3 = (new StringBuilder()).append(s3).append("<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/html/article_extra_large.css\"></link>").toString();
          goto _L5
_L13:
        if (k.e(d) != null && k.e(d).getTitle() != null && k.e(d).getTitle().trim().length() > 0 && com.appyet.c.k.d(d).IsShowPublisher)
        {
            s6 = (new StringBuilder()).append(s6).append("<span class=\"publisher\">").append(k.e(d).getTitle()).append("</span> / ").toString();
        }
        if (k.b(d).getAuthor() != null && k.b(d).getAuthor().length() > 0)
        {
            s6 = (new StringBuilder()).append(s6).append("<span class=\"author\">").append(k.b(d).getAuthor()).append("</span> / ").toString();
        }
        s7 = (new StringBuilder()).append(s6).append("<span class=\"time\">").append(com.appyet.d.a.b(k.c(d), k.b(d).getPubDate())).append("</span>").toString();
          goto _L31
_L17:
        StringBuilder stringbuilder2 = new StringBuilder();
        Object aobj1[] = new Object[1];
        aobj1[0] = decimalformat.format((double)k.b(d).getEnclosureLength().intValue() / 1048576D);
        s8 = stringbuilder2.append(String.format("%s", aobj1)).append(" ").append(d.getString(0x7f08008b)).toString();
          goto _L32
_L21:
        if (!k.b(d).getEnclosureType().toLowerCase().contains("video")) goto _L19; else goto _L33
_L33:
        s10 = k.c(d).getString(0x7f08005d);
          goto _L34
_L19:
        s9 = k.c(d).getString(0x7f08005e);
        s10 = s9;
          goto _L34
        illegalstateexception2;
        com.appyet.d.d.a(illegalstateexception2);
_L29:
        s14 = s16;
          goto _L35
        illegalstateexception;
_L39:
        s14 = (new StringBuilder()).append(s11).append("<span class=\"appyet_article\">").append(s).append("</span>").toString();
          goto _L35
_L27:
        s14 = (new StringBuilder()).append(s11).append("<span class=\"appyet_article\">").append(s).append("</span>").toString();
          goto _L35
_L25:
        if (!k.e(d).getLink().toLowerCase().contains("://gdata.youtube.com/feeds/api/") || k.b(d).getThumbnail() == null) goto _L37; else goto _L36
_L36:
        s20 = k.b(d).getThumbnail();
        s22 = s20.substring(3 + s20.indexOf("vi/"), s20.indexOf("/0.jpg"));
        k.b(d).setLink((new StringBuilder("http://www.youtube.com/watch?v=")).append(s22).toString());
        if (!k.e(d).getLink().toLowerCase().contains("://gdata.youtube.com/feeds/api/playlists"))
        {
            break MISSING_BLOCK_LABEL_2954;
        }
        s24 = Pattern.compile("(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:'\".,<>?\253\273\u201C\u201D\u2018\u2019]))").matcher(s).replaceAll("<a href=\"$1\">$1</a>");
        s21 = s24;
_L40:
        s11 = (new StringBuilder()).append(s11).append("<p><a href='appyet.youtube:").append(s22).append("'><img class='appyet_youtubeimg' src='file:///android_asset/html/youtube_btn_play.png' style=\"background:url('http://i.ytimg.com/vi/").append(s22).append("/0.jpg')\"/></a></p>").toString();
        s23 = (new StringBuilder()).append(s11).append("<p>").append(s21.replace("\n", "<br />")).append("</p>").toString();
        s14 = s23;
          goto _L35
        illegalstateexception3;
        s21 = s;
_L38:
        s14 = (new StringBuilder()).append(s11).append("<span class=\"appyet_article\">").append(s21).append("</span>").toString();
          goto _L35
_L37:
label5:
        {
            if (!com.appyet.c.k.d(d).IsViewImageOnTouch)
            {
                break label5;
            }
            StringBuilder stringbuilder1 = (new StringBuilder()).append(s11).append("<span class=\"appyet_article\">");
            d;
            s14 = stringbuilder1.append(com.appyet.c.k.a(s, k.f(d))).append("</span>").toString();
        }
          goto _L35
        s19 = (new StringBuilder()).append(s11).append("<span class=\"appyet_article\">").append(s).append("</span>").toString();
        s14 = s19;
          goto _L35
        illegalstateexception4;
          goto _L38
        illegalstateexception1;
        s11 = s16;
          goto _L39
        s21 = s;
          goto _L40
_L11:
        if (s == null)
        {
            s = "";
        }
          goto _L41
_L35:
        String s9;
        IllegalStateException illegalstateexception;
        IllegalStateException illegalstateexception1;
        IllegalStateException illegalstateexception2;
        String s19;
        String s20;
        IllegalStateException illegalstateexception3;
        String s21;
        String s22;
        IllegalStateException illegalstateexception4;
        String s23;
        String s24;
        try
        {
            if (com.appyet.c.k.d(d).IsShowViewWebsite)
            {
                s14 = (new StringBuilder()).append(s14).append("<p><a class=\"appyet_visitwebsite\" href=\"").append(k.b(d).getLink()).append("\">").append(d.getString(0x7f0800b9)).append("</a></p>").toString();
            }
            if (com.appyet.c.k.d(d).IsDisQusComment)
            {
                s14 = (new StringBuilder()).append(s14).append("<p><a class=\"appyet_viewcomments\" href=\"").append(k.g(d)).append("\">").append(d.getString(0x7f0800c4)).append("</a></p>").toString();
            }
            b = (new StringBuilder()).append(s14).append("</div></body></html>").toString();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return null;
        if (true) goto _L43; else goto _L42
_L42:
    }

    protected final void a()
    {
        k.i(d).setVisibility(0);
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        if (a == null)
        {
            return;
        }
        try
        {
            a.loadDataWithBaseURL(k.h(d), b, "text/html", "UTF-8", "");
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
    }

    protected final Object b()
    {
        return f();
    }
}
