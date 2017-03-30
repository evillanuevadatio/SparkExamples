package com.mx.datio

import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf,SparkContext}

/**
 * @author Eder Villanueva
 */
object MaxPrice {
  def main(args : Array[String]) {
    val conf = new SparkConf().setAppName("MaxPrice").setMaster("spark://Geofront:7077")
    val sc = new SparkContext( conf )

    sc.textFile( args(0) )
        .map(  _.split(",") )
        .map( rec => (  (rec(0).split("-"))(0).toInt, rec(1).toFloat  ) )
        .reduceByKey( (a,b) => Math.max(a,b) )
        .saveAsTextFile( args(1) )
  }
}
