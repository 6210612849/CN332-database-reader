
import java.security.interfaces.RSAPrivateCrtKey;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class App {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drawing", "root",
                    "yourpassword");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM drawing.drawing_database_real_csv;");
            try {
                JFrame fr = new JFrame();
                fr.setBounds(10, 10, 500, 500);
                fr.setDefaultCloseOperation(3);

                while (rs.next()) {
                    int pos_x = rs.getInt("position_x");
                    int pos_y = rs.getInt("postion_y");
                    String shape_draw = rs.getString("shape");
                    String size_draw = rs.getString("size");
                    int size_drawing_height;
                    int size_drawing_widht;
                    String raw_color = rs.getString("color");
                    color_setting used_color = new color_setting(raw_color);

                    if (size_draw.equals("small")) {
                        size_drawing_height = 40;
                        size_drawing_widht = 40;
                    } else if (size_draw.equals("medium")) {
                        size_drawing_height = 80;
                        size_drawing_widht = 80;
                    } else if (size_draw.equals("large")) {
                        size_drawing_height = 120;
                        size_drawing_widht = 120;
                    } else {
                        break;
                    }
                    JPanel pn = new JPanel() {
                        public void paint(Graphics g) {
                            Graphics2D g2 = (Graphics2D) g.create();
                            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                            switch (shape_draw) {
                                case "rectangle":
                                    g2.setColor(used_color.getColor());
                                    g2.fillRect(pos_x, pos_y, size_drawing_height, size_drawing_widht);
                                    break;
                                case "circle":
                                    g2.setColor(used_color.getColor());
                                    g2.fillOval(pos_x, pos_y, size_drawing_height, size_drawing_widht);
                                    break;
                                case "triangle":
                                    int[] xpoint = { pos_x, pos_x + size_drawing_widht / 2,
                                            pos_x + size_drawing_widht };
                                    int[] ypoint = { pos_y, pos_y + size_drawing_height, pos_y };
                                    int npoint = 3;
                                    g2.setColor(used_color.getColor());
                                    g2.fillPolygon(xpoint, ypoint, npoint);

                            }
                        }
                    };

                    fr.add(pn);
                    fr.setVisible(true);
                }
            }

            catch (SQLException f) {
                System.out.println("fail query cause :");
                System.out.println(f);

            }
            con.close();
        }

        catch (Exception e) {
            System.out.println("fail cause :");
            System.out.println(e);
        }

    }
}
