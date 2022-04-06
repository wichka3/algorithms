package AmazonOA.dfs;

/**
 * Created by bashir on 1/3/2021.
 */
public class MaximumVacationDays {

    public static void main(String[] args) {

        int[][] flights= new int[][]{
                {0,1,1},
                {1,0,1},
                {1,1,0}
        };

        int[][] days= new int[][]{
           /*c1*/     {1,3,1},
           /*c2*/     {6,0,3},
           /*c3*/     {3,3,3}
                    // w1,w2,w3

        };
        MaximumVacationDays maximumVacationDays= new MaximumVacationDays();
        int ret=maximumVacationDays.maxVacatioNDays(flights, days);
        System.out.println(ret);

    }

    public int maxVacatioNDays(int[][] flights, int[][] days)
    {
        int[][] memo= new int[days.length][days[0].length];
        int ret = helper(flights, days, 0, 0, memo);
        return ret;
    }

    public int helper(int[][] flights, int[][] days, int start_city,  int weekno, int[][] memo)
    {
        if ( weekno == days[0].length)
        {
            return 0;
        }
        int vacationstaken=0;

        if ( memo[start_city][weekno] != 0) return  memo[start_city][weekno];
        for (int destination = 0; destination < days.length; destination++) {

            if ( start_city== destination || flights[start_city][destination] == 1) {

                int tmp_vacations=days[start_city][destination];
                int ret = tmp_vacations+helper(flights, days, destination, weekno+1, memo);
                vacationstaken = Math.max(vacationstaken, ret);
            }
        }
        memo[start_city][weekno]=vacationstaken;
        return vacationstaken;

    }
}
