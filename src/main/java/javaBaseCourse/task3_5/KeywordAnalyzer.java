package javaBaseCourse.task3_5;

/**
 * Created by User on 07.01.2017.
 */
abstract class KeywordAnalyzer implements TextAnalyzer {

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String k : getKeywords()) {
            if (text.contains(k)) {
                return getLabel();
            }
        }
        return Label.OK;
    }


}
