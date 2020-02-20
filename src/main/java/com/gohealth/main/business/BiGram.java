package com.gohealth.main.business;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Class responsible for generates a BiGram.
 */
public class BiGram implements NGram {
    private static final Logger LOGGER = Logger.getLogger(BiGram.class.getSimpleName());

    @Override
    public Map<String, Integer> generate(String text) {
        LinkedHashMap<String, Integer> histogram = calculateHistogram(text);
        print(histogram);

        return histogram;
    }

    /**
     * Prints the histogram in the console.
     *
     * @param histogram the histogram that will be printed.
     */
    private void print(LinkedHashMap<String, Integer> histogram) {
        histogram.forEach((k, v) -> System.out.println("* '" + k + "' " + v));
    }

    /**
     * Calculates the histogram for the given text.
     *
     * @param text the text used to calculate the bi-gram histogram.
     * @return LinkedHashMap<String, Integer> containing the histogram.
     */
    private LinkedHashMap<String, Integer> calculateHistogram(String text) {
        LinkedHashMap<String, Integer> histogram = new LinkedHashMap<>();
        String[] arrayOfWords = sanitizeText(text);

        for (int i = 0; i < arrayOfWords.length - 1; i++) {
            String currentBigram = arrayOfWords[i] + " " + arrayOfWords[i + 1];

            if (histogram.containsKey(currentBigram)) {
                int currentValue = histogram.get(currentBigram);
                histogram.put(currentBigram, ++currentValue);
            } else {
                histogram.put(currentBigram, 1);
            }
        }
        return histogram;
    }

    /**
     * Cleans the text by removing any non alphabetical word.
     *
     * @param text the text to be sanitized.
     * @return the sanitized text.
     */
    private String[] sanitizeText(String text) {
        return text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }

}
