object Main {
  import fonctions.Utils.{baseEventMaxit, parcActif4g, reportingVenteDeplafonnementOm, reportingVenteSubscribersOm, baseMultiSim}
  import fonctions.Constants.{actif4g, deplafonementOm, maxit, subscribersOm, writeActif4g, writeDeplafonementOm, writeMaxit, writeSubscribersOm, multiSim, writeMultiSim}
  import fonctions.Read_write.{writeInMysql, writeFromMultisimInMysql}


  def main(args: Array[String]): Unit = {

    val year = args(0)
    val month = args(1)


    val df_deplafonnement_om    = reportingVenteDeplafonnementOm(   deplafonementOm  , year  , month)

    val df_subscribers_om       = reportingVenteSubscribersOm   (   subscribersOm    , year  , month)

    val df_actif_4g             = parcActif4g                   (   actif4g          , year  , month)

    val df_maxit                = baseEventMaxit                (   maxit            , year  , month)

    val df_multi_sim            = baseMultiSim                  (   multiSim                        )


    writeInMysql              (df_deplafonnement_om , "ignore"  , writeDeplafonementOm)

    writeInMysql              (df_subscribers_om    , "ignore"  , writeSubscribersOm  )

    writeInMysql              (df_actif_4g          , "ignore"  , writeActif4g        )

    writeInMysql              (df_maxit             , "ignore"  , writeMaxit          )

    writeFromMultisimInMysql  (df_multi_sim         , "overwrite", writeMultiSim      )



  }

}