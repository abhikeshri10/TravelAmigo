package Helper;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TravelTable {
    private SimpleIntegerProperty id;
    private SimpleStringProperty journey_date;
    private SimpleStringProperty ticket_number;
    private SimpleStringProperty source_city;
    private SimpleStringProperty dest_city;

    public TravelTable(Integer id, String journey_date, String ticket_number, String source_city, String dest_city) {
        this.id = new SimpleIntegerProperty(id);
        this.journey_date = new SimpleStringProperty(journey_date);
        this.ticket_number = new SimpleStringProperty(ticket_number);
        this.source_city = new SimpleStringProperty(source_city);
        this.dest_city = new SimpleStringProperty(dest_city);
    }

    public TravelTable() {
    }

    @Override
    public String toString() {
        return "TravelTable{" +
                "id=" + id +
                ", journey_date=" + journey_date +
                ", ticket_number=" + ticket_number +
                ", source_city=" + source_city +
                ", dest_city=" + dest_city +
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

    public String getSource_city() {
        return source_city.get();
    }

    public SimpleStringProperty source_cityProperty() {
        return source_city;
    }

    public void setSource_city(String source_city) {
        this.source_city.set(source_city);
    }

    public String getDest_city() {
        return dest_city.get();
    }

    public SimpleStringProperty dest_cityProperty() {
        return dest_city;
    }

    public void setDest_city(String dest_city) {
        this.dest_city.set(dest_city);
    }
}
