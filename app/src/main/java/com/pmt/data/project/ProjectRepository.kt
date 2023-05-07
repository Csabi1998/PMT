package com.pmt.data.project

import kotlinx.coroutines.flow.Flow

class ProjectRepository(private val projectDao: ProjectDao)  {
    fun getAllProjectsStream(): Flow<List<Project>> = projectDao.getAllProjects()

    fun getProjectStream(id: Int): Flow<Project?> = projectDao.getProject(id)

    suspend fun insertProject(item: Project) = projectDao.insert(item)

    suspend fun deleteProject(item: Project) = projectDao.delete(item)

    suspend fun updateProject(item: Project) = projectDao.update(item)
}