package t1;

/**
 * User: hp21 Date: 2013.12.05. Time: 13:08
 */
public class ReplaceBlank {

    public char[] replace(char[] string) {
        if (string == null || string.length == 0) {
            return string;
        }

        int size = 0;
        int spaces = 0;

        while (string[size] != 0) {
            if (string[size] == ' ') {
                spaces++;
            }

            size++;
        }

        int last = size + 2 * spaces - 1;
        int running = size - 1;

        while (running >= 0) {
            if (string[running] != ' ') {
                string[last--] = string[running--];
                continue;
            }

            // space at running counter
            string[last--] = '0';
            string[last--] = '2';
            string[last--] = '%';
            running--;
        }

        return string;
    }
}
