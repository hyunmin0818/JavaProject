package commission;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI {
    // 프레임, 패널, 레이블, 콤보박스, 버튼을 선언하는 클래스
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JComboBox<String> comboBox;
    private JButton button;

    // 생성자: GUI를 초기화하고 화면에 표시하는 역할
    public MainGUI() {
        // 프레임 및 패널, 레이블, 콤보박스, 버튼 초기화
        frame = new JFrame("수수료 계산기");
        panel = new JPanel();
        label = new JLabel("원하는 기능을 선택하세요:");
        comboBox = new JComboBox<String>(new String[]{"수수료 계산", "위탁 수수료", "낙찰 수수료", "부동산 중개 수수료 계산"});
        button = new JButton("선택");

        // 버튼에 액션 리스너 등록
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 콤보박스에서 선택된 인덱스를 가져와서 사용자의 선택에 따라 처리
                int choice = comboBox.getSelectedIndex() + 1;
                switch (choice) {
                    case 1:
                        // 수수료 계산 로직
                        double commissionRate = Double.parseDouble(JOptionPane.showInputDialog("수수료율을 입력하세요: "));
                        int transactionAmount1 = Integer.parseInt(JOptionPane.showInputDialog("거래 금액을 입력하세요: "));
                        int commission = (int) (transactionAmount1 * (commissionRate / 100));
                        JOptionPane.showMessageDialog(null, "수수료: " + commission + "원 입니다.");
                        break;

                    case 2:
                        // 위탁수수료 계산 로직
                        int transactionAmount2 = Integer.parseInt(JOptionPane.showInputDialog("거래 금액을 입력하세요: "));
                        double commission2 = transactionAmount2 * 0.11;
                        JOptionPane.showMessageDialog(null, "위탁 수수료: " + commission2 + "원 입니다.");
                        break;

                    case 3:
                        // 낙찰수수료 계산 로직
                        double bidAmount = Double.parseDouble(JOptionPane.showInputDialog("낙찰 금액을 입력하세요: "));
                        
                        // 낙찰 수수료율을 16.5%로 고정
                        double bidCommissionRate = 16.5;
                        
                        int bidCommission = (int) (bidAmount * (bidCommissionRate / 100));
                        
                        JOptionPane.showMessageDialog(null, "낙찰 수수료: " + bidCommission + "원 입니다.");
                        break;



                    case 4:
                        // 부동산 중개 수수료 계산 로직
                        String propertyTypeInput = JOptionPane.showInputDialog("부동산 유형을 선택하세요 (1. 주택, 2. 오피스텔, 3. 주택이외, 4. 고급주택): ");
                        int propertyType = Integer.parseInt(propertyTypeInput);
                        String transactionTypeInput = JOptionPane.showInputDialog("거래 유형을 선택하세요 (1. 매매/교환, 2. 임대): ");
                        int transactionType = Integer.parseInt(transactionTypeInput);
                        String transactionAmountInput = JOptionPane.showInputDialog("거래 금액을 입력하세요: ");
                        double transactionAmount = Double.parseDouble(transactionAmountInput);

                        MainHelper helper = new MainHelper();
                        int estateCommission = helper.calculateRealEstateCommission(propertyType, transactionType, transactionAmount);

                        JOptionPane.showMessageDialog(null, "부동산 중개 수수료: " + estateCommission + "원 입니다.");
                        break;

                    default:
                        // 잘못된 선택 시 안내 메시지 출력
                        JOptionPane.showMessageDialog(null, "다시 선택해주세요");
                        break;
                }
            }
        });

        // 패널에 레이블, 콤보박스, 버튼 추가 및 레이아웃 설정
        panel.add(label);
        panel.add(comboBox);
        panel.add(button);
        panel.setLayout(new FlowLayout());

        // 프레임 설정 및 화면에 표시
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    // 메인 메서드: GUI를 실행하는 역할
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainGUI();
            }
        });
    }
}