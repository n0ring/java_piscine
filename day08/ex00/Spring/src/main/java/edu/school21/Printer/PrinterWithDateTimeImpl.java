package edu.school21.Printer;

import edu.school21.Renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{
    private Renderer renderer;

    public PrinterWithDateTimeImpl() {
    }

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String msg) {
        renderer.render(LocalDateTime.now() + " " + msg);
    }
}
