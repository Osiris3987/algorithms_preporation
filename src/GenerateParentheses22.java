import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses22 {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recursiveParenthesis(n, 0, 0, "", ans);
        return ans;
    }
    private static void recursiveParenthesis(int n, int openLength, int closeLength, String result, List<String> ans) {
        if (result.length() == n * 2) {
            ans.add(result.toString());
            return;
        }

        if (openLength < n) {
            recursiveParenthesis(n, openLength + 1, closeLength, result + "(", ans);
        }

        if (closeLength < openLength) {
            recursiveParenthesis(n, openLength, closeLength + 1, result + ")", ans);
        }
    }
}
/*
                                    (0, 0, '')
								 	    |
									(1, 0, '(')
								   /           \
							(2, 0, '((')      (1, 1, '()')
							   /                 \
						(2, 1, '(()')           (2, 1, '()(')
						   /                       \
					(2, 2, '(())')                (2, 2, '()()')
						      |	                             |
					res.append('(())')             res.append('()()')
 */