package com.codingblocks.restapiretrofitjson.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by championswimmer on 30/06/17.
 */

public class API {

    private static API apiInstance;

    private PostsAPI postsAPI;
    private AlbumsApi albumsApi;
    private UsersAPI usersAPI;
    private CommentsAPI commentsAPI;
    private TodosAPI todosAPI;
    private PhotoApi photosApi;
    private PicApi picApi;

    public PostsAPI getPostsAPI() {
        return postsAPI;
    }

    public AlbumsApi getAlbumsApi() {
        return albumsApi;
    }

    public PhotoApi getPhotosApi() {
        return photosApi;
    }

    public PicApi getPicApi() {
        return picApi;
    }

    public UsersAPI getUsersAPI() {
        return usersAPI;
    }

    public CommentsAPI getCommentsAPI() {
        return commentsAPI;
    }

    public TodosAPI getTodosAPI() {
        return todosAPI;
    }

    private API() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        albumsApi = retrofit.create(AlbumsApi.class);
        postsAPI = retrofit.create(PostsAPI.class);
        usersAPI = retrofit.create(UsersAPI.class);
        photosApi = retrofit.create(PhotoApi.class);
        picApi = retrofit.create(PicApi.class);
        commentsAPI = retrofit.create(CommentsAPI.class);
        todosAPI = retrofit.create(TodosAPI.class);
    }

    public static API getInstance() {
        if (apiInstance == null) {
            apiInstance = new API();
        }

        return apiInstance;
    }
}
