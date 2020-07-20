package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "villages", schema = "afggis_db", catalog = "")
public class VillagesEntity {
    private int id;
    private Integer villageCo;
    private String village1;
    private int proCode;
    private int distCode;
    private BigDecimal mapLong;
    private BigDecimal mapLat;
    private Integer villagePop;
    private Integer villageHh;
    private BigDecimal east;
    private BigDecimal north;
    private Integer eastUtm42;
    private Integer northUtm42;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "village_co")
    public Integer getVillageCo() {
        return villageCo;
    }

    public void setVillageCo(Integer villageCo) {
        this.villageCo = villageCo;
    }

    @Basic
    @Column(name = "village_1")
    public String getVillage1() {
        return village1;
    }

    public void setVillage1(String village1) {
        this.village1 = village1;
    }

    @Basic
    @Column(name = "pro_code")
    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    @Basic
    @Column(name = "dist_code")
    public int getDistCode() {
        return distCode;
    }

    public void setDistCode(int distCode) {
        this.distCode = distCode;
    }

    @Basic
    @Column(name = "map_long")
    public BigDecimal getMapLong() {
        return mapLong;
    }

    public void setMapLong(BigDecimal mapLong) {
        this.mapLong = mapLong;
    }

    @Basic
    @Column(name = "map_lat")
    public BigDecimal getMapLat() {
        return mapLat;
    }

    public void setMapLat(BigDecimal mapLat) {
        this.mapLat = mapLat;
    }

    @Basic
    @Column(name = "village_pop")
    public Integer getVillagePop() {
        return villagePop;
    }

    public void setVillagePop(Integer villagePop) {
        this.villagePop = villagePop;
    }

    @Basic
    @Column(name = "village_hh")
    public Integer getVillageHh() {
        return villageHh;
    }

    public void setVillageHh(Integer villageHh) {
        this.villageHh = villageHh;
    }

    @Basic
    @Column(name = "east")
    public BigDecimal getEast() {
        return east;
    }

    public void setEast(BigDecimal east) {
        this.east = east;
    }

    @Basic
    @Column(name = "north")
    public BigDecimal getNorth() {
        return north;
    }

    public void setNorth(BigDecimal north) {
        this.north = north;
    }

    @Basic
    @Column(name = "east_utm42")
    public Integer getEastUtm42() {
        return eastUtm42;
    }

    public void setEastUtm42(Integer eastUtm42) {
        this.eastUtm42 = eastUtm42;
    }

    @Basic
    @Column(name = "north_utm42")
    public Integer getNorthUtm42() {
        return northUtm42;
    }

    public void setNorthUtm42(Integer northUtm42) {
        this.northUtm42 = northUtm42;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VillagesEntity that = (VillagesEntity) o;
        return id == that.id &&
                proCode == that.proCode &&
                distCode == that.distCode &&
                Objects.equals(villageCo, that.villageCo) &&
                Objects.equals(village1, that.village1) &&
                Objects.equals(mapLong, that.mapLong) &&
                Objects.equals(mapLat, that.mapLat) &&
                Objects.equals(villagePop, that.villagePop) &&
                Objects.equals(villageHh, that.villageHh) &&
                Objects.equals(east, that.east) &&
                Objects.equals(north, that.north) &&
                Objects.equals(eastUtm42, that.eastUtm42) &&
                Objects.equals(northUtm42, that.northUtm42);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, villageCo, village1, proCode, distCode, mapLong, mapLat, villagePop, villageHh, east, north, eastUtm42, northUtm42);
    }
}
