import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class mainMenu {

    private JPanel panel1;
    private JButton startButton;
    private JButton exitButton;
    private JPanel buttonPanel;

    public mainMenu() {
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Game game = new Game();
                game.start();
            }
        });
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int choose = JOptionPane.showOptionDialog(panel1,"确认退出吗? ","退出游戏",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
                if(choose == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public void start() {
        JFrame frame = new JFrame("mainMenu");
        frame.setContentPane(new mainMenu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.setVisible(true);
    }
}
