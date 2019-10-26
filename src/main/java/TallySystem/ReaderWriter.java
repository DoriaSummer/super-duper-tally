package TallySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class ReaderWriter {
    public static void main(String[] args) {
        getFromCsv();
        System.out.println("Hello World!");
    }

    public static void getFromExcel() {
        List<List<String>> result = ExcelUtil.ReadFile("test.xlsx");
        for (List<String> ls : result) {
            for (String s : ls) {
                System.out.print(s + ",");
            }
            System.out.println("");
        }
        result.add(new ArrayList<String>() {{
            add("ma");
            add("e");
        }});
        ExcelUtil.WriteFile(result, new String[]{"t1", "t2", "t3", "t4"}, "test1", "new.xls", false);

        JdbcUtil db = JdbcUtil.GetInstance();

        String sqlStr = "DROP TABLE IF EXISTS candidate";
        db.executeUpdate(sqlStr, null);

        sqlStr = "CREATE TABLE IF NOT EXISTS candidate (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "surname VARCHAR(45) NULL," +
                "firstname VARCHAR(45) NULL," +
                "party VARCHAR(100) NULL," +
                "state VARCHAR(15) NULL," +
                "PRIMARY KEY (id)," +
                "UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE);";
        int res = db.executeUpdate(sqlStr, null);
        System.out.println("res:" + res);

        sqlStr = "INSERT INTO candidate (id, surname, firstname, party, state) VALUES (id, ?, ?);";
        res = db.executeUpdate(sqlStr, "Potter", "Harry", "Gryffindor", "Hogwarts");
        System.out.println("res:" + res);

        sqlStr = "SELECT * FROM candidate;";
        List<Map<String, Object>> resList = db.executeQuery(sqlStr, null);
        if (resList != null) {
            System.out.println("res:" + resList);
        }
        db.closeAll();
    }

    public static void getFromCsv() {
        List<List<String>> result = CsvUtil.ReadFile("SenateCandidates2016RandomOrder.csv", ',');
        //CsvUtil.WriteFile(result, new String[]{"t1", "t2", "t3", "t4"}, "new.csv", ';', false);
        JdbcUtil db = JdbcUtil.GetInstance();

        String sqlStr = "DROP TABLE IF EXISTS candidate";
        db.executeUpdate(sqlStr, null);

        sqlStr = "CREATE TABLE IF NOT EXISTS candidate (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "surname VARCHAR(45) NULL," +
                "firstname VARCHAR(45) NULL," +
                "party VARCHAR(100) NULL," +
                "state VARCHAR(15) NULL," +
                "PRIMARY KEY (id)," +
                "UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE);";
        int res = db.executeUpdate(sqlStr, null);
        System.out.println("res:" + res);

        sqlStr = "INSERT INTO candidate (id, state, party, surname, firstname) VALUES (id, ?, ?, ?, ?);";
        for (List<String> ls: result){
            if (ls.size() == 4){
                res = db.executeUpdate(sqlStr, ls.get(0), ls.get(1),ls.get(2),ls.get(3));
                if (res == 0){
                    System.out.println(":Fail data:" + ls);
                }
            }
        }
        System.out.println("res:" + res);

        sqlStr = "SELECT * FROM candidate;";
        List<Map<String, Object>> resList = db.executeQuery(sqlStr, null);
        if (resList != null) {
            System.out.println("res:" + resList);
        }
        db.closeAll();
    }
}
