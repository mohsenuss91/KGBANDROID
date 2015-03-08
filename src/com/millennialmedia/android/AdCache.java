// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.millennialmedia.android:
//            HandShake, CachedAd, MMSDK, MMAdImpl, 
//            AdCacheThreadPool

final class AdCache
{

    private static final String CACHED_AD_FILE = "ad.dat";
    private static final String CACHE_INCOMPLETE_PREFIX = "incompleteDownload_";
    private static final String CACHE_PREFIX = "nextCachedAd_";
    private static final String CACHE_PREFIX_APID = "nextCachedAd_apids";
    private static final String LOCK_FILE = "ad.lock";
    static final int PRIORITY_FETCH = 3;
    static final int PRIORITY_PRECACHE = 1;
    static final int PRIORITY_REFRESH = 2;
    static final String PRIVATE_CACHE_DIR = ".mmsyscache";
    private static Set apidListSet;
    private static String cachedVideoList;
    private static boolean cachedVideoListLoaded;
    private static Set cachedVideoSet;
    private static Map incompleteDownloadHashMap;
    private static boolean incompleteDownloadHashMapLoaded;
    static boolean isExternalEnabled = true;
    private static Map nextCachedAdHashMap;
    private static boolean nextCachedAdHashMapLoaded;

    private AdCache()
    {
    }

    static void cachedVideoWasAdded(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (!cachedVideoListLoaded)
        {
            getCachedVideoList(context);
        }
        if (cachedVideoSet == null)
        {
            cachedVideoSet = new HashSet();
        }
        cachedVideoSet.add(s);
        cachedVideoList = null;
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void cachedVideoWasRemoved(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (!cachedVideoListLoaded)
        {
            getCachedVideoList(context);
        }
        if (cachedVideoSet != null)
        {
            cachedVideoSet.remove(s);
            cachedVideoList = null;
        }
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void cleanCache(final Context context)
    {
        Utils.ThreadUtils.execute(new _cls3());
    }

    static void cleanUpExpiredAds(final Context context)
    {
        iterateCachedAds(context, 1, new _cls4());
    }

    static void cleanupCache(Context context)
    {
        cleanupInternalCache(context);
        if (isExternalStorageAvailable(context))
        {
            cleanupExternalCache(context);
        }
    }

    static void cleanupDirectory(File file, long l)
    {
        File afile[] = file.listFiles();
        int i = afile.length;
        int j = 0;
        while (j < i) 
        {
            File file1 = afile[j];
            if (file1.isFile())
            {
                if (System.currentTimeMillis() - file1.lastModified() > l)
                {
                    file1.delete();
                }
            } else
            if (file1.isDirectory())
            {
                try
                {
                    cleanupDirectory(file1, l);
                    if (file1.list().length == 0)
                    {
                        file1.delete();
                    }
                }
                catch (SecurityException securityexception) { }
            }
            j++;
        }
    }

    private static void cleanupExternalCache(Context context)
    {
        File file;
        for (file = getExternalCacheDirectory(context); file == null || !file.exists() || !file.isDirectory();)
        {
            return;
        }

        cleanupDirectory(file, HandShake.sharedHandShake(context).creativeCacheTimeout);
    }

    private static void cleanupInternalCache(Context context)
    {
        File file;
        for (file = getInternalCacheDirectory(context); file == null || !file.exists() || !file.isDirectory();)
        {
            return;
        }

        cleanupDirectory(file, HandShake.sharedHandShake(context).creativeCacheTimeout);
    }

    static boolean deleteFile(Context context, String s)
    {
        File file = getCachedAdFile(context, s);
        if (file != null)
        {
            return file.delete();
        } else
        {
            return false;
        }
    }

    static boolean downloadComponent(String s, String s1, File file, Context context)
    {
        FileOutputStream fileoutputstream;
        File file1;
        fileoutputstream = null;
        if (TextUtils.isEmpty(s))
        {
            MMSDK.Log.d("No Url ...");
            return false;
        }
        file1 = new File(file, s1);
        MMSDK.Log.v("Downloading Component: %s from %s", new Object[] {
            s1, s
        });
        if (file1.exists() && file1.length() > 0L)
        {
            MMSDK.Log.v((new StringBuilder()).append(s1).append(" already exists, skipping...").toString());
            return true;
        }
        HttpURLConnection httpurlconnection;
        InputStream inputstream1;
        URL url = new URL(s);
        HttpURLConnection.setFollowRedirects(true);
        httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setConnectTimeout(30000);
        httpurlconnection.setRequestMethod("GET");
        httpurlconnection.connect();
        inputstream1 = httpurlconnection.getInputStream();
        InputStream inputstream = inputstream1;
        String s2 = httpurlconnection.getHeaderField("Content-Length");
        fileoutputstream = null;
        if (s2 == null) goto _L2; else goto _L1
_L1:
        long l = Long.parseLong(s2);
_L16:
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        MMSDK.Log.e("Connection stream is null downloading %s.", new Object[] {
            s1
        });
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception2)
            {
                Object aobj3[] = new Object[1];
                aobj3[0] = ioexception2.getMessage();
                MMSDK.Log.e("Content caching error: %s", aobj3);
                file1.delete();
                return false;
            }
        }
        return false;
        boolean flag = isInternalDir(context, getCacheDirectory(context));
        fileoutputstream = null;
        if (!flag) goto _L4; else goto _L3
_L3:
        fileoutputstream = context.openFileOutput(file1.getName(), 1);
_L8:
        byte abyte0[] = new byte[4096];
_L7:
        int i = inputstream.read(abyte0);
        if (i <= 0) goto _L6; else goto _L5
_L5:
        fileoutputstream.write(abyte0, 0, i);
          goto _L7
        Exception exception;
        exception;
_L14:
        Object aobj1[] = new Object[2];
        aobj1[0] = s1;
        aobj1[1] = exception.getMessage();
        MMSDK.Log.e("Exception downloading component %s: %s", aobj1);
        Exception exception1;
        SecurityException securityexception;
        Object aobj4[];
        IOException ioexception3;
        Object aobj5[];
        long l1;
        IOException ioexception4;
        Object aobj6[];
        FileOutputStream fileoutputstream1;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception1)
            {
                Object aobj2[] = new Object[1];
                aobj2[0] = ioexception1.getMessage();
                MMSDK.Log.e("Content caching error: %s", aobj2);
                file1.delete();
                return false;
            }
        }
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        fileoutputstream.close();
_L10:
        file1.delete();
        return false;
