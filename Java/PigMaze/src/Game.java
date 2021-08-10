import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

class Game {
    private JPanel mainField;
    private JPanel optionField;
    private JPanel SetPanel;
    private JComboBox<String> comboBox1;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JSpinner spinner6;
    private JSpinner spinner7;
    private JSpinner spinner8;
    private JTextArea textArea1;
    private JButton startButton;
    private JButton createMapbutton;
    private JButton addButton;
    private JButton deleteButton;
    public int mode;
    public int[][] map;
    public int[][] tmpMap;
    public Vector<Point> monsters;
    public Point start;
    public Point end;

    public Game() {
        monsters = new Vector<Point>();
        mode = 0;
        comboBox1.addItem("1.经典(最短路径)");
        comboBox1.addItem("2.挑战(最少转弯)");
        comboBox1.addItem("3.除妖(经过妖怪)");
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(map == null){
                    JOptionPane.showMessageDialog(mainField,"请先生成地图！","游戏未初始化", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                mode = comboBox1.getSelectedIndex();
                switch(mode){
                    case 0 -> {
                        AStar A1 = new AStar(map,(int)spinner2.getValue(),(int)spinner1.getValue());
                        showResult(A1.start(start,end));
                    }
                    case 1 -> {
                        AStarPlus1 A2 = new AStarPlus1(map,(int)spinner2.getValue(),(int)spinner1.getValue());
                        dPoint dstart = new dPoint();
                        dPoint dend = new dPoint();
                        dstart.setXY(start);
                        dend.setXY(end);
                        showResult(A2.dStart(dstart,dend));
                    }
                    case 2 -> {
                        AStarPlus2 A3 = new AStarPlus2(map,(int)spinner2.getValue(),(int)spinner1.getValue());
                        Vector<Point> tmp = new Vector<>();
                        monsters.insertElementAt(start,0);
                        monsters.addElement(end);
                        tmp.addElement(start);
                        for (int i = 0;i < monsters.size()-1;) {
                            tmp.addAll(A3.start(monsters.get(i),monsters.get(++i)));
                        }
                        showResult(tmp);
                        textArea1.append("\n若切换为其他模式，请重启游戏窗口再进入本模式！");
                    }
                    default -> {
                        return;
                    }
                }
            }
        });
        createMapbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                map = new int[(int)spinner2.getValue()][(int)spinner1.getValue()];
                start = new Point((int)spinner3.getValue(),(int)spinner4.getValue());
                end = new Point((int)spinner5.getValue(),(int)spinner6.getValue());
                map[start.y][start.x] = 2;
                map[end.y][end.x] = 2;
                tmpMap = copyMap(map);
                showMap(map);
            }
        });
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point mon = new Point((int)spinner7.getValue(),(int)spinner8.getValue());
                monsters.addElement(mon);
                map[mon.y][mon.x] = 1;
                tmpMap[mon.y][mon.x] = 1;
                showMap(map);
            }
        });
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                map[(int)spinner8.getValue()][(int)spinner7.getValue()] = 0;
                showMap(map);
            }
        });
    }

    public void start() {
        JFrame frame = new JFrame("Game");
        frame.setContentPane(new Game().mainField);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,460);
        frame.setVisible(true);
    }

    public void showMap(int[][] map){
        textArea1.setText("");
        textArea1.append("图例：0-空地，1-妖怪，2-起点和终点，3-路径\n");
        for(int[] arr : map){
            for(int index : arr){
                textArea1.append(index + "   ");
            }
            textArea1.append("\n");
        }
    }

    public void showResult(Vector<Point> results){
        if(!results.isEmpty()){
            for(int i = 1; i < results.size();i++){
                tmpMap[results.elementAt(i).y][results.elementAt(i).x] = 3;
            }
            showMap(tmpMap);
            textArea1.append("Path found.");
            tmpMap = copyMap(map);
        }
        else{
            textArea1.append("Path not found.");
        }
    }

    public int[][] copyMap(int[][] map){
        int[][] tmpMap = new int[map.length][map[0].length];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                tmpMap[i][j] = map[i][j];
            }
        }
        return tmpMap;
    }
}
