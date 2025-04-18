/**
 * CSC130 - Algorithms and Data Structures
 * Instructor: Dr. Abeer Abdel Khaleq
 * Student: Farrukh Israilov
 * Assignment: Heaps and Priority Queues
 *
 * Description:
 * This class defines a Movie with attributes such as title, genre, rating,
 * release date (as LocalDate), and recommendation score. It implements Comparable<Movie>
 * for default sorting based on recommendation scores.
 *
 * Notes:
 * - LocalDate is used for releaseDate to ensure valid and safe date handling.
 * - Includes standard methods (getters, setters, toString) and supports
 *   formatted string output.
 *
 * Date: 04-15-2025
 */

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movie implements Comparable<Movie> {

    private String title;
    private String genre;
    private double rating;          // e.g., 8.7
    private LocalDate releaseDate;  // LocalDate for type safety
    private int recommendation;     // out of 10

    /**
     * Constructs a Movie with specified details.
     *
     * @param title         Movie title
     * @param genre         Movie genre
     * @param rating        General movie rating (e.g., IMDb)
     * @param year          Year of release
     * @param month         Month of release
     * @param day           Day of release
     * @param recommendation Recommendation score (0–10)
     */
    public Movie(String title, String genre, double rating, int year, int month, int day, int recommendation) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.recommendation = recommendation;

        try {
            this.releaseDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            System.out.println("Invalid date provided. Defaulting to 2001-01-01.");
            this.releaseDate = LocalDate.of(2001, 1, 1);
        }
    }

    /**
     * Default constructor for placeholder Movie objects.
     */
    public Movie() {
        this("No Title", "No Genre", 0.0, 1970, 1, 1, 0);
    }

    // -------- Getters and Setters --------

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Gets release date as a formatted string (yyyy-MM-dd).
     */
    public String getReleaseDate() {
        return releaseDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * Gets release date as raw LocalDate.
     */
    public LocalDate getReleaseDateRaw() {
        return releaseDate;
    }

    /**
     * Sets the release date using year, month, and day.
     * Falls back to default if input is invalid.
     */
    public void setReleaseDate(int year, int month, int day) {
        try {
            this.releaseDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            System.out.println("Invalid date provided. Defaulting to 2001-01-01.");
            this.releaseDate = LocalDate.of(2001, 1, 1);
        }
    }

    public int getRecommendation() {
        return recommendation;
    }

    /**
     * Sets the recommendation score (0–10).
     */
    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }

    // -------- Comparable Implementation --------

    /**
     * Compares movies by recommendation first (higher is better),
     * then by rating if recommendation scores are equal (also higher is better).
     */
    @Override
    public int compareTo(Movie other) {
        int recCompare = Integer.compare(other.recommendation, this.recommendation);
        if (recCompare != 0) {
            return recCompare;
        }
        // If recommendations are equal, compare by rating
        return Double.compare(other.rating, this.rating);
    }


    // -------- toString --------

    /**
     * Returns a readable summary of the movie's information.
     */
    @Override
    public String toString() {
        return String.format("%-30s | %-15s | %-10.1f | %-15s | %-15d", title, genre, rating, getReleaseDate(), recommendation);
    }
}
