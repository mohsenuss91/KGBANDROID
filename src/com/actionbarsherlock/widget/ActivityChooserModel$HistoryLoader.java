// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.widget;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.actionbarsherlock.widget:
//            ActivityChooserModel

final class <init>
    implements Runnable
{

    final ActivityChooserModel this$0;

    public final void run()
    {
        FileInputStream fileinputstream;
        Exception exception;
        IOException ioexception1;
        XmlPullParserException xmlpullparserexception;
        XmlPullParser xmlpullparser;
        int i;
        ArrayList arraylist;
        int j;
        try
        {
            fileinputstream = ActivityChooserModel.access$400(ActivityChooserModel.this).openFileInput(ActivityChooserModel.access$300(ActivityChooserModel.this));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            return;
        }
        xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(fileinputstream, null);
        i = 0;
_L1:
        if (i == 1 || i == 2)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        i = xmlpullparser.next();
          goto _L1
        if (!"historical-records".equals(xmlpullparser.getName()))
        {
            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
        }
          goto _L2
        xmlpullparserexception;
        Log.e(ActivityChooserModel.access$1100(), (new StringBuilder("Error reading historical recrod file: ")).append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString(), xmlpullparserexception);
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        fileinputstream.close();
_L6:
        return;
_L2:
        arraylist = new ArrayList();
_L4:
        j = xmlpullparser.next();
        if (j == 1)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        if (j == 3 || j == 4) goto _L4; else goto _L3
_L3:
        if (!"historical-record".equals(xmlpullparser.getName()))
        {
            throw new XmlPullParserException("Share records file not well-formed.");
        }
        break MISSING_BLOCK_LABEL_232;
        ioexception1;
        Log.e(ActivityChooserModel.access$1100(), (new StringBuilder("Error reading historical recrod file: ")).append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString(), ioexception1);
        if (fileinputstream == null) goto _L6; else goto _L5
_L5:
        try
        {
            fileinputstream.close();
            return;
        }
        catch (IOException ioexception2)
        {
            return;
        }
        arraylist.add(new rd(xmlpullparser.getAttributeValue(null, "activity"), Long.parseLong(xmlpullparser.getAttributeValue(null, "time")), Float.parseFloat(xmlpullparser.getAttributeValue(null, "weight"))));
          goto _L4
        exception;
        class _cls1
            implements Runnable
        {

            final ActivityChooserModel.HistoryLoader this$1;

            public void run()
            {
                ActivityChooserModel.access$800(this$0);
                ActivityChooserModel.access$900(this$0);
            }

            _cls1()
            {
                this$1 = ActivityChooserModel.HistoryLoader.this;
                super();
            }
        }

        IOException ioexception3;
        Object obj;
        LinkedHashSet linkedhashset;
        Exception exception1;
        List list;
        int k;
        IOException ioexception4;
        IOException ioexception5;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            catch (IOException ioexception) { }
        }
        throw exception;
        obj = ActivityChooserModel.access$500(ActivityChooserModel.this);
        obj;
        JVM INSTR monitorenter ;
        linkedhashset = new LinkedHashSet(arraylist);
        list = ActivityChooserModel.access$600(ActivityChooserModel.this);
        k = -1 + list.size();
_L8:
        if (k < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        linkedhashset.add((rd)list.get(k));
        k--;
        if (true) goto _L8; else goto _L7
_L7:
        if (list.size() != linkedhashset.size())
        {
            break MISSING_BLOCK_LABEL_403;
        }
        obj;
        JVM INSTR monitorexit ;
        if (fileinputstream == null) goto _L6; else goto _L9
_L9:
        try
        {
            fileinputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception5)
        {
            return;
        }
        list.clear();
        list.addAll(linkedhashset);
        ActivityChooserModel.access$702(ActivityChooserModel.this, true);
        ActivityChooserModel.access$1000(ActivityChooserModel.this).post(new _cls1());
        obj;
        JVM INSTR monitorexit ;
        if (fileinputstream == null) goto _L6; else goto _L10
_L10:
        try
        {
            fileinputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception4)
        {
            return;
        }
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        ioexception3;
    }

    private _cls1()
    {
        this$0 = ActivityChooserModel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
