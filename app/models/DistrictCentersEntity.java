package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "district_centers", schema = "afggis_db", catalog = "")
public class DistrictCentersEntity {
    private int id;
    private String proName;
    private String proCenter;
    private Integer proCode;
    private String distName;
    private Integer distCode;
    private String centerType;
    private BigDecimal east;
    private BigDecimal north;
    private Integer eastUtm42;
    private Integer northUtm42;

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
    @Column(name = "pro_name")
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Basic
    @Column(name = "pro_center")
    public String getProCenter() {
        return proCenter;
    }

    public void setProCenter(String proCenter) {
        this.proCenter = proCenter;
    }

    @Basic
    @Column(name = "pro_code")
    public Integer getProCode() {
        return proCode;
    }

    public void setProCode(Integer proCode) {
        this.proCode = proCode;
    }

    @Basic
    @Column(name = "dist_name")
    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    @Basic
    @Column(name = "dist_code")
    public Integer getDistCode() {
        return distCode;
    }

    public void setDistCode(Integer distCode) {
        this.distCode = distCode;
    }

    @Basic
    @Column(name = "center_type")
    public String getCenterType() {
        return centerType;
    }

    public void setCenterType(String centerType) {
        this.centerType = centerType;
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
        DistrictCentersEntity that = (DistrictCentersEntity) o;
        return id == that.id &&
                Objects.equals(proName, that.proName) &&
                Objects.equals(proCenter, that.proCenter) &&
                Objects.equals(proCode, that.proCode) &&
                Objects.equals(distName, that.distName) &&
                Objects.equals(distCode, that.distCode) &&
                Objects.equals(centerType, that.centerType) &&
                Objects.equals(east, that.east) &&
                Objects.equals(north, that.north) &&
                Objects.equals(eastUtm42, that.eastUtm42) &&
                Objects.equals(northUtm42, that.northUtm42);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proName, proCenter, proCode, distName, distCode, centerType, east, north, eastUtm42, northUtm42);
    }
}
