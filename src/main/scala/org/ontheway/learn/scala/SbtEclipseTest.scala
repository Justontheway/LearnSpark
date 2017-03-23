package org.ontheway.learn.scala

import org.apache.spark.launcher.SparkLauncher

import swiss.army.knife.util.Logging
import swiss.army.knife.util.Utils

object SbtEclipseTest extends Logging {
  def testSpark(): Unit = {
    println("It's just a test.")
    val handle = new SparkLauncher().
        setSparkHome("/opt/core/spark-1.6.3-bin-hadoop2.6").
        setAppResource("/opt/core/spark-1.6.3-bin-hadoop2.6/lib/spark-examples-1.6.3-hadoop2.6.0.jar").
        setMainClass("org.apache.spark.examples.SparkPi").
        setAppName("SparkTest").
        setConf("spark.yarn.queue", "root.bigdata.statistics").
        setMaster("yarn-client").
        setVerbose(true).
        launch()
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
    //testSpark
    testLog
  }
}
