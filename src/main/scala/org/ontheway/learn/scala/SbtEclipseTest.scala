package org.ontheway.learn.scala

import org.ontheway.learn.java.JavaLangFeature;

//import org.ontheway.learn.scala.JavaLangFeature
import org.apache.spark.launcher.SparkLauncher
//import swiss.army.knife.util.Logging
//import swiss.army.knife.util.Utils

//object SbtEclipseTest extends Logging {
object SbtEclipseTest {
  def testSparkLocal(): Unit = {
    println("start on local.")
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
    println("finished")
  }

  def testSparkYarn(): Unit = {
    println("start on yarn.")
    val handle = new SparkLauncher()
        .setSparkHome("/opt/core/spark-1.6.3-bin-hadoop2.6")
        .setAppResource("/opt/core/spark-1.6.3-bin-hadoop2.6/lib/spark-examples-1.6.3-hadoop2.6.0.jar")
        .setMainClass("org.apache.spark.examples.SparkPi")
        .setAppName("SparkTest")
        .setConf("spark.yarn.queue", "root.bigdata.statistics")
        .setMaster("yarn-client")
        .setVerbose(true)
        .launch()
    handle.waitFor()
    println(handle.getOutputStream())
    println("finished")
  }

  def testLog(): Unit = {
    Utils.setLogLevel("ALL")
    logTrace("just a test info")
    logDebug("just a test info")
    logInfo("just a test info")
    //Utils.setLogLevel("ERROR")
    logWarning("just a test info")
    logError("just a test info")
  }

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

    //testLog
    //testSparkYarn
    testSparkLocal
  }
}
