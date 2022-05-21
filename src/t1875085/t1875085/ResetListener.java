package t1875085;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// リセットボタンのアクションリスナー
public class ResetListener implements ActionListener {

	private Picross picross; // ゲームのセットアップ

	// コンストラクタ
	public ResetListener(Picross picross) {

		this.picross = picross;

	}

	// ボタンがクリックされた時
	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {

				picross.getButtonx().get(i).get(j).setBoolblack(false); // 全ての描画部分のボタンの■が描画されているかの真理値をfalseに
				picross.getButtonx().get(i).get(j).setBackground(Color.WHITE); // 全ての描画部分のボタンの色を白に設定
				picross.getButtonx().get(i).get(j).setBoolcross(false); // 全ての描画部分のボタンの×が描画されているかの真理値をfalseに
				picross.getButtonx().get(i).get(j).setIcon(null); // 全ての描画部分のボタンの×の描画を消去

			}

		}

		picross.getLabelFinish().setText("未完成"); // 完成しているかを表示するラベルに"未完成"と表示
		picross.setStart(System.currentTimeMillis());

	}

}
