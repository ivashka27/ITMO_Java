package md2html;

import java.util.*;

public class ParseTexts {
    private StringBuilder sb;
    private static Set<Character> tagStart;
    private static Map<String, String> htmlTags;
    private static Map<Character, String> specTag;

    static {
        specTag = Map.of(
                '<', "&lt;",
                '>', "&gt;",
                '&', "&amp;"
        );

        htmlTags = Map.of(
                "*", "em",
                "**", "strong",
                "_", "em",
                "__", "strong",
                "--", "s",
                "`", "code",
                "```", "pre"
        );

        tagStart = Set.of('*', '-', '_', '`');

    }

    ParseTexts(StringBuilder sb) {
        this.sb = sb;
    }

    private String getSpecialHtml(char x) {
        if (specTag.containsKey(x)) {
            return specTag.get(x);
        }
        return null;
    }

    private String getHtmlTag(String tag) {
        if (htmlTags.containsKey(tag)) {
            return htmlTags.get(tag);
        }
        return null;
    }

    private boolean checkStart(char x) {
        return tagStart.contains(x);
    }

    public void toHtml(StringBuilder result) {
        List<String> currentResult = new ArrayList<>();
        Map<String, Integer> allTags = new HashMap<>();
        int idx = 0;
        while (idx < sb.length()) {
            String s = getSpecialHtml(sb.charAt(idx));
            if (s != null) {
                idx++;
                currentResult.add(s);
            }

            StringBuilder currentStr = new StringBuilder();
            while (idx < sb.length() && !checkStart(sb.charAt(idx)) &&
                    getSpecialHtml(sb.charAt(idx)) == null && sb.charAt(idx) != '\\')  {
                currentStr.append(sb.charAt(idx++));
            }

            if (currentStr.length() != 0) {
                currentResult.add(currentStr.toString());
                currentStr.setLength(0);
            }

            if (idx < sb.length() && sb.charAt(idx) == '\\') {
                currentResult.add(sb.substring(idx + 1, idx + 2));
                idx += 2;
            }
            while (idx < sb.length() && checkStart(sb.charAt(idx))
                    && (currentStr.length() < 2 || currentStr.charAt(currentStr.length() - 1) == '`')) {
                currentStr.append(sb.charAt(idx++));
            }
            System.out.println(currentStr);
            if (currentStr.length() == 0) {
                continue;
            }

            String currentTag = currentStr.toString();
            if(currentTag.equals("``")) {
                currentResult.add("<code></code>");
                continue;
            }
            currentResult.add(currentTag);
            Integer l = allTags.get(currentTag);
            if (l != null) {
                allTags.remove(currentTag);
                String str = getHtmlTag(currentTag);
                if (str != null) {
                    currentResult.set(l, "<" + str + ">");
                    currentResult.set(currentResult.size() - 1, "</" + str + ">");
                }
            } else {
                allTags.put(currentTag, currentResult.size() - 1);
                if(currentTag.equals("```")) {
                    currentStr.setLength(0);
                    while(idx < sb.length()) {
                        currentStr.append(sb.charAt(idx++));
                        if(idx + 2 < sb.length() && sb.charAt(idx) == '`'
                                && sb.charAt(idx + 1) == '`' && sb.charAt(idx + 2) == '`') {
                            break;
                        }
                    }
                    currentResult.add(currentStr.toString());
                }
            }
        }

        for (int i = 0; i < currentResult.size(); i++) {
            result.append(currentResult.get(i));
        }
    }
}
