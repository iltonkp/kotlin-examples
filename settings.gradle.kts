rootProject.name = "kotlin-examples"

val modulesDir = "$rootDir/modules"

fun getModulesPath(root: File, currentPaths: MutableList<String>) {
    if (root.isDirectory) {
        if (root.resolve("build.gradle.kst").exists())
            currentPaths.add(root.absolutePath)
        else
            for (child in root.listFiles())
                getModulesPath(child, currentPaths)
    }
}

fun includeModule(moduleName: String, modulePath: String){
    val finalModuleName = if(moduleName.startsWith(":")) moduleName else ":$moduleName"
    include(finalModuleName)
    project(finalModuleName).projectDir = file(modulePath)
}

fun includeAllModulesInPath(rootPath: String, modulesNamePrefix: String? = null){
    val paths = mutableListOf<String>()
    getModulesPath(file(rootPath), paths)
    paths.forEach {path->
        val moduleName = path.substringAfterLast('/')
        val renamedModule = if(!modulesNamePrefix.isNullOrBlank())
            "$modulesNamePrefix-$moduleName"
        else
            moduleName

        include(renamedModule)
        project(":$renamedModule").projectDir = file(path)
    }
}


includeModule("operator", "$modulesDir/operator")