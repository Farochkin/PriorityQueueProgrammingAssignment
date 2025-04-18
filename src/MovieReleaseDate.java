/**
 * CSC130 - Algorithms and Data Structures
 * Instructor: Dr. Abeer Abdel Khaleq
 * Student: Farrukh Israilov
 * Assignment: Heaps and Priority Queues
 *
 * Description:
 * Comparator class for sorting Movie objects based on their release dates.
 * This is used when the user selects to prioritize the movie queue by chronological order.
 *
 * Notes:
 * Assumes Movie objects expose a LocalDate directly via getReleaseDateRaw().
 *
 * Date: 04-15-2025
 */

import java.util.Comparator;

public class MovieReleaseDate implements Comparator<Movie> {

    /**
     * Compares two Movie objects by their release dates.
     * Earlier dates come first in priority.
     *
     * @param m1 First movie
     * @param m2 Second movie
     * @return negative if m1 is earlier, positive if later, zero if equal
     */
    @Override
    public int compare(Movie m1, Movie m2) {
        long epochDay1 = m1.getReleaseDateRaw().toEpochDay();
        long epochDay2 = m2.getReleaseDateRaw().toEpochDay();

//        System.out.println("Comparing: " + m1.getTitle() + " (" + epochDay1 + ") with " + m2.getTitle() + " (" + epochDay2 + ")");
        return Long.compare(epochDay1, epochDay2);
    }

}
