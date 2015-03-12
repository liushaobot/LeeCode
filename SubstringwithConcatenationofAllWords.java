/*
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of 
substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). 
Reference : https://leetcode.com/discuss/20885/accepted-short-java-solution
*/
public class Solution {
    public List<Integer> findSubstring1(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        int size = L[0].length();
        if (L.length == 0 || L[0].isEmpty() || L[0].length() > S.length())
            return result;
        /*
        * 用直方图表示字符串数组，若S的子串与数组L匹配，那么两者的直方图必定相同
        * */
        Map<String, Integer> hist = new HashMap<String, Integer>();
        for (String w : L) {
            hist.put(w, !hist.containsKey(w) ? 1 : hist.get(w)+1);
        }
        for (int index = 0; index < size; ++index){
            Map<String, Integer> currHist = new HashMap<String, Integer>();
            int startIndice = index;
            for (int i = index; i+size <= S.length(); i += size) {
                if (hist.containsKey(S.substring(i, i+size))) {
                    String sub = S.substring(i, i+size);
                    currHist.put(sub, currHist.containsKey(sub) ? currHist.get(sub)+1 : 1);
                    if (currHist.get(sub) > hist.get(sub)){
                        /*
                        * 如果S子串的直方图某一项比数组L的相应项大，
                        * 就需要剔除到前面的元素直至满足条件
                        * */
                        int numOfCurr = 0;
                        for (Map.Entry entry : currHist.entrySet()){
                            numOfCurr += (Integer)entry.getValue();
                        }
                        startIndice = (i+size) - numOfCurr*size;
                        while (!S.substring(startIndice, startIndice+size).equals(sub)){
                            String word = S.substring(startIndice, startIndice+size);
                            int num = currHist.get(word);
                            if (num == 1)
                                currHist.remove(word);
                            else
                                currHist.put(word, num-1);
                            startIndice += size;
                        }
                        currHist.put(sub, currHist.get(sub)-1);
                    }

                    if (currHist.equals(hist)){
                        /*
                        * 如果子串与数组L相匹配，保存初始节点索引，
                        * 并把初始项剔除或将其数量减1
                        **/
                        int numOfCurr = 0;
                        for (Map.Entry entry : currHist.entrySet()){
                            numOfCurr += (Integer)entry.getValue();
                        }
                        startIndice = (i+size) - numOfCurr*size;
                        result.add(startIndice);
                        String word = S.substring(startIndice, startIndice+size);
                        int num = currHist.get(word);
                        if (num == 1)
                            currHist.remove(word);
                        else
                            currHist.put(word, num - 1);
                    }
                } else {
                    //出现非法元素，清空子串，重新开始
                    currHist.clear();
                }
            }
        }
        Collections.sort(result);
        return result;
    }
    
    public List<Integer> findSubstring2(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        int size = L[0].length();
        if (L.length == 0 || L[0].isEmpty() || L[0].length() > S.length())
            return result;
        /*
        * 用直方图表示字符串数组，若S的子串与数组L匹配，那么两者的直方图必定相同
        * */
        Map<String, Integer> hist = new HashMap<String, Integer>();
        for (String w : L) {
            hist.put(w, !hist.containsKey(w) ? 1 : hist.get(w)+1);
        }
        for (int index = 0; index < size; ++index){
            Map<String, Integer> currHist = new HashMap<String, Integer>();
            int startIndice = index;
            for (int i = index; i+size <= S.length(); i += size) {
                if (hist.containsKey(S.substring(i, i+size))) {
                    String sub = S.substring(i, i+size);
                    currHist.put(sub, currHist.containsKey(sub) ? currHist.get(sub)+1 : 1);
                    if (currHist.get(sub) > hist.get(sub)){
                        /*
                        * 如果S子串的直方图某一项比数组L的相应项大，
                        * 就需要剔除到前面的元素直至满足条件
                        * */
                        startIndice = Indice(currHist, size, i);
                        while (!S.substring(startIndice, startIndice+size).equals(sub)){
                            String word = S.substring(startIndice, startIndice+size);
                            int num = currHist.get(word);
                            if (num == 1)
                                currHist.remove(word);
                            else
                                currHist.put(word, num-1);
                            startIndice += size;
                        }
                        currHist.put(sub, currHist.get(sub)-1);
                    }

                    if (currHist.equals(hist)){
                        /*
                        * 如果子串与数组L相匹配，保存初始节点索引，
                        * 并把初始项剔除或将其数量减1
                        * */
                        startIndice = Indice(currHist, size, i);
                        result.add(startIndice);
                        String word = S.substring(startIndice, startIndice+size);
                        int num = currHist.get(word);
                        if (num == 1)
                            currHist.remove(word);
                        else
                            currHist.put(word, num - 1);
                    }
                } else {
                    //出现非法元素，清空子串，重新开始
                    currHist.clear();
                }
            }
        }
        Collections.sort(result);
        return result;
    }
    public int Indice(Map<String, Integer> map, int size, int end){
        int numOfCurr = 0;
        for (Map.Entry entry : map.entrySet()){
            numOfCurr += (Integer)entry.getValue();
        }
        return (end+size) - numOfCurr*size;
    }
    
