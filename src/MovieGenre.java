/**
 * CSC130 - Algorithms and Data Structures
 * Instructor: Dr. Abeer Abdel Khaleq
 * Student: Farrukh Israilov
 * Assignment: Heaps and Priority Queues
 *
 * Description:
 * Comparator class for sorting Movie objects based on their genre.
 * If genres are equal, it falls back to recommendation score (higher is better).
 *
 * Date: April 17, 2025
 */

import java.util.Comparator;

public class MovieGenre implements Comparator<Movie> {

    /**
     * Compares two Movie objects by:
     * 1. Genre (alphabetical A–Z)
     * 2. Recommendation (higher is better if genres are equal)
     *
     * @param m1 First movie
     * @param m2 Second movie
     * @return negative if m1 < m2, positive if m1 > m2, zero if equal
     */
    @Override
    public int compare(Movie m1, Movie m2) {
        int genreCompare = m1.getGenre().compareTo(m2.getGenre());
        if (genreCompare != 0) {
            return genreCompare;
        }

        // Genres are equal — compare by recommendation (higher is better)
        return Integer.compare(m2.getRecommendation(), m1.getRecommendation());
    }
}
