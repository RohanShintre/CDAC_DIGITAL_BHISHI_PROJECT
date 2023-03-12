package rest.otp;

import java.util.Random;
public class Otp {
    public static String generateOtp(int otpLenght) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < otpLenght; i++) {
            sb.append(random.nextInt(10));
        }
        String otp = sb.toString();
        return otp;
    }
}
