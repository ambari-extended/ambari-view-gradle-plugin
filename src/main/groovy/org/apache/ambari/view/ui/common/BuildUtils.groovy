package org.apache.ambari.view.ui.common

import org.apache.tools.ant.taskdefs.condition.Os

/**
 * Created by dbhowmick on 9/13/16.
 */
class BuildUtils {
    static def boolean isWindows() {
        Os.isFamily(Os.FAMILY_WINDOWS);
    }
}
