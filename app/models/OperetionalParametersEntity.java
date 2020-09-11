package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "operetional_parameters", schema = "afggis_db", catalog = "")
public class OperetionalParametersEntity {
    private int id;
    private Double estimatedRoutineMaintenanceCost;
    private Double estimatedPeriodicMaintenanceCost;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "estimated_routine_maintenance_cost")
    public Double getEstimatedRoutineMaintenanceCost() {
        return estimatedRoutineMaintenanceCost;
    }

    public void setEstimatedRoutineMaintenanceCost(Double estimatedRoutineMaintenanceCost) {
        this.estimatedRoutineMaintenanceCost = estimatedRoutineMaintenanceCost;
    }

    @Basic
    @Column(name = "estimated_periodic_maintenance_cost")
    public Double getEstimatedPeriodicMaintenanceCost() {
        return estimatedPeriodicMaintenanceCost;
    }

    public void setEstimatedPeriodicMaintenanceCost(Double estimatedPeriodicMaintenanceCost) {
        this.estimatedPeriodicMaintenanceCost = estimatedPeriodicMaintenanceCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperetionalParametersEntity that = (OperetionalParametersEntity) o;
        return id == that.id &&
                Objects.equals(estimatedRoutineMaintenanceCost, that.estimatedRoutineMaintenanceCost) &&
                Objects.equals(estimatedPeriodicMaintenanceCost, that.estimatedPeriodicMaintenanceCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estimatedRoutineMaintenanceCost, estimatedPeriodicMaintenanceCost);
    }
}
