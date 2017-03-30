package com.mx.datio;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.List;

public class MapExample{
    public static void main( String[] args ){
        if( args.length < 2 ){
            System.out.println("Usage: MapExample-1.0-SNAPSHOT.jar [input] [output]");
            System.exit(1);
        }else{
            String input = args[0];
            String output = args[1];

            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("MaxPriceJava"));
            JavaRDD<String> InputFile = sc.textFile( input );

            JavaRDD<List<String>> splitedRows = InputFile.map(
                    new Function<String, List<String>>() {
                        public List<String> call(String s) throws Exception {
                            return Arrays.asList(s.split(","));
                        }
                    }
            );
            splitedRows.saveAsTextFile( output );
        }

    }
}
