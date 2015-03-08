// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.google.analytics.tracking.android:
//            DefaultProvider, Log

class ClientIdDefaultProvider
    implements DefaultProvider
{

    private static ClientIdDefaultProvider sInstance;
    private static final Object sInstanceLock = new Object();
    private String mClientId;
    private boolean mClientIdLoaded;
    private final Object mClientIdLock = new Object();
    private final Context mContext;

    protected ClientIdDefaultProvider(Context context)
    {
        mClientIdLoaded = false;
        mContext = context;
        asyncInitializeClientId();
    }

    private void asyncInitializeClientId()
    {
        (new _cls1("client_id_fetcher")).start();
    }

    private String blockingGetClientId()
    {
        if (mClientIdLoaded) goto _L2; else goto _L1
_L1:
        Object obj = mClientIdLock;
        obj;
        JVM INSTR monitorenter ;
        if (mClientIdLoaded) goto _L2; else goto _L3
_L3:
        Log.v("Waiting for clientId to load");
_L7:
        mClientIdLock.wait();
_L5:
        if (!mClientIdLoaded)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        Log.v("Loaded clientId");
        return mClientId;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e((new StringBuilder("Exception while waiting for clientId: ")).append(interruptedexception).toString());
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
    }

    static void dropInstance()
    {
        synchronized (sInstanceLock)
        {
            sInstance = null;
        }
    }

    public static ClientIdDefaultProvider getProvider()
    {
        ClientIdDefaultProvider clientiddefaultprovider;
        synchronized (sInstanceLock)
        {
            clientiddefaultprovider = sInstance;
        }
        return clientiddefaultprovider;
    }

    public static void initializeProvider(Context context)
    {
        synchronized (sInstanceLock)
        {
            if (sInstance == null)
            {
                sInstance = new ClientIdDefaultProvider(context);
            }
        }
    }

    private boolean storeClientId(String s)
    {
        try
        {
            Log.v("Storing clientId.");
            FileOutputStream fileoutputstream = mContext.openFileOutput("gaClientId", 0);
            fileoutputstream.write(s.getBytes());
            fileoutputstream.close();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Log.e("Error creating clientId file.");
            return false;
        }
        catch (IOException ioexception)
        {
            Log.e("Error writing to clientId file.");
            return false;
        }
        return true;
    }

    protected String generateClientId()
    {
        String s = UUID.randomUUID().toString().toLowerCase();
        if (!storeClientId(s))
        {
            s = "0";
        }
        return s;
    }

    public String getValue(String s)
    {
        if ("&cid".equals(s))
        {
            return blockingGetClientId();
        } else
        {
            return null;
        }
    }

    String initializeClientId()
    {
        String s = null;
        FileInputStream fileinputstream;
        byte abyte0[];
        int i;
        fileinputstream = mContext.openFileInput("gaClientId");
        abyte0 = new byte[128];
        i = fileinputstream.read(abyte0, 0, 128);
        if (fileinputstream.available() <= 0) goto _L2; else goto _L1
_L1:
        Log.e("clientId file seems corrupted, deleting it.");
        fileinputstream.close();
        mContext.deleteFile("gaClientId");
_L6:
        if (s == null)
        {
            s = generateClientId();
        }
        return s;
_L2:
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        Log.e("clientId file seems empty, deleting it.");
        fileinputstream.close();
        mContext.deleteFile("gaClientId");
        s = null;
        continue; /* Loop/switch isn't completed */
        String s1 = new String(abyte0, 0, i);
        fileinputstream.close();
        s = s1;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
_L4:
        Log.e("Error reading clientId file, deleting it.");
        mContext.deleteFile("gaClientId");
        continue; /* Loop/switch isn't completed */
        IOException ioexception1;
        ioexception1;
        s = s1;
        if (true) goto _L4; else goto _L3
_L3:
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
        s = s1;
        continue; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean providesField(String s)
    {
        return "&cid".equals(s);
    }




/*
    static String access$102(ClientIdDefaultProvider clientiddefaultprovider, String s)
    {
        clientiddefaultprovider.mClientId = s;
        return s;
    }

*/


/*
    static boolean access$202(ClientIdDefaultProvider clientiddefaultprovider, boolean flag)
    {
        clientiddefaultprovider.mClientIdLoaded = flag;
        return flag;
    }

*/

    private class _cls1 extends Thread
    {

        final ClientIdDefaultProvider this$0;

        public void run()
        {
            synchronized (mClientIdLock)
            {
                mClientId = initializeClientId();
                mClientIdLoaded = true;
                mClientIdLock.notifyAll();
            }
        }

        _cls1(String s)
        {
            this$0 = ClientIdDefaultProvider.this;
            super(s);
        }
    }

}
