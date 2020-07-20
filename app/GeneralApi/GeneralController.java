package GeneralApi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.DistrictsEntity;
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
import java.util.Iterator;
import java.util.List;

import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

public class GeneralController {


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getAllProvinces() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = "SELECT distinct\n" +
                        " province_name, \n" +
                        "numerical_province_code, \n" +
                        "alphanumerical_province_code \n" +
                        " FROM `DISTRICTS` WHERE 1;\n ";
                Query q = JPA.em().createNativeQuery(query);
                List distList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                ArrayList<HashMap<String, Object>> finalProvList = new ArrayList<HashMap<String, Object>>();
                Iterator it = distList.iterator();
                while (it.hasNext()){
                    JsonNode p = Json.toJson(it.next());
                    HashMap<String, Object> item = new HashMap<>();
                    item.put("province_name",p.get(0));
                    item.put("num_province_code",p.get(1));
                    item.put("alpha_province_code",p.get(2));
                    finalProvList.add(item);
                }
                returnList.put("data", finalProvList);
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
    public Result getAllDistricts() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select * from districts d where 1=1 ";
                String province_code = json.findPath("num_province_code").asText();
                if(province_code!=null && !province_code.equalsIgnoreCase("")){
                    query+=" and d.numerical_province_code="+province_code;
                }
                Query q = JPA.em().createNativeQuery(query, DistrictsEntity.class);
                List<DistrictsEntity> distList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (DistrictsEntity d: distList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("id", d.getId());
                    roadObject.put("district_name", d.getDistrictName());
                    roadObject.put("x_distance", d.getxDistance());
                    roadObject.put("y_distance", d.getyDistance());
                    roadObject.put("zoom_info_district", d.getZoomInfoDistrict());
                    roadObject.put("alpha_district_code", d.getAlphanumericalDistrictCode());
                    roadObject.put("num_district_code", d.getNumericalDistrictCode());
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
