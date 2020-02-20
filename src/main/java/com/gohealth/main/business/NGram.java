package com.gohealth.main.business;

import java.util.Map;

public interface NGram {

    /**
     * Generates a n-gram for a given text.
     */
    Map<String,Integer> generate(String text);
}
