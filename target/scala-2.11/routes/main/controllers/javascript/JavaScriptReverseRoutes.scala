
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/development/qgis/back/conf/routes
// @DATE:Mon Sep 14 20:56:44 EEST 2020

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:18
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:35
  class ReverseRoadController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def updateRoad: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.updateRoad",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateRoad"})
        }
      """
    )
  
    // @LINE:38
    def getRoadsForExporter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getRoadsForExporter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getRoadsForExporter"})
        }
      """
    )
  
    // @LINE:40
    def getAllSnapshotsRecords: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getAllSnapshotsRecords",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllSnapshotsRecords"})
        }
      """
    )
  
    // @LINE:41
    def resetCriteria: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.resetCriteria",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "resetCriteria"})
        }
      """
    )
  
    // @LINE:37
    def getAllFromRoadsHistory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getAllFromRoadsHistory",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFromRoadsHistory"})
        }
      """
    )
  
    // @LINE:36
    def getAllFromRoads: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getAllFromRoads",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFromRoads"})
        }
      """
    )
  
    // @LINE:39
    def calculateCriteria: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.calculateCriteria",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "calculateCriteria"})
        }
      """
    )
  
    // @LINE:43
    def deleteSnapshot: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.deleteSnapshot",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSnapshot"})
        }
      """
    )
  
    // @LINE:35
    def importRoadsData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.importRoadsData",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "importRoadsData"})
        }
      """
    )
  
  }

  // @LINE:70
  class ReverseVillageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:73
    def deleteVillage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VillageController.deleteVillage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteVillage"})
        }
      """
    )
  
    // @LINE:70
    def getAllVillages: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VillageController.getAllVillages",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllVillages"})
        }
      """
    )
  
    // @LINE:71
    def addVillage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VillageController.addVillage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addVillage"})
        }
      """
    )
  
    // @LINE:72
    def updateVillage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.VillageController.updateVillage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateVillage"})
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

  // @LINE:78
  class ReverseUsersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addUser"})
        }
      """
    )
  
    // @LINE:85
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.deleteUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteUser"})
        }
      """
    )
  
    // @LINE:81
    def getUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.getUsers",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getUsers"})
        }
      """
    )
  
    // @LINE:79
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:84
    def editUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.editUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editUser"})
        }
      """
    )
  
    // @LINE:80
    def forgotPwd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.forgotPwd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "forgotPwd"})
        }
      """
    )
  
    // @LINE:78
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
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

  // @LINE:48
  class ReverseFacilitiesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:50
    def updateFacilitie: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateFacilitie",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateFacilitie"})
        }
      """
    )
  
    // @LINE:57
    def updateDistrictCenter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateDistrictCenter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateDistrictCenter"})
        }
      """
    )
  
    // @LINE:61
    def deleteSchool: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteSchool",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSchool"})
        }
      """
    )
  
    // @LINE:60
    def updateSchool: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateSchool",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateSchool"})
        }
      """
    )
  
    // @LINE:58
    def deleteDistrictCenter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteDistrictCenter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDistrictCenter"})
        }
      """
    )
  
    // @LINE:49
    def addFacilitie: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addFacilitie",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addFacilitie"})
        }
      """
    )
  
    // @LINE:59
    def addSchool: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addSchool",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addSchool"})
        }
      """
    )
  
    // @LINE:48
    def importFacilitiesDataFromJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.importFacilitiesDataFromJson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "importFacilitiesDataFromJson"})
        }
      """
    )
  
    // @LINE:55
    def getAllFacilities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.getAllFacilities",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFacilities"})
        }
      """
    )
  
    // @LINE:51
    def deleteFacilitie: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteFacilitie",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteFacilitie"})
        }
      """
    )
  
    // @LINE:64
    def deleteMosque: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteMosque",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteMosque"})
        }
      """
    )
  
    // @LINE:62
    def addMosque: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addMosque",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addMosque"})
        }
      """
    )
  
    // @LINE:63
    def updateMosque: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateMosque",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateMosque"})
        }
      """
    )
  
    // @LINE:56
    def addDistrictCenter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addDistrictCenter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addDistrictCenter"})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseWebAppAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebAppAssets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:98
  class ReverseNotesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:100
    def editNote: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.editNote",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editNote"})
        }
      """
    )
  
    // @LINE:99
    def getNoteByRoadId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.getNoteByRoadId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getNoteByRoadId"})
        }
      """
    )
  
    // @LINE:98
    def addNote: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.addNote",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNote"})
        }
      """
    )
  
    // @LINE:101
    def deleteNote: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.deleteNote",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteNote"})
        }
      """
    )
  
  }


}
