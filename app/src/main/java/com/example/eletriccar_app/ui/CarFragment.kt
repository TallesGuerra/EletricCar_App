package com.example.eletriccar_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eletriccar_app.R

class CarFragment: Fragment() {
    lateinit var fabCalcular : FloatingActionButton
    lateinit var listaCarros: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRetrofit()
        setupView(view)
        setupListeners()
        setupList()
    }
    
    fun setupView(view: View) {
        view.apply {
            fabCalcular = findViewById(R.id.fab_calcular)
            listaCarros = findViewById(R.id.rv_lista_carros)
            progress = findViewById(R.id.pb_loader)
            noInternetImage = findViewById(R.id.iv_empty_state)
            noInternetText = findViewById(R.id.tv_no_wifi)
        }
    }

    fun setupList(){
      val adapter = CarAdapter(CarFactory.list)
       listaCarros.adapter = adapter

    }

     fun setupListeners() {
        fabCalcular.setOnClickListener {
            startActivity(Intent(context, CalcularAutonomiaActivity::class.java))
        }
    }

    inner class GetCarInfomations : AsyncTask<String, String, String>{
        override fun preExecute(){
            Log.d("MyTask", "Iniciando...")
        }


        override fun doInBackground(vararg url: String?): String {
            var urlConnection : HttpUrlConnection? = null

            try{
                val urlBase = URL(url[0])

                urlConnection = urlBase.openConnection() as HttpUrlConnection
                urlConnection.connetTimeout = 60000
                urlConnection.readTimeout = 60000

                var String = streamToString(urlConnection.inputStream)
                publishProgress(inString)
            } catch(ex: Exception){
                Log.e("Error", "Erro ao realizar processamento")
            } finally{
               urlConnection?.disconnect()
            }
            
            return  " "
        }

        override fun onProgressUpdate(vararg values: String=?){
            try {
                var json : JSONObject
              values[0]?.let{
                 json = JSONObject(it)
              }
              
                             
            }
            catch(ex: Exception) {
                
            }
        }


        fun streamToString(inputStream: InputStream): String{
            val bufferReader = Bufferreader(InputStreamReader(inputStream))

            var line: String
            var result = ""

            try{
                do{
                    line = bufferReader.readLine()
                    line?.let{
                        result += line
                    }
                } while (line != null){

                } catch (ex: Exception){
                    Log.e("Error", "Erro na Stream")
                }

                return result
            }
        }
        
    }

}
}