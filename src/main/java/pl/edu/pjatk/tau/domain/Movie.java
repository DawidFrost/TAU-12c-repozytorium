package pl.edu.pjatk.tau.domain;


import java.util.Date;

public class Movie {
    private Integer id;
    private String name;
    private String type;
    private String director;
    private Date    createObjDateLog;
    private Date    updateObjDateLog;
    private Date    readObjDateLog;
    private boolean actCreateDateLog=true;
    private boolean actUpdateDateLog;
    private boolean actReadDateLog;


    public Movie(String name,String type,String director) {
        this.name = name;
        this.type = type;
        this.director = director;
    }

    public Date getCreateObjDateLog() {
        return createObjDateLog;
    }

    public void setCreateObjDateLog(Date createObjDateLog) {
        this.createObjDateLog = createObjDateLog;
    }

    public Date getUpdateObjDateLog() {
        return updateObjDateLog;
    }

    public void setUpdateObjDateLog(Date updateObjDateLog) {
        this.updateObjDateLog = updateObjDateLog;
    }

    public Date getReadObjDateLog() {
        return readObjDateLog;
    }

    public void setReadObjDateLog(Date readObjDateLog) {
        this.readObjDateLog = readObjDateLog;
    }

    public boolean isActCreateDateLog() {
        return actCreateDateLog;
    }

    public void setActCreateDateLog(boolean actCreateDateLog) {
        this.actCreateDateLog = actCreateDateLog;
    }

    public boolean isActUpdateDateLog() {
        return actUpdateDateLog;
    }

    public void setActUpdateDateLog(boolean actUpdateDateLog) {
        this.actUpdateDateLog = actUpdateDateLog;
    }

    public boolean isActReadDateLog() {
        return actReadDateLog;
    }

    public void setActReadDateLog(boolean actReadDateLog) {
        this.actReadDateLog = actReadDateLog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
