import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
    private static int invalidLinesSkipped;
 
    public static void main(String[] args) {
        ArrayList<Integer> scores = readScores("scores.txt");

        if (scores.isEmpty()) {
            System.out.println("No valid scores were found. Report not created.");
            return;
        }

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > high) {
                high = score;
            }
            if (score < low) {
                low = score;
            }
        }

        double average = calculateAverage(scores);
        writeReport(scores, average, high, low, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        invalidLinesSkipped = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    invalidLinesSkipped++;
                    continue;
                }

                try {
                    scores.add(Integer.parseInt(line));
                } catch (NumberFormatException exception) {
                    System.out.println("Skipping invalid score: " + line);
                    invalidLinesSkipped++;
                }
            }
        } catch (IOException exception) {
            System.out.println("Could not read " + filename + ": " + exception.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        String[] reportLines = {
            "=== Grade Analysis Report ===",
            String.format("Total scores processed:  %d", scores.size()),
            String.format("Invalid lines skipped:    %d", invalidLinesSkipped),
            "",
            String.format("Average score: %.2f", avg),
            String.format("Highest score: %d", high),
            String.format("Lowest score:  %d", low),
            "",
            "Grade distribution:",
            String.format("  A (90-100):   %d", countA),
            String.format("  B (80-89):    %d", countB),
            String.format("  C (70-79):    %d", countC),
            String.format("  D (60-69):    %d", countD),
            String.format("  F (below 60): %d", countF)
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String reportLine : reportLines) {
                System.out.println(reportLine);
                writer.write(reportLine);
                writer.newLine();
            }
        } catch (IOException exception) {
            System.out.println("Could not write " + outputFile + ": " + exception.getMessage());
        }
    }
} 