package tally;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtil {
    private static CsvUtil g_instance = null;
    CsvReader m_csvReader = null;

    private CsvUtil() {
    }
    public static CsvUtil GetInstance() {
        if (g_instance == null) {
            g_instance = new CsvUtil();
        }
        return g_instance;
    }

    /**
     * If you want to read csv file by segment, you should call loadFile() at first,
     * then call readRecord() in a while loop condition
     * @param path file path with suffix
     * @return
     */
    public boolean loadFile(String path) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        if (!fileType.equals("csv")) {
            return false;
        }
        if (m_csvReader != null){
            m_csvReader.close();
        }
        try {
            m_csvReader = new CsvReader(path, ',', Charset.forName("UTF-8"));
            m_csvReader.readHeaders();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean readRecord(List<List<String>> result, int readNum) {
        int count = 0;
        if (m_csvReader == null){
            return false;
        }
        boolean isHaveData = false;
        try {
            while (m_csvReader.readRecord()) {
                result.add(Arrays.asList(m_csvReader.getValues()));
                isHaveData = true;
                count++;
                if (count > readNum){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!isHaveData){
            m_csvReader.close();
        }
        return isHaveData;
    }

    /**
     * get the headers, you should call loadFile() first
     * @return
     */
    public String[] getHeaders() {
        if (m_csvReader != null){
            try {
                return m_csvReader.getHeaders();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * read the whole file
     * @param path file path with suffix
     * @return
     */
    public static List<List<String>> ReadFile(String path, char separator) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        if (!fileType.equals("csv")) {
            return null;
        }
        CsvReader csvReader = null;
        try {
            csvReader = new CsvReader(path, separator, Charset.forName("UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        List<List<String>> resultList = new ArrayList<>();
        try {
            csvReader.readHeaders();
            // String[] headArray = csvReader.getHeaders();
            while (csvReader.readRecord()) {
                // csvReader.getRawRecord()
                resultList.add(Arrays.asList(csvReader.getValues()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != csvReader) {
                csvReader.close();
            }
        }
        return resultList;
    }

    /**
     *
     * @param lists data to store in csv file
     * @param headers first line which is the headers
     * @param path file path with suffix
     * @param isAppend whether to retain previous data
     * @return
     */
    public static boolean WriteFile(List<List<String>> lists, String[] headers, String path, char separator, boolean isAppend) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        if (!fileType.equals("csv")) {
            return false;
        }
        boolean isSuccess = false;
        CsvWriter csvWriter = null;
        FileOutputStream fileOs = null;
        byte[] bom = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        try {
            fileOs = new FileOutputStream(path, isAppend);
            fileOs.write(bom);
            csvWriter = new CsvWriter(fileOs, separator, Charset.forName("UTF-8"));
            csvWriter.writeRecord(headers);
            for (List<String> strList : lists) {
                csvWriter.writeRecord(strList.toArray(new String[strList.size()]));
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != csvWriter) {
                csvWriter.close();
            }
            if (null != fileOs) {
                try {
                    fileOs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }

}
