package pl.edu.pjatk.tau.domain;


import java.time.Clock;
import java.time.LocalDateTime;


public class Movie {
    private Integer id;
    private String name;
    private String type;
    private String director;
    private LocalDateTime createObjDateTime;
    private LocalDateTime   updateObjDateTime;
    private LocalDateTime   readObjDateTime;
    private boolean actCreateDateTime = true;
    private boolean actUpdateDateTime = true;
    private boolean actReadDateTime = true;
    private Clock   clock = Clock.systemDefaultZone();


    public Movie(String name,String type,String director) {
        this.name = name;
        this.type = type;
        this.director = director;

    }

    public Movie(Integer id, String name, String type, String director) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.director = director;
    }

    public LocalDateTime getCreateObjDateTime() {
        return createObjDateTime;
    }

    public void setCreateObjDateTime() {
        if (actCreateDateTime) {
            this.createObjDateTime = LocalDateTime.now(clock);
        }
    }

    public LocalDateTime getUpdateObjDateTime() {
        return updateObjDateTime;
    }

    public void setUpdateObjDateTime() {
        if (actUpdateDateTime) {
            this.updateObjDateTime = LocalDateTime.now(clock);
        }
    }

    public LocalDateTime getReadObjDateTime() {
        return readObjDateTime;
    }

    public void setReadObjDateTime() {
        if (actReadDateTime) {
            this.readObjDateTime = LocalDateTime.now(clock);
        }
    }
    public void actCreateDateTime(boolean flag) {
        this.actCreateDateTime = flag;
    }

    public void actUpdateDateTime(boolean flag) {
        this.actUpdateDateTime = flag;
    }

    public void actReadDateTime(boolean flag) {
        this.actReadDateTime = flag;
    }

    public boolean isactCreateDateTime() {
        return actCreateDateTime;
    }

    public void setactCreateDateTime(boolean actCreateDateTime) {
        this.actCreateDateTime = actCreateDateTime;
    }

    public boolean isactUpdateDateTime() {
        return actUpdateDateTime;
    }

    public void setactUpdateDateTime(boolean actUpdateDateTime) {
        this.actUpdateDateTime = actUpdateDateTime;
    }

    public boolean isactReadDateTime() {
        return actReadDateTime;
    }

    public void setactReadDateTime(boolean actReadDateTime) {
        this.actReadDateTime = actReadDateTime;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public LocalDateTime returnClock(){
        return LocalDateTime.now(clock);
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
