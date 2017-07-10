package model;

public class Score {
    private Integer scoreId;

    private Integer scoreUserId;

    private String scoreTopic;

    private String scoreOpinion;

    private Integer scoreFraction;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getScoreUserId() {
        return scoreUserId;
    }

    public void setScoreUserId(Integer scoreUserId) {
        this.scoreUserId = scoreUserId;
    }

    public String getScoreTopic() {
        return scoreTopic;
    }

    public void setScoreTopic(String scoreTopic) {
        this.scoreTopic = scoreTopic == null ? null : scoreTopic.trim();
    }

    public String getScoreOpinion() {
        return scoreOpinion;
    }

    public void setScoreOpinion(String scoreOpinion) {
        this.scoreOpinion = scoreOpinion == null ? null : scoreOpinion.trim();
    }

    public Integer getScoreFraction() {
        return scoreFraction;
    }

    public void setScoreFraction(Integer scoreFraction) {
        this.scoreFraction = scoreFraction;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", scoreUserId=" + scoreUserId +
                ", scoreTopic='" + scoreTopic + '\'' +
                ", scoreOpinion='" + scoreOpinion + '\'' +
                ", scoreFraction=" + scoreFraction +
                '}';
    }
}