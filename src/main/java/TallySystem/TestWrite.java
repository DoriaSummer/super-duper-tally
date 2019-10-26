package TallySystem;
// Initial delegates data, must be deleted after use.
public class TestWrite {

    public static void main(String[] args) {

        JdbcUtil db = JdbcUtil.GetInstance();
        int res = 0;
/*
        String createSqlStr = "CREATE TABLE IF NOT EXISTS delegate (\n" +
                "   `delegate_id` INT UNSIGNED AUTO_INCREMENT,\n" +
                "   `delegate_name` VARCHAR(100) NOT NULL UNIQUE,\n" +
                "   `delegate_pwd` VARCHAR(40) NOT NULL,\n" +
                "   PRIMARY KEY ( `delegate_id` )\n" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        int res = db.executeUpdate(createSqlStr, null);
*/
        String account1 = "Dumbledore";
        String password1 = JdbcUtil.GenerateMd5("DumbledoreAccioData");

        String account2 = "McGonagall";
        String password2 = JdbcUtil.GenerateMd5("McGonagallIncendio");

        String sqlStr = "INSERT INTO delegate (delegate_id, delegate_name, delegate_pwd) VALUES (delegate_id, ?, ?);";

        res = db.executeUpdate(sqlStr, account1, password1);
        System.out.println("res:" + res);
        res = db.executeUpdate(sqlStr, account2, password2);
        System.out.println("res:" + res);

        // String sqlStr = "UPDATE delegate SET delegate_pwd = ? WHERE delegate_name = ?";
        // int res = db.executeUpdate(sqlStr, JdbcUtil.GenerateMd5(password1), account1);
        // System.out.println("res:" + res);
        db.closeAll();
    }

}
