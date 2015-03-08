// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.io.File;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidAbstractController, MraidView, MraidScreenSizeProperty, MraidStateProperty, 
//            Mraids, MraidViewableProperty, MraidSupportsProperty, Drawables, 
//            MraidVideoPlayerActivity

class MraidDisplayController extends MraidAbstractController
{

    private static final int CLOSE_BUTTON_SIZE_DP = 50;
    private static final String DATE_FORMATS[] = {
        "yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"
    };
    private static final String LOGTAG = "MraidDisplayController";
    private static final int MAX_NUMBER_DAYS_IN_MONTH = 31;
    private static final long VIEWABILITY_TIMER_MILLIS = 3000L;
    private FrameLayout mAdContainerLayout;
    private boolean mAdWantsCustomCloseButton;
    private Runnable mCheckViewabilityTask;
    private ImageView mCloseButton;
    protected float mDensity;
    private RelativeLayout mExpansionLayout;
    private final MraidView.ExpansionStyle mExpansionStyle;
    private Handler mHandler;
    private boolean mIsViewable;
    private final MraidView.NativeCloseButtonStyle mNativeCloseButtonStyle;
    private OrientationBroadcastReceiver mOrientationBroadcastReceiver;
    private final int mOriginalRequestedOrientation;
    private FrameLayout mPlaceholderView;
    private FrameLayout mRootView;
    protected int mScreenHeight;
    protected int mScreenWidth;
    private MraidView mTwoPartExpansionView;
    private int mViewIndexInParent;
    private MraidView.ViewState mViewState;

    MraidDisplayController(MraidView mraidview, MraidView.ExpansionStyle expansionstyle, MraidView.NativeCloseButtonStyle nativeclosebuttonstyle)
    {
        super(mraidview);
        mViewState = MraidView.ViewState.HIDDEN;
        mCheckViewabilityTask = new _cls1();
        mHandler = new Handler();
        mOrientationBroadcastReceiver = new OrientationBroadcastReceiver();
        mScreenWidth = -1;
        mScreenHeight = -1;
        mExpansionStyle = expansionstyle;
        mNativeCloseButtonStyle = nativeclosebuttonstyle;
        Context context = getContext();
        int i;
        if (context instanceof Activity)
        {
            i = ((Activity)context).getRequestedOrientation();
        } else
        {
            i = -1;
        }
        mOriginalRequestedOrientation = i;
        mAdContainerLayout = createAdContainerLayout();
        mExpansionLayout = createExpansionLayout();
        mPlaceholderView = createPlaceholderView();
        initialize();
    }

    private String dayNumberToDayOfMonthString(int i)
    {
        if (i != 0 && i >= -31 && i <= 31)
        {
            return (new StringBuilder()).append(i).toString();
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid day of month ")).append(i).toString());
        }
    }

