import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {


    @Test
    public void writeExcel() throws IOException {

        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\excelfile.xlsx";

        Assert.assertNotNull(filePath);

        //  Open the workbook.
        FileInputStream fis = new FileInputStream(filePath);

        Workbook wb = WorkbookFactory.create(fis);
        //  Open the first worksheet.
        Sheet sheet1 = wb.getSheetAt(0);

        //  Go to the first row.
        Row row1 = sheet1.getRow(0);

        //  Create a cell on the 3rd column (2nd index) on the first row.
        Cell row1cell3 = row1.createCell(0);

        //  Write “POPULATION” on that cell.
        row1cell3.setCellValue("POPULATION");

        //  Create a cell on the 2nd row 3rd cell(index2), and write data.
        sheet1.getRow(1).createCell(2).setCellValue("200000");

        //  Create a cell on the 3rd row 3rd cell(index2), and write data.
        sheet1.getRow(2).createCell(2).setCellValue("600000");

        //  Create a cell on the 4th row 3rd cell(index2), and write data.
        sheet1.getRow(3).createCell(2).setCellValue("800000");

        //  Write and save the workbook.
        FileOutputStream fos = new FileOutputStream(filePath);
        wb.write(fos);

        //  Close the file.
        fis.close();
        fos.close();

        //  Close the workbook.
        wb.close();

    }
}
