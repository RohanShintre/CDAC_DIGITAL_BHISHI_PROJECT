package rest.pojo;

public class Format {
    public static String  formatNumber(String mobileNumber) {
        return mobileNumber.substring(17,27);
    }

    public static String  formatOtp(String otp) {
        return otp.substring(8,12);
    }

}
