package controllers;

import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Transactional
    public  Result  index() {



        return ok(index.render());
    }

//    public static Result upload() {
//        File file = request().body().asRaw().asFile();
//        return ok("File uploaded");
//    }
//
//    @BodyParser.Of(value = BodyParser.Text.class)
//    public static Result upload2() {
//        Http.MultipartFormData body = request().body().asMultipartFormData();
//        Http.MultipartFormData.FilePart fileHttp = body.getFile("picture");
//        if (fileHttp != null) {
//            String fileName = fileHttp.getFilename();
//            String contentType = fileHttp.getContentType();
//            File file = (File) fileHttp.getFile();
//            return ok("File uploaded");
//        } else {
//            flash("error", "Missing file");
//            return redirect("/getCollections");
//        }
//    }






}
