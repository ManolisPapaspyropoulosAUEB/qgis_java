
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/development/qgis/back/conf/routes
// @DATE:Wed Oct 14 20:37:30 EEST 2020

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:86
package documents.javascript {
  import ReverseRouteContext.empty

  // @LINE:86
  class ReverseDocumentsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:86
    def uploadPhotoTest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "documents.DocumentsController.uploadPhotoTest",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadPhotoTest"})
        }
      """
    )
  
    // @LINE:88
    def uploadFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "documents.DocumentsController.uploadFile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadFile"})
        }
      """
    )
  
    // @LINE:90
    def downloadFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "documents.DocumentsController.downloadFile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "downloadFile"})
        }
      """
    )
  
    // @LINE:89
    def deleteImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "documents.DocumentsController.deleteImage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteImage"})
        }
      """
    )
  
    // @LINE:91
    def downloadDocument: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "documents.DocumentsController.downloadDocument",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "downloadDocument"})
        }
      """
    )
  
    // @LINE:87
    def getPhotoByRoadId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "documents.DocumentsController.getPhotoByRoadId",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "getPhotoByRoadId"})
        }
      """
    )
  
  }


}
