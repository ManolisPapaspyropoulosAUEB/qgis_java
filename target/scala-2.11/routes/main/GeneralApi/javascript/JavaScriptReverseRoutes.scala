
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/developm/qgis_angular/back/conf/routes
// @DATE:Mon Jul 20 19:24:25 EEST 2020

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:23
package GeneralApi.javascript {
  import ReverseRouteContext.empty

  // @LINE:27
  class ReverseCoreDataController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def getAllCriteriaMaster: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "GeneralApi.CoreDataController.getAllCriteriaMaster",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllCriteriaMaster"})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseGeneralController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def getAllDistricts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "GeneralApi.GeneralController.getAllDistricts",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllDistricts"})
        }
      """
    )
  
    // @LINE:23
    def getAllProvinces: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "GeneralApi.GeneralController.getAllProvinces",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllProvinces"})
        }
      """
    )
  
  }


}
