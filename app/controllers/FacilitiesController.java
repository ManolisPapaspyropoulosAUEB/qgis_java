package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import org.cloudinary.json.JSONArray;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Result;

import javax.persistence.Query;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

public class FacilitiesController {



//    @SuppressWarnings("Duplicates")
//    @play.db.jpa.Transactional
//    @BodyParser.Of(BodyParser.Json.class)
//    public Result getAllFacilities() throws IOException {
//        ObjectNode result = Json.newObject();
//        try {
//            JsonNode json = request().body().asJson();
//            if (json == null) {
//                return badRequest("Expecting Json data");
//            } else {
//                List<HashMap<String, Object>> dataDistCenters = new ArrayList<HashMap<String, Object>>();
//                List<HashMap<String, Object>> dataSchools = new ArrayList<HashMap<String, Object>>();
//                List<HashMap<String, Object>> dataMosques = new ArrayList<HashMap<String, Object>>();
//                HashMap<String, Object> returnList = new HashMap<String, Object>();
//                Integer totalDistCenters = 0;
//                Integer totalMosques = 0;
//                Integer totalSchools = 0;
//                ObjectMapper ow = new ObjectMapper();
//                String jsonResult = "";
//                String type = json.findPath("type").asText();
//                String districtCode = json.findPath("num_district_code").asText();
//                String provinceCode = json.findPath("num_province_code").asText();
//                String nameFilter = json.findPath("nameFilter").asText();
//                String districtCenters = "select * from district_centers d where 1=1 ";
//                String schools = "select * from schools s where 1=1 ";
//                String mosques = "select * from mosques m where 1=1 ";
//                if(provinceCode!=null && !provinceCode.equalsIgnoreCase("")){
//                    districtCenters+=" and d.pro_code="+provinceCode;
//                    schools+=" and s.pro_code="+provinceCode;
//                    mosques+=" and m.pro_code="+provinceCode;
//                }
//                if(districtCode!=null && !districtCode.equalsIgnoreCase("")){
//                    districtCenters+=" and d.dist_code="+districtCode;
//                    schools+=" and s.dist_code="+districtCode;
//                    mosques+=" and m.dist_code="+districtCode;
//                }
//
//                if(nameFilter!=null && !nameFilter.equalsIgnoreCase("")){
//                    //query+=" and d.criterion_label like '%"+label+"%'";
//                    districtCenters+=" and d.pro_center  like   '%"+nameFilter+"%'";
//                    schools+=" and s.name  like  '%"+nameFilter+"%'";
//                    mosques+=" and m.name like '%"+nameFilter+"%'";
//                }
//                if(type.equalsIgnoreCase("Schools")){
//                    Query qS = JPA.em().createNativeQuery(schools, SchoolsEntity.class);
//                    totalSchools = qS.getResultList().size();
//                    List<SchoolsEntity> schoolsList = qS.getResultList();
//                    for (SchoolsEntity school : schoolsList) {
//                        HashMap<String, Object> distHM = new HashMap<String, Object>();
//                        distHM.put("id", school.getId());
//                        distHM.put("targetFid", school.getTargetFid());
//                        distHM.put("name", school.getName());
//                        distHM.put("type", school.getType());
//                        distHM.put("east", school.getEast());
//                        distHM.put("north", school.getNorth());
//                        distHM.put("eastUtm42", school.getEastUtm42());
//                        distHM.put("northUtm42", school.getNorthUtm42());
//                        distHM.put("from", school.getFromSource());
//                        distHM.put("distName", school.getDistName());
//                        distHM.put("proCode", school.getProCode());
//
//                        distHM.put("distCode", school.getDistCode());
//                        distHM.put("altDistName", school.getAltDistName());
//                        distHM.put("distId", school.getDistCode());
//                        dataSchools.add(distHM);
//                    }
//                }
//                if(type.equalsIgnoreCase("Mosques")){
//                    Query qM = JPA.em().createNativeQuery(mosques, MosquesEntity.class);
//                    totalMosques = qM.getResultList().size();
//                    List<MosquesEntity> mosquesList = qM.getResultList();
//                    for (MosquesEntity mosque : mosquesList) {
//                        HashMap<String, Object> distHM = new HashMap<String, Object>();
//                        distHM.put("id", mosque.getId());
//                        distHM.put("targetFid", mosque.getTargetFid());
//                        distHM.put("name", mosque.getName());
//                        distHM.put("type", mosque.getType());
//                        distHM.put("east", mosque.getEast());
//                        distHM.put("north", mosque.getNorth());
//                        distHM.put("eastUtm42", mosque.getEastUtm42());
//                        distHM.put("northUtm42", mosque.getNorthUtm42());
//                        distHM.put("from", mosque.getFromSource());
//                        distHM.put("proCode", mosque.getProCode());
//
//                        distHM.put("distName", mosque.getDistName());
//                        distHM.put("distCode", mosque.getDistCode());
//                        distHM.put("altDistName", mosque.getAltDistName());
//                        distHM.put("distId", mosque.getDistCode());
//                        dataMosques.add(distHM);
//                    }
//                }
//                if(type.equalsIgnoreCase("Distcenters")){
//                    Query qDC = JPA.em().createNativeQuery(districtCenters, DistrictCentersEntity.class);
//                    totalDistCenters = qDC.getResultList().size();
//                    List<DistrictCentersEntity> districtList = qDC.getResultList();
//                    for (DistrictCentersEntity distrct : districtList) {
//                        HashMap<String, Object> distHM = new HashMap<String, Object>();
//                        distHM.put("id", distrct.getId());
//                        distHM.put("proName", distrct.getProName());
//                        distHM.put("proCenter", distrct.getProCenter());
//                        distHM.put("proCode", distrct.getProCode());
//                        distHM.put("distName", distrct.getDistName());
//                        distHM.put("distCode", distrct.getDistCode());
//                        distHM.put("centerType", distrct.getCenterType());
//                        distHM.put("east", distrct.getEast());
//                        distHM.put("north", distrct.getNorth());
//                        distHM.put("eastUtm42", distrct.getEastUtm42());
//                        distHM.put("northUtm42", distrct.getNorthUtm42());
//                        distHM.put("checked", false);
//                        distHM.put("checkedFilter", false);
//                        dataDistCenters.add(distHM);
//                    }
//                }
//                if(type.equalsIgnoreCase("Both")){
//                    Query qDC = JPA.em().createNativeQuery(districtCenters, DistrictCentersEntity.class);
//                    Query qM = JPA.em().createNativeQuery(mosques, MosquesEntity.class);
//                    Query qS = JPA.em().createNativeQuery(schools, SchoolsEntity.class);
//                    List<DistrictCentersEntity> districtList = qDC.getResultList();
//                    List<MosquesEntity> mosquesList = qM.getResultList();
//                    List<SchoolsEntity> schoolsList = qS.getResultList();
//                     totalDistCenters = qDC.getResultList().size();
//                     totalMosques = qM.getResultList().size();
//                     totalSchools = qS.getResultList().size();
//                    for (DistrictCentersEntity distrct : districtList) {
//                        HashMap<String, Object> distHM = new HashMap<String, Object>();
//                        distHM.put("id", distrct.getId());
//                        distHM.put("proName", distrct.getProName());
//                        distHM.put("proCenter", distrct.getProCenter());
//                        distHM.put("proCode", distrct.getProCode());
//                        distHM.put("distName", distrct.getDistName());
//                        distHM.put("distCode", distrct.getDistCode());
//                        distHM.put("centerType", distrct.getCenterType());
//                        distHM.put("east", distrct.getEast());
//                        distHM.put("north", distrct.getNorth());
//                        distHM.put("proCode", distrct.getProCode());
//
//                        distHM.put("facilitie", "districtcenter");
//                        distHM.put("eastUtm42", distrct.getEastUtm42());
//                        distHM.put("northUtm42", distrct.getNorthUtm42());
//                        dataDistCenters.add(distHM);
//                    }
//                    for (SchoolsEntity school : schoolsList) {
//                        HashMap<String, Object> distHM = new HashMap<String, Object>();
//                        distHM.put("id", school.getId());
//                        distHM.put("targetFid", school.getTargetFid());
//                        distHM.put("name", school.getName());
//                        distHM.put("facilitie", "school");
//                        distHM.put("type", school.getType());
//                        distHM.put("east", school.getEast());
//                        distHM.put("north", school.getNorth());
//                        distHM.put("proCode", school.getProCode());
//
//                        distHM.put("eastUtm42", school.getEastUtm42());
//                        distHM.put("northUtm42", school.getNorthUtm42());
//                        distHM.put("from", school.getFromSource());
//                        distHM.put("distName", school.getDistName());
//                        distHM.put("distCode", school.getDistCode());
//                        distHM.put("distCode", school.getDistCode());
//                        String district = "select * from districts d where d.numerical_district_code="+school.getDistCode();
//                        List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(district,DistrictsEntity.class).getResultList();
//                        distHM.put("distName", districtsList.get(0).getDistrictName());
//                        distHM.put("altDistName", school.getAltDistName());
//                        distHM.put("distId", school.getDistCode());
//                        dataSchools.add(distHM);
//                    }
//                    for (MosquesEntity mosque : mosquesList) {
//                        HashMap<String, Object> distHM = new HashMap<String, Object>();
//                        distHM.put("id", mosque.getId());
//                        distHM.put("targetFid", mosque.getTargetFid());
//                        distHM.put("name", mosque.getName());
//                        distHM.put("type", mosque.getType());
//                        distHM.put("east", mosque.getEast());
//                        distHM.put("facilitie", "mosque");
//                        distHM.put("proCode", mosque.getProCode());
//
//                        distHM.put("north", mosque.getNorth());
//                        distHM.put("eastUtm42", mosque.getEastUtm42());
//                        distHM.put("northUtm42", mosque.getNorthUtm42());
//                        distHM.put("from", mosque.getFromSource());
//                        distHM.put("distName", mosque.getDistName());
//                        distHM.put("distCode", mosque.getDistCode());
//                        distHM.put("altDistName", mosque.getAltDistName());
//                        distHM.put("distId", mosque.getDistCode());
//                        dataMosques.add(distHM);
//                    }
//                }
//                returnList.put("dataMosques", dataMosques);
//                returnList.put("dataSchools", dataSchools);
//                returnList.put("dataDistCenters", dataDistCenters);
//                returnList.put("totalDistCenters", totalDistCenters);
//                returnList.put("totalMosques", totalMosques);
//                returnList.put("totalSchools", totalSchools);
//                returnList.put("status", "ok");
//                DateFormat myDateFormat = new SimpleDateFormat("M/d/Y");
//                ow.setDateFormat(myDateFormat);
//                try {
//                    jsonResult = ow.writeValueAsString(returnList);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    result.put("status", "error");
//                    result.put("message", "Problem in fetch data process,communicate with the administrator");
//                    return ok(result);
//                }
//                return ok(jsonResult);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("status", "error");
//            result.put("message", "Problem in fetch data process,communicate with the administrator");
//            return ok(result);
//        }
//    }


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result deleteSchool() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                SchoolsEntity school = JPA.em().find(SchoolsEntity.class,json.findPath("id").asInt());
                JPA.em().remove(school);
                result.put("status", "ok");
                result.put("message", "School  has been deleted succesfully!");
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

//addMosque updateFacilitie


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result deleteFacilitie() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                FacilitiesEntity mosque = JPA.em().find(FacilitiesEntity.class,json.findPath("id").asInt());
                JPA.em().remove(mosque);
                result.put("status", "ok");
                result.put("message", "Facilitite  has been deleted succesfully!");
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
    public Result updateFacilitie() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                BigDecimal north = json.findPath("north").decimalValue();
                BigDecimal east = json.findPath("east").decimalValue();
                String from = json.findPath("fromSource").asText();
                String label = json.findPath("label").asText();
                String type = json.findPath("type").asText();
                Integer num_district_code = json.findPath("num_district_code").asInt();
                Integer num_province_code = json.findPath("num_province_code").asInt();
                Integer id = json.findPath("id").asInt();

