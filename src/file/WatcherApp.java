package file;

/**
 * Created by Jmanzano on 8/12/2016.
 */

import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatcherApp {


    public void observar() throws Exception{
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get("resources");

        dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
        System.out.println("Iniciando observación para " + dir.getFileName());


        for(;;){
            WatchKey key;
            key = watcher.take();

            List<WatchEvent<?>> listaEventos = key.pollEvents();

            for(WatchEvent<?> evento : listaEventos){
                //Obteniendo tipo de evento
                Kind<?> tipoEvento = evento.kind();

                //Obteniendo nombre archivo
                Path fileName = (Path)evento.context();

                //System.out.println(tipoEvento.name() + ": " + fileName);

                if(tipoEvento == OVERFLOW){
                    continue;
                }else if(tipoEvento == ENTRY_DELETE){
                        System.out.println("[IMPORTANTE] El archivo " + fileName.toString() + " ha sido eliminado");
                }else if(tipoEvento == ENTRY_CREATE){
                        System.out.println("[IMPORTANTE] El archivo " + fileName.toString() + " ha sido creado");
                }else if(tipoEvento == ENTRY_MODIFY){
                        System.out.println("[IMPORTANTE] El archivo " + fileName.toString() + " ha sido modificado");

                }

            }

            //IMPORTANTE se debe reiniciar el key si no es valido
            boolean valid = key.reset();
            if(!valid){
                break;
            }
        }

        watcher.close();

    }

    public static void main(String[] args) throws Exception {
        WatcherApp app = new WatcherApp();
        app.observar();
    }

}
