package com.mx.datio;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

import java.util.Arrays;

/**
 * Created by evillanueva on 30/03/17.
 */
public class ReduceExample {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: MapExample-1.0-SNAPSHOT.jar  [outputPath]");
            System.exit(1);
        } else {

            String output = args[0];
            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("FlatMapVsMap"));

            JavaRDD<Integer> rdd1 = sc.parallelize(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

            Integer result = rdd1.reduce(
                    new Function2<Integer, Integer, Integer>() {
                        public Integer call(Integer v1, Integer v2) throws Exception {
                            return v1+v2;
                        }
                    }
            );
            System.out.println("Reduce Sume: " + result);
        }
    }
}
