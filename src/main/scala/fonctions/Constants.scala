package fonctions

import org.apache.spark.sql.SparkSession

object Constants {

  val spark = SparkSession.builder
    .appName("reconciliation")
    .config("spark.hadoop.fs.defaultFS", "hdfs://bigdata")
    .config("spark.master", "yarn")
    .config("spark.submit.deployMode", "cluster")
    .enableHiveSupport()
    .getOrCreate()

  val deplafonementOm          = "refined_om.reporting_vente_deplafonnement_om"
  val subscribersOm            = "refined_om.reporting_vente_subscribers_om"
  val maxit                    = "trusted_om.base_event_maxit"
  val actif4g                  = "refined_om.parc_actif_4g"
  val multiSim                 = "refined_reporting.multisim"
  val subsOm                   = "trusted_om.subscribers_full"

  val writeDeplafonementOm     = "MYSVENTEREBONDPRD.reporting_vente_deplafonnement_om"
  val writeSubscribersOm       = "MYSVENTEREBONDPRD.reporting_vente_subscribers_om"
  val writeMaxit               = "MYSVENTEREBONDPRD.base_event_maxit"
  val writeActif4g             = "MYSVENTEREBONDPRD.parc_actif_4g"
  val writeMultiSim            = "MYSVENTEREBONDPRD.multisim"
  val SubscribersOm            = "MYSVENTEREBONDPRD.clients_om"

}
