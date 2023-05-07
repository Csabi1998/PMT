package com.pmt.data.log

import kotlinx.coroutines.flow.Flow

class LogRepository(private val logDao: LogDao)  {
    fun getAllLogsStream(): Flow<List<Log>> = logDao.getAllLogs()

    fun getAllLogsByProjectId(projectId: Int): Flow<List<Log>> = logDao.getAllLogsByProjectId(projectId)

    fun getLogStream(id: Int): Flow<Log?> = logDao.getLog(id)

    suspend fun insertLog(item: Log) = logDao.insert(item)

    suspend fun deleteLog(item: Log) = logDao.delete(item)

    suspend fun updateLog(item: Log) = logDao.update(item)
}