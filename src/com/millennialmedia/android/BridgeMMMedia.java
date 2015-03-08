// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMJSResponse, AdCache, BridgeMMFileManager

class BridgeMMMedia extends MMJSObject
{

    private static final String PATH = "path";
    private static final String PICTURES = "Pictures";
    private static Object pickerActivityObject;
    MediaScannerConnection mediaScanner;

    BridgeMMMedia()
    {
    }

    private static Bitmap centerOfImage(Bitmap bitmap, int i, int j)
    {
        float f = (bitmap.getWidth() - i) / 2;
        float f1 = (bitmap.getHeight() - j) / 2;
        return cropImage(bitmap, (int)f, (int)f1, i, j);
    }

    private static Bitmap cropImage(Bitmap bitmap, int i, int j, int k, int l)
    {
        return Bitmap.createBitmap(bitmap, i, j, k, l);
    }

    private boolean isCameraAvailable()
    {
        Context context = (Context)contextRef.get();
        if (context != null && context.getPackageManager().checkPermission("android.permission.CAMERA", context.getPackageName()) == 0)
        {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
        } else
        {
            return false;
        }
    }

    private boolean isPictureChooserAvailable()
    {
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
        } else
        {
            return false;
        }
    }

    private boolean moveFile(File file, File file1)
    {
        try
        {
            FileChannel filechannel = (new FileInputStream(file)).getChannel();
            file1.createNewFile();
            FileChannel filechannel1 = (new FileOutputStream(file1)).getChannel();
            filechannel.transferTo(0L, filechannel.size(), filechannel1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    private static Bitmap resizeImage(Bitmap bitmap, int i, int j, int k)
    {
        return Bitmap.createScaledBitmap(bitmap, i, j, true);
    }

    static Bitmap resizeImage(Bitmap bitmap, String s, int i, int j, int k)
    {
        float f = (float)i / (float)bitmap.getWidth();
        float f1 = (float)j / (float)bitmap.getHeight();
        if (s.equals("Center"))
        {
            return centerOfImage(bitmap, i, j);
        }
        if (s.equals("ScaleToAspectFit"))
        {
            float f3 = Math.min(f, f1);
            return resizeImage(bitmap, (int)(f3 * (float)bitmap.getWidth()), (int)(f3 * (float)bitmap.getHeight()), k);
        }
        if (s.equals("ScaleToAspectFill"))
        {
            float f2 = Math.max(f, f1);
            return cropImage(resizeImage(bitmap, (int)(f2 * (float)bitmap.getWidth()), (int)(f2 * (float)bitmap.getHeight()), k), 0, 0, i, j);
        } else
        {
            return resizeImage(bitmap, i, j, k);
        }
    }

    private static final byte[] scaleBitmapToBytes(File file, int i, int j, String s)
    {
        FileInputStream fileinputstream = new FileInputStream(file);
        android.graphics.BitmapFactory.Options options;
        int k;
        int l;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileinputstream, null, options);
        k = options.outHeight;
        l = options.outWidth;
        if (k <= j && l <= i)
        {
            break MISSING_BLOCK_LABEL_495;
        }
        if (l <= k) goto _L2; else goto _L1
_L1:
        int i1 = Math.round((float)k / (float)j);
_L7:
        FileInputStream fileinputstream1 = new FileInputStream(file);
        Bitmap bitmap2;
        options.inJustDecodeBounds = false;
        options.inSampleSize = i1;
        bitmap2 = BitmapFactory.decodeStream(fileinputstream1, null, options);
        Bitmap bitmap = bitmap2;
        FileNotFoundException filenotfoundexception;
        IOException ioexception;
        byte abyte0[];
        Bitmap bitmap1;
        ByteArrayOutputStream bytearrayoutputstream;
        Exception exception;
        Exception exception1;
        Exception exception2;
        Exception exception3;
        byte abyte1[];
        Exception exception4;
        Exception exception5;
        Exception exception6;
        Exception exception7;
        IOException ioexception1;
        FileNotFoundException filenotfoundexception1;
        float f;
        int j1;
        Exception exception8;
        FileNotFoundException filenotfoundexception2;
        try
        {
            fileinputstream.close();
            fileinputstream1.close();
        }
        catch (IOException ioexception2) { }
        abyte0 = null;
        if (bitmap == null) goto _L4; else goto _L3
_L3:
        bitmap1 = resizeImage(bitmap, s, i, j, 1);
        bytearrayoutputstream = new ByteArrayOutputStream();
        if (!s.equals("")) goto _L6; else goto _L5
_L5:
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
_L8:
        abyte1 = bytearrayoutputstream.toByteArray();
        abyte0 = abyte1;
        if (bitmap != null)
        {
            try
            {
                bitmap.recycle();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception4)
            {
                exception4.printStackTrace();
                return abyte0;
            }
        }
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        bitmap1.recycle();
        bytearrayoutputstream.close();
_L4:
        return abyte0;
_L2:
        f = (float)l / (float)i;
        j1 = Math.round(f);
        i1 = j1;
          goto _L7
        filenotfoundexception2;
        fileinputstream1 = null;
        fileinputstream = null;
_L14:
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_254;
        }
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            bitmap = null;
            break MISSING_BLOCK_LABEL_125;
        }
        if (fileinputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        fileinputstream1.close();
        bitmap = null;
        break MISSING_BLOCK_LABEL_125;
        exception8;
        fileinputstream = null;
        exception7 = exception8;
        fileinputstream1 = null;
_L13:
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        fileinputstream.close();
        if (fileinputstream1 != null)
        {
            try
            {
                fileinputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception1) { }
        }
        throw exception7;
_L6:
        bitmap1.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
          goto _L8
        exception2;
_L12:
        exception2.printStackTrace();
        if (bitmap != null)
        {
            try
            {
                bitmap.recycle();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception3)
            {
                exception3.printStackTrace();
                return null;
            }
        }
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        bitmap1.recycle();
        abyte0 = null;
        if (bytearrayoutputstream == null) goto _L4; else goto _L9
_L9:
        bytearrayoutputstream.close();
        return null;
        exception5;
        bytearrayoutputstream = null;
        exception = exception5;
_L11:
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        bitmap.recycle();
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_419;
        }
        bitmap1.recycle();
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
        }
        throw exception;
        exception;
        if (true) goto _L11; else goto _L10
