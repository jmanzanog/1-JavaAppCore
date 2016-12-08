package watcher;

/**
 * Created by Jmanzano on 8/12/2016.
 */

import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatcherApp {

    public void observarDemo() throws Exception {
        WatchService watcher = FileSystems.getDefault().newWatchService();

        Path dir = Paths.get("src");
        dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE,
                ENTRY_MODIFY);

        System.out.println("Iniciando observación para " + dir.getFileName());

        while (true) {
            WatchKey key;

            try {
                key = watcher.take();
            }

            catch (InterruptedException ex) {
                System.out.println("Interrupted Exception");
                return;
            }

            List<WatchEvent<?>> eventList = key.pollEvents();

            for (WatchEvent<?> event : eventList) {

                // obteniendo tipo de evento
                WatchEvent.Kind<?> kind = event.kind();

                // obteniendo el nombre del archivo
                Path fileName = (Path)event.context();

                //System.out.println(kind.name() + ": " + fileName);

                if (kind == OVERFLOW) {
                    continue;
                }else if(kind == ENTRY_DELETE){
                    if(fileName.toString().equalsIgnoreCase("mitocodeCopy.txt")){
                        System.out.println("¡[IMPORTANTE] El archivo " + fileName.toString() + " ha sido elimado!");
                    }
                }
            }

            // IMPORTANTE : La llave debe resetearse despues de un procesamiento
            boolean valid = key.reset();
            //System.out.println("Llave reseteada");
            if (!valid) {
                break;
            }
        }
        watcher.close();
        System.out.println("Fin de la observación");

    }

    public void observar() throws Exception{
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get("src");

        dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
        System.out.println("Iniciando observación para " + dir.getFileName());

        while(true){
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
                    if(fileName.toString().equalsIgnoreCase("mitocodeCopy.txt")){
                        System.out.println("[IMPORTANTE] El archivo " + fileName.toString() + " ha sido eliminado");
                    }
                }else if(tipoEvento == ENTRY_CREATE){

                }else if(tipoEvento == ENTRY_MODIFY){

                }

            }

            //IMPORTANTE
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
