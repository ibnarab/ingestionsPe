package fonctions

import fonctions.Constants.spark
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object Utils {


    def reportingVenteDeplafonnementOm(table: String, year: String, month: String): DataFrame = {

        spark.sql(
          s"""
            |SELECT
            |       msisdn, year, month
            |FROM $table
            |WHERE year = $year and month = $month
            |GROUP BY msisdn, year, month
          """.stripMargin)
    }


    def reportingVenteSubscribersOm(table: String, year: String, month: String): DataFrame = {

      spark.sql(
        s"""
           |SELECT
           |       msisdn, year, month
           |FROM $table
           |WHERE year = $year and month = $month
           |GROUP BY msisdn, year, month
          """.stripMargin)
    }


    def baseEventMaxit(table: String, year: String, month: String): DataFrame = {
      spark.sql(
        s"""
           |SELECT
           |       msisdn, year, month
           |FROM $table
           |WHERE year = $year and month = $month
           |GROUP BY msisdn, year, month
          """.stripMargin)
    }


    def parcActif4g(table:  String, year: String, month: String): DataFrame = {
      spark.sql(
        s"""
          |SELECT
          |       num_ligne as msisdn, year, month
          |FROM $table
          |WHERE year = $year and month = $month
          |GROUP BY msisdn, year, month
        """.stripMargin)
    }


    def baseMultiSim(table: String): DataFrame = {

        val dataFrame = spark.sql(
          s"""
            |SELECT * FROM $table
          """.stripMargin)


      dataFrame
            .withColumn("top1", col("top_appel").getItem(0))
            .withColumn("top2", col("top_appel").getItem(1))
            .withColumn("top3", col("top_appel").getItem(2))
            .withColumn("top4", col("top_appel").getItem(3))
            .withColumn("top5", col("top_appel").getItem(4))
            .drop("top_appel")
    }

}
