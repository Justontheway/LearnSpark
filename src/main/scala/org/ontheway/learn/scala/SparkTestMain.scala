package org.ontheway.learn.scala

import org.apache.spark.{SparkConf, SparkContext}

object SparkTestMain {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf
    val sc = new SparkContext(conf.setMaster("local"))
    val rdd = sc.parallelize(Seq(1,2,3,4,5,6))
    println(s"Total count of records is ${rdd.count}.")
    sc.stop
  }
}
