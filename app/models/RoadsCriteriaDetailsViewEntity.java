package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roads_criteria_details_view", schema = "afggis_db", catalog = "")
public class RoadsCriteriaDetailsViewEntity {
    private boolean checked;
    private boolean checkedFilter;
    private Double cbiRoutine;
    private Double cbiPeriodic;
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
    private String lvrrId;
    private Double security;
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
    private String c1Id;
    private Double c1Score;
    private String c2Id;
    private Double c2Score;
    private String c3Id;
    private Double c3Score;
    private String c4Id;
    private Double c4Score;
    private String c5Id;
    private Double c5Score;
    private String c6Id;
    private Double c6Score;
    private String c7Id;
    private Double c7Score;
    private String c8Id;
    private Double c8Score;
    private String c9Id;
    private Double c9Score;
    private String c10Id;
    private Double c10Score;
    private String c11Id;
    private Double c11Score;
    private String c12Id;
    private Double c12Score;
    private String c13Id;
    private Double c13Score;
    private String c14Id;
    private Double c14Score;
    private String c15Id;
    private Double c15Score;
    private Double mca;
    private Double cbi1;
    private Double cbi2;
    private Double connectivity;
    private Double roadAccessibility;
    private Double requirementsForEarthWorks;
    private Double trafficVolume;
    private Double safety;
    private Double roadQualityAndNeeds;
    private Double roadConditionCriterio;
    private String accessToGCsRMsLabel;
    private String farmToTheMarketLabel;
    private String agricultureFacilitationLabel;
    private String roadAccessibilityLabel;
    private String numberOfConnectionsLabel;
    private String roadConditionCriterioLabel;
    private String roadQualityAndNeedsLabel;
    private String requirementsForEarthWorksLabel;
    private String trafficVolumeLabel;
    private String safetyLabel;
    private String securityLabel;
    private String environmentalImpactsLabel;
    private Long notesSize;
    private Long docSize;
    private String mcaTypos;
    private String cbi1RoutineTypos;
    private String cbi2PeriodicTypos;

    @Basic
    @Column(name = "checked")
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Basic
    @Column(name = "checked_filter")
    public boolean isCheckedFilter() {
        return checkedFilter;
    }

    public void setCheckedFilter(boolean checkedFilter) {
        this.checkedFilter = checkedFilter;
    }

    @Basic
    @Column(name = "cbi_routine")
    public Double getCbiRoutine() {
        return cbiRoutine;
    }

    public void setCbiRoutine(Double cbiRoutine) {
        this.cbiRoutine = cbiRoutine;
    }

    @Basic
    @Column(name = "cbi_periodic")
    public Double getCbiPeriodic() {
        return cbiPeriodic;
    }

    public void setCbiPeriodic(Double cbiPeriodic) {
        this.cbiPeriodic = cbiPeriodic;
    }

    @Id
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
    public String getLvrrId() {
        return lvrrId;
    }

    public void setLvrrId(String lvrrId) {
        this.lvrrId = lvrrId;
    }

    @Basic
    @Column(name = "security")
    public Double getSecurity() {
        return security;
    }

