package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.DistrictsEntity;
import models.NotesEntity;
import models.VillagesEntity;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Result;

import javax.persistence.Query;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

public class NotesController {

//deleteNote



    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result deleteNote() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {

                Integer id = json.findPath("id").asInt();

                NotesEntity n = JPA.em().find(NotesEntity.class,id);

                JPA.em().remove(n);
                result.put("status", "ok");
                result.put("message", "Note has been deleted succesfully");
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Error while commiting,please contact with administrator and report the problem");
            return ok(result);
        }
    }



    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result editNote() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String title = json.findPath("title").asText();
                String description = json.findPath("description").asText();
                Integer roadId = json.findPath("roadId").asInt();
                Integer id = json.findPath("id").asInt();

                NotesEntity n = JPA.em().find(NotesEntity.class,id);
                n.setDescription(description);
                n.setTitle(title);
                n.setRoadId(roadId);
                n.setUpdateDate(new Date());
                JPA.em().merge(n);
                result.put("status", "ok");
                result.put("message", "Note has been updated succesfully");
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Error while commiting,please contact with administrator and report the problem");
            return ok(result);
        }
    }
//

    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result addNote() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
               NotesEntity road = Json.fromJson(json, NotesEntity.class);
                road.setCreationDate(new Date());
               JPA.em().persist(road);

                result.put("status", "ok");
                result.put("message", "Your note has been added succesfully!");
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Error while commiting,please contact with administrator and report the problem");
            return ok(result);
        }
    }

//    @SuppressWarnings("Duplicates")
//    @play.db.jpa.Transactional
//    @BodyParser.Of(BodyParser.Json.class)
//    public Result deleteVillage() {
//        try {
//            System.out.println("eedew");
//            JsonNode json = request().body().asJson(); //
//            ObjectNode result = Json.newObject();
//            if (json == null) {
//                return badRequest("Expecting Json data");
//            } else {
//                VillagesEntity village = JPA.em().find(VillagesEntity.class,json.findPath("id").asInt());
//                JPA.em().remove(village);
//                result.put("status", "ok");
//                result.put("message", "Village  has been deleted succesfully!");
//                return ok(result);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            ObjectNode result = Json.newObject();
//            result.put("status", "error");
//            result.put("message", "Error while commiting,please contact with administrator and report the problem");
//            return ok(result);
//        }
//    }


//getNoteByRoadId
//
    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getNoteByRoadId() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select * from notes d where d.road_id= "+json.findPath("roadId").asText();
                query+=" order by d.creation_date desc";


                Query q = JPA.em().createNativeQuery(query, NotesEntity.class);
                List<NotesEntity> distList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (NotesEntity d: distList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("id", d.getId());
                    roadObject.put("title", d.getTitle());
                    roadObject.put("roadId", d.getRoadId());
                    roadObject.put("description", d.getDescription());
                    roadObject.put("creationDate", d.getCreationDate());

                    finalRoadsList.add(roadObject);
                }
                returnList.put("data", finalRoadsList);
                returnList.put("total", total.intValue());
                returnList.put("status", "ok");
                DateFormat myDateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");

                ow.setDateFormat(myDateFormat);
                try {
                    jsonResult = ow.writeValueAsString(returnList);
                } catch (Exception e) {
                    e.printStackTrace();
                    result.put("status", "error");
                    result.put("message", "Problem in fetch data process,communicate with the administrator");
                    return ok(result);
                }
                return ok(jsonResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", "Problem in fetch data process,communicate with the administrator");
            return ok(result);
        }
    }
//
//


}
