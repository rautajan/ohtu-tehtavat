package ohtu.io;

import java.util.ArrayList;
import java.util.List;

public class StubIO implements IO {

    private List<String> lines;
    private int i;
    private ArrayList<String> prints;

    public StubIO(List<String> values) {
        this.lines = values;
        prints = new ArrayList<>();
    }

    public void print(String toPrint) {
        prints.add(toPrint);
//        System.out.println("prints listan sisältö (print): " + prints);
    }

    public int readInt(String prompt) {
        print(prompt);
        return Integer.parseInt(lines.get(i++));
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

    public String readLine(String prompt) {
//        System.out.println("saavuin readlineen parametrein " + prompt);
//        System.out.println("prints listan sisältö: " + prints);
        print(prompt);
        if (i < lines.size()) {
//            System.out.println("TÄNNE??" + i);
//            System.out.println("listan alkio" + lines.get(i));
            return lines.get(i++);
        }
//        System.out.println("Mitä palautan?");
        return "";
    }
}
