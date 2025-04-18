/**
 * CSC130 - Algorithms and Data Structures
 * Instructor: Dr. Abeer Abdel Khaleq
 * Student: Farrukh Israilov
 * Assignment: Heaps and Priority Queues
 *
 * Description:
 * Main class demonstrating the use of a PriorityQueue with Movie objects.
 * The user selects how to prioritize the queue: by recommendation, release date, or genre.
 * The program populates the queue, shows the top-priority movie, and allows basic operations.
 *
 * Date: 04-15-2025
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Populate and show the initial movie list (unsorted)
        PriorityQueue<Movie> initialMovies = new PriorityQueue<>();
        populateQueue(initialMovies);

        System.out.println("=== Movie Priority Queue ===");
        System.out.println("\nInitial list of movies:");
        displayTable(initialMovies);

        // Step 2: Let user choose priority criteria
        System.out.println("\nSelect priority criteria:");
        System.out.println("1 - Recommendation");
        System.out.println("2 - Release Date");
        System.out.println("3 - Genre");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        PriorityQueue<Movie> movieQueue;

        switch (choice) {
            case 1 -> movieQueue = new PriorityQueue<>(initialMovies); // By recommendation
            case 2 -> {
                movieQueue = new PriorityQueue<>(new MovieReleaseDate());
                movieQueue.addAll(initialMovies);
            }
            case 3 -> {
                movieQueue = new PriorityQueue<>(new MovieGenre());
                movieQueue.addAll(initialMovies);
            }
            default -> {
                System.out.println("Invalid input. Defaulting to Recommendation.");
                movieQueue = new PriorityQueue<>(initialMovies);
            }
        }

        // Step 3: Display top-priority movie
        System.out.println("\nTop-priority movie (peek):");
        System.out.println(movieQueue.peek());

        // Step 4: Display all movies in the queue
        System.out.println("\nAll movies in queue:");
        displayTable(movieQueue);

        // Step 5: Remove top movie
        System.out.println("\nRemoving top-priority movie...");
        movieQueue.poll();

        // Step 6: Show updated queue
        System.out.println("\nMovies in queue after removal:");
        displayTable(movieQueue);

        scanner.close();
    }

    /**
     * Inserts 10 sample movies into the provided priority queue.
     * @param queue the priority queue to populate
     */
    private static void populateQueue(PriorityQueue<Movie> queue) {
        queue.add(new Movie("The Godfather", "Crime", 9.2, 1972, 3, 24, 10));
        queue.add(new Movie("The Shawshank Redemption", "Drama", 9.3, 1994, 9, 23, 10));
        queue.add(new Movie("The Dark Knight", "Action", 9.0, 2008, 7, 18, 9));
        queue.add(new Movie("Pulp Fiction", "Crime", 8.9, 1994, 10, 14, 9));
        queue.add(new Movie("Forrest Gump", "Drama", 8.8, 1994, 7, 6, 8));
        queue.add(new Movie("Inception", "Sci-Fi", 8.8, 2010, 7, 16, 9));
        queue.add(new Movie("Fight Club", "Drama", 8.8, 1999, 10, 15, 8));
        queue.add(new Movie("The Matrix", "Sci-Fi", 8.7, 1999, 3, 31, 9));
        queue.add(new Movie("Titanic", "Romance", 7.8, 1997, 12, 19, 7));
        queue.add(new Movie("Gladiator", "Action", 8.5, 2000, 5, 5, 8));
    }

    /**
     * Displays all movies in the priority queue in a table format.
     * @param queue the queue to display
     */
    private static void displayTable(PriorityQueue<Movie> queue) {
        System.out.printf("%-30s | %-15s | %-10s | %-15s | %-15s%n",
                "Title", "Genre", "Rating", "Release Date", "Recommendation");
        System.out.println("---------------------------------------------------------------------------------------");

        // Correctly sorted output
        PriorityQueue<Movie> copy = new PriorityQueue<>(queue);
        while (!copy.isEmpty()) {
            System.out.println(copy.poll());
        }
    }

}
