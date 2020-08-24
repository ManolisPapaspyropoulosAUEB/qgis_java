
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/developm/qgis_angular/back/conf/routes
// @DATE:Sun Aug 23 18:40:14 EEST 2020

package GeneralApi;

import router.RoutesPrefix;

public class routes {
  
  public static final GeneralApi.ReverseCoreDataController CoreDataController = new GeneralApi.ReverseCoreDataController(RoutesPrefix.byNamePrefix());
  public static final GeneralApi.ReverseGeneralController GeneralController = new GeneralApi.ReverseGeneralController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final GeneralApi.javascript.ReverseCoreDataController CoreDataController = new GeneralApi.javascript.ReverseCoreDataController(RoutesPrefix.byNamePrefix());
    public static final GeneralApi.javascript.ReverseGeneralController GeneralController = new GeneralApi.javascript.ReverseGeneralController(RoutesPrefix.byNamePrefix());
  }

}
