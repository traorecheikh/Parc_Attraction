/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cheikh
 */
public class HorairesUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("H'h'-H'h'");

    public static String formatHoraires(LocalTime debut, LocalTime fin) {
        return debut.format(DateTimeFormatter.ofPattern("H'h'")) + "-" + fin.format(DateTimeFormatter.ofPattern("H'h'"));
    }

    public boolean isValidHoraires(String horaire) {
        Pattern pattern = Pattern.compile("^(\\d{1,2})h-(\\d{1,2})h$");
        Matcher matcher = pattern.matcher(horaire);

        if (!matcher.matches()) {
            return false;
        }

        int startHour = Integer.parseInt(matcher.group(1));
        int endHour = Integer.parseInt(matcher.group(2));

        if (startHour >= endHour) {
            return false;
        }

        return true;
    }

     public boolean isShiftDurationValid(String horaire) {
        Pattern pattern = Pattern.compile("^(\\d{1,2})h-(\\d{1,2})h$");
        Matcher matcher = pattern.matcher(horaire);

        if (matcher.matches()) {
            int startHour = Integer.parseInt(matcher.group(1));
            int endHour = Integer.parseInt(matcher.group(2));

            if ((endHour - startHour) > 10) {
                return false;
            }
        }

        return true;
    }

    public static LocalTime[] parseHoraires(String horaires) {
        String[] parts = horaires.split("-");
        LocalTime debut = LocalTime.parse(parts[0], DateTimeFormatter.ofPattern("H'h'"));
        LocalTime fin = LocalTime.parse(parts[1], DateTimeFormatter.ofPattern("H'h'"));
        return new LocalTime[]{debut, fin};
    }
}
