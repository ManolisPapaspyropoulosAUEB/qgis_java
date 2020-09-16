package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jdk.nashorn.internal.parser.JSONParser;
import models.*;
import org.cloudinary.json.JSONObject;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import scala.util.parsing.json.JSON;

import javax.persistence.Query;
import javax.xml.transform.Source;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

public class RoadController {


    private static DecimalFormat df2 = new DecimalFormat("#.##");

    //


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getRoadsForExporter() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select r from RoadsEntity r where 1=1 ";
                String districtId = json.findPath("district_id").asText();
                String fclass = json.findPath("fclass").asText();
                String orderCol = json.findPath("orderCol").asText();
                String descAsc = json.findPath("descAsc").asText();
                //result
                Integer resultParam = json.findPath("result").asInt();
                String nameFilter = json.findPath("nameFilter").asText();
                String sqlInFclass = json.findPath("sqlInFclass").asText();
                String oneway = json.findPath("oneway").asText();
                String maxSpeedFilter = json.findPath("maxSpeedFilter").asText();
                String bridgeFilter = json.findPath("bridgeFilter").asText();
                String agriculturFacilitationFilter = json.findPath("agriculturFacilitationFilter").asText();
                String sqlInRoadConditions = json.findPath("sqlInRoadConditions").asText();
                if (districtId != null && districtId != "") {
                    query += "and r.districtId = " + districtId;
                }
                if (fclass != null && fclass != "") {
                    query += " and r.fclass = " + fclass + "'";
                }
                if (nameFilter != null && nameFilter != "") {
                    query += " and ( r.name like '%" + nameFilter + "%'  or r.lvrrId like '%" + nameFilter + "%' )";
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
                    query += " and r.agricultureFacilitation = '" + agriculturFacilitationFilter + "'";
                }
                if ((!sqlInRoadConditions.isEmpty()) && !sqlInRoadConditions.equalsIgnoreCase("()")) {
                    query += " and r.roadCondition in " + sqlInRoadConditions;
                }

                if (orderCol.equalsIgnoreCase("mca")) {
                    query += " order by mca " + descAsc ;
                } else if (orderCol != null && !orderCol.equalsIgnoreCase("")) {
                    query += " order by  " + orderCol + " " + descAsc;
                }
                Query q = JPA.em().createQuery(query, RoadsEntity.class);
                System.out.println(resultParam);
                if (resultParam == 5
                        || resultParam == 10
                        || resultParam == 20
                        || resultParam == 30
                        || resultParam == 50) {
                    q.setMaxResults(resultParam);
                }
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
                    roadObject.put("checked", false);
                    roadObject.put("osmId", roads.getOsmId());
                    roadObject.put("osm_id", roads.getOsmId());
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("code", roads.getCode());
                    } else {
                        roadObject.put("code", "-");
                    }
                    roadObject.put("checked", false);


                    roadObject.put("linksToMajorActivityCentres", roads.getAccessToGCsRMs()+roads.getFacilitiesServed());
                    roadObject.put("connectivity", roads.getConnectivity());


                    roadObject.put("fclass", roads.getFclass());
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("name", roads.getName());
                    } else {
                        roadObject.put("name", "-");
                    }
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("ref", roads.getRef());
                    } else {
                        roadObject.put("ref", "-");
                    }
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("oneway", roads.getOneway());
                    } else {
                        roadObject.put("oneway", "-");
                    }
                    roadObject.put("maxspeed", roads.getMaxspeed());
                    roadObject.put("layer", roads.getLayer());
                    roadObject.put("bridge", roads.getBridge());
                    if (roads.getBridge() != null) {
                        if (roads.getBridge().equalsIgnoreCase("T")) {
                            roadObject.put("bridgeMat", true);
                        } else {
                            roadObject.put("bridgeMat", false);
                        }
                    } else {
                        roadObject.put("bridgeMat", false);
                    }
                    roadObject.put("tunnel", roads.getTunnel());
                    if (roads.getTunnel() != null) {
                        if (roads.getTunnel().equalsIgnoreCase("T")) {
                            roadObject.put("tunnelMat", true);
                        } else {
                            roadObject.put("tunnelMat", false);
                        }
                    } else {
                        roadObject.put("tunnelMat", false);
                    }
                    roadObject.put("district", roads.getDistrict());
                    roadObject.put("source", roads.getSource());
                    roadObject.put("roadWidthInM", roads.getRoadWidthInM());
                    roadObject.put("roadCondition", roads.getRoadCondition());
                    roadObject.put("maxRoadSteepnessPrc", roads.getMaxRoadSteepnessPrc());
                    if (roads.getRoadsideEnvironment() == null) {
                        roadObject.put("roadsideEnvironment", "-");
                    } else {
                        roadObject.put("roadsideEnvironment", roads.getRoadsideEnvironment());
                    }
                    roadObject.put("agricultureFacilitation", roads.getAgricultureFacilitation());
                    roadObject.put("agricultureFacilitaties", roads.getAgriculturalFacilities().toString());
                    roadObject.put("lengthOfRoadStretchInM", roads.getLengthOfRoadStretchInM());
                    roadObject.put("averageElevationInMAboveSealevel", roads.getAverageElevationInMAboveSealevel());
                    roadObject.put("elevationInMetres", roads.getElevationInMetres());
                    roadObject.put("averagePopulationInPersons", roads.getAveragePopulationInPersons());
                    roadObject.put("LVRR_ID", roads.getLvrrId().toString());
                    roadObject.put("security", roads.getSecurity().toString());
                    roadObject.put("environmentalImpacts", roads.getEnvironmentalImpacts().toString());
                    roadObject.put("districtId", roads.getDistrictId());
                    roadObject.put("districtCode", roads.getDistrictId());
                    roadObject.put("lengthInMetres", roads.getLengthInMetres());
                    roadObject.put("populationServed", roads.getPopulationServed());
                    roadObject.put("facilitiesServed", roads.getFacilitiesServed());
                    roadObject.put("accessToGCsRMs", roads.getAccessToGCsRMs());
                    roadObject.put("farmToTheMarket", roads.getFarmToTheMarket().toString());
                    roadObject.put("linksToMajorActivityCentres", roads.getLinksToMajorActivityCentres());
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
                    roadObject.put("mcaTypos", roads.getC1Score() + "(c1)"
                            + roads.getC1Score() + "(c1)"
                            + roads.getC2Score() + "(c2)"
                            + roads.getC3Score() + "(c3)"
                            + roads.getC4Score() + "(c4)"
                            + roads.getC5Score() + "(c5)"
                            + roads.getC6Score() + "(c6)"
                            + roads.getC7Score() + "(c7)"
                            + roads.getC8Score() + "(c8)"
                            + roads.getC9Score() + "(c9)"
                            + roads.getC10Score() + "(c10)"
                            + roads.getC11Score() + "(c11)"
                            + roads.getC12Score() + "(c12)"
                            + roads.getC13Score() + "(c13)"
                            + roads.getC14Score() + "(c14)"
                            + roads.getC15Score() + "(c15)"
                    );
                    String opParamSql = "select * from operetional_parameters op ";
                    List<OperetionalParametersEntity> opList = JPA.em().createNativeQuery(opParamSql, OperetionalParametersEntity.class).getResultList();
                    roadObject.put("cbiRoutine", roads.getCbi2());
                    roadObject.put("cbiPeriodic", roads.getCbi1());
                    roadObject.put("mca", roads.getMca());
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
                String orderCol = json.findPath("orderCol").asText();
                String descAsc = json.findPath("descAsc").asText();
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
                    query += " and ( r.name like '%" + nameFilter + "%'  or r.LVRR_ID like '%" + nameFilter + "%' )";
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
                if ((!sqlInRoadConditions.isEmpty()) && !sqlInRoadConditions.equalsIgnoreCase("()")) {
                    query += " and r.road_condition in " + sqlInRoadConditions;
                }
                if (orderCol != null && !orderCol.equalsIgnoreCase("")) {
                    query += " order by mca " +" "+ descAsc;
                }
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
                    roadObject.put("agriculturalFacilities", roads.getAgriculturalFacilities().toString());
                    roadObject.put("commentsOnConnections", roads.getCommentsOnConnections());
                    roadObject.put("checked", false);
                    roadObject.put("osmId", roads.getOsmId());
                    roadObject.put("osm_id", roads.getOsmId());
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("code", roads.getCode());
                    } else {
                        roadObject.put("code", "-");
                    }
                    roadObject.put("checked", false);
                    roadObject.put("fclass", roads.getFclass());
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("name", roads.getName());

                    } else {
                        roadObject.put("name", "-");

                    }
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("ref", roads.getRef());

                    } else {
                        roadObject.put("ref", "-");

                    }

                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("oneway", roads.getOneway());

                    } else {
                        roadObject.put("oneway", "-");

                    }
                    roadObject.put("maxspeed", roads.getMaxspeed());
                    roadObject.put("layer", roads.getLayer());
                    roadObject.put("bridge", roads.getBridge());

                    if (roads.getBridge() != null) {
                        if (roads.getBridge().equalsIgnoreCase("T")) {
                            roadObject.put("bridgeMat", true);
                        } else {
                            roadObject.put("bridgeMat", false);

                        }
                    } else {
                        roadObject.put("bridgeMat", false);
                    }
                    roadObject.put("tunnel", roads.getTunnel());
                    if (roads.getTunnel() != null) {
                        if (roads.getTunnel().equalsIgnoreCase("T")) {
                            roadObject.put("tunnelMat", true);
                        } else {
                            roadObject.put("tunnelMat", false);
                        }
                    } else {
                        roadObject.put("tunnelMat", false);
                    }
                    roadObject.put("district", roads.getDistrict());
                    roadObject.put("source", roads.getSource());
                    roadObject.put("roadWidthInM", roads.getRoadWidthInM());
                    roadObject.put("roadCondition", roads.getRoadCondition());
                    roadObject.put("maxRoadSteepnessPrc", roads.getMaxRoadSteepnessPrc());
                    if (roads.getRoadsideEnvironment() == null) {
                        roadObject.put("roadsideEnvironment", "-");
                    } else {
                        roadObject.put("roadsideEnvironment", roads.getRoadsideEnvironment());
                    }
                    roadObject.put("lengthOfRoadStretchInM", roads.getLengthOfRoadStretchInM());
                    roadObject.put("averageElevationInMAboveSealevel", roads.getAverageElevationInMAboveSealevel());
                    roadObject.put("elevationInMetres", roads.getElevationInMetres());
                    roadObject.put("averagePopulationInPersons", roads.getAveragePopulationInPersons());
                    roadObject.put("LVRR_ID", roads.getLvrrId().toString());
                    roadObject.put("districtId", roads.getDistrictId());
                    roadObject.put("districtCode", roads.getDistrictId());
                    roadObject.put("lengthInMetres", roads.getLengthInMetres());
