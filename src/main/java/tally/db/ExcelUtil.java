package tally.db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static List<List<String>> ReadFile(String path) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        if (!fileType.equals("xls") && !fileType.equals("xlsx")) {
            return null;
        }
        FileInputStream fileIs = null;
        try {
            fileIs = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        Workbook wb = null;
        try {
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(fileIs);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(fileIs);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // only read the first sheet
        Sheet sheet = wb.getSheetAt(0);
        DataFormatter dataForm = new DataFormatter();
        List<List<String>> resultList = new ArrayList<List<String>>();

        // the first line is the titles
        for (Row row : sheet) {
            ArrayList<String> list = new ArrayList<String>();
            for (Cell cell : row) {
                // format to string by type
                if (cell.getCellType() == CellType.STRING) {
                    list.add(cell.getStringCellValue());
                } else {
                    list.add(dataForm.formatCellValue(cell));
                }
            }
            resultList.add(list);
        }
        try {
            wb.close();
            fileIs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static boolean WriteFile(List<List<String>> lists, String[] titles, String sheetName, String path, boolean isAppend) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        if (!fileType.equals("xls") && !fileType.equals("xlsx")) {
            return false;
        }
        Workbook wb = null;
        if (fileType.equals("xls")) {
            wb = new HSSFWorkbook();
        } else if (fileType.equals("xlsx")) {
            wb = new XSSFWorkbook();
        }
        Sheet sheet = wb.createSheet(sheetName);
        for (int i = 0; i < titles.length; i++) {
            sheet.setColumnWidth(i, 20 * 256);
        }
        Row firstRow = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            Cell cell = firstRow.createCell(i);
            cell.setCellValue(titles[i]);
        }
        if (lists != null) {
            for (int i = 1; i <= lists.size(); i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < titles.length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(lists.get(i - 1).get(j));
                }
            }
        }
        boolean isSucceed = false;
        FileOutputStream fileOs = null;
        try {
            fileOs = new FileOutputStream(path, isAppend);
            wb.write(fileOs);
            isSucceed = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                wb.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (null != fileOs) {
                try {
                    fileOs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSucceed;
    }
}
