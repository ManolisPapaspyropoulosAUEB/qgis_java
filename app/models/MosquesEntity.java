package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "mosques", schema = "afggis_db", catalog = "")
public class MosquesEntity {
    private int id;
    private Integer targetFid;
    private String name;
    private String type;
    private BigDecimal east;
    private BigDecimal north;
    private Integer eastUtm42;
    private Integer northUtm42;
    private String fromSource;
    private String distName;
    private String altDistName;
    private Integer distCode;
    private Integer proCode;

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
    @Column(name = "target_fid")
    public Integer getTargetFid() {
        return targetFid;
    }

    public void setTargetFid(Integer targetFid) {
        this.targetFid = targetFid;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Basic
    @Column(name = "from_source")
    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
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
    @Column(name = "alt_dist_name")
    public String getAltDistName() {
        return altDistName;
    }

    public void setAltDistName(String altDistName) {
        this.altDistName = altDistName;
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
    @Column(name = "pro_code")
    public Integer getProCode() {
        return proCode;
    }

    public void setProCode(Integer proCode) {
        this.proCode = proCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MosquesEntity that = (MosquesEntity) o;
        return id == that.id &&
                Objects.equals(targetFid, that.targetFid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(east, that.east) &&
                Objects.equals(north, that.north) &&
                Objects.equals(eastUtm42, that.eastUtm42) &&
                Objects.equals(northUtm42, that.northUtm42) &&
                Objects.equals(fromSource, that.fromSource) &&
                Objects.equals(distName, that.distName) &&
                Objects.equals(altDistName, that.altDistName) &&
                Objects.equals(distCode, that.distCode) &&
                Objects.equals(proCode, that.proCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, targetFid, name, type, east, north, eastUtm42, northUtm42, fromSource, distName, altDistName, distCode, proCode);
    }
}
