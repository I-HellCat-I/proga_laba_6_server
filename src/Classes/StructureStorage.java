package Classes;

import lombok.Getter;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Stack;


/**
 * Класс, отвечающий за работу с коллекцией.
 * Сохраняется автоматически почти всегда (Не сохранится, если выйти через exit)
 */

public class StructureStorage implements Cleaner.Cleanable {

    // очев
    @Getter
    protected Stack<Flat> collection = new Stack<>();
    private Context context;

    public StructureStorage(Context context) {
        this.context = context;
    }

    public synchronized void sort() {
        collection.sort(null);
    }


    public void load() { // Запрашивает загрузку коллекции у файлового менеджера
        try {
            collection.addAll((Collection<? extends Flat>) context.getFileManager().loadCollection());
        } catch (NullPointerException e) {
            // ignore
        }
    }

    public boolean removeFlatById(Integer id) {
        for (Flat flat : collection) {
            if (Objects.equals(flat.getId(), id)) {
                flat.markForDeletion();
                collection.remove(flat);
                return true;
            }
        }
        return false;
    }

    public boolean removeLastFlat() {
        collection.pop();
        return true;
    }

    public boolean removeFlatAt(int pos) {
        collection.remove(pos).markForDeletion();
        return true;
    }

    public boolean addFlat(Flat f) {
        return collection.add(f);
    }

    public int getSize() {
        return collection.size();
    }

    public Flat getFlatById(int id) {
        Flat ans = null;
        for (Flat flat : collection) {
            if (Objects.equals(flat.getId(), id)) {
                ans = flat;
                break;
            }
        }
        return ans;
    }

    public void clearCollection() {
        collection.clear();
    }

    public int getNumberOfRoomsSum() {
        int cnt = 0;
        for (Flat f : collection) {
            cnt += f.getNumberOfRooms();
        }
        return cnt;
    }

    public int countLTFurnish(int amount) {
        int res = 0;
        for (Flat f : collection) {
            if (f.getFurnish().ordinal() < amount) res++;
        }
        return res;
    }

    public ArrayList<House> getUniqueHouse() {
        ArrayList<House> ans = new ArrayList<>();
        for (Flat f : collection) {
            if (!ans.contains(f.getHouse())) {
                ans.add(f.getHouse());
            }
        }
        return ans;
    }

    @Override
    public void clean() {
        if (!context.isExitCommandUsed()) {
            context.getFileManager().saveCollection();
        }
    }


    @Getter
    private final Runnable onCleanRunnable = new Runnable() {
        /**
         Прикол, благодаря которому, коллекция сохранится в случае неожиданностей (В т.ч. ctrl+c)
         */
        @Override
        public void run() {
            clean();
        }
    };


    public boolean updateFlatByRecord(SendedFlatUpdateRecord arg) {
        for (Flat flat : collection) {
            if (Objects.equals(flat.getId(), arg.id())) {
                flat.update(arg.flatUpdateRecord());
                return true;
            }
        }
        return false;
    }
}
