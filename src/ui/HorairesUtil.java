/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Cheikh
 */
public class HorairesUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("H'h'-H'h'");

    public static String formatHoraires(LocalTime debut, LocalTime fin) {
        return debut.format(DateTimeFormatter.ofPattern("H'h'")) + "-" + fin.format(DateTimeFormatter.ofPattern("H'h'"));
    }

    public static boolean isValidHoraires(String horaires) {
        try {
            String[] parts = horaires.split("-");
            if (parts.length != 2) {
                return false;
            }
            LocalTime.parse(parts[0], DateTimeFormatter.ofPattern("H'h'"));
            LocalTime.parse(parts[1], DateTimeFormatter.ofPattern("H'h'"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalTime[] parseHoraires(String horaires) {
        String[] parts = horaires.split("-");
        LocalTime debut = LocalTime.parse(parts[0], DateTimeFormatter.ofPattern("H'h'"));
        LocalTime fin = LocalTime.parse(parts[1], DateTimeFormatter.ofPattern("H'h'"));
        return new LocalTime[]{debut, fin};
    }
}
