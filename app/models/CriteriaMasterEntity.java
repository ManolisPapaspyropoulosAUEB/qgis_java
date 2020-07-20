package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "criteria_master", schema = "afggis_db", catalog = "")
public class CriteriaMasterEntity {
    private int id;
    private String criterionLabel;
    private String scoreRange;
    private Integer weightFactor;
    private int calculateIndicator;

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
    @Column(name = "criterion_label")
    public String getCriterionLabel() {
        return criterionLabel;
    }

    public void setCriterionLabel(String criterionLabel) {
        this.criterionLabel = criterionLabel;
    }

    @Basic
    @Column(name = "score_range")
    public String getScoreRange() {
        return scoreRange;
    }

    public void setScoreRange(String scoreRange) {
        this.scoreRange = scoreRange;
    }

    @Basic
    @Column(name = "weight_factor")
    public Integer getWeightFactor() {
        return weightFactor;
    }

    public void setWeightFactor(Integer weightFactor) {
        this.weightFactor = weightFactor;
    }

    @Basic
    @Column(name = "calculate_indicator")
    public int getCalculateIndicator() {
        return calculateIndicator;
    }

    public void setCalculateIndicator(int calculateIndicator) {
        this.calculateIndicator = calculateIndicator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteriaMasterEntity that = (CriteriaMasterEntity) o;
        return id == that.id &&
                calculateIndicator == that.calculateIndicator &&
                Objects.equals(criterionLabel, that.criterionLabel) &&
                Objects.equals(scoreRange, that.scoreRange) &&
                Objects.equals(weightFactor, that.weightFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, criterionLabel, scoreRange, weightFactor, calculateIndicator);
    }
}
