// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, OverlaySettings, MMJSResponse, AdViewOverlayActivity, 
//            MMWebView, MMLayout, AdViewOverlayView

class BridgeMMInterstitial extends MMJSObject
{

    BridgeMMInterstitial()
    {
    }

    private Intent getExpandExtrasIntent(String s, OverlaySettings overlaysettings)
    {
        Intent intent = new Intent();
        if (s != null)
        {
            intent.setData(Uri.parse(s));
        }
        intent.putExtra("settings", overlaysettings);
        intent.putExtra("internalId", overlaysettings.creatorAdImplId);
        return intent;
    }

    private boolean isForcingOrientation(MMJSResponse mmjsresponse)
    {
        if (mmjsresponse.result == 1 && (mmjsresponse.response instanceof String))
        {
            String s = (String)mmjsresponse.response;
            return s.contains("portrait") || s.contains("landscape");
        } else
        {
            return false;
        }
    }

    private MMJSResponse setAllowOrientationChange(HashMap hashmap)
    {
        String s = (String)hashmap.get("allowOrientationChange");
        if (s != null)
        {
            AdViewOverlayActivity adviewoverlayactivity = getBaseActivity();
            if (adviewoverlayactivity != null)
            {
                adviewoverlayactivity.setAllowOrientationChange(Boolean.parseBoolean(s));
                return MMJSResponse.responseWithSuccess();
            }
        }
        return null;
    }

    private MMJSResponse setForceOrientation(HashMap hashmap)
    {
        String s = (String)hashmap.get("forceOrientation");
        if (!"none".equals(s))
        {
            AdViewOverlayActivity adviewoverlayactivity = getBaseActivity();
            if (adviewoverlayactivity != null)
            {
                if ("portrait".equals(s))
                {
                    adviewoverlayactivity.setRequestedOrientationPortrait();
                    return MMJSResponse.responseWithSuccess("portrait");
                }
                if ("landscape".equals(s))
                {
                    adviewoverlayactivity.setRequestedOrientationLandscape();
                    return MMJSResponse.responseWithSuccess("landscape");
                }
            }
        }
        return null;
    }

    public MMJSResponse close(HashMap hashmap)
    {
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        if (mmwebview != null)
        {
            mmwebview.getMMLayout().closeAreaTouched();
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse expandToExternalBrowser(HashMap hashmap)
    {
        return open(hashmap);
    }

    public MMJSResponse expandWithProperties(HashMap hashmap)
    {
        String s = (String)hashmap.get("PROPERTY_BANNER_TYPE");
        if (s != null && !Boolean.parseBoolean(s))
        {
            return MMJSResponse.responseWithError("Cannot expand a non banner ad");
        }
        String s1 = (String)hashmap.get("url");
        String s2 = (String)hashmap.get("enableNativeAccelerometer");
        String s3 = (String)hashmap.get("transparent");
        String s4 = (String)hashmap.get("useCustomClose");
        String s5 = (String)hashmap.get("transition");
        String s6 = (String)hashmap.get("orientation");
        String s7 = (String)hashmap.get("transitionDuration");
        String s8 = (String)hashmap.get("height");
        String s9 = (String)hashmap.get("width");
        String s10 = (String)hashmap.get("modal");
        String s11 = (String)hashmap.get("PROPERTY_EXPANDING");
        String s12 = (String)hashmap.get("allowOrientationChange");
        Context context = (Context)contextRef.get();
        if (context != null)
        {
            OverlaySettings overlaysettings = new OverlaySettings();
            if (s1 != null)
            {
                overlaysettings.urlToLoad = s1;
            }
            if (s11 != null)
            {
                overlaysettings.creatorAdImplId = (int)Float.parseFloat(s11);
            }
            if (s2 != null)
            {
                overlaysettings.canAccelerate = Boolean.parseBoolean(s2);
            }
            if (s3 != null)
            {
                overlaysettings.setIsTransparent(Boolean.parseBoolean(s3));
            }
            if (s4 != null)
            {
                overlaysettings.setUseCustomClose(Boolean.parseBoolean(s4));
            }
            if (s5 != null)
            {
                overlaysettings.setTransition(s5);
            }
            if (s12 != null)
            {
                overlaysettings.allowOrientationChange = Boolean.parseBoolean(s12);
            }
            String s13;
            if (s6 == null)
            {
                s13 = (String)hashmap.get("forceOrientation");
            } else
            {
                s13 = s6;
            }
            if (s13 != null)
            {
                overlaysettings.orientation = s13;
            }
            if (s8 != null)
            {
                overlaysettings.height = (int)Float.parseFloat(s8);
            }
            if (s9 != null)
            {
                overlaysettings.width = (int)Float.parseFloat(s9);
            }
            if (s10 != null)
            {
                overlaysettings.modal = Boolean.parseBoolean(s10);
            }
            if (s7 != null)
            {
                try
                {
                    overlaysettings.setTransitionDurationInMillis(1000L * Long.parseLong(s7));
                }
                catch (Exception exception) { }
            }
            Utils.IntentUtils.startAdViewOverlayActivity(context, getExpandExtrasIntent(s1, overlaysettings));
            MMSDK.Event.overlayOpenedBroadCast(context, getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse open(HashMap hashmap)
    {
        String s = (String)hashmap.get("url");
        Context context = (Context)contextRef.get();
        if (s != null && context != null)
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            MMSDK.Event.intentStarted(context, "browser", getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
            Utils.IntentUtils.startActivity(context, intent);
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse setOrientation(HashMap hashmap)
    {
        MMJSResponse mmjsresponse = setForceOrientation(hashmap);
        if (mmjsresponse == null || !isForcingOrientation(mmjsresponse))
        {
            mmjsresponse = setAllowOrientationChange(hashmap);
        }
        return mmjsresponse;
    }

    public MMJSResponse show(HashMap hashmap)
    {
        String s = (String)hashmap.get("url");
        Context context = (Context)contextRef.get();
        if (s != null && context != null)
        {
            Utils.IntentUtils.startAdViewOverlayActivityWithData(context, s);
            return MMJSResponse.responseWithSuccess();
        } else
        {
            return null;
        }
    }

    public MMJSResponse useCustomClose(HashMap hashmap)
    {
        MMWebView mmwebview = (MMWebView)mmWebViewRef.get();
        String s = (String)hashmap.get("useCustomClose");
        if (s != null && mmwebview != null)
        {
            AdViewOverlayView adviewoverlayview = mmwebview.getAdViewOverlayView();
            if (adviewoverlayview != null)
            {
                adviewoverlayview.setUseCustomClose(Boolean.parseBoolean(s));
                return MMJSResponse.responseWithSuccess();
            }
        }
        return null;
    }
}