    private String dayNumberToDayOfWeekString(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("invalid day of week ")).append(i).toString());

        case 0: // '\0'
            return "SU";

        case 1: // '\001'
            return "MO";

        case 2: // '\002'
            return "TU";

        case 3: // '\003'
            return "WE";

        case 4: // '\004'
            return "TH";

        case 5: // '\005'
            return "FR";

        case 6: // '\006'
            return "SA";
        }
    }

    private void downloadImage(final String uriString)
    {
        final File pictureStoragePath = getPictureStoragePath();
        pictureStoragePath.mkdirs();
        (new Thread(new _cls4())).start();
    }

    private void expandLayouts(View view, int i, int j)
    {
        int k = (int)(0.5F + 50F * mDensity);
        if (i < k)
        {
            i = k;
        }
        if (j < k)
        {
            j = k;
        }
        View view1 = new View(getContext());
        view1.setBackgroundColor(0);
        view1.setOnTouchListener(new _cls6());
        mExpansionLayout.addView(view1, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        mAdContainerLayout.addView(view, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i, j);
        layoutparams.addRule(13);
        mExpansionLayout.addView(mAdContainerLayout, layoutparams);
    }

    private Context getContext()
    {
        return getMraidView().getContext();
    }

    private int getDisplayRotation()
    {
        return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    private String getFileNameForUriAndHttpResponse(URI uri, HttpResponse httpresponse)
    {
        String s = uri.getPath();
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        String as[];
        int i;
        int j;
        s1 = (new File(s)).getName();
        Header header = httpresponse.getFirstHeader("Content-Type");
        if (header == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        as = header.getValue().split(";");
        i = as.length;
        j = 0;
_L5:
        if (j < i)
        {
label0:
            {
                String s2 = as[j];
                if (!s2.contains("image/"))
                {
                    break label0;
                }
                String s3 = (new StringBuilder(".")).append(s2.split("/")[1]).toString();
                if (!s1.endsWith(s3))
                {
                    return (new StringBuilder(String.valueOf(s1))).append(s3).toString();
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        j++;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    private File getPictureStoragePath()
    {
        return new File(Environment.getExternalStorageDirectory(), "Pictures");
    }

    private void initialize()
    {
        mViewState = MraidView.ViewState.LOADING;
        initializeScreenMetrics();
        initializeViewabilityTimer();
        mOrientationBroadcastReceiver.register(getContext());
    }

    private void initializeScreenMetrics()
    {
        Context context = getContext();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        mDensity = displaymetrics.density;
        int i;
        int j;
        int k;
        int l;
        if (context instanceof Activity)
        {
            Window window = ((Activity)context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            j = rect.top;
            i = window.findViewById(0x1020002).getTop() - j;
        } else
        {
            i = 0;
            j = 0;
        }
        k = displaymetrics.widthPixels;
        l = displaymetrics.heightPixels - j - i;
        mScreenWidth = (int)((double)k * (160D / (double)displaymetrics.densityDpi));
        mScreenHeight = (int)((double)l * (160D / (double)displaymetrics.densityDpi));
    }

    private void initializeViewabilityTimer()
    {
        mHandler.removeCallbacks(mCheckViewabilityTask);
        mHandler.post(mCheckViewabilityTask);
    }

    private void onOrientationChanged(int i)
    {
        initializeScreenMetrics();
        getMraidView().fireChangeEventForProperty(MraidScreenSizeProperty.createWithSize(mScreenWidth, mScreenHeight));
    }

    private Date parseDate(String s)
    {
        Date date;
        int i;
        date = null;
        i = 0;
_L5:
        if (i < DATE_FORMATS.length) goto _L2; else goto _L1
_L1:
        Date date1;
        return date;
_L2:
        if ((date = date1 = (new SimpleDateFormat(DATE_FORMATS[i])).parse(s)) != null) goto _L1; else goto _L3
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        ParseException parseexception;
        parseexception;
          goto _L3
    }

    private String parseRecurrenceRule(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!map.containsKey("frequency")) goto _L2; else goto _L1
_L1:
        String s = (String)map.get("frequency");
        int i;
        String s1;
        String s2;
        if (map.containsKey("interval"))
        {
            i = Integer.parseInt((String)map.get("interval"));
        } else
        {
            i = -1;
        }
        if (!"daily".equals(s)) goto _L4; else goto _L3
_L3:
        stringbuilder.append("FREQ=DAILY;");
        if (i != -1)
        {
            stringbuilder.append((new StringBuilder("INTERVAL=")).append(i).append(";").toString());
        }
_L2:
        return stringbuilder.toString();
_L4:
        if ("weekly".equals(s))
        {
            stringbuilder.append("FREQ=WEEKLY;");
            if (i != -1)
            {
                stringbuilder.append((new StringBuilder("INTERVAL=")).append(i).append(";").toString());
            }
            if (map.containsKey("daysInWeek"))
            {
                s2 = translateWeekIntegersToDays((String)map.get("daysInWeek"));
                if (s2 == null)
                {
                    throw new IllegalArgumentException("invalid ");
                }
                stringbuilder.append((new StringBuilder("BYDAY=")).append(s2).append(";").toString());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!"monthly".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append("FREQ=MONTHLY;");
        if (i != -1)
        {
            stringbuilder.append((new StringBuilder("INTERVAL=")).append(i).append(";").toString());
        }
        if (map.containsKey("daysInMonth"))
        {
            s1 = translateMonthIntegersToDays((String)map.get("daysInMonth"));
            if (s1 == null)
            {
                throw new IllegalArgumentException();
            }
            stringbuilder.append((new StringBuilder("BYMONTHDAY=")).append(s1).append(";").toString());
        }
        if (true) goto _L2; else goto _L5
_L5:
        throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
    }

    private void resetViewToDefaultState()
    {
        setNativeCloseButtonEnabled(false);
        mAdContainerLayout.removeAllViewsInLayout();
        mExpansionLayout.removeAllViewsInLayout();
        mRootView.removeView(mExpansionLayout);
        getMraidView().requestLayout();
        ViewGroup viewgroup = (ViewGroup)mPlaceholderView.getParent();
        viewgroup.addView(getMraidView(), mViewIndexInParent);
        viewgroup.removeView(mPlaceholderView);
        viewgroup.invalidate();
    }

    private void setOrientationLockEnabled(boolean flag)
    {
        Context context = getContext();
        Activity activity;
        int i;
        try
        {
            activity = (Activity)context;
        }
        catch (ClassCastException classcastexception)
        {
            Log.d("MraidDisplayController", "Unable to modify device orientation.");
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        i = activity.getResources().getConfiguration().orientation;
_L2:
        activity.setRequestedOrientation(i);
        return;
        i = mOriginalRequestedOrientation;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void showUserDialog(final String imageUrl)
    {
        (new android.app.AlertDialog.Builder(getContext())).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new _cls5()).setCancelable(true).show();
    }

    private void showUserToast(final String message)
    {
        mHandler.post(new _cls3());
    }

    private void swapViewWithPlaceholderView()
    {
        ViewGroup viewgroup = (ViewGroup)getMraidView().getParent();
        if (viewgroup == null)
        {
            return;
        }
        int i = viewgroup.getChildCount();
        do
        {
            int j;
            for (j = 0; j >= i || viewgroup.getChildAt(j) == getMraidView();)
            {
                mViewIndexInParent = j;
                viewgroup.addView(mPlaceholderView, j, new android.view.ViewGroup.LayoutParams(getMraidView().getWidth(), getMraidView().getHeight()));
                viewgroup.removeView(getMraidView());
                return;
            }

            j++;
        } while (true);
    }

    private Map translateJSParamsToAndroidCalendarEventMapping(Map map)
    {
        HashMap hashmap = new HashMap();
        if (!map.containsKey("description") || !map.containsKey("start"))
        {
            throw new IllegalArgumentException("Missing start and description fields");
        }
        hashmap.put("title", map.get("description"));
        if (map.containsKey("start") && map.get("start") != null)
        {
            Date date = parseDate((String)map.get("start"));
            if (date != null)
            {
                hashmap.put("beginTime", Long.valueOf(date.getTime()));
                if (map.containsKey("end") && map.get("end") != null)
                {
                    Date date1 = parseDate((String)map.get("end"));
                    if (date1 == null)
                    {
                        break MISSING_BLOCK_LABEL_344;
                    }
                    hashmap.put("endTime", Long.valueOf(date1.getTime()));
                }
                if (map.containsKey("location"))
                {
                    hashmap.put("eventLocation", map.get("location"));
                }
                if (map.containsKey("summary"))
                {
                    hashmap.put("description", map.get("summary"));
                }
                if (map.containsKey("transparency"))
                {
                    int i;
                    if (((String)map.get("transparency")).equals("transparent"))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    hashmap.put("availability", Integer.valueOf(i));
                }
                hashmap.put("rrule", parseRecurrenceRule(map));
                return hashmap;
            } else
            {
                throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
        } else
        {
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
    }

    private String translateMonthIntegersToDays(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean aflag[] = new boolean[63];
        String as[] = s.split(",");
        int i = 0;
        do
        {
            int j;
            if (i >= as.length)
            {
                if (as.length == 0)
                {
                    throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
                } else
                {
                    stringbuilder.deleteCharAt(-1 + stringbuilder.length());
                    return stringbuilder.toString();
                }
            }
            j = Integer.parseInt(as[i]);
            if (!aflag[j + 31])
            {
                stringbuilder.append((new StringBuilder(String.valueOf(dayNumberToDayOfMonthString(j)))).append(",").toString());
                aflag[j + 31] = true;
            }
            i++;
        } while (true);
    }

    private String translateWeekIntegersToDays(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean aflag[] = new boolean[7];
        String as[] = s.split(",");
        int i = 0;
        do
        {
            int j;
            if (i >= as.length)
            {
                if (as.length == 0)
                {
                    throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
                } else
                {
                    stringbuilder.deleteCharAt(-1 + stringbuilder.length());
                    return stringbuilder.toString();
                }
            }
            j = Integer.parseInt(as[i]);
            if (j == 7)
            {
                j = 0;
            }
            if (!aflag[j])
            {
                stringbuilder.append((new StringBuilder(String.valueOf(dayNumberToDayOfWeekString(j)))).append(",").toString());
                aflag[j] = true;
            }
            i++;
        } while (true);
    }

    protected boolean checkViewable()
    {
        return true;
    }

    protected void close()
    {
        if (mViewState != MraidView.ViewState.EXPANDED) goto _L2; else goto _L1
_L1:
        resetViewToDefaultState();
        setOrientationLockEnabled(false);
        mViewState = MraidView.ViewState.DEFAULT;
        getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
_L4:
        if (getMraidView().getMraidListener() != null)
        {
            getMraidView().getMraidListener().onClose(getMraidView(), mViewState);
        }
        return;
_L2:
        if (mViewState == MraidView.ViewState.DEFAULT)
        {
            getMraidView().setVisibility(4);
            mViewState = MraidView.ViewState.HIDDEN;
            getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    FrameLayout createAdContainerLayout()
    {
        return new FrameLayout(getContext());
    }

    protected void createCalendarEvent(Map map)
    {
        Context context;
        context = getMraidView().getContext();
        if (!Mraids.isCalendarAvailable(context))
        {
            break MISSING_BLOCK_LABEL_268;
        }
        Map map1;
        Intent intent;
        Iterator iterator;
        map1 = translateJSParamsToAndroidCalendarEventMapping(map);
        intent = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
        iterator = map1.keySet().iterator();
_L1:
        if (!iterator.hasNext())
        {
            intent.setFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
        ActivityNotFoundException activitynotfoundexception;
        String s;
        Object obj;
label0:
        {
            s = (String)iterator.next();
            obj = map1.get(s);
            if (!(obj instanceof Long))
            {
                break label0;
            }
            intent.putExtra(s, ((Long)obj).longValue());
        }
          goto _L1
        IllegalArgumentException illegalargumentexception;
label1:
        {
            if (!(obj instanceof Integer))
            {
                break label1;
            }
            intent.putExtra(s, ((Integer)obj).intValue());
        }
          goto _L1
        try
        {
            intent.putExtra(s, (String)obj);
        }
        // Misplaced declaration of an exception variable
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.d("MraidDisplayController", "no calendar app installed");
            getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "Action is unsupported on this device - no calendar app installed");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.d("MraidDisplayController", (new StringBuilder("create calendar: invalid parameters ")).append(illegalargumentexception.getMessage()).toString());
            getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.CREATE_CALENDAR_EVENT, illegalargumentexception.getMessage());
            return;
        }
        catch (Exception exception)
        {
            Log.d("MraidDisplayController", "could not create calendar event");
            getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "could not create calendar event");
            return;
        }
          goto _L1
        Log.d("MraidDisplayController", "unsupported action createCalendarEvent for devices pre-ICS");
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
        return;
    }

    RelativeLayout createExpansionLayout()
    {
        return new RelativeLayout(getContext());
    }

    FrameLayout createPlaceholderView()
    {
        return new FrameLayout(getContext());
    }

    public void destroy()
    {
        mHandler.removeCallbacks(mCheckViewabilityTask);
        mOrientationBroadcastReceiver.unregister();
_L1:
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if (!illegalargumentexception.getMessage().contains("Receiver not registered"))
        {
            throw illegalargumentexception;
        }
          goto _L1
    }

    protected void expand(String s, int i, int j, boolean flag, boolean flag1)
    {
        if (mExpansionStyle != MraidView.ExpansionStyle.DISABLED)
        {
            if (s != null && !URLUtil.isValidUrl(s))
            {
                getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.EXPAND, "URL passed to expand() was invalid.");
                return;
            }
            mRootView = (FrameLayout)getMraidView().getRootView().findViewById(0x1020002);
            useCustomClose(flag);
            setOrientationLockEnabled(flag1);
            swapViewWithPlaceholderView();
            MraidView mraidview = getMraidView();
            if (s != null)
            {
                mTwoPartExpansionView = new MraidView(getContext(), MraidView.ExpansionStyle.DISABLED, MraidView.NativeCloseButtonStyle.AD_CONTROLLED, MraidView.PlacementType.INLINE);
                mTwoPartExpansionView.setMraidListener(new _cls2());
                mTwoPartExpansionView.loadUrl(s);
                mraidview = mTwoPartExpansionView;
            }
            expandLayouts(mraidview, (int)((float)i * mDensity), (int)((float)j * mDensity));
            mRootView.addView(mExpansionLayout, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            if (mNativeCloseButtonStyle == MraidView.NativeCloseButtonStyle.ALWAYS_VISIBLE || !mAdWantsCustomCloseButton && mNativeCloseButtonStyle != MraidView.NativeCloseButtonStyle.ALWAYS_HIDDEN)
            {
                setNativeCloseButtonEnabled(true);
            }
            mViewState = MraidView.ViewState.EXPANDED;
            getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
            if (getMraidView().getMraidListener() != null)
            {
                getMraidView().getMraidListener().onExpand(getMraidView());
                return;
            }
        }
    }

    protected void getCurrentPosition()
    {
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_CURRENT_POSITION, "Unsupported action getCurrentPosition");
    }

    protected void getDefaultPosition()
    {
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_DEFAULT_POSITION, "Unsupported action getDefaultPosition");
    }

    protected void getMaxSize()
    {
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_MAX_SIZE, "Unsupported action getMaxSize");
    }

    protected void getScreenSize()
    {
        getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.GET_SCREEN_SIZE, "Unsupported action getScreenSize");
    }

    protected void initializeJavaScriptState()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(MraidScreenSizeProperty.createWithSize(mScreenWidth, mScreenHeight));
        arraylist.add(MraidViewableProperty.createWithViewable(mIsViewable));
        getMraidView().fireChangeEventForProperties(arraylist);
        mViewState = MraidView.ViewState.DEFAULT;
        getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(mViewState));
        initializeSupportedFunctionsProperty();
    }

    protected void initializeSupportedFunctionsProperty()
    {
        Context context = getContext();
        getMraidView().fireChangeEventForProperty((new MraidSupportsProperty()).withTel(Mraids.isTelAvailable(context)).withSms(Mraids.isSmsAvailable(context)).withCalendar(Mraids.isCalendarAvailable(context)).withInlineVideo(Mraids.isInlineVideoAvailable(context)).withStorePicture(Mraids.isStorePictureSupported(context)));
    }

    protected boolean isExpanded()
    {
        return mViewState == MraidView.ViewState.EXPANDED;
    }

    protected void setNativeCloseButtonEnabled(boolean flag)
    {
        if (mRootView != null)
        {
            MraidView mraidview;
            if (flag)
            {
                if (mCloseButton == null)
                {
                    StateListDrawable statelistdrawable = new StateListDrawable();
                    statelistdrawable.addState(new int[] {
                        0xfefeff59
                    }, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(mRootView.getContext()));
                    statelistdrawable.addState(new int[] {
                        0x10100a7
                    }, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(mRootView.getContext()));
                    mCloseButton = new ImageButton(getContext());
                    mCloseButton.setImageDrawable(statelistdrawable);
                    mCloseButton.setBackgroundDrawable(null);
                    mCloseButton.setOnClickListener(new _cls7());
                }
                int i = (int)(0.5F + 50F * mDensity);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(i, i, 5);
                mAdContainerLayout.addView(mCloseButton, layoutparams);
            } else
            {
                mAdContainerLayout.removeView(mCloseButton);
            }
            mraidview = getMraidView();
            if (mraidview.getOnCloseButtonStateChangeListener() != null)
            {
                mraidview.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(mraidview, flag);
                return;
            }
        }
    }

    protected void showUserDownloadImageAlert(String s)
    {
        Context context = getContext();
        if (!Mraids.isStorePictureSupported(context))
        {
            getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.STORE_PICTURE, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            Log.d("MoPub", "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            return;
        }
        if (context instanceof Activity)
        {
            showUserDialog(s);
            return;
        } else
        {
            showUserToast("Downloading image to Picture gallery...");
            downloadImage(s);
            return;
        }
    }

    protected void showVideo(String s)
    {
        MraidVideoPlayerActivity.startMraid(getContext(), s);
    }

    protected void useCustomClose(boolean flag)
    {
        mAdWantsCustomCloseButton = flag;
        MraidView mraidview = getMraidView();
        boolean flag1;
        if (flag)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (mraidview.getOnCloseButtonStateChangeListener() != null)
        {
            mraidview.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(mraidview, flag1);
        }
    }











    private class _cls1
        implements Runnable
    {

        final MraidDisplayController this$0;

        public void run()
        {
            boolean flag = checkViewable();
            if (mIsViewable != flag)
            {
                mIsViewable = flag;
                getMraidView().fireChangeEventForProperty(MraidViewableProperty.createWithViewable(mIsViewable));
            }
            mHandler.postDelayed(this, 3000L);
        }

        _cls1()
        {
            this$0 = MraidDisplayController.this;
            super();
        }
    }


    private class OrientationBroadcastReceiver extends BroadcastReceiver
    {

        private Context mContext;
        private int mLastRotation;
        final MraidDisplayController this$0;

        private boolean isRegistered()
        {
            return mContext != null;
        }

        public void onReceive(Context context, Intent intent)
        {
            if (isRegistered() && intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
            {
                int i = getDisplayRotation();
                if (i != mLastRotation)
                {
                    mLastRotation = i;
                    onOrientationChanged(mLastRotation);
                    return;
                }
            }
        }

        public void register(Context context)
        {
            mContext = context;
            context.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }

        public void unregister()
        {
            mContext.unregisterReceiver(this);
            mContext = null;
        }

        OrientationBroadcastReceiver()
        {
            this$0 = MraidDisplayController.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        private MediaScannerConnection mediaScannerConnection;
        private InputStream pictureInputStream;
        private OutputStream pictureOutputStream;
        final MraidDisplayController this$0;
        private URI uri;
        private final File val$pictureStoragePath;
        private final String val$uriString;

        private void loadPictureIntoGalleryApp(String s)
        {
            MoPubMediaScannerConnectionClient mopubmediascannerconnectionclient = new MoPubMediaScannerConnectionClient(s, null, null);
            mediaScannerConnection = new MediaScannerConnection(getContext().getApplicationContext(), mopubmediascannerconnectionclient);
            mopubmediascannerconnectionclient.mMediaScannerConnection = mediaScannerConnection;
            mediaScannerConnection.connect();
        }

        public void run()
        {
            HttpResponse httpresponse;
            String s;
            uri = URI.create(uriString);
            httpresponse = HttpClientFactory.create().execute(new HttpGet(uri));
            pictureInputStream = httpresponse.getEntity().getContent();
            s = HttpResponses.extractHeader(httpresponse, ResponseHeader.LOCATION);
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            uri = URI.create(s);
            String s1 = getFileNameForUriAndHttpResponse(uri, httpresponse);
            File file = new File(pictureStoragePath, s1);
            String s2 = file.toString();
            pictureOutputStream = new FileOutputStream(file);
            Streams.copyContent(pictureInputStream, pictureOutputStream);
            loadPictureIntoGalleryApp(s2);
            Streams.closeStream(pictureInputStream);
            Streams.closeStream(pictureOutputStream);
            return;
            Exception exception1;
            exception1;
            class _cls1
                implements Runnable
            {

                final _cls4 this$1;

                public void run()
                {
                    showUserToast("Image failed to download.");
                    getMraidView().fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand.STORE_PICTURE, "Error downloading and saving image file.");
                    Log.d("MoPub", "Error downloading and saving image file.");
                }

                _cls1()
                {
                    this$1 = _cls4.this;
                    super();
                }
            }

            mHandler.post(new _cls1());
            Streams.closeStream(pictureInputStream);
            Streams.closeStream(pictureOutputStream);
            return;
            Exception exception;
            exception;
            Streams.closeStream(pictureInputStream);
            Streams.closeStream(pictureOutputStream);
            throw exception;
        }


        _cls4()
        {
            this$0 = MraidDisplayController.this;
            uriString = s;
            pictureStoragePath = file;
            super();
        }

        private class MoPubMediaScannerConnectionClient
            implements android.media.MediaScannerConnection.MediaScannerConnectionClient
        {

            private final String mFilename;
            private MediaScannerConnection mMediaScannerConnection;
            private final String mMimeType;
            final MraidDisplayController this$0;

            private void setMediaScannerConnection(MediaScannerConnection mediascannerconnection)
            {
                mMediaScannerConnection = mediascannerconnection;
            }

            public void onMediaScannerConnected()
            {
                if (mMediaScannerConnection != null)
                {
                    mMediaScannerConnection.scanFile(mFilename, mMimeType);
                }
            }

            public void onScanCompleted(String s, Uri uri1)
            {
                if (mMediaScannerConnection != null)
                {
                    mMediaScannerConnection.disconnect();
                }
            }


            private MoPubMediaScannerConnectionClient(String s, String s1)
            {
                this$0 = MraidDisplayController.this;
                super();
                mFilename = s;
                mMimeType = s1;
            }

            MoPubMediaScannerConnectionClient(String s, String s1, MoPubMediaScannerConnectionClient mopubmediascannerconnectionclient)
            {
                this(s, s1);
            }
        }

    }


    private class _cls6
        implements android.view.View.OnTouchListener
    {

        final MraidDisplayController this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return true;
        }

        _cls6()
        {
            this$0 = MraidDisplayController.this;
            super();
        }
    }


    private class _cls5
        implements android.content.DialogInterface.OnClickListener
    {

        final MraidDisplayController this$0;
        private final String val$imageUrl;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            downloadImage(imageUrl);
        }

        _cls5()
        {
            this$0 = MraidDisplayController.this;
            imageUrl = s;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final MraidDisplayController this$0;
        private final String val$message;

        public void run()
        {
            Toast.makeText(getContext(), message, 0).show();
        }

        _cls3()
        {
            this$0 = MraidDisplayController.this;
            message = s;
            super();
        }
    }


    private class _cls2 extends MraidView.BaseMraidListener
    {

        final MraidDisplayController this$0;

        public void onClose(MraidView mraidview, MraidView.ViewState viewstate)
        {
            close();
        }

        _cls2()
        {
            this$0 = MraidDisplayController.this;
            super();
        }
    }


    private class _cls7
        implements android.view.View.OnClickListener
    {

        final MraidDisplayController this$0;

        public void onClick(View view)
        {
            close();
        }

        _cls7()
        {
            this$0 = MraidDisplayController.this;
            super();
        }
    }

}
