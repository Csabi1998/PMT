package com.pmt.network

import com.pmt.network.dto.Auth
import com.pmt.network.dto.CreateLog
import com.pmt.network.dto.ModifyLog
import com.pmt.network.response.CreateLogResponse
import com.pmt.network.response.DeleteLogResponse
import com.pmt.network.response.LogListResponse
import com.pmt.network.response.ModifyLogResponse
import com.pmt.network.response.ProjectListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface WorklogApiService {
    @GET("projects")
    suspend fun getProjects(
    ): Response<ProjectListResponse>

    @GET("logs/{projectId}")
    suspend fun getLogs(
        @Path("projectId") projectId : String
    ): Response<LogListResponse>

    @POST("logs")
    suspend fun createLog(
        @Body dto : CreateLog
    ): Response<CreateLogResponse>

    @PUT("logs/{id}")
    suspend fun modifyLog(
        @Path("id") id: String,
        @Body dto : ModifyLog
    ): Response<ModifyLogResponse>

    @DELETE("logs/{id}")
    suspend fun deleteLog(
        @Path("id") id : String
    ): Response<DeleteLogResponse>
}