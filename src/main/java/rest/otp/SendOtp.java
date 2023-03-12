package rest.otp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SendOtp {
    public static void sendOtp(String message,  String number, String apiKey) {
        try {
            String sendId="FTWSMS";
            String language = "english";
            String route = "v3";

            message = URLEncoder.encode(message, "UTF-8");

            //	String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN&route=v3&sender_id=FTWSMS&message="+message+"&language=english&flash=0&numbers="+number;
            String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&route="+route+"&sender_id="+sendId+"&message="+message+"&language="+language+"&flash=0&numbers="+number;
            URL url = new URL(myUrl);
            HttpsURLConnection  con = (HttpsURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("cache-control", "no-cache");
            System.out.println("Wait...");
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            StringBuffer response = new StringBuffer("");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while(true) {
                String line = br.readLine();
                if(line == null ) {
                    break;
                }
                response.append(line);

            }
            System.out.println("RESPONSE: " + response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        //System.out.println("Program Started.... ");
        Otp otp = new Otp();
        String otpMessage = otp.generateOtp(4);
        //System.out.println("Generated otp: " + otpMessage);
        String apiKey = "Rr36ehDsQwlLx4G925FvcXnNbmWZSPHa1pfT8OygYEIzVCMU0k98YW1XVdDhUmctBTvspouFOgr6QkCN";
        String number = "9766594665";
        sendOtp(otpMessage, number, apiKey);
    }
}
