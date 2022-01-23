import java.awt.Color;

public class color_setting {
    private Color main_color;

    public color_setting() {
        main_color = Color.black;
    }

    public color_setting(String str_color) {
        if (str_color.equals("red")) {
            main_color = Color.red;
        } else if (str_color.equals("blue")) {
            main_color = Color.blue;
        }

        else if (str_color.equals("yellow")) {
            main_color = Color.yellow;
        } else if (str_color.equals("black")) {
            main_color = Color.black;
        } else if (str_color.equals("green")) {
            main_color = Color.green;
        } else if (str_color.equals("orange")) {
            main_color = Color.orange;
        } else if (str_color.equals("pink")) {
            main_color = Color.pink;
        } else if (str_color.equals("gray")) {
            main_color = Color.gray;
        } else {
            main_color = Color.black;
        }
    }

    public Color getColor() {
        return main_color;
    }

    public String tostrString() {
        return "color";
    }
}
