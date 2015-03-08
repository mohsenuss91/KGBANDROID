// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.TypedValue;
import com.adsdk.sdk.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.client.methods.HttpGet;

public class ResourceManager
{

    static final boolean $assertionsDisabled = false;
    public static final String BACK_ICON = "browser_back.png";
    public static final String BOTTOMBAR_BG = "bar.png";
    public static final String CLOSE_BUTTON_NORMAL = "close_button_normal.png";
    public static final String CLOSE_BUTTON_PRESSED = "close_button_pressed.png";
    public static final int DEFAULT_BACK_IMAGE_RESOURCE_ID = -14;
    public static final int DEFAULT_BOTTOMBAR_BG_RESOURCE_ID = -2;
    public static final int DEFAULT_CLOSE_BUTTON_NORMAL_RESOURCE_ID = -29;
    public static final int DEFAULT_CLOSE_BUTTON_PRESSED_RESOURCE_ID = -30;
    public static final int DEFAULT_EXTERNAL_IMAGE_RESOURCE_ID = -17;
    public static final int DEFAULT_FORWARD_IMAGE_RESOURCE_ID = -15;
    public static final int DEFAULT_PAUSE_IMAGE_RESOURCE_ID = -12;
    public static final int DEFAULT_PLAY_IMAGE_RESOURCE_ID = -11;
    public static final int DEFAULT_RELOAD_IMAGE_RESOURCE_ID = -16;
    public static final int DEFAULT_REPLAY_IMAGE_RESOURCE_ID = -13;
    public static final int DEFAULT_SKIP_IMAGE_RESOURCE_ID = -18;
    public static final int DEFAULT_TOPBAR_BG_RESOURCE_ID = -1;
    public static final String EXTERNAL_ICON = "browser_external.png";
    public static final String FORWARD_ICON = "browser_forward.png";
    public static final String PAUSE_ICON = "video_pause.png";
    public static final String PLAY_ICON = "video_play.png";
    public static final String RELOAD_ICON = "video_replay.png";
    public static final String REPLAY_ICON = "video_replay.png";
    public static final int RESOURCE_LOADED_MSG = 100;
    public static final String SKIP_ICON = "skip.png";
    public static final String TOPBAR_BG = "bar.png";
    public static final int TYPE_FILE = 0;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_ZIP = 1;
    public static final String VERSION = "version.txt";
    public static boolean sCancel = false;
    public static HttpGet sDownloadGet;
    public static boolean sDownloading = false;
    private static HashMap sResources = new HashMap();
    private Handler mHandler;
    private HashMap mResources;

    public ResourceManager(Context context, Handler handler)
    {
        mResources = new HashMap();
        mHandler = handler;
    }

    private static Drawable buildDrawable(Context context, String s)
    {
        InputStream inputstream2 = context.getClass().getClassLoader().getResourceAsStream(s);
        InputStream inputstream = inputstream2;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        int l;
        android.util.DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        i = bitmap.getWidth();
        j = bitmap.getHeight();
        k = (int)TypedValue.applyDimension(1, i, displaymetrics);
        l = (int)TypedValue.applyDimension(1, j, displaymetrics);
        if (k == i && l == j) goto _L4; else goto _L3
_L3:
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, k, l, false);
_L8:
        BitmapDrawable bitmapdrawable = new BitmapDrawable(context.getResources(), bitmap1);
        Exception exception;
        InputStream inputstream1;
        Exception exception2;
        Exception exception7;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (Exception exception6)
            {
                return bitmapdrawable;
            }
        }
        return bitmapdrawable;
        exception2;
        inputstream1 = null;
_L7:
        Log.i((new StringBuilder("ResourceManager cannot find resource ")).append(s).toString());
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (Exception exception4) { }
        }
        return null;
        exception;
        inputstream = null;
_L6:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (Exception exception1) { }
        }
        throw exception;
_L2:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception7) { }
        }
        break MISSING_BLOCK_LABEL_160;
        exception;
        continue; /* Loop/switch isn't completed */
        Exception exception3;
        exception3;
        inputstream = inputstream1;
        exception = exception3;
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception5;
        exception5;
        inputstream1 = inputstream;
        if (true) goto _L7; else goto _L4