//criteria//
                    roadObject.put("populationServed", roads.getPopulationServed());
                    roadObject.put("checked", false);
                    roadObject.put("roadConditionCriterio", roads.getRoadConditionCriterio().toString());
                    roadObject.put("roadQualityAndNeeds", roads.getRoadQualityAndNeeds().toString());
                    roadObject.put("checkedFilter",false);
                    roadObject.put("facilitiesServed", roads.getFacilitiesServed());
                    roadObject.put("accessToGCsRMs", roads.getAccessToGCsRMs());
                    roadObject.put("farmToTheMarket", roads.getFarmToTheMarket().toString());
                    roadObject.put("agricultureFacilitation", roads.getAgricultureFacilitation());
                    roadObject.put("linksToMajorActivityCentres", roads.getAccessToGCsRMs()+roads.getFacilitiesServed());
                    roadObject.put("connectivity", roads.getConnectivity());
                    roadObject.put("roadAccessibility", roads.getRoadAccessibility().toString());
                    roadObject.put("numberOfConnections", roads.getNumberOfConnections());
                    roadObject.put("roadCondition", roads.getRoadCondition());
                    roadObject.put("roadQualityAndNeeds", roads.getRoadQualityAndNeeds().toString());
                    roadObject.put("requirementsForEarthWorks", roads.getRequirementsForEarthWorks().toString());
                    roadObject.put("trafficVolume", roads.getTrafficVolume().toString());
                    roadObject.put("safety", roads.getSafety().toString());
                    roadObject.put("safetyLabel", roads.getSafety().toString());



                    if(roads.getSafety()==5){
                        roadObject.put("safetyLabel","Very bad safety history/potential (road is very frequently connected to injuries and fatalities) – more than 10 road accidents with people killed");
                    }else if(roads.getSafety()==4){
                        roadObject.put("safetyLabel", "Bad safety history/potential (road is frequently connected to injuries and fatalities) – up to 10 road accidents with people killed and seriously injured\t");
                    }else if(roads.getSafety()==3){
                        roadObject.put("safetyLabel", "Average safety history/potential – 5 to 10 road accidents with people killed and/or seriously injured");
                    }else if(roads.getSafety()==2 ){
                        roadObject.put("safetyLabel","Good safety history/potential (road is not frequently connected to injuries and fatalities) - less than 5 road accidents – with people injured or serious injured, no deaths");
                    }else if(roads.getSafety()==1){
                        roadObject.put("safetyLabel", "Excellent safety history/potential (injuries and fatalities are very rare) – less than 5 accidents per year and light injuries");
                    }else if(roads.getSafety()==0){
                        roadObject.put("safetyLabel", "Perfect safety history/potential (no injuries and fatalities have been recorded)");
                    }


                    roadObject.put("security", roads.getSecurity());
                    roadObject.put("environmentalImpacts", roads.getEnvironmentalImpacts().toString());

                    if(roads.getEnvironmentalImpacts()==5){
                        roadObject.put("environmentalImpactsLabel","Extremely adverse environmental impacts (road use activities result in extremely harmful effects on the environment and/or on cultural heritage preservation areas. Traffic diversion, control and calming measures must be taken immediately)");
                    }else if(roads.getEnvironmentalImpacts()==4){
                        roadObject.put("environmentalImpactsLabel", "Serious adverse environmental impacts (road use activities result in seriously harmful effects on the environment and/or on cultural heritage preservation areas. There is an urgent need to take traffic control and calming measures)");
                    }else if(roads.getEnvironmentalImpacts()==5){
                        roadObject.put("environmentalImpactsLabel", "Average environmental impacts (road use activities to be seriously assessed as to the harmful effects on the environment and/or on cultural heritage preservation areas)");
                    }else if(roads.getEnvironmentalImpacts()==2 ){
                        roadObject.put("environmentalImpactsLabel","Few adverse environmental impacts (road use activities result in limited harmful effects on the environment and/or on cultural heritage preservation areas.)");
                    }else if(roads.getEnvironmentalImpacts()==1){
                        roadObject.put("environmentalImpactsLabel", "Limited adverse environmental impacts (road use activities result to very limited harmful effects on the environment and/or on cultural heritage preservation areas.)");
                    }else if(roads.getEnvironmentalImpacts()==0){
                        roadObject.put("environmentalImpactsLabel", "Perfect- No negative environmental impacts");
                    }



