import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*

Use the IDE shortcuts to assist in creating the class and methods.

*/
class WordProblemSolver {

    public int solve(String sentence){
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(sentence.replace("?", "")," ");

        int result = 0;
        while(tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            try {
                int num = Integer.parseInt(token);
            }
            catch {}

        }
        return 5;
    }

    boolean isNumber(String token) {
        return false;
    }

}
