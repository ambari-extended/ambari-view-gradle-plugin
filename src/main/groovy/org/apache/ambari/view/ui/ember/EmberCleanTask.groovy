package org.apache.ambari.view.ui.ember

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by dbhowmick on 9/12/16.
 */
class EmberCleanTask extends DefaultTask {

    @TaskAction
    def clean() {
        project.file("$project.rootDir/$project.emberCli.uiAppDirectory/dist").deleteDir()
        project.file("$project.rootDir/$project.emberCli.uiAppDirectory/tmp").deleteDir()
    }
}
