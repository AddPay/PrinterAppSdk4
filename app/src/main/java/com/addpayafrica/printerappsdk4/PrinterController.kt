package com.addpayafrica.printerappsdk4

import android.content.Context
import android.os.RemoteException
import android.view.Gravity
import android.widget.Toast
import wangpos.sdk4.libbasebinder.Printer




class PrinterController {

    private val mPrinter: Printer? = null

   // private  var  mPrinter : Printer =null

    private var device = ""


     fun runPrinter(){


         //As the order
        CheckBTStatus()
        initConnection()
         clearCache()
        grayLevel()
        printText()


    }

    private fun CheckBTStatus() {


        val status = IntArray(1)
        var ret = -1
        try {
            mPrinter?.getPrinterStatus(status)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    private fun initConnection() {

        try {

            mPrinter?.printInit()

            mPrinter?.clearPrintDataCache()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    private fun grayLevel(){


        try {

            mPrinter?.setGrayLevel(3)

        } catch (e: RemoteException) {
            e.printStackTrace()
        }

    }

    private fun clearCache(){

        try {
            mPrinter?.clearPrintDataCache()
        } catch (e: RemoteException) {
            e.printStackTrace();
        }



    }

    private fun printText(){


        try {
            mPrinter?.printString("www.wiseasy.com", 25, Printer.Align.CENTER, true, false);

        }catch (e : RemoteException) {
            e.printStackTrace();
        }


    }


}