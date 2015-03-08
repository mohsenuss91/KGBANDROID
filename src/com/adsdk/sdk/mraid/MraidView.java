// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.adsdk.sdk.mraid:
//            BaseWebView, ViewGestureDetector, MraidBrowserController, MraidDisplayController, 
//            MraidCommandFactory, MraidCommand, MraidProperty, HttpClientFactory, 
//            Strings

public class MraidView extends BaseWebView
    implements ViewGestureDetector.UserClickListener
{

    private static final String LOGTAG = "MraidView";
    private MraidBrowserController mBrowserController;
    private boolean mClicked;
    private MraidDisplayController mDisplayController;
    private boolean mHasFiredReadyEvent;
    private MraidListenerInfo mListenerInfo;
    private final PlacementType mPlacementType;
    private ViewGestureDetector mViewGestureDetector;
    private WebViewClient mWebViewClient;

    public MraidView(Context context)
    {
        this(context, ExpansionStyle.ENABLED, NativeCloseButtonStyle.AD_CONTROLLED, PlacementType.INLINE);
    }

    public MraidView(Context context, ExpansionStyle expansionstyle, NativeCloseButtonStyle nativeclosebuttonstyle, PlacementType placementtype)
    {
        super(context);
        mPlacementType = placementtype;
        mViewGestureDetector = new ViewGestureDetector(context, this);
        mViewGestureDetector.setUserClickListener(this);
        initialize(expansionstyle, nativeclosebuttonstyle);
    }

    private void initialize(ExpansionStyle expansionstyle, NativeCloseButtonStyle nativeclosebuttonstyle)
    {
        setScrollContainer(false);
        setBackgroundColor(0);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setOnTouchListener(new _cls1());
        getSettings().setJavaScriptEnabled(true);
        mBrowserController = new MraidBrowserController(this);
        mDisplayController = new MraidDisplayController(this, expansionstyle, nativeclosebuttonstyle);
        mWebViewClient = new MraidWebViewClient(null);
        setWebViewClient(mWebViewClient);
        mListenerInfo = new MraidListenerInfo();
    }

    private void notifyOnFailureListener()
    {
        if (mListenerInfo.mMraidListener != null)
        {
            mListenerInfo.mMraidListener.onFailure(this);
        }
    }

    private boolean tryCommand(URI uri)
    {
        String s = uri.getHost();
        List list = URLEncodedUtils.parse(uri, "UTF-8");
        HashMap hashmap = new HashMap();
        Iterator iterator = list.iterator();
        MraidCommand mraidcommand;
        do
        {
            if (!iterator.hasNext())
            {
                mraidcommand = MraidCommandFactory.create(s, hashmap, this);
                if (mraidcommand == null)
                {
                    fireNativeCommandCompleteEvent(s);
                    return false;
                }
                break;
            }
            NameValuePair namevaluepair = (NameValuePair)iterator.next();
            hashmap.put(namevaluepair.getName(), namevaluepair.getValue());
        } while (true);
        if (mraidcommand.isCommandDependentOnUserClick(mPlacementType) && !wasClicked())
        {
            return false;
        } else
        {
            mraidcommand.execute();
            fireNativeCommandCompleteEvent(s);
            return true;
        }
    }

    public void destroy()
    {
        mDisplayController.destroy();
        super.destroy();
    }

    protected void fireChangeEventForProperties(ArrayList arraylist)
    {
        String s = arraylist.toString();
        if (s.length() < 2)
        {
            return;
        } else
        {
            String s1 = (new StringBuilder("{")).append(s.substring(1, -1 + s.length())).append("}").toString();
            injectJavaScript((new StringBuilder("window.mraidbridge.fireChangeEvent(")).append(s1).append(");").toString());
            Log.d("MraidView", (new StringBuilder("Fire changes: ")).append(s1).toString());
            return;
        }
    }

    protected void fireChangeEventForProperty(MraidProperty mraidproperty)
    {
        String s = (new StringBuilder("{")).append(mraidproperty.toString()).append("}").toString();
        injectJavaScript((new StringBuilder("window.mraidbridge.fireChangeEvent(")).append(s).append(");").toString());
        Log.d("MraidView", (new StringBuilder("Fire change: ")).append(s).toString());
    }

    protected void fireErrorEvent(MraidCommandFactory.MraidJavascriptCommand mraidjavascriptcommand, String s)
    {
        String s1 = mraidjavascriptcommand.getCommand();
        injectJavaScript((new StringBuilder("window.mraidbridge.fireErrorEvent('")).append(s1).append("', '").append(s).append("');").toString());
    }

    protected void fireNativeCommandCompleteEvent(String s)
    {
        injectJavaScript((new StringBuilder("window.mraidbridge.nativeCallComplete('")).append(s).append("');").toString());
    }

    protected void fireReadyEvent()
    {
        injectJavaScript("window.mraidbridge.fireReadyEvent();");
    }

    protected MraidBrowserController getBrowserController()
    {
        return mBrowserController;
    }

    protected MraidDisplayController getDisplayController()
    {
        return mDisplayController;
    }

    public MraidListener getMraidListener()
    {
        return mListenerInfo.mMraidListener;
    }

    WebViewClient getMraidWebViewClient()
    {
        return mWebViewClient;
    }

    public OnCloseButtonStateChangeListener getOnCloseButtonStateChangeListener()
    {
        return mListenerInfo.mOnCloseButtonListener;
    }

    public OnOpenListener getOnOpenListener()
    {
        return mListenerInfo.mOnOpenListener;
    }

    protected void injectJavaScript(String s)
    {
        if (s != null)
        {
            super.loadUrl((new StringBuilder("javascript:")).append(s).toString());
        }
    }

    public void loadHtmlData(String s)
    {
        if (s == null)
        {
            return;
        }
        if (!s.contains("<html>"))
        {
            s = (new StringBuilder("<html><head></head><body style='margin:0;padding:0;'>")).append(s).append("</body></html>").toString();
        }
        loadDataWithBaseURL(null, s.replace("<head>", "<head><script>(function() {\n  var isIOS = (/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());\n  if (isIOS) {\n    console = {};\n    console.log = function(log) {\n      var iframe = document.createElement('iframe');\n      iframe.setAttribute('src', 'ios-log: ' + log);\n      document.documentElement.appendChild(iframe);\n      iframe.parentNode.removeChild(iframe);\n      iframe = null;\n    };\n    console.debug = console.info = console.warn = console.error = console.log;\n  }\n}());\n\n(function() {\n  // Establish the root mraidbridge object.\n  var mraidbridge = window.mraidbridge = {};\n\n  // Listeners for bridge events.\n  var listeners = {};\n\n  // Queue to track pending calls to the native SDK.\n  var nativeCallQueue = [];\n\n  // Whether a native call is currently in progress.\n  var nativeCallInFlight = false;\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  mraidbridge.fireReadyEvent = function() {\n    mraidbridge.fireEvent('ready');\n  };\n\n  mraidbridge.fireChangeEvent = function(properties) {\n    mraidbridge.fireEvent('change', properties);\n  };\n\n  mraidbridge.fireErrorEvent = function(message, action) {\n    mraidbridge.fireEvent('error', message, action);\n  };\n\n  mraidbridge.fireEvent = function(type) {\n    var ls = listeners[type];\n    if (ls) {\n      var args = Array.prototype.slice.call(arguments);\n      args.shift();\n      var l = ls.length;\n      for (var i = 0; i < l; i++) {\n        ls[i].apply(null, args);\n      }\n    }\n  };\n\n  mraidbridge.nativeCallComplete = function(command) {\n    if (nativeCallQueue.length === 0) {\n      nativeCallInFlight = false;\n      return;\n    }\n\n    var nextCall = nativeCallQueue.pop();\n    window.location = nextCall;\n  };\n\n  mraidbridge.executeNativeCall = function(command) {\n    var call = 'mraid://' + command;\n\n    var key, value;\n    var isFirstArgument = true;\n\n    for (var i = 1; i < arguments.length; i += 2) {\n      key = arguments[i];\n      value = arguments[i + 1];\n\n      if (value === null) continue;\n\n      if (isFirstArgument) {\n        call += '?';\n        isFirstArgument = false;\n      } else {\n        call += '&';\n      }\n\n      call += encodeURIComponent(key) + '=' + encodeURIComponent(value);\n    }\n\n    if (nativeCallInFlight) {\n      nativeCallQueue.push(call);\n    } else {\n      nativeCallInFlight = true;\n      window.location = call;\n    }\n  };\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  mraidbridge.addEventListener = function(event, listener) {\n    var eventListeners;\n    listeners[event] = listeners[event] || [];\n    eventListeners = listeners[event];\n\n    for (var l in eventListeners) {\n      // Listener already registered, so no need to add it.\n      if (listener === l) return;\n    }\n\n    eventListeners.push(listener);\n  };\n\n  mraidbridge.removeEventListener = function(event, listener) {\n    if (listeners.hasOwnProperty(event)) {\n      var eventListeners = listeners[event];\n      if (eventListeners) {\n        var idx = eventListeners.indexOf(listener);\n        if (idx !== -1) {\n          eventListeners.splice(idx, 1);\n        }\n      }\n    }\n  };\n}());\n\n(function() {\n  var mraid = window.mraid = {};\n  var bridge = window.mraidbridge;\n\n  // Constants. ////////////////////////////////////////////////////////////////////////////////////\n\n  var VERSION = mraid.VERSION = '2.0';\n\n  var STATES = mraid.STATES = {\n    LOADING: 'loading',     // Initial state.\n    DEFAULT: 'default',\n    EXPANDED: 'expanded',\n    HIDDEN: 'hidden'\n  };\n\n  var EVENTS = mraid.EVENTS = {\n    ERROR: 'error',\n    INFO: 'info',\n    READY: 'ready',\n    STATECHANGE: 'stateChange',\n    VIEWABLECHANGE: 'viewableChange'\n  };\n\n  var PLACEMENT_TYPES = mraid.PLACEMENT_TYPES = {\n    UNKNOWN: 'unknown',\n    INLINE: 'inline',\n    INTERSTITIAL: 'interstitial'\n  };\n\n  // External MRAID state: may be directly or indirectly modified by the ad JS. ////////////////////\n\n  // Properties which define the behavior of an expandable ad.\n  var expandProperties = {\n    width: -1,\n    height: -1,\n    useCustomClose: false,\n    isModal: true,\n    lockOrientation: false\n  };\n\n  var hasSetCustomSize = false;\n\n  var hasSetCustomClose = false;\n\n  var listeners = {};\n\n  // Internal MRAID state. Modified by the native SDK. /////////////////////////////////////////////\n\n  var state = STATES.LOADING;\n\n  var isViewable = false;\n\n  var screenSize = { width: -1, height: -1 };\n\n  var placementType = PLACEMENT_TYPES.UNKNOWN;\n\n  var supports = {\n    sms: false,\n    tel: false,\n    calendar: false,\n    storePicture: false,\n    inlineVideo: false\n  };\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  var EventListeners = function(event) {\n    this.event = event;\n    this.count = 0;\n    var listeners = {};\n\n    this.add = function(func) {\n      var id = String(func);\n      if (!listeners[id]) {\n        listeners[id] = func;\n        this.count++;\n      }\n    };\n\n    this.remove = function(func) {\n      var id = String(func);\n      if (listeners[id]) {\n        listeners[id] = null;\n        delete listeners[id];\n        this.count--;\n        return true;\n      } else {\n        return false;\n      }\n    };\n\n    this.removeAll = function() {\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) this.remove(listeners[id]);\n      }\n    };\n\n    this.broadcast = function(args) {\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) listeners[id].apply({}, args);\n      }\n    };\n\n    this.toString = function() {\n      var out = [event, ':'];\n      for (var id in listeners) {\n        if (listeners.hasOwnProperty(id)) out.push('|', id, '|');\n      }\n      return out.join('');\n    };\n  };\n\n  var broadcastEvent = function() {\n    var args = new Array(arguments.length);\n    var l = arguments.length;\n    for (var i = 0; i < l; i++) args[i] = arguments[i];\n    var event = args.shift();\n    if (listeners[event]) listeners[event].broadcast(args);\n  };\n\n  var contains = function(value, array) {\n    for (var i in array) {\n      if (array[i] === value) return true;\n    }\n    return false;\n  };\n\n  var clone = function(obj) {\n    if (obj === null) return null;\n    var f = function() {};\n    f.prototype = obj;\n    return new f();\n  };\n\n  var stringify = function(obj) {\n    if (typeof obj === 'object') {\n      var out = [];\n      if (obj.push) {\n        // Array.\n        for (var p in obj) out.push(obj[p]);\n        return '[' + out.join(',') + ']';\n      } else {\n        // Other object.\n        for (var p in obj) out.push(\"'\" + p + \"': \" + obj[p]);\n        return '{' + out.join(',') + '}';\n      }\n    } else return String(obj);\n  };\n\n  var trim = function(str) {\n    return str.replace(/^\\s+|\\s+$/g, '');\n  };\n\n  // Functions that will be invoked by the native SDK whenever a \"change\" event occurs.\n  var changeHandlers = {\n    state: function(val) {\n      if (state === STATES.LOADING) {\n        broadcastEvent(EVENTS.INFO, 'Native SDK initialized.');\n      }\n      state = val;\n      broadcastEvent(EVENTS.INFO, 'Set state to ' + stringify(val));\n      broadcastEvent(EVENTS.STATECHANGE, state);\n    },\n\n    viewable: function(val) {\n      isViewable = val;\n      broadcastEvent(EVENTS.INFO, 'Set isViewable to ' + stringify(val));\n      broadcastEvent(EVENTS.VIEWABLECHANGE, isViewable);\n    },\n\n    placementType: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set placementType to ' + stringify(val));\n      placementType = val;\n    },\n\n    screenSize: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set screenSize to ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) screenSize[key] = val[key];\n      }\n\n      if (!hasSetCustomSize) {\n        expandProperties['width'] = screenSize['width'];\n        expandProperties['height'] = screenSize['height'];\n      }\n    },\n\n    expandProperties: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Merging expandProperties with ' + stringify(val));\n      for (var key in val) {\n        if (val.hasOwnProperty(key)) expandProperties[key] = val[key];\n      }\n    },\n\n    supports: function(val) {\n      broadcastEvent(EVENTS.INFO, 'Set supports to ' + stringify(val));\n        supports = val;\n    },\n  };\n\n  var validate = function(obj, validators, action, merge) {\n    if (!merge) {\n      // Check to see if any required properties are missing.\n      if (obj === null) {\n        broadcastEvent(EVENTS.ERROR, 'Required object not provided.', action);\n        return false;\n      } else {\n        for (var i in validators) {\n          if (validators.hasOwnProperty(i) && obj[i] === undefined) {\n            broadcastEvent(EVENTS.ERROR, 'Object is missing required property: ' + i + '.', action);\n            return false;\n          }\n        }\n      }\n    }\n\n    for (var prop in obj) {\n      var validator = validators[prop];\n      var value = obj[prop];\n      if (validator && !validator(value)) {\n        // Failed validation.\n        broadcastEvent(EVENTS.ERROR, 'Value of property ' + prop + ' is invalid.',\n          action);\n        return false;\n      }\n    }\n    return true;\n  };\n\n  var expandPropertyValidators = {\n    width: function(v) { return !isNaN(v) && v >= 0; },\n    height: function(v) { return !isNaN(v) && v >= 0; },\n    useCustomClose: function(v) { return (typeof v === 'boolean'); },\n    lockOrientation: function(v) { return (typeof v === 'boolean'); }\n  };\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  bridge.addEventListener('change', function(properties) {\n    for (var p in properties) {\n      if (properties.hasOwnProperty(p)) {\n        var handler = changeHandlers[p];\n        handler(properties[p]);\n      }\n    }\n  });\n\n  bridge.addEventListener('error', function(message, action) {\n    broadcastEvent(EVENTS.ERROR, message, action);\n  });\n\n  bridge.addEventListener('ready', function() {\n    broadcastEvent(EVENTS.READY);\n  });\n\n  //////////////////////////////////////////////////////////////////////////////////////////////////\n\n  mraid.addEventListener = function(event, listener) {\n    if (!event || !listener) {\n      broadcastEvent(EVENTS.ERROR, 'Both event and listener are required.', 'addEventListener');\n    } else if (!contains(event, EVENTS)) {\n      broadcastEvent(EVENTS.ERROR, 'Unknown MRAID event: ' + event, 'addEventListener');\n    } else {\n      if (!listeners[event]) listeners[event] = new EventListeners(event);\n      listeners[event].add(listener);\n    }\n  };\n\n  mraid.close = function() {\n    if (state === STATES.HIDDEN) {\n      broadcastEvent(EVENTS.ERROR, 'Ad cannot be closed when it is already hidden.',\n        'close');\n    } else bridge.executeNativeCall('close');\n  };\n\n  mraid.expand = function(URL) {\n    if (this.getState() !== STATES.DEFAULT) {\n      broadcastEvent(EVENTS.ERROR, 'Ad can only be expanded from the default state.', 'expand');\n    } else {\n      var args = ['expand'];\n\n      if (this.getHasSetCustomClose()) {\n        args = args.concat(['shouldUseCustomClose', expandProperties.useCustomClose ? 'true' : 'false']);\n      }\n\n      if (this.getHasSetCustomSize()) {\n        if (expandProperties.width >= 0 && expandProperties.height >= 0) {\n          args = args.concat(['w', expandProperties.width, 'h', expandProperties.height]);\n        }\n      }\n\n      if (typeof expandProperties.lockOrientation !== 'undefined') {\n        args = args.concat(['lockOrientation', expandProperties.lockOrientation]);\n      }\n\n      if (URL) {\n        args = args.concat(['url', URL]);\n      }\n\n      bridge.executeNativeCall.apply(this, args);\n    }\n  };\n\n  mraid.getHasSetCustomClose = function() {\n      return hasSetCustomClose;\n  };\n\n  mraid.getHasSetCustomSize = function() {\n      return hasSetCustomSize;\n  };\n\n  mraid.getExpandProperties = function() {\n    var properties = {\n      width: expandProperties.width,\n      height: expandProperties.height,\n      useCustomClose: expandProperties.useCustomClose,\n      isModal: expandProperties.isModal\n    };\n    return properties;\n  };\n\n  mraid.getPlacementType = function() {\n    return placementType;\n  };\n\n  mraid.getState = function() {\n    return state;\n  };\n\n  mraid.getVersion = function() {\n    return mraid.VERSION;\n  };\n\n  mraid.isViewable = function() {\n    return isViewable;\n  };\n\n  mraid.open = function(URL) {\n    if (!URL) broadcastEvent(EVENTS.ERROR, 'URL is required.', 'open');\n    else bridge.executeNativeCall('open', 'url', URL);\n  };\n\n  mraid.removeEventListener = function(event, listener) {\n    if (!event) broadcastEvent(EVENTS.ERROR, 'Event is required.', 'removeEventListener');\n    else {\n      if (listener && (!listeners[event] || !listeners[event].remove(listener))) {\n        broadcastEvent(EVENTS.ERROR, 'Listener not currently registered for event.',\n          'removeEventListener');\n        return;\n      } else if (listeners[event]) listeners[event].removeAll();\n\n      if (listeners[event] && listeners[event].count === 0) {\n        listeners[event] = null;\n        delete listeners[event];\n      }\n    }\n  };\n\n  mraid.setExpandProperties = function(properties) {\n    if (validate(properties, expandPropertyValidators, 'setExpandProperties', true)) {\n      if (properties.hasOwnProperty('width') || properties.hasOwnProperty('height')) {\n        hasSetCustomSize = true;\n      }\n\n      if (properties.hasOwnProperty('useCustomClose')) hasSetCustomClose = true;\n\n      var desiredProperties = ['width', 'height', 'useCustomClose', 'lockOrientation'];\n      var length = desiredProperties.length;\n      for (var i = 0; i < length; i++) {\n        var propname = desiredProperties[i];\n        if (properties.hasOwnProperty(propname)) expandProperties[propname] = properties[propname];\n      }\n    }\n  };\n\n  mraid.useCustomClose = function(shouldUseCustomClose) {\n    expandProperties.useCustomClose = shouldUseCustomClose;\n    hasSetCustomClose = true;\n    bridge.executeNativeCall('usecustomclose', 'shouldUseCustomClose', shouldUseCustomClose);\n  };\n\n  // MRAID 2.0 APIs ////////////////////////////////////////////////////////////////////////////////\n\n  mraid.createCalendarEvent = function(parameters) {\n    CalendarEventParser.initialize(parameters);\n    if (CalendarEventParser.parse()) {\n      bridge.executeNativeCall.apply(this, CalendarEventParser.arguments);\n    } else {\n      broadcastEvent(EVENTS.ERROR, CalendarEventParser.errors[0], 'createCalendarEvent');\n    }\n  };\n\n  mraid.supports = function(feature) {\n    return supports[feature];\n  };\n\n  mraid.playVideo = function(uri) {\n    if (!mraid.isViewable()) {\n      broadcastEvent(EVENTS.ERROR, 'playVideo cannot be called until the ad is viewable', 'playVideo');\n      return;\n    }\n\n    if (!uri) {\n      broadcastEvent(EVENTS.ERROR, 'playVideo must be called with a valid URI', 'playVideo');\n    } else {\n      bridge.executeNativeCall.apply(this, ['playVideo', 'uri', uri]);\n    }\n  };\n\n  mraid.storePicture = function(uri) {\n    if (!mraid.isViewable()) {\n      broadcastEvent(EVENTS.ERROR, 'storePicture cannot be called until the ad is viewable', 'storePicture');\n      return;\n    }\n\n    if (!uri) {\n      broadcastEvent(EVENTS.ERROR, 'storePicture must be called with a valid URI', 'storePicture');\n    } else {\n      bridge.executeNativeCall.apply(this, ['storePicture', 'uri', uri]);\n    }\n  };\n\n  mraid.resize = function() {\n    bridge.executeNativeCall('resize');\n  };\n\n  mraid.getResizeProperties = function() {\n    bridge.executeNativeCall('getResizeProperties');\n  };\n\n  mraid.setResizeProperties = function(resizeProperties) {\n    bridge.executeNativeCall('setResizeProperties', 'resizeProperties', resizeProperties);\n  };\n\n  mraid.getCurrentPosition = function() {\n    bridge.executeNativeCall('getCurrentPosition');\n  };\n\n  mraid.getDefaultPosition = function() {\n    bridge.executeNativeCall('getDefaultPosition');\n  };\n\n  mraid.getMaxSize = function() {\n    bridge.executeNativeCall('getMaxSize');\n  };\n\n  mraid.getScreenSize = function() {\n    bridge.executeNativeCall('getScreenSize');\n  };\n\n  var CalendarEventParser = {\n    initialize: function(parameters) {\n      this.parameters = parameters;\n      this.errors = [];\n      this.arguments = ['createCalendarEvent'];\n    },\n\n    parse: function() {\n      if (!this.parameters) {\n        this.errors.push('The object passed to createCalendarEvent cannot be null.');\n      } else {\n        this.parseDescription();\n        this.parseLocation();\n        this.parseSummary();\n        this.parseStartAndEndDates();\n        this.parseReminder();\n        this.parseRecurrence();\n        this.parseTransparency();\n      }\n\n      var errorCount = this.errors.length;\n      if (errorCount) {\n        this.arguments.length = 0;\n      }\n\n      return (errorCount === 0);\n    },\n\n    parseDescription: function() {\n      this._processStringValue('description');\n    },\n\n    parseLocation: function() {\n      this._processStringValue('location');\n    },\n\n    parseSummary: function() {\n      this._processStringValue('summary');\n    },\n\n    parseStartAndEndDates: function() {\n      this._processDateValue('start');\n      this._processDateValue('end');\n    },\n\n    parseReminder: function() {\n      var reminder = this._getParameter('reminder');\n      if (!reminder) {\n        return;\n      }\n\n      if (reminder < 0) {\n        this.arguments.push('relativeReminder');\n        this.arguments.push(parseInt(reminder) / 1000);\n      } else {\n        this.arguments.push('absoluteReminder');\n        this.arguments.push(reminder);\n      }\n    },\n\n    parseRecurrence: function() {\n      var recurrenceDict = this._getParameter('recurrence');\n      if (!recurrenceDict) {\n        return;\n      }\n\n      this.parseRecurrenceInterval(recurrenceDict);\n      this.parseRecurrenceFrequency(recurrenceDict);\n      this.parseRecurrenceEndDate(recurrenceDict);\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInWeek');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInMonth');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'daysInYear');\n      this.parseRecurrenceArrayValue(recurrenceDict, 'monthsInYear');\n    },\n\n    parseTransparency: function() {\n      var validValues = ['opaque', 'transparent'];\n\n      if (this.parameters.hasOwnProperty('transparency')) {\n        var transparency = this.parameters['transparency'];\n        if (contains(transparency, validValues)) {\n          this.arguments.push('transparency');\n          this.arguments.push(transparency);\n        } else {\n          this.errors.push('transparency must be opaque or transparent');\n        }\n      }\n    },\n\n    parseRecurrenceArrayValue: function(recurrenceDict, kind) {\n      if (recurrenceDict.hasOwnProperty(kind)) {\n        var array = recurrenceDict[kind];\n        if (!array || !(array instanceof Array)) {\n          this.errors.push(kind + ' must be an array.');\n        } else {\n          var arrayStr = array.join(',');\n          this.arguments.push(kind);\n          this.arguments.push(arrayStr);\n        }\n      }\n    },\n\n    parseRecurrenceInterval: function(recurrenceDict) {\n      if (recurrenceDict.hasOwnProperty('interval')) {\n        var interval = recurrenceDict['interval'];\n        if (!interval) {\n          this.errors.push('Recurrence interval cannot be null.');\n        } else {\n          this.arguments.push('interval');\n          this.arguments.push(interval);\n        }\n      } else {\n        // If a recurrence rule was specified without an interval, use a default value of 1.\n        this.arguments.push('interval');\n        this.arguments.push(1);\n      }\n    },\n\n    parseRecurrenceFrequency: function(recurrenceDict) {\n      if (recurrenceDict.hasOwnProperty('frequency')) {\n        var frequency = recurrenceDict['frequency'];\n        var validFrequencies = ['daily', 'weekly', 'monthly', 'yearly'];\n        if (contains(frequency, validFrequencies)) {\n          this.arguments.push('frequency');\n          this.arguments.push(frequency);\n        } else {\n          this.errors.push('Recurrence frequency must be one of: \"daily\", \"weekly\", \"monthly\", \"yearly\".');\n        }\n      }\n    },\n\n    parseRecurrenceEndDate: function(recurrenceDict) {\n      var expires = recurrenceDict['expires'];\n\n      if (!expires) {\n        return;\n      }\n\n      this.arguments.push('expires');\n      this.arguments.push(expires);\n    },\n\n    _getParameter: function(key) {\n      if (this.parameters.hasOwnProperty(key)) {\n        return this.parameters[key];\n      }\n\n      return null;\n    },\n\n    _processStringValue: function(kind) {\n      if (this.parameters.hasOwnProperty(kind)) {\n        var value = this.parameters[kind];\n        this.arguments.push(kind);\n        this.arguments.push(value);\n      }\n    },\n\n    _processDateValue: function(kind) {\n      if (this.parameters.hasOwnProperty(kind)) {\n        var dateString = this._getParameter(kind);\n        this.arguments.push(kind);\n        this.arguments.push(dateString);\n      }\n    },\n  };\n}());\n</script>"), "text/html", "UTF-8", null);
    }

    public void loadUrl(String s)
    {
        if (s == null)
        {
            return;
        }
        if (s.startsWith("javascript:"))
        {
            super.loadUrl(s);
            return;
        }
        org.apache.http.impl.client.DefaultHttpClient defaulthttpclient = HttpClientFactory.create();
        String s1 = "";
        HttpEntity httpentity;
        String s2;
        try
        {
            HttpGet httpget = new HttpGet(s);
            httpget.setHeader("User-Agent", System.getProperty("http.agent"));
            httpentity = defaulthttpclient.execute(httpget).getEntity();
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.d("MoPub", (new StringBuilder("Mraid loadUrl failed (IllegalArgumentException): ")).append(s).toString());
            notifyOnFailureListener();
            return;
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            notifyOnFailureListener();
            return;
        }
        catch (IOException ioexception)
        {
            notifyOnFailureListener();
            return;
        }
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s2 = Strings.fromStream(httpentity.getContent());
        s1 = s2;
        loadHtmlData(s1);
        return;
    }

    public void onResetUserClick()
    {
        mClicked = false;
    }

    public void onUserClick()
    {
        mClicked = true;
    }

    void setMraidDisplayController(MraidDisplayController mraiddisplaycontroller)
    {
        mDisplayController = mraiddisplaycontroller;
    }

    public void setMraidListener(MraidListener mraidlistener)
    {
        mListenerInfo.mMraidListener = mraidlistener;
    }

    public void setOnCloseButtonStateChange(OnCloseButtonStateChangeListener onclosebuttonstatechangelistener)
    {
        mListenerInfo.mOnCloseButtonListener = onclosebuttonstatechangelistener;
    }

    public void setOnOpenListener(OnOpenListener onopenlistener)
    {
        mListenerInfo.mOnOpenListener = onopenlistener;
    }

    public boolean wasClicked()
    {
        return mClicked;
    }







    private class ExpansionStyle extends Enum
    {

        public static final ExpansionStyle DISABLED;
        public static final ExpansionStyle ENABLED;
        private static final ExpansionStyle ENUM$VALUES[];

        public static ExpansionStyle valueOf(String s)
        {
            return (ExpansionStyle)Enum.valueOf(com/adsdk/sdk/mraid/MraidView$ExpansionStyle, s);
        }

        public static ExpansionStyle[] values()
        {
            ExpansionStyle aexpansionstyle[] = ENUM$VALUES;
            int i = aexpansionstyle.length;
            ExpansionStyle aexpansionstyle1[] = new ExpansionStyle[i];
            System.arraycopy(aexpansionstyle, 0, aexpansionstyle1, 0, i);
            return aexpansionstyle1;
        }

        static 
        {
            ENABLED = new ExpansionStyle("ENABLED", 0);
            DISABLED = new ExpansionStyle("DISABLED", 1);
            ExpansionStyle aexpansionstyle[] = new ExpansionStyle[2];
            aexpansionstyle[0] = ENABLED;
            aexpansionstyle[1] = DISABLED;
            ENUM$VALUES = aexpansionstyle;
        }

        private ExpansionStyle(String s, int i)
        {
            super(s, i);
        }
    }


    private class NativeCloseButtonStyle extends Enum
    {

        public static final NativeCloseButtonStyle AD_CONTROLLED;
        public static final NativeCloseButtonStyle ALWAYS_HIDDEN;
        public static final NativeCloseButtonStyle ALWAYS_VISIBLE;
        private static final NativeCloseButtonStyle ENUM$VALUES[];

        public static NativeCloseButtonStyle valueOf(String s)
        {
            return (NativeCloseButtonStyle)Enum.valueOf(com/adsdk/sdk/mraid/MraidView$NativeCloseButtonStyle, s);
        }

        public static NativeCloseButtonStyle[] values()
        {
            NativeCloseButtonStyle anativeclosebuttonstyle[] = ENUM$VALUES;
            int i = anativeclosebuttonstyle.length;
            NativeCloseButtonStyle anativeclosebuttonstyle1[] = new NativeCloseButtonStyle[i];
            System.arraycopy(anativeclosebuttonstyle, 0, anativeclosebuttonstyle1, 0, i);
            return anativeclosebuttonstyle1;
        }

        static 
        {
            ALWAYS_VISIBLE = new NativeCloseButtonStyle("ALWAYS_VISIBLE", 0);
            ALWAYS_HIDDEN = new NativeCloseButtonStyle("ALWAYS_HIDDEN", 1);
            AD_CONTROLLED = new NativeCloseButtonStyle("AD_CONTROLLED", 2);
            NativeCloseButtonStyle anativeclosebuttonstyle[] = new NativeCloseButtonStyle[3];
            anativeclosebuttonstyle[0] = ALWAYS_VISIBLE;
            anativeclosebuttonstyle[1] = ALWAYS_HIDDEN;
            anativeclosebuttonstyle[2] = AD_CONTROLLED;
            ENUM$VALUES = anativeclosebuttonstyle;
        }

        private NativeCloseButtonStyle(String s, int i)
        {
            super(s, i);
        }
    }


    private class PlacementType extends Enum
    {

        private static final PlacementType ENUM$VALUES[];
        public static final PlacementType INLINE;
        public static final PlacementType INTERSTITIAL;

        public static PlacementType valueOf(String s)
        {
            return (PlacementType)Enum.valueOf(com/adsdk/sdk/mraid/MraidView$PlacementType, s);
        }

        public static PlacementType[] values()
        {
            PlacementType aplacementtype[] = ENUM$VALUES;
            int i = aplacementtype.length;
            PlacementType aplacementtype1[] = new PlacementType[i];
            System.arraycopy(aplacementtype, 0, aplacementtype1, 0, i);
            return aplacementtype1;
        }

        static 
        {
            INLINE = new PlacementType("INLINE", 0);
            INTERSTITIAL = new PlacementType("INTERSTITIAL", 1);
            PlacementType aplacementtype[] = new PlacementType[2];
            aplacementtype[0] = INLINE;
            aplacementtype[1] = INTERSTITIAL;
            ENUM$VALUES = aplacementtype;
        }

        private PlacementType(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls1
        implements android.view.View.OnTouchListener
    {

        final MraidView this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            mViewGestureDetector.sendTouchEvent(motionevent);
            motionevent.getAction();
            JVM INSTR tableswitch 0 1: default 36
        //                       0 38
        //                       1 38;
               goto _L1 _L2 _L2
_L1:
            return false;
_L2:
            if (!view.hasFocus())
            {
                view.requestFocus();
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        _cls1()
        {
            this$0 = MraidView.this;
            super();
        }
    }


    private class MraidWebViewClient extends WebViewClient
    {

        final MraidView this$0;

        public void onLoadResource(WebView webview, String s)
        {
            Log.d("MraidView", (new StringBuilder("Loaded resource: ")).append(s).toString());
        }

        public void onPageFinished(WebView webview, String s)
        {
            if (!mHasFiredReadyEvent)
            {
                mDisplayController.initializeJavaScriptState();
                fireChangeEventForProperty(MraidPlacementTypeProperty.createWithType(mPlacementType));
                fireReadyEvent();
                if (getMraidListener() != null)
                {
                    getMraidListener().onReady(MraidView.this);
                }
                mHasFiredReadyEvent = true;
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            Log.d("MraidView", (new StringBuilder("Error: ")).append(s).toString());
            super.onReceivedError(webview, i, s, s1);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            String s1 = Uri.parse(s).getScheme();
            if (s1.equals("mopub"))
            {
                return true;
            }
            if (s1.equals("mraid"))
            {
                tryCommand(URI.create(s));
                return true;
            }
            if (wasClicked())
            {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(s));
                intent.addFlags(0x10000000);
                try
                {
                    getContext().startActivity(intent);
                }
                catch (ActivityNotFoundException activitynotfoundexception)
                {
                    return false;
                }
                return true;
            } else
            {
                return false;
            }
        }

        private MraidWebViewClient()
        {
            this$0 = MraidView.this;
            super();
        }

        MraidWebViewClient(MraidWebViewClient mraidwebviewclient)
        {
            this();
        }
    }


    private class MraidListenerInfo
    {

        private MraidListener mMraidListener;
        private OnCloseButtonStateChangeListener mOnCloseButtonListener;
        private OnOpenListener mOnOpenListener;







        MraidListenerInfo()
        {
        }
    }


    private class MraidListener
    {

        public abstract void onClose(MraidView mraidview, ViewState viewstate);

        public abstract void onExpand(MraidView mraidview);

        public abstract void onFailure(MraidView mraidview);

        public abstract void onReady(MraidView mraidview);
    }

}
