package com.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jinglv
 * @date 2023/4/20 15:14
 */
public class FakerUtils {

    /**
     * 将csv文件中的数据转为二维数组
     *
     * @param fileName csv文件
     * @return 数据的二维数组
     */
    public static Object[][] getTestData(String fileName) {
        String projectRoot = new File("").getAbsolutePath();
        String charset = "utf-8";
        List<String[]> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(Files.newInputStream(new File(projectRoot + fileName).toPath()), charset))).build()) {
            csvReader.skip(1);
            for (String[] strings : csvReader) {
                list.add(strings);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[][] data = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            data[i] = list.get(i);
        }
        return data;
    }
}
