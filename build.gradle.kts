tasks.register("clean") {
    doFirst {
        project.delete("$rootDir/target")
    }
}

logger.lifecycle("building tuffvote $version")