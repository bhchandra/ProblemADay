package com.lab.problemaday.codewars;

import java.util.regex.Pattern;

public class Dubstep {

    private static final Pattern WUB_AT_START = Pattern.compile("^(WUB)+");
    private static final Pattern WUB_AT_END = Pattern.compile("(WUB)+$");
    private static final Pattern WUB_AT_MIDDLE = Pattern.compile("(WUB)+");


    //my solution - try 1
    public static String SongDecoder(String song) {

        song = WUB_AT_START.matcher(song).replaceFirst("");
        song = WUB_AT_END.matcher(song).replaceFirst("");
        song = WUB_AT_MIDDLE.matcher(song).replaceAll(" ");

        return song;
    }

    //clever and short -- https://www.codewars.com/kata/reviews/552ad87175107bdc53000018/groups/5536b0e2a6fe467f7600005a
    //not mine
    public static String SongDecoder2(String song) {
        return song.replaceAll("(WUB)+", " ").trim();
    }


    //this is what I wanted to do, could'nt get the implementation correct.
    //O(n) - time
    //solution by mdhari -- https://www.codewars.com/kata/reviews/552ad87175107bdc53000018/groups/56f8c616ba792a6c80000311
    public static String SongDecoder3(String song) {
        // error handle
        if (song.length() > 200 || song.isEmpty()) {
            return "";
        }

        // is it possible to do this with regular expressions too?

        // anyways... start to walk the string as a char array, we are going to try for < O(n) time
        char[] songCharArr = song.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        boolean buildingWord = false; // helps figure out to put a single space between words

        int i = 0;
        while (i < song.length()) {

            // stop checking before our 'lookahead' goes out of bounds
            // ex. WUB has a length of 3 so this is fine too look for WUB
            //     ^ + 2 = B
            // but WUB would go out of bounds
            //      ^ + 2 = out of bounds, hence minus 2 from the length
            if ((i < song.length() - 2) && songCharArr[i] == 'W' && songCharArr[i + 1] == 'U' && songCharArr[i + 2] == 'B') {

                if (buildingWord) {
                    strBuilder.append(" ");
                    buildingWord = false;
                }

                i += 3;

            } else {
                strBuilder.append(songCharArr[i]);
                buildingWord = true;
                i += 1;
            }
        }

        return strBuilder.toString().trim();

    }


}
