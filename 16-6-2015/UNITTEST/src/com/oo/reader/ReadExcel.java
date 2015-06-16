/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oo.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author hoaibao
 */
public class ReadExcel {

    private String inputFile;
    private int sheet;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public ReadExcel() {
    }

    public ReadExcel(String inputFile, int sheet) {
        this.inputFile = inputFile;
        this.sheet = sheet;

    }

    public Collection read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        List rows = new ArrayList();
        List rowData = new ArrayList();
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(this.sheet);
            // Loop over first 10 column and lines
            for (int j = 1; j < sheet.getRows(); j++) {
                rowData.clear();
                for (int i = 0; i < sheet.getColumns(); i++) {
                    if (i == 2 || i == 3) {
                        Cell cell = sheet.getCell(i, j);
                        CellType type = cell.getType();
                       if(type == CellType.LABEL)
                            rowData.add(cell.getContents());
                       else if(type== CellType.NUMBER)
                            rowData.add(Integer.parseInt(cell.getContents()));
                       else
                           rowData.add(cell.getContents());
                        System.out.print(cell.getContents());
                    }
                }
                rows.add(rowData.toArray());
                System.out.println("");
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
