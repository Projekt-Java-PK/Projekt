package com.javapk;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiaryEntry {
    private LocalDateTime date;
    private String title;
    private String content;
    private Enum<ObservationType> type;
    private File image;
    private String coordinateEast;
    private String coordinateNorth;

    public DiaryEntry(LocalDateTime date, String title, String content, Enum<ObservationType> type, String east, String north, File image) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.type = type;
        this.coordinateEast = east;
        this.coordinateNorth = north;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getFormattedDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
        return this.date.format(dateFormat);
    }

    public String getCSVData() {
        return "Data: " + getFormattedDate() + ";" + "Tytuł: " + this.title + ";" +
                "Treść: " + this.content + ";" + "Typ: " + this.type + ";" + this.coordinateEast + ";" + this.coordinateNorth;
    }

    @Override
    public String toString() {
        return this.date + " " + this.title + " " + this.content;
    }
}