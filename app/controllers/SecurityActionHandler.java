package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import play.Configuration;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by aioannidis on 24/6/2016.
 * <p>
 * This class represents the handler that filter every request
 * on the server and decides weather the request will pass or
 * it will be forbidden.
 * The selection is based on the authentication process made
 * with the user credentials from the database and the request header values
 * of @user and @token
 */
public class SecurityActionHandler extends Action.Simple {

    @Inject
    WSClient ws;

    @Inject
    Configuration configuration;

    private static final long WS_TIMEOUT = 60000;

    private static final List<String> publicSystemicActions = Arrays.asList(
            "login"
    );


    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        CompletionStage<Result> promiseResult = CompletableFuture.completedFuture(Results.forbidden());
        String action = ctx.request().uri().split("/")[1].split("\\?")[0]; //The request action
        System.out.println(action);

        if (!action.equals("login")) {//an den einai login

            try {

                Long timestamp = new Date().getTime();
                JsonNode requestJSON = ctx.request().body().asJson();

                Date actionTime = new Date();
                DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                Long time = actionTime.getTime();
                int randomNum = ThreadLocalRandom.current().nextInt(14350, 97854555 + 1);
                Long actionID = time + randomNum;

                String userId = null;
                userId = ctx.request().getHeader("id");

                System.out.println("id "+ctx.request().getHeader("id"));

                String serviceURL = configuration.getString("searchServer") + "log";
                WSRequest request = ws.url(serviceURL);
                WSRequest complexRequest = request.setRequestTimeout(WS_TIMEOUT)
                        .setContentType("application/json");


                final String actionUserId = userId;
                final String actionRequestToken = actionID.toString();
                final Long actionTimestamp = timestamp;

                if (actionUserId != null && !actionUserId.equals("") &&
                        actionRequestToken != null && !actionRequestToken.equals("") &&
                        actionTimestamp != null && actionTimestamp != 0) { //if auth is set the authorization is needed
                    return delegate.call(ctx);
                } else { //if auth is not set then forbidden
                    //return CompletableFuture.completedFuture(Results.forbidden());
                    return delegate.call(ctx);
                }

            } catch (Throwable t) {
                t.printStackTrace();
            }
            return promiseResult;

        } else if (action.equals("login")) {
            return delegate.call(ctx);
        }
        return promiseResult;
    }
}
