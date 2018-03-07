package io.github.ziginsider.epam_laba_1;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;


/**
 * Generates a list of random rows.
 *
 * @author Alex Kisel
 * @since 2018-03-07
 */
public class RowsGenerate {

    private static final int LENGHT_WORD = 20;

    public RowsGenerate() {
    }

    /**
     * Gets English lowercase alphabet
     *
     * @return lowercase alphabet
     */
    @NonNull
    private String getLowerCaseAlphabet() {
        StringBuilder sb = new StringBuilder(26);
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * Generates a row of random characters <br>
     * Uses {@link RowsGenerate#getLowerCaseAlphabet()}
     *
     * @return Row of random characters
     */
    @NonNull
    private String getAbracadabra() {
        String alphabet = getLowerCaseAlphabet();
        StringBuilder abracadabra = new StringBuilder();
        Random rnd = new Random();
        int index;

        while (abracadabra.length() < LENGHT_WORD) {
            index = (int) (rnd.nextFloat() * alphabet.length());
            abracadabra.append(alphabet.substring(index, index + 1));
        }

        return  abracadabra.toString();
    }

    /**
     * Generates list of rows. <br>
     * Uses {@link RowsGenerate#getAbracadabra()}
     *
     * @param number Number of needed rows
     * @return List of generated rows
     */
    @NonNull
    public List<String> getRows(@Nullable Integer number) {

        List<String> rows = new ArrayList<>();

        if (number == null) {
            Log.d(TAG, "getRows: Number of rows = null");
            rows.add("null");
            return rows;
        } else {
            for (int i = 0; i < number; i++) {
                rows.add(getAbracadabra());
            }
            return rows;
        }
    }
}
