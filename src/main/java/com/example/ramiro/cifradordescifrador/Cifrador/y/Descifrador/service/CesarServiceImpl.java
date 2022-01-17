package com.example.ramiro.cifradordescifrador.Cifrador.y.Descifrador.service;

import org.springframework.stereotype.Service;

@Service
public class CesarServiceImpl implements CesarService{
	
	private String Lmayus="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String Lminus="abcdefghijklmnopqrstuvwxyz";
    
    public CesarServiceImpl(){
        super();
    }

    public CesarServiceImpl(String Lmayus,String  Lminus){
        super();
        this.Lmayus=Lmayus;
        this.Lminus=Lminus;
    }
    public String getLmayus() {
        return Lmayus;
    }

    public void setLmayus(String lmayus) {
        Lmayus = lmayus;
    }

    public String getLminus() {
        return Lminus;
    }

    public void setLminus(String lminus) {
        Lminus = lminus;
    }
    

	@Override
	public int sumar(int a, int b) {

		return a+b;
	}

	@Override
	public String cifrar(String texto, int despl) {
		String salida="";
        for (int i=0;i<texto.length();i++){

            if((this.Lmayus.indexOf(texto.charAt(i)) !=-1) ||(this.Lminus.indexOf(texto.charAt(i)) !=-1 )){
                salida+=(this.Lmayus.indexOf(texto.charAt(i))!= -1)? this.Lmayus.charAt((this.Lmayus.indexOf(texto.charAt(i))+ despl)%this.Lmayus.length()):
                        this.Lminus.charAt((this.Lminus.indexOf(texto.charAt(i))+ despl)%this.Lminus.length());
            }else{
                texto+=texto.charAt(i);
            }
        }
        return salida;
	}

	@Override
	public String desCifrar(String texto, int despl) {
		String salida="";
        for (int i=0;i<texto.length();i++){

            if((this.Lmayus.indexOf(texto.charAt(i)) !=-1) ||(this.Lminus.indexOf(texto.charAt(i)) !=-1 )){
                if (this.Lmayus.indexOf(texto.charAt(i))!=-1){
                    if ((this.Lmayus.indexOf(texto.charAt(i))-despl) <0){
                        salida+=this.Lmayus.charAt(this.Lmayus.length()+((this.Lmayus.indexOf(texto.charAt(i)))-despl));
                    }else{
                        salida+=this.Lmayus.charAt(((this.Lmayus.indexOf(texto.charAt(i)))-despl)%(this.Lmayus.length()));
                    }

                }else{

                    if (this.Lminus.indexOf(texto.charAt(i))<0){
                        salida+=this.Lminus.charAt(this.Lminus.length()+((this.Lminus.indexOf(texto.charAt(i)))-despl));
                    }else{
                        salida+=this.Lminus .charAt(((this.Lminus.indexOf(texto.charAt(i)))-despl)%(this.Lminus.length()));
                    }

                }
            }else{
                salida+=texto.charAt(i);
            }
        }
        return salida;
	}

}
