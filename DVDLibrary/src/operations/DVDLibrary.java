package operations;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Suzanne Ludwig
 */
public class DVDLibrary {

    HashMap<String, DVD> library;

    
    public DVDLibrary() {
        library = new HashMap<>();
    }
    
    public DVDLibrary(HashMap<String, DVD> hm) {
        library = new HashMap<>(hm);
    }

    
    public void addDVD(String title, String releaseDate, String rating, String director, String studio, String userNote) {
        library.put(title, new DVD(title, releaseDate, rating, director, studio, userNote));
    }

    
    public boolean removeDVD(String title) {
        if (library.containsKey(title)) {
            library.remove(title);
            return true;
        } else {
            return false;
        }
    }

    
    public String getAllDVDs() {
        Set<String> keys = library.keySet();
        String allDVDs = "";
        for (String k : keys) {
            allDVDs += library.get(k).toString() + "\n";
        }
        return allDVDs;
    }
    
    public String saveAllDVDs() {
        Set<String> keys = library.keySet();
        String allDVDs = "";
        for (String k : keys) {
            allDVDs += library.get(k).saveString() + "\n";
        }
        return allDVDs;
    }
    
    
    public String searchDVDs (String title) {
        if (library.containsKey(title)) {
            return library.get(title).toString();
        }
        else return "That DVD was not found.";
    }
    
    
    public boolean editDVD (String title, String releaseDate, String rating, String director, String studio, String userNote ) {
        if (library.containsKey(title)) {
            library.get(title).setTitle(title);
            library.get(title).setReleaseDate(releaseDate);
            library.get(title).setRating(rating);
            library.get(title).setDirector(director);
            library.get(title).setStudio(studio);
            library.get(title).setUserNote(userNote);
            return true;
        } else 
            return false;
        
        //TOMAYBEDO: picker for element to set.
    }
    
}
