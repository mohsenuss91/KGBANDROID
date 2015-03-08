// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.millennialmedia.android:
//            MMBaseActivity, BridgeMMMedia

class hasRequestedPic extends MMBaseActivity
{

    private Uri fileUri;
    boolean hasRequestedPic;

    protected void onActivityResult(int i, int j, Intent intent)
    {
        FileOutputStream fileoutputstream;
        fileoutputstream = null;
        super.onActivityResult(i, j, intent);
        if (intent == null) goto _L2; else goto _L1
_L1:
        Uri uri = intent.getData();
        if (uri != null) goto _L4; else goto _L3
_L3:
        if (intent.getExtras() == null) goto _L2; else goto _L5
_L5:
        Bitmap bitmap = (Bitmap)intent.getExtras().get("data");
        FileOutputStream fileoutputstream1;
        ByteArrayInputStream bytearrayinputstream;
        File file = new File(getIntent().getData().getPath());
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.erActivity.getIntent, 0, bytearrayoutputstream);
        bytearrayinputstream = new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
        fileoutputstream1 = new FileOutputStream(file);
        byte abyte0[] = new byte[1024];
_L8:
        int k = bytearrayinputstream.read(abyte0);
        if (k <= 0) goto _L7; else goto _L6
_L6:
        fileoutputstream1.write(abyte0, 0, k);
          goto _L8
        Exception exception7;
        exception7;
_L21:
        Exception exception4;
        FileInputStream fileinputstream;
        FileOutputStream fileoutputstream2;
        Exception exception10;
        FileOutputStream fileoutputstream3;
        FileInputStream fileinputstream1;
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (Exception exception3) { }
        }
_L2:
        synchronized (BridgeMMMedia.access$000())
        {
            BridgeMMMedia.access$000().notify();
        }
        finish();
        return;
_L7:
        try
        {
            fileoutputstream1.close();
        }
        catch (Exception exception8) { }
          goto _L2
        exception4;
_L19:
        String as[];
        ContentResolver contentresolver;
        Cursor cursor;
        int l;
        File file1;
        File file2;
        Exception exception12;
        Exception exception13;
        byte abyte1[];
        int i1;
        Exception exception14;
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (Exception exception5) { }
        }
        try
        {
            throw exception4;
        }
        catch (Exception exception1)
        {
            finish((new StringBuilder("Error with picture: ")).append(exception1.getMessage()).toString());
        }
          goto _L2
_L4:
        if (uri == null) goto _L2; else goto _L9
_L9:
        as = (new String[] {
            "_data"
        });
        contentresolver = getContentResolver();
        if (contentresolver == null) goto _L2; else goto _L10
_L10:
        cursor = contentresolver.query(uri, as, null, null, null);
        if (cursor == null) goto _L2; else goto _L11
_L11:
        l = cursor.getColumnIndex("_data");
        if (l == -1) goto _L2; else goto _L12
_L12:
        cursor.moveToFirst();
        file1 = new File(cursor.getString(l));
        cursor.close();
        file2 = new File(getIntent().getData().getPath());
        fileinputstream = new FileInputStream(file1);
        fileoutputstream2 = new FileOutputStream(file2);
        abyte1 = new byte[1024];
_L15:
        i1 = fileinputstream.read(abyte1);
        if (i1 <= 0) goto _L14; else goto _L13
_L13:
        fileoutputstream2.write(abyte1, 0, i1);
          goto _L15
        exception12;
        fileoutputstream3 = fileoutputstream2;
        fileinputstream1 = fileinputstream;
_L18:
        if (fileinputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_426;
        }
        fileinputstream1.close();
        if (fileoutputstream3 != null)
        {
            try
            {
                fileoutputstream3.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception13) { }
        }
          goto _L2
_L14:
        try
        {
            fileinputstream.close();
            fileoutputstream2.close();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception14) { }
          goto _L2
        exception10;
        fileinputstream = null;
_L17:
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_477;
        }
        fileinputstream.close();
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (Exception exception11) { }
        }
        throw exception10;
        exception10;
        fileoutputstream = null;
        continue; /* Loop/switch isn't completed */
        Exception exception9;
        exception9;
        fileoutputstream = fileoutputstream2;
        exception10 = exception9;
        if (true) goto _L17; else goto _L16
_L16:
        Exception exception16;
        exception16;
        fileinputstream1 = null;
        fileoutputstream3 = null;
          goto _L18
        Exception exception15;
        exception15;
        fileinputstream1 = fileinputstream;
        fileoutputstream3 = null;
          goto _L18
        Exception exception6;
        exception6;
        fileoutputstream = fileoutputstream1;
        exception4 = exception6;
          goto _L19
        Exception exception2;
        exception2;
        fileoutputstream1 = null;
        if (true) goto _L21; else goto _L20
_L20:
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            if (getLastNonConfigurationInstance() != null)
            {
                hasRequestedPic = ((Bundle)getLastNonConfigurationInstance()).getBoolean("hasRequestedPic");
            }
            if (!hasRequestedPic)
            {
                if (!getIntent().getStringExtra("type").equalsIgnoreCase("Camera"))
                {
                    break label0;
                }
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                fileUri = getIntent().getData();
                intent.putExtra("return-data", true);
                hasRequestedPic = true;
                startActivityForResult(intent, 0);
            }
            return;
        }
        Intent intent1 = new Intent();
        intent1.setType("image/*");
        intent1.setAction("android.intent.action.GET_CONTENT");
        hasRequestedPic = true;
        startActivityForResult(intent1, 0);
    }

    public Object onRetainNonConfigurationInstance()
    {
        super.onRetainNonConfigurationInstance();
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasRequestedPic", hasRequestedPic);
        return bundle;
    }

    ()
    {
        hasRequestedPic = false;
    }
}
