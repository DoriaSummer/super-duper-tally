package TallySystem;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;
import java.util.*;

// Connection to the database
public class JdbcUtil {
    private String m_driverAddress = "com.mysql.cj.jdbc.Driver";
    private String m_dbUrl = "jdbc:mysql://localhost:3306/VOTESYS?useSSL=false&serverTimezone=UTC";
    private String m_user = "root";
    private String m_psw = "duper6@@";
    private static JdbcUtil g_instance = null;
    private Connection m_conn = null;
    private static final String S_SALT_KEY = "";

    private JdbcUtil() {
        loadProperty();
    }

    public static JdbcUtil GetInstance() {
        if (g_instance == null) {
            g_instance = new JdbcUtil();
        }
        return g_instance;
    }

    private void loadProperty() {
        InputStream iStream = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
        if (iStream == null) {
            System.out.println("Cannot find config file db.properties, use default value.");
            return;
        }
        Properties prop = new Properties();
        try {
            prop.load(iStream);
            m_driverAddress = prop.getProperty("driver");
            m_dbUrl = prop.getProperty("url");
            m_user = prop.getProperty("user");
            m_psw = prop.getProperty("psw");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        if (m_conn == null) {
            // load driver
            try {
                Class.forName(m_driverAddress);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // connect to DB
            try {
                m_conn = DriverManager.getConnection(m_dbUrl, m_user, m_psw);
                if (!m_conn.isClosed()) {
                    System.out.println("Connect db succeed");
                }
            } catch (SQLException e) {
                System.out.println("Connect db failed");
                e.printStackTrace();
            }
        }
        return m_conn;
    }

    public void closeAll() {
        if (m_conn != null) {
            try {
                m_conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        m_conn = null;
    }

    public List<Map<String, Object>> executeQuery(String sqlStr, Object... args) {
        try {
            PreparedStatement ps = getConn().prepareStatement(sqlStr);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            ResultSet resSet = ps.executeQuery();
            List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
            ResultSetMetaData metaDate = resSet.getMetaData();
            int colCount = metaDate.getColumnCount();
            List<String> colNameList = new ArrayList<String>();
            for (int i = 0; i < colCount; i++) {
                colNameList.add(metaDate.getColumnName(i + 1));
            }
            while (resSet.next()) {
                Map map = new HashMap<String, Object>();
                for (int i = 0; i < colCount; i++) {
                    String key = colNameList.get(i);
                    Object value = resSet.getString(colNameList.get(i));
                    map.put(key, value);
                }
                results.add(map);
            }
            ps.close();
            resSet.close();
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String sqlStr, Object... args) {
        try {
            PreparedStatement ps = getConn().prepareStatement(sqlStr);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String GenerateMd5(String dataStr){
        try {
            dataStr = dataStr + S_SALT_KEY;
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] secretBytes = m.digest(dataStr.getBytes("UTF8"));
            String md5code = new BigInteger(1, secretBytes).toString(16);
            for (int i = 0; i < 32 - md5code.length(); i++) {
                md5code = "0" + md5code;
            }
            return md5code;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
