package Seminar3;

public class Answer {
  private  int cowCount;
  private int bullCount;
  private   Integer tryCount;


    public Answer(int cowCount, int bullCount, Integer tryCount) {
        this.cowCount = cowCount;
        this.bullCount = bullCount;
        this.tryCount = tryCount;
    }


    @Override
    public String toString() {
        return cowCount + "коровы, " + bullCount + "быков," + tryCount + "попыток";
    }
}