_L4:
        fileoutputstream1 = new FileOutputStream(file1);
        fileoutputstream = fileoutputstream1;
          goto _L8
_L6:
        l1 = file1.length();
        if (l1 != l && l != -1L)
        {
            break MISSING_BLOCK_LABEL_449;
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception4)
            {
                aobj6 = new Object[1];
                aobj6[0] = ioexception4.getMessage();
                MMSDK.Log.e("Content caching error: %s", aobj6);
                file1.delete();
                return false;
            }
        }
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_414;
        }
        fileoutputstream.close();
        return true;
        MMSDK.Log.e("Content-Length does not match actual length.");
_L11:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception3)
            {
                aobj5 = new Object[1];
                aobj5[0] = ioexception3.getMessage();
                MMSDK.Log.e("Content caching error: %s", aobj5);
                file1.delete();
                return false;
            }
        }
        if (fileoutputstream == null) goto _L10; else goto _L9
_L9:
        fileoutputstream.close();
          goto _L10
        securityexception;
        aobj4 = new Object[2];
        aobj4[0] = s1;
        aobj4[1] = securityexception.getMessage();
        MMSDK.Log.e("Exception downloading component %s: %s", aobj4);
          goto _L11
        exception1;
_L13:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception)
            {
                Object aobj[] = new Object[1];
                aobj[0] = ioexception.getMessage();
                MMSDK.Log.e("Content caching error: %s", aobj);
                file1.delete();
                return false;
            }
        }
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_566;
        }
        fileoutputstream.close();
        throw exception1;
        exception1;
        fileoutputstream = null;
        inputstream = null;
        if (true) goto _L13; else goto _L12
_L12:
        exception;
        fileoutputstream = null;
        inputstream = null;
          goto _L14
_L2:
        l = -1L;
        if (true) goto _L16; else goto _L15
