package t1875085;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

//RestAPIとの通信を行うクラス
public interface PlayerDBService {

	@GET("users/{uid}.json")
	Call<Player> get(@Path("uid") int rank);

	@PUT("users/{uid}.json")
	Call<Player> put(@Path("uid") int rank, @Body Player player);

}