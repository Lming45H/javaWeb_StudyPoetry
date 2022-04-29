package com.lushannanlu.service;

import com.csvreader.CsvReader;
import com.lushannanlu.pojo.Poetry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ServicePoetry {

    //从csv中读取诗歌封装成实体类，并返回List
    public ArrayList<Poetry> readCsv(String csvFilePath) {
        ArrayList<Poetry> poetries = new ArrayList<>();
        ArrayList<String[]> csvFileList = new ArrayList<String[]>();

        try {
            CsvReader csvReader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            //跳过表头
            //boolean b = csvReader.readHeaders();

            while (csvReader.readRecord()) {
//                System.out.println(csvReader.getRawRecord());//读取一条记录
                csvFileList.add(csvReader.getValues());
            }
            //关闭流
            csvReader.close();
            //将诗歌封装成List集合
            for (int row = 1; row < csvFileList.size(); row++) {
                poetries.add(new Poetry(csvFileList.get(row)[4], csvFileList.get(row)[3], csvFileList.get(row)[2], csvFileList.get(row)[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return poetries;
    }
}
