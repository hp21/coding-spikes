package rmdupl;

/**
 * http://maxnoy.com/interviews.html <br/>
 * <br/>
 * 
 * Remove duplicate chars from a string ("AAA BBB" -> "A B")<br/>
 * int RemoveDups(char* szStr)
 * 
 * User: hp21 Date: 2013.11.13. Time: 13:45
 */
public class RemoveDuplicates implements IRemoveDuplicates {

    public static final String EMPTY_STRING = "";

    @Override
    public String removeDuplicates(String string) {

        if (string == null) {
            return string;
        }

        StringBuilder response = new StringBuilder();
        String current = "";

        for (int i = 0; i < string.length(); i++) {
            final String next = string.substring(i, i + 1);

            if (!next.equals(current)) {
                addToRespoonse(response, current);
                current = next;
            }
        }

        addToRespoonse(response, current);
        return response.toString();
    }

    private StringBuilder addToRespoonse(StringBuilder response, String current) {
        return response.append(EMPTY_STRING.equals(current) ? EMPTY_STRING : current);
    }

}
