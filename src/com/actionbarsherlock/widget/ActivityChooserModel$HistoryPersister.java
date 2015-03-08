// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.actionbarsherlock.widget:
//            ActivityChooserModel

final class <init>
    implements Runnable
{

    final ActivityChooserModel this$0;

    public final void run()
    {
        ArrayList arraylist;
        FileOutputStream fileoutputstream;
        XmlSerializer xmlserializer;
        int i;
        int j;
        synchronized (ActivityChooserModel.access$500(ActivityChooserModel.this))
        {
            arraylist = new ArrayList(ActivityChooserModel.access$600(ActivityChooserModel.this));
        }
        fileoutputstream = ActivityChooserModel.access$400(ActivityChooserModel.this).openFileOutput(ActivityChooserModel.access$300(ActivityChooserModel.this), 0);
        xmlserializer = Xml.newSerializer();
        xmlserializer.setOutput(fileoutputstream, null);
        xmlserializer.startDocument("UTF-8", Boolean.valueOf(true));
        xmlserializer.startTag(null, "historical-records");
        i = arraylist.size();
        j = 0;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        <init> <init>1 = (this._cls0)arraylist.remove(0);
        xmlserializer.startTag(null, "historical-record");
        xmlserializer.attribute(null, "activity", <init>1.activity.flattenToString());
        xmlserializer.attribute(null, "time", String.valueOf(<init>1.time));
        xmlserializer.attribute(null, "weight", String.valueOf(<init>1.weight));
        xmlserializer.endTag(null, "historical-record");
        j++;
        if (true) goto _L2; else goto _L1
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Log.e(ActivityChooserModel.access$1100(), (new StringBuilder("Error writing historical recrod file: ")).append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString(), filenotfoundexception);
_L3:
        return;
_L1:
        xmlserializer.endTag(null, "historical-records");
        xmlserializer.endDocument();
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
                return;
            }
            catch (IOException ioexception5)
            {
                return;
            }
        }
          goto _L3
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.e(ActivityChooserModel.access$1100(), (new StringBuilder("Error writing historical recrod file: ")).append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString(), illegalargumentexception);
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
                return;
            }
            catch (IOException ioexception4)
            {
                return;
            }
        }
          goto _L3
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e(ActivityChooserModel.access$1100(), (new StringBuilder("Error writing historical recrod file: ")).append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString(), illegalstateexception);
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
                return;
            }
            catch (IOException ioexception3)
            {
                return;
            }
        }
          goto _L3
        IOException ioexception1;
        ioexception1;
        Log.e(ActivityChooserModel.access$1100(), (new StringBuilder("Error writing historical recrod file: ")).append(ActivityChooserModel.access$300(ActivityChooserModel.this)).toString(), ioexception1);
        if (fileoutputstream == null) goto _L3; else goto _L4
_L4:
        try
        {
            fileoutputstream.close();
            return;
        }
        catch (IOException ioexception2)
        {
            return;
        }
        Exception exception1;
        exception1;
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (IOException ioexception) { }
        }
        throw exception1;
    }

    private ()
    {
        this$0 = ActivityChooserModel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
