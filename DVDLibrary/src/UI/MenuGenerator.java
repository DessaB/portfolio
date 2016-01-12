

package UI;

/**
 *
 * @author Dessa Brewington
 */
public class MenuGenerator {
    static public int makeMenu(String... options) {
        for(int i = 0; i < options.length; i++)
            System.out.println((i + 1) + ". " + options[i] + "\n");
            
        return options.length;
        
    }
}
