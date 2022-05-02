package edu.school21.PreProcessor;

public class PreProcessorToLower implements PreProcessor {

    public PreProcessorToLower() {
    }
    public String PreProcessing(String msg) {
        return msg.toLowerCase();
    }
}
