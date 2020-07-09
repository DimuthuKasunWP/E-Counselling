package lk.ac.cmb.ucsc.counselling.util;

import java.util.ArrayList;
import java.util.List;


public class ActiveUsers {
    private List<String> store;

    public ActiveUsers() {
        this.store = new ArrayList<>();
    }

    public List<String> getStore() {
        return store;
    }

    public void add(String username){
        store.add(username);
    }
}
