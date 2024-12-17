package com.github.manuelarte.demo

import kotlin.system.exitProcess
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import java.io.Serializable
import java.math.BigDecimal

fun main(args: Array<String>) {
    Runner().process()
}

class Runner {

    fun process() {
        val file = this::class.java.classLoader.getResource("dividends.csv")?.file

        if (file == null) {
            println("File not found")
            exitProcess(1)
        }

        val spark = SparkSession
            .builder()
            .config("spark.master", "local")
            .appName("Main")
            .getOrCreate()
        val lines = spark.read().option("header", true).csv(file).javaRDD()

        val func = object: org.apache.spark.api.java.function.Function<Row, DividendSum>, Serializable {
            override fun call(s: Row) : DividendSum {
                return DividendSum(s.getString(1), BigDecimal(s.getString(3)))
            }
        }

        val dividendRows = lines.map(func).keyBy { it.company }
        val dividendValues = dividendRows.reduceByKey { i1: DividendSum, i2: DividendSum -> i1.add(i2) }
        val output = dividendValues.collect()
        output.forEach {
            println(it._1().toString() + ": " + it._2())
        }
        spark.stop()
    }

}