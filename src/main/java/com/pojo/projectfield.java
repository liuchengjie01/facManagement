package com.pojo;

public class projectfield {

    private String projectfield_id;
    private String project_id;
    private String project_location;

    @Override
    public String toString() {
        return "projectfield{" +
                "projectfield_id='" + projectfield_id + '\'' +
                ", project_id='" + project_id + '\'' +
                ", project_location='" + project_location + '\'' +
                '}';
    }

    public String getProjectfield_id() {
        return projectfield_id;
    }

    public void setProjectfield_id(String projectfield_id) {
        this.projectfield_id = projectfield_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_location() {
        return project_location;
    }

    public void setProject_location(String project_location) {
        this.project_location = project_location;
    }
}
