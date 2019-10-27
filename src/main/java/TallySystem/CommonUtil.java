package TallySystem;

import java.io.File;
import java.lang.reflect.Field;

public class CommonUtil {

    public static boolean CheckAccount(String acc) {
        if (acc == null) {
            return false;
        }
        if (acc.matches("^[a-zA-Z][a-zA-Z0-9_]{4,15}$")) {
            String[] reserves = {"root", "daemon", "sync", "shutdown", "halt", "mail", "uucp", "operator", "games", "oprofile", "postgres", "mysql", "rpcuser", "apache", "Pegasus", "webalizer", "haldaemon", "vcsa", "avahi", "tcpdump", "sshd", "dbus", "postfix", "tomcat", "hsqldb", "dovecot", "nobody", "usbmuxd", "abrt", "dovenull", "pulse", "qpidd", "saslauth", "cimsrvr", "rtkit", "nfsnobody"};
            for (String r : reserves) {
                if (acc.equals(r)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean CheckPassword(String pwd) {
        if (pwd == null) {
            return false;
        }
        return pwd.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$");
    }

    public static boolean CheckFileExist(String path) {
        File file = new File(path);
        return file.exists();
    }
}
