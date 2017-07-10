package dto;

public class Student {
    private String stuLoginName;
    private int stuId;
    private String stuName;
    private int stuStageCode;
    private String stuStage;

    public String getStuLoginName() {
        return stuLoginName;
    }

    public void setStuLoginName(String stuLoginName) {
        this.stuLoginName = stuLoginName;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuStageCode() {
        return stuStageCode;
    }

    public void setStuStageCode(int stuStageCode) {
        this.stuStageCode = stuStageCode;
    }

    public String getStuStage() {
        return stuStage;
    }

    public void setStuStage(String stuStage) {
        this.stuStage = stuStage;
    }
}
