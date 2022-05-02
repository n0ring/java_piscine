package edu.school21.App;

import edu.school21.PreProcessor.PreProcessor;
import edu.school21.PreProcessor.PreProcessorToUpperImpl;
import edu.school21.Printer.Printer;
import edu.school21.Printer.PrinterWithDateTimeImpl;
import edu.school21.Printer.PrinterWithPrefixImpl;
import edu.school21.Renderer.Renderer;
import edu.school21.Renderer.RendererErrImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        try {
            ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("context.xml");
            Printer printer = context.getBean("printerWithPrefix",
                    PrinterWithPrefixImpl.class);
            printer.print("Hello!");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