_L15:
    }

    static boolean downloadComponentToCache(String s, String s1, Context context)
    {
        return downloadComponent(s, s1, getCacheDirectory(context), context);
    }

    static File getCacheDirectory(Context context)
    {
        if (isExternalStorageAvailable(context))
        {
            return getExternalCacheDirectory(context);
        } else
        {
            return getInternalCacheDirectory(context);
        }
    }

    private static File getCachedAdFile(Context context, String s)
    {
        String s1;
        boolean flag;
        File file;
        s1 = (new StringBuilder()).append(s).append("ad.dat").toString();
        flag = isExternalStorageAvailable(context);
        file = getCacheDirectory(context);
        if (file == null) goto _L2; else goto _L1
_L1:
        if (!file.isDirectory()) goto _L2; else goto _L3
_L3:
        File file1 = new File(file, s1);
_L5:
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (file1.exists())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        File file2;
        File file3;
        boolean flag1;
        try
        {
            file2 = context.getFilesDir();
        }
        catch (Exception exception)
        {
            MMSDK.Log.e(exception);
            return null;
        }
        if (file2 == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        file3 = new File(file2, (new StringBuilder(".mmsyscache")).append(File.separator).append(s1).toString());
        if (!file3.exists())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        flag1 = file3.isFile();
        if (flag1)
        {
            return file3;
        }
        return file1;
_L2:
        file1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    static String getCachedVideoList(final Context context)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        java.util.Iterator iterator;
        if (cachedVideoList != null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (!cachedVideoListLoaded)
        {
            final HashSet hashSet = new HashSet();
            iterateCachedAds(context, 2, new _cls1());
            cachedVideoSet = hashSet;
            cachedVideoListLoaded = true;
        }
        if (cachedVideoSet == null || cachedVideoSet.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        stringbuilder = new StringBuilder();
        iterator = cachedVideoSet.iterator();
_L1:
        String s1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_161;
            }
            s1 = (String)iterator.next();
            if (stringbuilder.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_147;
            }
            stringbuilder.append((new StringBuilder(",")).append((String)s1).toString());
        } while (true);
        Exception exception;
        exception;
        throw exception;
        stringbuilder.append((String)s1);
          goto _L1
        cachedVideoList = stringbuilder.toString();
        String s = cachedVideoList;
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return s;
    }

    static File getDownloadFile(Context context, String s)
    {
        File file = getCacheDirectory(context);
        File file1 = null;
        if (file != null)
        {
            file1 = new File(file, s);
        }
        return file1;
    }

    private static File getExternalCacheDirectory(Context context)
    {
        File file1;
label0:
        {
            File file = Environment.getExternalStorageDirectory();
            if (file != null)
            {
                file1 = new File(file, ".mmsyscache");
                if (file1.exists() || file1.mkdirs())
                {
                    break label0;
                }
            }
            return null;
        }
        return file1;
    }

    static String getIncompleteDownload(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!incompleteDownloadHashMapLoaded)
        {
            loadIncompleteDownloadHashMap(context);
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = (String)incompleteDownloadHashMap.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static File getInternalCacheDirectory(Context context)
    {
        File file = context.getFilesDir();
        if (file != null && !file.exists() && !file.mkdirs())
        {
            file = null;
        }
        return file;
    }

    static String getNextCachedAd(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!nextCachedAdHashMapLoaded)
        {
            loadNextCachedAdHashMap(context);
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = (String)nextCachedAdHashMap.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static boolean hasDownloadFile(Context context, String s)
    {
        File file = getDownloadFile(context, s);
        return file != null && file.exists();
    }

    static boolean isExternalStorageAvailable(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && Environment.getExternalStorageState().equals("mounted") && isExternalEnabled;
    }

    static boolean isInternalDir(Context context, File file)
    {
        File file1 = getInternalCacheDirectory(context);
        return file1 != null && file1.equals(file);
    }

    static void iterateCachedAds(Context context, int i, Iterator iterator)
    {
        File file = getCacheDirectory(context);
        if (file == null) goto _L2; else goto _L1
_L1:
        File afile[];
        int j;
        int k;
        ObjectInputStream objectinputstream;
        afile = file.listFiles(new _cls2());
        j = afile.length;
        k = 0;
        objectinputstream = null;
_L7:
        if (k >= j) goto _L2; else goto _L3
_L3:
        File file1 = afile[k];
        if (file1 == null) goto _L5; else goto _L4
_L4:
        boolean flag = file1.exists();
        if (flag) goto _L6; else goto _L5
_L5:
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        objectinputstream.close();
        objectinputstream = null;
_L13:
        k++;
          goto _L7
_L6:
        if (i != 0) goto _L9; else goto _L8
_L8:
        boolean flag1 = iterator.callback(file1.getName());
        if (flag1) goto _L11; else goto _L10
_L10:
        Exception exception;
        ObjectInputStream objectinputstream1;
        Exception exception2;
        Exception exception3;
        int l;
        Date date;
        String s;
        long l1;
        if (objectinputstream != null)
        {
            try
            {
                objectinputstream.close();
            }
            catch (IOException ioexception5) { }
        }
_L2:
        iterator.done();
        return;
_L11:
        if (objectinputstream == null) goto _L13; else goto _L12
_L12:
        objectinputstream.close();
        objectinputstream = null;
          goto _L13
_L9:
        objectinputstream1 = new ObjectInputStream(new FileInputStream(file1));
        l = objectinputstream1.readInt();
        date = (Date)objectinputstream1.readObject();
        s = (String)objectinputstream1.readObject();
        l1 = objectinputstream1.readLong();
        if (i != 1) goto _L15; else goto _L14
_L14:
        if (iterator.callback(file1.getName(), l, date, s, l1, objectinputstream1)) goto _L17; else goto _L16
_L16:
        objectinputstream1.close();
          goto _L2
        exception3;
        exception = exception3;
        objectinputstream = objectinputstream1;
_L21:
        Object aobj[] = new Object[1];
        aobj[0] = file1.getName();
        MMSDK.Log.d("There was a problem reading the cached ad %s.", aobj);
        MMSDK.Log.d(exception);
        if (objectinputstream == null) goto _L13; else goto _L18
_L18:
        objectinputstream.close();
        objectinputstream = null;
          goto _L13
_L15:
        if (iterator.callback((CachedAd)objectinputstream1.readObject())) goto _L17; else goto _L19
_L19:
        objectinputstream1.close();
          goto _L2
        exception2;
_L20:
        IOException ioexception;
        IOException ioexception2;
        IOException ioexception3;
        IOException ioexception4;
        if (objectinputstream1 != null)
        {
            try
            {
                objectinputstream1.close();
            }
            catch (IOException ioexception1) { }
        }
        throw exception2;
_L17:
        objectinputstream1.close();
        objectinputstream = null;
          goto _L13
        ioexception3;
        objectinputstream = objectinputstream1;
          goto _L13
        ioexception;
          goto _L13
        ioexception4;
          goto _L13
        ioexception2;
          goto _L13
        Exception exception1;
        exception1;
        objectinputstream1 = objectinputstream;
        exception2 = exception1;
          goto _L20
        exception;
          goto _L21
    }

    static CachedAd load(Context context, String s)
    {
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        File file;
        return null;
_L2:
        if ((file = getCachedAdFile(context, s)) == null) goto _L1; else goto _L3
_L3:
        ObjectInputStream objectinputstream = new ObjectInputStream(new FileInputStream(file));
        CachedAd cachedad;
        objectinputstream.readInt();
        objectinputstream.readObject();
        objectinputstream.readObject();
        objectinputstream.readLong();
        cachedad = (CachedAd)objectinputstream.readObject();
        ObjectInputStream objectinputstream1;
        Exception exception1;
        Exception exception2;
        FileNotFoundException filenotfoundexception1;
        try
        {
            objectinputstream.close();
        }
        catch (IOException ioexception3) { }
        return cachedad;
        filenotfoundexception1;
        objectinputstream1 = null;
_L9:
        MMSDK.Log.e("There was a problem loading up the cached ad %s. Ad is not on disk.", new Object[] {
            s
        });
        if (objectinputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        try
        {
            objectinputstream1.close();
        }
        catch (IOException ioexception1)
        {
            cachedad = null;
            break MISSING_BLOCK_LABEL_75;
        }
        cachedad = null;
        break MISSING_BLOCK_LABEL_75;
        exception2;
        objectinputstream = null;
_L7:
        MMSDK.Log.e("There was a problem loading up the cached ad %s.", new Object[] {
            s
        });
        MMSDK.Log.d(exception2.getMessage());
        MMSDK.Log.d(exception2);
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        try
        {
            objectinputstream.close();
        }
        catch (IOException ioexception2)
        {
            cachedad = null;
            break MISSING_BLOCK_LABEL_75;
        }
        cachedad = null;
        break MISSING_BLOCK_LABEL_75;
        exception1;
        objectinputstream = null;
_L5:
        if (objectinputstream != null)
        {
            try
            {
                objectinputstream.close();
            }
            catch (IOException ioexception) { }
        }
        throw exception1;
        exception1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        objectinputstream = objectinputstream1;
        exception1 = exception;
        if (true) goto _L5; else goto _L4
_L4:
        exception2;
        if (true) goto _L7; else goto _L6
_L6:
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        objectinputstream1 = objectinputstream;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static void loadApidListSet(SharedPreferences sharedpreferences)
    {
        apidListSet = new HashSet();
        String s = sharedpreferences.getString("nextCachedAd_apids", null);
        if (s != null)
        {
            String as[] = s.split(MMSDK.COMMA);
            if (as != null && as.length > 0)
            {
                int i = as.length;
                for (int j = 0; j < i; j++)
                {
                    String s1 = as[j];
                    apidListSet.add(s1);
                }

            }
        }
    }

    static CachedAd loadIncompleteDownload(Context context, String s)
    {
        String s1 = getIncompleteDownload(context, s);
        if (s1 == null)
        {
            return null;
        } else
        {
            return load(context, s1);
        }
    }

    private static void loadIncompleteDownloadHashMap(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        incompleteDownloadHashMap = new ConcurrentHashMap();
        if (apidListSet == null)
        {
            loadApidListSet(sharedpreferences);
        }
        for (java.util.Iterator iterator = apidListSet.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            String as[] = MMAdImpl.getAdTypes();
            int i = as.length;
            int j = 0;
            while (j < i) 
            {
                String s1 = as[j];
                String s2 = sharedpreferences.getString((new StringBuilder("incompleteDownload_")).append(s1).append('_').append(s).toString(), null);
                if (s2 != null)
                {
                    incompleteDownloadHashMap.put((new StringBuilder()).append(s1).append('_').append(s).toString(), s2);
                }
                j++;
            }
        }

        incompleteDownloadHashMapLoaded = true;
    }

    static CachedAd loadNextCachedAd(Context context, String s)
    {
        String s1 = getNextCachedAd(context, s);
        if (s1 == null || s1.equals(""))
        {
            return null;
        } else
        {
            return load(context, s1);
        }
    }

    private static void loadNextCachedAdHashMap(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        nextCachedAdHashMap = new ConcurrentHashMap();
        if (apidListSet == null)
        {
            loadApidListSet(sharedpreferences);
        }
        for (java.util.Iterator iterator = apidListSet.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            String as[] = MMAdImpl.getAdTypes();
            int i = as.length;
            int j = 0;
            while (j < i) 
            {
                String s1 = as[j];
                String s2 = sharedpreferences.getString((new StringBuilder("nextCachedAd_")).append(s1).append('_').append(s).toString(), null);
                if (s2 != null)
                {
                    nextCachedAdHashMap.put((new StringBuilder()).append(s1).append('_').append(s).toString(), s2);
                }
                j++;
            }
        }

        nextCachedAdHashMapLoaded = true;
    }

    static void resetCache(final Context context)
    {
        iterateCachedAds(context, 2, new _cls5());
        cachedVideoSet = null;
        cachedVideoList = null;
        cachedVideoListLoaded = false;
        if (nextCachedAdHashMap != null)
        {
            for (java.util.Iterator iterator1 = nextCachedAdHashMap.keySet().iterator(); iterator1.hasNext(); setNextCachedAd(context, (String)iterator1.next(), null)) { }
        }
        if (incompleteDownloadHashMap != null)
        {
            for (java.util.Iterator iterator = incompleteDownloadHashMap.keySet().iterator(); iterator.hasNext(); setIncompleteDownload(context, (String)iterator.next(), null)) { }
        }
    }

    static boolean save(Context context, CachedAd cachedad)
    {
        ObjectOutputStream objectoutputstream = null;
        if (cachedad != null) goto _L2; else goto _L1
_L1:
        File file;
        return false;
_L2:
        if ((file = getCachedAdFile(context, cachedad.getId())) == null) goto _L1; else goto _L3
_L3:
        Object aobj[] = new Object[2];
        aobj[0] = cachedad.getId();
        aobj[1] = file;
        MMSDK.Log.v("Saving CachedAd %s to %s", aobj);
        File file1 = new File(file.getParent(), (new StringBuilder()).append(cachedad.getId()).append("ad.lock").toString());
        if (file1.createNewFile())
        {
            break MISSING_BLOCK_LABEL_125;
        }
        Object aobj2[] = new Object[1];
        aobj2[0] = cachedad.getId();
        MMSDK.Log.v("Could not save the cached ad %s. Ad was locked.", aobj2);
        try
        {
            file1.delete();
        }
        catch (IOException ioexception3)
        {
            return false;
        }
        return false;
        ObjectOutputStream objectoutputstream1 = new ObjectOutputStream(new FileOutputStream(file));
        objectoutputstream1.writeInt(cachedad.getType());
        objectoutputstream1.writeObject(cachedad.expiration);
        objectoutputstream1.writeObject(cachedad.acid);
        objectoutputstream1.writeLong(cachedad.deferredViewStart);
        objectoutputstream1.writeObject(cachedad);
        Exception exception;
        File file2;
        Exception exception1;
        IOException ioexception;
        Object aobj1[];
        IOException ioexception1;
        try
        {
            file1.delete();
            objectoutputstream1.close();
        }
        catch (IOException ioexception2) { }
        if (!cachedad.saveAssets(context))
        {
            cachedad.delete(context);
            return false;
        } else
        {
            return true;
        }
        exception;
        file2 = null;
_L7:
        aobj1 = new Object[1];
        aobj1[0] = cachedad.getId();
        MMSDK.Log.e("There was a problem saving the cached ad %s.", aobj1);
        MMSDK.Log.d(exception.getMessage());
        MMSDK.Log.d(exception);
        try
        {
            file2.delete();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception1)
        {
            return false;
        }
        if (objectoutputstream == null) goto _L1; else goto _L4
_L4:
        objectoutputstream.close();
        return false;
        exception1;
        file1 = null;
_L6:
        file1.delete();
        if (objectoutputstream != null)
        {
            try
            {
                objectoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
        }
        throw exception1;
        exception1;
        objectoutputstream = null;
        continue; /* Loop/switch isn't completed */
        exception1;
        objectoutputstream = objectoutputstream1;
        continue; /* Loop/switch isn't completed */
        exception1;
        file1 = file2;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        file2 = file1;
        objectoutputstream = null;
          goto _L7
        exception;
        objectoutputstream = objectoutputstream1;
        file2 = file1;
          goto _L7
    }

    private static void saveApidListSet(android.content.SharedPreferences.Editor editor, String s)
    {
        int i = s.indexOf('_');
        if (i >= 0 && i < s.length())
        {
            String s1 = s.substring(i + 1);
            if (s1 != null && !apidListSet.contains(s1))
            {
                boolean flag = apidListSet.isEmpty();
                StringBuilder stringbuilder = null;
                if (!flag)
                {
                    java.util.Iterator iterator = apidListSet.iterator();
                    StringBuilder stringbuilder2 = new StringBuilder();
                    for (; iterator.hasNext(); stringbuilder2.append((new StringBuilder()).append((String)iterator.next()).append(MMSDK.COMMA).toString())) { }
                    stringbuilder = stringbuilder2;
                }
                StringBuilder stringbuilder1 = new StringBuilder();
                String s2;
                if (stringbuilder == null)
                {
                    s2 = "";
                } else
                {
                    s2 = stringbuilder.toString();
                }
                editor.putString("nextCachedAd_apids", stringbuilder1.append(s2).append(s1).toString());
                apidListSet.add(s1);
            }
        }
    }

    private static void saveIncompleteDownloadHashMap(Context context, String s)
    {
        if (s != null)
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            saveApidListSet(editor, s);
            editor.putString((new StringBuilder("incompleteDownload_")).append(s).toString(), (String)incompleteDownloadHashMap.get(s));
            editor.commit();
        }
    }

    private static void saveNextCachedAdHashMapValue(Context context, String s)
    {
        if (s != null)
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            saveApidListSet(editor, s);
            editor.putString((new StringBuilder("nextCachedAd_")).append(s).toString(), (String)nextCachedAdHashMap.get(s));
            editor.commit();
        }
    }

    static void setEnableExternalStorage(boolean flag)
    {
        isExternalEnabled = flag;
    }

    static void setIncompleteDownload(Context context, String s, String s1)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!incompleteDownloadHashMapLoaded)
        {
            loadIncompleteDownloadHashMap(context);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Map map = incompleteDownloadHashMap;
        if (s1 == null)
        {
            s1 = "";
        }
        map.put(s, s1);
        saveIncompleteDownloadHashMap(context, s);
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void setNextCachedAd(Context context, String s, String s1)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!nextCachedAdHashMapLoaded)
        {
            loadNextCachedAdHashMap(context);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Map map = nextCachedAdHashMap;
        if (s1 == null)
        {
            s1 = "";
        }
        map.put(s, s1);
        saveNextCachedAdHashMapValue(context, s);
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean startDownloadTask(Context context, String s, CachedAd cachedad, AdCacheTaskListener adcachetasklistener)
    {
        return AdCacheThreadPool.sharedThreadPool().startDownloadTask(context, s, cachedad, adcachetasklistener);
    }


    private class _cls3
        implements Runnable
    {

        final Context val$context;

        public final void run()
        {
            MMSDK.Log.d("AdCache");
            AdCache.cleanUpExpiredAds(context);
            AdCache.cleanupCache(context);
        }

        _cls3()
        {
            context = context1;
            super();
        }
    }


    private class _cls4 extends Iterator
    {
        private class Iterator
        {

            static final int ITERATE_ID = 0;
            static final int ITERATE_INFO = 1;
            static final int ITERATE_OBJECT = 2;

            boolean callback(CachedAd cachedad)
            {
                return false;
            }

            boolean callback(String s)
            {
                return false;
            }

            boolean callback(String s, int i, Date date, String s1, long l, ObjectInputStream objectinputstream)
            {
                return false;
            }

            void done()
            {
            }

            Iterator()
            {
            }
        }


        final Context val$context;

        final boolean callback(String s, int i, Date date, String s1, long l, ObjectInputStream objectinputstream)
        {
            if (date != null && date.getTime() <= System.currentTimeMillis())
            {
                try
                {
                    CachedAd cachedad = (CachedAd)objectinputstream.readObject();
                    Object aobj[] = new Object[1];
                    aobj[0] = cachedad.getId();
                    MMSDK.Log.d("Deleting expired ad %s.", aobj);
                    cachedad.delete(context);
                }
                catch (Exception exception)
                {
                    MMSDK.Log.d("There was a problem reading the cached ad %s.", new Object[] {
                        s
                    });
                    MMSDK.Log.d(exception);
                    return true;
                }
            }
            return true;
        }

        _cls4()
        {
            context = context1;
            super();
        }
    }


    private class _cls1 extends Iterator
    {

        final Context val$context;
        final Set val$hashSet;

        final boolean callback(CachedAd cachedad)
        {
            if (cachedad.acid != null && cachedad.getType() == 1 && cachedad.isOnDisk(context))
            {
                hashSet.add(cachedad.acid);
            }
            return true;
        }

        _cls1()
        {
            context = context1;
            hashSet = set;
            super();
        }
    }


    private class _cls2
        implements FileFilter
    {

        public final boolean accept(File file)
        {
            return !file.isDirectory() && file.getName().endsWith("ad.dat");
        }

        _cls2()
        {
        }
    }


    private class _cls5 extends Iterator
    {

        final Context val$context;

        final boolean callback(CachedAd cachedad)
        {
            Object aobj[] = new Object[1];
            aobj[0] = cachedad.getId();
            MMSDK.Log.d("Deleting ad %s.", aobj);
            cachedad.delete(context);
            return true;
        }

        _cls5()
        {
            context = context1;
            super();
        }
    }

}
