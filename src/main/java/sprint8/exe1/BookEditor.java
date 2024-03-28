package sprint8.exe1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookEditor {

    private HeaderDecorator headerDecorator;
    private final List<LineProcessor> lineProcessors = new ArrayList<>();

    public static void main(String[] args) {
        BookEditor bookEditor = new BookEditor();

        bookEditor.setHeaderDecorator(x -> x.toUpperCase() + "/n");
        bookEditor.addLineProcessor(x -> x.charAt(0) + x.substring(1));

        List<String> content = Arrays.asList(
                "Приключения Java-программиста",
                "История началась рано утром, ",
                "когда программист вышел из дома, ",
                "решив выпить утренний кофе."
        );

        List<String> resultContent = bookEditor.processText(content);
        System.out.println(resultContent);
    }

    public List<String> processText(List<String> sourceText) {
        List<String> resultText = new ArrayList<>();

        String sourceHeader = sourceText.getFirst();
        String decoratedHeader = headerDecorator.decorate(sourceHeader);
        resultText.add(decoratedHeader);

        for (int i = 1; i < sourceText.size(); i++) {
            String currentLine = sourceText.get(i);
            for (LineProcessor processor : lineProcessors) {
                currentLine = processor.processLine(currentLine);
            }
            resultText.add(currentLine);
        }

        return resultText;
    }

    public void setHeaderDecorator(HeaderDecorator headerDecorator) {
        this.headerDecorator = headerDecorator;
    }

    public void addLineProcessor(LineProcessor lineProcessor) {
        this.lineProcessors.add(lineProcessor);
    }
}

interface HeaderDecorator {
    String decorate(String header);
}

interface LineProcessor {
    String processLine(String line);
}