                String sqlDP= "select * from districts d where d.numerical_province_code="+num_province_code +" and d.numerical_district_code="+num_district_code;
                List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(sqlDP,DistrictsEntity.class).getResultList();

                String proName = districtsList.get(0).getProvinceName();
                String distrName =districtsList.get(0).getDistrictName();

                FacilitiesEntity f = JPA.em().find(FacilitiesEntity.class,id);
                f.setNorth(north);
                f.setEast(east);
                f.setFromSource(from);
                f.setLabel(label);
                f.setPoiType(type);





                f.setDistrictName(distrName);
                f.setDistrictCode(num_district_code);

                f.setProvinceName(proName);
                f.setProvinceCode(num_province_code);

                JPA.em().merge(f);


                result.put("status", "ok");
                result.put("message", "Facility:  has been added succesfully!");
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
    public Result addFacilitie() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                BigDecimal north = json.findPath("north").decimalValue();
                BigDecimal east = json.findPath("east").decimalValue();
                String from = json.findPath("fromSource").asText();
                String label = json.findPath("label").asText();
                String type = json.findPath("type").asText();
                Integer num_district_code = json.findPath("num_district_code").asInt();
                Integer num_province_code = json.findPath("num_province_code").asInt();

                String sqlDP= "select * from districts d where d.numerical_province_code="+num_province_code +" and d.numerical_district_code="+num_district_code;
                List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(sqlDP,DistrictsEntity.class).getResultList();

