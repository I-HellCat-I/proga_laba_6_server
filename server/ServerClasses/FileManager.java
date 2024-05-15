package ServerClasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
/**
 * Класс, который отвечает за загрузку и сохранение Коллекции.
 */
public class FileManager {
    private final XmlMapper mapper;
    private Context context;
    FileManager(Context context){
        mapper = XmlMapper.builder().findAndAddModules().build();
        this.context = context;
    }



    /**
     * Сохраняет коллекцию, создавая файл если его нет.
     */
    public boolean saveCollection() {
        String toWrite;
        try {
            new File(context.getPath()).createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        try {
            toWrite = mapper.writeValueAsString(context.getStructureStorage().getCollection());
        } catch (JsonProcessingException e) {
            return false;
        }
        try (PrintWriter pw = new PrintWriter(context.getPath())) {
            pw.write(toWrite);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return false;
        }
    }

    /**
     * Загружает коллекцию из файла. В случе nullpointer'а в пути - вернёт пустой Стек.
     */
    public Stack<Flat> loadCollection() {
        try {
            Stack<Flat> loaded = null;
            mapper.registerModule(new JavaTimeModule());
            try {
                loaded = mapper.readValue(new File(context.getPath()), new TypeReference<Stack<Flat>>() {
                });
                for (Flat f : loaded) {
                    f.addLoadedId();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            Flat.finishLoadingIds();
            return loaded;
        } catch (NullPointerException e) {
            return new Stack<>();

        }
    }
}
