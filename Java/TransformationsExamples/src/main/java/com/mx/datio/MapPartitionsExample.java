package com.mx.datio;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.Iterator;

/**
 * Created by evillanueva on 29/03/17.
 */
public class MapPartitionsExample {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: MapExample-1.0-SNAPSHOT.jar [input] [output]");
            System.exit(1);
        } else {
            String input = args[0];
            String output = args[1];

            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("MaxPriceJava"));
            JavaRDD<String> inputFile = sc.textFile(input);

            inputFile.mapPartitions(
                    new FlatMapFunction<Iterator<String>, Object>() {
                        public Iterator<Object> call(Iterator<String> stringIterator) throws Exception {
                            return null;
                        }
                    }
            );

        }
    }
}
