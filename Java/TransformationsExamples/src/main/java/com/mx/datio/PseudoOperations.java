package com.mx.datio;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

/**
 * Created by evillanueva on 30/03/17.
 */
public class PseudoOperations {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: MapExample-1.0-SNAPSHOT.jar  [outputPath]");
            System.exit(1);
        } else {

            String output = args[0];
            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("FlatMapVsMap"));
            JavaRDD<String> rdd1 = sc.parallelize(Arrays.asList("coffe", "coffe", "panda","monkey","tea"));
            JavaRDD<String> rdd2 = sc.parallelize(Arrays.asList("coffe", "monkey","kitty"));

            JavaRDD<String> rdd1_distinct = rdd1.distinct();
            rdd1_distinct.saveAsTextFile(output+"RddDitinct");

            JavaRDD<String> rdd3 = rdd1.union(rdd2);
            rdd3.saveAsTextFile(output+"RddUnion");

            JavaRDD<String> rdd_intersection = rdd1.intersection(rdd2);
            rdd_intersection.saveAsTextFile(output+"RddIntersection");

            JavaRDD<String> rdd_substract = rdd1.subtract(rdd2);
            rdd_substract.saveAsTextFile(output+"RddSubstract");

        }
    }
}
