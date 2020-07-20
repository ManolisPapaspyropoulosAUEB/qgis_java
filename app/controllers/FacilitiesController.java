package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.DistrictCentersEntity;
import models.MosquesEntity;
import models.RoadsEntity;
import models.SchoolsEntity;
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

public class FacilitiesController {



    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getAllFacilities() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {

                List<HashMap<String, Object>> dataDistCenters = new ArrayList<HashMap<String, Object>>();
                List<HashMap<String, Object>> dataSchools = new ArrayList<HashMap<String, Object>>();
                List<HashMap<String, Object>> dataMosques = new ArrayList<HashMap<String, Object>>();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                Integer totalDistCenters = 0;
                Integer totalMosques = 0;
                Integer totalSchools = 0;

                ObjectMapper ow = new ObjectMapper();
                String jsonResult = "";
                String type = json.findPath("type").asText();
                String districtCode = json.findPath("num_district_code").asText();
                String provinceCode = json.findPath("num_province_code").asText();
                String districtCenters = "select * from district_centers d where 1=1 ";
                String schools = "select * from schools s where 1=1 ";
                String mosques = "select * from mosques m where 1=1 ";
                if(provinceCode!=null && !provinceCode.equalsIgnoreCase("")){
                    districtCenters+=" and d.pro_code="+provinceCode;
                    schools+=" and s.pro_code="+provinceCode;
                    mosques+=" and m.pro_code="+provinceCode;
                }
                if(districtCode!=null && !districtCode.equalsIgnoreCase("")){
                    districtCenters+=" and d.dist_code="+districtCode;
                    schools+=" and s.dist_code="+districtCode;
                    mosques+=" and m.dist_code="+districtCode;
                }
                if(type.equalsIgnoreCase("Schools")){
                    Query qS = JPA.em().createNativeQuery(schools, SchoolsEntity.class);
                    totalSchools = qS.getResultList().size();
                    List<SchoolsEntity> schoolsList = qS.getResultList();
                    for (SchoolsEntity school : schoolsList) {
                        HashMap<String, Object> distHM = new HashMap<String, Object>();
                        distHM.put("id", school.getId());
                        distHM.put("targetFid", school.getTargetFid());
                        distHM.put("name", school.getName());
                        distHM.put("type", school.getType());
                        distHM.put("east", school.getEast());
                        distHM.put("north", school.getNorth());
                        distHM.put("eastUtm42", school.getEastUtm42());
                        distHM.put("northUtm42", school.getNorthUtm42());
                        distHM.put("from", school.getFrom());
                        distHM.put("distName", school.getDistName());
                        distHM.put("distCode", school.getDistCode());
                        distHM.put("altDistName", school.getAltDistName());
                        distHM.put("distId", school.getDistCode());

                        dataSchools.add(distHM);
                    }

                }

                if(type.equalsIgnoreCase("Mosques")){
                    Query qM = JPA.em().createNativeQuery(mosques, MosquesEntity.class);
                    totalMosques = qM.getResultList().size();
                    List<MosquesEntity> mosquesList = qM.getResultList();
                    for (MosquesEntity mosque : mosquesList) {
                        HashMap<String, Object> distHM = new HashMap<String, Object>();
                        distHM.put("id", mosque.getId());
                        distHM.put("targetFid", mosque.getTarggetFid());
                        distHM.put("name", mosque.getName());
                        distHM.put("type", mosque.getType());
                        distHM.put("east", mosque.getEast());
                        distHM.put("north", mosque.getNorth());
                        distHM.put("eastUtm42", mosque.getEastUtm42());
                        distHM.put("northUtm42", mosque.getNorthUtm42());
                        distHM.put("from", mosque.getFrom());
                        distHM.put("distName", mosque.getDistName());
                        distHM.put("distCode", mosque.getDistCode());
                        distHM.put("altDistName", mosque.getAltDistName());
                        distHM.put("distId", mosque.getDistCode());
                        dataMosques.add(distHM);
                    }
                }

                if(type.equalsIgnoreCase("Distcenters")){
                    Query qDC = JPA.em().createNativeQuery(districtCenters, DistrictCentersEntity.class);
                    totalDistCenters = qDC.getResultList().size();
                    List<DistrictCentersEntity> districtList = qDC.getResultList();
                    for (DistrictCentersEntity distrct : districtList) {
                        HashMap<String, Object> distHM = new HashMap<String, Object>();
                        distHM.put("id", distrct.getId());
                        distHM.put("proName", distrct.getProName());
                        distHM.put("proCenter", distrct.getProCenter());
                        distHM.put("proCode", distrct.getProCode());
                        distHM.put("distName", distrct.getDistName());
                        distHM.put("distCode", distrct.getDistCode());
                        distHM.put("centerType", distrct.getCenterType());
                        distHM.put("east", distrct.getEast());
                        distHM.put("north", distrct.getNorth());
                        distHM.put("eastUtm42", distrct.getEastUtm42());
                        distHM.put("northUtm42", distrct.getNorthUtm42());
                        distHM.put("checked", false);
                        distHM.put("checkedFilter", false);
                        dataDistCenters.add(distHM);
                    }
                }

                if(type.equalsIgnoreCase("Both")){

                    Query qDC = JPA.em().createNativeQuery(districtCenters, DistrictCentersEntity.class);
                    Query qM = JPA.em().createNativeQuery(mosques, MosquesEntity.class);
                    Query qS = JPA.em().createNativeQuery(schools, SchoolsEntity.class);
                    List<DistrictCentersEntity> districtList = qDC.getResultList();
                    List<MosquesEntity> mosquesList = qM.getResultList();
                    List<SchoolsEntity> schoolsList = qS.getResultList();

                     totalDistCenters = qDC.getResultList().size();
                     totalMosques = qM.getResultList().size();
                     totalSchools = qS.getResultList().size();

                    for (DistrictCentersEntity distrct : districtList) {
                        HashMap<String, Object> distHM = new HashMap<String, Object>();
                        distHM.put("id", distrct.getId());
                        distHM.put("proName", distrct.getProName());
                        distHM.put("proCenter", distrct.getProCenter());
                        distHM.put("proCode", distrct.getProCode());
                        distHM.put("distName", distrct.getDistName());
                        distHM.put("distCode", distrct.getDistCode());
                        distHM.put("centerType", distrct.getCenterType());
                        distHM.put("east", distrct.getEast());
                        distHM.put("north", distrct.getNorth());
                        distHM.put("eastUtm42", distrct.getEastUtm42());
                        distHM.put("northUtm42", distrct.getNorthUtm42());
                        dataDistCenters.add(distHM);
                    }

                    for (SchoolsEntity school : schoolsList) {
                        HashMap<String, Object> distHM = new HashMap<String, Object>();
                        distHM.put("id", school.getId());
                        distHM.put("targetFid", school.getTargetFid());
                        distHM.put("name", school.getName());
                        distHM.put("type", school.getType());
                        distHM.put("east", school.getEast());
                        distHM.put("north", school.getNorth());
                        distHM.put("eastUtm42", school.getEastUtm42());
                        distHM.put("northUtm42", school.getNorthUtm42());
                        distHM.put("from", school.getFrom());
                        distHM.put("distName", school.getDistName());
                        distHM.put("distCode", school.getDistCode());
                        distHM.put("altDistName", school.getAltDistName());
                        distHM.put("distId", school.getDistCode());

                        dataSchools.add(distHM);
                    }

                    for (MosquesEntity mosque : mosquesList) {
                        HashMap<String, Object> distHM = new HashMap<String, Object>();
                        distHM.put("id", mosque.getId());
                        distHM.put("targetFid", mosque.getTarggetFid());
                        distHM.put("name", mosque.getName());
                        distHM.put("type", mosque.getType());
                        distHM.put("east", mosque.getEast());
                        distHM.put("north", mosque.getNorth());
                        distHM.put("eastUtm42", mosque.getEastUtm42());
                        distHM.put("northUtm42", mosque.getNorthUtm42());
                        distHM.put("from", mosque.getFrom());
                        distHM.put("distName", mosque.getDistName());
                        distHM.put("distCode", mosque.getDistCode());
                        distHM.put("altDistName", mosque.getAltDistName());
                        distHM.put("distId", mosque.getDistCode());
                        dataMosques.add(distHM);
                    }
                }
                returnList.put("dataMosques", dataMosques);
                returnList.put("dataSchools", dataSchools);
                returnList.put("dataDistCenters", dataDistCenters);
                returnList.put("totalDistCenters", totalDistCenters);
                returnList.put("totalMosques", totalMosques);
                returnList.put("totalSchools", totalSchools);
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
