package HW20200704IO;

import java.time.LocalDate;

public class PersonDate {
    private String name;
    private LocalDate date;

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public PersonDate(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "PersonDate{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
