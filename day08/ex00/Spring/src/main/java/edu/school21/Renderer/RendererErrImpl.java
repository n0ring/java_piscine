package edu.school21.Renderer;

import edu.school21.PreProcessor.PreProcessor;

public class RendererErrImpl implements Renderer{
    private  PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }
    public void render(String s) {
        System.err.println(preProcessor.PreProcessing(s));
    }

    public RendererErrImpl() {
    }
}