_L10:
        exception2;
        bytearrayoutputstream = null;
          goto _L12
        exception6;
        exception7 = exception6;
        fileinputstream1 = null;
          goto _L13
        exception7;
          goto _L13
        filenotfoundexception;
        fileinputstream1 = null;
          goto _L14
        filenotfoundexception1;
          goto _L14
        i1 = 1;
          goto _L7
    }

    private void scanMedia(final String path)
    {
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            mediaScanner = new MediaScannerConnection(context.getApplicationContext(), new _cls1());
            if (mediaScanner != null)
            {
                mediaScanner.connect();
            }
        }
    }

    public MMJSResponse availableSourceTypes(HashMap hashmap)
    {
        JSONArray jsonarray = new JSONArray();
        if (isCameraAvailable())
        {
            jsonarray.put("Camera");
        }
        if (isPictureChooserAvailable())
        {
            jsonarray.put("Photo Library");
        }
        MMJSResponse mmjsresponse = new MMJSResponse();
        mmjsresponse.result = 1;
        mmjsresponse.response = jsonarray;
        return mmjsresponse;
    }

    public MMJSResponse getPicture(HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        Context context;
        String s;
        String s1;
        String s2;
        String s3;
        context = (Context)contextRef.get();
        s = (String)hashmap.get("sourceType");
        s1 = (String)hashmap.get("constrainHeight");
        s2 = (String)hashmap.get("constrainWidth");
        s3 = (String)hashmap.get("contentMode");
        if (s3 == null)
        {
            s3 = "";
        }
          goto _L1
_L4:
        MMJSResponse mmjsresponse = MMJSResponse.responseWithError("Missing constrainHeight and/or constrainWidth");
        MMJSResponse mmjsresponse1 = mmjsresponse;
_L2:
        this;
        JVM INSTR monitorexit ;
        return mmjsresponse1;
_L5:
        int i;
        int j;
        i = (int)Float.parseFloat(s1);
        j = (int)Float.parseFloat(s2);
        if (i * j <= 0x57e40)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        mmjsresponse1 = MMJSResponse.responseWithError("constrainHeight * constrainWidth > 360000");
          goto _L2
        if (context == null || s == null)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        File file;
        boolean flag;
        file = new File(AdCache.getCacheDirectory(context), (new StringBuilder("tmp_mm_")).append(String.valueOf(System.currentTimeMillis())).append(".jpg").toString());
        if (s.equalsIgnoreCase("Camera") && isCameraAvailable())
        {
            break MISSING_BLOCK_LABEL_229;
        }
        if (!s.equalsIgnoreCase("Photo Library") && !s.equalsIgnoreCase("PhotoLibrary"))
        {
            break MISSING_BLOCK_LABEL_370;
        }
        flag = isPictureChooserAvailable();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        Object obj = new Object();
        pickerActivityObject = obj;
        obj;
        JVM INSTR monitorenter ;
        Utils.IntentUtils.startPickerActivity(context, file, s);
        pickerActivityObject.wait();
        obj;
        JVM INSTR monitorexit ;
        pickerActivityObject = null;
_L3:
        byte abyte0[];
        if (!file.exists() || file.length() <= 0L)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        abyte0 = scaleBitmapToBytes(file, j, i, s3);
        file.delete();
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        mmjsresponse1 = new MMJSResponse();
        mmjsresponse1.result = 1;
        mmjsresponse1.dataResponse = abyte0;
          goto _L2
        Exception exception;
        exception;
        throw exception;
        Exception exception3;
        exception3;
        obj;
        JVM INSTR monitorexit ;
        throw exception3;
        Exception exception2;
        exception2;
        exception2.printStackTrace();
        pickerActivityObject = null;
          goto _L3
        Exception exception1;
        exception1;
        pickerActivityObject = null;
        throw exception1;
        mmjsresponse1 = null;
          goto _L2
_L1:
        if (s1 != null && s2 != null) goto _L5; else goto _L4
    }

    public MMJSResponse isSourceTypeAvailable(HashMap hashmap)
    {
        String s = (String)hashmap.get("sourceType");
        if (s != null)
        {
            if (s.equalsIgnoreCase("Camera") && isCameraAvailable())
            {
                return MMJSResponse.responseWithSuccess("true");
            }
            if (s.equalsIgnoreCase("Photo Library") && isPictureChooserAvailable())
            {
                return MMJSResponse.responseWithSuccess("true");
            }
        }
        return MMJSResponse.responseWithError("false");
    }

    public MMJSResponse playAudio(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("path");
        if (context != null && s != null)
        {
            if (Audio.sharedAudio(context).isPlaying())
            {
                return MMJSResponse.responseWithError("Audio already playing.");
            }
            if (s.startsWith("http"))
            {
                return Audio.sharedAudio(context).playAudio(Uri.parse(s), Boolean.parseBoolean((String)hashmap.get("repeat")));
            }
            File file = AdCache.getDownloadFile(context, s);
            if (file.exists())
            {
                return Audio.sharedAudio(context).playAudio(Uri.fromFile(file), Boolean.parseBoolean((String)hashmap.get("repeat")));
            }
        }
        return null;
    }

    public MMJSResponse playSound(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("path");
        if (context != null && s != null)
        {
            File file = AdCache.getDownloadFile(context, s);
            if (file.exists())
            {
                return Audio.sharedAudio((Context)contextRef.get()).playSound(file);
            }
        }
        return null;
    }

    public MMJSResponse playVideo(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("path");
        if (context != null && s != null)
        {
            if (s.startsWith("http"))
            {
                Utils.IntentUtils.startVideoPlayerActivityWithData(context, s);
                return MMJSResponse.responseWithSuccess(s);
            }
            File file = AdCache.getDownloadFile(context, s);
            if (file.exists())
            {
                Utils.IntentUtils.startVideoPlayerActivityWithData(context, file);
                return MMJSResponse.responseWithSuccess(file.getName());
            }
        }
        return null;
    }

    public MMJSResponse stopAudio(HashMap hashmap)
    {
        return Audio.sharedAudio((Context)contextRef.get()).stop();
    }

    public MMJSResponse writeToPhotoLibrary(HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        Context context;
        Uri uri;
        File file;
        String s;
        context = (Context)contextRef.get();
        uri = Uri.parse((String)hashmap.get("path"));
        file = new File((new StringBuilder()).append(AdCache.getCacheDirectory(context).getAbsolutePath()).append(File.separator).append("Pictures").append(File.separator).append(uri.getLastPathSegment()).toString());
        s = uri.getScheme();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.equals("http")) goto _L2; else goto _L3
