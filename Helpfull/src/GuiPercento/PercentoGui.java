package GuiPercento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PercentoGui extends JFrame {
    private JTextField textHodnota;
    private JTextField textPercenta;
    private JButton vyhodnotiťButton;
    private JTextArea textArea1;
    private JButton resetButton;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private double vyhodnotenie;

    public PercentoGui() {
        super("Percento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("src\\GuiPackages\\Obrazky\\ML2.jpg").getImage());
        setContentPane(panel1);
        spracujData();
        reset();
        pack();
        setCenterOfScreen();
        setVisible(true);

    }

    public void reset(){
        resetButton.setBackground(Color.white);
        resetButton.setBorder(null);
        resetButton.setFocusPainted(false);
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetButton.setBackground(Color.black);
                resetButton.setForeground(Color.white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetButton.setBackground(Color.white);
                resetButton.setForeground(Color.black);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                textHodnota.setText("");
                textPercenta.setText("");
            }
        });
    }

    public void spracujData(){
        vyhodnotiťButton.setBackground(Color.white);
        vyhodnotiťButton.setBorder(null);
        vyhodnotiťButton.setFocusPainted(false);
        vyhodnotiťButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vyhodnotiťButton.setBackground(Color.black);
                vyhodnotiťButton.setForeground(Color.white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                vyhodnotiťButton.setBackground(Color.white);
                vyhodnotiťButton.setForeground(Color.black);
            }
        });
        vyhodnotiťButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double hodnota = Double.parseDouble(textHodnota.getText());
                    double percenta = Integer.parseInt(textPercenta.getText());
                    double pomHod = hodnota / 100.0;
                    pomHod = pomHod * (percenta / 1000.0);
                    vyhodnotenie =  (pomHod * 1000.0);
                    textArea1.setText("  Z " + hodnota + " je " + percenta + "% = " + vyhodnotenie);
                } catch (Exception ex) {
                    textArea1.setText("Niečo je zle, oprav sa a opakuj pokus.");
                }
            }
        });
    }

    public void setCenterOfScreen(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
}
