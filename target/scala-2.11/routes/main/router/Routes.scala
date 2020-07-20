
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/developm/qgis_angular/back/conf/routes
// @DATE:Mon Jul 20 19:24:25 EEST 2020

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
  HomeController_1: controllers.HomeController,
  // @LINE:8
  CountController_0: controllers.CountController,
  // @LINE:10
  AsyncController_2: controllers.AsyncController,
  // @LINE:16
  Assets_8: controllers.Assets,
  // @LINE:17
  WebAppAssets_3: controllers.WebAppAssets,
  // @LINE:23
  GeneralController_5: GeneralApi.GeneralController,
  // @LINE:27
  CoreDataController_4: GeneralApi.CoreDataController,
  // @LINE:32
  RoadController_7: controllers.RoadController,
  // @LINE:40
  FacilitiesController_6: controllers.FacilitiesController,
  // @LINE:45
  VillageController_9: controllers.VillageController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:8
    CountController_0: controllers.CountController,
    // @LINE:10
    AsyncController_2: controllers.AsyncController,
    // @LINE:16
    Assets_8: controllers.Assets,
    // @LINE:17
    WebAppAssets_3: controllers.WebAppAssets,
    // @LINE:23
    GeneralController_5: GeneralApi.GeneralController,
    // @LINE:27
    CoreDataController_4: GeneralApi.CoreDataController,
    // @LINE:32
    RoadController_7: controllers.RoadController,
    // @LINE:40
    FacilitiesController_6: controllers.FacilitiesController,
    // @LINE:45
    VillageController_9: controllers.VillageController
  ) = this(errorHandler, HomeController_1, CountController_0, AsyncController_2, Assets_8, WebAppAssets_3, GeneralController_5, CoreDataController_4, RoadController_7, FacilitiesController_6, VillageController_9, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, CountController_0, AsyncController_2, Assets_8, WebAppAssets_3, GeneralController_5, CoreDataController_4, RoadController_7, FacilitiesController_6, VillageController_9, prefix)
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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllCriteriaMaster""", """GeneralApi.CoreDataController.getAllCriteriaMaster()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFromRoads""", """controllers.RoadController.getAllFromRoads()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """calculateCriteria""", """controllers.RoadController.calculateCriteria()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """resetCriteria""", """controllers.RoadController.resetCriteria()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateSoftwareAccount""", """controllers.RoadController.updateSoftwareAccount()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllFacilities""", """controllers.FacilitiesController.getAllFacilities()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getAllVillages""", """controllers.VillageController.getAllVillages()"""),
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
    HomeController_1.index,
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
    AsyncController_2.message,
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

  // @LINE:16
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_8.versioned(fakeValue[String], fakeValue[Asset]),
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

  // @LINE:17
  private[this] lazy val controllers_WebAppAssets_at4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("app/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebAppAssets_at4_invoker = createInvoker(
    WebAppAssets_3.at(fakeValue[String], fakeValue[String]),
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

  // @LINE:23
  private[this] lazy val GeneralApi_GeneralController_getAllProvinces5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllProvinces")))
  )
  private[this] lazy val GeneralApi_GeneralController_getAllProvinces5_invoker = createInvoker(
    GeneralController_5.getAllProvinces(),
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

  // @LINE:24
  private[this] lazy val GeneralApi_GeneralController_getAllDistricts6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllDistricts")))
  )
  private[this] lazy val GeneralApi_GeneralController_getAllDistricts6_invoker = createInvoker(
    GeneralController_5.getAllDistricts(),
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
  private[this] lazy val GeneralApi_CoreDataController_getAllCriteriaMaster7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllCriteriaMaster")))
  )
  private[this] lazy val GeneralApi_CoreDataController_getAllCriteriaMaster7_invoker = createInvoker(
    CoreDataController_4.getAllCriteriaMaster(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "GeneralApi.CoreDataController",
      "getAllCriteriaMaster",
      Nil,
      "POST",
      """GeneralController""",
      this.prefix + """getAllCriteriaMaster"""
    )
  )

  // @LINE:32
  private[this] lazy val controllers_RoadController_getAllFromRoads8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFromRoads")))
  )
  private[this] lazy val controllers_RoadController_getAllFromRoads8_invoker = createInvoker(
    RoadController_7.getAllFromRoads(),
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

  // @LINE:33
  private[this] lazy val controllers_RoadController_calculateCriteria9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("calculateCriteria")))
  )
  private[this] lazy val controllers_RoadController_calculateCriteria9_invoker = createInvoker(
    RoadController_7.calculateCriteria(),
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

  // @LINE:34
  private[this] lazy val controllers_RoadController_resetCriteria10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("resetCriteria")))
  )
  private[this] lazy val controllers_RoadController_resetCriteria10_invoker = createInvoker(
    RoadController_7.resetCriteria(),
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

  // @LINE:35
  private[this] lazy val controllers_RoadController_updateSoftwareAccount11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateSoftwareAccount")))
  )
  private[this] lazy val controllers_RoadController_updateSoftwareAccount11_invoker = createInvoker(
    RoadController_7.updateSoftwareAccount(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoadController",
      "updateSoftwareAccount",
      Nil,
      "POST",
      """""",
      this.prefix + """updateSoftwareAccount"""
    )
  )

  // @LINE:40
  private[this] lazy val controllers_FacilitiesController_getAllFacilities12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllFacilities")))
  )
  private[this] lazy val controllers_FacilitiesController_getAllFacilities12_invoker = createInvoker(
    FacilitiesController_6.getAllFacilities(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FacilitiesController",
      "getAllFacilities",
      Nil,
      "POST",
      """""",
      this.prefix + """getAllFacilities"""
    )
  )

  // @LINE:45
  private[this] lazy val controllers_VillageController_getAllVillages13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getAllVillages")))
  )
  private[this] lazy val controllers_VillageController_getAllVillages13_invoker = createInvoker(
    VillageController_9.getAllVillages(),
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


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_0.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message2_route(params) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:16
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_8.versioned(path, file))
      }
  
    // @LINE:17
    case controllers_WebAppAssets_at4_route(params) =>
      call(Param[String]("path", Right("webapp/")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_WebAppAssets_at4_invoker.call(WebAppAssets_3.at(path, file))
      }
  
    // @LINE:23
    case GeneralApi_GeneralController_getAllProvinces5_route(params) =>
      call { 
        GeneralApi_GeneralController_getAllProvinces5_invoker.call(GeneralController_5.getAllProvinces())
      }
  
    // @LINE:24
    case GeneralApi_GeneralController_getAllDistricts6_route(params) =>
      call { 
        GeneralApi_GeneralController_getAllDistricts6_invoker.call(GeneralController_5.getAllDistricts())
      }
  
    // @LINE:27
    case GeneralApi_CoreDataController_getAllCriteriaMaster7_route(params) =>
      call { 
        GeneralApi_CoreDataController_getAllCriteriaMaster7_invoker.call(CoreDataController_4.getAllCriteriaMaster())
      }
  
    // @LINE:32
    case controllers_RoadController_getAllFromRoads8_route(params) =>
      call { 
        controllers_RoadController_getAllFromRoads8_invoker.call(RoadController_7.getAllFromRoads())
      }
  
    // @LINE:33
    case controllers_RoadController_calculateCriteria9_route(params) =>
      call { 
        controllers_RoadController_calculateCriteria9_invoker.call(RoadController_7.calculateCriteria())
      }
  
    // @LINE:34
    case controllers_RoadController_resetCriteria10_route(params) =>
      call { 
        controllers_RoadController_resetCriteria10_invoker.call(RoadController_7.resetCriteria())
      }
  
    // @LINE:35
    case controllers_RoadController_updateSoftwareAccount11_route(params) =>
      call { 
        controllers_RoadController_updateSoftwareAccount11_invoker.call(RoadController_7.updateSoftwareAccount())
      }
  
    // @LINE:40
    case controllers_FacilitiesController_getAllFacilities12_route(params) =>
      call { 
        controllers_FacilitiesController_getAllFacilities12_invoker.call(FacilitiesController_6.getAllFacilities())
      }
  
    // @LINE:45
    case controllers_VillageController_getAllVillages13_route(params) =>
      call { 
        controllers_VillageController_getAllVillages13_invoker.call(VillageController_9.getAllVillages())
      }
  }
}
