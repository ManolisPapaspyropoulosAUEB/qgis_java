
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/development/qgis/back/conf/routes
// @DATE:Mon Sep 14 20:56:44 EEST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_2: controllers.HomeController,
  // @LINE:8
  CountController_0: controllers.CountController,
  // @LINE:10
  AsyncController_3: controllers.AsyncController,
  // @LINE:18
  Assets_11: controllers.Assets,
  // @LINE:19
  WebAppAssets_5: controllers.WebAppAssets,
  // @LINE:25
  GeneralController_7: GeneralApi.GeneralController,
  // @LINE:30
  CoreDataController_6: GeneralApi.CoreDataController,
  // @LINE:35
  RoadController_10: controllers.RoadController,
  // @LINE:48
  FacilitiesController_9: controllers.FacilitiesController,
  // @LINE:70
  VillageController_12: controllers.VillageController,
  // @LINE:78
  UsersController_1: controllers.UsersController,
  // @LINE:89
  DocumentsController_8: documents.DocumentsController,
  // @LINE:98
  NotesController_4: controllers.NotesController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_2: controllers.HomeController,
    // @LINE:8
    CountController_0: controllers.CountController,
    // @LINE:10
    AsyncController_3: controllers.AsyncController,
    // @LINE:18
    Assets_11: controllers.Assets,
    // @LINE:19
    WebAppAssets_5: controllers.WebAppAssets,
    // @LINE:25
    GeneralController_7: GeneralApi.GeneralController,
    // @LINE:30
    CoreDataController_6: GeneralApi.CoreDataController,
    // @LINE:35
    RoadController_10: controllers.RoadController,
    // @LINE:48
    FacilitiesController_9: controllers.FacilitiesController,
    // @LINE:70
    VillageController_12: controllers.VillageController,
    // @LINE:78
    UsersController_1: controllers.UsersController,
    // @LINE:89
    DocumentsController_8: documents.DocumentsController,
    // @LINE:98
    NotesController_4: controllers.NotesController
  ) = this(errorHandler, HomeController_2, CountController_0, AsyncController_3, Assets_11, WebAppAssets_5, GeneralController_7, CoreDataController_6, RoadController_10, FacilitiesController_9, VillageController_12, UsersController_1, DocumentsController_8, NotesController_4, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, CountController_0, AsyncController_3, Assets_11, WebAppAssets_5, GeneralController_7, CoreDataController_6, RoadController_10, FacilitiesController_9, VillageController_12, UsersController_1, DocumentsController_8, NotesController_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """app/""" + "$" + """file<.+>""", """controllers.WebAppAssets.at(path:String = "webapp/", file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllProvinces""", """GeneralApi.GeneralController.getAllProvinces()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllDistricts""", """GeneralApi.GeneralController.getAllDistricts()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateMalakies""", """GeneralApi.GeneralController.updateMalakies()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllCriteriaMaster""", """GeneralApi.CoreDataController.getAllCriteriaMaster()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateEstimatedMaintenanceCost""", """GeneralApi.CoreDataController.updateEstimatedMaintenanceCost()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """importRoadsData""", """controllers.RoadController.importRoadsData()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFromRoads""", """controllers.RoadController.getAllFromRoads()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFromRoadsHistory""", """controllers.RoadController.getAllFromRoadsHistory()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getRoadsForExporter""", """controllers.RoadController.getRoadsForExporter()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """calculateCriteria""", """controllers.RoadController.calculateCriteria()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllSnapshotsRecords""", """controllers.RoadController.getAllSnapshotsRecords()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """resetCriteria""", """controllers.RoadController.resetCriteria()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateRoad""", """controllers.RoadController.updateRoad()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteSnapshot""", """controllers.RoadController.deleteSnapshot()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """importFacilitiesDataFromJson""", """controllers.FacilitiesController.importFacilitiesDataFromJson()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addFacilitie""", """controllers.FacilitiesController.addFacilitie()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateFacilitie""", """controllers.FacilitiesController.updateFacilitie()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteFacilitie""", """controllers.FacilitiesController.deleteFacilitie()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFacilities""", """controllers.FacilitiesController.getAllFacilities()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addDistrictCenter""", """controllers.FacilitiesController.addDistrictCenter()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateDistrictCenter""", """controllers.FacilitiesController.updateDistrictCenter()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteDistrictCenter""", """controllers.FacilitiesController.deleteDistrictCenter()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addSchool""", """controllers.FacilitiesController.addSchool()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateSchool""", """controllers.FacilitiesController.updateSchool()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteSchool""", """controllers.FacilitiesController.deleteSchool()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addMosque""", """controllers.FacilitiesController.addMosque()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateMosque""", """controllers.FacilitiesController.updateMosque()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteMosque""", """controllers.FacilitiesController.deleteMosque()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllVillages""", """controllers.VillageController.getAllVillages()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addVillage""", """controllers.VillageController.addVillage()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateVillage""", """controllers.VillageController.updateVillage()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteVillage""", """controllers.VillageController.deleteVillage()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UsersController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.UsersController.register()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotPwd""", """controllers.UsersController.forgotPwd()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getUsers""", """controllers.UsersController.getUsers()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addUser""", """controllers.UsersController.addUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editUser""", """controllers.UsersController.editUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteUser""", """controllers.UsersController.deleteUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """uploadPhotoTest""", """documents.DocumentsController.uploadPhotoTest()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getPhotoByRoadId""", """documents.DocumentsController.getPhotoByRoadId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """uploadFile""", """documents.DocumentsController.uploadFile()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteImage""", """documents.DocumentsController.deleteImage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """downloadFile""", """documents.DocumentsController.downloadFile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """downloadDocument""", """documents.DocumentsController.downloadDocument()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addNote""", """controllers.NotesController.addNote()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getNoteByRoadId""", """controllers.NotesController.getNoteByRoadId()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editNote""", """controllers.NotesController.editNote()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteNote""", """controllers.NotesController.deleteNote()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_0.count,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      """ An example controller showing how to use dependency injection""",
      this.prefix + """count"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_3.message,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      """ An example controller showing how to write asynchronous code""",
      this.prefix + """message"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_11.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /iets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_WebAppAssets_at4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("app/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebAppAssets_at4_invoker = createInvoker(
    WebAppAssets_5.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebAppAssets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """app/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:25
  private[this] lazy val GeneralApi_GeneralController_getAllProvinces5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllProvinces")))
  )
  private[this] lazy val GeneralApi_GeneralController_getAllProvinces5_invoker = createInvoker(
    GeneralController_7.getAllProvinces(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "GeneralApi.GeneralController",
      "getAllProvinces",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllProvinces"""
    )
  )

  // @LINE:26
  private[this] lazy val GeneralApi_GeneralController_getAllDistricts6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllDistricts")))
  )
  private[this] lazy val GeneralApi_GeneralController_getAllDistricts6_invoker = createInvoker(
    GeneralController_7.getAllDistricts(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "GeneralApi.GeneralController",
      "getAllDistricts",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllDistricts"""
    )
  )

  // @LINE:27
  private[this] lazy val GeneralApi_GeneralController_updateMalakies7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateMalakies")))
  )
  private[this] lazy val GeneralApi_GeneralController_updateMalakies7_invoker = createInvoker(
    GeneralController_7.updateMalakies(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "GeneralApi.GeneralController",
      "updateMalakies",
      Nil,
      "POST",
      """""",
      this.prefix + """updateMalakies"""
    )
  )

  // @LINE:30
  private[this] lazy val GeneralApi_CoreDataController_getAllCriteriaMaster8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllCriteriaMaster")))
  )
  private[this] lazy val GeneralApi_CoreDataController_getAllCriteriaMaster8_invoker = createInvoker(
    CoreDataController_6.getAllCriteriaMaster(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "GeneralApi.CoreDataController",
      "getAllCriteriaMaster",
      Nil,
      "POST",
      """CoreDataController""",
      this.prefix + """getAllCriteriaMaster"""
    )
  )

  // @LINE:31
  private[this] lazy val GeneralApi_CoreDataController_updateEstimatedMaintenanceCost9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateEstimatedMaintenanceCost")))
  )
  private[this] lazy val GeneralApi_CoreDataController_updateEstimatedMaintenanceCost9_invoker = createInvoker(
    CoreDataController_6.updateEstimatedMaintenanceCost(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "GeneralApi.CoreDataController",
      "updateEstimatedMaintenanceCost",
      Nil,
      "POST",
      """""",
      this.prefix + """updateEstimatedMaintenanceCost"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_RoadController_importRoadsData10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("importRoadsData")))
  )
  private[this] lazy val controllers_RoadController_importRoadsData10_invoker = createInvoker(
    RoadController_10.importRoadsData(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "importRoadsData",
      Nil,
      "POST",
      """RoadsController""",
      this.prefix + """importRoadsData"""
    )
  )

  // @LINE:36
  private[this] lazy val controllers_RoadController_getAllFromRoads11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFromRoads")))
  )
  private[this] lazy val controllers_RoadController_getAllFromRoads11_invoker = createInvoker(
    RoadController_10.getAllFromRoads(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "getAllFromRoads",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllFromRoads"""
    )
  )

  // @LINE:37
  private[this] lazy val controllers_RoadController_getAllFromRoadsHistory12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFromRoadsHistory")))
  )
  private[this] lazy val controllers_RoadController_getAllFromRoadsHistory12_invoker = createInvoker(
    RoadController_10.getAllFromRoadsHistory(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "getAllFromRoadsHistory",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllFromRoadsHistory"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_RoadController_getRoadsForExporter13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getRoadsForExporter")))
  )
  private[this] lazy val controllers_RoadController_getRoadsForExporter13_invoker = createInvoker(
    RoadController_10.getRoadsForExporter(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "getRoadsForExporter",
      Nil,
      "POST",
      """""",
      this.prefix + """getRoadsForExporter"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_RoadController_calculateCriteria14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("calculateCriteria")))
  )
  private[this] lazy val controllers_RoadController_calculateCriteria14_invoker = createInvoker(
    RoadController_10.calculateCriteria(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "calculateCriteria",
      Nil,
      "POST",
      """""",
      this.prefix + """calculateCriteria"""
    )
  )

  // @LINE:40
  private[this] lazy val controllers_RoadController_getAllSnapshotsRecords15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllSnapshotsRecords")))
  )
  private[this] lazy val controllers_RoadController_getAllSnapshotsRecords15_invoker = createInvoker(
    RoadController_10.getAllSnapshotsRecords(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "getAllSnapshotsRecords",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllSnapshotsRecords"""
    )
  )

  // @LINE:41
  private[this] lazy val controllers_RoadController_resetCriteria16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("resetCriteria")))
  )
  private[this] lazy val controllers_RoadController_resetCriteria16_invoker = createInvoker(
    RoadController_10.resetCriteria(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "resetCriteria",
      Nil,
      "POST",
      """""",
      this.prefix + """resetCriteria"""
    )
  )

  // @LINE:42
  private[this] lazy val controllers_RoadController_updateRoad17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateRoad")))
  )
  private[this] lazy val controllers_RoadController_updateRoad17_invoker = createInvoker(
    RoadController_10.updateRoad(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "updateRoad",
      Nil,
      "POST",
      """""",
      this.prefix + """updateRoad"""
    )
  )

  // @LINE:43
  private[this] lazy val controllers_RoadController_deleteSnapshot18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteSnapshot")))
  )
  private[this] lazy val controllers_RoadController_deleteSnapshot18_invoker = createInvoker(
    RoadController_10.deleteSnapshot(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "deleteSnapshot",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteSnapshot"""
    )
  )

  // @LINE:48
  private[this] lazy val controllers_FacilitiesController_importFacilitiesDataFromJson19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("importFacilitiesDataFromJson")))
  )
  private[this] lazy val controllers_FacilitiesController_importFacilitiesDataFromJson19_invoker = createInvoker(
    FacilitiesController_9.importFacilitiesDataFromJson(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "importFacilitiesDataFromJson",
      Nil,
      "POST",
      """""",
      this.prefix + """importFacilitiesDataFromJson"""
    )
  )

  // @LINE:49
  private[this] lazy val controllers_FacilitiesController_addFacilitie20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addFacilitie")))
  )
  private[this] lazy val controllers_FacilitiesController_addFacilitie20_invoker = createInvoker(
    FacilitiesController_9.addFacilitie(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "addFacilitie",
      Nil,
      "POST",
      """""",
      this.prefix + """addFacilitie"""
    )
  )

  // @LINE:50
  private[this] lazy val controllers_FacilitiesController_updateFacilitie21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateFacilitie")))
  )
  private[this] lazy val controllers_FacilitiesController_updateFacilitie21_invoker = createInvoker(
    FacilitiesController_9.updateFacilitie(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "updateFacilitie",
      Nil,
      "POST",
      """""",
      this.prefix + """updateFacilitie"""
    )
  )

  // @LINE:51
  private[this] lazy val controllers_FacilitiesController_deleteFacilitie22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteFacilitie")))
  )
  private[this] lazy val controllers_FacilitiesController_deleteFacilitie22_invoker = createInvoker(
    FacilitiesController_9.deleteFacilitie(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "deleteFacilitie",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteFacilitie"""
    )
  )

  // @LINE:55
  private[this] lazy val controllers_FacilitiesController_getAllFacilities23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFacilities")))
  )
  private[this] lazy val controllers_FacilitiesController_getAllFacilities23_invoker = createInvoker(
    FacilitiesController_9.getAllFacilities(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "getAllFacilities",
      Nil,
      "POST",
      """old routes------------------------------------------------------------------------------------------------------------------------------""",
      this.prefix + """getAllFacilities"""
    )
  )

  // @LINE:56
  private[this] lazy val controllers_FacilitiesController_addDistrictCenter24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addDistrictCenter")))
  )
  private[this] lazy val controllers_FacilitiesController_addDistrictCenter24_invoker = createInvoker(
    FacilitiesController_9.addDistrictCenter(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "addDistrictCenter",
      Nil,
      "POST",
      """""",
      this.prefix + """addDistrictCenter"""
    )
  )

  // @LINE:57
  private[this] lazy val controllers_FacilitiesController_updateDistrictCenter25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateDistrictCenter")))
  )
  private[this] lazy val controllers_FacilitiesController_updateDistrictCenter25_invoker = createInvoker(
    FacilitiesController_9.updateDistrictCenter(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "updateDistrictCenter",
      Nil,
      "POST",
      """""",
      this.prefix + """updateDistrictCenter"""
    )
  )

  // @LINE:58
  private[this] lazy val controllers_FacilitiesController_deleteDistrictCenter26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteDistrictCenter")))
  )
  private[this] lazy val controllers_FacilitiesController_deleteDistrictCenter26_invoker = createInvoker(
    FacilitiesController_9.deleteDistrictCenter(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "deleteDistrictCenter",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteDistrictCenter"""
    )
  )

  // @LINE:59
  private[this] lazy val controllers_FacilitiesController_addSchool27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addSchool")))
  )
  private[this] lazy val controllers_FacilitiesController_addSchool27_invoker = createInvoker(
    FacilitiesController_9.addSchool(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "addSchool",
      Nil,
      "POST",
      """""",
      this.prefix + """addSchool"""
    )
  )

  // @LINE:60
  private[this] lazy val controllers_FacilitiesController_updateSchool28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateSchool")))
  )
  private[this] lazy val controllers_FacilitiesController_updateSchool28_invoker = createInvoker(
    FacilitiesController_9.updateSchool(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "updateSchool",
      Nil,
      "POST",
      """""",
      this.prefix + """updateSchool"""
    )
  )

  // @LINE:61
  private[this] lazy val controllers_FacilitiesController_deleteSchool29_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteSchool")))
  )
  private[this] lazy val controllers_FacilitiesController_deleteSchool29_invoker = createInvoker(
    FacilitiesController_9.deleteSchool(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "deleteSchool",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteSchool"""
    )
  )

  // @LINE:62
  private[this] lazy val controllers_FacilitiesController_addMosque30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addMosque")))
  )
  private[this] lazy val controllers_FacilitiesController_addMosque30_invoker = createInvoker(
    FacilitiesController_9.addMosque(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "addMosque",
      Nil,
      "POST",
      """""",
      this.prefix + """addMosque"""
    )
  )

  // @LINE:63
  private[this] lazy val controllers_FacilitiesController_updateMosque31_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateMosque")))
  )
  private[this] lazy val controllers_FacilitiesController_updateMosque31_invoker = createInvoker(
    FacilitiesController_9.updateMosque(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "updateMosque",
      Nil,
      "POST",
      """""",
      this.prefix + """updateMosque"""
    )
  )

  // @LINE:64
  private[this] lazy val controllers_FacilitiesController_deleteMosque32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteMosque")))
  )
  private[this] lazy val controllers_FacilitiesController_deleteMosque32_invoker = createInvoker(
    FacilitiesController_9.deleteMosque(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "deleteMosque",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteMosque"""
    )
  )

  // @LINE:70
  private[this] lazy val controllers_VillageController_getAllVillages33_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllVillages")))
  )
  private[this] lazy val controllers_VillageController_getAllVillages33_invoker = createInvoker(
    VillageController_12.getAllVillages(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VillageController",
      "getAllVillages",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllVillages"""
    )
  )

  // @LINE:71
  private[this] lazy val controllers_VillageController_addVillage34_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addVillage")))
  )
  private[this] lazy val controllers_VillageController_addVillage34_invoker = createInvoker(
    VillageController_12.addVillage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VillageController",
      "addVillage",
      Nil,
      "POST",
      """""",
      this.prefix + """addVillage"""
    )
  )

  // @LINE:72
  private[this] lazy val controllers_VillageController_updateVillage35_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateVillage")))
  )
  private[this] lazy val controllers_VillageController_updateVillage35_invoker = createInvoker(
    VillageController_12.updateVillage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VillageController",
      "updateVillage",
      Nil,
      "POST",
      """""",
      this.prefix + """updateVillage"""
    )
  )

  // @LINE:73
  private[this] lazy val controllers_VillageController_deleteVillage36_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVillage")))
  )
  private[this] lazy val controllers_VillageController_deleteVillage36_invoker = createInvoker(
    VillageController_12.deleteVillage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VillageController",
      "deleteVillage",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteVillage"""
    )
  )

  // @LINE:78
  private[this] lazy val controllers_UsersController_login37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UsersController_login37_invoker = createInvoker(
    UsersController_1.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "login",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:79
  private[this] lazy val controllers_UsersController_register38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_UsersController_register38_invoker = createInvoker(
    UsersController_1.register(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "register",
      Nil,
      "POST",
      """""",
      this.prefix + """register"""
    )
  )

  // @LINE:80
  private[this] lazy val controllers_UsersController_forgotPwd39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotPwd")))
  )
  private[this] lazy val controllers_UsersController_forgotPwd39_invoker = createInvoker(
    UsersController_1.forgotPwd(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "forgotPwd",
      Nil,
      "POST",
      """""",
      this.prefix + """forgotPwd"""
    )
  )

  // @LINE:81
  private[this] lazy val controllers_UsersController_getUsers40_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUsers")))
  )
  private[this] lazy val controllers_UsersController_getUsers40_invoker = createInvoker(
    UsersController_1.getUsers(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "getUsers",
      Nil,
      "POST",
      """""",
      this.prefix + """getUsers"""
    )
  )

  // @LINE:82
  private[this] lazy val controllers_UsersController_addUser41_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addUser")))
  )
  private[this] lazy val controllers_UsersController_addUser41_invoker = createInvoker(
    UsersController_1.addUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "addUser",
      Nil,
      "POST",
      """""",
      this.prefix + """addUser"""
    )
  )

  // @LINE:84
  private[this] lazy val controllers_UsersController_editUser42_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editUser")))
  )
  private[this] lazy val controllers_UsersController_editUser42_invoker = createInvoker(
    UsersController_1.editUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "editUser",
      Nil,
      "POST",
      """POST        /updateUser                            controllers.UsersController.updateUser()""",
      this.prefix + """editUser"""
    )
  )

  // @LINE:85
  private[this] lazy val controllers_UsersController_deleteUser43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteUser")))
  )
  private[this] lazy val controllers_UsersController_deleteUser43_invoker = createInvoker(
    UsersController_1.deleteUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "deleteUser",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteUser"""
    )
  )

  // @LINE:89
  private[this] lazy val documents_DocumentsController_uploadPhotoTest44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("uploadPhotoTest")))
  )
  private[this] lazy val documents_DocumentsController_uploadPhotoTest44_invoker = createInvoker(
    DocumentsController_8.uploadPhotoTest(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "documents.DocumentsController",
      "uploadPhotoTest",
      Nil,
      "POST",
      """""",
      this.prefix + """uploadPhotoTest"""
    )
  )

  // @LINE:90
  private[this] lazy val documents_DocumentsController_getPhotoByRoadId45_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getPhotoByRoadId")))
  )
  private[this] lazy val documents_DocumentsController_getPhotoByRoadId45_invoker = createInvoker(
    DocumentsController_8.getPhotoByRoadId(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "documents.DocumentsController",
      "getPhotoByRoadId",
      Nil,
      "POST",
      """""",
      this.prefix + """getPhotoByRoadId"""
    )
  )

  // @LINE:91
  private[this] lazy val documents_DocumentsController_uploadFile46_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("uploadFile")))
  )
  private[this] lazy val documents_DocumentsController_uploadFile46_invoker = createInvoker(
    DocumentsController_8.uploadFile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "documents.DocumentsController",
      "uploadFile",
      Nil,
      "POST",
      """""",
      this.prefix + """uploadFile"""
    )
  )

  // @LINE:92
  private[this] lazy val documents_DocumentsController_deleteImage47_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteImage")))
  )
  private[this] lazy val documents_DocumentsController_deleteImage47_invoker = createInvoker(
    DocumentsController_8.deleteImage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "documents.DocumentsController",
      "deleteImage",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteImage"""
    )
  )

  // @LINE:93
  private[this] lazy val documents_DocumentsController_downloadFile48_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("downloadFile")))
  )
  private[this] lazy val documents_DocumentsController_downloadFile48_invoker = createInvoker(
    DocumentsController_8.downloadFile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "documents.DocumentsController",
      "downloadFile",
      Nil,
      "GET",
      """""",
      this.prefix + """downloadFile"""
    )
  )

  // @LINE:94
  private[this] lazy val documents_DocumentsController_downloadDocument49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("downloadDocument")))
  )
  private[this] lazy val documents_DocumentsController_downloadDocument49_invoker = createInvoker(
    DocumentsController_8.downloadDocument(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "documents.DocumentsController",
      "downloadDocument",
      Nil,
      "GET",
      """""",
      this.prefix + """downloadDocument"""
    )
  )

  // @LINE:98
  private[this] lazy val controllers_NotesController_addNote50_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNote")))
  )
  private[this] lazy val controllers_NotesController_addNote50_invoker = createInvoker(
    NotesController_4.addNote(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "addNote",
      Nil,
      "POST",
      """""",
      this.prefix + """addNote"""
    )
  )

  // @LINE:99
  private[this] lazy val controllers_NotesController_getNoteByRoadId51_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getNoteByRoadId")))
  )
  private[this] lazy val controllers_NotesController_getNoteByRoadId51_invoker = createInvoker(
    NotesController_4.getNoteByRoadId(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "getNoteByRoadId",
      Nil,
      "POST",
      """""",
      this.prefix + """getNoteByRoadId"""
    )
  )

  // @LINE:100
  private[this] lazy val controllers_NotesController_editNote52_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editNote")))
  )
  private[this] lazy val controllers_NotesController_editNote52_invoker = createInvoker(
    NotesController_4.editNote(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "editNote",
      Nil,
      "POST",
      """""",
      this.prefix + """editNote"""
    )
  )

  // @LINE:101
  private[this] lazy val controllers_NotesController_deleteNote53_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteNote")))
  )
  private[this] lazy val controllers_NotesController_deleteNote53_invoker = createInvoker(
    NotesController_4.deleteNote(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "deleteNote",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteNote"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_0.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message2_route(params) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_3.message)
      }
  
    // @LINE:18
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_11.versioned(path, file))
      }
  
    // @LINE:19
    case controllers_WebAppAssets_at4_route(params) =>
      call(Param[String]("path", Right("webapp/")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_WebAppAssets_at4_invoker.call(WebAppAssets_5.at(path, file))
      }
  
    // @LINE:25
    case GeneralApi_GeneralController_getAllProvinces5_route(params) =>
      call { 
        GeneralApi_GeneralController_getAllProvinces5_invoker.call(GeneralController_7.getAllProvinces())
      }
  
    // @LINE:26
    case GeneralApi_GeneralController_getAllDistricts6_route(params) =>
      call { 
        GeneralApi_GeneralController_getAllDistricts6_invoker.call(GeneralController_7.getAllDistricts())
      }
  
    // @LINE:27
    case GeneralApi_GeneralController_updateMalakies7_route(params) =>
      call { 
        GeneralApi_GeneralController_updateMalakies7_invoker.call(GeneralController_7.updateMalakies())
      }
  
    // @LINE:30
    case GeneralApi_CoreDataController_getAllCriteriaMaster8_route(params) =>
      call { 
        GeneralApi_CoreDataController_getAllCriteriaMaster8_invoker.call(CoreDataController_6.getAllCriteriaMaster())
      }
  
    // @LINE:31
    case GeneralApi_CoreDataController_updateEstimatedMaintenanceCost9_route(params) =>
      call { 
        GeneralApi_CoreDataController_updateEstimatedMaintenanceCost9_invoker.call(CoreDataController_6.updateEstimatedMaintenanceCost())
      }
  
    // @LINE:35
    case controllers_RoadController_importRoadsData10_route(params) =>
      call { 
        controllers_RoadController_importRoadsData10_invoker.call(RoadController_10.importRoadsData())
      }
  
    // @LINE:36
    case controllers_RoadController_getAllFromRoads11_route(params) =>
      call { 
        controllers_RoadController_getAllFromRoads11_invoker.call(RoadController_10.getAllFromRoads())
      }
  
    // @LINE:37
    case controllers_RoadController_getAllFromRoadsHistory12_route(params) =>
      call { 
        controllers_RoadController_getAllFromRoadsHistory12_invoker.call(RoadController_10.getAllFromRoadsHistory())
      }
  
    // @LINE:38
    case controllers_RoadController_getRoadsForExporter13_route(params) =>
      call { 
        controllers_RoadController_getRoadsForExporter13_invoker.call(RoadController_10.getRoadsForExporter())
      }
  
    // @LINE:39
    case controllers_RoadController_calculateCriteria14_route(params) =>
      call { 
        controllers_RoadController_calculateCriteria14_invoker.call(RoadController_10.calculateCriteria())
      }
  
    // @LINE:40
    case controllers_RoadController_getAllSnapshotsRecords15_route(params) =>
      call { 
        controllers_RoadController_getAllSnapshotsRecords15_invoker.call(RoadController_10.getAllSnapshotsRecords())
      }
  
    // @LINE:41
    case controllers_RoadController_resetCriteria16_route(params) =>
      call { 
        controllers_RoadController_resetCriteria16_invoker.call(RoadController_10.resetCriteria())
      }
  
    // @LINE:42
    case controllers_RoadController_updateRoad17_route(params) =>
      call { 
        controllers_RoadController_updateRoad17_invoker.call(RoadController_10.updateRoad())
      }
  
    // @LINE:43
    case controllers_RoadController_deleteSnapshot18_route(params) =>
      call { 
        controllers_RoadController_deleteSnapshot18_invoker.call(RoadController_10.deleteSnapshot())
      }
  
    // @LINE:48
    case controllers_FacilitiesController_importFacilitiesDataFromJson19_route(params) =>
      call { 
        controllers_FacilitiesController_importFacilitiesDataFromJson19_invoker.call(FacilitiesController_9.importFacilitiesDataFromJson())
      }
  
    // @LINE:49
    case controllers_FacilitiesController_addFacilitie20_route(params) =>
      call { 
        controllers_FacilitiesController_addFacilitie20_invoker.call(FacilitiesController_9.addFacilitie())
      }
  
    // @LINE:50
    case controllers_FacilitiesController_updateFacilitie21_route(params) =>
      call { 
        controllers_FacilitiesController_updateFacilitie21_invoker.call(FacilitiesController_9.updateFacilitie())
      }
  
    // @LINE:51
    case controllers_FacilitiesController_deleteFacilitie22_route(params) =>
      call { 
        controllers_FacilitiesController_deleteFacilitie22_invoker.call(FacilitiesController_9.deleteFacilitie())
      }
  
    // @LINE:55
    case controllers_FacilitiesController_getAllFacilities23_route(params) =>
      call { 
        controllers_FacilitiesController_getAllFacilities23_invoker.call(FacilitiesController_9.getAllFacilities())
      }
  
    // @LINE:56
    case controllers_FacilitiesController_addDistrictCenter24_route(params) =>
      call { 
        controllers_FacilitiesController_addDistrictCenter24_invoker.call(FacilitiesController_9.addDistrictCenter())
      }
  
    // @LINE:57
    case controllers_FacilitiesController_updateDistrictCenter25_route(params) =>
      call { 
        controllers_FacilitiesController_updateDistrictCenter25_invoker.call(FacilitiesController_9.updateDistrictCenter())
      }
  
    // @LINE:58
    case controllers_FacilitiesController_deleteDistrictCenter26_route(params) =>
      call { 
        controllers_FacilitiesController_deleteDistrictCenter26_invoker.call(FacilitiesController_9.deleteDistrictCenter())
      }
  
    // @LINE:59
    case controllers_FacilitiesController_addSchool27_route(params) =>
      call { 
        controllers_FacilitiesController_addSchool27_invoker.call(FacilitiesController_9.addSchool())
      }
  
    // @LINE:60
    case controllers_FacilitiesController_updateSchool28_route(params) =>
      call { 
        controllers_FacilitiesController_updateSchool28_invoker.call(FacilitiesController_9.updateSchool())
      }
  
    // @LINE:61
    case controllers_FacilitiesController_deleteSchool29_route(params) =>
      call { 
        controllers_FacilitiesController_deleteSchool29_invoker.call(FacilitiesController_9.deleteSchool())
      }
  
    // @LINE:62
    case controllers_FacilitiesController_addMosque30_route(params) =>
      call { 
        controllers_FacilitiesController_addMosque30_invoker.call(FacilitiesController_9.addMosque())
      }
  
    // @LINE:63
    case controllers_FacilitiesController_updateMosque31_route(params) =>
      call { 
        controllers_FacilitiesController_updateMosque31_invoker.call(FacilitiesController_9.updateMosque())
      }
  
    // @LINE:64
    case controllers_FacilitiesController_deleteMosque32_route(params) =>
      call { 
        controllers_FacilitiesController_deleteMosque32_invoker.call(FacilitiesController_9.deleteMosque())
      }
  
    // @LINE:70
    case controllers_VillageController_getAllVillages33_route(params) =>
      call { 
        controllers_VillageController_getAllVillages33_invoker.call(VillageController_12.getAllVillages())
      }
  
    // @LINE:71
    case controllers_VillageController_addVillage34_route(params) =>
      call { 
        controllers_VillageController_addVillage34_invoker.call(VillageController_12.addVillage())
      }
  
    // @LINE:72
    case controllers_VillageController_updateVillage35_route(params) =>
      call { 
        controllers_VillageController_updateVillage35_invoker.call(VillageController_12.updateVillage())
      }
  
    // @LINE:73
    case controllers_VillageController_deleteVillage36_route(params) =>
      call { 
        controllers_VillageController_deleteVillage36_invoker.call(VillageController_12.deleteVillage())
      }
  
    // @LINE:78
    case controllers_UsersController_login37_route(params) =>
      call { 
        controllers_UsersController_login37_invoker.call(UsersController_1.login())
      }
  
    // @LINE:79
    case controllers_UsersController_register38_route(params) =>
      call { 
        controllers_UsersController_register38_invoker.call(UsersController_1.register())
      }
  
    // @LINE:80
    case controllers_UsersController_forgotPwd39_route(params) =>
      call { 
        controllers_UsersController_forgotPwd39_invoker.call(UsersController_1.forgotPwd())
      }
  
    // @LINE:81
    case controllers_UsersController_getUsers40_route(params) =>
      call { 
        controllers_UsersController_getUsers40_invoker.call(UsersController_1.getUsers())
      }
  
    // @LINE:82
    case controllers_UsersController_addUser41_route(params) =>
      call { 
        controllers_UsersController_addUser41_invoker.call(UsersController_1.addUser())
      }
  
    // @LINE:84
    case controllers_UsersController_editUser42_route(params) =>
      call { 
        controllers_UsersController_editUser42_invoker.call(UsersController_1.editUser())
      }
  
    // @LINE:85
    case controllers_UsersController_deleteUser43_route(params) =>
      call { 
        controllers_UsersController_deleteUser43_invoker.call(UsersController_1.deleteUser())
      }
  
    // @LINE:89
    case documents_DocumentsController_uploadPhotoTest44_route(params) =>
      call { 
        documents_DocumentsController_uploadPhotoTest44_invoker.call(DocumentsController_8.uploadPhotoTest())
      }
  
    // @LINE:90
    case documents_DocumentsController_getPhotoByRoadId45_route(params) =>
      call { 
        documents_DocumentsController_getPhotoByRoadId45_invoker.call(DocumentsController_8.getPhotoByRoadId())
      }
  
    // @LINE:91
    case documents_DocumentsController_uploadFile46_route(params) =>
      call { 
        documents_DocumentsController_uploadFile46_invoker.call(DocumentsController_8.uploadFile())
      }
  
    // @LINE:92
    case documents_DocumentsController_deleteImage47_route(params) =>
      call { 
        documents_DocumentsController_deleteImage47_invoker.call(DocumentsController_8.deleteImage())
      }
  
    // @LINE:93
    case documents_DocumentsController_downloadFile48_route(params) =>
      call { 
        documents_DocumentsController_downloadFile48_invoker.call(DocumentsController_8.downloadFile())
      }
  
    // @LINE:94
    case documents_DocumentsController_downloadDocument49_route(params) =>
      call { 
        documents_DocumentsController_downloadDocument49_invoker.call(DocumentsController_8.downloadDocument())
      }
  
    // @LINE:98
    case controllers_NotesController_addNote50_route(params) =>
      call { 
        controllers_NotesController_addNote50_invoker.call(NotesController_4.addNote())
      }
  
    // @LINE:99
    case controllers_NotesController_getNoteByRoadId51_route(params) =>
      call { 
        controllers_NotesController_getNoteByRoadId51_invoker.call(NotesController_4.getNoteByRoadId())
      }
  
    // @LINE:100
    case controllers_NotesController_editNote52_route(params) =>
      call { 
        controllers_NotesController_editNote52_invoker.call(NotesController_4.editNote())
      }
  
    // @LINE:101
    case controllers_NotesController_deleteNote53_route(params) =>
      call { 
        controllers_NotesController_deleteNote53_invoker.call(NotesController_4.deleteNote())
      }
  }
}
