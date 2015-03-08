// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import com.adsdk.sdk.customevents.CustomEvent;
import com.adsdk.sdk.data.ClickType;
import com.adsdk.sdk.video.VASTParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.adsdk.sdk:
//            RequestAd, Log, AdResponse, RequestException

public class RequestGeneralAd extends RequestAd
{

    private static final int RELOAD_AFTER_NO_AD = 20;

    public RequestGeneralAd()
    {
    }

    public RequestGeneralAd(InputStream inputstream)
    {
        is = inputstream;
        StringBuilder stringbuilder = new StringBuilder("Parse is null");
        boolean flag;
        if (is == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Log.d(stringbuilder.append(flag).toString());
    }

    private String convertStreamToString(InputStream inputstream)
    {
        String s;
        try
        {
            s = (new Scanner(inputstream)).useDelimiter("\\A").next();
        }
        catch (NoSuchElementException nosuchelementexception)
        {
            return "";
        }
        return s;
    }

    private String getAttribute(Document document, String s, String s1)
    {
        Element element = (Element)document.getElementsByTagName(s).item(0);
        if (element != null)
        {
            String s2 = element.getAttribute(s1);
            if (s2.length() != 0)
            {
                return s2;
            }
        }
        return null;
    }

    private List getCustomEvents(Document document)
    {
        int i;
        ArrayList arraylist;
        Element element;
        i = 0;
        arraylist = new ArrayList();
        element = (Element)document.getElementsByTagName("customevents").item(0);
        if (element == null) goto _L2; else goto _L1
_L1:
        NodeList nodelist = element.getElementsByTagName("customevent");
_L5:
        if (i < nodelist.getLength()) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        Element element1 = (Element)nodelist.item(i);
        arraylist.add(new CustomEvent(getTextValue(element1, "class"), getTextValue(element1, "parameter"), getTextValue(element1, "pixel")));
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private int getInteger(String s)
    {
        if (s == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0;
        }
        return i;
    }

    private String getTextValue(Element element, String s)
    {
        NodeList nodelist = element.getElementsByTagName(s);
        if (nodelist.getLength() > 0 && nodelist.item(0).getFirstChild() != null)
        {
            return nodelist.item(0).getFirstChild().getNodeValue();
        } else
        {
            return "";
        }
    }

    private String getValue(Document document, String s)
    {
        Element element = (Element)document.getElementsByTagName(s).item(0);
        if (element != null)
        {
            NodeList nodelist = element.getChildNodes();
            if (nodelist.getLength() > 0)
            {
                return nodelist.item(0).getNodeValue();
            }
        }
        return null;
    }

    private boolean getValueAsBoolean(Document document, String s)
    {
        return "yes".equalsIgnoreCase(getValue(document, s));
    }

    private int getValueAsInt(Document document, String s)
    {
        return getInteger(getValue(document, s));
    }

    AdResponse parse(InputStream inputstream, boolean flag)
    {
        AdResponse adresponse;
        Document document;
        String s1;
        DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
        adresponse = new AdResponse();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        DocumentBuilder documentbuilder;
        InputSource inputsource;
        Element element;
        String s;
        String s4;
        com.adsdk.sdk.video.VideoData videodata;
        try
        {
            adresponse.setCustomEvents(new ArrayList());
            videodata = VASTParser.fillVideoDataFromVast(VASTParser.createVastFromStream(inputstream));
        }
        catch (ParserConfigurationException parserconfigurationexception)
        {
            throw new RequestException("Cannot parse Response", parserconfigurationexception);
        }
        catch (SAXException saxexception)
        {
            throw new RequestException("Cannot parse Response", saxexception);
        }
        catch (IOException ioexception)
        {
            throw new RequestException("Cannot read Response", ioexception);
        }
        catch (Throwable throwable)
        {
            throw new RequestException("Cannot read Response", throwable);
        }
        if (videodata != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        adresponse.setType(2);
        if (adresponse.getRefresh() > 0)
        {
            break MISSING_BLOCK_LABEL_845;
        }
        adresponse.setRefresh(20);
        return adresponse;
        adresponse.setVideoData(videodata);
        adresponse.setType(3);
        return adresponse;
        documentbuilder = documentbuilderfactory.newDocumentBuilder();
        inputsource = new InputSource(inputstream);
        if (Log.LOGGING_ENABLED)
        {
            s4 = convertStreamToString(inputstream);
            Log.d((new StringBuilder("Ad RequestPerform HTTP Response: ")).append(s4).toString());
            inputsource = new InputSource(new ByteArrayInputStream(s4.getBytes("ISO-8859-1")));
        }
        inputsource.setEncoding("ISO-8859-1");
        document = documentbuilder.parse(inputsource);
        element = document.getDocumentElement();
        if (element != null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        throw new RequestException("Document is not an xml");
        s = getValue(document, "error");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        throw new RequestException((new StringBuilder("Error Response received: ")).append(s).toString());
        s1 = element.getAttribute("type");
        element.normalize();
        if (!"imageAd".equalsIgnoreCase(s1)) goto _L2; else goto _L1
_L1:
        adresponse.setType(0);
        adresponse.setBannerWidth(getValueAsInt(document, "bannerwidth"));
        adresponse.setBannerHeight(getValueAsInt(document, "bannerheight"));
        adresponse.setClickType(ClickType.getValue(getValue(document, "clicktype")));
        adresponse.setClickUrl(getValue(document, "clickurl"));
        adresponse.setImageUrl(getValue(document, "imageurl"));
        adresponse.setRefresh(getValueAsInt(document, "refresh"));
        adresponse.setScale(getValueAsBoolean(document, "scale"));
        adresponse.setSkipPreflight(getValueAsBoolean(document, "skippreflight"));
_L3:
        adresponse.setCustomEvents(getCustomEvents(document));
        return adresponse;
_L2:
        String s3;
        if (!"textAd".equalsIgnoreCase(s1))
        {
            break MISSING_BLOCK_LABEL_618;
        }
        adresponse.setType(1);
        adresponse.setText(getValue(document, "htmlString"));
        s3 = getAttribute(document, "htmlString", "skipoverlaybutton");
        Log.i("PARSER", (new StringBuilder("SkipOverlay: ")).append(s3).toString());
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        adresponse.setSkipOverlay(Integer.parseInt(s3));
        adresponse.setClickType(ClickType.getValue(getValue(document, "clicktype")));
        adresponse.setClickUrl(getValue(document, "clickurl"));
        adresponse.setRefresh(getValueAsInt(document, "refresh"));
        adresponse.setScale(getValueAsBoolean(document, "scale"));
        adresponse.setSkipPreflight(getValueAsBoolean(document, "skippreflight"));
          goto _L3
        String s2;
        if (!"mraidAd".equalsIgnoreCase(s1))
        {
            break MISSING_BLOCK_LABEL_784;
        }
        adresponse.setType(4);
        adresponse.setText(getValue(document, "htmlString"));
        s2 = getAttribute(document, "htmlString", "skipoverlaybutton");
        Log.i("PARSER", (new StringBuilder("SkipOverlay: ")).append(s2).toString());
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_702;
        }
        adresponse.setSkipOverlay(Integer.parseInt(s2));
        adresponse.setClickType(ClickType.getValue(getValue(document, "clicktype")));
        adresponse.setClickUrl(getValue(document, "clickurl"));
        adresponse.setUrlType(getValue(document, "urltype"));
        adresponse.setRefresh(0);
        adresponse.setScale(getValueAsBoolean(document, "scale"));
        adresponse.setSkipPreflight(getValueAsBoolean(document, "skippreflight"));
          goto _L3
label0:
        {
            if (!"noAd".equalsIgnoreCase(s1))
            {
                break label0;
            }
            adresponse.setType(2);
            if (adresponse.getRefresh() <= 0)
            {
                adresponse.setRefresh(20);
            }
        }
          goto _L3
        throw new RequestException((new StringBuilder("Unknown response type ")).append(s1).toString());
        return adresponse;
    }

    volatile Object parse(InputStream inputstream, boolean flag)
    {
        return parse(inputstream, flag);
    }

    AdResponse parseTestString()
    {
        return parse(is, false);
    }

    volatile Object parseTestString()
    {
        return parseTestString();
    }
}
