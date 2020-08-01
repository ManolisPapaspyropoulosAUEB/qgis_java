package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roads", schema = "afggis_db", catalog = "")
public class RoadsEntity {
    private int id;
    private String osmId;
    private String code;
    private String fclass;
    private String name;
    private String ref;
    private String oneway;
    private String maxspeed;
    private String layer;
    private String bridge;
    private String tunnel;
    private String district;
    private String source;
    private Integer roadWidthInM;
    private String roadCondition;
    private Integer maxRoadSteepnessPrc;
    private String roadsideEnvironment;
    private String agricultureFacilitation;
    private String commentsOnConnections;
    private Integer lengthOfRoadStretchInM;
    private Integer averageElevationInMAboveSealevel;
    private String averagePopulationInPersons;
    private Integer lvrrId;
    private Integer security;
    private Integer environmentalImpacts;
    private Integer districtId;
    private Integer lengthInMetres;
    private Integer widthInMetres;
    private Integer elevationInMetres;
    private Double populationServed;
    private Double facilitiesServed;
    private Double accessToGCsRMs;
    private Double farmToTheMarket;
    private Double agriculturalFacilities;
    private Double linksToMajorActivityCentres;
    private Double numberOfConnections;
    private Integer c1Id;
    private Double c1Score;
    private Integer c2Id;
    private Double c2Score;
    private Integer c3Id;
    private Double c3Score;
    private Integer c4Id;
    private Double c4Score;
    private Integer c5Id;
    private Double c5Score;
    private Integer c6Id;
    private Double c6Score;
    private Integer c7Id;
    private Double c7Score;
    private Integer c8Id;
    private Double c8Score;
    private Integer c9Id;
    private Double c9Score;
    private Integer c10Id;
    private Double c10Score;
    private Integer c11Id;
    private Double c11Score;
    private Integer c12Id;
    private Double c12Score;
    private Integer c13Id;
    private Double c13Score;
    private Integer c14Id;
    private Double c14Score;
    private Integer c15Id;
    private Double c15Score;
    private Double mca;
    private Double cbi;
    private Double connectivity;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "osm_id")
    public String getOsmId() {
        return osmId;
    }

    public void setOsmId(String osmId) {
        this.osmId = osmId;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "fclass")
    public String getFclass() {
        return fclass;
    }

    public void setFclass(String fclass) {
        this.fclass = fclass;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ref")
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Basic
    @Column(name = "oneway")
    public String getOneway() {
        return oneway;
    }

    public void setOneway(String oneway) {
        this.oneway = oneway;
    }

    @Basic
    @Column(name = "maxspeed")
    public String getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(String maxspeed) {
        this.maxspeed = maxspeed;
    }

    @Basic
    @Column(name = "layer")
    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    @Basic
    @Column(name = "bridge")
    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    @Basic
    @Column(name = "tunnel")
    public String getTunnel() {
        return tunnel;
    }

    public void setTunnel(String tunnel) {
        this.tunnel = tunnel;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "road_width_in_m")
    public Integer getRoadWidthInM() {
        return roadWidthInM;
    }

    public void setRoadWidthInM(Integer roadWidthInM) {
        this.roadWidthInM = roadWidthInM;
    }

    @Basic
    @Column(name = "road_condition")
    public String getRoadCondition() {
        return roadCondition;
    }

    public void setRoadCondition(String roadCondition) {
        this.roadCondition = roadCondition;
    }

    @Basic
    @Column(name = "max_road_steepness_prc")
    public Integer getMaxRoadSteepnessPrc() {
        return maxRoadSteepnessPrc;
    }

    public void setMaxRoadSteepnessPrc(Integer maxRoadSteepnessPrc) {
        this.maxRoadSteepnessPrc = maxRoadSteepnessPrc;
    }

    @Basic
    @Column(name = "roadside_environment")
    public String getRoadsideEnvironment() {
        return roadsideEnvironment;
    }

    public void setRoadsideEnvironment(String roadsideEnvironment) {
        this.roadsideEnvironment = roadsideEnvironment;
    }

    @Basic
    @Column(name = "agriculture_facilitation")
    public String getAgricultureFacilitation() {
        return agricultureFacilitation;
    }

    public void setAgricultureFacilitation(String agricultureFacilitation) {
        this.agricultureFacilitation = agricultureFacilitation;
    }

    @Basic
    @Column(name = "comments_on_connections")
    public String getCommentsOnConnections() {
        return commentsOnConnections;
    }

    public void setCommentsOnConnections(String commentsOnConnections) {
        this.commentsOnConnections = commentsOnConnections;
    }

    @Basic
    @Column(name = "length_of_road_stretch_in_m")
    public Integer getLengthOfRoadStretchInM() {
        return lengthOfRoadStretchInM;
    }

    public void setLengthOfRoadStretchInM(Integer lengthOfRoadStretchInM) {
        this.lengthOfRoadStretchInM = lengthOfRoadStretchInM;
    }

    @Basic
    @Column(name = "average_elevation_in_m_above_sealevel")
    public Integer getAverageElevationInMAboveSealevel() {
        return averageElevationInMAboveSealevel;
    }

    public void setAverageElevationInMAboveSealevel(Integer averageElevationInMAboveSealevel) {
        this.averageElevationInMAboveSealevel = averageElevationInMAboveSealevel;
    }

    @Basic
    @Column(name = "average_population_in_persons")
    public String getAveragePopulationInPersons() {
        return averagePopulationInPersons;
    }

    public void setAveragePopulationInPersons(String averagePopulationInPersons) {
        this.averagePopulationInPersons = averagePopulationInPersons;
    }

    @Basic
    @Column(name = "lvrr_id")
    public Integer getLvrrId() {
        return lvrrId;
    }

    public void setLvrrId(Integer lvrrId) {
        this.lvrrId = lvrrId;
    }

    @Basic
    @Column(name = "security")
    public Integer getSecurity() {
        return security;
    }

    public void setSecurity(Integer security) {
        this.security = security;
    }

    @Basic
    @Column(name = "environmental_impacts")
    public Integer getEnvironmentalImpacts() {
        return environmentalImpacts;
    }

    public void setEnvironmentalImpacts(Integer environmentalImpacts) {
        this.environmentalImpacts = environmentalImpacts;
    }

    @Basic
    @Column(name = "district_id")
    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    @Basic
    @Column(name = "length_in_metres")
    public Integer getLengthInMetres() {
        return lengthInMetres;
    }

    public void setLengthInMetres(Integer lengthInMetres) {
        this.lengthInMetres = lengthInMetres;
    }

    @Basic
    @Column(name = "width_in_metres")
    public Integer getWidthInMetres() {
        return widthInMetres;
    }

    public void setWidthInMetres(Integer widthInMetres) {
        this.widthInMetres = widthInMetres;
    }

    @Basic
    @Column(name = "elevation_in_metres")
    public Integer getElevationInMetres() {
        return elevationInMetres;
    }

    public void setElevationInMetres(Integer elevationInMetres) {
        this.elevationInMetres = elevationInMetres;
    }

    @Basic
    @Column(name = "population_served")
    public Double getPopulationServed() {
        return populationServed;
    }

    public void setPopulationServed(Double populationServed) {
        this.populationServed = populationServed;
    }

    @Basic
    @Column(name = "facilities_served")
    public Double getFacilitiesServed() {
        return facilitiesServed;
    }

    public void setFacilitiesServed(Double facilitiesServed) {
        this.facilitiesServed = facilitiesServed;
    }

    @Basic
    @Column(name = "access_to_GCsRMs")
    public Double getAccessToGCsRMs() {
        return accessToGCsRMs;
    }

    public void setAccessToGCsRMs(Double accessToGCsRMs) {
        this.accessToGCsRMs = accessToGCsRMs;
    }

    @Basic
    @Column(name = "farm_to_the_Market")
    public Double getFarmToTheMarket() {
        return farmToTheMarket;
    }

    public void setFarmToTheMarket(Double farmToTheMarket) {
        this.farmToTheMarket = farmToTheMarket;
    }

    @Basic
    @Column(name = "agricultural_Facilities")
    public Double getAgriculturalFacilities() {
        return agriculturalFacilities;
    }

    public void setAgriculturalFacilities(Double agriculturalFacilities) {
        this.agriculturalFacilities = agriculturalFacilities;
    }

    @Basic
    @Column(name = "links_to_major_activity_centres")
    public Double getLinksToMajorActivityCentres() {
        return linksToMajorActivityCentres;
    }

    public void setLinksToMajorActivityCentres(Double linksToMajorActivityCentres) {
        this.linksToMajorActivityCentres = linksToMajorActivityCentres;
    }

    @Basic
    @Column(name = "number_of_connections")
    public Double getNumberOfConnections() {
        return numberOfConnections;
    }

    public void setNumberOfConnections(Double numberOfConnections) {
        this.numberOfConnections = numberOfConnections;
    }

    @Basic
    @Column(name = "c1_id")
    public Integer getC1Id() {
        return c1Id;
    }

    public void setC1Id(Integer c1Id) {
        this.c1Id = c1Id;
    }

    @Basic
    @Column(name = "c1_score")
    public Double getC1Score() {
        return c1Score;
    }

    public void setC1Score(Double c1Score) {
        this.c1Score = c1Score;
    }

    @Basic
    @Column(name = "c2_id")
    public Integer getC2Id() {
        return c2Id;
    }

    public void setC2Id(Integer c2Id) {
        this.c2Id = c2Id;
    }

    @Basic
    @Column(name = "c2_score")
    public Double getC2Score() {
        return c2Score;
    }

    public void setC2Score(Double c2Score) {
        this.c2Score = c2Score;
    }

    @Basic
    @Column(name = "c3_id")
    public Integer getC3Id() {
        return c3Id;
    }

    public void setC3Id(Integer c3Id) {
        this.c3Id = c3Id;
    }

    @Basic
    @Column(name = "c3_score")
    public Double getC3Score() {
        return c3Score;
    }

    public void setC3Score(Double c3Score) {
        this.c3Score = c3Score;
    }

    @Basic
    @Column(name = "c4_id")
    public Integer getC4Id() {
        return c4Id;
    }

    public void setC4Id(Integer c4Id) {
        this.c4Id = c4Id;
    }

    @Basic
    @Column(name = "c4_score")
    public Double getC4Score() {
        return c4Score;
    }

    public void setC4Score(Double c4Score) {
        this.c4Score = c4Score;
    }

    @Basic
    @Column(name = "c5_id")
    public Integer getC5Id() {
        return c5Id;
    }

    public void setC5Id(Integer c5Id) {
        this.c5Id = c5Id;
    }

    @Basic
    @Column(name = "c5_score")
    public Double getC5Score() {
        return c5Score;
    }

    public void setC5Score(Double c5Score) {
        this.c5Score = c5Score;
    }

    @Basic
    @Column(name = "c6_id")
    public Integer getC6Id() {
        return c6Id;
    }

    public void setC6Id(Integer c6Id) {
        this.c6Id = c6Id;
    }

    @Basic
    @Column(name = "c6_score")
    public Double getC6Score() {
        return c6Score;
    }

    public void setC6Score(Double c6Score) {
        this.c6Score = c6Score;
    }

    @Basic
    @Column(name = "c7_id")
    public Integer getC7Id() {
        return c7Id;
    }

    public void setC7Id(Integer c7Id) {
        this.c7Id = c7Id;
    }

    @Basic
    @Column(name = "c7_score")
    public Double getC7Score() {
        return c7Score;
    }

    public void setC7Score(Double c7Score) {
        this.c7Score = c7Score;
    }

    @Basic
    @Column(name = "c8_id")
    public Integer getC8Id() {
        return c8Id;
    }

    public void setC8Id(Integer c8Id) {
        this.c8Id = c8Id;
    }

    @Basic
    @Column(name = "c8_score")
    public Double getC8Score() {
        return c8Score;
    }

    public void setC8Score(Double c8Score) {
        this.c8Score = c8Score;
    }

    @Basic
    @Column(name = "c9_id")
    public Integer getC9Id() {
        return c9Id;
    }

    public void setC9Id(Integer c9Id) {
        this.c9Id = c9Id;
    }

    @Basic
    @Column(name = "c9_score")
    public Double getC9Score() {
        return c9Score;
    }

    public void setC9Score(Double c9Score) {
        this.c9Score = c9Score;
    }

    @Basic
    @Column(name = "c10_id")
    public Integer getC10Id() {
        return c10Id;
    }

    public void setC10Id(Integer c10Id) {
        this.c10Id = c10Id;
    }

    @Basic
    @Column(name = "c10_score")
    public Double getC10Score() {
        return c10Score;
    }

    public void setC10Score(Double c10Score) {
        this.c10Score = c10Score;
    }

    @Basic
    @Column(name = "c11_id")
    public Integer getC11Id() {
        return c11Id;
    }

    public void setC11Id(Integer c11Id) {
        this.c11Id = c11Id;
    }

    @Basic
    @Column(name = "c11_score")
    public Double getC11Score() {
        return c11Score;
    }

    public void setC11Score(Double c11Score) {
        this.c11Score = c11Score;
    }

    @Basic
    @Column(name = "c12_id")
    public Integer getC12Id() {
        return c12Id;
    }

    public void setC12Id(Integer c12Id) {
        this.c12Id = c12Id;
    }

    @Basic
    @Column(name = "c12_score")
    public Double getC12Score() {
        return c12Score;
    }

    public void setC12Score(Double c12Score) {
        this.c12Score = c12Score;
    }

    @Basic
    @Column(name = "c13_id")
    public Integer getC13Id() {
        return c13Id;
    }

    public void setC13Id(Integer c13Id) {
        this.c13Id = c13Id;
    }

    @Basic
    @Column(name = "c13_score")
    public Double getC13Score() {
        return c13Score;
    }

    public void setC13Score(Double c13Score) {
        this.c13Score = c13Score;
    }

    @Basic
    @Column(name = "c14_id")
    public Integer getC14Id() {
        return c14Id;
    }

    public void setC14Id(Integer c14Id) {
        this.c14Id = c14Id;
    }

    @Basic
    @Column(name = "c14_score")
    public Double getC14Score() {
        return c14Score;
    }

    public void setC14Score(Double c14Score) {
        this.c14Score = c14Score;
    }

    @Basic
    @Column(name = "c15_id")
    public Integer getC15Id() {
        return c15Id;
    }

    public void setC15Id(Integer c15Id) {
        this.c15Id = c15Id;
    }

    @Basic
    @Column(name = "c15_score")
    public Double getC15Score() {
        return c15Score;
    }

    public void setC15Score(Double c15Score) {
        this.c15Score = c15Score;
    }

    @Basic
    @Column(name = "mca")
    public Double getMca() {
        return mca;
    }

    public void setMca(Double mca) {
        this.mca = mca;
    }

    @Basic
    @Column(name = "cbi")
    public Double getCbi() {
        return cbi;
    }

    public void setCbi(Double cbi) {
        this.cbi = cbi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadsEntity that = (RoadsEntity) o;
        return id == that.id &&
                Objects.equals(osmId, that.osmId) &&
                Objects.equals(code, that.code) &&
                Objects.equals(fclass, that.fclass) &&
                Objects.equals(name, that.name) &&
                Objects.equals(ref, that.ref) &&
                Objects.equals(oneway, that.oneway) &&
                Objects.equals(maxspeed, that.maxspeed) &&
                Objects.equals(layer, that.layer) &&
                Objects.equals(bridge, that.bridge) &&
                Objects.equals(tunnel, that.tunnel) &&
                Objects.equals(district, that.district) &&
                Objects.equals(source, that.source) &&
                Objects.equals(roadWidthInM, that.roadWidthInM) &&
                Objects.equals(roadCondition, that.roadCondition) &&
                Objects.equals(maxRoadSteepnessPrc, that.maxRoadSteepnessPrc) &&
                Objects.equals(roadsideEnvironment, that.roadsideEnvironment) &&
                Objects.equals(agricultureFacilitation, that.agricultureFacilitation) &&
                Objects.equals(commentsOnConnections, that.commentsOnConnections) &&
                Objects.equals(lengthOfRoadStretchInM, that.lengthOfRoadStretchInM) &&
                Objects.equals(averageElevationInMAboveSealevel, that.averageElevationInMAboveSealevel) &&
                Objects.equals(averagePopulationInPersons, that.averagePopulationInPersons) &&
                Objects.equals(lvrrId, that.lvrrId) &&
                Objects.equals(security, that.security) &&
                Objects.equals(environmentalImpacts, that.environmentalImpacts) &&
                Objects.equals(districtId, that.districtId) &&
                Objects.equals(lengthInMetres, that.lengthInMetres) &&
                Objects.equals(widthInMetres, that.widthInMetres) &&
                Objects.equals(elevationInMetres, that.elevationInMetres) &&
                Objects.equals(populationServed, that.populationServed) &&
                Objects.equals(facilitiesServed, that.facilitiesServed) &&
                Objects.equals(accessToGCsRMs, that.accessToGCsRMs) &&
                Objects.equals(farmToTheMarket, that.farmToTheMarket) &&
                Objects.equals(agriculturalFacilities, that.agriculturalFacilities) &&
                Objects.equals(linksToMajorActivityCentres, that.linksToMajorActivityCentres) &&
                Objects.equals(numberOfConnections, that.numberOfConnections) &&
                Objects.equals(c1Id, that.c1Id) &&
                Objects.equals(c1Score, that.c1Score) &&
                Objects.equals(c2Id, that.c2Id) &&
                Objects.equals(c2Score, that.c2Score) &&
                Objects.equals(c3Id, that.c3Id) &&
                Objects.equals(c3Score, that.c3Score) &&
                Objects.equals(c4Id, that.c4Id) &&
                Objects.equals(c4Score, that.c4Score) &&
                Objects.equals(c5Id, that.c5Id) &&
                Objects.equals(c5Score, that.c5Score) &&
                Objects.equals(c6Id, that.c6Id) &&
                Objects.equals(c6Score, that.c6Score) &&
                Objects.equals(c7Id, that.c7Id) &&
                Objects.equals(c7Score, that.c7Score) &&
                Objects.equals(c8Id, that.c8Id) &&
                Objects.equals(c8Score, that.c8Score) &&
                Objects.equals(c9Id, that.c9Id) &&
                Objects.equals(c9Score, that.c9Score) &&
                Objects.equals(c10Id, that.c10Id) &&
                Objects.equals(c10Score, that.c10Score) &&
                Objects.equals(c11Id, that.c11Id) &&
                Objects.equals(c11Score, that.c11Score) &&
                Objects.equals(c12Id, that.c12Id) &&
                Objects.equals(c12Score, that.c12Score) &&
                Objects.equals(c13Id, that.c13Id) &&
                Objects.equals(c13Score, that.c13Score) &&
                Objects.equals(c14Id, that.c14Id) &&
                Objects.equals(c14Score, that.c14Score) &&
                Objects.equals(c15Id, that.c15Id) &&
                Objects.equals(c15Score, that.c15Score) &&
                Objects.equals(mca, that.mca) &&
                Objects.equals(cbi, that.cbi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, osmId, code, fclass, name, ref, oneway, maxspeed, layer, bridge, tunnel, district, source, roadWidthInM, roadCondition, maxRoadSteepnessPrc, roadsideEnvironment, agricultureFacilitation, commentsOnConnections, lengthOfRoadStretchInM, averageElevationInMAboveSealevel, averagePopulationInPersons, lvrrId, security, environmentalImpacts, districtId, lengthInMetres, widthInMetres, elevationInMetres, populationServed, facilitiesServed, accessToGCsRMs, farmToTheMarket, agriculturalFacilities, linksToMajorActivityCentres, numberOfConnections, c1Id, c1Score, c2Id, c2Score, c3Id, c3Score, c4Id, c4Score, c5Id, c5Score, c6Id, c6Score, c7Id, c7Score, c8Id, c8Score, c9Id, c9Score, c10Id, c10Score, c11Id, c11Score, c12Id, c12Score, c13Id, c13Score, c14Id, c14Score, c15Id, c15Score, mca, cbi);
    }

    @Basic
    @Column(name = "connectivity")
    public Double getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(Double connectivity) {
        this.connectivity = connectivity;
    }
}
