package com.ids.fao.controller.Fragments



import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.*
import com.ids.fao.custom.MyDrawView
import kotlinx.android.synthetic.main.fragment_signature.*

import android.graphics.drawable.Drawable
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.os.Environment

import com.google.android.youtube.player.internal.i
import java.io.File.separator
import java.nio.file.Files.exists
import android.os.Environment.DIRECTORY_PICTURES
import android.os.Environment.getExternalStoragePublicDirectory
import android.util.Log

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import com.ids.fao.R
import com.ids.fao.controller.MyApplication
import com.ids.fao.utils.AppHelper


class FragmentSignature : Fragment() {

    var canClick = true
    var myDrawView:MyDrawView?=null
    private val PERMISSION_GALLERY_WRITE = 1004

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(com.ids.fao.R.layout.fragment_signature, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        MyApplication.isSignatureEmpty=true
        addSignView()

        btClear.setOnClickListener{
            try{rlSignature.removeView(myDrawView)}catch (e:Exception){}
            addSignView()
            MyApplication.isSignatureEmpty=true
        }

        btSave.setOnClickListener{
            if(!MyApplication.isSignatureEmpty)
               saveSignature()
            else
               AppHelper.createDialog(activity!!,getString(R.string.please_sign))
        }
    }


    private fun addSignView(){
        myDrawView =  MyDrawView(activity);
        rlSignature.addView(myDrawView)
    }


    private fun saveSignature(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

         if (checkSelfPermission(this.activity!!,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permissions, PERMISSION_GALLERY_WRITE); }
            else
             saveBitMap(activity!!,rlSignature)
        }
        else
            saveBitMap(activity!!,rlSignature)
    }

    private fun getBitmapFromView(view: View): Bitmap {
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) {
            bgDrawable.draw(canvas)
        } else {
            canvas.drawColor(Color.WHITE)
        }
        view.draw(canvas)
        return returnedBitmap
    }


    private fun saveBitMap(context: Context, drawView: View): File? {
        val pictureFileDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            "Logicchip"
        )
        if (!pictureFileDir.exists()) {
            val isDirectoryCreated = pictureFileDir.mkdirs()
            if (!isDirectoryCreated)
                Log.i("TAG", "Can't create directory to save the image")
            return null
        }
        val filename =
            pictureFileDir.getPath() + File.separator + System.currentTimeMillis() + ".jpg"
        val pictureFile = File(filename)
        val bitmap = getBitmapFromView(drawView)
        try {
            pictureFile.createNewFile()
            val oStream = FileOutputStream(pictureFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, oStream)
            oStream.flush()
            oStream.close()
            Toast.makeText(activity,"success",Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Log.i("TAG", "There was an issue saving the image.")
        }

        scanGallery(context, pictureFile.getAbsolutePath())
        return pictureFile
    }


    // used for scanning gallery
    private fun scanGallery(cntx: Context, path: String) {
        try {
            MediaScannerConnection.scanFile(
                cntx,
                arrayOf(path),
                null
            ) { path, _ -> }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("TAG", "There was an issue scanning gallery.")
        }

    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){

            PERMISSION_GALLERY_WRITE -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    saveBitMap(activity!!,rlSignature)
                }
                else{
                    Toast.makeText(activity, getString(R.string.permission_denied), Toast.LENGTH_SHORT).show()
                }
            }


        }
    }

}




