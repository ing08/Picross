package t1875085;

import javax.swing.JButton;

// JButtonに真理値を持たせたもの
public class JButtonBool extends JButton {

	private Boolean bool; // ボタンが押されている状態であるかの真理値

	// コンストラクタ
	public JButtonBool(Boolean bool) {

		super();
		this.bool = bool;

	}

	// 真理値のgetter
	public Boolean getBool() {

		return bool;

	}

	// 真理値のsetter
	public void setBool(Boolean bool) {

		this.bool = bool;

	}

}
