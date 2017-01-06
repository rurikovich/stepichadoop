package javaBaseCourse.task3_5;

/**
 * Created by User on 07.01.2017.
 */
 class TextProcessor {

    TextAnalyzer[] analyzers = new TextAnalyzer[]{
            new SpamAnalyzer(new String[]{"fuck"}),
            new NegativeTextAnalyzer(),
            new TooLongTextAnalyzer(100)
    };

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (!label.equals(Label.OK)) {
                return label;
            }
        }
        return Label.OK;
    }
}
