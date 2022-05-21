package t1875085;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

// 問題のドット絵とその答えを持つ
public class ImagePikachu {

	private ArrayList<ArrayList<JButtonBool>> buttonx; // ボタンのリストのリスト, 縦方向の座標

	// コンストラクタ
	public ImagePikachu() {

		buttonx = new ArrayList<ArrayList<JButtonBool>>();

		for (int i = 0; i < 10; i++) {

			ArrayList<JButtonBool> buttony = new ArrayList<JButtonBool>(); // ボタンのリスト, 横方向の座標

			for (int j = 0; j < 10; j++) {

				JButtonBool button = new JButtonBool(false); // ボタンに初期値falseを持たせる
				buttony.add(button); // ボタンのリストに登録

			}

			buttonx.add(buttony); // ボタンのリストのリストに登録

		}

		// 答えのドットパターン
		buttonx.get(0).get(0).setBool(true);
		buttonx.get(0).get(3).setBool(true);
		buttonx.get(0).get(9).setBool(true);
		buttonx.get(1).get(0).setBool(true);
		buttonx.get(1).get(1).setBool(true);
		buttonx.get(1).get(3).setBool(true);
		buttonx.get(1).get(4).setBool(true);
		buttonx.get(1).get(8).setBool(true);
		buttonx.get(1).get(9).setBool(true);
		buttonx.get(2).get(1).setBool(true);
		buttonx.get(2).get(2).setBool(true);
		buttonx.get(2).get(4).setBool(true);
		buttonx.get(2).get(5).setBool(true);
		buttonx.get(2).get(6).setBool(true);
		buttonx.get(2).get(7).setBool(true);
		buttonx.get(2).get(8).setBool(true);
		buttonx.get(3).get(2).setBool(true);
		buttonx.get(3).get(3).setBool(true);
		buttonx.get(3).get(9).setBool(true);
		buttonx.get(4).get(2).setBool(true);
		buttonx.get(5).get(2).setBool(true);
		buttonx.get(5).get(4).setBool(true);
		buttonx.get(5).get(9).setBool(true);
		buttonx.get(6).get(1).setBool(true);
		buttonx.get(6).get(3).setBool(true);
		buttonx.get(6).get(4).setBool(true);
		buttonx.get(6).get(8).setBool(true);
		buttonx.get(6).get(9).setBool(true);
		buttonx.get(7).get(1).setBool(true);
		buttonx.get(7).get(2).setBool(true);
		buttonx.get(7).get(6).setBool(true);
		buttonx.get(8).get(1).setBool(true);
		buttonx.get(8).get(2).setBool(true);
		buttonx.get(8).get(5).setBool(true);
		buttonx.get(8).get(6).setBool(true);
		buttonx.get(8).get(7).setBool(true);
		buttonx.get(9).get(2).setBool(true);
		buttonx.get(9).get(3).setBool(true);
		buttonx.get(9).get(9).setBool(true);

	}

