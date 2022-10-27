
package search;

/**
 * Class of operations on ordered lists of strings.
 * You should fill in the bodies of these methods.
 */
public class Search {
    /**
     * Returns the index of the longest string in the list.
     * If there are several string of this length, the 
     * indexed returned is the that of the first.
     * @param a list of strings, in ascending order
     * @return position of an entry with the longest string in the list
     */
    public int longestWord(StringList a) {
        // replace the following line with your implementation
        int longestWrd=0;
        int longestPos=0;
        for (int i=0;i<a.size();i++){
            String current = a.get(i);
            if (current.length() > longestWrd){
                longestWrd=current.length();
                longestPos=i;
            }else if (i==a.size()){
                return -1;
            }
        }
        return longestPos;
    }
    /**
     * Returns the number of unique elements in the list
     * @param a list of strings, in ascending order
     * @return number of unique elements in the list.
     */
    public int countUnique(StringList a) {
        // replace the following line with your implementation
        int repeat=0;
        for (int i=0;i<a.size()-1;i++){
            if (a.get(i).equals(a.get(i+1))){
                repeat++;
            }
        }
        return (a.size()-repeat);
    }
    /**
     * Search for a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return position of an element equal to k, if any, otherwise -1
     */
    public int findElement(StringList a, String k) {
        // replace the following line with your implementation
        int l=0;
        int r=a.size()-1;
        int mid=0;
        int pos=0;
        while (l<=r){
            mid=(l+r)/2;
            pos=a.get(mid).compareTo(k);
            if (pos==0){
                return mid;
            }else if (pos<0){
                l=mid+1;
            }else if (pos>0){
                r=mid-1;
            }
        }
        if (pos==0){
            return mid;
        }else {
            return -1;
        }
    }
    /**
     * Position of a string in an ordered collection
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return number of strings in the collection a greater than or equal to k
     */
    public int countGreaterOrEqual(StringList a, String k) {
        // replace the following line with your implementation
        int l=0;
        int r=a.size()-1;
        int mid=0;
        int pos=0;
        while (l<=r){
            mid=(l+r)/2;
            pos=a.get(mid).compareTo(k);
             if (pos<0){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return a.size()-l;
    }
}