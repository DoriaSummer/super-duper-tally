package tally;

public class Delegate {
    private static Delegate s_instance = null;
    private String delegateID = "";
    private String delegateName = "";
    private String delegatePwd = "";
    private boolean isLogin = false;

    private Delegate() {
    }

    public static Delegate GetInstance() {
        if (s_instance == null) {
            s_instance = new Delegate();
        }
        return s_instance;
    }

    public String getUserID(){
        return delegateID;
    }
    public String getUserName(){
        return delegateName;
    }
    public String getUserPsw(){
        return delegatePwd;
    }
    public boolean getIsLogin(){
        return isLogin;
    }

    public void login(String id, String acc, String pwd){
        delegateID = id;
        delegateName = acc;
        delegatePwd = pwd;
        isLogin = true;
    }
    public void logout(){
        isLogin = false;
        delegateID = "";
        delegateName = "";
        delegatePwd = "";
    }
}
