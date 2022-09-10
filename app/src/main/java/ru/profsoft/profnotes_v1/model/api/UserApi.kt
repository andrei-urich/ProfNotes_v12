package ru.profsoft.profnotes_v1.model.api

import retrofit2.http.GET
import retrofit2.http.Path
import ru.profsoft.profnotes_v1.model.entity.User

interface UserApi {
    @GET("todos/1")
    suspend fun getUser(): User

    @GET("todos/{id}")
    suspend fun getUserById(
        @Path("id") id: Int
    ): User

    @GET("todos")
    suspend fun getNotes(): List<User>
}

