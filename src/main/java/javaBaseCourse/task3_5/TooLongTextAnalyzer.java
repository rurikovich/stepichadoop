package javaBaseCourse.task3_5;

/**
 * Created by User on 07.01.2017.
 */
class TooLongTextAnalyzer implements TextAnalyzer {

    private final int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return text.length() <= maxLength ? Label.OK : Label.TOO_LONG;
    }
}
