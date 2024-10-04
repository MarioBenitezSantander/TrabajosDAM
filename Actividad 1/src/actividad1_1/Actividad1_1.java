package actividad1_1;

import java.io.File;
import java.io.IOException;


/**
 *
 * @author Mario
 */
public class Actividad1_1 {

    public static void main(String[] args) {
        //Creación de directorio prueba
        String rutaPrueba = "/home/mario/Documentos/prueba";
        File prueba = new File(rutaPrueba);
        if(prueba.mkdir()){
            System.out.println("Directorio prueba creado con éxito");
        }else{
            System.out.println("Error al crear el directorio");
        }
        
        //Creación de documentos de texto
        File doc1 = new File(rutaPrueba+"/doc1.txt");
        File doc2 = new File(rutaPrueba+"/doc2.txt");
        try{
            if(doc1.createNewFile()){
                System.out.println("Documento 1 creado con éxito");
            }else{
                System.out.println("Error al crear el documento 1");
            }
            if(doc2.createNewFile()){
                System.out.println("Documento 2 creado con éxito");
            }else{
                System.out.println("Error al crear el documento 2");
            }
        }catch(IOException ex){
            System.out.println("Error al crear los documentos");
        }
        
        //Creación de subcarpetas
        File subcarpetas = new File(rutaPrueba+"/subcarpeta1/subcarpeta2");
        if(subcarpetas.mkdirs()){
            System.out.println("Subcarpetas creadas con éxito");
        }else{
            System.out.println("Error al crear las subcarpetas");
        }
        
        //Creación de documento de texto en subcarpeta2
        File doc = new File(rutaPrueba+"/subcarpeta1/subcarpeta2/doc3.txt");
        try{
            if(doc.createNewFile()){
                System.out.println("Documento dentro de subcarpeta2 creado con éxito");
            }else{
                System.out.println("Error al crear el documento dentro de subcarpeta2");
            }
        }catch(IOException ex){
            System.out.println("Error al crear el documento dentro de subcarpeta2");
        }
    }

}
