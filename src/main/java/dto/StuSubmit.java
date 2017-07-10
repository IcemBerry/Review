package dto;

public class StuSubmit {
    private String stage;
    private String suggest;
    private String message;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StuSubmit(int state) {
        switch (state) {
            case 0:
                this.setStage("提交题目");
                this.setSuggest("提交题目阶段需要上传题目描述，并在备注内写明题目");
                break;
            case 1:
                this.setStage("开题报告");
                this.setSuggest("请上传DOC格式文档");
                break;
            case 2:
                this.setStage("中期验收");
                this.setSuggest("请上传ZIP格式交付物");
                break;
            case 3:
                this.setStage("论文提交");
                this.setSuggest("请上传DOC格式论文");
                break;
            case 4:
                this.setStage("论文通过");
                this.setSuggest("上传通道已关闭");
                break;
            case -1:
                this.setStage("选题修改");
                this.setSuggest("提交题目阶段不需要上传附件，请在备注内写明题目");
                break;
            case -2:
                this.setStage("开题报告修改");
                this.setSuggest("请上传DOC格式文档");
                break;
            case -3:
                this.setStage("中期检查修改");
                this.setSuggest("请上传ZIP格式交付物");
                break;
            case -4:
                this.setStage("论文修改");
                this.setSuggest("请上传DOC格式交付物");
                break;
        }
    }
}
