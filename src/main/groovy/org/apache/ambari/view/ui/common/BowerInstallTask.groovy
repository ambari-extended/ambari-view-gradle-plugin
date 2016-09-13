package org.apache.ambari.view.ui.common

import org.gradle.api.tasks.Exec

/**
 * Created by dbhowmick on 9/12/16.
 */
class BowerInstallTask extends Exec {

    BowerInstallTask() {
        if (BuildUtils.windows) {
            executable 'cmd'
            args '/c', 'bower'
        } else {
            executable 'bower'
        }

        args 'install'
        workingDir project.file("$project.rootDir/$project.emberCli.uiAppDirectory")
    }

}
