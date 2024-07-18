package ru.job4j.cinema.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

public class FilmSession {

    private int id;
    private String filmName;
    private String hallsName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int price;
    private String genreName;
    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "film_id", "filmName",
            "genre_id", "genreName",
            "halls_id", "hallsName",
            "start_time", "startTime",
            "end_time", "endTime",
            "price", "price",
            "row_count", "hallRowCount",
            "place_count", "hallPlaceCount"
    );
    private int hallRowCount;
    private int hallPlaceCount;

    public FilmSession(int id, String filmName, String genreName, String hallsId, LocalDateTime startTime,
                       LocalDateTime endTime, int price, String hallsName, int hallRowCount, int hallPlaceCount) {
        this.id = id;
        this.filmName = filmName;
        this.genreName = genreName;
        this.hallsName = hallsId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.hallRowCount = hallRowCount;
        this.hallPlaceCount = hallPlaceCount;
    }

    public int getHallRowCount() {
        return hallRowCount;
    }

    public void setHallRowCount(int hallRowCount) {
        this.hallRowCount = hallRowCount;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getHallPlaceCount() {
        return hallPlaceCount;
    }

    public void setHallPlaceCount(int hallPlaceCount) {
        this.hallPlaceCount = hallPlaceCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getHallsName() {
        return hallsName;
    }

    public void setHallsName(String hallsName) {
        this.hallsName = hallsName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getFormattedStartTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return startTime.format(formatter);
    }

    public String getFormattedEndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return endTime.format(formatter);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof FilmSession that)) {
            return false;
        }
        return id == that.id && price == that.price && hallRowCount == that.hallRowCount && hallPlaceCount == that.hallPlaceCount && Objects.equals(filmName, that.filmName) && Objects.equals(hallsName, that.hallsName) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(genreName, that.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filmName, hallsName, startTime, endTime, price, genreName, hallRowCount, hallPlaceCount);
    }
}