_L4:
        bitmap1 = bitmap;
          goto _L8
    }

    public static void cancel()
    {
        sCancel = true;
        if (sDownloadGet != null)
        {
            sDownloadGet.abort();
            sDownloadGet = null;
        }
        sResources.clear();
    }

    public static Drawable getDefaultResource(int i)
    {
        return (Drawable)sResources.get(Integer.valueOf(i));
    }

    public static Drawable getDefaultSkipButton(Context context)
    {
        return buildDrawable(context, "skip.png");
    }

    public static long getInstalledVersion(Context context)
    {
        long l;
        FileInputStream fileinputstream;
        l = -1L;
        fileinputstream = null;
        long l1;
        fileinputstream = context.openFileInput("version.txt");
        l1 = Long.valueOf((new BufferedReader(new InputStreamReader(fileinputstream, "UTF-8"))).readLine()).longValue();
        l = l1;
        Exception exception;
        Exception exception1;
        Exception exception2;
        Exception exception3;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            catch (Exception exception4) { }
        }
        Log.d((new StringBuilder("Resources installed version:")).append(l).toString());
        return l;
        exception2;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception3) { }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        exception;
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception1) { }
        }
        throw exception;
    }

    public static Drawable getStaticResource(Context context, int i)
    {
        BitmapDrawable bitmapdrawable = (BitmapDrawable)sResources.get(Integer.valueOf(i));
        if (bitmapdrawable == null || bitmapdrawable.getBitmap().isRecycled())
        {
            initDefaultResource(context, i);
            bitmapdrawable = (BitmapDrawable)sResources.get(Integer.valueOf(i));
        }
        return bitmapdrawable;
    }

    private static void initDefaultResource(Context context, int i)
    {
        switch (i)
        {
        default:
            return;

        case -11: 
            registerImageResource(context, -11, "video_play.png");
            return;

        case -12: 
            registerImageResource(context, -12, "video_pause.png");
            return;

        case -13: 
            registerImageResource(context, -13, "video_replay.png");
            return;

        case -14: 
            registerImageResource(context, -14, "browser_back.png");
            return;

        case -15: 
            registerImageResource(context, -15, "browser_forward.png");
            return;

        case -16: 
            registerImageResource(context, -16, "video_replay.png");
            return;

        case -17: 
            registerImageResource(context, -17, "browser_external.png");
            return;

        case -18: 
            registerImageResource(context, -18, "skip.png");
            return;

        case -1: 
            registerImageResource(context, -1, "bar.png");
            return;

        case -2: 
            registerImageResource(context, -2, "bar.png");
            return;

        case -29: 
            registerImageResource(context, -29, "close_button_normal.png");
            return;

        case -30: 
            registerImageResource(context, -30, "close_button_pressed.png");
            return;
        }
    }

    public static boolean isDownloading()
    {
        return sDownloading;
    }

    private static void registerImageResource(Context context, int i, String s)
    {
        Drawable drawable = buildDrawable(context, s);
        if (drawable != null)
        {
            sResources.put(Integer.valueOf(i), drawable);
            return;
        } else
        {
            Log.i("registerImageResource", (new StringBuilder("drawable was null ")).append(s).toString());
            return;
        }
    }

    public static boolean resourcesInstalled(Context context)
    {
        String as[] = context.fileList();
        int i = 0;
        do
        {
            if (i >= as.length)
            {
                return false;
            }
            if ("version.txt".equals(as[i]))
            {
                Log.d("Resources already installed");
                return true;
            }
            i++;
        } while (true);
    }

    public static void saveInstalledVersion(Context context, long l)
    {
        FileOutputStream fileoutputstream = null;
        FileOutputStream fileoutputstream2 = context.openFileOutput("version.txt", 0);
        fileoutputstream = fileoutputstream2;
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(fileoutputstream, "UTF-8");
        outputstreamwriter.write(String.valueOf(l));
        outputstreamwriter.flush();
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        fileoutputstream.close();
_L2:
        return;
        Exception exception3;
        exception3;
        if (fileoutputstream == null) goto _L2; else goto _L1
_L1:
        try
        {
            fileoutputstream.close();
            return;
        }
        catch (Exception exception4)
        {
            return;
        }
        Exception exception;
        exception;
        FileOutputStream fileoutputstream1;
        Exception exception1;
        fileoutputstream1 = null;
        exception1 = exception;
_L4:
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (Exception exception2) { }
        }
        throw exception1;
        Exception exception6;
        exception6;
        return;
        Exception exception5;
        exception5;
        fileoutputstream1 = fileoutputstream;
        exception1 = exception5;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean containsResource(int i)
    {
        return mResources.get(Integer.valueOf(i)) != null || mResources.get(Integer.valueOf(i)) != null;
    }

    public void fetchResource(Context context, String s, int i)
    {
        if (sResources.get(Integer.valueOf(i)) == null)
        {
            (new FetchImageTask(context, s, i)).execute(new Void[0]);
        }
    }

    public Drawable getResource(Context context, int i)
    {
        BitmapDrawable bitmapdrawable = (BitmapDrawable)mResources.get(Integer.valueOf(i));
        if (bitmapdrawable != null)
        {
            return bitmapdrawable;
        } else
        {
            return getStaticResource(context, i);
        }
    }

    public void releaseInstance()
    {
        Iterator iterator = mResources.entrySet().iterator();
        do
        {
            java.util.Map.Entry entry;
            if (!iterator.hasNext())
            {
                if (!$assertionsDisabled && mResources.size() != 0)
                {
                    throw new AssertionError();
                } else
                {
                    System.gc();
                    return;
                }
            }
            entry = (java.util.Map.Entry)iterator.next();
            iterator.remove();
            entry.getValue();
        } while (true);
    }

    static 
    {
        boolean flag;
        if (!com/adsdk/sdk/video/ResourceManager.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



    private class FetchImageTask extends AsyncTask
    {

        Context mContext;
        int mResourceId;
        String mUrl;
        final ResourceManager this$0;

        private Drawable fetchImage(String s)
        {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)(new URL(s)).getContent());
            if (bitmap == null) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            int k;
            int l;
            android.util.DisplayMetrics displaymetrics = mContext.getResources().getDisplayMetrics();
            i = bitmap.getWidth();
            j = bitmap.getHeight();
            k = (int)TypedValue.applyDimension(1, i, displaymetrics);
            l = (int)TypedValue.applyDimension(1, j, displaymetrics);
            if (k == i && l == j)
            {
                break MISSING_BLOCK_LABEL_139;
            }
            Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, k, l, false);
_L3:
            BitmapDrawable bitmapdrawable = new BitmapDrawable(mContext.getResources(), bitmap1);
            return bitmapdrawable;
            Exception exception;
            exception;
            Log.e((new StringBuilder("Cannot fetch image:")).append(s).toString(), exception);
_L2:
            return null;
            bitmap1 = bitmap;
              goto _L3
        }

        protected transient Boolean doInBackground(Void avoid[])
        {
            String s = mUrl;
            Drawable drawable = null;
            if (s != null)
            {
                int i = mUrl.length();
                drawable = null;
                if (i > 0)
                {
                    drawable = fetchImage(mUrl);
                }
            }
            if (drawable != null)
            {
                mResources.put(Integer.valueOf(mResourceId), drawable);
                return Boolean.valueOf(true);
            } else
            {
                return Boolean.valueOf(false);
            }
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Boolean boolean1)
        {
            super.onPostExecute(boolean1);
            Log.i((new StringBuilder("Fetched: ")).append(mUrl).toString());
            android.os.Message message = mHandler.obtainMessage(100, mResourceId, 0);
            mHandler.sendMessage(message);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Boolean)obj);
        }

        public FetchImageTask(Context context, String s, int i)
        {
            this$0 = ResourceManager.this;
            super();
            mContext = context;
            mUrl = s;
            mResourceId = i;
            Log.i((new StringBuilder("Fetching: ")).append(mUrl).toString());
        }
    }

}
