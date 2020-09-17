package model.DTOs.Request;

public class ClientActionRequest {

    private String toFill;
    private int x;
    private int y;
    private int userId;


    public ClientActionRequest(String toFill, int x, int y, int userId) {
        this.toFill = toFill;
        this.x = x;
        this.y = y;
        this.userId = userId;
    }

    public String getToFill() {
        return toFill;
    }

    public void setToFill(String toFill) {
        this.toFill = toFill;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