    public void setSecurity(Double security) {
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
    public String getC1Id() {
        return c1Id;
    }

    public void setC1Id(String c1Id) {
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
    public String getC2Id() {
        return c2Id;
    }

    public void setC2Id(String c2Id) {
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
    public String getC3Id() {
        return c3Id;
    }

    public void setC3Id(String c3Id) {
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
    public String getC4Id() {
        return c4Id;
    }

    public void setC4Id(String c4Id) {
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
    public String getC5Id() {
        return c5Id;
    }

    public void setC5Id(String c5Id) {
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
    public String getC6Id() {
        return c6Id;
    }

    public void setC6Id(String c6Id) {
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
    public String getC7Id() {
        return c7Id;
    }

    public void setC7Id(String c7Id) {
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
    public String getC8Id() {
        return c8Id;
    }

    public void setC8Id(String c8Id) {
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
    public String getC9Id() {
        return c9Id;
    }

    public void setC9Id(String c9Id) {
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
    public String getC10Id() {
        return c10Id;
    }

    public void setC10Id(String c10Id) {
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
    public String getC11Id() {
        return c11Id;
    }

    public void setC11Id(String c11Id) {
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
    public String getC12Id() {
        return c12Id;
    }

    public void setC12Id(String c12Id) {
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
    public String getC13Id() {
        return c13Id;
    }

    public void setC13Id(String c13Id) {
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
    public String getC14Id() {
        return c14Id;
    }

    public void setC14Id(String c14Id) {
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
    public String getC15Id() {
        return c15Id;
    }

    public void setC15Id(String c15Id) {
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
    @Column(name = "cbi_1")
    public Double getCbi1() {
        return cbi1;
    }

    public void setCbi1(Double cbi1) {
        this.cbi1 = cbi1;
    }

    @Basic
    @Column(name = "cbi_2")
    public Double getCbi2() {
        return cbi2;
    }

    public void setCbi2(Double cbi2) {
        this.cbi2 = cbi2;
    }

    @Basic
    @Column(name = "connectivity")
    public Double getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(Double connectivity) {
        this.connectivity = connectivity;
    }

    @Basic
    @Column(name = "road_accessibility")
    public Double getRoadAccessibility() {
        return roadAccessibility;
    }

    public void setRoadAccessibility(Double roadAccessibility) {
        this.roadAccessibility = roadAccessibility;
    }

    @Basic
    @Column(name = "requirements_for_earth_works")
    public Double getRequirementsForEarthWorks() {
        return requirementsForEarthWorks;
    }

    public void setRequirementsForEarthWorks(Double requirementsForEarthWorks) {
        this.requirementsForEarthWorks = requirementsForEarthWorks;
    }

    @Basic
    @Column(name = "traffic_volume")
    public Double getTrafficVolume() {
        return trafficVolume;
    }

    public void setTrafficVolume(Double trafficVolume) {
        this.trafficVolume = trafficVolume;
    }

    @Basic
    @Column(name = "safety")
    public Double getSafety() {
        return safety;
    }

    public void setSafety(Double safety) {
        this.safety = safety;
    }

    @Basic
    @Column(name = "road_quality_and_needs")
    public Double getRoadQualityAndNeeds() {
        return roadQualityAndNeeds;
    }

    public void setRoadQualityAndNeeds(Double roadQualityAndNeeds) {
        this.roadQualityAndNeeds = roadQualityAndNeeds;
    }

    @Basic
    @Column(name = "road_condition_criterio")
    public Double getRoadConditionCriterio() {
        return roadConditionCriterio;
    }

    public void setRoadConditionCriterio(Double roadConditionCriterio) {
        this.roadConditionCriterio = roadConditionCriterio;
    }

    @Basic
    @Column(name = "access_to_GCs_RMs_label")
    public String getAccessToGCsRMsLabel() {
        return accessToGCsRMsLabel;
    }

    public void setAccessToGCsRMsLabel(String accessToGCsRMsLabel) {
        this.accessToGCsRMsLabel = accessToGCsRMsLabel;
    }

    @Basic
    @Column(name = "farm_to_the_market_label")
    public String getFarmToTheMarketLabel() {
        return farmToTheMarketLabel;
    }

    public void setFarmToTheMarketLabel(String farmToTheMarketLabel) {
        this.farmToTheMarketLabel = farmToTheMarketLabel;
    }

    @Basic
    @Column(name = "agriculture_facilitation_label")
    public String getAgricultureFacilitationLabel() {
        return agricultureFacilitationLabel;
    }

    public void setAgricultureFacilitationLabel(String agricultureFacilitationLabel) {
        this.agricultureFacilitationLabel = agricultureFacilitationLabel;
    }

    @Basic
    @Column(name = "road_accessibility_label")
    public String getRoadAccessibilityLabel() {
        return roadAccessibilityLabel;
    }

    public void setRoadAccessibilityLabel(String roadAccessibilityLabel) {
        this.roadAccessibilityLabel = roadAccessibilityLabel;
    }

    @Basic
    @Column(name = "number_of_connections_label")
    public String getNumberOfConnectionsLabel() {
        return numberOfConnectionsLabel;
    }

    public void setNumberOfConnectionsLabel(String numberOfConnectionsLabel) {
        this.numberOfConnectionsLabel = numberOfConnectionsLabel;
    }

    @Basic
    @Column(name = "road_condition_criterio_label")
    public String getRoadConditionCriterioLabel() {
        return roadConditionCriterioLabel;
    }

    public void setRoadConditionCriterioLabel(String roadConditionCriterioLabel) {
        this.roadConditionCriterioLabel = roadConditionCriterioLabel;
    }

    @Basic
    @Column(name = "road_quality_and_needs_label")
    public String getRoadQualityAndNeedsLabel() {
        return roadQualityAndNeedsLabel;
    }

    public void setRoadQualityAndNeedsLabel(String roadQualityAndNeedsLabel) {
        this.roadQualityAndNeedsLabel = roadQualityAndNeedsLabel;
    }

    @Basic
    @Column(name = "requirements_for_earth_works_label")
    public String getRequirementsForEarthWorksLabel() {
        return requirementsForEarthWorksLabel;
    }

    public void setRequirementsForEarthWorksLabel(String requirementsForEarthWorksLabel) {
        this.requirementsForEarthWorksLabel = requirementsForEarthWorksLabel;
    }

    @Basic
    @Column(name = "traffic_volume_label")
    public String getTrafficVolumeLabel() {
        return trafficVolumeLabel;
    }

    public void setTrafficVolumeLabel(String trafficVolumeLabel) {
        this.trafficVolumeLabel = trafficVolumeLabel;
    }

    @Basic
    @Column(name = "safety_label")
    public String getSafetyLabel() {
        return safetyLabel;
    }

    public void setSafetyLabel(String safetyLabel) {
        this.safetyLabel = safetyLabel;
    }

    @Basic
    @Column(name = "security_label")
    public String getSecurityLabel() {
        return securityLabel;
    }

    public void setSecurityLabel(String securityLabel) {
        this.securityLabel = securityLabel;
    }

    @Basic
    @Column(name = "environmental_impacts_label")
    public String getEnvironmentalImpactsLabel() {
        return environmentalImpactsLabel;
    }

    public void setEnvironmentalImpactsLabel(String environmentalImpactsLabel) {
        this.environmentalImpactsLabel = environmentalImpactsLabel;
    }

    @Basic
    @Column(name = "notes_size")
    public Long getNotesSize() {
        return notesSize;
    }

    public void setNotesSize(Long notesSize) {
        this.notesSize = notesSize;
    }

    @Basic
    @Column(name = "doc_size")
    public Long getDocSize() {
        return docSize;
    }

    public void setDocSize(Long docSize) {
        this.docSize = docSize;
    }

    @Basic
    @Column(name = "mca_Typos")
    public String getMcaTypos() {
        return mcaTypos;
    }

    public void setMcaTypos(String mcaTypos) {
        this.mcaTypos = mcaTypos;
    }

    @Basic
    @Column(name = "CBI1_ROUTINE_TYPOS")
    public String getCbi1RoutineTypos() {
        return cbi1RoutineTypos;
    }

    public void setCbi1RoutineTypos(String cbi1RoutineTypos) {
        this.cbi1RoutineTypos = cbi1RoutineTypos;
    }

    @Basic
    @Column(name = "CBI2_PERIODIC_TYPOS")
    public String getCbi2PeriodicTypos() {
        return cbi2PeriodicTypos;
    }

    public void setCbi2PeriodicTypos(String cbi2PeriodicTypos) {
        this.cbi2PeriodicTypos = cbi2PeriodicTypos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadsCriteriaDetailsViewEntity that = (RoadsCriteriaDetailsViewEntity) o;
        return checked == that.checked &&
                checkedFilter == that.checkedFilter &&
                id == that.id &&
                Objects.equals(cbiRoutine, that.cbiRoutine) &&
                Objects.equals(cbiPeriodic, that.cbiPeriodic) &&
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
                Objects.equals(cbi1, that.cbi1) &&
                Objects.equals(cbi2, that.cbi2) &&
                Objects.equals(connectivity, that.connectivity) &&
                Objects.equals(roadAccessibility, that.roadAccessibility) &&
                Objects.equals(requirementsForEarthWorks, that.requirementsForEarthWorks) &&
                Objects.equals(trafficVolume, that.trafficVolume) &&
                Objects.equals(safety, that.safety) &&
                Objects.equals(roadQualityAndNeeds, that.roadQualityAndNeeds) &&
                Objects.equals(roadConditionCriterio, that.roadConditionCriterio) &&
                Objects.equals(accessToGCsRMsLabel, that.accessToGCsRMsLabel) &&
                Objects.equals(farmToTheMarketLabel, that.farmToTheMarketLabel) &&
                Objects.equals(agricultureFacilitationLabel, that.agricultureFacilitationLabel) &&
                Objects.equals(roadAccessibilityLabel, that.roadAccessibilityLabel) &&
                Objects.equals(numberOfConnectionsLabel, that.numberOfConnectionsLabel) &&
                Objects.equals(roadConditionCriterioLabel, that.roadConditionCriterioLabel) &&
                Objects.equals(roadQualityAndNeedsLabel, that.roadQualityAndNeedsLabel) &&
                Objects.equals(requirementsForEarthWorksLabel, that.requirementsForEarthWorksLabel) &&
                Objects.equals(trafficVolumeLabel, that.trafficVolumeLabel) &&
                Objects.equals(safetyLabel, that.safetyLabel) &&
                Objects.equals(securityLabel, that.securityLabel) &&
                Objects.equals(environmentalImpactsLabel, that.environmentalImpactsLabel) &&
                Objects.equals(notesSize, that.notesSize) &&
                Objects.equals(docSize, that.docSize) &&
                Objects.equals(mcaTypos, that.mcaTypos) &&
                Objects.equals(cbi1RoutineTypos, that.cbi1RoutineTypos) &&
                Objects.equals(cbi2PeriodicTypos, that.cbi2PeriodicTypos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checked, checkedFilter, cbiRoutine, cbiPeriodic, id, osmId, code, fclass, name, ref, oneway, maxspeed, layer, bridge, tunnel, district, source, roadWidthInM, roadCondition, maxRoadSteepnessPrc, roadsideEnvironment, agricultureFacilitation, commentsOnConnections, lengthOfRoadStretchInM, averageElevationInMAboveSealevel, averagePopulationInPersons, lvrrId, security, environmentalImpacts, districtId, lengthInMetres, widthInMetres, elevationInMetres, populationServed, facilitiesServed, accessToGCsRMs, farmToTheMarket, agriculturalFacilities, linksToMajorActivityCentres, numberOfConnections, c1Id, c1Score, c2Id, c2Score, c3Id, c3Score, c4Id, c4Score, c5Id, c5Score, c6Id, c6Score, c7Id, c7Score, c8Id, c8Score, c9Id, c9Score, c10Id, c10Score, c11Id, c11Score, c12Id, c12Score, c13Id, c13Score, c14Id, c14Score, c15Id, c15Score, mca, cbi1, cbi2, connectivity, roadAccessibility, requirementsForEarthWorks, trafficVolume, safety, roadQualityAndNeeds, roadConditionCriterio, accessToGCsRMsLabel, farmToTheMarketLabel, agricultureFacilitationLabel, roadAccessibilityLabel, numberOfConnectionsLabel, roadConditionCriterioLabel, roadQualityAndNeedsLabel, requirementsForEarthWorksLabel, trafficVolumeLabel, safetyLabel, securityLabel, environmentalImpactsLabel, notesSize, docSize, mcaTypos, cbi1RoutineTypos, cbi2PeriodicTypos);
    }
}
