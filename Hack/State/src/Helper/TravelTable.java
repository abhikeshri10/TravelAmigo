package Helper;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TravelTable {
    private SimpleIntegerProperty id;
    private SimpleStringProperty journey_date;
    private SimpleStringProperty ticket_number;
    private SimpleStringProperty purpose;
    private SimpleIntegerProperty age;
    private SimpleIntegerProperty duration;
    private SimpleStringProperty travel_type;
    private SimpleStringProperty source_state;

    public TravelTable() {
    }

    public TravelTable(Integer id, String journey_date, String ticket_number, String purpose, Integer age, Integer duration, String travel_type, String source_state) {
        this.id = new SimpleIntegerProperty(id);
        this.journey_date = new SimpleStringProperty(journey_date);
        this.ticket_number = new SimpleStringProperty(ticket_number);
        this.purpose = new SimpleStringProperty(purpose);
        this.age = new SimpleIntegerProperty(age);
        this.duration =new SimpleIntegerProperty(duration);
        this.travel_type = new SimpleStringProperty(travel_type);
        this.source_state = new SimpleStringProperty(source_state);
    }

    @Override
    public String toString() {
        return "TravelTable{" +
                "id=" + id +
                ", journey_date=" + journey_date +
                ", ticket_number=" + ticket_number +
                ", purpose=" + purpose +
                ", age=" + age +
                ", duration=" + duration +
                ", travel_type=" + travel_type +
                ", source_state=" + source_state +
                '}';
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getJourney_date() {
        return journey_date.get();
    }

    public SimpleStringProperty journey_dateProperty() {
        return journey_date;
    }

    public void setJourney_date(String journey_date) {
        this.journey_date.set(journey_date);
    }

    public String getTicket_number() {
        return ticket_number.get();
    }

    public SimpleStringProperty ticket_numberProperty() {
        return ticket_number;
    }

    public void setTicket_number(String ticket_number) {
        this.ticket_number.set(ticket_number);
    }

    public String getPurpose() {
        return purpose.get();
    }

    public SimpleStringProperty purposeProperty() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose.set(purpose);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public int getDuration() {
        return duration.get();
    }

    public SimpleIntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public String getTravel_type() {
        return travel_type.get();
    }

    public SimpleStringProperty travel_typeProperty() {
        return travel_type;
    }

    public void setTravel_type(String travel_type) {
        this.travel_type.set(travel_type);
    }

    public String getSource_state() {
        return source_state.get();
    }

    public SimpleStringProperty source_stateProperty() {
        return source_state;
    }

    public void setSource_state(String source_state) {
        this.source_state.set(source_state);
    }
}