                String proName = districtsList.get(0).getProvinceName();
                String distrName =districtsList.get(0).getDistrictName();

                FacilitiesEntity f = new FacilitiesEntity();
                f.setNorth(north);
                f.setEast(east);
                f.setFromSource(from);
                f.setLabel(label);
                f.setPoiType(type);




                f.setDistrictName(distrName);
                f.setDistrictCode(num_district_code);

                f.setProvinceName(proName);
                f.setProvinceCode(num_province_code);

                JPA.em().persist(f);


                result.put("status", "ok");
                result.put("message", "Facility:  has been added succesfully!");
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
    public Result addMosque() {
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
                MosquesEntity mosquesEntity = new MosquesEntity();
                mosquesEntity.setDistCode(num_district_code);
                mosquesEntity.setName(name);
                mosquesEntity.setTargetFid(targetFid);
                mosquesEntity.setType(type);
                mosquesEntity.setFromSource(from);
                mosquesEntity.setAltDistName(altDistName);
                mosquesEntity.setProCode(num_province_code);
                mosquesEntity.setEast(east);
                mosquesEntity.setNorth(north);
                mosquesEntity.setNorthUtm42(northUtm42);
                mosquesEntity.setEastUtm42(eastUtm42);
                String sqlDP= "select * from districts d where d.numerical_province_code="+num_province_code +" and d.numerical_district_code="+num_district_code;
                List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(sqlDP,DistrictsEntity.class).getResultList();
                mosquesEntity.setDistName(districtsList.get(0).getDistrictName());
                JPA.em().persist(mosquesEntity);
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


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result updateMosque() {
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
                MosquesEntity mosquesEntity = JPA.em().find(MosquesEntity.class,json.findPath("id").asInt());
                mosquesEntity.setDistCode(num_district_code);
                mosquesEntity.setName(name);
                mosquesEntity.setTargetFid(targetFid);
                mosquesEntity.setType(type);
                mosquesEntity.setFromSource(from);
                mosquesEntity.setAltDistName(altDistName);
                mosquesEntity.setProCode(num_province_code);
                mosquesEntity.setEast(east);
                mosquesEntity.setNorth(north);
                mosquesEntity.setNorthUtm42(northUtm42);
                mosquesEntity.setEastUtm42(eastUtm42);
                String sqlDP= "select * from districts d where d.numerical_province_code="+num_province_code +" and d.numerical_district_code="+num_district_code;
                List<DistrictsEntity> districtsList = JPA.em().createNativeQuery(sqlDP,DistrictsEntity.class).getResultList();
                mosquesEntity.setDistName(districtsList.get(0).getDistrictName());
                JPA.em().merge(mosquesEntity);
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
    public Result deleteMosque() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                MosquesEntity mosque = JPA.em().find(MosquesEntity.class,json.findPath("id").asInt());
                JPA.em().remove(mosque);
                result.put("status", "ok");
                result.put("message", "Mosque  has been deleted succesfully!");
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
    /**meta apo entolh olandou ta parapanw paragrafontai...eleos**/
    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result importFacilitiesDataFromJson() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                Iterator data = json.findPath("data").iterator();
                Iterator itC;
                while (data.hasNext()){
                    JsonNode facilitie = Json.toJson(data.next());
                    HashMap<String, Object> item = new HashMap<>();
                    item.put("district",facilitie.findPath("district"));
                    item.put("POI",facilitie.findPath("POI"));
                    item.put("Label",facilitie.findPath("Label"));
                    item.put("Source",facilitie.findPath("Source"));
                    itC=null;
                    itC = facilitie.findPath("coordinates").iterator();
                    String east =  itC.next().toString();
                    String north =  itC.next().toString();

                    System.out.println(east);
                    System.out.println(north);

                    String districtProvince = "select * from districts d where d.district_name='"+facilitie.findPath("district").asText()  +"'";
                    List<DistrictsEntity> dList = JPA.em().createNativeQuery(districtProvince,DistrictsEntity.class).getResultList();
                    FacilitiesEntity f = new FacilitiesEntity();
                    if(dList.size()>0){
                        f.setProvinceCode(dList.get(0).getNumericalProvinceCode());
                        f.setDistrictCode(dList.get(0).getNumericalDistrictCode());
                        f.setProvinceName(dList.get(0).getProvinceName());
                    }else{
                        f.setProvinceCode(0);
                        f.setDistrictCode(0);
                        f.setProvinceName("-");
                    }
                    f.setDistrictName(facilitie.findPath("district").asText());
                    if(facilitie.findPath("Source").asText().equalsIgnoreCase("null")){
                        f.setFromSource("-");
                    }else{
                        f.setFromSource(facilitie.findPath("Source").asText());
                    }
                    f.setLabel(facilitie.findPath("Label").asText());
                    f.setNorth(new BigDecimal(north));
                    f.setEast(new BigDecimal(east));
                    f.setPoiType(facilitie.findPath("POI").asText());
                    JPA.em().persist(f);
                }
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
    public Result getAllFacilities() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select * from facilities d where 1=1 ";

                String type = json.findPath("type").asText();
                String districtCode = json.findPath("num_district_code").asText();
                String provinceCode = json.findPath("num_province_code").asText();
                String nameFilter = json.findPath("nameFilter").asText();

                if(provinceCode!=null && !provinceCode.equalsIgnoreCase("")){
                    query+=" and d.province_code="+provinceCode;
                }
                if(districtCode!=null && !districtCode.equalsIgnoreCase("")){
                    query+=" and d.district_code="+districtCode;

                }

                if(nameFilter!=null && !nameFilter.equalsIgnoreCase("")){
                    query+=" and d.label like '%"+nameFilter+"%'";
                }

                if(type!=null && !type.equalsIgnoreCase("") && !type.equalsIgnoreCase("Both") ){
                    query+=" and d.poi_type ="+"'"+type+"'";
                }

                System.out.println(query);

                Query q = JPA.em().createNativeQuery(query, FacilitiesEntity.class);
                List<FacilitiesEntity> distList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (FacilitiesEntity d: distList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("id", d.getId());
                    roadObject.put("districtCode", d.getDistrictCode());
                    roadObject.put("districtName", d.getDistrictName());
                    roadObject.put("provinceCode", d.getProvinceCode());
                    roadObject.put("provinceName", d.getProvinceName());
                    roadObject.put("label", d.getLabel());
                    roadObject.put("fromSource", d.getFromSource());
                    roadObject.put("type", d.getPoiType());
                    roadObject.put("east", d.getEast());
                    roadObject.put("north", d.getNorth());
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