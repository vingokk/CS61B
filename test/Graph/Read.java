/** Read xlsx file as an array. *
 * @source https://blog.csdn.net/sinat_22797429/article/details/52900152
 */

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class Read {
    public static void main(String[] args) {
        jxl.Workbook readwb = null;
        // List<String> list = new ArrayList<String>();
        try {
            // 构建Workbook对象, 只读Workbook对象 直接从本地文件创建Workbook
            readwb = Workbook.getWorkbook(new FileInputStream(new File("./time.xlsx")));
            // Sheet的下标是从0开始 获取第一张Sheet表
            Sheet readsheet = readwb.getSheet(0);
            // 获取Sheet表中所包含的总列数
            int rsColumns = readsheet.getColumns();
            // 获取Sheet表中所包含的总行数
            int rsRows = readsheet.getRows();
            // 获取指定单元格的对象引用
            String[][] arr = (new String[rsColumns][rsRows]);
            for (int i = 0; i < rsColumns; i++) {
                for (int j = 0; j < rsRows; j++) {
                    Cell cell = readsheet.getCell(i, j);
                    // System.out.print(cell.getContents() + " ");
                    // list.add(cell.getContents());
                    arr[i][j] = cell.getContents();
                }
            }
            for (int i = 0; i < rsColumns; i++) {
                for (int j = 0; j < rsRows; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println("------------数据分割线-----------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readwb.close();
        }
    }
}