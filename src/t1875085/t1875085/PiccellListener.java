package t1875085;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// ボタン(描画部分)のアクションリスナー
public class PiccellListener implements ActionListener {

	private Picross picross; // ゲームのセットアップ
	private JButtonBool2 button; // 描画部分のボタン
	private ImagePikachu answer; // 問題のドット絵とその答えを持つ
	private Finish finish; // クリア判定をする
	private RestAPICaller caller;

	// コンストラクタ
	public PiccellListener(Picross picross, JButtonBool2 button, ImagePikachu answer, Finish finish) {

		this.picross = picross;
		this.button = button;
		this.answer = answer;
		this.finish = finish;
		caller = new RestAPICaller();

	}

	// ボタンがクリックされた時
	@Override
	public void actionPerformed(ActionEvent e) {

		if (!finish.check(picross.getButtonx(), answer.getButtonx())) { // ドット絵が未完成ならば

			if (picross.getButtonblack().getBool() && !picross.getButtoncross().getBool()) { // ■描画モードならば

				button.setBoolblack(!button.getBoolblack()); // ボタンの■が描画された状態かの真理値を反転
				button.setBoolcross(false); // ボタンの×が描画された状態かの真理値をfalseに
				button.setIcon(null); // ボタンの×の描画を消去

				if (button.getBoolblack()) { // ボタンが押されていない状況だったならば

					button.setBackground(Color.BLACK); // ボタンの色を黒に設定

				} else { // ボタンが押されている状況だったならば

					button.setBackground(Color.WHITE); // ボタンの色を白に設定

				}

				if (finish.check(picross.getButtonx(), answer.getButtonx())) { // ドット絵が完成しているならば

					answer.color(picross.getButtonx()); // 描画部分のボタンを着色
					picross.getLabelFinish().setText("完成(" + finish.getSecond() + "sec)"); // // 完成しているかを表示するラベルに"完成"と表示

					try {

						caller.read(picross.getLabel1(), 1);

					} catch (IOException e1) {

						// TODO 自動生成された catch ブロック
						e1.printStackTrace();

					}

					try {

						caller.read(picross.getLabel2(), 2);

					} catch (IOException e1) {

						// TODO 自動生成された catch ブロック
						e1.printStackTrace();

					}

					try {

						caller.read(picross.getLabel3(), 3);

					} catch (IOException e1) {

						// TODO 自動生成された catch ブロック
						e1.printStackTrace();

					}


				}

			} else if (!picross.getButtonblack().getBool() && picross.getButtoncross().getBool()) { // ×描画モードならば

				button.setBoolcross(!button.getBoolcross()); // ボタンの×が描画された状態かの真理値を反転
				button.setBoolblack(false); // ボタンの■が描画された状態かの真理値をfalseに
				button.setBackground(Color.WHITE); // ボタンの色を白に設定する

				if (button.getBoolcross()) { // ボタンが押されていない状況だったならば

					button.setIcon(picross.getIconcross()); // ボタンに×を表示

				} else { // ボタンが押されている状況だったならば

					button.setIcon(null); // ボタンの×の描画を消去

				}

			}

		}

	}

}
