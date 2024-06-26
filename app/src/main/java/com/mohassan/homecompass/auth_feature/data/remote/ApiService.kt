package com.mohassan.homecompass.auth_feature.data.remote

import com.mohassan.homecompass.auth_feature.data.remote.dto.LoginRequestBody
import com.mohassan.homecompass.auth_feature.data.remote.dto.RegisterRequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/Auth/register")
    suspend fun registerUser(@Body requestBody: RegisterRequestBody): Response<Any>

    @POST("/Auth/confirmEmail")
    suspend fun confirmEmail(
        @Query("email") email: String,
        @Query("token") token: String
    ): Response<Any>

    @POST("/Auth/login")
    suspend fun loginUser(@Body requestBody: LoginRequestBody): Response<Any>
}
data class ConfirmEmailRequest(
    val email: String,
    val token: String
)