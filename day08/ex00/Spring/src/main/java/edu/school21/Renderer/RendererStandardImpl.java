package edu.school21.Renderer;

import edu.school21.PreProcessor.PreProcessor;

public class RendererStandardImpl implements Renderer {
    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    public RendererStandardImpl() {
    }

    public void render(String s) {
        System.out.println(preProcessor.PreProcessing(s));
    }
}
