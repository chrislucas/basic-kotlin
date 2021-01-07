import java.io.File;

val folders: Array<File>? = File("/").listFiles { file -> file.isDirectory }

folders?.forEach { folder -> println(folder) }