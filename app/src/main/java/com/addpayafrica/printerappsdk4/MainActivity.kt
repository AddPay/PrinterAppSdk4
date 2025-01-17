package com.addpayafrica.printerappsdk4

import android.os.Bundle
import android.os.RemoteException
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import wangpos.sdk4.libbasebinder.Printer


class MainActivity : AppCompatActivity() {

    private var mPrinter: Printer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val button = findViewById<Button>(R.id.button)

        object : Thread() {
            override fun run() {

                mPrinter = Printer(applicationContext)
                SDKInstance.initSDK(applicationContext)

            }
        }.start()


        button?.setOnClickListener {

            //As the order
            CheckBTStatus()
            initConnection()
            clearCache()
            grayLevel()
            printText()
            printPaper()
            printFinish()

        }

    }

    private fun CheckBTStatus() {


        val status = IntArray(1)

        try {
            mPrinter?.getPrinterStatus(status)!!
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    private fun initConnection() {

        try {

           mPrinter?.printInit()

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

            mPrinter?.printString("------------------------------------------------", 30, Printer.Align.CENTER, true, false)
            mPrinter?.printString("Customer Success Cashier", 35, Printer.Align.CENTER, true, false)
            mPrinter?.printString("------------------------------------------------", 30, Printer.Align.CENTER, true, false)
            mPrinter?.print2StringInLine("Orange","R10",2.0f,Printer.Font.DEFAULT,25,Printer.Align.CENTER,true,false,true)
            mPrinter?.print2StringInLine("Apple","R30",2.0f,Printer.Font.DEFAULT,25,Printer.Align.CENTER,true,false,true)
            mPrinter?.print2StringInLine("Banana","R15",2.0f,Printer.Font.DEFAULT,25,Printer.Align.CENTER,true,false,true)
            mPrinter?.print2StringInLine("Bread","R20",2.0f,Printer.Font.DEFAULT,25,Printer.Align.CENTER,true,false,true)
            mPrinter?.print2StringInLine("Braai Pack","R20",2.0f,Printer.Font.DEFAULT,25,Printer.Align.CENTER,true,false,true)
            mPrinter?.printString("------------------------------------------------", 30, Printer.Align.CENTER, true, false)
            mPrinter?.print2StringInLine("TOTAL:","R75",2.0f,Printer.Font.DEFAULT,25,Printer.Align.CENTER,true,false, false)

        }catch (e : RemoteException) {
            e.printStackTrace();
        }


    }

    private fun printPaper(){


        try {

            mPrinter?.printPaper(60)

        }catch (e : RemoteException) {
            e.printStackTrace();
        }


    }

    private fun printFinish(){


        try {

            mPrinter?.printFinish()

        }catch (e : RemoteException) {
            e.printStackTrace();
        }


    }



}