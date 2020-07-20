package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "districts", schema = "afggis_db", catalog = "")
public class DistrictsEntity {
    private long id;
    private String provinceName;
    private String districtName;
    private String alternativeDistrictName;
    private String permanentTemporary;
    private String districtChanges;
    private Integer numericalProvinceCode;
    private String alphanumericalProvinceCode;
    private Integer numericalDistrictCode;
    private String alphanumericalDistrictCode;
    private String disambiguations;
    private Double xDistance;
    private Double yDistance;
    private Double zoomInfoDistrict;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "district_name")
    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Basic
    @Column(name = "alternative_district_name")
    public String getAlternativeDistrictName() {
        return alternativeDistrictName;
    }

    public void setAlternativeDistrictName(String alternativeDistrictName) {
        this.alternativeDistrictName = alternativeDistrictName;
    }

    @Basic
    @Column(name = "permanent_temporary")
    public String getPermanentTemporary() {
        return permanentTemporary;
    }

    public void setPermanentTemporary(String permanentTemporary) {
        this.permanentTemporary = permanentTemporary;
    }

    @Basic
    @Column(name = "district_changes")
    public String getDistrictChanges() {
        return districtChanges;
    }

    public void setDistrictChanges(String districtChanges) {
        this.districtChanges = districtChanges;
    }

    @Basic
    @Column(name = "numerical_province_code")
    public Integer getNumericalProvinceCode() {
        return numericalProvinceCode;
    }

    public void setNumericalProvinceCode(Integer numericalProvinceCode) {
        this.numericalProvinceCode = numericalProvinceCode;
    }

    @Basic
    @Column(name = "alphanumerical_province_code")
    public String getAlphanumericalProvinceCode() {
        return alphanumericalProvinceCode;
    }

    public void setAlphanumericalProvinceCode(String alphanumericalProvinceCode) {
        this.alphanumericalProvinceCode = alphanumericalProvinceCode;
    }

    @Basic
    @Column(name = "numerical_district_code")
    public Integer getNumericalDistrictCode() {
        return numericalDistrictCode;
    }

    public void setNumericalDistrictCode(Integer numericalDistrictCode) {
        this.numericalDistrictCode = numericalDistrictCode;
    }

    @Basic
    @Column(name = "alphanumerical_district_code")
    public String getAlphanumericalDistrictCode() {
        return alphanumericalDistrictCode;
    }

    public void setAlphanumericalDistrictCode(String alphanumericalDistrictCode) {
        this.alphanumericalDistrictCode = alphanumericalDistrictCode;
    }

    @Basic
    @Column(name = "disambiguations")
    public String getDisambiguations() {
        return disambiguations;
    }

    public void setDisambiguations(String disambiguations) {
        this.disambiguations = disambiguations;
    }

    @Basic
    @Column(name = "x_distance")
    public Double getxDistance() {
        return xDistance;
    }

    public void setxDistance(Double xDistance) {
        this.xDistance = xDistance;
    }

    @Basic
    @Column(name = "y_distance")
    public Double getyDistance() {
        return yDistance;
    }

    public void setyDistance(Double yDistance) {
        this.yDistance = yDistance;
    }

    @Basic
    @Column(name = "zoom_info_district")
    public Double getZoomInfoDistrict() {
        return zoomInfoDistrict;
    }

    public void setZoomInfoDistrict(Double zoomInfoDistrict) {
        this.zoomInfoDistrict = zoomInfoDistrict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistrictsEntity that = (DistrictsEntity) o;
        return id == that.id &&
                Objects.equals(provinceName, that.provinceName) &&
                Objects.equals(districtName, that.districtName) &&
                Objects.equals(alternativeDistrictName, that.alternativeDistrictName) &&
                Objects.equals(permanentTemporary, that.permanentTemporary) &&
                Objects.equals(districtChanges, that.districtChanges) &&
                Objects.equals(numericalProvinceCode, that.numericalProvinceCode) &&
                Objects.equals(alphanumericalProvinceCode, that.alphanumericalProvinceCode) &&
                Objects.equals(numericalDistrictCode, that.numericalDistrictCode) &&
                Objects.equals(alphanumericalDistrictCode, that.alphanumericalDistrictCode) &&
                Objects.equals(disambiguations, that.disambiguations) &&
                Objects.equals(xDistance, that.xDistance) &&
                Objects.equals(yDistance, that.yDistance) &&
                Objects.equals(zoomInfoDistrict, that.zoomInfoDistrict);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, provinceName, districtName, alternativeDistrictName, permanentTemporary, districtChanges, numericalProvinceCode, alphanumericalProvinceCode, numericalDistrictCode, alphanumericalDistrictCode, disambiguations, xDistance, yDistance, zoomInfoDistrict);
    }
}