//end of criteria//
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
                    String notes = "select * from notes n where n.road_id=" + roads.getId();
                    List<NotesEntity> notesList = JPA.em().createNativeQuery(notes, NotesEntity.class).getResultList();
                    if (notesList.size() > 0) {
                        roadObject.put("notesSize", notesList.size());
                    } else {
                        roadObject.put("notesSize", 0);
                    }
                    String uploads = "select * from documents d where d.road_id=" + roads.getId();
                    List<DocumentsEntity> docList = JPA.em().createNativeQuery(uploads, DocumentsEntity.class).getResultList();

                    if (docList.size() > 0) {
                        roadObject.put("docSize", docList.size());
                    } else {
                        roadObject.put("docSize", 0);
                    }
                    roadObject.put("mcaTypos",
                            roads.getC1Score() + "(c1)+"
                                    + roads.getC2Score()  + "(c2)+"
                                    + roads.getC3Score()  + "(c3)+"
                                    + roads.getC4Score()  + "(c4)+"
                                    + roads.getC5Score()  + "(c5)+"
                                    + roads.getC6Score()  + "(c6)+" + "\n" +
                                    + roads.getC7Score()  + "(c7)+"
                                    + roads.getC8Score()  + "(c8)+"
                                    + roads.getC9Score()  + "(c9)+"
                                    + roads.getC10Score() + "(c10)+" + "\n" +
                                    + roads.getC11Score() + "(c11)+"
                                    + roads.getC12Score() + "(c12)+"
                                    + roads.getC13Score() + "(c13)+"
                                    + roads.getC14Score() + "(c14)+"
                                    + roads.getC15Score() + "(c15)"
                    );

                    String opParamSql = "select * from operetional_parameters op ";
                    List<OperetionalParametersEntity> opList = JPA.em().createNativeQuery(opParamSql, OperetionalParametersEntity.class).getResultList();

                    roadObject.put("CBI1_ROUTINE_TYPOS", "(" +opList.get(0).getEstimatedRoutineMaintenanceCost()  +"*" +"(" + roads.getLengthInMetres()/1000.00+"))"+"/"+roads.getPopulationServed()   );
                    roadObject.put("CBI2_PERIODIC_TYPOS", "(" +opList.get(0).getEstimatedPeriodicMaintenanceCost()  +"*" +"(" + roads.getLengthInMetres()/1000.00+"))"+"/"+roads.getPopulationServed()   );


                    roadObject.put("mca", roads.getMca());
                    roadObject.put("cbiRoutine", roads.getCbi2());
                    roadObject.put("cbiPeriodic", roads.getCbi1());
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
                String sqlR = "select * from roads ";
                List<RoadsEntity> roadsList = JPA.em().createNativeQuery(sqlR, RoadsEntity.class).getResultList();
                for (RoadsEntity road : roadsList) {
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
                    road.setCbi1(0.0);
                    road.setCbi2(0.0);
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
    public Result getAllFromRoadsHistory() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select * from roads_revisions r where 1=1 ";
                Integer snapId = json.findPath("id").asInt();
                query += " and r.snapshot_id=" + snapId;
                Query q = JPA.em().createNativeQuery(query, RoadsRevisionsEntity.class);
                List<RoadsRevisionsEntity> roadsList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (RoadsRevisionsEntity roads : roadsList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("road_id", roads.getRoadId());
                    roadObject.put("agriculturalFacilities", roads.getAgriculturalFacilities());
                    roadObject.put("commentsOnConnections", roads.getCommentsOnConnections());
                    roadObject.put("checked", false);
                    roadObject.put("osmId", roads.getOsmId());
                    roadObject.put("osm_id", roads.getOsmId());
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("code", roads.getCode());
                    } else {
                        roadObject.put("code", "-");
                    }
                    roadObject.put("checked", false);


                    roadObject.put("fclass", roads.getFclass());
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("name", roads.getName());
                    } else {
                        roadObject.put("name", "-");
                    }
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("ref", roads.getRef());
                    } else {
                        roadObject.put("ref", "-");
                    }
                    if (!roads.getOsmId().equalsIgnoreCase("") && roads.getOsmId() != null) {
                        roadObject.put("oneway", roads.getOneway());
                    } else {
                        roadObject.put("oneway", "-");
                    }
                    roadObject.put("maxspeed", roads.getMaxspeed());
                    roadObject.put("layer", roads.getLayer());
                    roadObject.put("bridge", roads.getBridge());
                    if (roads.getBridge() != null) {
                        if (roads.getBridge().equalsIgnoreCase("T")) {
                            roadObject.put("bridgeMat", true);
                        } else {
                            roadObject.put("bridgeMat", false);
                        }
                    } else {
                        roadObject.put("bridgeMat", false);
                    }
                    roadObject.put("tunnel", roads.getTunnel());
                    if (roads.getTunnel() != null) {
                        if (roads.getTunnel().equalsIgnoreCase("T")) {
                            roadObject.put("tunnelMat", true);
                        } else {
                            roadObject.put("tunnelMat", false);
                        }
                    } else {
                        roadObject.put("tunnelMat", false);

                    }

                    roadObject.put("linksToMajorActivityCentres", roads.getAccessToGCsRMs()+roads.getFacilitiesServed());
                    roadObject.put("connectivity", roads.getConnectivity());
                    roadObject.put("district", roads.getDistrict());
                    roadObject.put("source", roads.getSource());
                    roadObject.put("roadWidthInM", roads.getRoadWidthInM());
                    roadObject.put("roadCondition", roads.getRoadCondition());
                    roadObject.put("maxRoadSteepnessPrc", roads.getMaxRoadSteepnessPrc());
                    if (roads.getRoadsideEnvironment() == null) {
                        roadObject.put("roadsideEnvironment", "-");
                    } else {
                        roadObject.put("roadsideEnvironment", roads.getRoadsideEnvironment());
                    }
                    roadObject.put("agricultureFacilitation", roads.getAgricultureFacilitation());
                    roadObject.put("agricultureFacilitaties", roads.getAgriculturalFacilities().toString());
                    roadObject.put("lengthOfRoadStretchInM", roads.getLengthOfRoadStretchInM());
                    roadObject.put("averageElevationInMAboveSealevel", roads.getAverageElevationInMAboveSealevel());
                    roadObject.put("elevationInMetres", roads.getElevationInMetres());
                    roadObject.put("averagePopulationInPersons", roads.getAveragePopulationInPersons());
                    roadObject.put("LVRR_ID", roads.getLvrrId().toString());
                    roadObject.put("security", roads.getSecurity());
                    roadObject.put("environmentalImpacts", roads.getEnvironmentalImpacts().toString());
                    roadObject.put("districtId", roads.getDistrictId());
                    roadObject.put("districtCode", roads.getDistrictId());
                    roadObject.put("lengthInMetres", roads.getLengthInMetres());
                    roadObject.put("populationServed", roads.getPopulationServed());
                    roadObject.put("facilitiesServed", roads.getFacilitiesServed());
                    roadObject.put("accessToGCsRMs", roads.getAccessToGCsRMs());
                    roadObject.put("farmToTheMarket", roads.getFarmToTheMarket().toString());
                    roadObject.put("agriculturalFacilities", roads.getAgriculturalFacilities());
                    roadObject.put("linksToMajorActivityCentres", roads.getLinksToMajorActivityCentres());
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
                    String opParamSql = "select * from operetional_parameters op ";
                    roadObject.put("cbiRoutine", roads.getCbi2());
                    roadObject.put("cbiPeriodic", roads.getCbi1());
                    roadObject.put("mca", roads.getMca());
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


    //importRoadsData
    private RoadsEntity removeNullsFromRoad(RoadsEntity road) {
        RoadsEntity roadsEntity = road;
        if (roadsEntity.getAgricultureFacilitation() == null || roadsEntity.getAgricultureFacilitation().equalsIgnoreCase("")) {
            roadsEntity.setAgricultureFacilitation("-");
        }
        if (roadsEntity.getAveragePopulationInPersons() == null || roadsEntity.getAveragePopulationInPersons().equalsIgnoreCase("")) {
            roadsEntity.setAveragePopulationInPersons("-");
        }
        if (roadsEntity.getBridge() == null || roadsEntity.getBridge().equalsIgnoreCase("")) {
            roadsEntity.setBridge("-");
        }

        if (roadsEntity.getLayer() == null || roadsEntity.getLayer().equalsIgnoreCase("")) {
            roadsEntity.setLayer("-");
        }

        if (roadsEntity.getCode() == null || roadsEntity.getCode().equalsIgnoreCase("")) {
            roadsEntity.setCode("-");
        }
        if (roadsEntity.getCommentsOnConnections() == null || roadsEntity.getCommentsOnConnections().equalsIgnoreCase("")) {
            roadsEntity.setCommentsOnConnections("-");
        }
        if (roadsEntity.getDistrict() == null || roadsEntity.getDistrict().equalsIgnoreCase("")) {
            roadsEntity.setDistrict("-");
        }
        if (roadsEntity.getName() == null || roadsEntity.getName().equalsIgnoreCase("")) {
            roadsEntity.setName("-");
        }
        if (roadsEntity.getOsmId() == null || roadsEntity.getOsmId().equalsIgnoreCase("")) {
            roadsEntity.setOsmId("-");
        }
        if (roadsEntity.getRoadCondition() == null || roadsEntity.getRoadCondition().equalsIgnoreCase("")) {
            roadsEntity.setRoadCondition("-");
        }
        if (roadsEntity.getRoadsideEnvironment() == null || roadsEntity.getRoadsideEnvironment().equalsIgnoreCase("")) {
            roadsEntity.setRoadsideEnvironment("-");
        }
        if (roadsEntity.getRef() == null || roadsEntity.getRef().equalsIgnoreCase("")) {
            roadsEntity.setRef("-");
        }
        if (roadsEntity.getFclass() == null || roadsEntity.getFclass().equalsIgnoreCase("")) {
            roadsEntity.setFclass("-");
        }
        if (roadsEntity.getOneway() == null || roadsEntity.getOneway().equalsIgnoreCase("")) {
            roadsEntity.setOneway("-");
        }
        if (roadsEntity.getTunnel() == null || roadsEntity.getTunnel().equalsIgnoreCase("")) {
            roadsEntity.setTunnel("-");
        }

        if (roadsEntity.getSource() == null) {
            roadsEntity.setSource("-");
        }

        if (roadsEntity.getMaxspeed() == null) {
            roadsEntity.setMaxspeed("-");
        }
        if (roadsEntity.getAgriculturalFacilities() == null) {
            roadsEntity.setAgriculturalFacilities(0.0);
        }

        if (roadsEntity.getWidthInMetres() == null) {
            roadsEntity.setWidthInMetres(0);
        }

        if (roadsEntity.getRoadWidthInM() == null) {
            roadsEntity.setRoadWidthInM(0);
        }


        if (roadsEntity.getMaxRoadSteepnessPrc() == null) {
            roadsEntity.setMaxRoadSteepnessPrc(0);
        }

        if (roadsEntity.getLengthOfRoadStretchInM() == null) {
            roadsEntity.setLengthOfRoadStretchInM(0);
        }

        if (roadsEntity.getAverageElevationInMAboveSealevel() == null) {
            roadsEntity.setAverageElevationInMAboveSealevel(0);
        }

        if (roadsEntity.getSecurity() == null) {
            roadsEntity.setSecurity(0);
        }
        if (roadsEntity.getEnvironmentalImpacts() == null) {
            roadsEntity.setEnvironmentalImpacts(0);
        }
        if (roadsEntity.getLengthInMetres() == null) {
            roadsEntity.setLengthInMetres(0);
        }

        if (roadsEntity.getWidthInMetres() == null) {
            roadsEntity.setWidthInMetres(0);
        }
        if (roadsEntity.getElevationInMetres() == null) {
            roadsEntity.setElevationInMetres(0);
        }
        if (roadsEntity.getPopulationServed() == null) {
            roadsEntity.setPopulationServed(0.0);
        }
        if (roadsEntity.getFacilitiesServed() == null) {
            roadsEntity.setFacilitiesServed(0.0);
        }

        if (roadsEntity.getAccessToGCsRMs() == null) {
            roadsEntity.setAccessToGCsRMs(0.0);
        }
        if (roadsEntity.getFarmToTheMarket() == null) {
            roadsEntity.setFarmToTheMarket(0.0);
        }
        if (roadsEntity.getAgriculturalFacilities() == null) {
            roadsEntity.setAgriculturalFacilities(0.0);
        }
        if (roadsEntity.getLinksToMajorActivityCentres() == null) {
            roadsEntity.setLinksToMajorActivityCentres(0.0);
        }
        if (roadsEntity.getNumberOfConnections() == null) {
            roadsEntity.setNumberOfConnections(0.0);
        }
        roadsEntity.setC1Score(0.0);
        roadsEntity.setC2Score(0.0);
        roadsEntity.setC3Score(0.0);
        roadsEntity.setC4Score(0.0);
        roadsEntity.setC5Score(0.0);
        roadsEntity.setC6Score(0.0);
        roadsEntity.setC7Score(0.0);
        roadsEntity.setC8Score(0.0);
        roadsEntity.setC9Score(0.0);
        roadsEntity.setC10Score(0.0);
        roadsEntity.setC11Score(0.0);
        roadsEntity.setC12Score(0.0);
        roadsEntity.setC13Score(0.0);
        roadsEntity.setC14Score(0.0);
        roadsEntity.setC15Score(0.0);
        roadsEntity.setMca(0.0);
        roadsEntity.setCbi1(0.0);
        roadsEntity.setCbi2(0.0);
        return roadsEntity;
    }



    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result importRoadsData() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                JsonNode headers = ((ObjectNode) json).get("headers");
                ((ObjectNode) json).remove("headers");
                JsonNode data = ((ObjectNode) json).get("data");
                ((ObjectNode) json).remove("data");
                Integer length = json.findPath("length").asInt();
                ((ObjectNode) json).remove("length");
                String[] headersArray = new String[length];
                if (headers != null && data != null) {
                    for (int i = 0; i < headers.size(); i++) {
                        String header = headers.get(i).findPath("title").asText();
                        headersArray[i] = header;
                    }
                    for (int i = 0; i < data.size(); i++) {
                        HashMap<String, Object> road = new HashMap<>();
                        for (int j = 0; j < headersArray.length; j++) { //data.get(i).size()
                            road.put(headersArray[j], data.get(i).get(j));
                        }
                        JsonNode roadJson = Json.toJson(road);
                        RoadsEntity roadsEntity = Json.fromJson(roadJson, RoadsEntity.class);
                        RoadsEntity notNullFieldsRoad = removeNullsFromRoad(roadsEntity);
                        String sqlDistrict = "select * from districts d where d.district_name='" + notNullFieldsRoad.getDistrict() + "'";
                        List<DistrictsEntity> dlist = JPA.em().createNativeQuery(sqlDistrict, DistrictsEntity.class).getResultList();
                        if (dlist.size() > 0) {
                            notNullFieldsRoad.setDistrictId((int) dlist.get(0).getNumericalDistrictCode());
                        }
                        if (notNullFieldsRoad.getLvrrId() != null && notNullFieldsRoad.getLvrrId() != 0) {
                            String roadByLvrrId = "select * from roads r where r.lvrr_id=" + notNullFieldsRoad.getLvrrId();
                            List<RoadsEntity> roadsList = JPA.em().createNativeQuery(roadByLvrrId, RoadsEntity.class).getResultList();
                            if (roadsList.size()>0) {
                                notNullFieldsRoad.setId(roadsList.get(0).getId());
                                if (json.findPath("criteriaCheckBox").asText().equalsIgnoreCase("true")) {
                                    HashMap<String, Object> roadMapResult = new HashMap<>();
                                    roadMapResult = calculateCriteriaAfterImport(notNullFieldsRoad);
                                    JsonNode mapedRoadMcaCbi = Json.toJson(roadMapResult);
                                    if (mapedRoadMcaCbi.findPath("status").asText().equalsIgnoreCase("ok")) {
                                        RoadsEntity roadCalculatedMcaCbi = (RoadsEntity) roadMapResult.get("road");
                                        JPA.em().merge(roadCalculatedMcaCbi);
                                    }else {
                                        JPA.em().merge(notNullFieldsRoad);
                                    }

                                } else {
                                    JPA.em().merge(notNullFieldsRoad);
                                }
                            }else{
                                if (json.findPath("criteriaCheckBox").asText().equalsIgnoreCase("true")) {
                                    HashMap<String, Object> roadMapResult = new HashMap<>();
                                    roadMapResult = calculateCriteriaAfterImport(notNullFieldsRoad);
                                    JsonNode mapedRoadMcaCbi = Json.toJson(roadMapResult);
                                    if (mapedRoadMcaCbi.findPath("status").asText().equalsIgnoreCase("ok")) {
                                        RoadsEntity roadCalculatedMcaCbi = (RoadsEntity) roadMapResult.get("road");
                                        JPA.em().persist(roadCalculatedMcaCbi);
                                    }else {
                                        JPA.em().persist(notNullFieldsRoad);
                                    }
                                } else {
                                    JPA.em().persist(notNullFieldsRoad);
                                }
                            }
                        }
                    }
                }
                returnList.put("data", finalRoadsList);
                returnList.put("status", "ok");
                returnList.put("message", "Roads from file has been updated succesfully");
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


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result getAllSnapshotsRecords() throws IOException {
        ObjectNode result = Json.newObject();
        try {
            JsonNode json = request().body().asJson();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                String query = " select * from snapshot d where 1=1 order by creation_date desc";
                Query q = JPA.em().createNativeQuery(query, SnapshotEntity.class);
                List<SnapshotEntity> distList = q.getResultList();
                ObjectMapper ow = new ObjectMapper();
                HashMap<String, Object> returnList = new HashMap<String, Object>();
                String jsonResult = "";
                Integer total = q.getResultList().size();
                List<HashMap<String, Object>> finalRoadsList = new ArrayList<HashMap<String, Object>>();
                for (SnapshotEntity d : distList) {
                    HashMap<String, Object> roadObject = new HashMap<String, Object>();
                    roadObject.put("id", d.getId());
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
                boolean snapshot = json.findPath("snapshot").asBoolean();
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
                    if (!lvrr_id.isEmpty()) {
                        roadsSql += " and r.lvrr_id=" + lvrr_id;
                    }
                    if (!district_id.isEmpty()) {
                        List<RoadsEntity> roadsList = JPA.em().createNativeQuery(roadsSql, RoadsEntity.class).getResultList();
                        if (snapshot == true) {
                            SnapshotEntity s = new SnapshotEntity();
                            s.setCreationDate(new Date());
                            s.setTitle("snapshot taked " + new Date());
                            JPA.em().persist(s);
                            for (RoadsEntity road : roadsList) {
                                JsonNode roadObject = Json.toJson(road);
                                ((ObjectNode) roadObject).remove("id");
                                RoadsRevisionsEntity roadRevision = Json.fromJson(roadObject, RoadsRevisionsEntity.class);
                                roadRevision.setRoadId(road.getId());
                                roadRevision.setSnapshotId(s.getId());
                                JPA.em().persist(roadRevision);
                            }
                        }


                        for (RoadsEntity road : roadsList) {
                            Double mca = 0.0;
                            String opParamSql = "select * from `operetional_parameters` op ";
                            List<OperetionalParametersEntity> opList = JPA.em().createNativeQuery(opParamSql, OperetionalParametersEntity.class).getResultList();
                            Double estimatedPeriodicMaintenanceCost = opList.get(0).getEstimatedPeriodicMaintenanceCost();
                            Double estimatedRoutineMaintenanceCost = opList.get(0).getEstimatedRoutineMaintenanceCost();
                            Double cbiPeriodic = 0.0;
                            Double cbiRoutine = 0.0;
                            if (road.getLengthInMetres() > 0) {
                                cbiPeriodic =  (estimatedPeriodicMaintenanceCost *(road.getLengthInMetres()/new Double(1000)))/road.getPopulationServed();
                                cbiRoutine =  (estimatedRoutineMaintenanceCost *(road.getLengthInMetres()/new Double(1000)))/road.getPopulationServed();
                            }
                            if (cbiPeriodic > 0) {
                                BigDecimal finalCbi = new BigDecimal(cbiPeriodic).setScale(2, RoundingMode.HALF_UP);
                                System.out.println(finalCbi);
                                road.setCbi1(finalCbi.doubleValue());//  value =Double.parseDouble(new DecimalFormat("##.####").format(value));
                            } else {
                                road.setCbi1(new Double(0));
                            }
                            if (cbiRoutine > 0) {
                                BigDecimal finalCbi = new BigDecimal(cbiRoutine).setScale(2, RoundingMode.HALF_UP);
                                System.out.println(finalCbi);
                                road.setCbi2(finalCbi.doubleValue());//  value =Double.parseDouble(new DecimalFormat("##.####").format(value));
                            } else {
                                road.setCbi2(new Double(0));
                            }
                            for (CriteriaMasterEntity cm : cmList) {
                                if (cm.getId() == 1) {
                                    Integer weightFactor = 1;
                                    if (cm.getCalculateIndicator() == 1) {
                                        if (road.getPopulationServed() == 0) {
                                            road.setC1Score(0.0);
                                            road.setC1Id(1);
                                        }
                                        if (road.getPopulationServed() > 0 && road.getPopulationServed() < 999) {
                                            road.setC1Score(Double.valueOf(4 * weightFactor));
                                            road.setC1Id(2);
                                        }
                                        if (road.getPopulationServed() > 1000 && road.getPopulationServed() < 1999) {
                                            road.setC1Score(Double.valueOf(8 * weightFactor));
                                            road.setC1Id(3);
                                        }
                                        if (road.getPopulationServed() > 2000 && road.getPopulationServed() < 2999) {
                                            road.setC1Score(Double.valueOf(12 * weightFactor));
                                            road.setC1Id(4);
                                        }
                                        if (road.getPopulationServed() > 3000) {
                                            road.setC1Score(Double.valueOf(15 * weightFactor));
                                            road.setC1Id(5);
                                        }
                                    }
                                    mca += road.getC1Score();
                                }
                                if (cm.getId() == 2) {
                                    Integer weightFactor = 1;
                                    if (cm.getCalculateIndicator() == 1) {
                                        if (road.getFacilitiesServed() == 0) {
                                            road.setC2Score(0.0);
                                            road.setC2Id(10);
                                        }
                                        if (road.getFacilitiesServed() >= 1 && road.getFacilitiesServed() <= 9) {
                                            road.setC2Score(road.getFacilitiesServed().doubleValue());
                                            road.setC2Id((int) (10 + road.getFacilitiesServed()));
                                        }
                                        if (road.getFacilitiesServed() >= 10) {
                                            road.setC2Score(10.0);
                                            road.setC2Id(20);
                                        }
                                    }
                                    mca += road.getC2Score() * weightFactor;
                                }
                                if (cm.getId() == 3) {
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getAccessToGCsRMs() + " and cmd.criteria_master_id=3";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
                                    if (cmdList.size() > 0) {
                                        road.setC3Id(cmdList.get(0).getId());
                                        road.setC3Score(road.getAccessToGCsRMs());
                                        mca += road.getC3Score() * weightFactor;
                                    } else {
                                        road.setC3Id(0);
                                        road.setC3Score(0.0);
                                    }
                                }
                                if (cm.getId() == 4) {
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getFarmToTheMarket() + " and cmd.criteria_master_id=4";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
                                    if (cmdList.size() > 0) {

                                        road.setC4Id(cmdList.get(0).getId());
                                        road.setC4Score(road.getFarmToTheMarket());
                                        mca += road.getC4Score() * weightFactor;
                                    } else {
                                        road.setC4Id(0);
                                        road.setC4Score(0.0);
                                    }
                                }
                                if (cm.getId() == 5) {
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getAgriculturalFacilities() + " and cmd.criteria_master_id=5";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();

                                    if (cmdList.size() > 0) {
                                        road.setC5Id(cmdList.get(0).getId());
                                        road.setC5Score(road.getAgriculturalFacilities());
                                        mca += road.getC5Score() * weightFactor;
                                    } else {
                                        road.setC5Id(0);
                                        road.setC5Score(0.0);
                                    }
                                }
                                if (cm.getId() == 6) {
                                    Integer weightFactor = 5;
                                    road.setC6Id(0);
                                    road.setC6Score(road.getConnectivity());
                                    mca += road.getC6Score();

                                }
                                if (cm.getId() == 7) {
                                    road.setC7Score(0.0);
                                    road.setC7Id(0);
                                    mca += road.getC7Score();
                                }
                                if (cm.getId() == 8) {
                                    Integer weightFactor = 1;
                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getNumberOfConnections() + " and cmd.criteria_master_id=8";
                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
                                    if (cmdList.size() > 0) {
                                        road.setC8Id(cmdList.get(0).getId());
                                        road.setC8Score(road.getNumberOfConnections());
                                        mca += road.getC8Score() * weightFactor;
                                    } else {
                                        road.setC8Id(0);
                                        road.setC8Score(0.0);
                                    }
                                }
                                if (cm.getId() == 9) {
                                    Integer weightFactor = 1;

                                    road.setC9Id(0);
                                    if(road.getRoadCondition()=="asphalt" || road.getRoadCondition()=="concrete"){
                                        road.setC9Score(5.0);
                                        mca += road.getC9Score() * weightFactor;

                                    }else {
                                        road.setC9Score(0.0);
                                    }
                                    mca += road.getC9Score();
                                }
                                if (cm.getId() == 10) {
                                    road.setC10Score(road.getRoadQualityAndNeeds());
                                    road.setC10Id(0);
                                    mca += road.getC10Score();
                                }
                                if (cm.getId() == 11) {
                                    road.setC11Score(road.getRequirementsForEarthWorks());
                                    road.setC11Id(0);
                                    mca += road.getC11Score();
                                }
                                if (cm.getId() == 12) {
                                    road.setC12Score(road.getTrafficVolume());
                                    road.setC12Id(0);
                                    mca += road.getC12Score();
                                }
                                if (cm.getId() == 13) {
                                    road.setC13Score(road.getSafety());
                                    road.setC13Id(0);
                                    mca += road.getC13Score();
                                }
                                if (cm.getId() == 14) {

                                    if (road.getDistrictId() == 1409) {
                                        road.setC14Score(0.0);
                                        road.setC14Id(98);
                                    } else if (road.getDistrictId() == 1403) {
                                        road.setC14Score(0.0);
                                        road.setC14Id(99);
                                    } else if (road.getDistrictId() == 1401) {
                                        road.setC14Score(0.0);
                                        road.setC14Id(100);
                                    } else if (road.getDistrictId() == 1402) {
                                        road.setC14Score(0.0);
                                        road.setC14Id(101);
                                    } else if (road.getDistrictId() == 1405) {
                                        road.setC14Score(2.0);
                                        road.setC14Id(102);
                                    } else if (road.getDistrictId() == 1406) {
                                        road.setC14Score(2.0);
                                        road.setC14Id(103);
                                    } else if (road.getDistrictId() == 1410) {
                                        road.setC14Score(5.0);
                                        road.setC14Id(104);
                                    } else if (road.getDistrictId() == 1407) {
                                        road.setC14Score(3.0);
                                        road.setC14Id(105);
                                    } else if (road.getDistrictId() == 1412) {
                                        road.setC14Score(3.0);
                                        road.setC14Id(106);
                                    } else if (road.getDistrictId() == 1404) {
                                        road.setC14Score(0.0);
                                        road.setC14Id(107);
                                    } else if (road.getDistrictId() == 1408) {
                                        road.setC14Score(0.0);
                                        road.setC14Id(108);
                                    }
                                    mca += road.getC14Score();
                                }
                                if (cm.getId() == 15) {
                                    road.setC15Score(Double.valueOf(road.getEnvironmentalImpacts()));
                                    mca += road.getC15Score();
                                }
                            }
                            road.setMca(mca);
                            JPA.em().merge(road);
                        }
                    }
                    result.put("status", "ok");
                    result.put("message", "Criteria has been updated succesfully");
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


//    @SuppressWarnings("Duplicates")
//    @play.db.jpa.Transactional
//    @BodyParser.Of(BodyParser.Json.class)
//    public Result calculateCriteria() {
//        ObjectNode result = Json.newObject();
//        try {
//            JsonNode json = request().body().asJson();
//            if (json == null) {
//                return badRequest("Expecting Json data");
//            } else {
//                String district_id = json.findPath("district_id").asText();
//                String lvrr_id = json.findPath("lvrr_id").asText();
//                boolean snapshot = json.findPath("snapshot").asBoolean();
//                if (district_id.isEmpty() || district_id.equalsIgnoreCase("0")) {
//                    result.put("status", "error");
//                    result.put("message", "Ανεπιτυχής Διαδικασία.");
//                    return ok(result);
//                } else {
//                    String criteriaMasterSql = "select cm.* FROM criteria_master cm";
//                    List<CriteriaMasterEntity> cmList = JPA.em().createNativeQuery(criteriaMasterSql, CriteriaMasterEntity.class).getResultList();
//                    String roadsSql = "select * from roads r where 1=1";
//                    if (!district_id.isEmpty()) {
//                        roadsSql += " and r.district_id=" + district_id;
//                    }
//                    if (!lvrr_id.isEmpty()) {
//                        roadsSql += " and r.lvrr_id=" + lvrr_id;
//                    }
//                    if (!district_id.isEmpty()) {
//                        List<RoadsEntity> roadsList = JPA.em().createNativeQuery(roadsSql, RoadsEntity.class).getResultList();
//                        if (snapshot == true) {
//                            SnapshotEntity s = new SnapshotEntity();
//                            s.setCreationDate(new Date());
//                            s.setTitle("snapshot taked " + new Date());
//                            JPA.em().persist(s);
//                            for (RoadsEntity road : roadsList) {
//                                JsonNode roadObject = Json.toJson(road);
//                                ((ObjectNode) roadObject).remove("id");
//                                RoadsRevisionsEntity roadRevision = Json.fromJson(roadObject, RoadsRevisionsEntity.class);
//                                roadRevision.setRoadId(road.getId());
//                                roadRevision.setSnapshotId(s.getId());
//                                JPA.em().persist(roadRevision);
//                            }
//                        }
//                        for (RoadsEntity road : roadsList) {
//                            Double mca = 0.0;
//                            String opParamSql = "select * from `operetional_parameters` op ";
//                            List<OperetionalParametersEntity> opList = JPA.em().createNativeQuery(opParamSql, OperetionalParametersEntity.class).getResultList();
//                            Double estimatedPeriodicMaintenanceCost = opList.get(0).getEstimatedPeriodicMaintenanceCost();
//                            Double estimatedRoutineMaintenanceCost = opList.get(0).getEstimatedRoutineMaintenanceCost();
//                            Double cbiPeriodic = 0.0;
//                            Double cbiRoutine = 0.0;
//                            if (road.getLengthInMetres() > 0) {
//                                cbiPeriodic =  (estimatedPeriodicMaintenanceCost *(road.getLengthInMetres()/new Double(1000)))/road.getPopulationServed();
//                                cbiRoutine =  (estimatedRoutineMaintenanceCost *(road.getLengthInMetres()/new Double(1000)))/road.getPopulationServed();
//                            }
//                            if (cbiPeriodic > 0) {
//                                BigDecimal finalCbi = new BigDecimal(cbiPeriodic).setScale(2, RoundingMode.HALF_UP);
//                                System.out.println(finalCbi);
//                                road.setCbi1(finalCbi.doubleValue());//  value =Double.parseDouble(new DecimalFormat("##.####").format(value));
//                            } else {
//                                road.setCbi1(new Double(0));
//                            }
//                            if (cbiRoutine > 0) {
//                                BigDecimal finalCbi = new BigDecimal(cbiRoutine).setScale(2, RoundingMode.HALF_UP);
//                                System.out.println(finalCbi);
//                                road.setCbi2(finalCbi.doubleValue());//  value =Double.parseDouble(new DecimalFormat("##.####").format(value));
//                            } else {
//                                road.setCbi2(new Double(0));
//                            }
//                            for (CriteriaMasterEntity cm : cmList) {
//                                if (cm.getId() == 1) {
//                                    Integer weightFactor = 1;
//                                    if (cm.getCalculateIndicator() == 1) {
//                                        if (road.getPopulationServed() == 0) {
//                                            road.setC1Score(0.0);
//                                            road.setC1Id(1);
//                                        }
//                                        if (road.getPopulationServed() > 0 && road.getPopulationServed() < 999) {
//                                            road.setC1Score(Double.valueOf(4 * weightFactor));
//                                            road.setC1Id(2);
//                                        }
//                                        if (road.getPopulationServed() > 1000 && road.getPopulationServed() < 1999) {
//                                            road.setC1Score(Double.valueOf(8 * weightFactor));
//                                            road.setC1Id(3);
//                                        }
//                                        if (road.getPopulationServed() > 2000 && road.getPopulationServed() < 2999) {
//                                            road.setC1Score(Double.valueOf(12 * weightFactor));
//                                            road.setC1Id(4);
//                                        }
//                                        if (road.getPopulationServed() > 3000) {
//                                            road.setC1Score(Double.valueOf(15 * weightFactor));
//                                            road.setC1Id(5);
//                                        }
//                                    }
//                                    mca += road.getC1Score();
//                                }
//                                if (cm.getId() == 2) {
//                                    Integer weightFactor = 1;
//                                    if (cm.getCalculateIndicator() == 1) {
//                                        if (road.getFacilitiesServed() == 0) {
//                                            road.setC2Score(0.0);
//                                            road.setC2Id(10);
//                                        }
//                                        if (road.getFacilitiesServed() >= 1 && road.getFacilitiesServed() <= 9) {
//                                            road.setC2Score(road.getFacilitiesServed().doubleValue());
//                                            road.setC2Id((int) (10 + road.getFacilitiesServed()));
//                                        }
//                                        if (road.getFacilitiesServed() >= 10) {
//                                            road.setC2Score(10.0);
//                                            road.setC2Id(20);
//                                        }
//                                    }
//                                    mca += road.getC2Score() * weightFactor;
//                                }
//                                if (cm.getId() == 3) {
//                                    Integer weightFactor = 1;
//                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getAccessToGCsRMs() + " and cmd.criteria_master_id=3";
//                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
//                                    if (cmdList.size() > 0) {
//                                        road.setC3Id(cmdList.get(0).getId());
//                                        road.setC3Score(road.getAccessToGCsRMs());
//                                        mca += road.getC3Score() * weightFactor;
//                                    } else {
//                                        road.setC3Id(0);
//                                        road.setC3Score(0.0);
//                                    }
//                                }
//                                if (cm.getId() == 4) {
//                                    Integer weightFactor = 1;
//                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getFarmToTheMarket() + " and cmd.criteria_master_id=4";
//                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
//                                    if (cmdList.size() > 0) {
//
//                                        road.setC4Id(cmdList.get(0).getId());
//                                        road.setC4Score(road.getFarmToTheMarket());
//                                        mca += road.getC4Score() * weightFactor;
//                                    } else {
//                                        road.setC4Id(0);
//                                        road.setC4Score(0.0);
//                                    }
//                                }
//                                if (cm.getId() == 5) {
//                                    Integer weightFactor = 1;
//                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getAgriculturalFacilities() + " and cmd.criteria_master_id=5";
//                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
//
//                                    if (cmdList.size() > 0) {
//                                        road.setC5Id(cmdList.get(0).getId());
//                                        road.setC5Score(road.getAgriculturalFacilities());
//                                        mca += road.getC5Score() * weightFactor;
//                                    } else {
//                                        road.setC5Id(0);
//                                        road.setC5Score(0.0);
//                                    }
//                                }
//                                if (cm.getId() == 6) {
//                                    Integer weightFactor = 5;
//                                    road.setC6Id(0);
//                                    if (road.getLinksToMajorActivityCentres() <= 5) {
//                                        road.setC6Score(road.getConnectivity());
//                                    } else {
//                                        road.setC6Score(5.0);
//                                    }
//                                }
//                                if (cm.getId() == 7) {
//                                    road.setC7Score(0.0);
//                                    road.setC7Id(0);
//                                    mca += road.getC7Score();
//                                }
//                                if (cm.getId() == 8) {
//                                    Integer weightFactor = 1;
//                                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getNumberOfConnections() + " and cmd.criteria_master_id=8";
//                                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
//                                    if (cmdList.size() > 0) {
//                                        road.setC8Id(cmdList.get(0).getId());
//                                        road.setC8Score(road.getNumberOfConnections());
//                                        mca += road.getC8Score() * weightFactor;
//                                    } else {
//                                        road.setC8Id(0);
//                                        road.setC8Score(0.0);
//                                    }
//                                }
//                                if (cm.getId() == 9) {
//                                    road.setC9Score(0.0);
//
//                                    road.setC9Id(0);
//                                    mca += road.getC9Score();
//                                }
//                                if (cm.getId() == 10) {
//                                    road.setC10Score(0.0);
//                                    road.setC10Id(0);
//                                    mca += road.getC10Score();
//                                }
//                                if (cm.getId() == 11) {
//                                    road.setC11Score(0.0);
//                                    road.setC11Id(0);
//                                    mca += road.getC11Score();
//                                }
//                                if (cm.getId() == 12) {
//                                    road.setC12Score(0.0);
//                                    road.setC12Id(0);
//                                    mca += road.getC12Score();
//                                }
//                                if (cm.getId() == 13) {
//                                    road.setC13Score(0.0);
//                                    road.setC13Id(0);
//                                    mca += road.getC13Score();
//                                }
//                                if (cm.getId() == 14) {
//
//                                    if (road.getDistrictId() == 1409) {
//                                        road.setC14Score(0.0);
//                                        road.setC14Id(98);
//                                    } else if (road.getDistrictId() == 1403) {
//                                        road.setC14Score(0.0);
//                                        road.setC14Id(99);
//                                    } else if (road.getDistrictId() == 1401) {
//                                        road.setC14Score(0.0);
//                                        road.setC14Id(100);
//                                    } else if (road.getDistrictId() == 1402) {
//                                        road.setC14Score(0.0);
//                                        road.setC14Id(101);
//                                    } else if (road.getDistrictId() == 1405) {
//                                        road.setC14Score(2.0);
//                                        road.setC14Id(102);
//                                    } else if (road.getDistrictId() == 1406) {
//                                        road.setC14Score(2.0);
//                                        road.setC14Id(103);
//                                    } else if (road.getDistrictId() == 1410) {
//                                        road.setC14Score(5.0);
//                                        road.setC14Id(104);
//                                    } else if (road.getDistrictId() == 1407) {
//                                        road.setC14Score(3.0);
//                                        road.setC14Id(105);
//                                    } else if (road.getDistrictId() == 1412) {
//                                        road.setC14Score(3.0);
//                                        road.setC14Id(106);
//                                    } else if (road.getDistrictId() == 1404) {
//                                        road.setC14Score(0.0);
//                                        road.setC14Id(107);
//                                    } else if (road.getDistrictId() == 1408) {
//                                        road.setC14Score(0.0);
//                                        road.setC14Id(108);
//                                    }
//                                    mca += road.getC14Score();
//                                }
//                                if (cm.getId() == 15) {
//                                    road.setC15Score(0.0);
//                                    road.setC15Id(0);
//                                    mca += road.getC15Score();
//                                }
//                            }
//                            // road.setLinksToMajorActivityCentres(road.getC2Score()+road.getC3Score());
//
//                            road.setMca(mca);
//                            JPA.em().merge(road);
//                        }
//                    }
//                    result.put("status", "ok");
//                    result.put("message", "Criteria has been updated succesfully");
//                    return ok(result);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("status", "error");
//            result.put("message", "Not selected District");
//            return ok(result);
//        }
//    }

    @SuppressWarnings("Duplicates")

    private HashMap<String, Object> calculateCriteriaAfterImport(RoadsEntity road) {
        try {
            HashMap<String, Object> result = new HashMap<>();
            String criteriaMasterSql = "select cm.* FROM criteria_master cm";
            List<CriteriaMasterEntity> cmList = JPA.em().createNativeQuery(criteriaMasterSql, CriteriaMasterEntity.class).getResultList();

            Double mca = 0.0;
            String opParamSql = "select * from operetional_parameters op ";
            List<OperetionalParametersEntity> opList = JPA.em().createNativeQuery(opParamSql, OperetionalParametersEntity.class).getResultList();

            Double estimatedPeriodicMaintenanceCost = opList.get(0).getEstimatedPeriodicMaintenanceCost();
            Double estimatedRoutineMaintenanceCost = opList.get(0).getEstimatedRoutineMaintenanceCost();
            Double cbiPeriodic = 0.0;
            Double cbiRoutine = 0.0;
            if (road.getLengthInMetres() > 0) {
                cbiPeriodic =  (estimatedPeriodicMaintenanceCost *(road.getLengthInMetres()/new Double(1000)))/road.getPopulationServed();
                cbiRoutine =  (estimatedRoutineMaintenanceCost *(road.getLengthInMetres()/new Double(1000)))/road.getPopulationServed();
            }

            if (cbiPeriodic > 0) {
                BigDecimal finalCbi = new BigDecimal(cbiPeriodic).setScale(2, RoundingMode.HALF_UP);
                System.out.println(finalCbi);
                road.setCbi1(finalCbi.doubleValue());//  value =Double.parseDouble(new DecimalFormat("##.####").format(value));
            } else {
                road.setCbi1(new Double(0));
            }

            if (cbiRoutine > 0) {
                BigDecimal finalCbi = new BigDecimal(cbiRoutine).setScale(2, RoundingMode.HALF_UP);
                System.out.println(finalCbi);
                road.setCbi2(finalCbi.doubleValue());//  value =Double.parseDouble(new DecimalFormat("##.####").format(value));
            } else {
                road.setCbi2(new Double(0));
            }

            for (CriteriaMasterEntity cm : cmList) {
                if (cm.getId() == 1) {
                    Integer weightFactor = 1;
                    if (cm.getCalculateIndicator() == 1) {
                        if (road.getPopulationServed() == 0) {
                            road.setC1Score(0.0);
                            road.setC1Id(1);
                        }
                        if (road.getPopulationServed() > 0 && road.getPopulationServed() < 999) {
                            road.setC1Score(Double.valueOf(4 * weightFactor));
                            road.setC1Id(2);
                        }
                        if (road.getPopulationServed() > 1000 && road.getPopulationServed() < 1999) {
                            road.setC1Score(Double.valueOf(8 * weightFactor));
                            road.setC1Id(3);
                        }
                        if (road.getPopulationServed() > 2000 && road.getPopulationServed() < 2999) {
                            road.setC1Score(Double.valueOf(12 * weightFactor));
                            road.setC1Id(4);
                        }
                        if (road.getPopulationServed() > 3000) {
                            road.setC1Score(Double.valueOf(15 * weightFactor));
                            road.setC1Id(5);
                        }
                    }
                    mca += road.getC1Score();
                }
                if (cm.getId() == 2) {
                    Integer weightFactor = 1;
                    if (cm.getCalculateIndicator() == 1) {
                        if (road.getFacilitiesServed() == 0) {
                            road.setC2Score(0.0);
                            road.setC2Id(10);
                        }
                        if (road.getFacilitiesServed() >= 1 && road.getFacilitiesServed() <= 9) {
                            road.setC2Score(road.getFacilitiesServed().doubleValue());
                            road.setC2Id((int) (10 + road.getFacilitiesServed()));
                        }
                        if (road.getFacilitiesServed() >= 10) {
                            road.setC2Score(10.0);
                            road.setC2Id(20);
                        }
                    }
                    mca += road.getC2Score() * weightFactor;
                }
                if (cm.getId() == 3) {
                    Integer weightFactor = 1;
                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getAccessToGCsRMs() + " and cmd.criteria_master_id=3";
                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
                    if (cmdList.size() > 0) {
                        road.setC3Id(cmdList.get(0).getId());
                        road.setC3Score(road.getAccessToGCsRMs());
                        mca += road.getC3Score() * weightFactor;
                    } else {
                        road.setC3Id(0);
                        road.setC3Score(0.0);
                    }
                }
                if (cm.getId() == 4) {
                    Integer weightFactor = 1;
                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getFarmToTheMarket() + " and cmd.criteria_master_id=4";
                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
                    if (cmdList.size() > 0) {

                        road.setC4Id(cmdList.get(0).getId());
                        road.setC4Score(road.getFarmToTheMarket());
                        mca += road.getC4Score() * weightFactor;
                    } else {
                        road.setC4Id(0);
                        road.setC4Score(0.0);
                    }
                }
                if (cm.getId() == 5) {
                    Integer weightFactor = 1;
                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getAgriculturalFacilities() + " and cmd.criteria_master_id=5";
                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();

                    if (cmdList.size() > 0) {
                        road.setC5Id(cmdList.get(0).getId());
                        road.setC5Score(road.getAgriculturalFacilities());
                        mca += road.getC5Score() * weightFactor;
                    } else {
                        road.setC5Id(0);
                        road.setC5Score(0.0);
                    }
                }
                if (cm.getId() == 6) {
                    Integer weightFactor = 5;
                    road.setC6Id(0);
                    road.setC6Score(road.getNumberOfConnections());
                }
                if (cm.getId() == 7) {
                    road.setC7Score(0.0);
                    road.setC7Id(0);
                    mca += road.getC7Score();
                }
                if (cm.getId() == 8) {
                    Integer weightFactor = 1;
                    String sqlMasterDetail = "select cmd.* from criteria_master_details cmd where cmd.score=" + road.getNumberOfConnections() + " and cmd.criteria_master_id=8";
                    List<CriteriaMasterDetailsEntity> cmdList = JPA.em().createNativeQuery(sqlMasterDetail, CriteriaMasterDetailsEntity.class).getResultList();
                    if (cmdList.size() > 0) {
                        road.setC8Id(cmdList.get(0).getId());
                        road.setC8Score(road.getNumberOfConnections());
                        mca += road.getC8Score() * weightFactor;
                    } else {
                        road.setC8Id(0);
                        road.setC8Score(0.0);
                    }
                }
                if (cm.getId() == 9) {
                    road.setC9Id(0);
                    if(road.getRoadCondition()=="asphalt" || road.getRoadCondition()=="concrete"){
                        road.setC9Score(5.0);

                    }else {
                        road.setC9Score(0.0);
                    }
                    mca += road.getC9Score();
                }
                if (cm.getId() == 10) {
                    road.setC10Score(0.0);
                    road.setC10Id(0);
                    mca += road.getC10Score();
                }
                if (cm.getId() == 11) {
                    road.setC11Score(0.0);
                    road.setC11Id(0);
                    mca += road.getC11Score();
                }
                if (cm.getId() == 12) {
                    road.setC12Score(0.0);
                    road.setC12Id(0);
                    mca += road.getC12Score();
                }
                if (cm.getId() == 13) {
                    road.setC13Score(road.getSafety());
                    road.setC13Id(0);
                    mca += road.getC13Score();
                }
                if (cm.getId() == 14) {

                    if (road.getDistrictId() == 1409) {
                        road.setC14Score(0.0);
                        road.setC14Id(98);
                    } else if (road.getDistrictId() == 1403) {
                        road.setC14Score(0.0);
                        road.setC14Id(99);
                    } else if (road.getDistrictId() == 1401) {
                        road.setC14Score(0.0);
                        road.setC14Id(100);
                    } else if (road.getDistrictId() == 1402) {
                        road.setC14Score(0.0);
                        road.setC14Id(101);
                    } else if (road.getDistrictId() == 1405) {
                        road.setC14Score(2.0);
                        road.setC14Id(102);
                    } else if (road.getDistrictId() == 1406) {
                        road.setC14Score(2.0);
                        road.setC14Id(103);
                    } else if (road.getDistrictId() == 1410) {
                        road.setC14Score(5.0);
                        road.setC14Id(104);
                    } else if (road.getDistrictId() == 1407) {
                        road.setC14Score(3.0);
                        road.setC14Id(105);
                    } else if (road.getDistrictId() == 1412) {
                        road.setC14Score(3.0);
                        road.setC14Id(106);
                    } else if (road.getDistrictId() == 1404) {
                        road.setC14Score(0.0);
                        road.setC14Id(107);
                    } else if (road.getDistrictId() == 1408) {
                        road.setC14Score(0.0);
                        road.setC14Id(108);
                    }
                    mca += road.getC14Score();
                }
                if (cm.getId() == 15) {
                    road.setC15Score(Double.valueOf(road.getEnvironmentalImpacts()));
                    mca += road.getC15Score();
                }
            }
            road.setMca(mca);
            result.put("status", "ok");
            result.put("road", road);

            return result;
        } catch (Exception e) {
            HashMap<String, Object> result = new HashMap<>();
            result.put("status", "error");
            result.put("message", "Error while calculate criteria mca cbi rates");
            return result;
        }


    }


    @SuppressWarnings("Duplicates")
    @play.db.jpa.Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result deleteSnapshot() {
        try {
            JsonNode json = request().body().asJson(); //
            ObjectNode result = Json.newObject();
            if (json == null) {
                return badRequest("Expecting Json data");
            } else {
                Integer id = json.findPath("id").asInt();
                String rrevSql = "select * from roads_revisions rev where rev.snapshot_id=" + id;
                List<RoadsRevisionsEntity> rList = JPA.em().createNativeQuery(rrevSql, RoadsRevisionsEntity.class).getResultList();
                for (RoadsRevisionsEntity rev : rList) {
                    JPA.em().remove(rev);
                }
                SnapshotEntity n = JPA.em().find(SnapshotEntity.class, id);
                JPA.em().remove(n);
                JPA.em().remove(n);
                result.put("status", "ok");
                result.put("message", "Snapshot has been deleted succesfully");
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
    public Result updateRoad() {
        try {
            JsonNode json = Http.Context.Implicit.request().body().asJson();
            ObjectNode result = Json.newObject();
            if (json.findPath("id") == null) {
                return badRequest("Expecting Json data");
            } else {

                Double accessToGCsRMs = json.findPath("accessToGCsRMs").asDouble();
                Double agriculturalFacilities = json.findPath("agriculturalFacilities").asDouble();
                Double roadAccessibility = json.findPath("roadAccessibility").asDouble();
                boolean bridgeMat = json.findPath("bridgeMat").asBoolean();
                Integer elevationInMetres = json.findPath("elevationInMetres").asInt();
                Integer facilitiesServed = json.findPath("facilitiesServed").asInt();
                Double connectivity = json.findPath("connectivity").asDouble();



                Double farmToTheMarket = json.findPath("farmToTheMarket").asDouble();
                Double roadConditionCriterio = json.findPath("roadConditionCriterio").asDouble();
                Double roadQualityAndNeeds = json.findPath("roadQualityAndNeeds").asDouble();
                Integer environmentalImpacts = json.findPath("environmentalImpacts").asInt();
                Double safety = json.findPath("safety").asDouble();
                Double requirementsForEarthWorks = json.findPath("requirementsForEarthWorks").asDouble();
                Double trafficVolume = json.findPath("trafficVolume").asDouble();
                System.out.println(farmToTheMarket);
                String fclass = json.findPath("fclass").asText();
                String layer = json.findPath("layer").asText();
                Integer lengthInMetres = json.findPath("lengthInMetres").asInt();
                String maxspeed = json.findPath("maxspeed").asText();
                String name = json.findPath("name").asText();
                Double numberOfConnections = json.findPath("numberOfConnections").asDouble();
                String oneway = json.findPath("oneway").asText();
                Integer populationServed = json.findPath("populationServed").asInt();
                String ref = json.findPath("ref").asText();
                String roadCondition = json.findPath("roadCondition").asText();
                String source = json.findPath("source").asText();
                boolean tunnelMat = json.findPath("tunnelMat").asBoolean();
                RoadsEntity road = JPA.em().find(RoadsEntity.class, json.findPath("id").asInt());
                road.setAccessToGCsRMs(accessToGCsRMs);
                road.setAgriculturalFacilities(agriculturalFacilities);
                if (bridgeMat) {
                    road.setBridge("T");
                } else {
                    road.setBridge("F");
                }

                road.setTrafficVolume(trafficVolume);
                road.setRequirementsForEarthWorks(requirementsForEarthWorks);
                road.setSafety(safety);
                road.setRoadConditionCriterio(roadConditionCriterio);
                road.setRoadQualityAndNeeds(roadQualityAndNeeds);
                road.setRoadAccessibility(roadAccessibility);
                road.setElevationInMetres(elevationInMetres);
                road.setFacilitiesServed(facilitiesServed.doubleValue());
                road.setFclass(fclass);
                road.setFarmToTheMarket(farmToTheMarket);
                road.setLayer(layer);
                road.setLengthInMetres(lengthInMetres);
                road.setMaxspeed(maxspeed);
                road.setName(name);
                road.setNumberOfConnections(numberOfConnections);
                road.setOneway(oneway);
                road.setPopulationServed(populationServed.doubleValue());
                road.setRef(ref);
                road.setEnvironmentalImpacts(environmentalImpacts);
                road.setSource(source);
                road.setRoadCondition(roadCondition);
                if (tunnelMat) {
                    road.setTunnel("T");
                } else {
                    road.setTunnel("F");
                }
                road.setLinksToMajorActivityCentres(road.getFacilitiesServed()+road.getAccessToGCsRMs());
                road.setConnectivity(connectivity);
                RoadsEntity fixedRoad = removeNullsFromRoad(road);


                JPA.em().merge(fixedRoad);
                result.put("status", "ok");
                result.put("lvrr_id", road.getLvrrId());
                result.put("message", "Road has been updated successfully");
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