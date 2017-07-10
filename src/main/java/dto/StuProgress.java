package dto;

public class StuProgress {
    private String state;
    private String desc1;
    private String desc2;
    private String desc3;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public StuProgress(int state){
        switch (state){
            case 0:
                this.setState("未选题");
                this.setDesc1("请尽快提交选题并与导师取得联系");
                this.setDesc2("已提交选题的同学请耐心等待审核，审核通过方可进入下一阶段");
                break;
            case 1:
                this.setState("开题");
                this.setDesc1("请尽快提交开题报告所需交付物");
                this.setDesc2("已提交交付物的同学请耐心等待审核，审核通过方可进入下一阶段");
                break;
            case 2:
                this.setState("中期检查");
                this.setDesc1("请尽快提交中期检查所需交付物");
                this.setDesc2("已提交交付物的同学请耐心等待审核，审核通过方可进入下一阶段");
                break;
            case 3:
                this.setState("论文提交");
                this.setDesc1("请尽快提交论文提交");
                this.setDesc2("已提交论文的同学请耐心等待审核，审核通过方可查询成绩");
                break;
            case 4:
                this.setState("论文通过");
                this.setDesc1("恭喜你论文已通过审核");
                this.setDesc2("请及时确认论文成绩，如有疑问，请尽快与导师取得联系");
                break;
            case -1:
                this.setState("选题未通过");
                this.setDesc1("选题未通过审核");
                this.setDesc2("请及时根据修改意见修改选题并与导师取得联系后再次上传");
                break;
            case -2:
                this.setState("开题报告未通过");
                this.setDesc1("开题报告未通过审核");
                this.setDesc2("请及时根据修改意见修改交付物并与导师取得联系后再次上传");
                break;
            case -3:
                this.setState("中期检查未通过");
                this.setDesc1("中期检查未通过审核");
                this.setDesc2("请及时根据修改意见修改交付物并与导师取得联系后再次上传");
                break;
            case -4:
                this.setState("论文未通过");
                this.setDesc1("论文未通过审核");
                this.setDesc2("请及时根据修改意见修改论文并与导师取得联系后再次上传");
                break;
        }
    }
}
