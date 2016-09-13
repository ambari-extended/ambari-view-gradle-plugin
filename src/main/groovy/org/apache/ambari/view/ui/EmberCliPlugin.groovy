package org.apache.ambari.view.ui

import org.apache.ambari.view.ui.common.BowerInstallTask
import org.apache.ambari.view.ui.common.NpmInstallTask
import org.apache.ambari.view.ui.ember.EmberBuildTask
import org.apache.ambari.view.ui.ember.EmberCleanTask
import org.apache.ambari.view.ui.ember.EmberServeTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

/**
 * Gradle plugin to add ember cli's build workflow to the ambari views build workflow
 */
class EmberCliPlugin implements Plugin<Project> {
    final def AMBARI_GROUP = 'ambari views'

    @Override
    void apply(Project project) {

        project.extensions.create("emberCli", EmberCliPluginExtension)

        project.afterEvaluate {
            project.tasks.create(name: 'npmInstall', type: NpmInstallTask) {
                description 'Executes npm install inside the Ember Application'
                group AMBARI_GROUP
            }

            project.tasks.create(name: 'bowerInstall', type: BowerInstallTask) {
                description 'Executes bower install inside the Ember Application'
                group AMBARI_GROUP
                dependsOn 'npmInstall'
            }

            project.tasks.create(name: "emberClean", type: EmberCleanTask) {
                description 'Cleans the Ember application'
                group AMBARI_GROUP
            }

            project.tasks.create(name: "emberBuild", type: EmberBuildTask) {
                description 'Builds the Ember application'
                group AMBARI_GROUP
                dependsOn 'emberClean', 'npmInstall', 'bowerInstall'
            }

            project.tasks.create(name: "emberServe", type: EmberServeTask) {
                description 'Starts the node server to serve the ui application'
                group AMBARI_GROUP
                dependsOn 'emberClean', 'npmInstall', 'bowerInstall'
            }

            Task cleanTask = project.tasks.findByName("clean")
            if (cleanTask != null) {
                project.tasks.clean.finalizedBy 'emberClean'
            }

            /**
             * Wires up the ui build when the Spring boot plugin is enabled
             */
            Task bootRepackageTask = project.tasks.findByName('bootRepackage')
            if (bootRepackageTask != null) {
                project.tasks.bootRepackage.dependsOn << ['emberClean', 'emberBuild']
            }


        }

    }
}
