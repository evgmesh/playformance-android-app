package fi.team7.playformance.notes;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    public long nid;
    public String achievment;
    public String fail;
    public long playerID;

    public Note(long nid, String achievment, String fail, long playerID) {
        this.nid = nid;
        this.achievment = achievment;
        this.fail = fail;
        this.playerID = playerID;
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
