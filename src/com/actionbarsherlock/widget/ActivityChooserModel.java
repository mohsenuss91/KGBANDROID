// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.Handler;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class ActivityChooserModel extends DataSetObservable
{

    private static final String ATTRIBUTE_ACTIVITY = "activity";
    private static final String ATTRIBUTE_TIME = "time";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1F;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = com/actionbarsherlock/widget/ActivityChooserModel.getSimpleName();
    private static final Executor SERIAL_EXECUTOR = Executors.newSingleThreadExecutor();
    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map sDataModelRegistry = new HashMap();
    private static final Object sRegistryLock = new Object();
    private final List mActivites = new ArrayList();
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    private boolean mCanReadHistoricalData;
    private final Context mContext;
    private final Handler mHandler = new Handler();
    private final List mHistoricalRecords = new ArrayList();
    private boolean mHistoricalRecordsChanged;
    private final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock = new Object();
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;

    private ActivityChooserModel(Context context, String s)
    {
        mActivitySorter = new DefaultSorter(null);
        mHistoryMaxSize = 50;
        mCanReadHistoricalData = true;
        mReadShareHistoryCalled = false;
        mHistoricalRecordsChanged = true;
        mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(s) && !s.endsWith(".xml"))
        {
            mHistoryFileName = (new StringBuilder()).append(s).append(".xml").toString();
            return;
        } else
        {
            mHistoryFileName = s;
            return;
        }
    }

    private boolean addHisoricalRecord(HistoricalRecord historicalrecord)
    {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = mHistoricalRecords.add(historicalrecord);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsLocked();
        persistHistoricalData();
        sortActivities();
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static ActivityChooserModel get(Context context, String s)
    {
        Object obj = sRegistryLock;
        obj;
        JVM INSTR monitorenter ;
        ActivityChooserModel activitychoosermodel = (ActivityChooserModel)sDataModelRegistry.get(s);
        if (activitychoosermodel != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        activitychoosermodel = new ActivityChooserModel(context, s);
        sDataModelRegistry.put(s, activitychoosermodel);
        activitychoosermodel.readHistoricalData();
        obj;
        JVM INSTR monitorexit ;
        return activitychoosermodel;
        Exception exception;
        exception;
        throw exception;
    }

    private void loadActivitiesLocked()
    {
        mActivites.clear();
        if (mIntent != null)
        {
            List list = mContext.getPackageManager().queryIntentActivities(mIntent, 0);
            int i = list.size();
            for (int j = 0; j < i; j++)
            {
                ResolveInfo resolveinfo = (ResolveInfo)list.get(j);
                mActivites.add(new ActivityResolveInfo(resolveinfo));
            }

            sortActivities();
            return;
        } else
        {
            notifyChanged();
            return;
        }
    }

    private void persistHistoricalData()
    {
        synchronized (mInstanceLock)
        {
            if (!mReadShareHistoryCalled)
            {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
            break MISSING_BLOCK_LABEL_29;
        }
        if (mHistoricalRecordsChanged)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        mHistoricalRecordsChanged = false;
        mCanReadHistoricalData = true;
        if (!TextUtils.isEmpty(mHistoryFileName))
        {
            SERIAL_EXECUTOR.execute(new HistoryPersister(null));
        }
        obj;
        JVM INSTR monitorexit ;
    }

    private void pruneExcessiveHistoricalRecordsLocked()
    {
        List list = mHistoricalRecords;
        int i = list.size() - mHistoryMaxSize;
        if (i > 0)
        {
            mHistoricalRecordsChanged = true;
            int j = 0;
            while (j < i) 
            {
                list.remove(0);
                j++;
            }
        }
    }

    private void readHistoricalData()
    {
label0:
        {
            synchronized (mInstanceLock)
            {
                if (mCanReadHistoricalData && mHistoricalRecordsChanged)
                {
                    break label0;
                }
            }
            return;
        }
        mCanReadHistoricalData = false;
        mReadShareHistoryCalled = true;
        if (!TextUtils.isEmpty(mHistoryFileName))
        {
            SERIAL_EXECUTOR.execute(new HistoryLoader(null));
        }
        obj;
        JVM INSTR monitorexit ;
    }

    private void sortActivities()
    {
        synchronized (mInstanceLock)
        {
            if (mActivitySorter != null && !mActivites.isEmpty())
            {
                mActivitySorter.sort(mIntent, mActivites, Collections.unmodifiableList(mHistoricalRecords));
                notifyChanged();
            }
        }
    }

    public Intent chooseActivity(int i)
    {
        ActivityResolveInfo activityresolveinfo = (ActivityResolveInfo)mActivites.get(i);
        ComponentName componentname = new ComponentName(activityresolveinfo.resolveInfo.activityInfo.packageName, activityresolveinfo.resolveInfo.activityInfo.name);
        Intent intent = new Intent(mIntent);
        intent.setComponent(componentname);
        if (mActivityChoserModelPolicy != null)
        {
            Intent intent1 = new Intent(intent);
            if (mActivityChoserModelPolicy.onChooseActivity(this, intent1))
            {
                return null;
            }
        }
        addHisoricalRecord(new HistoricalRecord(componentname, System.currentTimeMillis(), 1.0F));
        return intent;
    }

    public ResolveInfo getActivity(int i)
    {
        ResolveInfo resolveinfo;
        synchronized (mInstanceLock)
        {
            resolveinfo = ((ActivityResolveInfo)mActivites.get(i)).resolveInfo;
        }
        return resolveinfo;
    }

    public int getActivityCount()
    {
        int i;
        synchronized (mInstanceLock)
        {
            i = mActivites.size();
        }
        return i;
    }

    public int getActivityIndex(ResolveInfo resolveinfo)
    {
        List list = mActivites;
        int i = list.size();
        for (int j = 0; j < i; j++)
        {
            if (((ActivityResolveInfo)list.get(j)).resolveInfo == resolveinfo)
            {
                return j;
            }
        }

        return -1;
    }

    public ResolveInfo getDefaultActivity()
    {
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        ResolveInfo resolveinfo;
        if (mActivites.isEmpty())
        {
            break MISSING_BLOCK_LABEL_40;
        }
        resolveinfo = ((ActivityResolveInfo)mActivites.get(0)).resolveInfo;
        return resolveinfo;
        obj;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        throw exception;
    }

    public int getHistoryMaxSize()
    {
        int i;
        synchronized (mInstanceLock)
        {
            i = mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize()
    {
        int i;
        synchronized (mInstanceLock)
        {
            i = mHistoricalRecords.size();
        }
        return i;
    }

    public Intent getIntent()
    {
        Intent intent;
        synchronized (mInstanceLock)
        {
            intent = mIntent;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitysorter)
    {
label0:
        {
            synchronized (mInstanceLock)
            {
                if (mActivitySorter != activitysorter)
                {
                    break label0;
                }
            }
            return;
        }
        mActivitySorter = activitysorter;
        sortActivities();
        obj;
        JVM INSTR monitorexit ;
    }

    public void setDefaultActivity(int i)
    {
        ActivityResolveInfo activityresolveinfo = (ActivityResolveInfo)mActivites.get(i);
        ActivityResolveInfo activityresolveinfo1 = (ActivityResolveInfo)mActivites.get(0);
        float f;
        if (activityresolveinfo1 != null)
        {
            f = 5F + (activityresolveinfo1.weight - activityresolveinfo.weight);
        } else
        {
            f = 1.0F;
        }
        addHisoricalRecord(new HistoricalRecord(new ComponentName(activityresolveinfo.resolveInfo.activityInfo.packageName, activityresolveinfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
    }

    public void setHistoryMaxSize(int i)
    {
label0:
        {
            synchronized (mInstanceLock)
            {
                if (mHistoryMaxSize != i)
                {
                    break label0;
                }
            }
            return;
        }
        mHistoryMaxSize = i;
        pruneExcessiveHistoricalRecordsLocked();
        sortActivities();
        obj;
        JVM INSTR monitorexit ;
    }

    public void setIntent(Intent intent)
    {
label0:
        {
            synchronized (mInstanceLock)
            {
                if (mIntent != intent)
                {
                    break label0;
                }
            }
            return;
        }
        mIntent = intent;
        loadActivitiesLocked();
        obj;
        JVM INSTR monitorexit ;
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onchooseactivitylistener)
    {
        mActivityChoserModelPolicy = onchooseactivitylistener;
    }









/*
    static boolean access$702(ActivityChooserModel activitychoosermodel, boolean flag)
    {
        activitychoosermodel.mHistoricalRecordsChanged = flag;
        return flag;
    }

*/



    private class DefaultSorter
        implements ActivitySorter
    {

        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
        private final Map mPackageNameToActivityMap;
        final ActivityChooserModel this$0;

        public final void sort(Intent intent, List list, List list1)
        {
            Map map = mPackageNameToActivityMap;
            map.clear();
            int i = list.size();
            for (int j = 0; j < i; j++)
            {
                ActivityResolveInfo activityresolveinfo1 = (ActivityResolveInfo)list.get(j);
                activityresolveinfo1.weight = 0.0F;
                map.put(activityresolveinfo1.resolveInfo.activityInfo.packageName, activityresolveinfo1);
            }

            int k = -1 + list1.size();
            float f = 1.0F;
            int l = k;
            while (l >= 0) 
            {
                HistoricalRecord historicalrecord = (HistoricalRecord)list1.get(l);
                ActivityResolveInfo activityresolveinfo = (ActivityResolveInfo)map.get(historicalrecord.activity.getPackageName());
                float f1;
                if (activityresolveinfo != null)
                {
                    activityresolveinfo.weight = activityresolveinfo.weight + f * historicalrecord.weight;
                    f1 = 0.95F * f;
                } else
                {
                    f1 = f;
                }
                l--;
                f = f1;
            }
            Collections.sort(list);
        }

        private DefaultSorter()
        {
            this$0 = ActivityChooserModel.this;
            super();
            mPackageNameToActivityMap = new HashMap();
        }

        DefaultSorter(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ActivityResolveInfo
        implements Comparable
    {

        public final ResolveInfo resolveInfo;
        final ActivityChooserModel this$0;
        public float weight;

        public final int compareTo(ActivityResolveInfo activityresolveinfo)
        {
            return Float.floatToIntBits(activityresolveinfo.weight) - Float.floatToIntBits(weight);
        }

        public final volatile int compareTo(Object obj)
        {
            return compareTo((ActivityResolveInfo)obj);
        }

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                ActivityResolveInfo activityresolveinfo = (ActivityResolveInfo)obj;
                if (Float.floatToIntBits(weight) != Float.floatToIntBits(activityresolveinfo.weight))
                {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode()
        {
            return 31 + Float.floatToIntBits(weight);
        }

        public final String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("[");
            stringbuilder.append("resolveInfo:").append(resolveInfo.toString());
            stringbuilder.append("; weight:").append(new BigDecimal(weight));
            stringbuilder.append("]");
            return stringbuilder.toString();
        }

        public ActivityResolveInfo(ResolveInfo resolveinfo)
        {
            this$0 = ActivityChooserModel.this;
            super();
            resolveInfo = resolveinfo;
        }
    }


    private class HistoryPersister
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
            synchronized (mInstanceLock)
            {
                arraylist = new ArrayList(mHistoricalRecords);
            }
            fileoutputstream = mContext.openFileOutput(mHistoryFileName, 0);
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
            HistoricalRecord historicalrecord = (HistoricalRecord)arraylist.remove(0);
            xmlserializer.startTag(null, "historical-record");
            xmlserializer.attribute(null, "activity", historicalrecord.activity.flattenToString());
            xmlserializer.attribute(null, "time", String.valueOf(historicalrecord.time));
            xmlserializer.attribute(null, "weight", String.valueOf(historicalrecord.weight));
            xmlserializer.endTag(null, "historical-record");
            j++;
            if (true) goto _L2; else goto _L1
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder("Error writing historical recrod file: ")).append(mHistoryFileName).toString(), filenotfoundexception);
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
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder("Error writing historical recrod file: ")).append(mHistoryFileName).toString(), illegalargumentexception);
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
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder("Error writing historical recrod file: ")).append(mHistoryFileName).toString(), illegalstateexception);
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
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder("Error writing historical recrod file: ")).append(mHistoryFileName).toString(), ioexception1);
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

        private HistoryPersister()
        {
            this$0 = ActivityChooserModel.this;
            super();
        }

        HistoryPersister(_cls1 _pcls1)
        {
            this();
        }
    }


    private class HistoryLoader
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
                fileinputstream = mContext.openFileInput(mHistoryFileName);
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
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder("Error reading historical recrod file: ")).append(mHistoryFileName).toString(), xmlpullparserexception);
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
            Log.e(ActivityChooserModel.LOG_TAG, (new StringBuilder("Error reading historical recrod file: ")).append(mHistoryFileName).toString(), ioexception1);
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
            arraylist.add(new HistoricalRecord(xmlpullparser.getAttributeValue(null, "activity"), Long.parseLong(xmlpullparser.getAttributeValue(null, "time")), Float.parseFloat(xmlpullparser.getAttributeValue(null, "weight"))));
              goto _L4
            exception;
            class _cls1
                implements Runnable
            {

                final HistoryLoader this$1;

                public void run()
                {
                    pruneExcessiveHistoricalRecordsLocked();
                    sortActivities();
                }

                _cls1()
                {
                    this$1 = HistoryLoader.this;
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
            obj = mInstanceLock;
            obj;
            JVM INSTR monitorenter ;
            linkedhashset = new LinkedHashSet(arraylist);
            list = mHistoricalRecords;
            k = -1 + list.size();
_L8:
            if (k < 0)
            {
                break; /* Loop/switch isn't completed */
            }
            linkedhashset.add((HistoricalRecord)list.get(k));
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
            mHistoricalRecordsChanged = true;
            mHandler.post(new _cls1());
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

        private HistoryLoader()
        {
            this$0 = ActivityChooserModel.this;
            super();
        }

        HistoryLoader(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ActivitySorter
    {

        public abstract void sort(Intent intent, List list, List list1);
    }


    private class OnChooseActivityListener
    {

        public abstract boolean onChooseActivity(ActivityChooserModel activitychoosermodel, Intent intent);
    }


    private class HistoricalRecord
    {

        public final ComponentName activity;
        public final long time;
        public final float weight;

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                HistoricalRecord historicalrecord = (HistoricalRecord)obj;
                if (activity == null)
                {
                    if (historicalrecord.activity != null)
                    {
                        return false;
                    }
                } else
                if (!activity.equals(historicalrecord.activity))
                {
                    return false;
                }
                if (time != historicalrecord.time)
                {
                    return false;
                }
                if (Float.floatToIntBits(weight) != Float.floatToIntBits(historicalrecord.weight))
                {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode()
        {
            int i;
            if (activity == null)
            {
                i = 0;
            } else
            {
                i = activity.hashCode();
            }
            return 31 * (31 * (i + 31) + (int)(time ^ time >>> 32)) + Float.floatToIntBits(weight);
        }

        public final String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("[");
            stringbuilder.append("; activity:").append(activity);
            stringbuilder.append("; time:").append(time);
            stringbuilder.append("; weight:").append(new BigDecimal(weight));
            stringbuilder.append("]");
            return stringbuilder.toString();
        }

        public HistoricalRecord(ComponentName componentname, long l, float f)
        {
            activity = componentname;
            time = l;
            weight = f;
        }

        public HistoricalRecord(String s, long l, float f)
        {
            this(ComponentName.unflattenFromString(s), l, f);
        }
    }

}
