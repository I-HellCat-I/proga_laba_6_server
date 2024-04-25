package Classes;

import CommandExecution.CommandManager;
import Network.CommunicationsArray;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.lang.ref.Cleaner;
import java.net.SocketException;
import java.time.ZonedDateTime;

/**
 * Общий контекст, содержит ссылки на переменные, используемые в разных частях программы, ибо мне лень их передавать
 **/
@Getter
public class Context {

    protected final StructureStorage structureStorage = new StructureStorage(this);
    protected final FileManager fileManager = new FileManager(this);
    protected final String pathVar = "HOME";
    protected boolean exitCommandUsed = false;
    protected final ZonedDateTime initDate = ZonedDateTime.now();
    @Setter
    protected int maxRecursionDepth = 100;
    protected CommandManager commandManager = new CommandManager(this);
    public Context(){
        structureStorage.load();
        Runtime.getRuntime().addShutdownHook(new Thread(structureStorage.getOnCleanRunnable()));
        Cleaner cl = Cleaner.create();
        cl.register(structureStorage, structureStorage.getOnCleanRunnable());
    }




    public String getPath() {
        return System.getenv(pathVar) + "/saved.xml";
    }

    public void setExitCommandUsed() {
        exitCommandUsed = true;
    }
}
