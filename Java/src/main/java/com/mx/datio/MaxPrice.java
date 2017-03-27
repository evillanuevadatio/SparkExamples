package com.mx.datio;

import org.apache.spark.SparkConf;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPrice {
    public static void main( String[] args ) {

        JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("MaxPriceJava"));
        JavaRDD<String> InputFile = sc.textFile("hdfs://172.17.0.2:9000/sparkData/table.csv");

          /*
        JavaRDD<String> splitedFile = InputFile.flatMap(
                new Function<String,String>(){
                    public String call(String s){
                        return ArrayList( s.split(",") );
                    }
                }
        );

        JavaRDD<List<String>> columns = InputFile.map(
                new Function<String, List<String>>(){
                    @Override
                    public List<String> call(String s) {
                        return Arrays.asList( s.split(","));
                    }
                }
        );


        JavaPairRDD<Integer,Float> a1 = columns.mapToPair(
                new PairFunction<String,Integer, Float>(){
                    @Override
                    public Tuple2<Integer,Float> call(tring s ){
                        return new Tuple2<Integer, Float>(Integer.parseInt(  s[0].split("-")[0] ), Float.parseFloat( s[1] ) );
                    }
                }
        );

*/
    }
}
