
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/developm/qgis_angular/back/conf/routes
// @DATE:Mon Jul 20 19:24:25 EEST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
