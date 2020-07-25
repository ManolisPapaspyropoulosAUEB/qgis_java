package GeneralApi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;

import javax.persistence.Query;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;
public class CoreDataController {
    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getAllCriteriaMaster() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select * from criteria_master d where 1=1 ";
                String label = json.findPath("label").asText();
                if(label!=null && !label.equalsIgnoreCase("") ){
                    query+=" and d.criterion_label like '%"+label+"%'";
                }
                Query q = JPA.em().createNativeQuery(query, CriteriaMasterEntity.class);
                List<CriteriaMasterEntity> distList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (CriteriaMasterEntity d: distList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("id", d.getId());
                    roadObject.put("label", d.getCriterionLabel());
                    roadObject.put("scoreRange", d.getScoreRange());
                    roadObject.put("weightFactor", d.getWeightFactor());
                    String cmd = " select * from criteria_master_details cmd where cmd.criteria_master_id="+d.getId();
                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(cmd,CriteriaMasterDetailsEntity.class).getResultList();
                    ArrayList<HashMap<String,Object>> cmdFlist = new ArrayList<HashMap<String,Object>>();
                    for(CriteriaMasterDetailsEntity cmdOb : cmdList){
                        HashMap<String, Object> cmdM = new HashMap<String, Object>();
                        cmdM.put("id", cmdOb.getId());
                        cmdM.put("label", cmdOb.getLabel());
                        cmdM.put("score", cmdOb.getScore());
                        cmdFlist.add(cmdM);
                    }
                    roadObject.put("cmdList", cmdFlist);
                    finalRoadsList.add(roadObject);
                }
                returnList.put("data", finalRoadsList);
                String opParam = "select * from operetional_parameters op ";
                List<OperetionalParametersEntity> opList = JPA.em().createNativeQuery(opParam,OperetionalParametersEntity.class).getResultList();
                returnList.put("data", finalRoadsList);
                returnList.put("opParam", opList.get(0).getEstimatedMaintenanceCost());
                returnList.put("opId", opList.get(0).getId());
                returnList.put("total", total.intValue());
                returnList.put("status", "ok");
                DateFormat myDateFormat = new SimpleDateFormat("M/d/Y");
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
    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result updateEstimatedMaintenanceCost() {
        try {
            JsonNode json = Http.Context.Implicit.request().body().asJson();
            ObjectNode result = Json.newObject();
            if (json.findPath("id") == null) {
                return badRequest("Expecting Json data");
            } else {
                Double estimatedMaintenanceCost = json.findPath("opParam").asDouble();
                Integer id = json.findPath("opId").asInt();
                OperetionalParametersEntity op = JPA.em().find(OperetionalParametersEntity.class,id);
                op.setEstimatedMaintenanceCost(estimatedMaintenanceCost);
                JPA.em().merge(op);
                result.put("status", "ok");
                result.put("message", "Update successfully");
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ObjectNode result = Json.newObject();
            result.put("status", "error");
            result.put("message", "Πρόβλημα κατά την εισαγωγή .");
            return ok(result);
        }
    }





}
