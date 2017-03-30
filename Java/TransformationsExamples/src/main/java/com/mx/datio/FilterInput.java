package com.mx.datio;

/**
 * Created by evillanueva on 29/03/17.
 */

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.List;

public class FilterInput {
    public static void main( String[] args ){
        if( args.length < 2 ){
            System.out.println("Usage: MapExample-1.0-SNAPSHOT.jar [input] [output]");
            System.exit(1);
        }else {
            String input = args[0];
            String output = args[1];

            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("MaxPriceJava"));
            JavaRDD<String> InputFile = sc.textFile(input);

            JavaRDD<String> inputFileFiltered = InputFile.filter(
                    new Function<String, Boolean>() {
                        public Boolean call(String s) throws Exception {
                            return s.contains( "2016-03-31" );
                        }
                    }
            );
            inputFileFiltered.saveAsTextFile( output );
        }
    }
}
