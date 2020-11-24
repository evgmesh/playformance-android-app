package fi.team7.playformance;

import java.util.List;

public class Note {

    private String description;
    private boolean fail;

    public Note(String description, boolean fail) {
        this.description = description;
        this.fail = fail;
    }
    @Override
    public String toString (){
        String temp = this.description;
        if(this.fail == false) {
            temp += "fail\n";
        }
        else {
            temp += "achievment\n";
        }
        return temp;
    }
}
