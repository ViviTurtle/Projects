/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TODD
 */
public class Hw6b {
    
    int bottom = 0;
    int guessAmount = 0;
    int top;
    
    public Hw6b(int x) {
         top = x;
    }
    
    public int guess(int x) {
        guessAmount++;
        int range = top - bottom;
        if (top - x == 1 && x - bottom == 1) {
            return 0;
        }
        if (range - x > x) {
            bottom = x;
            return 1;
        }
        if (range -x < x) {
            top = x ;
            return -1;
        }
        return 0;
    }
    
    public int numberGuesses() {
        return guessAmount;
    }
}
