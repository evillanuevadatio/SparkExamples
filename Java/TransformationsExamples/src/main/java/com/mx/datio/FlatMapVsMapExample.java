package com.mx.datio;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by evillanueva on 30/03/17.
 */
public class FlatMapVsMapExample {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: MapExample-1.0-SNAPSHOT.jar  [outputPath]");
            System.exit(1);
        } else {

            String output = args[0];

            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("FlatMapVsMap"));
            JavaRDD<String> rdd1 = sc.parallelize(Arrays.asList("coffe panda", "happy panda", "happiest panda party"));


            // MAP
            JavaRDD<List<String>> rdd1Primary = rdd1.map(
                    new Function<String, List<String>>() {
                        public List<String> call(String s) throws Exception {
                            return Arrays.asList(s.split(" "));
                        }
                    }
            );

            rdd1Primary.saveAsTextFile(output + "MapOutput");

            //FLATMAP
            JavaRDD<String> rdd1Secondary = rdd1.flatMap(
                    new FlatMapFunction<String, String>() {
                        public Iterator<String> call(String s) throws Exception {
                            return Arrays.asList(s.split(" ")).iterator();
                        }
                    }
            );
            rdd1Secondary.saveAsTextFile(output+ "FlatMapOutput");
        }
    }//main
}
