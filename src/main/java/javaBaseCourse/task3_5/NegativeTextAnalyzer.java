package javaBaseCourse.task3_5;

/**
 * Created by User on 07.01.2017.
 */
class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = new String[]{":(", "=(", ":|"};

    public NegativeTextAnalyzer() {
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
