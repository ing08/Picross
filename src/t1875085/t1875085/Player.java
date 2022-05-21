package t1875085;

public class Player {

	private int rank; // 順位
	private int second; // クリアタイム(秒)

	public Player(int rank, int second) {

		this.rank = rank;
		this.second = second;

	}

	// toString
	public String toString() {

		return "rank:" + rank + " time:" + second + "sec";

	}

	// 順位のgetter
	public int getRank() {

		return rank;

	}

	// 順位のsetter
	public void setRank(int rank) {

		this.rank = rank;

	}

	// クリアタイムのgetter
	public int getSecond() {

		return second;

	}

	// クリアタイムのsetter
	public void setSecond(int second) {

		this.second = second;

	}
}
