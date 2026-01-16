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
            MyTask().execute("https://github.com/igorbag/cars-api/blob/main/cars.json")
            //startActivity(Intent(context, CalcularAutonomiaActivity::class.java))
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

                var inString = urlConnection.inputStream.bufferReader().use{it. readText}
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
              val jsonArray = JSONTokener(values[0]).nextValue() as jsonArray
              
              for (i in 0 until jsonArray.lenght()){
                 val id = jsonArray.getJSONObject(i).getString("id")
                    Log.d("ID ->", id)

                    val preco = jsonArray.getJSONObject(i).getString("preco")
                    Log.d("Preco ->", preco)

                    val bateria = jsonArray.getJSONObject(i).getString("bateria")
                    Log.d("Bateria ->", bateria)

                    val potencia = jsonArray.getJSONObject(i).getString("potencia")
                    Log.d("Potencia ->", potencia)

                    val recarga = jsonArray.getJSONObject(i).getString("recarga")
                    Log.d("Recarga ->", recarga)

                    val urlPhoto = jsonArray.getJSONObject(i).getString("urlPhoto")
                    Log.d("urlPhoto ->", urlPhoto)

                    al model = Carro(
                        id = id.toInt(),
                        preco = preco,
                        bateria = bateria,
                        potencia = potencia,
                        recarga = recarga,
                        urlPhoto = urlPhoto,
                        isFavorite = false 
                    )
                    carrosArray.add(model)
                }


              }

            }catch(ex: Exception) {
                Log.e("Erro ->", ex.message.toString())
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