package org.apache.ambari.view.ui

/**
 * Extension to configure the Ember Cli plugin for Ambari View
 */
class EmberCliPluginExtension {

    /**
     * Directory containing the ui application.
     */
    String uiAppDirectory = 'ui'

    /**
     * Configuration to control the environment for which the ui application will be built.
     * Possible values are 'production', 'development'.
     */
    String environment = 'development'

    /**
     * Configures the proxy url. To be used while serving the ui application for proxying the xhr request.
     */
    String proxyUrl = 'http://localhost:8080'

    /**
     * Flag to control if the proxying is required while serving the ui application
     */
    boolean enableApiProxy = true

}
