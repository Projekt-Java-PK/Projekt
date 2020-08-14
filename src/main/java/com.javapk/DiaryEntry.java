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

    public DiaryEntry(LocalDateTime date, String title, String content, Enum<ObservationType> type, File image) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.type = type;
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
        return getFormattedDate() + ";" + this.title + ";" + this.content + ";" + this.type;
    }

    @Override
    public String toString() {
        return this.date + " " + this.title + " " + this.content;
    }
}
