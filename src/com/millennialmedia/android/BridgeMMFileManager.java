// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.net.Uri;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, AdCache, HandShake, MMJSResponse, 
//            Base64

class BridgeMMFileManager extends MMJSObject
{

    private File root;

    BridgeMMFileManager()
    {
    }

    private boolean hasCreativeDirectory()
    {
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            File file = AdCache.getCacheDirectory(context);
            root = file;
            if (file != null)
            {
                return true;
            }
        }
        return false;
    }

    public MMJSResponse cleanupCache(HashMap hashmap)
    {
        if (hasCreativeDirectory())
        {
            boolean flag = hashmap.containsKey("clear");
            boolean flag1 = false;
            if (flag)
            {
                flag1 = Boolean.parseBoolean((String)hashmap.get("clear"));
            }
            long l;
            if (flag1)
            {
                l = 0L;
            } else
            {
                Context context = (Context)contextRef.get();
                SecurityException securityexception;
                if (context != null)
                {
                    l = HandShake.sharedHandShake(context).creativeCacheTimeout;
                } else
                {
                    l = 0xf731400L;
                }
            }
            try
            {
                AdCache.cleanupDirectory(root, l);
            }
            // Misplaced declaration of an exception variable
            catch (SecurityException securityexception) { }
        }
        return null;
    }

    public MMJSResponse downloadFile(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("url");
        if (!TextUtils.isEmpty(s) && context != null)
        {
            String s1;
            if (hashmap.containsKey("path"))
            {
                s1 = (String)hashmap.get("path");
            } else
            {
                s1 = Uri.parse((String)hashmap.get("url")).getLastPathSegment();
            }
            if (AdCache.downloadComponentToCache(s, s1, context))
            {
                return MMJSResponse.responseWithSuccess(s1);
            }
        }
        return null;
    }

    public MMJSResponse getDirectoryContents(HashMap hashmap)
    {
        if (hasCreativeDirectory())
        {
            File file;
            JSONArray jsonarray;
            String as[];
            int i;
            if (hashmap.containsKey("path"))
            {
                file = new File(root, (String)hashmap.get("path"));
            } else
            {
                file = root;
            }
            jsonarray = new JSONArray();
            as = file.list();
            i = as.length;
            for (int j = 0; j < i; j++)
            {
                jsonarray.put(as[j]);
            }

            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.response = jsonarray;
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getFileContents(HashMap hashmap)
    {
        FileInputStream fileinputstream = null;
        if (!hasCreativeDirectory() || !hashmap.containsKey("path")) goto _L2; else goto _L1
_L1:
        File file;
        FileInputStream fileinputstream1;
        file = new File(root, (String)hashmap.get("path"));
        fileinputstream1 = new FileInputStream(file);
        byte abyte0[];
        abyte0 = new byte[(int)file.length()];
        fileinputstream1.read(abyte0);
        Exception exception3;
        Exception exception6;
        try
        {
            fileinputstream1.close();
        }
        catch (Exception exception5) { }
        if (abyte0 != null)
        {
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.dataResponse = abyte0;
            return mmjsresponse;
        }
          goto _L2
        exception6;
        fileinputstream1 = null;
_L6:
        if (fileinputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        try
        {
            fileinputstream1.close();
        }
        catch (Exception exception1)
        {
            abyte0 = null;
            break MISSING_BLOCK_LABEL_71;
        }
        abyte0 = null;
        break MISSING_BLOCK_LABEL_71;
        exception3;
_L4:
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            catch (Exception exception4) { }
        }
        throw exception3;
_L2:
        return null;
        Exception exception2;
        exception2;
        fileinputstream = fileinputstream1;
        exception3 = exception2;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public MMJSResponse getFreeDiskSpace(HashMap hashmap)
    {
        if (hasCreativeDirectory())
        {
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            StatFs statfs = new StatFs(root.getAbsolutePath());
            mmjsresponse.response = new Long((long)statfs.getAvailableBlocks() * (long)statfs.getBlockSize());
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getMimeType(HashMap hashmap)
    {
        if (hasCreativeDirectory())
        {
            String as[] = ((String)hashmap.get("path")).split("\\.");
            String s = MimeTypeMap.getSingleton().getMimeTypeFromExtension(as[-1 + as.length]);
            if (s != null)
            {
                MMJSResponse mmjsresponse = new MMJSResponse();
                mmjsresponse.result = 1;
                mmjsresponse.response = s;
                return mmjsresponse;
            }
        }
        return null;
    }

    public MMJSResponse moveFile(HashMap hashmap)
    {
        if (!hasCreativeDirectory())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        String s;
        String s1;
        s = (String)hashmap.get("fromPath");
        s1 = (String)hashmap.get("toPath");
        if (s == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        MMJSResponse mmjsresponse;
        if (!(new File(root, s)).renameTo(new File(root, s1)))
        {
            break MISSING_BLOCK_LABEL_79;
        }
        mmjsresponse = MMJSResponse.responseWithSuccess("File moved successfully");
        return mmjsresponse;
        Exception exception;
        exception;
        return null;
    }

    public MMJSResponse removeAtPath(HashMap hashmap)
    {
        if (!hasCreativeDirectory())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        String s = (String)hashmap.get("path");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        MMJSResponse mmjsresponse;
        if (!(new File(root, s)).delete())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        mmjsresponse = MMJSResponse.responseWithSuccess("File removed successfully");
        return mmjsresponse;
        Exception exception;
        exception;
        return null;
    }

    public MMJSResponse writeData(HashMap hashmap)
    {
        FileOutputStream fileoutputstream = null;
        if (!hasCreativeDirectory() || !hashmap.containsKey("path") || !hashmap.containsKey("data")) goto _L2; else goto _L1
_L1:
        FileOutputStream fileoutputstream1;
        byte abyte0[];
        File file = new File(root, (String)hashmap.get("path"));
        abyte0 = Base64.decode((String)hashmap.get("data"));
        fileoutputstream1 = new FileOutputStream(file);
        fileoutputstream1.write(abyte0);
        fileoutputstream1.close();
        boolean flag = true;
_L3:
        if (flag)
        {
            return MMJSResponse.responseWithSuccess("File written successfully");
        }
          goto _L2
        Exception exception6;
        exception6;
        flag = true;
          goto _L3
        Exception exception2;
        exception2;
        fileoutputstream1 = null;
_L6:
        if (fileoutputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        fileoutputstream1.close();
        flag = false;
          goto _L3
        Exception exception3;
        exception3;
        flag = false;
          goto _L3
        Exception exception;
        exception;
_L5:
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (Exception exception1) { }
        }
        throw exception;
_L2:
        return null;
        Exception exception5;
        exception5;
        fileoutputstream = fileoutputstream1;
        exception = exception5;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception4;
        exception4;
          goto _L6
    }
}
