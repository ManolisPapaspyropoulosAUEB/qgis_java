package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "operetional_parameters", schema = "afggis_db", catalog = "")
public class OperetionalParametersEntity {
    private int id;
    private Double estimatedMaintenanceCost;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "estimated_maintenance_cost")
    public Double getEstimatedMaintenanceCost() {
        return estimatedMaintenanceCost;
    }

    public void setEstimatedMaintenanceCost(Double estimatedMaintenanceCost) {
        this.estimatedMaintenanceCost = estimatedMaintenanceCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperetionalParametersEntity that = (OperetionalParametersEntity) o;
        return id == that.id &&
                Objects.equals(estimatedMaintenanceCost, that.estimatedMaintenanceCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estimatedMaintenanceCost);
    }
}
