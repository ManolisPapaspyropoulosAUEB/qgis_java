
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Digitals Assets</title>
        <base href="/app/">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <link rel="icon" type="image/x-icon" href="favicon.ico">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.js"></script>
        <link rel="stylesheet" href="styles.css">
       """),format.raw/*16.76*/("""
      """),format.raw/*18.60*/("""
    """),format.raw/*19.5*/("""</head>
    <body>
        <app-root></app-root>
      <script src="polyfills-es5.js" nomodule defer></script>
      <script src="polyfills-es2015.js" type="module"></script>
      <script src="scripts.js" defer></script>
      <script src="runtime-es2015.js" type="module"></script>
      <script src="main-es2015.js" type="module"></script>
      <script src="runtime-es5.js" nomodule defer></script>
      <script src="main-es5.js" nomodule defer></script>


    </body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Jul 20 01:16:36 EEST 2020
                  SOURCE: C:/developm/qgis_angular/back/app/views/index.scala.html
                  HASH: accad3a82d9334ba433c0f1bb6fd564e85a2fbb5
                  MATRIX: 827->0|1486->922|1521->1033|1553->1038
                  LINES: 32->1|44->16|45->18|46->19
                  -- GENERATED --
              */
          