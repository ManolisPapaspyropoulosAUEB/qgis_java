package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "criteria_master_details", schema = "afggis_db", catalog = "")
public class CriteriaMasterDetailsEntity {
    private int id;
    private String label;
    private int criteriaMasterId;
    private int order;
    private double score;
    private int activeInd;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "criteria_master_id")
    public int getCriteriaMasterId() {
        return criteriaMasterId;
    }

    public void setCriteriaMasterId(int criteriaMasterId) {
        this.criteriaMasterId = criteriaMasterId;
    }

    @Basic
    @Column(name = "order")
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Basic
    @Column(name = "score")
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "active_ind")
    public int getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(int activeInd) {
        this.activeInd = activeInd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteriaMasterDetailsEntity that = (CriteriaMasterDetailsEntity) o;
        return id == that.id &&
                criteriaMasterId == that.criteriaMasterId &&
                order == that.order &&
                Double.compare(that.score, score) == 0 &&
                activeInd == that.activeInd &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, criteriaMasterId, order, score, activeInd);
    }
}
