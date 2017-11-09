/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.eden.demo.common.spark;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

/**
 * Create by zhaoxianghui on 17/7/11.
 */
public class WordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    private static final String DB_URL =
            "jdbc:mysql://10.94.219.87:8036/fcore_loan_0?useUnicode=true&characterEncoding=utf-8&allowMultiQueries"
                    + "=true&zeroDateTimeBehavior=convertToNull";

    private static final String DB_USER = "zhukun03";

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    private static final String DB_PASSWORD = "83Qf249Bt4";

    private static final int TABLE_NUM = 15;

    public static void main(String[] args) throws Exception {

        SparkSession spark = SparkSession.builder().appName("JavaWordCount").master("local").getOrCreate();


        spark.conf().set("time", 100);



        Dataset<Row> data = spark.read().csv("/Users/baidu/data/loan/H_TRANSACTION_0_0");

        data.filter(functions.col("_c2").gt(10000)).groupBy("_c3").sum("_c2").show();

        SparkConf conf = new SparkConf().setAppName("JavaWordCount").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Row> peopleRDD = spark.read().csv("/Users/baidu/data/loan/H_TRANSACTION_0_0")
                                            .toJavaRDD();

        String schemaString = "time id amount code";


        List<StructField> fields = new ArrayList<>();
        for (String fieldName : schemaString.split(" ")) {
            StructField field = DataTypes.createStructField(fieldName, DataTypes.StringType, true);
            fields.add(field);
        }
        StructType schema = DataTypes.createStructType(fields);

        Dataset<Row> peopleDataFrame = spark.createDataFrame(peopleRDD, schema);

        peopleDataFrame.createOrReplaceTempView("people");

        Dataset<Row> results = spark.sql("SELECT time FROM people").distinct();

        Dataset<String> namesDS = results.map(new MapFunction<Row, String>() {
            @Override
            public String call(Row row) throws Exception {
                return "Time: " + row.getString(0);
            }
        }, Encoders.STRING());

        namesDS.show();



        spark.stop();
    }

    private void loadDataFromDb(SparkSession spark) {
        Properties prop = new Properties();
        prop.put("driver", DB_DRIVER);
        prop.put("user", DB_USER);
        prop.put("password", DB_PASSWORD);

        for (int i=0; i<TABLE_NUM; i++) {
            String table = "H_TRANSACTION_0_" + i;
            System.out.println("load : " +  table);
            spark.sqlContext().read().jdbc(DB_URL, table, prop).select("TRANSACTION_DATE","TRANSACTION_ID",
                    "TRANSACTION_AMOUNT","TRANSACTION_CODE")
                    .where(functions.col("TRANSACTION_DATE").equalTo("2017-06-01"))
                    .write().csv("/Users/baidu/data/loan/" + table);
        }
    }
}
