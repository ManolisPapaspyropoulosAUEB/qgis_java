package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
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

                System.out.println(districtCenters);

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
                        distHM.put("from", school.getFromSource());
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
                        distHM.put("facilitie", "districtcenter");
                        distHM.put("eastUtm42", distrct.getEastUtm42());
                        distHM.put("northUtm42", distrct.getNorthUtm42());
                        dataDistCenters.add(distHM);
                    }

                    for (SchoolsEntity school : schoolsList) {
                        HashMap<String, Object> distHM = new HashMap<String, Object>();
                        distHM.put("id", school.getId());
                        distHM.put("targetFid", school.getTargetFid());
                        distHM.put("name", school.getName());
                        distHM.put("facilitie", "school");

                        distHM.put("type", school.getType());
                        distHM.put("east", school.getEast());
                        distHM.put("north", school.getNorth());
                        distHM.put("eastUtm42", school.getEastUtm42());
                        distHM.put("northUtm42", school.getNorthUtm42());
                        distHM.put("from", school.getFromSource());
                        distHM.put("distName", school.getDistName());
                        distHM.put("distCode", school.getDistCode());
                        distHM.put("distCode", school.getDistCode());

                        String district = "select * from districts d where d.numerical_district_code="+school.getDistCode();

                        System.out.println(district);
                        List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(district,DistrictsEntity.class).getResultList();
                        distHM.put("distName", districtsList.get(0).getDistrictName());

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
                        distHM.put("facilitie", "mosque");

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

    //

    //deleteDistrictCenter deleteDistrictCenter


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result deleteSchool() {
        try {
            System.out.println("eedew");
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {

                DistrictCentersEntity districtCenter = JPA.em().find(DistrictCentersEntity.class,json.findPath("id").asInt());

                JPA.em().remove(districtCenter);
                result.put("status", "ok");
                result.put("message", "District Center  has been deleted succesfully!");
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
    public Result deleteDistrictCenter() {
        try {
            System.out.println("eedew");
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {

                DistrictCentersEntity districtCenter = JPA.em().find(DistrictCentersEntity.class,json.findPath("id").asInt());

                JPA.em().remove(districtCenter);
                result.put("status", "ok");
                result.put("message", "District Center  has been deleted succesfully!");
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
    public Result updateDistrictCenter() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String proCenter = json.findPath("proCenter").asText();
                Integer num_district_code = json.findPath("num_district_code").asInt();
                String districtType = json.findPath("districtType").asText();
                Integer num_province_code = json.findPath("num_province_code").asInt();
                BigDecimal east = json.findPath("east").decimalValue();
                BigDecimal north = json.findPath("north").decimalValue();
                Integer northUtm42 = json.findPath("northUtm42").asInt();
                Integer eastUtm42 = json.findPath("eastUtm42").asInt();
                DistrictCentersEntity districtCenter = JPA.em().find(DistrictCentersEntity.class,json.findPath("id").asInt());
                districtCenter.setCenterType(districtType);
                districtCenter.setProCenter(proCenter);
                districtCenter.setDistCode(num_district_code);
                districtCenter.setProCode(num_province_code);
                districtCenter.setEast(east);
                districtCenter.setNorth(north);
                districtCenter.setNorthUtm42(northUtm42);
                districtCenter.setEastUtm42(eastUtm42);
                String sqlDP= "select * from districts d where d.numerical_province_code="+num_province_code +" and d.numerical_district_code="+num_district_code;
                System.out.println(sqlDP);
                List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(sqlDP,DistrictsEntity.class).getResultList();
                districtCenter.setDistName(districtsList.get(0).getDistrictName());
                districtCenter.setProName(districtsList.get(0).getProvinceName());
                JPA.em().persist(districtCenter);
                result.put("status", "ok");
                result.put("message", "District Center: "+proCenter +" has been updated succesfully!");
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
    public Result addDistrictCenter() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String proCenter = json.findPath("proCenter").asText();
                Integer num_district_code = json.findPath("num_district_code").asInt();
                String districtType = json.findPath("districtType").asText();
                Integer num_province_code = json.findPath("num_province_code").asInt();
                BigDecimal east = json.findPath("east").decimalValue();
                BigDecimal north = json.findPath("north").decimalValue();
                Integer northUtm42 = json.findPath("northUtm42").asInt();
                Integer eastUtm42 = json.findPath("eastUtm42").asInt();
                DistrictCentersEntity districtCenter = new DistrictCentersEntity();
                districtCenter.setCenterType(districtType);
                districtCenter.setProCenter(proCenter);
                districtCenter.setDistCode(num_district_code);
                districtCenter.setProCode(num_province_code);
                districtCenter.setEast(east);
                districtCenter.setNorth(north);
                districtCenter.setNorthUtm42(northUtm42);
                districtCenter.setEastUtm42(eastUtm42);
                String sqlDP= "select * from districts d where d.numerical_province_code="+num_province_code +" and d.numerical_district_code="+num_district_code;
                System.out.println(sqlDP);
                List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(sqlDP,DistrictsEntity.class).getResultList();
                districtCenter.setDistName(districtsList.get(0).getDistrictName());
                districtCenter.setProName(districtsList.get(0).getProvinceName());
                JPA.em().persist(districtCenter);
                result.put("status", "ok");
                result.put("message", "District Center: "+proCenter +" has been added succesfully!");
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
    public Result updateSchool() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {


                String altDistName = json.findPath("altDistName").asText();
                Integer num_district_code = json.findPath("num_district_code").asInt();
                String from = json.findPath("from").asText();
                String type = json.findPath("type").asText();
                String name = json.findPath("name").asText();

                Integer num_province_code = json.findPath("num_province_code").asInt();
                Integer targetFid = json.findPath("targetFid").asInt();

                BigDecimal east = json.findPath("east").decimalValue();
                BigDecimal north = json.findPath("north").decimalValue();
                Integer northUtm42 = json.findPath("northUtm42").asInt();
                Integer eastUtm42 = json.findPath("eastUtm42").asInt();


                SchoolsEntity school = JPA.em().find(SchoolsEntity.class,json.findPath("id").asInt());

                school.setDistCode(num_district_code);
                school.setName(name);
                school.setTargetFid(targetFid);
                school.setType(type);
                school.setFromSource(from);
                school.setAltDistName(altDistName);
                school.setProCode(num_province_code);
                school.setEast(east);
                school.setNorth(north);
                school.setNorthUtm42(northUtm42);
                school.setEastUtm42(eastUtm42);

                String sqlDP= "select * from districts d where d.numerical_province_code="+num_province_code +" and d.numerical_district_code="+num_district_code;
                System.out.println(sqlDP);
                List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(sqlDP,DistrictsEntity.class).getResultList();
                school.setDistName(districtsList.get(0).getDistrictName());
                JPA.em().merge(school);
                result.put("status", "ok");
                result.put("message", "School: "+name +" has been updated succesfully!");
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
    public Result addSchool() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {


                String altDistName = json.findPath("altDistName").asText();
                Integer num_district_code = json.findPath("num_district_code").asInt();
                String from = json.findPath("from").asText();
                String type = json.findPath("type").asText();
                String name = json.findPath("name").asText();

                Integer num_province_code = json.findPath("num_province_code").asInt();
                Integer targetFid = json.findPath("targetFid").asInt();

                BigDecimal east = json.findPath("east").decimalValue();
                BigDecimal north = json.findPath("north").decimalValue();
                Integer northUtm42 = json.findPath("northUtm42").asInt();
                Integer eastUtm42 = json.findPath("eastUtm42").asInt();

                SchoolsEntity school = new SchoolsEntity();


                school.setDistCode(num_district_code);
                school.setName(name);
                school.setTargetFid(targetFid);
                school.setType(type);
                school.setFromSource(from);
                school.setAltDistName(altDistName);
                school.setProCode(num_province_code);
                school.setEast(east);
                school.setNorth(north);
                school.setNorthUtm42(northUtm42);
                school.setEastUtm42(eastUtm42);

                String sqlDP= "select * from districts d where d.numerical_province_code="+num_province_code +" and d.numerical_district_code="+num_district_code;
                System.out.println(sqlDP);
                List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(sqlDP,DistrictsEntity.class).getResultList();
                school.setDistName(districtsList.get(0).getDistrictName());
                JPA.em().persist(school);
                result.put("status", "ok");
                result.put("message", "School: "+name +" has been added succesfully!");
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





}
