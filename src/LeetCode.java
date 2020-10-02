import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode {	public static void main(String[] args) {
    String path = "/a//b////c/d//././/..";
    System.out.println(simplifyPath(path));
}

    public static String simplifyPath(String path) {
        if(path.length() == 0) {
            return "/";
        }
        String[] p = path.split("/");
        Deque<String> pDeque = new ArrayDeque<String>();
        for(int i=0; i < p.length; i ++) {
            handle(pDeque, p[i]);
        }
        String rt = "";
        if(pDeque.size() == 0) {
            rt = "/";
        }
        else {
            while(pDeque.size() > 0) {
                rt += "/"+ pDeque.removeFirst();
            }
        }
        return rt;
    }

    private static void handle(Deque<String> pDeque, String string) {
        switch (string) {
            case ".":
            case "":
                break;
            case "..":
                if(pDeque.size() > 0) {
                    pDeque.removeLast();
                }
                break;
            default:
                pDeque.addLast(string);
                break;
        }
    }
}
