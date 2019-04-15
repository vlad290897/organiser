package com.example.cm_recyclerview

import android.view.ViewGroup
import android.widget.TextView
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.standard.domain.folder.Project
import java.text.SimpleDateFormat

/**
 * Контроллер TODO
 */
class ProjectItemController(
        private val onItemClickAction: (Project) -> Unit
) : BindableItemController<Project, ProjectItemController.Holder>() {

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    override fun getItemId(project: Project) = project.hashCode().toString()

    inner class Holder(parent: ViewGroup) : BindableViewHolder<Project>(parent, R.layout.item_project) {

        private lateinit var project: Project

        private val projectName = itemView.findViewById<TextView>(R.id.projects_projectName_tv)
        private val projectDate = itemView.findViewById<TextView>(R.id.projects_projectDate_tv)

        init {
            itemView.setOnClickListener { onItemClickAction(project) }
        }

        override fun bind(project: Project) {
            this.project = project
            projectName.text = project.toString()
            val dateBegin = SimpleDateFormat("dd/MM/yy").format(project.beginDate)
            projectDate.text = dateBegin
        }
    }
}