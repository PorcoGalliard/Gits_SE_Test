package org.msib.second;

import java.util.*;

public class Dense_Ranking {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah semua pemain: ");
        int totalPlayers = SCANNER.nextInt();

        System.out.print("Masukkan jumlah pemain GITS: ");
        int gitsPlayers = SCANNER.nextInt();

        System.out.println("Masukkan score semua pemain: ");
        List<Integer> scores = getScores(totalPlayers);

        System.out.println("Masukkan score pemain GITS: ");
        List<Integer> gitsPlayerScores = getScores(gitsPlayers);

        List<Integer> rankings = denseRanking(scores, gitsPlayerScores);

        for (int rank : rankings) {
            System.out.println("Rank Pemain GITS: ");
            System.out.print(rank + " ");
        }
    }

    public static List<Integer> getScores(int size) {
        List<Integer> scores = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            scores.add(SCANNER.nextInt());
        }
        return scores;
    }

    public static List<Integer> denseRanking(List<Integer> scores, List<Integer> gitsScores){
        List<Integer> allScores = new ArrayList<>(scores);
        allScores.addAll(gitsScores);

        List<Integer> uniqueScores = new ArrayList<>(new HashSet<>(allScores));
        uniqueScores.sort(Collections.reverseOrder());

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int score : uniqueScores) {
            rankMap.put(score, rank);
            rank++;
        }

        List<Integer> result = new ArrayList<>();
        for (int gitScore : gitsScores) {
            int gitsRank = rankMap.getOrDefault(gitScore, rank);
            result.add(gitsRank);
        }

        return result;

    }


}
