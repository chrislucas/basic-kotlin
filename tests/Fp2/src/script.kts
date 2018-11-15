import java.io.File;

val folders = File("g:/").listFiles {
    file -> file.isDirectory
}

folders?.forEach {folder -> println(folder)}