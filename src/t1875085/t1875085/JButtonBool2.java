package t1875085;

import javax.swing.JButton;

// JButtonに2種類の真理値を持たせたもの
public class JButtonBool2 extends JButton {

	private Boolean boolblack; // ■が描画された状態かの真理値
	private Boolean boolcross; // ×が描画された状態かの真理値

	// コンストラクタ
	public JButtonBool2(Boolean boolblack, Boolean boolcross) {

		super();
		this.boolblack = boolblack;
		this.boolcross = boolcross;

	}

	// ■が描画された状態かの真理値のgetter
	public Boolean getBoolblack() {

		return boolblack;

	}

	// ■が描画された状態かの真理値のsetter
	public void setBoolblack(Boolean boolblack) {

		this.boolblack = boolblack;

	}

	// ×が描画された状態かの真理値のgetter
	public Boolean getBoolcross() {

		return boolcross;

	}

	// ×が描画された状態かの真理値のsetter
	public void setBoolcross(Boolean boolcross) {

		this.boolcross = boolcross;

	}

}