	// ラベル(ヒント)を設置
	public void LabelLocate(JPanel pane, ArrayList<JLabel> labels) {

		for (int i = 0; i < 22; i++) { // "1"

			JLabel label = new JLabel();
			label.setText("  1"); // ラベルタイトル
			labels.add(label); // ラベルを設置

		}

		for (int i = 0; i < 19; i++) { // "2"

			JLabel label = new JLabel();
			label.setText("  2"); // ラベルタイトル
			labels.add(label); // ラベルのリストに登録

		}

		for (int i = 0; i < 3; i++) { // "3"

			JLabel label = new JLabel();
			label.setText("  3"); // ラベルタイトル
			labels.add(label); // ラベルのリストに登録

		}

		// ラベル(ヒント)の位置を指定して設置
		labels.get(0).setBounds(325, 75, 25, 25);
		pane.add(labels.get(0));
		labels.get(1).setBounds(25, 100, 25, 25);
		pane.add(labels.get(1));
		labels.get(2).setBounds(50, 100, 25, 25);
		pane.add(labels.get(2));
		labels.get(3).setBounds(75, 100, 25, 25);
		pane.add(labels.get(3));
		labels.get(4).setBounds(75, 175, 25, 25);
		pane.add(labels.get(4));
		labels.get(5).setBounds(75, 200, 25, 25);
		pane.add(labels.get(5));
		labels.get(6).setBounds(25, 225, 25, 25);
		pane.add(labels.get(6));
		labels.get(7).setBounds(50, 225, 25, 25);
		pane.add(labels.get(7));
		labels.get(8).setBounds(75, 225, 25, 25);
		pane.add(labels.get(8));
		labels.get(9).setBounds(25, 250, 25, 25);
		pane.add(labels.get(9));
		labels.get(10).setBounds(75, 275, 25, 25);
		pane.add(labels.get(10));
		labels.get(11).setBounds(75, 325, 25, 25);
		pane.add(labels.get(11));
		labels.get(12).setBounds(175, 25, 25, 25);
		pane.add(labels.get(12));
		labels.get(13).setBounds(175, 50, 25, 25);
		pane.add(labels.get(13));
		labels.get(14).setBounds(175, 75, 25, 25);
		pane.add(labels.get(14));
		labels.get(15).setBounds(225, 50, 25, 25);
		pane.add(labels.get(15));
		labels.get(16).setBounds(225, 75, 25, 25);
		pane.add(labels.get(16));
		labels.get(17).setBounds(250, 50, 25, 25);
		pane.add(labels.get(17));
		labels.get(18).setBounds(275, 50, 25, 25);
		pane.add(labels.get(18));
		labels.get(19).setBounds(275, 75, 25, 25);
		pane.add(labels.get(19));
		labels.get(20).setBounds(300, 75, 25, 25);
		pane.add(labels.get(20));
		labels.get(21).setBounds(325, 25, 25, 25);
		pane.add(labels.get(21));
		labels.get(22).setBounds(325, 50, 25, 25);
		pane.add(labels.get(22));
		labels.get(23).setBounds(25, 125, 25, 25);
		pane.add(labels.get(23));
		labels.get(24).setBounds(50, 125, 25, 25);
		pane.add(labels.get(24));
		labels.get(25).setBounds(75, 125, 25, 25);
		pane.add(labels.get(25));
		labels.get(26).setBounds(50, 150, 25, 25);
		pane.add(labels.get(26));
		labels.get(27).setBounds(50, 175, 25, 25);
		pane.add(labels.get(27));
		labels.get(28).setBounds(50, 250, 25, 25);
		pane.add(labels.get(28));
		labels.get(29).setBounds(75, 250, 25, 25);
		pane.add(labels.get(29));
		labels.get(30).setBounds(50, 275, 25, 25);
		pane.add(labels.get(30));
		labels.get(31).setBounds(50, 300, 25, 25);
		pane.add(labels.get(31));
		labels.get(32).setBounds(50, 325, 25, 25);
		pane.add(labels.get(32));
		labels.get(33).setBounds(100, 75, 25, 25);
		pane.add(labels.get(33));
		labels.get(34).setBounds(125, 50, 25, 25);
		pane.add(labels.get(34));
		labels.get(35).setBounds(175, 0, 25, 25);
		pane.add(labels.get(35));
		labels.get(36).setBounds(200, 50, 25, 25);
		pane.add(labels.get(36));
		labels.get(37).setBounds(200, 75, 25, 25);
		pane.add(labels.get(37));
		labels.get(38).setBounds(250, 75, 25, 25);
		pane.add(labels.get(38));
		labels.get(39).setBounds(300, 50, 25, 25);
		pane.add(labels.get(39));
		labels.get(40).setBounds(325, 0, 25, 25);
		pane.add(labels.get(40));
		labels.get(41).setBounds(75, 300, 25, 25);
		pane.add(labels.get(41));
		labels.get(42).setBounds(125, 75, 25, 25);
		pane.add(labels.get(42));
		labels.get(43).setBounds(150, 75, 25, 25);
		pane.add(labels.get(43));
		JLabel label4 = new JLabel();

		label4.setText("  4"); // "4"
		label4.setBounds(150, 50, 25, 25);
		pane.add(label4);

		JLabel label5 = new JLabel();
		label5.setText("  5"); // "5"
		label5.setBounds(75, 150, 25, 25);
		pane.add(label5);

	}

