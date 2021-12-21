package com.example.demo.service.impl;

import com.example.demo.entitiy.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<User> users;


    public ExcelServiceImpl(List<User> users) {
        this.users = users;
        workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle cellStyle) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);

        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }

        cell.setCellStyle(cellStyle);
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("User");
        Row row = sheet.createRow(0);
        CellStyle cellStyle = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        font.setBold(Boolean.TRUE);
        font.setFontHeight(20);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        this.createCell(row, 0, "User info", cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        font.setFontHeightInPoints((short) 10);

        row = sheet.createRow(1);
        font.setBold(Boolean.TRUE);
        font.setFontHeight(16);
        cellStyle.setFont(font);

        this.createCell(row, 0, "ID", cellStyle);
        this.createCell(row, 1, "Username", cellStyle);
        this.createCell(row, 2, "Email", cellStyle);
        this.createCell(row, 3, "Company", cellStyle);
        this.createCell(row, 4, "Create Time", cellStyle);
        this.createCell(row, 5, "Update Time", cellStyle);
    }

    private void writeDataLines() {
        int rowCount = 2;

        CellStyle cellStyle = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        cellStyle.setFont(font);

        for (User user : users) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, user.getId(), cellStyle);
            createCell(row, columnCount++, user.getUsername(), cellStyle);
            createCell(row, columnCount++, user.getEmail(), cellStyle);
            createCell(row, columnCount++, user.getCompany().getName(), cellStyle);
            createCell(row, columnCount++, user.getCreateAt(), cellStyle);
            createCell(row, columnCount++, user.getUpdateAt(), cellStyle);
        }
    }

    private void export(HttpServletResponse response) throws IOException {
        this.writeHeaderLine();
        this.writeDataLines();

        ServletOutputStream servletOutputStream = response.getOutputStream();
        workbook.write(servletOutputStream);
        workbook.close();
    }


}
