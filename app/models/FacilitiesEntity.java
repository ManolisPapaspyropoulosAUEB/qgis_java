package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "facilities", schema = "afggis_db", catalog = "")
public class FacilitiesEntity {
    private int id;
    private Integer districtCode;
    private Integer provinceCode;
    private String districtName;
    private String provinceName;
    private String poiType;
    private String label;
    private String fromSource;
    private BigDecimal east;
    private BigDecimal north;

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
    @Column(name = "district_code")
    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    @Basic
    @Column(name = "province_code")
    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Basic
    @Column(name = "district_name")
    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Basic
    @Column(name = "province_name")
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Basic
    @Column(name = "poi_type")
    public String getPoiType() {
        return poiType;
    }

    public void setPoiType(String poiType) {
        this.poiType = poiType;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "from_source")
    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacilitiesEntity that = (FacilitiesEntity) o;
        return id == that.id &&
                Objects.equals(districtCode, that.districtCode) &&
                Objects.equals(provinceCode, that.provinceCode) &&
                Objects.equals(districtName, that.districtName) &&
                Objects.equals(provinceName, that.provinceName) &&
                Objects.equals(poiType, that.poiType) &&
                Objects.equals(label, that.label) &&
                Objects.equals(fromSource, that.fromSource) &&
                Objects.equals(east, that.east) &&
                Objects.equals(north, that.north);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, districtCode, provinceCode, districtName, provinceName, poiType, label, fromSource, east, north);
    }
}