	// クリア時に着色する
	public void color(ArrayList<ArrayList<JButtonBool2>> buttons) {

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {

				buttons.get(i).get(j).setBoolcross(false); // ×マーク状態であるかの真理値をfalseに
				buttons.get(i).get(j).setIcon(null); // ×を全消去

			}

		}

		// ドット絵を着色
		buttons.get(0).get(1).setBackground(Color.YELLOW);
		buttons.get(0).get(2).setBackground(Color.YELLOW);
		buttons.get(1).get(2).setBackground(Color.YELLOW);
		buttons.get(2).get(3).setBackground(Color.YELLOW);
		buttons.get(2).get(9).setBackground(Color.YELLOW);
		buttons.get(3).get(4).setBackground(Color.YELLOW);
		buttons.get(3).get(5).setBackground(Color.YELLOW);
		buttons.get(3).get(6).setBackground(Color.YELLOW);
		buttons.get(3).get(7).setBackground(Color.YELLOW);
		buttons.get(3).get(8).setBackground(Color.YELLOW);
		buttons.get(4).get(3).setBackground(Color.YELLOW);
		buttons.get(4).get(4).setBackground(Color.YELLOW);
		buttons.get(4).get(5).setBackground(Color.YELLOW);
		buttons.get(4).get(6).setBackground(Color.YELLOW);
		buttons.get(4).get(7).setBackground(Color.YELLOW);
		buttons.get(4).get(8).setBackground(Color.YELLOW);
		buttons.get(4).get(9).setBackground(Color.YELLOW);
		buttons.get(5).get(5).setBackground(Color.YELLOW);
		buttons.get(5).get(6).setBackground(Color.YELLOW);
		buttons.get(5).get(7).setBackground(Color.YELLOW);
		buttons.get(6).get(2).setBackground(Color.YELLOW);
		buttons.get(6).get(5).setBackground(Color.YELLOW);
		buttons.get(6).get(6).setBackground(Color.YELLOW);
		buttons.get(6).get(7).setBackground(Color.YELLOW);
		buttons.get(7).get(3).setBackground(Color.YELLOW);
		buttons.get(7).get(4).setBackground(Color.YELLOW);
		buttons.get(7).get(5).setBackground(Color.YELLOW);
		buttons.get(7).get(7).setBackground(Color.YELLOW);
		buttons.get(7).get(8).setBackground(Color.YELLOW);
		buttons.get(7).get(9).setBackground(Color.YELLOW);
		buttons.get(8).get(3).setBackground(Color.YELLOW);
		buttons.get(8).get(4).setBackground(Color.YELLOW);
		buttons.get(8).get(8).setBackground(Color.YELLOW);
		buttons.get(8).get(9).setBackground(Color.YELLOW);
		buttons.get(9).get(4).setBackground(Color.YELLOW);
		buttons.get(9).get(5).setBackground(Color.YELLOW);
		buttons.get(9).get(6).setBackground(Color.YELLOW);
		buttons.get(9).get(7).setBackground(Color.YELLOW);
		buttons.get(9).get(8).setBackground(Color.YELLOW);

		buttons.get(7).get(1).setBackground(Color.RED);
		buttons.get(7).get(2).setBackground(Color.RED);
		buttons.get(8).get(1).setBackground(Color.RED);
		buttons.get(8).get(2).setBackground(Color.RED);

	}

	// ボタンのリストのリスト(答え)のgetter
	public ArrayList<ArrayList<JButtonBool>> getButtonx() {

		return buttonx;

	}

}
