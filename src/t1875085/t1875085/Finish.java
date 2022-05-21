package t1875085;

import java.io.IOException;
import java.util.ArrayList;

// 終了判定をする
public class Finish {

	private Picross picross; // ゲームのセットアップ
	private int second; // クリアタイム(秒)
	private RestAPICaller caller; // RestAPIとの通信を行う

	// コンストラクタ
	public Finish(Picross picross) {

		this.picross = picross;
		caller = new RestAPICaller();

	}

	// 終了判定をする
	public Boolean check(ArrayList<ArrayList<JButtonBool2>> buttons, ArrayList<ArrayList<JButtonBool>> answer) {

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {

				if (buttons.get(i).get(j).getBoolblack() != answer.get(i).get(j).getBool()) // 答えのドットパターンと違うならば
					return false; // falseを返す

			}

		}

		picross.setEnd(System.currentTimeMillis()); // クリアタイムの終了時刻の計測

		second = (int) (picross.getEnd() - picross.getStart()) / 1000; // クリアタイム計算

		try {
			caller.renew(second); // ランキングの更新
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return true;

	}

	public int getSecond() {

		return second;

	}

	public void setSecond(int second) {

		this.second = second;

	}

}
