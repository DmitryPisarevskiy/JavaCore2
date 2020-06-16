package Lesson01;

public class Robot implements Competitable {
    private String name;
    private String type="Робот";
    private int maxRunDistance;
    private int maxJumpHeight;
    private final int MAX_JUMP_HEIGHT=0;
    private final int MAX_RUN_DISTANCE=50;
    private boolean isOnDistance;

    @Override
    public void info() {
        System.out.printf("%s %s: прыгает максимум %d метров, бегает максимум %d метров\n",type,name,maxJumpHeight,maxRunDistance);
    }

    public Robot(String name){
        this.name=name;
        maxJumpHeight=MAX_JUMP_HEIGHT;
        maxRunDistance=MAX_RUN_DISTANCE;
        isOnDistance=true;
    }

    public Robot(String name, int maxRunDistance, int maxJumpHeight){
        this.name=name;
        this.maxRunDistance=maxRunDistance;
        this.maxJumpHeight=maxJumpHeight;
        isOnDistance=true;
    }

    @Override
    public void jump(int height) {
        if (maxJumpHeight==0) {
            System.out.printf("%s %s не умеет прыгать\n", type, name);
            isOnDistance=false;
        } else if (height<=maxJumpHeight) {
            System.out.printf("%s %s перепрыгнул стену высотой %d метров\n", type, name, height);
        } else {
            System.out.printf("%s %s не смог перепрыгнуть стену высотой %d метров\n", type, name, height);
            isOnDistance=false;
        }
    }

    public boolean isOnDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if (maxRunDistance==0) {
            System.out.printf("%s %s не умеет бегать\n", type, name);
            isOnDistance=false;
        } else if (distance<=maxRunDistance) {
            System.out.printf("%s %s пробежал на беговой дорожке %d метров\n", type, name, distance);
        } else {
            System.out.printf("%s %s не смог пробежать на беговой дорожке %d метров\n", type, name, distance);
            isOnDistance=false;
        }
    }
}
