package collections;

import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagTask {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public String findTag(String tag, String tagsLines) {
        errorsVerification(tag, tagsLines);
        ArrayDeque<String> allTags = findAllTags(tag, tagsLines);
        return findCorrectTags(tag, allTags);
    }

    private ArrayDeque<String> findAllTags(String tag, String tagsLines) {
        ArrayDeque<String> tagsDeque = new ArrayDeque<>();
        Pattern tagPattern = Pattern.compile("<[^/]|</\\w+>");
        Matcher tagMatcher = tagPattern.matcher(tagsLines);
        int openTagIndex = 0;
        boolean closeTagIsExists = false;
        while (tagMatcher.find()) {
            String foundTag = tagsLines.substring(tagMatcher.start(), tagMatcher.end());
            if (tagIsOpen(foundTag, tag) && closeTagIsExists) {
                    tagsDeque.add(tagsLines.substring(openTagIndex, tagMatcher.end() - 2)
                            .replaceAll(LINE_SEPARATOR, ""));
                    closeTagIsExists = false;
                    openTagIndex = getOpenTagStartIndex(tagMatcher);
            }
            if (tagIsClose(foundTag)) {
                closeTagIsExists = true;
                if (lineEndVerify(tagsLines, tagMatcher)) {
                    tagsDeque.add(tagsLines.substring(openTagIndex, tagMatcher.end())
                            .replaceAll(LINE_SEPARATOR, ""));
                }
            }
        }
        return tagsDeque;
    }

    private boolean lineEndVerify(String tagsLines, Matcher tagMatcher) {
        return tagsLines.length() <= tagMatcher.end();
    }

    private boolean tagIsOpen(String foundTag, String tag) {
        return foundTag.equals("<" + tag.substring(0, 1));
    }

    private boolean tagIsClose(String foundTag) {
        return foundTag.contains("</");
    }

    private int getOpenTagStartIndex(Matcher tagMatcher) {
        return tagMatcher.start();
    }

    private String findCorrectTags(String tag, ArrayDeque<String> tagsDeque) {
        StringBuilder correctTags = new StringBuilder();
        Pattern tagPattern = Pattern.compile("<\\w+>|<\\w+ ");
        for (String element : tagsDeque) {
            Matcher tagMatcher = tagPattern.matcher(element);
            boolean isFind = tagMatcher.find();
            if (isFind) {
                String openTag = element.substring(0, tagMatcher.end());
                if (openTag.equals("<" + tag + " ") || openTag.equals("<" + tag + ">")) {
                    correctTags.append(element).append(System.getProperty("line.separator"));
                }
            }
        }
        return correctTags.toString();
    }

    private void errorsVerification(String... inputLines) {
        for (String inputLine : inputLines) {
            if (!lineIsCorrect(inputLine)) {
                throw new NullPointerException("String is not correct");
            }
        }
    }

    private boolean lineIsCorrect(String... inputLines) {
        for (String inputLine : inputLines) {
            if (inputLine.length() == 0) {
                return false;
            }
        }
        return true;
    }
}
