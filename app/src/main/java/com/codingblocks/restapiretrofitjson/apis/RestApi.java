package com.codingblocks.restapiretrofitjson.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Suraj on 6/30/2017.
 */

public class RestApi {
    private static RestApi restApi;
    private final Retrofit retrofit;
    private final AlbumApi albumApi;
    private final CommentApi commentApi;
    private final PhotoApi photoApi;
    private final PostApi postApi;
    private final TodoApi todoApi;
    private final UserApi userApi;

    public AlbumApi getAlbumApi() {
        return albumApi;
    }

    public CommentApi getCommentApi() {
        return commentApi;
    }

    public PhotoApi getPhotoApi() {
        return photoApi;
    }

    public PostApi getPostApi() {
        return postApi;
    }

    public TodoApi getTodoApi() {
        return todoApi;
    }

    public UserApi getUserApi() {
        return userApi;
    }
    private RestApi(){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(
                            GsonConverterFactory.create()
                    )
                    .build();
        albumApi = retrofit.create(AlbumApi.class);
        commentApi = retrofit.create(CommentApi.class);
        photoApi = retrofit.create(PhotoApi.class);
        postApi = retrofit.create(PostApi.class);
        todoApi = retrofit.create(TodoApi.class);
        userApi = retrofit.create(UserApi.class);
    }
    public static RestApi getInstance(){
        if(restApi==null){
            restApi = new RestApi();
        }
        return restApi;
    }
}
