package fi.team7.playformance.notes;

import java.util.List;


public class Note {

    private String achievment;
    private String fail;

    public Note(String achievment, String fail) {
        this.achievment = achievment;
        this.fail = fail;
    }

    @Override
    public String toString() {
        return "Note{" +
                "achievment='" + achievment + '\'' +
                ", fail='" + fail + '\'' +
                '}';
    }

    public String getAchievment() {
        return achievment;
    }

    public String getFail() {
        return fail;
    }
}

//public class Note {
//
//    private String description;
//    private boolean fail;
//
//    public Note(String description, boolean fail) {
//        this.description = description;
//        this.fail = fail;
//    }
//
//    @Override
//    public String toString (){
//        String temp = this.description;
//        if(this.fail == false) {
//            temp += " - fail\n";
//        }
//        else {
//            temp += "achievment\n";
//        }
//        return temp;
//    }
//}
