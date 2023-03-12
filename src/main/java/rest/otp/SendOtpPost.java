package rest.otp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
public class SendOtpPost {
    public static void sendOtp(String message,  String number, String apiKey) throws Exception {
        String sendId="FTWSMS";
        String language = "english";
        String route = "v3";

        message = URLEncoder.encode(message, "UTF-8");

        //String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN&route=v3&sender_id=FTWSMS&message="+message+"&language=english&flash=0&numbers="+number;
        String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&route="+route+"&sender_id="+sendId+"&message="+message+"&language="+language+"&flash=0&numbers="+number;
        URL url = new URL(myUrl);
        HttpsURLConnection  con = (HttpsURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("cache-control", "no-cache");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type","application/json");

        con.setRequestProperty("authorization", "Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN");
        con.setRequestProperty("Content-Type","application/json");

//		{
//
//			"authorization":"Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN"
//			"Content-Type":"application/json"
//			}

        String postJsonData = "{\r\n"
                + "\r\n"
                + "\"route\" : \"v3\",\r\n"
                + "\"sender_id\" : \"FTWSMS\",\r\n"
                + "\"message\": message"
                + "\"language\" : \"english\",\r\n"
                + "\"flash\" : 0,\r\n"
                + "\"numbers\" : number"
                + "}";

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postJsonData);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("nSending 'POST' request to URL : " + url);
        System.out.println("Post Data : " + postJsonData);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();

        //printing result from response
        System.out.println(response.toString());


    }
}
