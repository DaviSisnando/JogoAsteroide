package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScorePers {

    public static ArrayList<Score> score = new ArrayList<Score>();

    public static void adicionarScore(Score s) throws Exception {

        score.add(s);

        Collections.sort(score, new Comparator<Score>() {
            @Override
            public int compare(Score s1, Score s2) {
                return Integer.valueOf(s2.getScore()).compareTo(s1.getScore());

            }
        });

        salvarScore();
    }

    public static void salvarScore() throws Exception {
        File f = new File("src\\score\\score.txt");

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);

            bw = new BufferedWriter(fw);

            for (Score scores : score) {
                bw.write(scores.getScore() + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        File f = new File("src\\score\\score.txt");

        if (f.exists()) {

            FileReader fr = null;
            BufferedReader br = null;

            try {
                fr = new FileReader(f);

                br = new BufferedReader(fr);

                String l;
                while ((l = br.readLine()) != null) {
                    String[] dados = l.split(";");

                    Score a = new Score(Integer.parseInt(dados[0]));
                    score.add(a);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    if (fr != null) {
                        fr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