_L3:
        BridgeMMFileManager bridgemmfilemanager;
        hashmap.put("url", uri.toString());
        hashmap.put("path", uri.getLastPathSegment());
        bridgemmfilemanager = new BridgeMMFileManager();
        bridgemmfilemanager.setContext(context);
        if (bridgemmfilemanager.downloadFile(hashmap) != null) goto _L2; else goto _L4
_L4:
        MMJSResponse mmjsresponse1 = MMJSResponse.responseWithError("Failed to download");
        MMJSResponse mmjsresponse = mmjsresponse1;
_L10:
        this;
        JVM INSTR monitorexit ;
        return mmjsresponse;
_L2:
        File file1;
        file1 = AdCache.getDownloadFile(context, uri.getLastPathSegment());
        if (!file1.exists())
        {
            mmjsresponse = MMJSResponse.responseWithError((new StringBuilder("No file at ")).append(file1.getAbsolutePath()).toString());
            continue; /* Loop/switch isn't completed */
        }
        if (!moveFile(file1, file)) goto _L6; else goto _L5
_L5:
        String s2 = file.getAbsolutePath();
_L8:
        scanMedia(s2);
        mmjsresponse = MMJSResponse.responseWithSuccess("Image saved to photo library");
        continue; /* Loop/switch isn't completed */
