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

        if( args.length < 2 ){
            System.out.println("Usage: MaxPrice-1.0-SNAPSHOT.jar [input] [output]");
            System.exit(1);
        }else{
            String input = args[0];
            String output = args[1];

            JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("MaxPriceJava"));
            JavaRDD<String> InputFile = sc.textFile( input );

            JavaRDD<List <String> > splitedRows = InputFile.map(
                    new Function<String, List<String>>() {
                        public List<String> call(String s) throws Exception {
                            return Arrays.asList(s.split(","));
                        }
                    }
            );
            splitedRows.saveAsTextFile( output );

        }
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
