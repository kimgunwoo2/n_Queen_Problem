package ����1�ܰ�;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class gui���α׷� extends JFrame {
	JButton[][] btnNewButton;
	JPanel board = new JPanel();
	private JTextField textField;
	int x;
	int y = 0;
	public gui���α׷�() {
		super("n �� �� ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RecursiveAlgorithm Recur = new RecursiveAlgorithm();
		IterativeAlgorithm Itera = new IterativeAlgorithm();
		setSize(800, 950);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JLabel page = new JLabel("0/0");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		JLabel timee = new JLabel("\uD0D0\uC0C9\uC2DC\uAC04 :");
		getContentPane().add(board, BorderLayout.CENTER);

		JRadioButton Iterativebutton = new JRadioButton("\uBC18\uBCF5");
		panel.add(Iterativebutton);

		JRadioButton Recursivebutton = new JRadioButton("\uC21C\uD658");
		panel.add(Recursivebutton);
		Iterativebutton.setSelected(true);
		Iterativebutton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JRadioButton Iterativebutton = (JRadioButton) e.getSource();
				if (Iterativebutton.isSelected())
					Recursivebutton.setSelected(false);
			}
		});
		Recursivebutton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JRadioButton Recursivebutton = (JRadioButton) e.getSource();
				if (Recursivebutton.isSelected())
					Iterativebutton.setSelected(false);
			}
		});

		if (Iterativebutton.isSelected())
			Recursivebutton.setSelected(false);
		if (Recursivebutton.isSelected())
			Iterativebutton.setSelected(false);
		JLabel sizee = new JLabel("\uD06C\uAE30 \uC785\uB825 :");
		sizee.setFont(new Font("����", Font.BOLD, 15));
		panel.add(sizee);
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(4);
		textField.setText("");
		JOptionPane.showMessageDialog(null, "-n�� ����-\n  NxN ũ���� ü���ǿ� ���� ������ �ʰ� N�� ��ġ�ϴ� �� ����\n���� �밢���� ���� ��,�� ���� ����  ",
				"��������", JOptionPane.INFORMATION_MESSAGE);
		ImageIcon no = new ImageIcon();
		ImageIcon normal = new ImageIcon("C:\\Users\\dd\\Documents\\īī���� ���� ����\\��1.jpg");
		Image img = normal.getImage();
		ImageIcon normal1 = new ImageIcon(img.getScaledInstance(10, 10, Image.SCALE_SMOOTH));

		JButton sizeset = new JButton("\uD06C\uAE30\uC124\uC815\r\n");
		sizeset.setSelectedIcon(null);
		sizeset.setBackground(Color.GREEN);
		sizeset.setForeground(Color.BLACK);
		panel.add(sizeset);
		sizeset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				long starttime = 0, endtime = 0, estimatedTime = 0;
				y = 0;
				try {
					x = Integer.valueOf(textField.getText());
				} catch (NumberFormatException v) {
					JOptionPane.showMessageDialog(null, "ũ�⸦ �ٽ� �Է����ּ���\n 4�̻��� �ڿ���", "�˸�â",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				JButton b = (JButton) e.getSource();
				board.removeAll();

				if (x >= 4) {
					starttime = System.currentTimeMillis();
					if (Iterativebutton.isSelected()) {
						Itera.vc.clear();
						Itera.start(x);
					} else if (Recursivebutton.isSelected()) {
						Recur.vc.clear();
						Recur.start(x);
					}
				
					endtime = System.currentTimeMillis();
					estimatedTime = endtime - starttime;
					timee.setText("\uD0D0\uC0C9\uC2DC\uAC04 :" + estimatedTime+" ms");
				}
				if (Iterativebutton.isSelected()) {
					page.setText(" page : " + (y) + "/" + Itera.vc.size());
				} else if (Recursivebutton.isSelected()) {
					page.setText(" page : " + (y) + "/" + Recur.vc.size());
				}
				if (x < 4) {
					JOptionPane.showMessageDialog(null, "ũ�⸦ �ٽ� �Է����ּ���", "�˸�â", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				btnNewButton = new JButton[x][x];
				board.setLayout(new GridLayout(x, x));
			
					for (int a = 1; a <= x; a++) {
						for (int c = 1; c <= x; c++) {
							btnNewButton[a - 1][c - 1] = new JButton(a + "," + c + "");
							if ((a + c) % 2 == 0) {
								btnNewButton[a - 1][c - 1].setBackground(Color.WHITE);
								btnNewButton[a - 1][c - 1].setForeground(Color.BLACK);
								board.add(btnNewButton[a - 1][c - 1]);
							} else if ((a + c) % 2 == 1) {
								btnNewButton[a - 1][c - 1].setBackground(Color.BLACK);
								btnNewButton[a - 1][c - 1].setForeground(Color.WHITE);
								board.add(btnNewButton[a - 1][c - 1]);
							}
						}
					}
			
			}
		});

		JButton place = new JButton("\uC704\uCE58\uD655\uC778");
		place.setBackground(Color.YELLOW);
		panel.add(place);
		place.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y = 0;
				for (int a = 1; a <= x; a++) {
					for (int c = 1; c <= x; c++) {
						if ((a + c) % 2 == 0) {
							btnNewButton[a - 1][c - 1].setBackground(Color.WHITE);
							btnNewButton[a - 1][c - 1].setForeground(Color.BLACK);
							btnNewButton[a - 1][c - 1].setIcon(no);
						} else if ((a + c) % 2 == 1) {
							btnNewButton[a - 1][c - 1].setBackground(Color.BLACK);
							btnNewButton[a - 1][c - 1].setForeground(Color.WHITE);
							btnNewButton[a - 1][c - 1].setIcon(no);
						}
					}
				}
				if (Iterativebutton.isSelected()) {
					page.setText(" page : " + (y + 1) + "/" + Itera.vc.size());
				} else if (Recursivebutton.isSelected()) {
					page.setText(" page : " + (y + 1) + "/" + Recur.vc.size());
				}
				for (int o = 0; o < x; o++) {
					if (Iterativebutton.isSelected()) {
						ImageIcon normal1 = new ImageIcon(img.getScaledInstance(
								btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
										.getWidth(),
								btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
										.getHeight(),
								Image.SCALE_SMOOTH));
						btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1].setIcon(normal1);
						btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
								.setBackground(Color.BLACK);
					} else if (Recursivebutton.isSelected()) {
						ImageIcon normal1 = new ImageIcon(img.getScaledInstance(
								btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
										.getWidth(),
								btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
										.getHeight(),
								Image.SCALE_SMOOTH));
						btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1].setIcon(normal1);
						btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
								.setBackground(Color.BLACK);
					}
				}
			}
		});

		panel.add(page);
		if (Iterativebutton.isSelected()) {
			page.setText(" page : " + (y) + "/" + Itera.vc.size());
		} else if (Recursivebutton.isSelected()) {
			page.setText(" page : " + (y) + "/" + Recur.vc.size());
		}
		JButton pre = new JButton("pre");
		panel.add(pre);
		pre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y--;
				if (Iterativebutton.isSelected()) {
					page.setText(" page : " + (y + 1) + "/" + Itera.vc.size());
				} else if (Recursivebutton.isSelected()) {
					page.setText(" page : " + (y + 1) + "/" + Recur.vc.size());
				}
				for (int a = 1; a <= x; a++) {
					for (int c = 1; c <= x; c++) {
						if ((a + c) % 2 == 0) {
							btnNewButton[a - 1][c - 1].setBackground(Color.WHITE);
							btnNewButton[a - 1][c - 1].setForeground(Color.BLACK);
							btnNewButton[a - 1][c - 1].setIcon(no);
						} else if ((a + c) % 2 == 1) {
							btnNewButton[a - 1][c - 1].setBackground(Color.BLACK);
							btnNewButton[a - 1][c - 1].setForeground(Color.WHITE);
							btnNewButton[a - 1][c - 1].setIcon(no);
						}
					}
				}
				for (int o = 0; o < x; o++) {
					if (y < 0) {
						JOptionPane.showMessageDialog(null, "�� �̻� �ذ� �����ϴ�", "�˸�â", JOptionPane.INFORMATION_MESSAGE);
						y++;
						if (Iterativebutton.isSelected()) {
							page.setText(" page : " + (y + 1) + "/" + Itera.vc.size());
						} else if (Recursivebutton.isSelected()) {
							page.setText(" page : " + (y + 1) + "/" + Recur.vc.size());
						}
					}
					if (Iterativebutton.isSelected()) {
						ImageIcon normal1 = new ImageIcon(img.getScaledInstance(
								btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
										.getWidth(),
								btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
										.getHeight(),
								Image.SCALE_SMOOTH));
						btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1].setIcon(normal1);
						btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
								.setBackground(Color.BLACK);
					} else if (Recursivebutton.isSelected()) {
						ImageIcon normal1 = new ImageIcon(img.getScaledInstance(
								btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
										.getWidth(),
								btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
										.getHeight(),
								Image.SCALE_SMOOTH));
						btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1].setIcon(normal1);
						btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
								.setBackground(Color.BLACK);
					}
				}

			}
		});
		JButton next = new JButton("next");
		panel.add(next);

		panel.add(timee);

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y++;
				if (Iterativebutton.isSelected()) {
					page.setText(" page : " + (y + 1) + "/" + Itera.vc.size());
				} else if (Recursivebutton.isSelected()) {
					page.setText(" page : " + (y + 1) + "/" + Recur.vc.size());
				}
				for (int a = 1; a <= x; a++) {
					for (int c = 1; c <= x; c++) {
						if ((a + c) % 2 == 0) {
							btnNewButton[a - 1][c - 1].setBackground(Color.WHITE);
							btnNewButton[a - 1][c - 1].setForeground(Color.BLACK);
							btnNewButton[a - 1][c - 1].setIcon(no);
						} else if ((a + c) % 2 == 1) {
							btnNewButton[a - 1][c - 1].setBackground(Color.BLACK);
							btnNewButton[a - 1][c - 1].setForeground(Color.WHITE);
							btnNewButton[a - 1][c - 1].setIcon(no);
						}
					}
				}
				for (int o = 0; o < x; o++) {
					if (Iterativebutton.isSelected())
						if (y >= Itera.vc.size()) {
							JOptionPane.showMessageDialog(null, "�� �̻� �ذ� �����ϴ�", "�˸�â", JOptionPane.INFORMATION_MESSAGE);
							y--;
							page.setText(" page : " + (y + 1) + "/" + Itera.vc.size());
						}
					if (Recursivebutton.isSelected())
						if (y >= Recur.vc.size()) {
							JOptionPane.showMessageDialog(null, "�� �̻� �ذ� �����ϴ�", "�˸�â", JOptionPane.INFORMATION_MESSAGE);
							y--;
							page.setText(" page : " + (y + 1) + "/" + Recur.vc.size());
						}
					if (Iterativebutton.isSelected()) {
						ImageIcon normal1 = new ImageIcon(img.getScaledInstance(
								btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
										.getWidth(),
								btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
										.getHeight(),
								Image.SCALE_SMOOTH));
						btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
								.setIcon(normal1);
						btnNewButton[Itera.vc.elementAt(y).getanswer(o).getx() - 1][Itera.vc.elementAt(y).getanswer(o).gety() - 1]
								.setBackground(Color.BLACK);
					} else if (Recursivebutton.isSelected()) {
						ImageIcon normal1 = new ImageIcon(img.getScaledInstance(
								btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
										.getWidth(),
								btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
										.getHeight(),
								Image.SCALE_SMOOTH));
						btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
								.setIcon(normal1);
						btnNewButton[Recur.vc.elementAt(y).getanswer(o).getx() - 1][Recur.vc.elementAt(y).getanswer(o).gety() - 1]
								.setBackground(Color.BLACK);
					}
				}

			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		new gui���α׷�();
	}
}