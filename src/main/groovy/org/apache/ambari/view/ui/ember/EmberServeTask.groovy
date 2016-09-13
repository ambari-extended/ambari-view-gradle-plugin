package org.apache.ambari.view.ui.ember

import org.apache.ambari.view.ui.common.BuildUtils
import org.gradle.api.tasks.Exec

/**
 * Created by dbhowmick on 9/12/16.
 */
class EmberServeTask extends Exec {

    EmberServeTask() {
        if (BuildUtils.windows) {
            executable 'cmd'
            args '/c', 'ember'
        } else {
            executable 'ember'
        }

        args "serve"
        if (project.emberCli.enableApiProxy) {
            args "--proxy", project.emberCli.proxyUrl
        }
        workingDir project.file("$project.rootDir/$project.emberCli.uiAppDirectory")
    }
}
