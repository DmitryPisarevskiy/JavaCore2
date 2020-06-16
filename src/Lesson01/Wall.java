package Lesson01;

public class Wall implements Obstacles {
    private int height;

    public Wall(int height){
        this.height=height;
    }

    @Override
    public void info() {
        System.out.println("Стена высотой "+height+" метров");
    }

    @Override
    public void justDoIt(Competitable competitor) {
        competitor.jump(height);
    }
}
