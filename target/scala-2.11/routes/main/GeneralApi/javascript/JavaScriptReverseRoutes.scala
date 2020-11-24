
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/development/qgis/back/conf/routes
// @DATE:Wed Oct 14 20:37:30 EEST 2020

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:24
package GeneralApi.javascript {
  import ReverseRouteContext.empty

  // @LINE:29
  class ReverseCoreDataController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def getAllCriteriaMaster: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "GeneralApi.CoreDataController.getAllCriteriaMaster",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllCriteriaMaster"})
        }
      """
    )
  
    // @LINE:30
    def updateEstimatedMaintenanceCost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "GeneralApi.CoreDataController.updateEstimatedMaintenanceCost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateEstimatedMaintenanceCost"})
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseGeneralController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def getAllDistricts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "GeneralApi.GeneralController.getAllDistricts",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllDistricts"})
        }
      """
    )
  
    // @LINE:26
    def updateMalakies: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "GeneralApi.GeneralController.updateMalakies",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateMalakies"})
        }
      """
    )
  
    // @LINE:24
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
