package com.mx.datio;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class WordsCount {
    public static void main( String[] args ) {

        if( args.length < 2 ){
            System.out.println("Usage: WordsCount-1.0-SNAPSHOT.jar [input] [output]");
            System.exit(1);
        }else {
            String input = args[0];
            String output = args[1];

            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("WordsCount"));
            JavaRDD<String> inputFile = sc.textFile(input);
            // Split up into words.
            JavaRDD<String> words = inputFile.flatMap(
                    new FlatMapFunction<String, String>() {
                        public Iterator<String> call(String x) {
                            return Arrays.asList(x.split(" ")).iterator();
                        }
                    }
            );
            // Transform into pairs and count.
            JavaPairRDD<String, Integer> counts = words.mapToPair(
                    new PairFunction<String, String, Integer>(){
                        public Tuple2<String, Integer> call(String x){
                            return new Tuple2(x, 1);
                        }
                    }
            );
            // Reduce Results by Key (words)
            JavaPairRDD<String, Integer>  reducedCounts = counts.reduceByKey(
                    new Function2<Integer, Integer, Integer>(){
                        public Integer call(Integer x, Integer y){
                            return x + y;
                        }
                    }
            );

            // Save Results
            reducedCounts.saveAsTextFile( output );

        }
    }
}
