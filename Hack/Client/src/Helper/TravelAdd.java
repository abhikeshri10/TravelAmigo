package Helper;

import java.io.Serializable;

public class TravelAdd implements Serializable {
    private String username;
    private String ticket_category;
    private String ticket_number;
    private String source_city;
    private String journey_date;
    private String source_state;
    private String dest_city;
    private String dest_state;
    private Integer duration_days;
    private String purpose;
    private Integer age;

    public TravelAdd() {
    }

    public TravelAdd(String username, String ticket_category, String ticket_number, String source_city, String journey_date, String source_state, String dest_city, String dest_state, Integer duration_days, String purpose, Integer age) {
        this.username = username;
        this.ticket_category = ticket_category;
        this.ticket_number = ticket_number;
        this.source_city = source_city;
        this.journey_date = journey_date;
        this.source_state = source_state;
        this.dest_city = dest_city;
        this.dest_state = dest_state;
        this.duration_days = duration_days;
        this.purpose = purpose;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TravelAdd{" +
                "username='" + username + '\'' +
                ", ticket_category='" + ticket_category + '\'' +
                ", ticket_number='" + ticket_number + '\'' +
                ", source_city='" + source_city + '\'' +
                ", journey_date='" + journey_date + '\'' +
                ", source_state='" + source_state + '\'' +
                ", dest_city='" + dest_city + '\'' +
                ", dest_state='" + dest_state + '\'' +
                ", duration_days=" + duration_days +
                ", purpose='" + purpose + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTicket_category() {
        return ticket_category;
    }

    public void setTicket_category(String ticket_category) {
        this.ticket_category = ticket_category;
    }

    public String getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(String ticket_number) {
        this.ticket_number = ticket_number;
    }

    public String getSource_city() {
        return source_city;
    }

    public void setSource_city(String source_city) {
        this.source_city = source_city;
    }

    public String getJourney_date() {
        return journey_date;
    }

    public void setJourney_date(String journey_date) {
        this.journey_date = journey_date;
    }

    public String getSource_state() {
        return source_state;
    }

    public void setSource_state(String source_state) {
        this.source_state = source_state;
    }

    public String getDest_city() {
        return dest_city;
    }

    public void setDest_city(String dest_city) {
        this.dest_city = dest_city;
    }

    public String getDest_state() {
        return dest_state;
    }

    public void setDest_state(String dest_state) {
        this.dest_state = dest_state;
    }

    public Integer getDuration_days() {
        return duration_days;
    }

    public void setDuration_days(Integer duration_days) {
        this.duration_days = duration_days;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
