package edu.znzz.cg.entity;

public class SysClazz {
    private String clazzId;

    private String clazzName;

    private String clazzBrief;

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId == null ? null : clazzId.trim();
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName == null ? null : clazzName.trim();
    }

    public String getClazzBrief() {
        return clazzBrief;
    }

    public void setClazzBrief(String clazzBrief) {
        this.clazzBrief = clazzBrief == null ? null : clazzBrief.trim();
    }
}