package com.whiteSpace.ws.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.whiteSpace.domain.common.types.Notification;

/**
 * @author Shivakumar N
 *
 * @since Jan 22, 2013 4:42:50 PM
 */

public class TxtWebPush{

    private static final long serialVersionUID = 5704094472222822353L;
    private static final String appKey = "cc2430ed-db9b-4687-b4e9-292038f44eb2";
    private static final String pubKey = "094BADB5-C418-4877-B11A-94E8D4431EB2";
    
	public void processRequest(List<Notification> notificationList, String mobile){

		String mobileHash =mobile;
        String message = notificationList.get(0).getData();
        if(mobileHash == null)
            mobileHash = "";
        if(message == null)
            message = "";
        String response = "Trying to push a message to your mobile<br/>";
        System.out.println(message);
        int result = sendPushMessage(message, mobileHash);
        /*
        0
        Success!
        -1
        Unknown Exception(Usually Server side)
        Have a retry logic in place to call the API again in case such an error code is received or wait till the APIs are back to being functional.
        -3
        Invalid input
        Incorrect format for calling the API Ð Check the right syntax for making the API call
        -101
        No such mobile
        mobile number does not exist
        -103
        MAX Publisher Allocation exceeded
        No more than 250 messages per 5 minutes per mobile number
        No more than 20 messages per 10 seconds per mobile number
        -104
        Number registered with NCPR
        -300
        Missing publisher key
        Get your publisher key under ÒBuild and Manage my apps sectionÓ on txtWeb.com and include it in the parameter list of the API call
        -301
        Incorrect publisher key
        Check and verify your publisher key under ÒBuild and Manage my apps sectionÓ on txtWeb.com against the one you have sent in the API request call
        -400
        Missing application key
        Get the application key of the app under ÒBuild and Manage my apps sectionÓ on txtWeb.com and include it in the message body list of the API call
        -401
        Incorrect application key
        Check and verify the application key for the app under ÒBuild and Manage my apps sectionÓ on txtWeb.com against the one you have sent in the API request call
        -402
        Maximum Throttle exceeded
        No more than 5,000 API calls in a single day
        -500
        Mobile opted out
        If a mobile number has opted out from receiving any message from the app
        -600
        Missing message
        Check if you have included the message to be sent in the right format
         */
        if (result == 0) {
            response += "Message sent successfully!";
        }
        else if ( result == -1) {
            //try again
            int tryResult = sendPushMessage(message, mobileHash);
            response += "Result after trying again "+ tryResult ;
        }
        else {
            response += "!!!Error occured!!!<br/>Error code : "+ result;
        }
        System.err.println(response);
       // sendResponse(httpResponse, response);
    }
    public static int sendPushMessage(String message, String mobileHash) {
        String head = "<html>"
            +"<head>"
            +"<meta name=\"txtweb-appkey\" content=\""+appKey+"\">"
            +"</head>"
            +"<body>";
        String tail = "</body></html>";
        String htmlMessage = head + message + tail; 
        try{
            String urlParams =     "txtweb-message="+URLEncoder.encode(htmlMessage,"UTF-8")
            +"&txtweb-mobile="+URLEncoder.encode(mobileHash,"UTF-8")
            +"&txtweb-pubkey="+URLEncoder.encode(pubKey,"UTF-8");
            //Using DOM parser to parse the XML response from the API
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            URLConnection conn = new URL("http://api.txtweb.com/v1/push").openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(urlParams);
            wr.flush();
            
            Document doc = db.parse(conn.getInputStream());
            NodeList statusNodes = doc.getElementsByTagName("status");
            String code = "-1";
            for(int index = 0; index < statusNodes.getLength(); index++){
                Node childNode = statusNodes.item(index);
                if( childNode.getNodeType() == Node.ELEMENT_NODE ){
                    Element element = (Element) childNode;
                    code = getTagValue("code", element);                    
                    return Integer.parseInt(code);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return -999; //APPLICATION ERROR
    }
    private static String getTagValue(String sTag, Element eElement) {
        NodeList nodeList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
	
	public static void main(String args[]){
		String mobile = "cc56a1cc-ae95-4e8f-b4df-6a9cf7d03837";
		
		TxtWebPush push = new TxtWebPush();
		List<Notification> list =  new ArrayList<Notification>();
		Notification notification = new Notification();
		notification.setData("huhha haaha .. i can hack into ur mobile :P ");
		
		list.add(notification);
		push.processRequest(list, mobile);
	}

}
