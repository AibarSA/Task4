package HomeWork.Entity;

public class Lightbulb {
    private int lightbulbIllumination;

    public Lightbulb(int illumination) {
        this.lightbulbIllumination = illumination;
    }

    public int getLightbulbIllumination() {
        return lightbulbIllumination;
    }

    @Override
    public String toString() {
        return "Lightbulb{" +
                "lightbulbIllumination=" + lightbulbIllumination +
                '}';
    }
}
