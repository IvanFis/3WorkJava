package Seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class History {

        private List<String> actions;

        public History(){
            actions = new ArrayList<>();
        }
        public void addActions(String action){
            actions.add(action);
        }
        public List<String> getActions(){
            return Collections.unmodifiableList(actions);
        }
    }

