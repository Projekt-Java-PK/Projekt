package com.javapk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.Month;

public class DiaryEntryTest {

    private DiaryEntry entry;

    @BeforeEach
    void init() {
        entry = new DiaryEntry(LocalDateTime.of(2020, Month.JULY, 29, 20, 10, 40), "Title", "Content",
                ObservationType.DRZEWA, "18.899231", "52.268157", new File("no-image.png"));
    }

    @Test
    void getFileExtensionTest() {
        Assertions.assertEquals("png", entry.getFileExtension());
    }

    @Test
    void getCSVDataTest() {
        Assertions.assertEquals("Data: 29_07_2020_20_10;Tytuł: Title;Treść: Content;Typ: DRZEWA;18.899231;52.268157", entry.getCSVData());
    }

    @Test
    void getFormattedDateTest() {
        Assertions.assertEquals("29_07_2020_20_10", entry.getFormattedDate());
    }

    @Test
    void observationTypeTest() {
        Assertions.assertTrue(entry.getType() instanceof ObservationType);
    }

    @Test
    void entryTypeTest() {
        Assertions.assertTrue(entry instanceof DiaryEntry);
    }
}
