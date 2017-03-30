package com.mx.datio

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._
 
object WordsCount {
 def main(args: Array[String]) {
 	val logFile = args(0) 

 	val sparkConf = new SparkConf().setAppName("Spark Word Count")
 	val sc = new SparkContext(sparkConf)
 	val file = sc.textFile(logFile)
 	
	val counts = file.flatMap(_.split(" ")).map(word => (word, 1)).reduceByKey(_ + _) 
 	
	counts.saveAsTextFile( args(1) )
 }
}
