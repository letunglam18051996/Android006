package winds.com.androidtutorial.recyclerview;

public class History {
    String title;
    int point;

    String icon;

    public History(String title, int point, String icon) {
        this.title = title;
        this.point = point;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}