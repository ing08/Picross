package t1875085;

import javax.swing.SwingUtilities;

// main関数
public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Picross frame = new Picross(); // 生成して
				frame.setVisible(true); // 表示する
			}
		});
	}
}