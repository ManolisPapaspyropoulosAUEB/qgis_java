
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/development/qgis/back/conf/routes
// @DATE:Wed Oct 14 20:37:30 EEST 2020

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
  // @LINE:24
  GeneralController_7: GeneralApi.GeneralController,
  // @LINE:29
  CoreDataController_6: GeneralApi.CoreDataController,
  // @LINE:34
  RoadController_10: controllers.RoadController,
  // @LINE:49
  FacilitiesController_9: controllers.FacilitiesController,
  // @LINE:70
  VillageController_12: controllers.VillageController,
  // @LINE:77
  UsersController_1: controllers.UsersController,
  // @LINE:86
  DocumentsController_8: documents.DocumentsController,
  // @LINE:94
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
    // @LINE:24
    GeneralController_7: GeneralApi.GeneralController,
    // @LINE:29
    CoreDataController_6: GeneralApi.CoreDataController,
    // @LINE:34
    RoadController_10: controllers.RoadController,
    // @LINE:49
    FacilitiesController_9: controllers.FacilitiesController,
    // @LINE:70
    VillageController_12: controllers.VillageController,
    // @LINE:77
    UsersController_1: controllers.UsersController,
    // @LINE:86
    DocumentsController_8: documents.DocumentsController,
    // @LINE:94
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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFromRoads""", """controllers.RoadController.getAllFromRoadsView()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """fill_C_id_columns_Roads""", """controllers.RoadController.fill_C_id_columns_Roads()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFromRoadsHistory""", """controllers.RoadController.getAllFromRoadsHistory()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getRoadsForExporter""", """controllers.RoadController.getRoadsForExporter()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """calculateCriteria""", """controllers.RoadController.calculateCriteria()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllSnapshotsRecords""", """controllers.RoadController.getAllSnapshotsRecords()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateRoad""", """controllers.RoadController.updateRoad()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteSnapshot""", """controllers.RoadController.deleteSnapshot()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getRoadsColumns""", """controllers.RoadController.getRoadsColumns()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFromRoadsView""", """controllers.RoadController.getAllFromRoadsView()"""),
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

  // @LINE:24
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
      """GeneralController""",
      this.prefix + """getAllProvinces"""
    )
  )

  // @LINE:25
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

  // @LINE:26
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

  // @LINE:29
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

  // @LINE:30
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

  // @LINE:34
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
      """RoadsController fill_C_id_columns_Roads""",
      this.prefix + """importRoadsData"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_RoadController_getAllFromRoadsView11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFromRoads")))
  )
  private[this] lazy val controllers_RoadController_getAllFromRoadsView11_invoker = createInvoker(
    RoadController_10.getAllFromRoadsView(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "getAllFromRoadsView",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllFromRoads"""
    )
  )

  // @LINE:36
  private[this] lazy val controllers_RoadController_fill_C_id_columns_Roads12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("fill_C_id_columns_Roads")))
  )
  private[this] lazy val controllers_RoadController_fill_C_id_columns_Roads12_invoker = createInvoker(
    RoadController_10.fill_C_id_columns_Roads(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "fill_C_id_columns_Roads",
      Nil,
      "POST",
      """""",
      this.prefix + """fill_C_id_columns_Roads"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_RoadController_getAllFromRoadsHistory13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFromRoadsHistory")))
  )
  private[this] lazy val controllers_RoadController_getAllFromRoadsHistory13_invoker = createInvoker(
    RoadController_10.getAllFromRoadsHistory(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "getAllFromRoadsHistory",
      Nil,
      "POST",
      """POST        /getAllFromRoads2                       controllers.RoadController.getAllFromRoads2()""",
      this.prefix + """getAllFromRoadsHistory"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_RoadController_getRoadsForExporter14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getRoadsForExporter")))
  )
  private[this] lazy val controllers_RoadController_getRoadsForExporter14_invoker = createInvoker(
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

  // @LINE:40
  private[this] lazy val controllers_RoadController_calculateCriteria15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("calculateCriteria")))
  )
  private[this] lazy val controllers_RoadController_calculateCriteria15_invoker = createInvoker(
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

  // @LINE:41
  private[this] lazy val controllers_RoadController_getAllSnapshotsRecords16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllSnapshotsRecords")))
  )
  private[this] lazy val controllers_RoadController_getAllSnapshotsRecords16_invoker = createInvoker(
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

  // @LINE:44
  private[this] lazy val controllers_RoadController_getRoadsColumns19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getRoadsColumns")))
  )
  private[this] lazy val controllers_RoadController_getRoadsColumns19_invoker = createInvoker(
    RoadController_10.getRoadsColumns(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "getRoadsColumns",
      Nil,
      "POST",
      """""",
      this.prefix + """getRoadsColumns"""
    )
  )

  // @LINE:45
  private[this] lazy val controllers_RoadController_getAllFromRoadsView20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFromRoadsView")))
  )
  private[this] lazy val controllers_RoadController_getAllFromRoadsView20_invoker = createInvoker(
    RoadController_10.getAllFromRoadsView(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "getAllFromRoadsView",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllFromRoadsView"""
    )
  )

  // @LINE:49
  private[this] lazy val controllers_FacilitiesController_importFacilitiesDataFromJson21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("importFacilitiesDataFromJson")))
  )
  private[this] lazy val controllers_FacilitiesController_importFacilitiesDataFromJson21_invoker = createInvoker(
    FacilitiesController_9.importFacilitiesDataFromJson(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "importFacilitiesDataFromJson",
      Nil,
      "POST",
      """FacilitiesController""",
      this.prefix + """importFacilitiesDataFromJson"""
    )
  )

  // @LINE:50
  private[this] lazy val controllers_FacilitiesController_addFacilitie22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addFacilitie")))
  )
  private[this] lazy val controllers_FacilitiesController_addFacilitie22_invoker = createInvoker(
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

  // @LINE:51
  private[this] lazy val controllers_FacilitiesController_updateFacilitie23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateFacilitie")))
  )
  private[this] lazy val controllers_FacilitiesController_updateFacilitie23_invoker = createInvoker(
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

  // @LINE:52
  private[this] lazy val controllers_FacilitiesController_deleteFacilitie24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteFacilitie")))
  )
  private[this] lazy val controllers_FacilitiesController_deleteFacilitie24_invoker = createInvoker(
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

  // @LINE:56
  private[this] lazy val controllers_FacilitiesController_getAllFacilities25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFacilities")))
  )
  private[this] lazy val controllers_FacilitiesController_getAllFacilities25_invoker = createInvoker(
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

  // @LINE:57
  private[this] lazy val controllers_FacilitiesController_addDistrictCenter26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addDistrictCenter")))
  )
  private[this] lazy val controllers_FacilitiesController_addDistrictCenter26_invoker = createInvoker(
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

  // @LINE:58
  private[this] lazy val controllers_FacilitiesController_updateDistrictCenter27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateDistrictCenter")))
  )
  private[this] lazy val controllers_FacilitiesController_updateDistrictCenter27_invoker = createInvoker(
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

  // @LINE:59
  private[this] lazy val controllers_FacilitiesController_deleteDistrictCenter28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteDistrictCenter")))
  )
  private[this] lazy val controllers_FacilitiesController_deleteDistrictCenter28_invoker = createInvoker(
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

  // @LINE:60
  private[this] lazy val controllers_FacilitiesController_addSchool29_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addSchool")))
  )
  private[this] lazy val controllers_FacilitiesController_addSchool29_invoker = createInvoker(
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

  // @LINE:61
  private[this] lazy val controllers_FacilitiesController_updateSchool30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateSchool")))
  )
  private[this] lazy val controllers_FacilitiesController_updateSchool30_invoker = createInvoker(
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

  // @LINE:62
  private[this] lazy val controllers_FacilitiesController_deleteSchool31_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteSchool")))
  )
  private[this] lazy val controllers_FacilitiesController_deleteSchool31_invoker = createInvoker(
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

  // @LINE:63
  private[this] lazy val controllers_FacilitiesController_addMosque32_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addMosque")))
  )
  private[this] lazy val controllers_FacilitiesController_addMosque32_invoker = createInvoker(
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

  // @LINE:64
  private[this] lazy val controllers_FacilitiesController_updateMosque33_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateMosque")))
  )
  private[this] lazy val controllers_FacilitiesController_updateMosque33_invoker = createInvoker(
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

  // @LINE:65
  private[this] lazy val controllers_FacilitiesController_deleteMosque34_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteMosque")))
  )
  private[this] lazy val controllers_FacilitiesController_deleteMosque34_invoker = createInvoker(
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
  private[this] lazy val controllers_VillageController_getAllVillages35_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllVillages")))
  )
  private[this] lazy val controllers_VillageController_getAllVillages35_invoker = createInvoker(
    VillageController_12.getAllVillages(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VillageController",
      "getAllVillages",
      Nil,
      "POST",
      """VillagesController""",
      this.prefix + """getAllVillages"""
    )
  )

  // @LINE:71
  private[this] lazy val controllers_VillageController_addVillage36_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addVillage")))
  )
  private[this] lazy val controllers_VillageController_addVillage36_invoker = createInvoker(
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
  private[this] lazy val controllers_VillageController_updateVillage37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateVillage")))
  )
  private[this] lazy val controllers_VillageController_updateVillage37_invoker = createInvoker(
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
  private[this] lazy val controllers_VillageController_deleteVillage38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteVillage")))
  )
  private[this] lazy val controllers_VillageController_deleteVillage38_invoker = createInvoker(
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

  // @LINE:77
  private[this] lazy val controllers_UsersController_login39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UsersController_login39_invoker = createInvoker(
    UsersController_1.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "login",
      Nil,
      "POST",
      """UsersController updateUser""",
      this.prefix + """login"""
    )
  )

  // @LINE:78
  private[this] lazy val controllers_UsersController_register40_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_UsersController_register40_invoker = createInvoker(
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

  // @LINE:79
  private[this] lazy val controllers_UsersController_forgotPwd41_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotPwd")))
  )
  private[this] lazy val controllers_UsersController_forgotPwd41_invoker = createInvoker(
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

  // @LINE:80
  private[this] lazy val controllers_UsersController_getUsers42_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUsers")))
  )
  private[this] lazy val controllers_UsersController_getUsers42_invoker = createInvoker(
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

  // @LINE:81
  private[this] lazy val controllers_UsersController_addUser43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addUser")))
  )
  private[this] lazy val controllers_UsersController_addUser43_invoker = createInvoker(
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

  // @LINE:82
  private[this] lazy val controllers_UsersController_editUser44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editUser")))
  )
  private[this] lazy val controllers_UsersController_editUser44_invoker = createInvoker(
    UsersController_1.editUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "editUser",
      Nil,
      "POST",
      """""",
      this.prefix + """editUser"""
    )
  )

  // @LINE:83
  private[this] lazy val controllers_UsersController_deleteUser45_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteUser")))
  )
  private[this] lazy val controllers_UsersController_deleteUser45_invoker = createInvoker(
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

  // @LINE:86
  private[this] lazy val documents_DocumentsController_uploadPhotoTest46_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("uploadPhotoTest")))
  )
  private[this] lazy val documents_DocumentsController_uploadPhotoTest46_invoker = createInvoker(
    DocumentsController_8.uploadPhotoTest(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "documents.DocumentsController",
      "uploadPhotoTest",
      Nil,
      "POST",
      """DocumentsController""",
      this.prefix + """uploadPhotoTest"""
    )
  )

  // @LINE:87
  private[this] lazy val documents_DocumentsController_getPhotoByRoadId47_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getPhotoByRoadId")))
  )
  private[this] lazy val documents_DocumentsController_getPhotoByRoadId47_invoker = createInvoker(
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

  // @LINE:88
  private[this] lazy val documents_DocumentsController_uploadFile48_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("uploadFile")))
  )
  private[this] lazy val documents_DocumentsController_uploadFile48_invoker = createInvoker(
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

  // @LINE:89
  private[this] lazy val documents_DocumentsController_deleteImage49_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteImage")))
  )
  private[this] lazy val documents_DocumentsController_deleteImage49_invoker = createInvoker(
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

  // @LINE:90
  private[this] lazy val documents_DocumentsController_downloadFile50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("downloadFile")))
  )
  private[this] lazy val documents_DocumentsController_downloadFile50_invoker = createInvoker(
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

  // @LINE:91
  private[this] lazy val documents_DocumentsController_downloadDocument51_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("downloadDocument")))
  )
  private[this] lazy val documents_DocumentsController_downloadDocument51_invoker = createInvoker(
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

  // @LINE:94
  private[this] lazy val controllers_NotesController_addNote52_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addNote")))
  )
  private[this] lazy val controllers_NotesController_addNote52_invoker = createInvoker(
    NotesController_4.addNote(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotesController",
      "addNote",
      Nil,
      "POST",
      """NotesController""",
      this.prefix + """addNote"""
    )
  )

  // @LINE:95
  private[this] lazy val controllers_NotesController_getNoteByRoadId53_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getNoteByRoadId")))
  )
  private[this] lazy val controllers_NotesController_getNoteByRoadId53_invoker = createInvoker(
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

  // @LINE:96
  private[this] lazy val controllers_NotesController_editNote54_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editNote")))
  )
  private[this] lazy val controllers_NotesController_editNote54_invoker = createInvoker(
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

  // @LINE:97
  private[this] lazy val controllers_NotesController_deleteNote55_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteNote")))
  )
  private[this] lazy val controllers_NotesController_deleteNote55_invoker = createInvoker(
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
  
    // @LINE:24
    case GeneralApi_GeneralController_getAllProvinces5_route(params) =>
      call { 
        GeneralApi_GeneralController_getAllProvinces5_invoker.call(GeneralController_7.getAllProvinces())
      }
  
    // @LINE:25
    case GeneralApi_GeneralController_getAllDistricts6_route(params) =>
      call { 
        GeneralApi_GeneralController_getAllDistricts6_invoker.call(GeneralController_7.getAllDistricts())
      }
  
    // @LINE:26
    case GeneralApi_GeneralController_updateMalakies7_route(params) =>
      call { 
        GeneralApi_GeneralController_updateMalakies7_invoker.call(GeneralController_7.updateMalakies())
      }
  
    // @LINE:29
    case GeneralApi_CoreDataController_getAllCriteriaMaster8_route(params) =>
      call { 
        GeneralApi_CoreDataController_getAllCriteriaMaster8_invoker.call(CoreDataController_6.getAllCriteriaMaster())
      }
  
    // @LINE:30
    case GeneralApi_CoreDataController_updateEstimatedMaintenanceCost9_route(params) =>
      call { 
        GeneralApi_CoreDataController_updateEstimatedMaintenanceCost9_invoker.call(CoreDataController_6.updateEstimatedMaintenanceCost())
      }
  
    // @LINE:34
    case controllers_RoadController_importRoadsData10_route(params) =>
      call { 
        controllers_RoadController_importRoadsData10_invoker.call(RoadController_10.importRoadsData())
      }
  
    // @LINE:35
    case controllers_RoadController_getAllFromRoadsView11_route(params) =>
      call { 
        controllers_RoadController_getAllFromRoadsView11_invoker.call(RoadController_10.getAllFromRoadsView())
      }
  
    // @LINE:36
    case controllers_RoadController_fill_C_id_columns_Roads12_route(params) =>
      call { 
        controllers_RoadController_fill_C_id_columns_Roads12_invoker.call(RoadController_10.fill_C_id_columns_Roads())
      }
  
    // @LINE:38
    case controllers_RoadController_getAllFromRoadsHistory13_route(params) =>
      call { 
        controllers_RoadController_getAllFromRoadsHistory13_invoker.call(RoadController_10.getAllFromRoadsHistory())
      }
  
    // @LINE:39
    case controllers_RoadController_getRoadsForExporter14_route(params) =>
      call { 
        controllers_RoadController_getRoadsForExporter14_invoker.call(RoadController_10.getRoadsForExporter())
      }
  
    // @LINE:40
    case controllers_RoadController_calculateCriteria15_route(params) =>
      call { 
        controllers_RoadController_calculateCriteria15_invoker.call(RoadController_10.calculateCriteria())
      }
  
    // @LINE:41
    case controllers_RoadController_getAllSnapshotsRecords16_route(params) =>
      call { 
        controllers_RoadController_getAllSnapshotsRecords16_invoker.call(RoadController_10.getAllSnapshotsRecords())
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
  
    // @LINE:44
    case controllers_RoadController_getRoadsColumns19_route(params) =>
      call { 
        controllers_RoadController_getRoadsColumns19_invoker.call(RoadController_10.getRoadsColumns())
      }
  
    // @LINE:45
    case controllers_RoadController_getAllFromRoadsView20_route(params) =>
      call { 
        controllers_RoadController_getAllFromRoadsView20_invoker.call(RoadController_10.getAllFromRoadsView())
      }
  
    // @LINE:49
    case controllers_FacilitiesController_importFacilitiesDataFromJson21_route(params) =>
      call { 
        controllers_FacilitiesController_importFacilitiesDataFromJson21_invoker.call(FacilitiesController_9.importFacilitiesDataFromJson())
      }
  
    // @LINE:50
    case controllers_FacilitiesController_addFacilitie22_route(params) =>
      call { 
        controllers_FacilitiesController_addFacilitie22_invoker.call(FacilitiesController_9.addFacilitie())
      }
  
    // @LINE:51
    case controllers_FacilitiesController_updateFacilitie23_route(params) =>
      call { 
        controllers_FacilitiesController_updateFacilitie23_invoker.call(FacilitiesController_9.updateFacilitie())
      }
  
    // @LINE:52
    case controllers_FacilitiesController_deleteFacilitie24_route(params) =>
      call { 
        controllers_FacilitiesController_deleteFacilitie24_invoker.call(FacilitiesController_9.deleteFacilitie())
      }
  
    // @LINE:56
    case controllers_FacilitiesController_getAllFacilities25_route(params) =>
      call { 
        controllers_FacilitiesController_getAllFacilities25_invoker.call(FacilitiesController_9.getAllFacilities())
      }
  
    // @LINE:57
    case controllers_FacilitiesController_addDistrictCenter26_route(params) =>
      call { 
        controllers_FacilitiesController_addDistrictCenter26_invoker.call(FacilitiesController_9.addDistrictCenter())
      }
  
    // @LINE:58
    case controllers_FacilitiesController_updateDistrictCenter27_route(params) =>
      call { 
        controllers_FacilitiesController_updateDistrictCenter27_invoker.call(FacilitiesController_9.updateDistrictCenter())
      }
  
    // @LINE:59
    case controllers_FacilitiesController_deleteDistrictCenter28_route(params) =>
      call { 
        controllers_FacilitiesController_deleteDistrictCenter28_invoker.call(FacilitiesController_9.deleteDistrictCenter())
      }
  
    // @LINE:60
    case controllers_FacilitiesController_addSchool29_route(params) =>
      call { 
        controllers_FacilitiesController_addSchool29_invoker.call(FacilitiesController_9.addSchool())
      }
  
    // @LINE:61
    case controllers_FacilitiesController_updateSchool30_route(params) =>
      call { 
        controllers_FacilitiesController_updateSchool30_invoker.call(FacilitiesController_9.updateSchool())
      }
  
    // @LINE:62
    case controllers_FacilitiesController_deleteSchool31_route(params) =>
      call { 
        controllers_FacilitiesController_deleteSchool31_invoker.call(FacilitiesController_9.deleteSchool())
      }
  
    // @LINE:63
    case controllers_FacilitiesController_addMosque32_route(params) =>
      call { 
        controllers_FacilitiesController_addMosque32_invoker.call(FacilitiesController_9.addMosque())
      }
  
    // @LINE:64
    case controllers_FacilitiesController_updateMosque33_route(params) =>
      call { 
        controllers_FacilitiesController_updateMosque33_invoker.call(FacilitiesController_9.updateMosque())
      }
  
    // @LINE:65
    case controllers_FacilitiesController_deleteMosque34_route(params) =>
      call { 
        controllers_FacilitiesController_deleteMosque34_invoker.call(FacilitiesController_9.deleteMosque())
      }
  
    // @LINE:70
    case controllers_VillageController_getAllVillages35_route(params) =>
      call { 
        controllers_VillageController_getAllVillages35_invoker.call(VillageController_12.getAllVillages())
      }
  
    // @LINE:71
    case controllers_VillageController_addVillage36_route(params) =>
      call { 
        controllers_VillageController_addVillage36_invoker.call(VillageController_12.addVillage())
      }
  
    // @LINE:72
    case controllers_VillageController_updateVillage37_route(params) =>
      call { 
        controllers_VillageController_updateVillage37_invoker.call(VillageController_12.updateVillage())
      }
  
    // @LINE:73
    case controllers_VillageController_deleteVillage38_route(params) =>
      call { 
        controllers_VillageController_deleteVillage38_invoker.call(VillageController_12.deleteVillage())
      }
  
    // @LINE:77
    case controllers_UsersController_login39_route(params) =>
      call { 
        controllers_UsersController_login39_invoker.call(UsersController_1.login())
      }
  
    // @LINE:78
    case controllers_UsersController_register40_route(params) =>
      call { 
        controllers_UsersController_register40_invoker.call(UsersController_1.register())
      }
  
    // @LINE:79
    case controllers_UsersController_forgotPwd41_route(params) =>
      call { 
        controllers_UsersController_forgotPwd41_invoker.call(UsersController_1.forgotPwd())
      }
  
    // @LINE:80
    case controllers_UsersController_getUsers42_route(params) =>
      call { 
        controllers_UsersController_getUsers42_invoker.call(UsersController_1.getUsers())
      }
  
    // @LINE:81
    case controllers_UsersController_addUser43_route(params) =>
      call { 
        controllers_UsersController_addUser43_invoker.call(UsersController_1.addUser())
      }
  
    // @LINE:82
    case controllers_UsersController_editUser44_route(params) =>
      call { 
        controllers_UsersController_editUser44_invoker.call(UsersController_1.editUser())
      }
  
    // @LINE:83
    case controllers_UsersController_deleteUser45_route(params) =>
      call { 
        controllers_UsersController_deleteUser45_invoker.call(UsersController_1.deleteUser())
      }
  
    // @LINE:86
    case documents_DocumentsController_uploadPhotoTest46_route(params) =>
      call { 
        documents_DocumentsController_uploadPhotoTest46_invoker.call(DocumentsController_8.uploadPhotoTest())
      }
  
    // @LINE:87
    case documents_DocumentsController_getPhotoByRoadId47_route(params) =>
      call { 
        documents_DocumentsController_getPhotoByRoadId47_invoker.call(DocumentsController_8.getPhotoByRoadId())
      }
  
    // @LINE:88
    case documents_DocumentsController_uploadFile48_route(params) =>
      call { 
        documents_DocumentsController_uploadFile48_invoker.call(DocumentsController_8.uploadFile())
      }
  
    // @LINE:89
    case documents_DocumentsController_deleteImage49_route(params) =>
      call { 
        documents_DocumentsController_deleteImage49_invoker.call(DocumentsController_8.deleteImage())
      }
  
    // @LINE:90
    case documents_DocumentsController_downloadFile50_route(params) =>
      call { 
        documents_DocumentsController_downloadFile50_invoker.call(DocumentsController_8.downloadFile())
      }
  
    // @LINE:91
    case documents_DocumentsController_downloadDocument51_route(params) =>
      call { 
        documents_DocumentsController_downloadDocument51_invoker.call(DocumentsController_8.downloadDocument())
      }
  
    // @LINE:94
    case controllers_NotesController_addNote52_route(params) =>
      call { 
        controllers_NotesController_addNote52_invoker.call(NotesController_4.addNote())
      }
  
    // @LINE:95
    case controllers_NotesController_getNoteByRoadId53_route(params) =>
      call { 
        controllers_NotesController_getNoteByRoadId53_invoker.call(NotesController_4.getNoteByRoadId())
      }
  
    // @LINE:96
    case controllers_NotesController_editNote54_route(params) =>
      call { 
        controllers_NotesController_editNote54_invoker.call(NotesController_4.editNote())
      }
  
    // @LINE:97
    case controllers_NotesController_deleteNote55_route(params) =>
      call { 
        controllers_NotesController_deleteNote55_invoker.call(NotesController_4.deleteNote())
      }
  }
}
