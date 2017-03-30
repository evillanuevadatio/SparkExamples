package com.mx.datio;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import scala.Array;
import scala.collection.immutable.StringOps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by evillanueva on 29/03/17.
 */
public class FlatMapExample {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: MapExample-1.0-SNAPSHOT.jar [input] [output]");
            System.exit(1);
        } else {
            String input = args[0];
            String output = args[1];

            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("MaxPriceJava"));
            JavaRDD<String> InputFile = sc.textFile(input);

            JavaRDD<String>  outputRdd = InputFile.flatMap(
                    new FlatMapFunction<String, String>() {
                        public Iterator<String> call(String s) throws Exception {
                            return Arrays.asList(s.split(",")).iterator();
                        }
                    }
            );
            outputRdd.saveAsTextFile( output );


        }
    }

}