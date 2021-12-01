import org.apache.commons.lang3.StringUtils;

public class StringUtilsPlay {

    public static void main(String[] args) {
        String str1 = "hi there how are you open-new-document-1 fine good";
        String str3 = "\t" + "open-new-document-1:" + "\t";
        String str2 = "open-new-document-1";
        int n = StringUtils.countMatches(str3, str2);
        System.out.println(n);
    }
}
