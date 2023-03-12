package rest.pojo;

public class Login {
    String mobileNo;
    String password;

    public Login(String mobileNo, String password) {
        this.mobileNo = mobileNo;
        this.password = password;
    }

    public Login() {
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


