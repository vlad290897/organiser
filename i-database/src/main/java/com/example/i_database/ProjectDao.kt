package com.example.i_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project

@Dao
interface ProjectDao {
    @Insert
    fun insertProject(project: Project):Long

    //получить список папок в папке
    @Query("SELECT * FROM project WHERE parentFolderId LIKE :parentFolderId")
    fun getAllProjectsWithParentFolderId(parentFolderId: Long): List<Project>

    @Query("SELECT * FROM folder WHERE id LIKE :projectId")
    fun getProjectById(projectId: Long): Project

    @Query("SELECT * FROM folder")
    fun getAllProjects(): List<Project>
}