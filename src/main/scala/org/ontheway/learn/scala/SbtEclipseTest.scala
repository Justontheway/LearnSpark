package org.ontheway.learn.scala

import org.ontheway.learn.java.JavaLangFeature;

//import org.ontheway.learn.scala.JavaLangFeature
import org.apache.spark.launcher.SparkLauncher
import swiss.army.knife.util.Logging
import swiss.army.knife.util.Utils

object SbtEclipseTest extends Logging {

  def testLog(): Unit = {
    Utils.setLogLevel("ALL")
    logTrace("just a test info")
    logDebug("just a test info")
    logInfo("just a test info")
    //Utils.setLogLevel("ERROR")
    logWarning("just a test info")
    logError("just a test info")
  }

  def testJavaLangFeature() = {
    // scala调用java只能在同名字的包中？
    // java方法不加public不能再这里被调用
    assert(1 == 1)
    val x = new JavaLangFeature
    println(x.join("-->", "1"))
    println(x.join("-->", "1", "2"))
    println(x.join("-->", "1", "2", "3"))
    println(x.join("-->", "1", "2", "3", "4"))
    println(x.join("-->", "1", "2", "3", "4", "5"))
  }

  def runInternalClass(className: String,
      appName: String,
      masterUrl: String,
      deployMode: String,
      queueName: String = "root.bigdata.statistics") = {

    logInfo(s"run ${appName} on master ${masterUrl}.")
    sys.env.get("LEARN_SPARK_HOME") foreach { sh =>
      val spark = new SparkLauncher()
          .setMainClass(className)
          .setAppName(appName)
          .setMaster(masterUrl)
          .setAppResource(s"${sh}/target/scala-2.10/learnspark_2.10-1.0.jar")
          .setDeployMode(deployMode)
          .setConf(SparkLauncher.DRIVER_MEMORY, "1g")
          .setConf(SparkLauncher.EXECUTOR_MEMORY, "1g")
          .setConf(SparkLauncher.EXECUTOR_CORES, "2")
      spark.startApplication()
    }

    logInfo(s"finish ${appName} on master ${masterUrl}.")
  }


  def runExampleClass(className: String,
      appName: String,
      masterUrl: String,
      deployMode: String,
      queueName: String = "root.bigdata.statistics") = {

    logInfo(s"run ${appName} on master ${masterUrl}.")
    sys.env.get("SPARK_HOME") foreach { sh =>
      val handle = new SparkLauncher()
          .setMainClass(className)
          .setAppName(appName)
          .setMaster(masterUrl)
          .setAppResource(s"${sh}/lib/spark-examples-1.6.3-hadoop2.6.0.jar")
          .setDeployMode(deployMode)
          .setConf("spark.yarn.queue", queueName)
          .setConf(SparkLauncher.DRIVER_MEMORY, "1g")
          .setConf(SparkLauncher.EXECUTOR_MEMORY, "1g")
          .setConf(SparkLauncher.EXECUTOR_CORES, "2")
      handle.startApplication()
    }

    logInfo(s"finish ${appName} on master ${masterUrl}.")
  }

  def main(args: Array[String]): Unit = {
    println("It's just a test.")
    //testLog
    //testJavaLangFeature
    //testSparkYarn
    //runExampleClass("org.apache.spark.examples.SparkPi", "SparkPi", "yarn", "client")
    //runExampleClass("org.apache.spark.examples.SparkPi", "SparkPi", "yarn", "cluster")
    runInternalClass("org.ontheway.learn.scala.SparkTestMain", "SparkTestMain", "local[2]", "client")
  }
}
