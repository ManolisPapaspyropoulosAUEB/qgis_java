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
                    itC = facilitie.findPath("coordinates").iterator();
                    String east =  itC.next().toString();
                    String north =  itC.next().toString();
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