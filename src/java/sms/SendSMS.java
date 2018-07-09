/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import cart.CartInfo;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SendSMS {

    private static String username = "demopack";
    private static String password = "pack@1234";

    private static String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        SendSMS http = new SendSMS();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendSms("8796154522", "!hi, how's that?\nAre you in \"pain\"?");

    }

    // HTTP GET request
    public static void sendSms(String reciever, String message) throws Exception {

        String msg = URLEncoder.encode(message);
        String sms_url = "http://websms.bulksmspack.com/index.php/smsapi/httpapi/?uname="+username+"&password="+password+"&sender=SMSPCK&receiver="+reciever+"&route=TA&msgtype=3&sms="+msg;

        URL obj = new URL(sms_url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + sms_url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
    
    public static String get_check_out_sms(String service_name, float amount) {
        String check_out_sms = "Dear Customer\nYou have taken following service/packages: \n" + service_name 
                + "\nYour bill amount is " + amount + " INR."
                + "Thank you for your visit.";
        
        return check_out_sms;
    }
    
    public static String get_package_sms() {
        String package_sms = "Dear Customer\nYou have consumed a service from your package.";
        
        return package_sms;
    }

}
