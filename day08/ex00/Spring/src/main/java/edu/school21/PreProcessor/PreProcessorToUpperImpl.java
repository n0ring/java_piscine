package edu.school21.PreProcessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    public PreProcessorToUpperImpl() {
    }

    public String PreProcessing(String msg) {
        return msg.toUpperCase();
    }
}
