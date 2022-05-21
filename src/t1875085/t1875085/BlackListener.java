package t1875085;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ■描画モードボタンのアクションリスナー
public class BlackListener implements ActionListener {

	private Picross picross; // ゲームのセットアップ

	public BlackListener(Picross picross) { // コンストラクタ

		this.picross = picross;

	}

	// ボタンがクリックされた時
	@Override
	public void actionPerformed(ActionEvent e) {

		if (!picross.getButtonblack().getBool()) { // ■描画モードでないならば

			picross.getButtoncross().setBool(!picross.getButtoncross().getBool()); // ×描画モードボタンの真理値を反転
			picross.getButtonblack().setBool(!picross.getButtonblack().getBool()); // ■描画モードボタンの真理値を反転

		}

	}

}
