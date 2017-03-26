package org.ontheway.learn.scala

import org.ontheway.learn.java.JavaLangFeature;

//import org.ontheway.learn.scala.JavaLangFeature
import org.apache.spark.launcher.SparkLauncher

object SbtEclipseTest {
  def main(args: Array[String]): Unit = {
    println("It's just a test.")
    // scala调用java只能在同名字的包中？
    // java方法不加public不能再这里被调用
    assert(1 == 1)
    val x = new JavaLangFeature
    println(x.join("-->", "1"))
    println(x.join("-->", "1", "2"))
    println(x.join("-->", "1", "2", "3"))
    println(x.join("-->", "1", "2", "3", "4"))
    println(x.join("-->", "1", "2", "3", "4", "5"))

    println("start")
    val spark = new SparkLauncher()
        .setAppName("test")
        .setMaster("local[1]")
        .setSparkHome("/d/code/spark-1.6.0-bin-hadoop2.6/")
        .setAppResource(" C:\\Users\\lenovo\\workspace_spark\\LearnSpark\\LearnSpark\\target\\scala-2.10\\learnspark_2.10-1.0.jar")
        .setMainClass("org.ontheway.learn.scala。SparkTestMain")
        .setConf(SparkLauncher.DRIVER_MEMORY, "1g")
        .setConf(SparkLauncher.EXECUTOR_CORES, "1")
        .setConf(SparkLauncher.SPARK_MASTER, "local")
        .launch()
    spark.waitFor
    println(spark.exitValue)
    println("finish")
  }
}