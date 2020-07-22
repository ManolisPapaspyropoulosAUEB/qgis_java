package controllers;

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
import javax.xml.transform.Source;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;
public class RoadController {



    private static DecimalFormat df2 = new DecimalFormat("#.##");


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getAllFromRoads() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select * from roads r where 1=1 ";
                String districtId = json.findPath("district_id").asText();
                String fclass = json.findPath("fclass").asText();
                String nameFilter = json.findPath("nameFilter").asText();
                String sqlInFclass = json.findPath("sqlInFclass").asText();
                String oneway = json.findPath("oneway").asText();
                String maxSpeedFilter = json.findPath("maxSpeedFilter").asText();
                String bridgeFilter = json.findPath("bridgeFilter").asText();
                String agriculturFacilitationFilter = json.findPath("agriculturFacilitationFilter").asText();
                String sqlInRoadConditions = json.findPath("sqlInRoadConditions").asText();
                if (districtId != null && districtId != "") {
                    query += "and r.district_id = " + districtId;
                }
                if (fclass != null && fclass != "") {
                    query += " and r.fclass = " + fclass + "'";
                }
                if (nameFilter != null && nameFilter != "") {
                    query += " and r.name like '%" + nameFilter + "%'";
                }
                if ((!sqlInFclass.isEmpty()) && !sqlInFclass.equalsIgnoreCase("()")) {
                    query += " and r.fclass IN " + sqlInFclass;
                }
                if ((!oneway.isEmpty()) && !oneway.equalsIgnoreCase("FB")) {
                    query += " and r.oneway = '" + oneway + "'";
                }
                if ((!maxSpeedFilter.isEmpty()) && maxSpeedFilter != "") {
                    query += " and r.maxspeed = " + maxSpeedFilter;
                }
                if ((!bridgeFilter.isEmpty()) && !bridgeFilter.equalsIgnoreCase("TF")) {
                    query += " and r.bridge = '" + bridgeFilter + "'";
                }
                if ((!agriculturFacilitationFilter.isEmpty()) && !agriculturFacilitationFilter.equalsIgnoreCase("TF")) {
                    query += " and r.agriculture_facilitation = '" + agriculturFacilitationFilter + "'";
                }
                if ((!sqlInRoadConditions.isEmpty()) && !sqlInRoadConditions .equalsIgnoreCase("()")) {
                    query += " and r.road_condition in " + sqlInRoadConditions ;
                }
                System.out.println(query);
                Query q = JPA.em().createNativeQuery(query, RoadsEntity.class);
                List<RoadsEntity> roadsList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (RoadsEntity roads : roadsList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("id", roads.getId());
                    roadObject.put("agriculturalFacilities", roads.getAgriculturalFacilities());
                    roadObject.put("commentsOnConnections", roads.getCommentsOnConnections());
                    roadObject.put("osmId", roads.getOsmId());
                    roadObject.put("osm_id", roads.getOsmId());
                    roadObject.put("code", roads.getCode());
                    roadObject.put("checked", false);

                    roadObject.put("fclass", roads.getFclass());
                    roadObject.put("name", roads.getName());
                    roadObject.put("ref", roads.getRef());
                    roadObject.put("oneway", roads.getOneway());
                    roadObject.put("maxspeed", roads.getMaxspeed());
                    roadObject.put("layer", roads.getLayer());
                    roadObject.put("bridge", roads.getBridge());

                    if(roads.getBridge()!=null){
                        if(roads.getBridge().equalsIgnoreCase("T")){
                            roadObject.put("bridgeMat",true);
                        }else{
                            roadObject.put("bridgeMat", false);

                        }
                    }else{
                        roadObject.put("bridgeMat", false);
                    }
                    roadObject.put("tunnel", roads.getTunnel());
                    if(roads.getTunnel()!=null){
                        if(roads.getTunnel().equalsIgnoreCase("T")){
                            roadObject.put("tunnelMat",true);
                        }else{
                            roadObject.put("tunnelMat", false);
                        }
                    }else{
                        roadObject.put("tunnelMat", false);

                    }
                    roadObject.put("district", roads.getDistrict());
                    roadObject.put("source", roads.getSource());
                    roadObject.put("roadWidthInM", roads.getRoadWidthInM());
                    roadObject.put("roadCondition", roads.getRoadCondition());
                    roadObject.put("maxRoadSteepnessPrc", roads.getMaxRoadSteepnessPrc());
                    roadObject.put("roadsideEnvironment", roads.getRoadsideEnvironment());
                    roadObject.put("agricultureFacilitation", roads.getAgricultureFacilitation());
                    roadObject.put("agricultureFacilitaties", roads.getAgriculturalFacilities().toString());
                    roadObject.put("lengthOfRoadStretchInM", roads.getLengthOfRoadStretchInM());
                    roadObject.put("averageElevationInMAboveSealevel", roads.getAverageElevationInMAboveSealevel());
                    roadObject.put("elevationInMetres", roads.getElevationInMetres());
                    roadObject.put("averagePopulationInPersons", roads.getAveragePopulationInPersons());
                    roadObject.put("LVRR_ID", roads.getLvrrId().toString());
                    roadObject.put("security", roads.getSecurity());
                    roadObject.put("environmentalImpacts", roads.getEnvironmentalImpacts());
                    roadObject.put("districtId", roads.getDistrictId());
                    roadObject.put("districtCode", roads.getDistrictId());
                    roadObject.put("lengthInMetres", roads.getLengthInMetres());
                    roadObject.put("populationServed", roads.getPopulationServed());
                    roadObject.put("facilitiesServed", roads.getFacilitiesServed());
                    roadObject.put("accessToGCsRMs", roads.getAccessToGCsRMs());
                    roadObject.put("farmToTheMarket", roads.getFarmToTheMarket().toString());
                    roadObject.put("agriculturalFacilities", roads.getAgriculturalFacilities());
                    roadObject.put("linksToMajorActivityCentres", roads.getLinksToMajorActivityCentres().toString());
                    roadObject.put("numberOfConnections", roads.getNumberOfConnections());
                    roadObject.put("c1Id", roads.getC1Id());
                    roadObject.put("c1Score", roads.getC1Score());
                    roadObject.put("c2Id", roads.getC2Id());
                    roadObject.put("c2Score", roads.getC2Score());
                    roadObject.put("c3Id", roads.getC3Id());
                    roadObject.put("c3Score", roads.getC3Score());
                    roadObject.put("c4Id", roads.getC4Id());
                    roadObject.put("c4Score", roads.getC4Score());
                    roadObject.put("c5Id", roads.getC5Id());
                    roadObject.put("c5Score", roads.getC5Score());
                    roadObject.put("c6Id", roads.getC6Id());
                    roadObject.put("c6Score", roads.getC6Score());
                    roadObject.put("c7Id", roads.getC7Id());
                    roadObject.put("c7Score", roads.getC7Score());
                    roadObject.put("c8Id", roads.getC8Id());
                    roadObject.put("c8Score", roads.getC8Score());
                    roadObject.put("c9Id", roads.getC9Id());
                    roadObject.put("c9Score", roads.getC9Score());
                    roadObject.put("c10Id", roads.getC10Id());
                    roadObject.put("c10Score", roads.getC10Score());
                    roadObject.put("c11Id", roads.getC11Id());
                    roadObject.put("c11Score", roads.getC11Score());
                    roadObject.put("c12Id", roads.getC12Id());
                    roadObject.put("c12Score", roads.getC12Score());
                    roadObject.put("c13Id", roads.getC13Id());
                    roadObject.put("c13Score", roads.getC13Score());
                    roadObject.put("c14Id", roads.getC14Id());
                    roadObject.put("c14Score", roads.getC14Score());
                    roadObject.put("c15Id", roads.getC15Id());
                    roadObject.put("c15Score", roads.getC15Score());
                    roadObject.put("mca", roads.getMca());
                    roadObject.put("cbi", roads.getCbi());
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

    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result resetCriteria() {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String sqlR="select * from roads ";
                List<RoadsEntity> roadsList = JPA.em().createNativeQuery(sqlR,RoadsEntity.class).getResultList();
                for(RoadsEntity road : roadsList){
                    road.setC1Id(0);
                    road.setC1Score(0.0);

                    road.setC2Id(0);
                    road.setC2Score(0.0);

                    road.setC3Id(0);
                    road.setC3Score(0.0);

                    road.setC4Id(0);
                    road.setC4Score(0.0);

                    road.setC5Id(0);
                    road.setC5Score(0.0);

                    road.setC6Id(0);
                    road.setC6Score(0.0);

                    road.setC7Id(0);
                    road.setC7Score(0.0);

                    road.setC8Id(0);
                    road.setC8Score(0.0);

                    road.setC9Id(0);
                    road.setC9Score(0.0);

                    road.setC10Id(0);
                    road.setC10Score(0.0);

                    road.setC11Id(0);
                    road.setC11Score(0.0);

                    road.setC12Id(0);
                    road.setC12Score(0.0);

                    road.setC13Id(0);
                    road.setC13Score(0.0);

                    road.setC14Id(0);
                    road.setC14Score(0.0);

                    road.setC15Id(0);
                    road.setC15Score(0.0);

                    road.setMca(0.0);
                    road.setCbi(0.0);
                }
                result.put("status", "ok");
                result.put("message", "success");
                return ok(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", "Πρόβλημα κατά την διαγραφή .");
            return ok(result);
        }
    }




    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result calculateCriteria() {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String district_id = json.findPath("district_id").asText();
                String lvrr_id = json.findPath("lvrr_id").asText();

                if (district_id.isEmpty() || district_id.equalsIgnoreCase("0")) {
                    result.put("status", "error");
                    result.put("message", "Ανεπιτυχής Διαδικασία.");
                    return ok(result);
                } else {
                    String criteriaMasterSql = "select cm.* FROM criteria_master cm";
                    List<CriteriaMasterEntity> cmList = JPA.em().createNativeQuery(criteriaMasterSql, CriteriaMasterEntity.class).getResultList();

                    String roadsSql = "select * from roads r where 1=1";

                    if (!district_id.isEmpty()) {
                        roadsSql += " and r.district_id=" + district_id;
                    }
                    System.out.println("lvrr_id "+lvrr_id);
                    if (!lvrr_id.isEmpty()) {
                        roadsSql += " and r.lvrr_id=" + lvrr_id;
                    }
                    if (!district_id.isEmpty()) {
                        List<RoadsEntity> roadsList = JPA.em().createNativeQuery(roadsSql, RoadsEntity.class).getResultList();
                        for (RoadsEntity road : roadsList) {
                            Double mca =0.0;
                            String opParamSql = "select * from operetional_parameters op ";
                            List<OperetionalParametersEntity> opList = JPA.em().createNativeQuery(opParamSql,OperetionalParametersEntity.class).getResultList();
                            Double opParam = opList.get(0).getEstimatedMaintenanceCost();
                            Double cbi = 0.0;
                            if(road.getPopulationServed()>0 && road.getLengthInMetres() >0){
                                cbi = (opParam/road.getLengthInMetres())/road.getPopulationServed();
                            }

                            if(cbi > 0){
                                BigDecimal finalCbi = new BigDecimal(cbi).setScale(2, RoundingMode.HALF_UP);
                                System.out.println(df2.format(cbi));
                                //System.out.println(cbi.doubleValue());
                                //double finalCbi  = Double.parseDouble((df2.format(cbi)));
                                System.out.println(finalCbi);
                                road.setCbi(finalCbi.doubleValue());//  value =Double.parseDouble(new DecimalFormat("##.####").format(value));
                            }else{
                                road.setCbi(new Double(0));
                            }



                            for(CriteriaMasterEntity cm : cmList){
                                if(cm.getId()==1){
                                    Integer weightFactor = 1;
                                    if(cm.getCalculateIndicator()==1){

                                        if(road.getPopulationServed()==0){
                                            road.setC1Score(0.0);
                                            road.setC1Id(1);
                                        }
                                        if(road.getPopulationServed()>0 && road.getPopulationServed()<999){
                                            road.setC1Score(Double.valueOf(4*weightFactor));
                                            road.setC1Id(2);
                                        }
                                        if(road.getPopulationServed()>1000 && road.getPopulationServed()<1999){
                                            road.setC1Score(Double.valueOf(8*weightFactor));
                                            road.setC1Id(3);
                                        }
                                        if(road.getPopulationServed()>2000 && road.getPopulationServed()<2999){
                                            road.setC1Score(Double.valueOf(12*weightFactor));
                                            road.setC1Id(4);
                                        }
                                        if(road.getPopulationServed()>3000){
                                            road.setC1Score(Double.valueOf(15*weightFactor));
                                            road.setC1Id(5);
                                        }
                                    }
                                    mca+=road.getC1Score();
                                }
                                if(cm.getId()==2){
                                    Integer weightFactor = 1;
                                    if(cm.getCalculateIndicator()==1){
                                        if(road.getFacilitiesServed()==0){
                                            road.setC2Score(0.0);
                                            road.setC2Id(10);
                                        }
                                        if(road.getFacilitiesServed()>=1 && road.getFacilitiesServed()<=9){
                                            road.setC2Score(road.getFacilitiesServed().doubleValue());
                                            road.setC2Id((int) (10+road.getFacilitiesServed()));
                                        }
                                        if(road.getFacilitiesServed()>=10){
                                            road.setC2Score(10.0);
                                            road.setC2Id(20);
                                        }
                                    }
                                    mca+=road.getC2Score()*weightFactor;
                                }
                                if(cm.getId()==3){
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score="+road.getAccessToGCsRMs()+" and cmd.criteria_master_id=3";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail,CriteriaMasterDetailsEntity.class).getResultList();
                                    if(cmdList.size()>0) {
                                        road.setC3Id(cmdList.get(0).getId());
                                        road.setC3Score(road.getAccessToGCsRMs());
                                        mca+=road.getC3Score()*weightFactor;
                                    }else{
                                        road.setC3Id(0);
                                        road.setC3Score(0.0);
                                    }
                                }
                                if(cm.getId()==4){
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score="+road.getFarmToTheMarket()+" and cmd.criteria_master_id=4";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail,CriteriaMasterDetailsEntity.class).getResultList();
                                    if(cmdList.size()>0){

                                        road.setC4Id(cmdList.get(0).getId());
                                        road.setC4Score(road.getFarmToTheMarket());
                                        mca+=road.getC4Score()*weightFactor;
                                    }else{
                                        road.setC4Id(0);
                                        road.setC4Score(0.0);
                                    }
                                }

                                if(cm.getId()==5){
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score="+road.getAgriculturalFacilities()+" and cmd.criteria_master_id=5";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail,CriteriaMasterDetailsEntity.class).getResultList();

                                    if(cmdList.size()>0){
                                        road.setC5Id(cmdList.get(0).getId());
                                        road.setC5Score(road.getAgriculturalFacilities());
                                        mca+=road.getC5Score()*weightFactor;
                                    }else{
                                        road.setC5Id(0);
                                        road.setC5Score(0.0);
                                    }
                                }
                                if(cm.getId()==6){
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score="+road.getLinksToMajorActivityCentres()+" and cmd.criteria_master_id=6";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail,CriteriaMasterDetailsEntity.class).getResultList();
                                    if(cmdList.size()>0){
                                        road.setC6Id(cmdList.get(0).getId());
                                        road.setC6Score(road.getLinksToMajorActivityCentres());
                                        mca+=road.getC6Score()*weightFactor;
                                    }else{
                                        road.setC6Id(0);
                                        road.setC6Score(0.0);
                                    }
                                }
                                if(cm.getId()==7){
                                    road.setC7Score(0.0);
                                    road.setC7Id(0);
                                    mca+=road.getC7Score();
                                }
                                if(cm.getId()==8){
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score="+road.getNumberOfConnections()+" and cmd.criteria_master_id=8";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail,CriteriaMasterDetailsEntity.class).getResultList();
                                    if(cmdList.size()>0){
                                        road.setC8Id(cmdList.get(0).getId());
                                        road.setC8Score(road.getNumberOfConnections());
                                        mca+=road.getC8Score()*weightFactor;
                                    }else{
                                        road.setC8Id(0);
                                        road.setC8Score(0.0);
                                    }
                                }
                                if(cm.getId()==9){
                                    road.setC9Score(0.0);

                                    road.setC9Id(0);
                                    mca+=road.getC9Score();
                                }
                                if(cm.getId()==10){
                                    road.setC10Score(0.0);
                                    road.setC10Id(0);
                                    mca+=road.getC10Score();
                                }
                                if(cm.getId()==11){
                                    road.setC11Score(0.0);
                                    road.setC11Id(0);
                                    mca+=road.getC11Score();
                                }
                                if(cm.getId()==12){
                                    road.setC12Score(0.0);
                                    road.setC12Id(0);
                                    mca+=road.getC12Score();
                                }
                                if(cm.getId()==13){
                                    road.setC13Score(0.0);
                                    road.setC13Id(0);
                                    mca+=road.getC13Score();
                                }
                                if(cm.getId()==14){
                                    road.setC14Score(0.0);
                                    road.setC14Id(0);
                                    mca+=road.getC14Score();
                                }
                                if(cm.getId()==15){
                                    road.setC15Score(0.0);
                                    road.setC15Id(0);
                                    mca+=road.getC15Score();
                                }
                            }
                            road.setMca(mca);
                            JPA.em().merge(road);
                        }
                    }
                    result.put("status", "ok");
                    result.put("message", "Update success");
                    return ok(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
            result.put("message", "Not selected District");
            return ok(result);
        }
    }


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result updateRoad() {
        try {
            JsonNode json = Http.Context.Implicit.request().body().asJson();
            ObjectNode result = Json.newObject();
            if (json.findPath("id") == null) {
                return badRequest("Expecting Json data");
            } else {

                Double accessToGCsRMs = json.findPath("accessToGCsRMs").asDouble();




                Double agricultureFacilitaties = json.findPath("agricultureFacilitaties").asDouble();
                boolean bridgeMat = json.findPath("bridgeMat").asBoolean();
                Integer elevationInMetres = json.findPath("elevationInMetres").asInt();
                Integer facilitiesServed = json.findPath("facilitiesServed").asInt();
                Double farmToTheMarket = json.findPath("farmToTheMarket").asDouble();



                String fclass = json.findPath("fclass").asText();

                String layer = json.findPath("layer").asText();
                Integer lengthInMetres = json.findPath("lengthInMetres").asInt();
                Double linksToMajorActivityCentres = json.findPath("linksToMajorActivityCentres").asDouble();
                String maxspeed = json.findPath("maxspeed").asText();
                String name = json.findPath("name").asText();
                Double numberOfConnections = json.findPath("numberOfConnections").asDouble();

                String oneway = json.findPath("oneway").asText();
                Integer populationServed = json.findPath("populationServed").asInt();
                String ref = json.findPath("ref").asText();
                String roadCondition = json.findPath("roadCondition").asText();
                String source = json.findPath("source").asText();
                boolean tunnelMat = json.findPath("tunnelMat").asBoolean();

                RoadsEntity road = JPA.em().find(RoadsEntity.class,json.findPath("id").asInt());
                road.setFarmToTheMarket(farmToTheMarket);

                road.setAccessToGCsRMs(accessToGCsRMs);
                road.setAgriculturalFacilities(agricultureFacilitaties);
                if(bridgeMat){
                    road.setBridge("T");
                }else{
                    road.setBridge("F");
                }
                road.setElevationInMetres(elevationInMetres);
                road.setFacilitiesServed(facilitiesServed.doubleValue());
                road.setFclass(fclass);
                road.setLayer(layer);
                road.setLengthInMetres(lengthInMetres);
                road.setLinksToMajorActivityCentres(linksToMajorActivityCentres);
                road.setMaxspeed(maxspeed);
                road.setName(name);
                road.setNumberOfConnections(numberOfConnections);
                road.setOneway(oneway);
                road.setPopulationServed(populationServed.doubleValue());
                road.setRef(ref);
                road.setSource(source);
                road.setRoadCondition(roadCondition);
                if(tunnelMat){
                    road.setTunnel("T");
                }else{
                    road.setTunnel("F");
                }

                JPA.em().merge(road);
                result.put("status", "ok");
                result.put("lvrr_id", road.getLvrrId());
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
