import java.io.*;
import okhttp3.*;
public class Peticion {

	//CRUD -> Create
	public void create(String nombre, String tipo, int gen) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
				RequestBody body = RequestBody.create(mediaType, "nombre=" + nombre +"&tipo=" + tipo + "&gen=" + gen);
				Request request = new Request.Builder()
				  .url("http://localhost:11700/pokemon")
				  .method("POST", body)
				  .addHeader("Content-Type", "application/x-www-form-urlencoded")
				  .build();
				Response response = client.newCall(request).execute();
	}
	
	//CRUD -> Read all
	public void readAll() throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
			      .build();
			    Request request = new Request.Builder()
			      .url("http://localhost:11700/pokemon")
			      .method("GET", null)
			      .addHeader("Content-Type", "application/x-www-form-urlencoded")
			      .build();
			    Response response = client.newCall(request).execute();
			    System.out.println(response.body().string());
	}
	
	//CRUD -> Read one
	public void readOne(int id) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("http://localhost:11700/pokemon/" + id)
				  .method("GET", null)
				  .addHeader("Content-Type", "application/x-www-form-urlencoded")
				  .build();
				Response response = client.newCall(request).execute();
				System.out.println(response.body().string());
	}
	
	//CRUD -> Update
	public void update(int id, String nombre, String tipo, int gen) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
				RequestBody body = RequestBody.create(mediaType, "nombre=" + nombre +"&tipo=" + tipo + "&gen=" + gen);
				Request request = new Request.Builder()
				  .url("http://localhost:11700/pokemon/" + id)
				  .method("PUT", body)
				  .addHeader("Content-Type", "application/x-www-form-urlencoded")
				  .build();
				Response response = client.newCall(request).execute();
	}
	
	//CRUD -> Delete
	public void delete(int id) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
				RequestBody body = RequestBody.create(mediaType, "nombre=Mimikyu&tipo=Fantasma/Hada&gen=7");
				Request request = new Request.Builder()
						.url("http://localhost:11700/pokemon/" + id)
				  .method("DELETE", body)
				  .addHeader("Content-Type", "application/x-www-form-urlencoded")
				  .build();
				Response response = client.newCall(request).execute();
	}
	
}
