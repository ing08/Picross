package t1875085;

import java.io.IOException;

import javax.swing.JLabel;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// RestAPIと通信を行うクラス
public class RestAPICaller {

	static final String baseURL = "https://softdev20-b2121-default-rtdb.firebaseio.com/"; // RestAPIUのURL
	private Retrofit retrofit; // RestAPIと通信を行う
	private PlayerDBService service; // // RestAPIと通信を行うクラス
	Picross picross; // ゲームのセットアップ

	public RestAPICaller() {
		retrofit = new Retrofit.Builder()
				.baseUrl(baseURL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		service = retrofit.create(PlayerDBService.class);
	}

	// RestAPIにランキングを書き込む
	public void write(int rank, int second) throws IOException {

		Player player = new Player(rank, second);
		Call<Player> repos = service.put(player.getRank(), player); // 書き込み
		repos.execute();

	}

	// RestAPIからランキングを読み取る
	public void read(JLabel label, int rank) throws IOException {

		Call<Player> repos = service.get(rank);
		Response<Player> response = repos.execute();

		if (response.body() != null) { // ランキングが埋まっているならば

			label.setText(response.body().toString()); // ランキングを表示するラベルタイトル

		} else { // ランキングが埋まってないならば

			label.setText("rank:" + rank + " time: --sec"); // ランキングを表示するラベルタイトル

		}

	}

	// ランキングの更新を行うメソッド
	public void renew(int second) throws IOException {

		// ランキングの読み取り
		Call<Player> rank1 = service.get(1);
		Call<Player> rank2 = service.get(2);
		Call<Player> rank3 = service.get(3);
		Response<Player> response1 = rank1.execute();
		Response<Player> response2 = rank2.execute();
		Response<Player> response3 = rank3.execute();

		if (response1.body() != null) { // ランキングが埋まっているならば

			if (response1.body().getSecond() >= second) { // クリアタイムが更新されていれば

				if (response2.body() != null) { // ランキングが埋まっているならば

					write(3, response2.body().getSecond()); // ランキングの更新

				}

				if (response1.body() != null) { // ランキングが埋まっているならば

					write(2, response1.body().getSecond()); // ランキングの更新

				}

				write(1, second); // ランキングの更新

			} else if (response2.body() != null) { // ランキングが埋まっているならば

				if (response2.body().getSecond() >= second) { // クリアタイムが更新されていれば

					if (response2.body() != null) { // ランキングが埋まっているならば

						write(3, response2.body().getSecond()); // ランキングの更新

					}

					write(2, second); // ランキングの更新

				} else if (response3.body() != null) { // ランキングが埋まっているならば

					if (response3.body().getSecond() >= second) { // クリアタイムが更新されていれば

						write(3, second); // ランキングの更新

					}

				} else {

					write(3, second); // ランキングの更新

				}

			} else {

				if (response2.body() != null) { // ランキングが埋まっているならば

					write(3, response2.body().getSecond()); // ランキングの更新

				}

				write(2, second); // ランキングの更新

			}

		} else {

			if (response2.body() != null) { // ランキングが埋まっているならば

				write(3, response2.body().getSecond()); // ランキングの更新

			}

			if (response1.body() != null) { // ランキングが埋まっているならば

				write(2, response1.body().getSecond()); // ランキングの更新

			}

			write(1, second); // ランキングの更新

		}

	}

}