// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMSDK, MMJSResponse, MMWebView, 
//            HandShake, MMRequest

class BridgeMMDevice extends MMJSObject
{

    BridgeMMDevice()
    {
    }

    static JSONObject getDeviceInfo(Context context)
    {
        JSONObject jsonobject;
        Locale locale;
        JSONObject jsonobject1;
        JSONArray jsonarray;
        try
        {
            jsonobject = new JSONObject();
        }
        catch (JSONException jsonexception1)
        {
            return null;
        }
        try
        {
            jsonobject.put("sdkVersion", "5.0.1-13.05.14.a");
            jsonobject.put("mmisdk", "5.0.1-13.05.14.a");
            jsonobject.put("connection", MMSDK.getConnectionType(context));
            jsonobject.put("platform", "Android");
            if (android.os.Build.VERSION.RELEASE != null)
            {
                jsonobject.put("version", android.os.Build.VERSION.RELEASE);
            }
            if (Build.MODEL != null)
            {
                jsonobject.put("device", Build.MODEL);
            }
            jsonobject.put("mmdid", MMSDK.getMMdid(context));
            DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
            jsonobject.put("density", new Float(displaymetrics.density));
            jsonobject.put("height", new Integer(displaymetrics.heightPixels));
            jsonobject.put("width", new Integer(displaymetrics.widthPixels));
            locale = Locale.getDefault();
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        if (locale == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        jsonobject.put("language", locale.getLanguage());
        jsonobject.put("country", locale.getCountry());
        jsonobject1 = new JSONObject();
        jsonobject1.put("name", "MAC-ID");
        jsonobject1.put("path", "/");
        jsonobject1.put("value", MMSDK.macId);
        jsonarray = new JSONArray();
        jsonarray.put(jsonobject1);
        jsonobject.put("cookies", jsonarray);
        return jsonobject;
    }

    public MMJSResponse call(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("number");
        if (context != null && s != null)
        {
            MMSDK.Log.d("Dialing Phone: %s", new Object[] {
                s
            });
            Intent intent;
            if (Boolean.parseBoolean((String)hashmap.get("dial")) && context.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0)
            {
                intent = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder("tel:")).append(s).toString()));
            } else
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("tel:")).append(s).toString()));
            }
            Utils.IntentUtils.startActivity(context, intent);
            MMSDK.Event.intentStarted(context, "tel", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse composeEmail(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("recipients");
        String s1 = (String)hashmap.get("subject");
        String s2 = (String)hashmap.get("message");
        if (context != null)
        {
            MMSDK.Log.d("Creating email");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            if (s != null)
            {
                intent.putExtra("android.intent.extra.EMAIL", s.split(","));
            }
            if (s1 != null)
            {
                intent.putExtra("android.intent.extra.SUBJECT", s1);
            }
            if (s2 != null)
            {
                intent.putExtra("android.intent.extra.TEXT", s2);
            }
            Utils.IntentUtils.startActivity(context, intent);
            MMSDK.Event.intentStarted(context, "email", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse composeSms(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("number");
        String s1 = (String)hashmap.get("message");
        if (context != null && s != null)
        {
            MMSDK.Log.d("Creating sms: %s", new Object[] {
                s
            });
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("sms:")).append(s).toString()));
            if (s1 != null)
            {
                intent.putExtra("sms_body", s1);
            }
            Utils.IntentUtils.startActivity(context, intent);
            MMSDK.Event.intentStarted(context, "sms", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess("SMS Sent");
        } else
        {
            return null;
        }
    }

    public MMJSResponse enableHardwareAcceleration(HashMap hashmap)
    {
        MMSDK.Log.d((new StringBuilder("hardware accel call")).append(hashmap).toString());
        String s = (String)hashmap.get("enabled");
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        if (mmwebview != null && mmwebview != null)
        {
            if (Boolean.parseBoolean(s))
            {
                mmwebview.enableHardwareAcceleration();
            } else
            {
                mmwebview.disableAllAcceleration();
            }
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse getAvailableSchemes(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            HandShake handshake = HandShake.sharedHandShake(context);
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.response = handshake.getSchemesJSONArray(context);
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getInfo(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.response = getDeviceInfo(context);
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse getLocation(HashMap hashmap)
    {
        if (MMRequest.location != null)
        {
label0:
            {
                JSONObject jsonobject;
                MMJSResponse mmjsresponse;
                try
                {
                    jsonobject = new JSONObject();
                }
                catch (JSONException jsonexception1)
                {
                    jsonobject = null;
                    if (false)
                    {
                    } else
                    {
                        break label0;
                    }
                }
                try
                {
                    jsonobject.put("lat", Double.toString(MMRequest.location.getLatitude()));
                    jsonobject.put("long", Double.toString(MMRequest.location.getLongitude()));
                    if (MMRequest.location.hasAccuracy())
                    {
                        jsonobject.put("ha", Float.toString(MMRequest.location.getAccuracy()));
                        jsonobject.put("va", Float.toString(MMRequest.location.getAccuracy()));
                    }
                    if (MMRequest.location.hasSpeed())
                    {
                        jsonobject.put("spd", Float.toString(MMRequest.location.getSpeed()));
                    }
                    if (MMRequest.location.hasBearing())
                    {
                        jsonobject.put("brg", Float.toString(MMRequest.location.getBearing()));
                    }
                    if (MMRequest.location.hasAltitude())
                    {
                        jsonobject.put("alt", Double.toString(MMRequest.location.getAltitude()));
                    }
                    jsonobject.put("tslr", Long.toString(MMRequest.location.getTime()));
                }
                catch (JSONException jsonexception) { }
            }
            mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.response = jsonobject;
            return mmjsresponse;
        } else
        {
            return MMJSResponse.responseWithError("location object has not been set");
        }
    }

    public MMJSResponse getOrientation(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        if (context == null) goto _L2; else goto _L1
_L1:
        int i = context.getResources().getConfiguration().orientation;
        int j;
        MMJSResponse mmjsresponse;
        if (i == 0)
        {
            j = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getOrientation();
        } else
        {
            j = i;
        }
        mmjsresponse = new MMJSResponse();
        mmjsresponse.result = 1;
        j;
        JVM INSTR tableswitch 2 2: default 84
    //                   2 95;
           goto _L3 _L4
_L3:
        mmjsresponse.response = "portrait";
_L5:
        return mmjsresponse;
_L4:
        mmjsresponse.response = "landscape";
        if (true) goto _L5; else goto _L2
_L2:
        return null;
    }

    public MMJSResponse isSchemeAvailable(HashMap hashmap)
    {
        String s = (String)hashmap.get("scheme");
        String s1;
        Context context;
        if (!s.contains(":"))
        {
            s1 = (new StringBuilder()).append(s).append(":").toString();
        } else
        {
            s1 = s;
        }
        context = (Context)contextRef.get();
        if (s1 != null && context != null)
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s1));
            if (context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0)
            {
                return MMJSResponse.responseWithSuccess(s1);
            }
        }
        return MMJSResponse.responseWithError(s1);
    }

    public MMJSResponse openAppStore(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("appId");
        String s1 = (String)hashmap.get("referrer");
        if (context != null && s != null)
        {
            MMSDK.Log.d("Opening marketplace: %s", new Object[] {
                s
            });
            Intent intent = new Intent("android.intent.action.VIEW");
            if (s1 != null)
            {
                Object aobj[] = new Object[2];
                aobj[0] = s;
                aobj[1] = URLEncoder.encode(s1);
                intent.setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", aobj)));
            } else
            {
                intent.setData(Uri.parse((new StringBuilder("market://details?id=")).append(s).toString()));
            }
            MMSDK.Event.intentStarted(context, "market", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            Utils.IntentUtils.startActivity(context, intent);
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse openUrl(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("url");
        if (context != null && s != null)
        {
            MMSDK.Log.d("Opening: %s", new Object[] {
                s
            });
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            if (intent.getScheme().startsWith("http") || intent.getScheme().startsWith("https"))
            {
                MMSDK.Event.intentStarted(context, "browser", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            }
            Utils.IntentUtils.startActivity(context, intent);
            return MMJSResponse.responseWithSuccess("Overlay opened");
        } else
        {
            return MMJSResponse.responseWithError("URL could not be opened");
        }
    }

    public MMJSResponse setMMDID(HashMap hashmap)
    {
        String s = (String)hashmap.get("mmdid");
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            HandShake.sharedHandShake(context).setMMdid(context, s);
            return MMJSResponse.responseWithSuccess("MMDID is set");
        } else
        {
            return null;
        }
    }

    public MMJSResponse showMap(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("location");
        if (context != null && s != null)
        {
            MMSDK.Log.d("Launching Google Maps: %s", new Object[] {
                s
            });
            Utils.IntentUtils.startActivity(context, new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("geo:")).append(s).toString())));
            MMSDK.Event.intentStarted(context, "geo", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess("Map successfully opened");
        } else
        {
            return null;
        }
    }

    public MMJSResponse tweet(HashMap hashmap)
    {
        return null;
    }
}