    public List<Integer> findSubstring3(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        int size = L[0].length();
        if (L.length == 0 || L[0].isEmpty() || L[0].length() > S.length())
            return result;
        Map<String, Integer> hist = new HashMap<String, Integer>();
        for (String w : L) {
            hist.put(w, !hist.containsKey(w) ? 1 : hist.get(w)+1);
        }
        for (int index = 0; index < size; ++index){
            Map<String, Integer> currHist = new HashMap<String, Integer>();
            int startIndice = index;
            for (int i = index; i+size <= S.length(); i += size) {
                if (hist.containsKey(S.substring(i, i+size))) {
                    if (currHist.isEmpty())
                        startIndice = i;
                    String sub = S.substring(i, i+size);
                    currHist.put(sub, currHist.containsKey(sub) ? currHist.get(sub)+1 : 1);
                    if (currHist.get(sub) > hist.get(sub)){
                        while (!S.substring(startIndice, startIndice+size).equals(sub)){
                            String word = S.substring(startIndice, startIndice+size);
                            int num = currHist.get(word);
                            if (num == 1)
                                currHist.remove(word);
                            else
                                currHist.put(word, num-1);
                            startIndice += size;
                        }
                        currHist.put(sub, currHist.get(sub)-1);
                        startIndice += size;
                    }

                    if (currHist.equals(hist)){
                        result.add(startIndice);
                        String word = S.substring(startIndice, startIndice+size);
                        int num = currHist.get(word);
                        if (num == 1)
                            currHist.remove(word);
                        else
                            currHist.put(word, num - 1);
                        startIndice += size;
                    }
                } else {
                    currHist.clear();
                }
            }
        }
        Collections.sort(result);
        return result;
    }
    
    public List<Integer> findSubstring4(String S, String[] L) {
        List<Integer> rslt = new ArrayList<Integer>();

        // edge case
        if(L.length==0) return rslt;

        // initialize k queues and k maps
        int k = L[0].length();
        List<Queue<String>> queues = new ArrayList<Queue<String>>();
        List<Map<String, Integer>> maps = new ArrayList<Map<String, Integer>>();
        Map<String, Integer> map_temp = new HashMap<String, Integer>();
        for(int i = 0;i < L.length;i++) setMap(map_temp, L[i]);
        for(int i = 0;i < k;i++) queues.add(new LinkedList<String>());
        for(int i = 0;i < k;i++) maps.add(new HashMap<String, Integer>(map_temp));

        // go though S
        for(int i = 0;i <= S.length()-k;i++){
            Queue<String> queue = queues.get(i%k);
            Map<String, Integer> map = maps.get(i%k); 
            String s = S.substring(i,i+k);
            if(map.containsKey(s)){
                queue.add(s);
                map.put(s,map.get(s)-1);
                if(map.get(s)==0) map.remove(s);
            }else{
                if(!queue.isEmpty()){
                    if(s.equals(queue.peek())) // when the word to be poll == the word to be add
                        queue.add(queue.poll()); // don't need to modify map
                    else
                        while(!queue.isEmpty()) setMap(map, queue.poll());
                }
            }
            // find a match
            if(queue.size()==L.length){
                rslt.add(i-(L.length-1)*k);
                setMap(map,queue.poll());
            }
        }

        return rslt;
    }

    private void setMap(Map<String, Integer> map, String s){
        if(!map.containsKey(s))
            map.put(s,1);
        else
            map.put(s,map.get(s)+1);
        return;
    }
    
    public List<Integer> findSubstring5(String S, String[] L) {
        List<Integer> result = new ArrayList<>();
        int size = L[0].length();
        if (L.length == 0 || L[0].isEmpty() || L[0].length() > S.length()) 
            return result;
        Map<String, Integer> hist = new HashMap<>();
        for (String w : L) {
            hist.put(w, !hist.containsKey(w) ? 1 : hist.get(w)+1);
        }
        for (int i = 0; i+size*L.length <= S.length(); i++) {
            if (hist.containsKey(S.substring(i, i+size))) {
                Map<String, Integer> currHist = new HashMap<>();
                for (int j = 0; j < L.length; j++) {
                    String word = S.substring(i+j*size, i+(j+1)*size);
                    if (hist.containsKey(word)){
                        currHist.put(word, !currHist.containsKey(word) ? 
                            1 : currHist.get(word)+1);
                        if (hist.get(word) < currHist.get(word))
                            break;
                    } else
                        break;
                }
                if (currHist.equals(hist)) result.add(i);
            }
        }
        return result;
    }
}
