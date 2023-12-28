package com.bitcodetech.storagedemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Internal Storage

        /*val out : FileOutputStream =
            openFileOutput("demo1.txt", Activity.MODE_PRIVATE or Activity.MODE_APPEND)
        out.write("this is demo1.txt".toByteArray())
        out.close()

        val data = ByteArray(1024)
        val ins = openFileInput("demo1.txt")
        var count = ins.read(data)
        ins.close()

        mt( String(data, 0, count))
        deleteFile("demo1.txt")*/

        //val intAppRootDir = filesDir
        mt("App Specific internal storage files root dir:  ${filesDir.absolutePath}" )

        /*val tempDir = File(filesDir, "temp")
        if(!tempDir.exists()) {
            tempDir.mkdir()
        }

        val tempFile = File(filesDir, "temp_file.txt")
        if(!tempFile.exists()) {
            tempFile.createNewFile()
        }

        val outStream = FileOutputStream(tempFile)
        val inStream = FileInputStream(tempFile)

        //tempFile.delete()*/

        mt("Internal Cache: ${cacheDir.absolutePath}")

        val tempFile = File(cacheDir, "temp_file.txt")
        if(!tempFile.exists()) {
            tempFile.createNewFile()
        }

        val outStream = FileOutputStream(tempFile)
        val inStream = FileInputStream(tempFile)

        //tempFile.delete()


        //External Storage

        val state = Environment.getExternalStorageState()
        when(state) {
            Environment.MEDIA_MOUNTED ->
                mt("Ext state: R+W")
        }
        val extRoot = Environment.getExternalStorageDirectory()
        mt("Ext Storage root dir: ${extRoot.absolutePath}")

        val musicRoot =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        mt("Ext Storage music dir: ${musicRoot.absolutePath}")

        val newDir = File(extRoot, "new_ext_dir")
        if(!newDir.exists()) {
            newDir.mkdir()
        }

        val appExtDir = getExternalFilesDir(null)
        mt("App Specific root dir on ext storage: ${appExtDir!!.absolutePath}")

        val appMusicDir = getExternalFilesDir(Environment.DIRECTORY_MUSIC)
        mt("App Specific music dir on ext storage: ${appMusicDir!!.absolutePath}")

        val appCacheDir = externalCacheDir
        mt("App Specific cache dir on ext storage: ${appCacheDir!!.absolutePath}")


    }

    private fun mt(text : String) = Log.e("tag", text)
}









