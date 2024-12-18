
public class Sign {
    private String message;
    private int width;

    public Sign(String message, int width) {
        this.message = message;
        this.width = width;
    }
    public int numberOfLines() {
        return (int) (Math.ceil(message.length() / (double) width));
    }
}