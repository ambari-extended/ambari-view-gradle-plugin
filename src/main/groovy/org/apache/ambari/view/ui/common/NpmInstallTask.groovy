package org.apache.ambari.view.ui.common

import org.gradle.api.tasks.Exec

/**
 * Created by dbhowmick on 9/12/16.
 */
class NpmInstallTask extends Exec {

    NpmInstallTask() {

        if (BuildUtils.windows) {
            executable 'cmd'
            args '/c', 'npm'
        } else {
            executable 'npm'
        }

        args 'install'
        workingDir project.file("$project.rootDir/$project.emberCli.uiAppDirectory")
    }
}
