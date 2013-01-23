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

import com.whiteSpace.domain.common.types.Notification;

/**
 * @author Shivakumar N
 *
 * @since Jan 22, 2013 4:42:50 PM
 */

public class TxtWebPush{

	public void processRequest(List<Notification> notificationList, String mobile){

		try{
			if(mobile!=null &&
					!mobile.isEmpty()){
				String url = "http://api.txtweb.com/v1/push";
				String data = "";
				data += URLEncoder.encode("txtweb-mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8");
				data += "&";
				data += URLEncoder.encode("txtweb-message", "UTF-8") + "=" + URLEncoder.encode("<HTML><head><meta name=\"txtweb-appkey\" content=\"d4cea360-7f86-4235-bcb6-850489b2cd22\"></head>" +
						"<BODY>", "UTF-8");	
				int i = 1;
				for ( Notification notification : notificationList) {
					data = notification.getData();
				}
				data +=	URLEncoder.encode("</BODY></HTML>", "UTF-8");
				data += "&";
				data += URLEncoder.encode("txtweb-pubkey", "UTF-8") + "=" + URLEncoder.encode("094BADB5-C418-4877-B11A-94E8D4431EB2", "UTF-8");
				URLConnection conn = new URL(url).openConnection();
				System.out.println("TxtWebPush.processRequest()"+data);
				conn.setDoOutput(true);
				OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
				System.out.println();
				wr.write(data);
				wr.flush();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
			//	PrintWriter printWriter = response.getWriter();
				while((line = br.readLine())!=null){
					System.err.println(line);
				}
				br.close();
			}
		}
		catch(UnsupportedEncodingException e){e.printStackTrace();} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		String mobile = "77035B27-E60E-4844-9F78-C35404BCA0BD";
		
		TxtWebPush push = new TxtWebPush();
		List<Notification> list =  new ArrayList<Notification>();
		Notification notification = new Notification();
		notification.setData("hello from sakathOta");
		
		list.add(notification);
		push.processRequest(list, mobile);
	}

}
