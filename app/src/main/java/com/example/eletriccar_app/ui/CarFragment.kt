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

    var carrosArray : ArrayList<Carros> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callService()
        setupView(view)
        setupListeners()
       
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
      val adapter = CarAdapter(carrosArray)
       listaCarros.adapter = adapter
    }

     fun setupListeners() {
        fabCalcular.setOnClickListener {
            startActivity(Intent(context, CalcularAutonomiaActivity::class.java))
             }
        }

      fun callService(){
        val urlBase = "https://github.com/igorbag/cars-api/blob/main/cars.json"
         MyTask().execute(urlBase)
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
                 urlConnection.setRequestProperty(
                    "Accept",
                    "application/json"
                )

                val responseCode = urlConnection.responseCode
                
                if (responseCode == HttpURLConnection.HTTP_OK) {
                var response = urlConnection.inputStream.bufferReader().use{it. readText}
                publishProgress(inString)
                }else{
                    Log.e("Error", "Serviço indisponivel no momento.")
                }
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

                    val model = Carro(
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
                setupList()

            }catch(ex: Exception) {
                Log.e("Erro ->", ex.message.toString())
            }
           
        }     
    }
}