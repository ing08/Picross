package t1875085;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

// ゲームのセットアップ
public class Picross extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pane; // ウィンドウの（メニューバーなどでない）本体部分。
	private ArrayList<JLabel> labels; // ヒントのラベルのリスト
	private JLabel labelfinish; // 完成しているかを表示するラベル
	private ArrayList<ArrayList<JButtonBool2>> buttonx; // ボタンのリストのリスト, 縦方向の座標
	private JButtonBool buttonblack; // ■描画モードに変更するボタン
	private JButtonBool buttoncross; // ×描画モードに変更するボタン
	private JButton buttonreset; // リセットボタン
	private ImagePikachu answer; // 問題のドット絵とその答えを持つ
	private Finish finish; // クリア判定をする
	private ImageIcon iconcross; // ×マークのアイコン
	private ImageIcon iconpen; // ペンマークのアイコン
	private long start; // クリアタイム計測の開始時間
	private long end; // クリアタイム計測の終了時間
	RestAPICaller caller = new RestAPICaller(); // RestAPIとの通信を行う
	private JLabel labelrank; // ランキングのタイトル
	private JLabel label1; // 1位のクリアタイムを表示するラベル
	private JLabel label2; // 2位のクリアタイムを表示するラベル
	private JLabel label3; // 3位のクリアタイムを表示するラベル

	public Picross() {

		super();
		labels = new ArrayList<JLabel>();
		labelfinish = new JLabel();
		buttonx = new ArrayList<ArrayList<JButtonBool2>>();
		buttonblack = new JButtonBool(true);
		buttoncross = new JButtonBool(false);
		buttonreset = new JButton();
		answer = new ImagePikachu();
		finish = new Finish(this);
		iconcross = new ImageIcon("cross.png");
		iconpen = new ImageIcon("pen.png");
		start = System.currentTimeMillis();
		end = 0;
		labelrank = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		initialize();

	}

	// セットアップ
	public void initialize() {

		setLAF(); // ボタンの見た目設定

		setTitle("Picross"); // ウィンドウタイトル
		setSize(500, 450); // ウィンドウサイズ
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // "x"印をおされたら、Frameを終了
		pane = new JPanel(); // ウィンドウ本体部分を作成
		pane.setLayout(null); // レイアウト設定

		ButtonLocate(); // ボタン(描画部分)を設置
		answer.LabelLocate(pane, labels); // ラベル(ヒント)を設置

		labelfinish.setText("未完成"); // ラベルタイトル
		labelfinish.setBounds(75, 375, 100, 25); // ラベルサイズ
		pane.add(labelfinish); // 完成しているかを表示するラベルを設置

		buttonblack.setIcon(iconpen); // ボタンにペンマークを表示
		buttonblack.setBounds(175, 375, 25, 25); // ボタンサイズ
		buttonblack.addActionListener(new BlackListener(this)); // アクションリスナーを設定
		pane.add(buttonblack); // ■描画モードに変更するボタンを設置

		buttoncross.setIcon(iconcross); // ボタンに×マークを表示
		buttoncross.setBounds(200, 375, 25, 25); // ボタンサイズ
		buttoncross.addActionListener(new CrossListener(this)); // アクションリスナーを設定
		pane.add(buttoncross); // ×描画モードに変更するボタンを設置

		buttonreset.setText("reset"); // ボタンタイトル
		buttonreset.setBounds(250, 375, 100, 25); // ボタンサイズ
		buttonreset.addActionListener(new ResetListener(this)); // アクションリスナーを設定
		pane.add(buttonreset); // リセットボタンを設置

		labelrank.setText("ランキング"); // ラベルタイトル
		labelrank.setBounds(375, 100, 100, 25); // ラベルサイズ
		pane.add(labelrank); // "ランキング"を表示するラベルを設置

		label1.setBounds(375, 125, 125, 25); // ラベルサイズ
		try {
			caller.read(label1, 1); // １位の情報をRestAPIから所得
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		pane.add(label1); // 1位のクリアタイムを表示するラベルを設置

		label2.setBounds(375, 150, 125, 25); // ラベルサイズ
		try {
			caller.read(label2, 2); // 2位の情報をRestAPIから所得
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		pane.add(label2); // 2位のクリアタイムを表示するラベルを設置

		label3.setBounds(375, 175, 125, 25); // ラベルサイズ
		try {
			caller.read(label3, 3); // 3位の情報をRestAPIから所得
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		pane.add(label3); // 3位のクリアタイムを表示するラベルを設置

		this.setContentPane(pane); // pane を JFrameに登録

	}

	// ボタン(描画部分)を設置
	private void ButtonLocate() {

		for (int i = 0; i < 10; i++) {

			ArrayList<JButtonBool2> buttony = new ArrayList<JButtonBool2>(); // ボタンのリスト, 横方向の座標

			for (int j = 0; j < 10; j++) {

				JButtonBool2 button = new JButtonBool2(false, false); // ボタンに初期値falseを持たせる
				button.setBackground(Color.WHITE); // ボタンの初期カラー
				button.setBounds((j + 4) * 25, (i + 4) * 25, 25, 25); // ボタンサイズ
				button.addActionListener(new PiccellListener(this, button, answer, finish)); // アクションリスナーを設定
				pane.add(button); // ボタン(描画部分)を設置
				buttony.add(button); // ボタンのリストに登録

			}

			buttonx.add(buttony); // ボタンのリストのリストに登録

		}

	}

	// ボタンの見た目設定
	void setLAF() {

		try {

			//System.out.println(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			//com.sun.java.swing.plaf.gtk.GTKLookAndFeel
			//com.sun.java.swing.plaf.motif.MotifLookAndFeel
			//com.sun.java.swing.plaf.windows.WindowsLookAndFeel

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// 完成しているかを表示するラベルのgetter
	public JLabel getLabelFinish() {

		return labelfinish;

	}

	// 完成しているかを表示するラベルのsetter
	public void setLabelFinish(JLabel label) {

		this.labelfinish = label;

	}

	//ボタンのリストのリストのgetter
	public ArrayList<ArrayList<JButtonBool2>> getButtonx() {

		return buttonx;

	}

	// ■描画モードに変更するボタンのgetter
	public JButtonBool getButtonblack() {

		return buttonblack;

	}

	// ■描画モードに変更するボタンのsetter
	public void setButtonblack(JButtonBool buttonblack) {

		this.buttonblack = buttonblack;

	}

	// ×描画モードに変更するボタンのgetter
	public JButtonBool getButtoncross() {

		return buttoncross;

	}

	// ×描画モードに変更するボタンのsetter
	public void setButtoncross(JButtonBool buttoncross) {

		this.buttoncross = buttoncross;

	}

	// ×マークのアイコンのgetter
	public ImageIcon getIconcross() {

		return iconcross;

	}

	// クリアタイム計測の開始時間のgetter
	public long getStart() {

		return start;

	}

	// クリアタイム計測の開始時間のsetter
	public void setStart(long start) {

		this.start = start;

	}

	// クリアタイム計測の終了時間のgetter
	public long getEnd() {

		return end;

	}

	// クリアタイム計測の終了時間のsetter
	public void setEnd(long end) {

		this.end = end;

	}

	// 1位のクリアタイムを表示するラベルのgetter
	public JLabel getLabel1() {

		return label1;

	}

	// 1位のクリアタイムを表示するラベルのsetter
	public void setLabel1(JLabel label1) {

		this.label1 = label1;

	}

	// 2位のクリアタイムを表示するラベルのgetter
	public JLabel getLabel2() {

		return label2;

	}

	// 2位のクリアタイムを表示するラベルのsetter
	public void setLabel2(JLabel label2) {

		this.label2 = label2;

	}

	// 3位のクリアタイムを表示するラベルのgetter
	public JLabel getLabel3() {

		return label3;

	}

	// 3位のクリアタイムを表示するラベルのsetter
	public void setLabel3(JLabel label3) {

		this.label3 = label3;

	}

}
