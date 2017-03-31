package com.mx.datio;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by evillanueva on 29/03/17.
 */
public class MapPartitionsExample {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: MapExample-1.0-SNAPSHOT.jar [output]");
            System.exit(1);
        } else {
            String output = args[0];


            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("MaxPriceJava"));
            //JavaRDD<String> inputFile = sc.textFile(input);

            JavaRDD<Integer> rdd = sc.parallelize( Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10,11,12),3);


            JavaRDD<Integer> integerJavaRDD = rdd.mapPartitions(
                    new FlatMapFunction<Iterator<Integer>, Integer>() {
                        public Iterator<Integer> call(Iterator<Integer> intIter) throws Exception {
                            /*
                            Integer acum = 0;

                            List<Integer> ap1 = new ArrayList<Integer>();
                            while (intIter.hasNext()) {
                                acum += intIter.next();
                                ap1.add(acum);
                            }
                            return ap1.iterator();
                            */
                            return intIter;
                        }
                    }
            );

            //integerJavaRDD.saveAsTextFile(output+"MapPartitions");
            Integer x = integerJavaRDD.reduce(
                    new Function2<Integer, Integer, Integer>() {
                        public Integer call(Integer integer, Integer integer2) throws Exception {
                            return integer+integer2;
                        }
                    }
            );
            System.out.println("Reduced x: " + x);

        }
    }
}