_L6:
        String s1 = file1.getAbsolutePath();
        s2 = s1;
        if (true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
        throw exception;
        if (true) goto _L10; else goto _L9
_L9:
    }


    private class _cls1
        implements android.media.MediaScannerConnection.MediaScannerConnectionClient
    {

        final BridgeMMMedia this$0;
        final String val$path;

        public void onMediaScannerConnected()
        {
            if (mediaScanner != null)
            {
                mediaScanner.scanFile(path, null);
            }
        }

        public void onScanCompleted(String s, Uri uri)
        {
            if (uri == null)
            {
                MMSDK.Log.d((new StringBuilder("Failed to scan ")).append(s).toString());
            }
        }

        _cls1()
        {
            this$0 = BridgeMMMedia.this;
            path = s;
            super();
        }
    }


    private class Audio
    {

        private static final int MAX_SOUNDS = 4;
        private static Audio sharedInstance;
        private OnLoadCompleteListener completionListener;
        private WeakReference contextRef;
        private MediaPlayer mediaPlayer;
        private SoundPool soundPool;

        static Audio sharedAudio(Context context)
        {
            com/millennialmedia/android/BridgeMMMedia$Audio;
            JVM INSTR monitorenter ;
            Audio audio;
            if (sharedInstance == null)
            {
                sharedInstance = new Audio(context);
            }
            audio = sharedInstance;
            com/millennialmedia/android/BridgeMMMedia$Audio;
            JVM INSTR monitorexit ;
            return audio;
            Exception exception;
            exception;
            throw exception;
        }

        boolean isPlaying()
        {
            this;
            JVM INSTR monitorenter ;
            if (mediaPlayer == null) goto _L2; else goto _L1
_L1:
            boolean flag1 = mediaPlayer.isPlaying();
            if (!flag1) goto _L2; else goto _L3
_L3:
            boolean flag = true;
_L5:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            flag = false;
            if (true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            throw exception;
        }

        MMJSResponse playAudio(Uri uri, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (mediaPlayer != null)
            {
                mediaPlayer.release();
                mediaPlayer = null;
            }
            mediaPlayer = MediaPlayer.create((Context)contextRef.get(), uri);
            mediaPlayer.setLooping(flag);
            mediaPlayer.start();
            class _cls1
                implements android.media.MediaPlayer.OnCompletionListener
            {

                final Audio this$0;

                public void onCompletion(MediaPlayer mediaplayer)
                {
                    this;
                    JVM INSTR monitorenter ;
                    if (mediaPlayer != null)
                    {
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    this;
                    JVM INSTR monitorexit ;
                    return;
                    Exception exception2;
                    exception2;
                    throw exception2;
                }

                _cls1()
                {
                    this$0 = Audio.this;
                    super();
                }
            }

            mediaPlayer.setOnCompletionListener(new _cls1());
_L1:
            MMJSResponse mmjsresponse = MMJSResponse.responseWithSuccess("Audio playback started");
            this;
            JVM INSTR monitorexit ;
            return mmjsresponse;
            Exception exception1;
            exception1;
            MMSDK.Log.e(exception1.getCause());
              goto _L1
            Exception exception;
            exception;
            throw exception;
        }

        MMJSResponse playSound(File file)
        {
            this;
            JVM INSTR monitorenter ;
            Exception exception1;
            MMJSResponse mmjsresponse;
            try
            {
                if (soundPool == null)
                {
                    soundPool = new SoundPool(4, 3, 0);
                    class _cls2 extends OnLoadCompleteListener
                    {

                        final Audio this$0;

                        public void onLoadComplete(SoundPool soundpool, int i, int j)
                        {
                            this;
                            JVM INSTR monitorenter ;
                            if (soundpool == null)
                            {
                                break MISSING_BLOCK_LABEL_61;
                            }
                            AudioManager audiomanager = (AudioManager)((Context)contextRef.get()).getSystemService("audio");
                            float f = (0.0F + (float)audiomanager.getStreamVolume(3)) / (float)audiomanager.getStreamMaxVolume(3);
                            soundpool.play(i, f, f, 1, 0, 1.0F);
                            this;
                            JVM INSTR monitorexit ;
                            return;
                            Exception exception2;
                            exception2;
                            throw exception2;
                        }

                _cls2(SoundPool soundpool)
                {
                    this$0 = Audio.this;
                    class OnLoadCompleteListener
                    {

                        private static final int TEST_PERIOD_MS = 100;
                        private ArrayList sampleIds;
                        private SoundPool soundPool;
                        final Audio this$0;
                        private Timer timer;

                        abstract void onLoadComplete(SoundPool soundpool1, int i, int j);

                        void release()
                        {
                            this;
                            JVM INSTR monitorenter ;
                            if (timer != null)
                            {
                                timer.cancel();
                                timer.purge();
                            }
                            this;
                            JVM INSTR monitorexit ;
                            return;
                            Exception exception;
                            exception;
                            throw exception;
                        }

                        void testSample(int i)
                        {
                            this;
                            JVM INSTR monitorenter ;
                            sampleIds.add(Integer.valueOf(i));
                            if (sampleIds.size() == 1)
                            {
                                timer = new Timer();
                                class _cls1 extends TimerTask
                                {

                                    final OnLoadCompleteListener this$1;

                                    public void run()
                                    {
                                        ArrayList arraylist = new ArrayList();
                                        Iterator iterator = sampleIds.iterator();
                                        do
                                        {
                                            if (!iterator.hasNext())
                                            {
                                                break;
                                            }
                                            Integer integer = (Integer)iterator.next();
                                            int j = soundPool.play(integer.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                                            if (j != 0)
                                            {
                                                soundPool.stop(j);
                                                onLoadComplete(soundPool, integer.intValue(), 0);
                                                arraylist.add(integer);
                                            }
                                        } while (true);
                                        sampleIds.removeAll(arraylist);
                                        if (sampleIds.size() == 0)
                                        {
                                            timer.cancel();
                                            timer.purge();
                                        }
                                    }

                                    _cls1()
                                    {
                                        this$1 = OnLoadCompleteListener.this;
                                        super();
                                    }
                                }

                                timer.scheduleAtFixedRate(new _cls1(), 0L, 100L);
                            }
                            this;
                            JVM INSTR monitorexit ;
                            return;
                            Exception exception;
                            exception;
                            throw exception;
                        }




                            public OnLoadCompleteListener(SoundPool soundpool)
                            {
                                this$0 = Audio.this;
                                super();
                                sampleIds = new ArrayList();
                                soundPool = soundpool;
                            }
                    }

                    super(soundpool);
                }
                    }

                    completionListener = new _cls2(soundPool);
                }
                completionListener.testSample(soundPool.load(file.getAbsolutePath(), 1));
            }
            catch (Exception exception) { }
            mmjsresponse = MMJSResponse.responseWithSuccess("Sound playback started");
            this;
            JVM INSTR monitorexit ;
            return mmjsresponse;
            exception1;
            throw exception1;
        }

        MMJSResponse stop()
        {
            this;
            JVM INSTR monitorenter ;
            MMJSResponse mmjsresponse;
            if (mediaPlayer != null)
            {
                mediaPlayer.release();
                mediaPlayer = null;
            }
            if (soundPool != null)
            {
                soundPool.release();
                soundPool = null;
            }
            if (completionListener != null)
            {
                completionListener.release();
                completionListener = null;
            }
            mmjsresponse = MMJSResponse.responseWithSuccess("Audio stopped");
            this;
            JVM INSTR monitorexit ;
            return mmjsresponse;
            Exception exception;
            exception;
            throw exception;
        }



/*
        static MediaPlayer access$102(Audio audio, MediaPlayer mediaplayer)
        {
            audio.mediaPlayer = mediaplayer;
            return mediaplayer;
        }

*/


        private Audio()
        {
        }

        private Audio(Context context)
        {
            contextRef = new WeakReference(context.getApplicationContext());
        }
    }

}
