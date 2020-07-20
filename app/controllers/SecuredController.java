package controllers;

import play.mvc.Controller;
import play.mvc.With;


/**
 * Created by aioannidis on 24/6/2016.
 * <p>
 * This class will be extended by all the controllers that will be secured.
 */
@With(SecurityActionHandler.class)
public class SecuredController extends Controller {

    protected static final long WS_TIMEOUT = 60000;

}