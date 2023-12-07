package com.hypereon.projectservice.dto;

public class Skill {
    private String skillName;
    private int skillProficiency;

    public Skill() {
    }

    public Skill(String skillName, int skillProficiency) {
        this.skillName = skillName;
        this.skillProficiency = skillProficiency;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillProficiency() {
        return skillProficiency;
    }

    public void setSkillProficiency(int skillProficiency) {
        this.skillProficiency = skillProficiency;
    }

}
