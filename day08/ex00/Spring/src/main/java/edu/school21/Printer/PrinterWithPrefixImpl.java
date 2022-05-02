package edu.school21.Printer;

import edu.school21.Renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer{
    private String prefix;
    private Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String p) {
        prefix = p;
    }

    @Override
    public void print(String msg) {
        renderer.render(prefix + msg);
    }
}
