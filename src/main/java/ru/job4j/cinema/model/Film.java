package ru.job4j.cinema.model;

import java.util.Map;
import java.util.Objects;

public class Film {

    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "name", "name",
            "genre_id", "genreName",
            "description", "description",
            "year", "year",
            "minimal_age", "minmalAge",
            "duration_in_minutes", "duration",
            "file_id", "fileId"
    );
    private int id;
    private String name;
    private String genreName;
    private String description;
    private int year;
    private int minmalAge;
    private int duration;
    private String fileId;

    public Film(int id, String name, String description, String fileId, int minmalAge, int duration, int year, String genreName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fileId = fileId;
        this.minmalAge = minmalAge;
        this.duration = duration;
        this.year = year;
        this.genreName = genreName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinmalAge() {
        return minmalAge;
    }

    public void setMinmalAge(int minmalAge) {
        this.minmalAge = minmalAge;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Film film)) {
            return false;
        }
        return id == film.id && year == film.year && minmalAge == film.minmalAge && duration == film.duration && fileId == film.fileId && Objects.equals(name, film.name) && Objects.equals(genreName, film.genreName) && Objects.equals(description, film.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genreName, description, year, minmalAge, duration, fileId);
    }
}
