package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.DistrictsEntity;
import models.VillagesEntity;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.BodyParser;
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

public class VillageController {

    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getAllVillages() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select * from villages d where 1=1 ";

                String num_province_code = json.findPath("num_province_code").asText();
                String num_district_code = json.findPath("num_district_code").asText();
                String villageNameFilter = json.findPath("villageNameFilter").asText();

                if(num_province_code!=null && !num_province_code.equalsIgnoreCase("")){
                    query+=" and d.pro_code="+num_province_code;
                }

                if(num_district_code!=null && !num_district_code.equalsIgnoreCase("")){
                    query+=" and d.dist_code="+num_district_code;
                }

                if(villageNameFilter!=null && !villageNameFilter.equalsIgnoreCase("")){
                    query+=" and d.village_1 like '%"+villageNameFilter+"%'";
                }

                Query q = JPA.em().createNativeQuery(query, VillagesEntity.class);
                List<VillagesEntity> distList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (VillagesEntity d: distList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("id", d.getId());
                    roadObject.put("villageCo", d.getVillageCo());
                    roadObject.put("village1", d.getVillage1());
                    roadObject.put("proCode", d.getProCode());
                    roadObject.put("distCode", d.getDistCode());
                    roadObject.put("mapLong", d.getMapLong());
                    roadObject.put("mapLat", d.getMapLat());
                    roadObject.put("villagePop", d.getVillagePop());
                    roadObject.put("villageHh", d.getVillageHh());
                    roadObject.put("east", d.getEast());
                    roadObject.put("north", d.getNorth());
                    roadObject.put("eastUtm42", d.getEastUtm42());
                    roadObject.put("northUtm42", d.getNorthUtm42());
                    roadObject.put("villageName", d.getVillage1());
                    finalRoadsList.add(roadObject);
                }
                returnList.put("data", finalRoadsList);
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

}
