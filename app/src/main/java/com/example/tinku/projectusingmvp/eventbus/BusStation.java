package com.example.tinku.projectusingmvp.eventbus;

import java.util.ArrayList;

/**
 * Created by ryellap on 2/18/18.
 */

public class BusStation {

    private ArrayList<String> names;
    private ArrayList<String> description;

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }


}
