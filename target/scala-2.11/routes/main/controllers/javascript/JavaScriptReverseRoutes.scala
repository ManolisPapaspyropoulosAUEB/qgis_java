
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/development/qgis/back/conf/routes
// @DATE:Wed Oct 14 20:37:30 EEST 2020

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

  // @LINE:34
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
  
    // @LINE:35
    def getAllFromRoadsView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getAllFromRoadsView",
      """
        function() {
        
          if (true) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFromRoads"})
          }
        
        }
      """
    )
  
    // @LINE:39
    def getRoadsForExporter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getRoadsForExporter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getRoadsForExporter"})
        }
      """
    )
  
    // @LINE:41
    def getAllSnapshotsRecords: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getAllSnapshotsRecords",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllSnapshotsRecords"})
        }
      """
    )
  
    // @LINE:38
    def getAllFromRoadsHistory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getAllFromRoadsHistory",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFromRoadsHistory"})
        }
      """
    )
  
    // @LINE:44
    def getRoadsColumns: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.getRoadsColumns",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getRoadsColumns"})
        }
      """
    )
  
    // @LINE:36
    def fill_C_id_columns_Roads: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoadController.fill_C_id_columns_Roads",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "fill_C_id_columns_Roads"})
        }
      """
    )
  
    // @LINE:40
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
  
    // @LINE:34
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

  // @LINE:77
  class ReverseUsersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:81
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addUser"})
        }
      """
    )
  
    // @LINE:83
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.deleteUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteUser"})
        }
      """
    )
  
    // @LINE:80
    def getUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.getUsers",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getUsers"})
        }
      """
    )
  
    // @LINE:78
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:82
    def editUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.editUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editUser"})
        }
      """
    )
  
    // @LINE:79
    def forgotPwd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.forgotPwd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "forgotPwd"})
        }
      """
    )
  
    // @LINE:77
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

  // @LINE:49
  class ReverseFacilitiesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:51
    def updateFacilitie: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateFacilitie",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateFacilitie"})
        }
      """
    )
  
    // @LINE:58
    def updateDistrictCenter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateDistrictCenter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateDistrictCenter"})
        }
      """
    )
  
    // @LINE:62
    def deleteSchool: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteSchool",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteSchool"})
        }
      """
    )
  
    // @LINE:61
    def updateSchool: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateSchool",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateSchool"})
        }
      """
    )
  
    // @LINE:59
    def deleteDistrictCenter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteDistrictCenter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteDistrictCenter"})
        }
      """
    )
  
    // @LINE:50
    def addFacilitie: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addFacilitie",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addFacilitie"})
        }
      """
    )
  
    // @LINE:60
    def addSchool: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addSchool",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addSchool"})
        }
      """
    )
  
    // @LINE:49
    def importFacilitiesDataFromJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.importFacilitiesDataFromJson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "importFacilitiesDataFromJson"})
        }
      """
    )
  
    // @LINE:56
    def getAllFacilities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.getAllFacilities",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFacilities"})
        }
      """
    )
  
    // @LINE:52
    def deleteFacilitie: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteFacilitie",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteFacilitie"})
        }
      """
    )
  
    // @LINE:65
    def deleteMosque: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.deleteMosque",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteMosque"})
        }
      """
    )
  
    // @LINE:63
    def addMosque: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.addMosque",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addMosque"})
        }
      """
    )
  
    // @LINE:64
    def updateMosque: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FacilitiesController.updateMosque",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateMosque"})
        }
      """
    )
  
    // @LINE:57
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

  // @LINE:94
  class ReverseNotesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:96
    def editNote: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.editNote",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editNote"})
        }
      """
    )
  
    // @LINE:95
    def getNoteByRoadId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.getNoteByRoadId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getNoteByRoadId"})
        }
      """
    )
  
    // @LINE:94
    def addNote: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotesController.addNote",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addNote"})
        }
      """
    )
  
    // @LINE:97
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
