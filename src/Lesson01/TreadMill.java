package Lesson01;

public class TreadMill implements Obstacles {
    private int distance;

    public TreadMill(int distance) {
        this.distance=distance;
    }

    @Override
    public void justDoIt(Competitable competitor) {
        competitor.run(distance);
    }

    @Override
    public void info() {
        System.out.println("Беговая дорожка "+distance+" метров");
    }
}
