
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/developm/qgis_angular/back/conf/routes
// @DATE:Wed Jul 22 01:19:56 EEST 2020

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:16
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:32
  class ReverseRoadController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def resetCriteria: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.resetCriteria",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "resetCriteria"})
        }
      """
    )
  
    // @LINE:35
    def updateSoftwareAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.updateSoftwareAccount",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateSoftwareAccount"})
        }
      """
    )
  
    // @LINE:33
    def calculateCriteria: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.calculateCriteria",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "calculateCriteria"})
        }
      """
    )
  
    // @LINE:32
    def getAllFromRoads: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getAllFromRoads",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFromRoads"})
        }
      """
    )
  
  }

  // @LINE:50
  class ReverseVillageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:50
    def getAllVillages: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VillageController.getAllVillages",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllVillages"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:40
  class ReverseFacilitiesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def updateDistrictCenter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateDistrictCenter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateDistrictCenter"})
        }
      """
    )
  
    // @LINE:45
    def updateSchool: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateSchool",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateSchool"})
        }
      """
    )
  
    // @LINE:43
    def deleteDistrictCenter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteDistrictCenter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDistrictCenter"})
        }
      """
    )
  
    // @LINE:44
    def addSchool: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addSchool",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addSchool"})
        }
      """
    )
  
    // @LINE:40
    def getAllFacilities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.getAllFacilities",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFacilities"})
        }
      """
    )
  
    // @LINE:41
    def addDistrictCenter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addDistrictCenter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addDistrictCenter"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseWebAppAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebAppAssets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
