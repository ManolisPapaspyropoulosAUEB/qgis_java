
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/development/qgis/back/conf/routes
// @DATE:Mon Sep 14 20:56:44 EEST 2020

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:25
package GeneralApi {

  // @LINE:30
  class ReverseCoreDataController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def getAllCriteriaMaster(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "getAllCriteriaMaster")
    }
  
    // @LINE:31
    def updateEstimatedMaintenanceCost(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "updateEstimatedMaintenanceCost")
    }
  
  }

  // @LINE:25
  class ReverseGeneralController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def getAllDistricts(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "getAllDistricts")
    }
  
    // @LINE:27
    def updateMalakies(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "updateMalakies")
    }
  
    // @LINE:25
    def getAllProvinces(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "getAllProvinces")
    }
  
  }


}
