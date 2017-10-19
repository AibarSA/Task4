package HomeWork;

public class SpaceUsageTooMuchException extends Throwable {
    @Override
    public String toString() {
        return "Space usage should be less than 70% of Room area.";
    }
}
