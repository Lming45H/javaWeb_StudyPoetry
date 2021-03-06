package com.lushannanlu;

import com.alibaba.fastjson.JSON;
import com.csvreader.CsvReader;
import org.apache.ibatis.session.SqlSession;
import com.lushannanlu.pojo.Poetry;
import com.lushannanlu.utils.MybatisUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void readPoetry(){
        ArrayList<String> strings = readCsvByCsvReader("C:\\Users\\26728\\Desktop\\PoetryLibrary\\2_秦朝\\555-556.csv");
        System.out.println(strings);
    }
    public static ArrayList<String> readCsvByCsvReader(String filePath) {
        ArrayList<String> strList = null;
        try {
            ArrayList<String[]> arrList = new ArrayList<String[]>();
            strList = new ArrayList<String>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));
            while (reader.readRecord()) {
//                System.out.println(Arrays.asList(reader.getValues()));
                arrList.add(reader.getValues()); // 按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + arrList.size());
            // 如果要返回 String[] 类型的 list 集合，则直接返回 arrList
            // 以下步骤是把 String[] 类型的 list 集合转化为 String 类型的 list 集合
            for (int row = 0; row < arrList.size(); row++) {
                // 组装String字符串
                // 如果不知道有多少列，则可再加一个循环
                String ele = arrList.get(row)[0] + "," + arrList.get(row)[1] + ","
                        + arrList.get(row)[2] + "," + arrList.get(row)[3]+","+arrList.get(row)[4] ;
//                System.out.println(ele);
                strList.add(ele);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strList;
    }

    @org.junit.Test
    public void readCsv(){
        ArrayList<Poetry> poetries = new ArrayList<>();
        ArrayList<String[]> csvFileList = new ArrayList<String[]>();

        String csvFilePath = "C:\\Users\\26728\\Desktop\\PoetryLibrary\\2_秦朝\\555-556.csv";

        try {
            CsvReader csvReader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
            //跳过表头
            //boolean b = csvReader.readHeaders();

            while(csvReader.readRecord()){
//                System.out.println(csvReader.getRawRecord());//读取一条记录
                csvFileList.add(csvReader.getValues());
            }
            csvReader.close();

            for (int row = 1;row<csvFileList.size();row++){
                poetries.add(new Poetry(csvFileList.get(row)[1],csvFileList.get(row)[2],csvFileList.get(row)[3],csvFileList.get(row)[4]));
            }
            ArrayList<Object> objects = new ArrayList<>();
            for (Poetry poetry : poetries) {
                objects.add(JSON.toJSON(poetry));
            }
            String s = JSON.toJSONString(objects);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @org.junit.Test
    public void testMybatis(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        System.out.println(sqlSession);
    }
}
