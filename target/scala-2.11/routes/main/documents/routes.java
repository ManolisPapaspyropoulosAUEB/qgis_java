
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/development/qgis/back/conf/routes
// @DATE:Wed Oct 14 20:37:30 EEST 2020

package documents;

import router.RoutesPrefix;

public class routes {
  
  public static final documents.ReverseDocumentsController DocumentsController = new documents.ReverseDocumentsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final documents.javascript.ReverseDocumentsController DocumentsController = new documents.javascript.ReverseDocumentsController(RoutesPrefix.byNamePrefix());
  }

}
