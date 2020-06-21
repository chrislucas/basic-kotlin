@file:JvmName("IO"
)
package algoriothms

import java.io.File
import java.io.FileWriter

object IO {

    @JvmStatic
    fun writeFile(content: String, filename: String) {
        FileWriter(File(filename)).use {
            it.write(content)
        }
    }
}