package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int input = Integer.parseInt(br.readLine());
        int check = 0;
        String[] data;
        for (int i = 0; i < input; i++) {
            data = br.readLine().split("");
            for (String j : data) {
                if (j == "(") {
                    check++;
                } else if(j == ")") {
                    check--;
                }
            }
            
            if (check == 0) {
                bw.write("YES");
                bw.write("\n");
            } else {
                bw.write("NO");
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

